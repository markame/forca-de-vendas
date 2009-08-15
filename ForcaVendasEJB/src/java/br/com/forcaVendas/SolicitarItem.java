package br.com.forcaVendas;

import br.com.forcaVendas.dto.EmpresaDTO;
import br.com.forcaVendas.dto.ItemDTO;
import br.com.forcaVendas.dto.Solicitacao;
import br.com.forcaVendas.dto.interfaces.IEmpresa;
import br.com.forcaVendas.dto.interfaces.IItem;
import br.com.forcaVendas.empresa.remote.EmpresaException;
import br.com.forcaVendas.empresa.remote.IEmpresaMgtRemote;
import br.com.forcaVendas.fornecedor.remote.IFornecedorMgt;
import java.util.List;
import javax.ejb.EJB;

/**
 * Classe adicionada para separar a solicitação das demais funções,
 * seguindo a arquitetura que foi definida
 *
 * OBS: esta classe não precisa ser disponibilizada externamente
 *
 * @author Henrique
 */
public class SolicitarItem {

    @EJB
    public IFornecedorMgt fornecedorMgtRemote = null;

    @EJB
    public IEmpresaMgtRemote empresaMgtRemote = null;


    public List<Solicitacao> solicitarItem(List<ItemDTO> itens, IEmpresa empresa) throws EmpresaException{
        //validar cada item de acordo as necessidades do fornecedor
        for(IItem item: itens){
            //TODO criar exceção para estes casos
            if(item == null)
                throw new EmpresaException(this.getClass().getName() +": Item nulo");
            
            if(item.getCodigo() == null)
                throw new EmpresaException(this.getClass().getName() +": Item com código inválido");

            if(item.getEstoqueMinimo() == null || item.getEstoqueMinimo() <= 0)
                throw new EmpresaException(this.getClass().getName() +": Item com estoque mínimo inválido");

        }

        List<Solicitacao> solicitacoes = null;
        solicitacoes = fornecedorMgtRemote.solicitarItem(itens, EmpresaDTO.copy(empresa));


        //atualizar com estoques com as quantidades pedidas
        int codigo;
        float quantidade;

        EmpresaException exception = null;
        for(Solicitacao solic : solicitacoes){
            try{
                codigo = solic.getIdItem();
                quantidade = solic.getQuantidade();

                empresaMgtRemote.incrementarEstoqueItem(codigo, quantidade);
            }catch(EmpresaException eex){
                exception = eex;
                eex.printStackTrace();
            }
        }

        if(exception != null)
                throw exception;

        return solicitacoes;
    }

}

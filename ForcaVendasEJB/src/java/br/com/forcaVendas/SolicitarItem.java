package br.com.forcaVendas;

import br.com.forcaVendas.dto.EmpresaDTO;
import br.com.forcaVendas.dto.Solicitacao;
import br.com.forcaVendas.dto.interfaces.IEmpresa;
import br.com.forcaVendas.dto.interfaces.IItem;
import br.com.forcaVendas.empresa.remote.EmpresaException;
import br.com.forcaVendas.empresa.remote.IEmpresaMgtRemote;
import br.com.forcaVendas.fornecedor.remote.IFornecedorMgt;
import java.util.ArrayList;
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


    public List<Solicitacao> solicitarItem(List<IItem> itens, IEmpresa empresa) throws EmpresaException{
        List<Integer> codigoItens = new ArrayList();
        for(IItem item: itens){
            //TODO validar cada item de acordo as necessidades do fornecedor

            //TODO criar exceção para estes casos
            if(item == null)
                throw new EmpresaException(this.getClass().getName() +": Item nulo");
            
            if(item.getCodigo() == null)
                throw new EmpresaException(this.getClass().getName() +": Item com código inválido");

            if(item.getEstoqueMinimo() == null || item.getEstoqueMinimo() <= 0)
                throw new EmpresaException(this.getClass().getName() +": Item com estoque mínimo inválido");

            codigoItens.add(item.getCodigo());
        }

        List<Solicitacao> solicitacoes = null;
        solicitacoes = fornecedorMgtRemote.solicitarItem(codigoItens, EmpresaDTO.copy(empresa));


        //TODO atualizar com estoques com as quantidades pedidas
        int codigo;
        float quantidade;

        for(Solicitacao solic : solicitacoes){
            codigo = solic.getIdItem();
            quantidade = 1; //TODO

            empresaMgtRemote.incrementarEstoqueItem(codigo, quantidade);
        }


        return solicitacoes;
    }

}

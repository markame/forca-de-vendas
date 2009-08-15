/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fornecedor;

import br.com.forcaVendas.dto.EmpresaDTO;
import br.com.forcaVendas.dto.Fornecedor;
import br.com.forcaVendas.dto.ItemDTO;
import br.com.forcaVendas.dto.Solicitacao;
import br.com.forcaVendas.fornecedor.remote.IFornecedorMgt;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Nelson Alves
 */
@Stateless
@Remote
public class FornecedorMgt implements IFornecedorMgt {

     /**
     * @see IFornecedorMgt
     */

    private FornecedorDAO fornecedorDao;
    private SolicitacaoDAO solicitacaoDao;

    public FornecedorMgt(){
       fornecedorDao=new FornecedorDAO();
       solicitacaoDao=new SolicitacaoDAO();
    }

    public void deleteFornecedor(Integer id) {

        
        fornecedorDao.deleteFornecedor(id);
    }

    public Fornecedor getFornecedor(Integer id) {
        
        return fornecedorDao.getFornecedor(id);
    }

    public List<Solicitacao> solicitarItem(List<ItemDTO> itens, EmpresaDTO empresa) {
        LinkedList<Solicitacao> solicitacoes=new LinkedList<Solicitacao>();
        for(ItemDTO item:itens){
            Solicitacao solicitacao = new Solicitacao();
            solicitacao.setIdEmpresa(empresa.getId());
            Fornecedor fornecedor=this.getFornecedorByItem(item);
            if(fornecedor!=null){

                float quantidadeSolicitada = item.getEstoqueMinimo();

                if(item.getEstoque() < 0){
                    float quantidadeFaltante = - item.getEstoque();
                    quantidadeSolicitada = quantidadeSolicitada + quantidadeFaltante;
                }
                solicitacao.setIdFornecedor(fornecedor.getId());
                solicitacao.setQuantidade(quantidadeSolicitada);
                solicitacao.setItem(item.getCodigo());
                solicitacaoDao.createSolicitacao(solicitacao);
                solicitacoes.add(solicitacao);
            }
            else
                System.out.println("fornecedor nao encontrado");
        }
        

        //persiste a solicitação
        
        

        return solicitacoes;
    }

    public void createFornecedor(Fornecedor fornecedor) {
        
        fornecedorDao.createFornecedor(fornecedor);
    }

    public void updateFornecedor(Fornecedor fornecedor) {
        
        fornecedorDao.updateFornecedor(fornecedor);
    }

    public Fornecedor getFornecedorByItemId(Integer itemId) {
        List<Fornecedor> fornecedores= fornecedorDao.getFornecedores();
        for(Fornecedor temp:fornecedores){
            if(temp.isItemFornecedor(itemId))
                return temp;
        }
        return null;
    }

    public Fornecedor getFornecedorByItem(ItemDTO item) {
         List<Fornecedor> fornecedores= fornecedorDao.getFornecedores();
        for(Fornecedor temp:fornecedores){
            if(temp.isItemFornecedor(item))
                return temp;
        }
        return null;
    }
 
}

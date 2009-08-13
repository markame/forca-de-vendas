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

    public Solicitacao solicitarItem(List<Integer> itens, EmpresaDTO empresa, Fornecedor fornecedor) {
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setIdEmpresa(empresa.getId());
        solicitacao.setIdFornecedor(fornecedor.getId());

        //persiste a solicitação
        
        solicitacaoDao.createSolicitacao(solicitacao);

        return solicitacao;
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

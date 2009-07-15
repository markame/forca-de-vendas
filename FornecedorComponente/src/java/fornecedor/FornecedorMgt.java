/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fornecedor;

import br.com.forcaVendas.dto.EmpresaDTO;
import br.com.forcaVendas.dto.Fornecedor;
import br.com.forcaVendas.dto.Solicitacao;
import fornecedor.interfaces.remote.IFornecedorMgt;
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
    public void deleteFornecedor(Integer id) {

        FornecedorDAO instance = new FornecedorDAO();
        instance.deleteFornecedor(id);
    }

    public Fornecedor getFornecedor(Integer id) {
        FornecedorDAO instance = new FornecedorDAO();
        return instance.getFornecedor(id);
    }

    public Solicitacao solicitarItem(List<Integer> itens, EmpresaDTO empresa, Fornecedor fornecedor) {
        Solicitacao solicitacao = new Solicitacao();
        solicitacao.setIdEmpresa(empresa.getId());
        solicitacao.setIdFornecedor(fornecedor.getId());

        return solicitacao;
    }

    public void createFornecedor(Fornecedor fornecedor) {
        FornecedorDAO instance = new FornecedorDAO();
        instance.createFornecedor(fornecedor);
    }

    public void updateFornecedor(Fornecedor fornecedor) {
        FornecedorDAO instance = new FornecedorDAO();
        instance.updateFornecedor(fornecedor);
    }
 
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fatura.session;

import br.com.forcaVendas.empresa.entidade.Item;
import fatura.entidades.Fatura;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Thiago
 */
@Stateless
public class FaturaBean implements FaturaRemote {

    public void criarFatura(List<Item> itens) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void buscarCliente(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void editarCliente(Fatura fatura) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void deletarCliente(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
 
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fatura.session;

import br.com.forcaVendas.empresa.entidade.Item;
import fatura.entidades.Fatura;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Thiago
 */
@Remote
public interface FaturaRemote {

    public void criarFatura(List<Item> itens, Integer quantidade);

    public void buscarCliente(Integer id);

    public void editarCliente(Fatura fatura);

    public void deletarCliente(Integer id);
    
}

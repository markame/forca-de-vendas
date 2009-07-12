/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cliente.session;

import cliente.entidades.Cliente;
import javax.ejb.Remote;

/**
 *
 * @author André
 */
@Remote
public interface ClienteRemote {

    public void criarCliente(String nome, String endereco, String cpf, String telefone);

    public void buscarCliente(String cpf);

    public void editarCliente(Cliente cliente);

    public void deletarCliente(String cpf);
}

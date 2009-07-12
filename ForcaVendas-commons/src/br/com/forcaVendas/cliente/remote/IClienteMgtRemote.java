/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.cliente.remote;

import br.com.forcaVendas.dto.ClienteDTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author André
 */
@Remote
public interface IClienteMgtRemote {

    public boolean criarCliente(String nome, String endereco, String cpf, String telefone);

    public ClienteDTO buscarCliente(String cpf);

    public List<ClienteDTO> getClientes();

    public boolean editarCliente(ClienteDTO cliente);

    public boolean deletarCliente(String cpf);
}

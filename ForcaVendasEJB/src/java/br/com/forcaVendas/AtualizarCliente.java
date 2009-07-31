/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas;

import br.com.forcaVendas.cliente.remote.ClienteException;
import br.com.forcaVendas.cliente.remote.IClienteMgtRemote;
import br.com.forcaVendas.dto.ClienteDTO;
import br.com.forcaVendas.dto.FaturaDTO;
import br.com.forcaVendas.dto.PedidoDTO;
import br.com.forcaVendas.remote.IAtualizarClienteRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author André
 */
@Stateless
public class AtualizarCliente implements IAtualizarClienteRemote{

    @EJB
    public IClienteMgtRemote clienteMgtRemote = null;

    //IAtualizarCliente
    public boolean criarCliente(String nome, String endereco, String cpf, String telefone) throws ClienteException {
        return clienteMgtRemote.criarCliente(nome, endereco, cpf, telefone);
    }

    public ClienteDTO buscarCliente(String cpf) throws ClienteException {
        return clienteMgtRemote.buscarCliente(cpf);
    }

    public List<ClienteDTO> getClientes() throws ClienteException {
        return clienteMgtRemote.getClientes();
    }

    public boolean deletarCliente(String cpf) throws ClienteException {
        return clienteMgtRemote.deletarCliente(cpf);
    }

    public boolean editarCliente(ClienteDTO cliente) throws ClienteException {
        return clienteMgtRemote.editarCliente(cliente);
    }

    public boolean criarFatura(List<PedidoDTO> pedidos, ClienteDTO cliente) throws ClienteException {
        return clienteMgtRemote.criarFatura(pedidos, cliente);
    }

    public FaturaDTO buscarFatura(Integer id) throws ClienteException {
        return clienteMgtRemote.buscarFatura(id);
    }
    //Fim de IAtualizarCliente

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.remote;

import br.com.forcaVendas.cliente.remote.ClienteException;
import br.com.forcaVendas.dto.ClienteDTO;
import br.com.forcaVendas.dto.LinkFaturaPedidoDTO;
import br.com.forcaVendas.dto.PedidoDTO;
import java.util.List;

/**
 *
 * @author André
 */
public interface IAtualizarClienteRemote {

    public boolean criarCliente(String nome, String endereco, String cpf, String telefone) throws ClienteException;

    public ClienteDTO buscarCliente(String cpf)  throws ClienteException;

    public List<ClienteDTO> getClientes()  throws ClienteException;

    public boolean editarCliente(ClienteDTO cliente)  throws ClienteException;

    public boolean deletarCliente(String cpf)  throws ClienteException;

    public boolean  criarFatura(List<PedidoDTO> pedidos, String cpfCliente)  throws ClienteException;

    public List<LinkFaturaPedidoDTO> buscarFatura(String cpfCliente, int mes)  throws ClienteException;

}

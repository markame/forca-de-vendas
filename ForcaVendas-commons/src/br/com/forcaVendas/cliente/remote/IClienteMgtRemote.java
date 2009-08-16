/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.cliente.remote;

import br.com.forcaVendas.dto.ClienteDTO;
import br.com.forcaVendas.dto.LinkFaturaPedidoDTO;
import br.com.forcaVendas.dto.PedidoDTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author André
 */
@Remote
public interface IClienteMgtRemote {

    public boolean criarCliente(String nome, String endereco, String cpf, String telefone) throws ClienteException;

    public ClienteDTO buscarCliente(String cpf)  throws ClienteException;

    public List<ClienteDTO> getClientes()  throws ClienteException;

    public boolean editarCliente(ClienteDTO cliente)  throws ClienteException;

    public boolean deletarCliente(String cpf)  throws ClienteException;

    public boolean  criarFatura(List<PedidoDTO> pedidos, String cpfCliente)  throws ClienteException;

    /**
     * 
     * @param cpfCliente
     * @param mes
     * @return uma lista de String em que cada posição do Vector tem o código do pedido
     * @throws ClienteException
     */
    public List<String> buscarFatura(String cpfCliente, int mes)  throws ClienteException;
}

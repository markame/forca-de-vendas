/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.remote;

import br.com.forcaVendas.cliente.remote.ClienteException;
import br.com.forcaVendas.dto.ClienteDTO;
import br.com.forcaVendas.dto.PedidoDTO;
import br.com.forcaVendas.dto.PedidoItemDTO;
import br.com.forcaVendas.dto.VendedorDTO;
import br.com.forcaVendas.empresa.remote.EmpresaException;
import java.util.List;

/**
 *
 * @author Henrique
 */
public interface IFazerPedidoRemote {

    public ClienteDTO getCliente(String cpf) throws ClienteException;

    public VendedorDTO getVendedor(int id) throws EmpresaException;

    public List<PedidoItemDTO> addItem(List<PedidoItemDTO> pedidoItens, int itemId, float quantidade) throws EmpresaException;

    public PedidoDTO fazerPedido(ClienteDTO cliente, VendedorDTO vendedor, List<PedidoItemDTO> pedidoItens) throws EmpresaException;

}

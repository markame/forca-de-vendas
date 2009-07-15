/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.cliente.remote;

import br.com.forcaVendas.dto.ClienteDTO;
import br.com.forcaVendas.dto.FaturaDTO;
import br.com.forcaVendas.dto.ItemDTO;
import br.com.forcaVendas.dto.PedidoDTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Thiago
 */
@Deprecated
@Remote
public interface IFaturaMgtRemote {

    public boolean  criarFatura(List<PedidoDTO> pedidos, ClienteDTO cliente);

    public FaturaDTO buscarFatura(Integer id);

}

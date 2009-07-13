/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.cliente.remote;

import br.com.forcaVendas.dto.FaturaDTO;
import br.com.forcaVendas.dto.ItemDTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Thiago
 */
@Remote
public interface IFaturaMgtRemote {

    public boolean  criarFatura(List<ItemDTO> itens, Integer quantidade);

    public FaturaDTO buscarFatura(Integer id);

    public boolean  editarFatatura(FaturaDTO fatura);

    public boolean  deletarFatura(Integer id);

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.remote;

import br.com.forcaVendas.dto.ItemDTO;
import br.com.forcaVendas.empresa.remote.EmpresaException;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Henrique
 */
@Remote
public interface IAtualizarItemRemote {

    public ItemDTO createItem(String nome, float preco) throws EmpresaException;

    public ItemDTO getItem(int codigo) throws EmpresaException;

    public List<ItemDTO> getItens() throws EmpresaException;

    public boolean updateItem(ItemDTO itemDTO) throws EmpresaException;

    public boolean deleteItem(int codigo) throws EmpresaException;


}

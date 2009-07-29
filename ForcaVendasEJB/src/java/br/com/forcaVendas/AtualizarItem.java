/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas;

import br.com.forcaVendas.dto.ItemDTO;
import br.com.forcaVendas.empresa.remote.EmpresaException;
import br.com.forcaVendas.empresa.remote.IEmpresaMgtRemote;
import br.com.forcaVendas.remote.IAtualizarItemRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Henrique
 */
@Stateless
public class AtualizarItem implements IAtualizarItemRemote{

    @EJB
    public IEmpresaMgtRemote empresaMgtRemote = null;

    public AtualizarItem() {
    }

    public ItemDTO createItem(String nome, float preco) throws EmpresaException {
        return empresaMgtRemote.createItem(nome, preco);
    }

    public ItemDTO getItem(int codigo) throws EmpresaException {
        return empresaMgtRemote.getItem(codigo);
    }

    public List<ItemDTO> getItens() throws EmpresaException {
        return empresaMgtRemote.getItens();
    }

    public boolean updateItem(ItemDTO itemDTO) throws EmpresaException {
        return empresaMgtRemote.updateItem(itemDTO);
    }

    public boolean deleteItem(int codigo) throws EmpresaException {
        return empresaMgtRemote.deleteItem(codigo);
    }

}

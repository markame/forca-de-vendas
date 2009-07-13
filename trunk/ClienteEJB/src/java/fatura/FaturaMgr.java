/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fatura;

import br.com.forcaVendas.cliente.remote.IFaturaMgtRemote;
import br.com.forcaVendas.dto.FaturaDTO;
import br.com.forcaVendas.dto.ItemDTO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Thiago
 */
import javax.persistence.PersistenceContext;
public class FaturaMgr implements IFaturaMgtRemote {

    @PersistenceContext
    private EntityManager em;

    public boolean criarFatura(List<ItemDTO> itens, Integer quantidade) {
        try{
            for (int i = 0; i < itens.size(); i++) {
                String idCodString = itens.get(i).getCodigo().toString();
                Integer idCod = new Integer(idCodString);
                FaturaDTO fatura = new FaturaDTO(idCod, quantidade);
                em.persist(fatura);
                //em.flush();
            }

        }
        catch(Exception e){
            System.err.println(e);
            return false;
        }
        return true;
    }

    public FaturaDTO buscarFatura(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean editarFatatura(FaturaDTO fatura) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean deletarFatura(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}

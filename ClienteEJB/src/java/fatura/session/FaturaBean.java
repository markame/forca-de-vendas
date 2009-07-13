/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fatura.session;

import br.com.forcaVendas.empresa.entidade.Item;
import fatura.entidades.Fatura;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Thiago
 */
@Stateless
public class FaturaBean implements FaturaRemote {

    @PersistenceContext
    private EntityManager em;

    public void criarFatura(List<Item> itens, Integer quantidade) {
        try{
            for (int i = 0; i < itens.size(); i++) {
                String idCodString = itens.get(i).getCodigo().toString();
                Integer idCod = new Integer(idCodString);
                Fatura fatura = new Fatura(idCod, quantidade);
                em.persist(fatura);
                em.flush();
            }
            
        }
        catch(Exception e){
            
        }
    }

    public void buscarCliente(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void editarCliente(Fatura fatura) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void deletarCliente(Integer id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
 
}

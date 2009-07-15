package br.com.forcaVendas.empresa.persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrique
 */

public class JpaController{

    @PersistenceContext
    private EntityManager em;

    public JpaController() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmpresaEJBPU");
        em = emf.createEntityManager();
        em.setFlushMode(FlushModeType.AUTO);
    }

    public void insert(Object object) {
        em.getTransaction().begin();
        em.persist(object);
        em.flush();
        em.getTransaction().commit();
        
        JOptionPane.showMessageDialog(null, object + " salvo com sucesso.");
    }

    public Object find(Class c, Object id) {
        Object found = em.find(c, id);
        return found;
    }

    public void update(Object object) {
        em.getTransaction().begin();
        em.merge(object);
        em.flush();
        em.getTransaction().commit();
    }

    public void delete(Object id) {
        em.getTransaction().begin();
        em.remove(id);
        em.flush();
        em.getTransaction().commit();
    }

    public List findEntities(String table) {
        return findEntities(table, true, -1, -1);
    }

    public List findEntities(String table, int maxResults, int firstResult) {
        return findEntities(table, false, maxResults, firstResult);
    }

    private List findEntities(String table, boolean all, int maxResults, int firstResult) {
        System.out.println("Select in Table " + table);
        Query q = em.createQuery("select object(o) from " + table + " as o");
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

}

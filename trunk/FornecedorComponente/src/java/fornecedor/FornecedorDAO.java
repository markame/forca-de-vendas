/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fornecedor;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import br.com.forcaVendas.dto.Fornecedor;

public class FornecedorDAO {
    
    private EntityManagerFactory emf = null;

    public FornecedorDAO(){
        emf = Persistence.createEntityManagerFactory("simple-jpaPU");
    }

    public EntityManager getEntityManager() {
       
        return emf.createEntityManager();
    }

    public void createFornecedor(Fornecedor fornecedor) {
        EntityManager em = getEntityManager();
         em.getTransaction().begin();
         try {
         em.persist(fornecedor);
         em.getTransaction().commit();
         } catch (Exception e) {
         e.printStackTrace();
         em.getTransaction().rollback();
         } finally {
         em.close();
         }
    }

    public void updateFornecedor(Fornecedor fornecedor) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(fornecedor);
        em.getTransaction().commit();
    }

    public void deleteFornecedor(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Fornecedor fornecedor=getFornecedor(id);
        em.remove(em.merge(fornecedor));
        em.getTransaction().commit();
    }

    public List<Fornecedor> getFornecedores() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Fornecedor as o");
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Fornecedor getFornecedor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Fornecedor.class, id);
        } finally {
            em.close();
        }
    }

    public Fornecedor retrieveByName(String name) {
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("Fornecedor.findByName");

        q.setParameter("name", name);

        return (Fornecedor)q.getSingleResult();
    }

}

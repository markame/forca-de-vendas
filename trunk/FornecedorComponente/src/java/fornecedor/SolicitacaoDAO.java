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
import br.com.forcaVendas.dto.Solicitacao;


/**
 *
 * @author Nelson Alves
 */
public class SolicitacaoDAO {

    private EntityManagerFactory emf = null;

    public SolicitacaoDAO(){
        emf = Persistence.createEntityManagerFactory("simple-jpaPU");
    }

    public EntityManager getEntityManager() {

        return emf.createEntityManager();
    }

    public void createSolicitacao(Solicitacao solicitacao) {
        EntityManager em = getEntityManager();
         em.getTransaction().begin();
         try {
         em.persist(solicitacao);
         em.getTransaction().commit();
         } catch (Exception e) {
         e.printStackTrace();
         em.getTransaction().rollback();
         } finally {
         em.close();
         }
    }

    public void updateSolicitacao(Solicitacao solicitacao) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(solicitacao);
        em.getTransaction().commit();
    }

    public void deleteSolicitacao(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Solicitacao solicitacao= getSolicitacao(id);
        em.remove(em.merge(solicitacao));
        em.getTransaction().commit();
    }

    public List<Solicitacao> getSolicitacao() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Fornecedor as o");
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Solicitacao getSolicitacao(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Solicitacao.class, id);
        } finally {
            em.close();
        }
    }

    public Solicitacao retrieveByName(String name) {
        EntityManager em = getEntityManager();
        Query q = em.createNamedQuery("Fornecedor.findByName");

        q.setParameter("name", name);

        return (Solicitacao)q.getSingleResult();
    }

}

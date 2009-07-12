/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.empresa.persistencia;

import br.com.forcaVendas.empresa.entidade.NotaFiscal;
import br.com.forcaVendas.empresa.persistencia.exceptions.NonexistentEntityException;
import br.com.forcaVendas.empresa.persistencia.exceptions.RollbackFailureException;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.transaction.UserTransaction;

/**
 *
 * @author Henrique
 */
public class NotaFiscalJpaController {
    @Resource
    private UserTransaction utx = null;
    @PersistenceUnit(unitName = "EJBEmpresaPU")
    private EntityManagerFactory emf = null;

    private EntityManagerFactory getEmf() {
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("EJBEmpresaPU");
        }
        return emf;
    }

    public EntityManager getEntityManager() {
        return getEmf().createEntityManager();
    }

    public void create(NotaFiscal notaFiscal) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(notaFiscal);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(NotaFiscal notaFiscal) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            notaFiscal = em.merge(notaFiscal);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = notaFiscal.getCodigo();
                if (findNotaFiscal(id) == null) {
                    throw new NonexistentEntityException("The notaFiscal with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            NotaFiscal notaFiscal;
            try {
                notaFiscal = em.getReference(NotaFiscal.class, id);
                notaFiscal.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The notaFiscal with id " + id + " no longer exists.", enfe);
            }
            em.remove(notaFiscal);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<NotaFiscal> findNotaFiscalEntities() {
        return findNotaFiscalEntities(true, -1, -1);
    }

    public List<NotaFiscal> findNotaFiscalEntities(int maxResults, int firstResult) {
        return findNotaFiscalEntities(false, maxResults, firstResult);
    }

    private List<NotaFiscal> findNotaFiscalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from NotaFiscal as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public NotaFiscal findNotaFiscal(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(NotaFiscal.class, id);
        } finally {
            em.close();
        }
    }

    public int getNotaFiscalCount() {
        EntityManager em = getEntityManager();
        try {
            return ((Long) em.createQuery("select count(o) from NotaFiscal as o").getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}

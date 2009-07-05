/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.forcaVendas.empresa.persistencia;

import br.com.forcaVendas.empresa.entidade.PedidoItem;
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
public class PedidoItemJpaController {
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

    public void create(PedidoItem pedidoItem) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(pedidoItem);
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

    public void edit(PedidoItem pedidoItem) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            pedidoItem = em.merge(pedidoItem);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = pedidoItem.getCodigo();
                if (findPedidoItem(id) == null) {
                    throw new NonexistentEntityException("The pedidoItem with id " + id + " no longer exists.");
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
            PedidoItem pedidoItem;
            try {
                pedidoItem = em.getReference(PedidoItem.class, id);
                pedidoItem.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pedidoItem with id " + id + " no longer exists.", enfe);
            }
            em.remove(pedidoItem);
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

    public List<PedidoItem> findPedidoItemEntities() {
        return findPedidoItemEntities(true, -1, -1);
    }

    public List<PedidoItem> findPedidoItemEntities(int maxResults, int firstResult) {
        return findPedidoItemEntities(false, maxResults, firstResult);
    }

    private List<PedidoItem> findPedidoItemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from PedidoItem as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public PedidoItem findPedidoItem(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PedidoItem.class, id);
        } finally {
            em.close();
        }
    }

    public int getPedidoItemCount() {
        EntityManager em = getEntityManager();
        try {
            return ((Long) em.createQuery("select count(o) from PedidoItem as o").getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}

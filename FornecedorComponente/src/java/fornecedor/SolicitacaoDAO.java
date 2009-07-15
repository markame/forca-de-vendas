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
        /*EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Customer persistentCustomer = em.find(Customer.class, customer.getCustomerId());
            DiscountCode discountCodeOld = persistentCustomer.getDiscountCode();
            DiscountCode discountCodeNew = customer.getDiscountCode();
            Collection<PurchaseOrder> purchaseOrderCollectionOld = persistentCustomer.getPurchaseOrderCollection();
            Collection<PurchaseOrder> purchaseOrderCollectionNew = customer.getPurchaseOrderCollection();
            List<String> illegalOrphanMessages = null;
            for (PurchaseOrder purchaseOrderCollectionOldPurchaseOrder : purchaseOrderCollectionOld) {
                if (!purchaseOrderCollectionNew.contains(purchaseOrderCollectionOldPurchaseOrder)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain PurchaseOrder " + purchaseOrderCollectionOldPurchaseOrder + " since its customerId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (discountCodeNew != null) {
                discountCodeNew = em.getReference(discountCodeNew.getClass(), discountCodeNew.getDiscountCode());
                customer.setDiscountCode(discountCodeNew);
            }
            List<PurchaseOrder> attachedPurchaseOrderCollectionNew = new ArrayList<PurchaseOrder>();
            for (PurchaseOrder purchaseOrderCollectionNewPurchaseOrderToAttach : purchaseOrderCollectionNew) {
                purchaseOrderCollectionNewPurchaseOrderToAttach = em.getReference(purchaseOrderCollectionNewPurchaseOrderToAttach.getClass(), purchaseOrderCollectionNewPurchaseOrderToAttach.getOrderNum());
                attachedPurchaseOrderCollectionNew.add(purchaseOrderCollectionNewPurchaseOrderToAttach);
            }
            purchaseOrderCollectionNew = attachedPurchaseOrderCollectionNew;
            customer.setPurchaseOrderCollection(purchaseOrderCollectionNew);
            customer = em.merge(customer);
            if (discountCodeOld != null && !discountCodeOld.equals(discountCodeNew)) {
                discountCodeOld.getCustomerCollection().remove(customer);
                discountCodeOld = em.merge(discountCodeOld);
            }
            if (discountCodeNew != null && !discountCodeNew.equals(discountCodeOld)) {
                discountCodeNew.getCustomerCollection().add(customer);
                discountCodeNew = em.merge(discountCodeNew);
            }
            for (PurchaseOrder purchaseOrderCollectionNewPurchaseOrder : purchaseOrderCollectionNew) {
                if (!purchaseOrderCollectionOld.contains(purchaseOrderCollectionNewPurchaseOrder)) {
                    Customer oldCustomerIdOfPurchaseOrderCollectionNewPurchaseOrder = purchaseOrderCollectionNewPurchaseOrder.getCustomerId();
                    purchaseOrderCollectionNewPurchaseOrder.setCustomerId(customer);
                    purchaseOrderCollectionNewPurchaseOrder = em.merge(purchaseOrderCollectionNewPurchaseOrder);
                    if (oldCustomerIdOfPurchaseOrderCollectionNewPurchaseOrder != null && !oldCustomerIdOfPurchaseOrderCollectionNewPurchaseOrder.equals(customer)) {
                        oldCustomerIdOfPurchaseOrderCollectionNewPurchaseOrder.getPurchaseOrderCollection().remove(purchaseOrderCollectionNewPurchaseOrder);
                        oldCustomerIdOfPurchaseOrderCollectionNewPurchaseOrder = em.merge(oldCustomerIdOfPurchaseOrderCollectionNewPurchaseOrder);
                    }
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = customer.getCustomerId();
                if (findCustomer(id) == null) {
                    throw new NonexistentEntityException("The customer with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }*/
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

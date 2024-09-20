package com.mycompany.gestion_alumnos.PERSISTENCIA;

import com.mycompany.gestion_alumnos.LOGICA.PagoColegiatura;
import com.mycompany.gestion_alumnos.PERSISTENCIA.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * Created by Frame-Code, September 2024
 */
public class PagoColegiaturaJpaController implements Serializable {

    public PagoColegiaturaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PagoColegiatura pagoColegiatura) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pagoColegiatura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PagoColegiatura pagoColegiatura) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pagoColegiatura = em.merge(pagoColegiatura);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = pagoColegiatura.getId();
                if (findPagoColegiatura(id) == null) {
                    throw new NonexistentEntityException("The pagoColegiatura with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PagoColegiatura pagoColegiatura;
            try {
                pagoColegiatura = em.getReference(PagoColegiatura.class, id);
                pagoColegiatura.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pagoColegiatura with id " + id + " no longer exists.", enfe);
            }
            em.remove(pagoColegiatura);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PagoColegiatura> findPagoColegiaturaEntities() {
        return findPagoColegiaturaEntities(true, -1, -1);
    }

    public List<PagoColegiatura> findPagoColegiaturaEntities(int maxResults, int firstResult) {
        return findPagoColegiaturaEntities(false, maxResults, firstResult);
    }

    private List<PagoColegiatura> findPagoColegiaturaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PagoColegiatura.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public PagoColegiatura findPagoColegiatura(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PagoColegiatura.class, id);
        } finally {
            em.close();
        }
    }

    public int getPagoColegiaturaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PagoColegiatura> rt = cq.from(PagoColegiatura.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}

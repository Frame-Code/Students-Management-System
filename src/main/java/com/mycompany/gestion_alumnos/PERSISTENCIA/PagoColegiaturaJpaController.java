package com.mycompany.gestion_alumnos.PERSISTENCIA;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.gestion_alumnos.LOGICA.Estudiante;
import com.mycompany.gestion_alumnos.LOGICA.PagoColegiatura;
import com.mycompany.gestion_alumnos.PERSISTENCIA.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
            Estudiante estudiante = pagoColegiatura.getEstudiante();
            if (estudiante != null) {
                estudiante = em.getReference(estudiante.getClass(), estudiante.getId());
                pagoColegiatura.setEstudiante(estudiante);
            }
            em.persist(pagoColegiatura);
            if (estudiante != null) {
                estudiante.getListPago_colegiaturas().add(pagoColegiatura);
                estudiante = em.merge(estudiante);
            }
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
            PagoColegiatura persistentPagoColegiatura = em.find(PagoColegiatura.class, pagoColegiatura.getId());
            Estudiante estudianteOld = persistentPagoColegiatura.getEstudiante();
            Estudiante estudianteNew = pagoColegiatura.getEstudiante();
            if (estudianteNew != null) {
                estudianteNew = em.getReference(estudianteNew.getClass(), estudianteNew.getId());
                pagoColegiatura.setEstudiante(estudianteNew);
            }
            pagoColegiatura = em.merge(pagoColegiatura);
            if (estudianteOld != null && !estudianteOld.equals(estudianteNew)) {
                estudianteOld.getListPago_colegiaturas().remove(pagoColegiatura);
                estudianteOld = em.merge(estudianteOld);
            }
            if (estudianteNew != null && !estudianteNew.equals(estudianteOld)) {
                estudianteNew.getListPago_colegiaturas().add(pagoColegiatura);
                estudianteNew = em.merge(estudianteNew);
            }
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
            Estudiante estudiante = pagoColegiatura.getEstudiante();
            if (estudiante != null) {
                estudiante.getListPago_colegiaturas().remove(pagoColegiatura);
                estudiante = em.merge(estudiante);
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

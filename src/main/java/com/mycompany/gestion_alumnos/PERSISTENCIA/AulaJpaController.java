package com.mycompany.gestion_alumnos.PERSISTENCIA;

import com.mycompany.gestion_alumnos.LOGICA.Aula;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.gestion_alumnos.LOGICA.Curso;
import com.mycompany.gestion_alumnos.PERSISTENCIA.exceptions.NonexistentEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * Created by Frame-Code, September 2024
 */
public class AulaJpaController implements Serializable {

    public AulaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Aula aula) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Curso curso = aula.getCurso();
            if (curso != null) {
                curso = em.getReference(curso.getClass(), curso.getId());
                aula.setCurso(curso);
            }
            em.persist(aula);
            if (curso != null) {
                curso.getListAulas().add(aula);
                curso = em.merge(curso);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Aula aula) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aula persistentAula = em.find(Aula.class, aula.getId());
            Curso cursoOld = persistentAula.getCurso();
            Curso cursoNew = aula.getCurso();
            if (cursoNew != null) {
                cursoNew = em.getReference(cursoNew.getClass(), cursoNew.getId());
                aula.setCurso(cursoNew);
            }
            aula = em.merge(aula);
            if (cursoOld != null && !cursoOld.equals(cursoNew)) {
                cursoOld.getListAulas().remove(aula);
                cursoOld = em.merge(cursoOld);
            }
            if (cursoNew != null && !cursoNew.equals(cursoOld)) {
                cursoNew.getListAulas().add(aula);
                cursoNew = em.merge(cursoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = aula.getId();
                if (findAula(id) == null) {
                    throw new NonexistentEntityException("The aula with id " + id + " no longer exists.");
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
            Aula aula;
            try {
                aula = em.getReference(Aula.class, id);
                aula.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The aula with id " + id + " no longer exists.", enfe);
            }
            Curso curso = aula.getCurso();
            if (curso != null) {
                curso.getListAulas().remove(aula);
                curso = em.merge(curso);
            }
            em.remove(aula);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Aula> findAulaEntities() {
        return findAulaEntities(true, -1, -1);
    }

    public List<Aula> findAulaEntities(int maxResults, int firstResult) {
        return findAulaEntities(false, maxResults, firstResult);
    }

    private List<Aula> findAulaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Aula.class));
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

    public Aula findAula(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Aula.class, id);
        } finally {
            em.close();
        }
    }

    public int getAulaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Aula> rt = cq.from(Aula.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}

package com.mycompany.gestion_alumnos.PERSISTENCIA;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.gestion_alumnos.LOGICA.Curso;
import com.mycompany.gestion_alumnos.LOGICA.Materia;
import com.mycompany.gestion_alumnos.PERSISTENCIA.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * Created by Frame-Code, September 2024
 */
public class MateriaJpaController implements Serializable {

    public MateriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Materia materia) {
        if (materia.getListCursos() == null) {
            materia.setListCursos(new ArrayList<Curso>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Curso> attachedListCursos = new ArrayList<Curso>();
            for (Curso listCursosCursoToAttach : materia.getListCursos()) {
                listCursosCursoToAttach = em.getReference(listCursosCursoToAttach.getClass(), listCursosCursoToAttach.getId());
                attachedListCursos.add(listCursosCursoToAttach);
            }
            materia.setListCursos(attachedListCursos);
            em.persist(materia);
            for (Curso listCursosCurso : materia.getListCursos()) {
                listCursosCurso.getListMaterias().add(materia);
                listCursosCurso = em.merge(listCursosCurso);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Materia materia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Materia persistentMateria = em.find(Materia.class, materia.getId());
            List<Curso> listCursosOld = persistentMateria.getListCursos();
            List<Curso> listCursosNew = materia.getListCursos();
            List<Curso> attachedListCursosNew = new ArrayList<Curso>();
            for (Curso listCursosNewCursoToAttach : listCursosNew) {
                listCursosNewCursoToAttach = em.getReference(listCursosNewCursoToAttach.getClass(), listCursosNewCursoToAttach.getId());
                attachedListCursosNew.add(listCursosNewCursoToAttach);
            }
            listCursosNew = attachedListCursosNew;
            materia.setListCursos(listCursosNew);
            materia = em.merge(materia);
            for (Curso listCursosOldCurso : listCursosOld) {
                if (!listCursosNew.contains(listCursosOldCurso)) {
                    listCursosOldCurso.getListMaterias().remove(materia);
                    listCursosOldCurso = em.merge(listCursosOldCurso);
                }
            }
            for (Curso listCursosNewCurso : listCursosNew) {
                if (!listCursosOld.contains(listCursosNewCurso)) {
                    listCursosNewCurso.getListMaterias().add(materia);
                    listCursosNewCurso = em.merge(listCursosNewCurso);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = materia.getId();
                if (findMateria(id) == null) {
                    throw new NonexistentEntityException("The materia with id " + id + " no longer exists.");
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
            Materia materia;
            try {
                materia = em.getReference(Materia.class, id);
                materia.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The materia with id " + id + " no longer exists.", enfe);
            }
            List<Curso> listCursos = materia.getListCursos();
            for (Curso listCursosCurso : listCursos) {
                listCursosCurso.getListMaterias().remove(materia);
                listCursosCurso = em.merge(listCursosCurso);
            }
            em.remove(materia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Materia> findMateriaEntities() {
        return findMateriaEntities(true, -1, -1);
    }

    public List<Materia> findMateriaEntities(int maxResults, int firstResult) {
        return findMateriaEntities(false, maxResults, firstResult);
    }

    private List<Materia> findMateriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Materia.class));
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

    public Materia findMateria(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Materia.class, id);
        } finally {
            em.close();
        }
    }

    public int getMateriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Materia> rt = cq.from(Materia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}

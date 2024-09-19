package com.mycompany.gestion_alumnos.PERSISTENCIA;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.gestion_alumnos.LOGICA.Aula;
import com.mycompany.gestion_alumnos.LOGICA.Curso;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.gestion_alumnos.LOGICA.Materia;
import com.mycompany.gestion_alumnos.PERSISTENCIA.exceptions.NonexistentEntityException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * Created by Frame-Code, September 2024
 */
public class CursoJpaController implements Serializable {

    public CursoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Curso curso) {
        if (curso.getListAulas() == null) {
            curso.setListAulas(new ArrayList<Aula>());
        }
        if (curso.getListMaterias() == null) {
            curso.setListMaterias(new ArrayList<Materia>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Aula> attachedListAulas = new ArrayList<Aula>();
            for (Aula listAulasAulaToAttach : curso.getListAulas()) {
                listAulasAulaToAttach = em.getReference(listAulasAulaToAttach.getClass(), listAulasAulaToAttach.getId());
                attachedListAulas.add(listAulasAulaToAttach);
            }
            curso.setListAulas(attachedListAulas);
            List<Materia> attachedListMaterias = new ArrayList<Materia>();
            for (Materia listMateriasMateriaToAttach : curso.getListMaterias()) {
                listMateriasMateriaToAttach = em.getReference(listMateriasMateriaToAttach.getClass(), listMateriasMateriaToAttach.getId());
                attachedListMaterias.add(listMateriasMateriaToAttach);
            }
            curso.setListMaterias(attachedListMaterias);
            em.persist(curso);
            for (Aula listAulasAula : curso.getListAulas()) {
                Curso oldCursoOfListAulasAula = listAulasAula.getCurso();
                listAulasAula.setCurso(curso);
                listAulasAula = em.merge(listAulasAula);
                if (oldCursoOfListAulasAula != null) {
                    oldCursoOfListAulasAula.getListAulas().remove(listAulasAula);
                    oldCursoOfListAulasAula = em.merge(oldCursoOfListAulasAula);
                }
            }
            for (Materia listMateriasMateria : curso.getListMaterias()) {
                Curso oldCursoOfListMateriasMateria = listMateriasMateria.getCurso();
                listMateriasMateria.setCurso(curso);
                listMateriasMateria = em.merge(listMateriasMateria);
                if (oldCursoOfListMateriasMateria != null) {
                    oldCursoOfListMateriasMateria.getListMaterias().remove(listMateriasMateria);
                    oldCursoOfListMateriasMateria = em.merge(oldCursoOfListMateriasMateria);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Curso curso) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Curso persistentCurso = em.find(Curso.class, curso.getId());
            List<Aula> listAulasOld = persistentCurso.getListAulas();
            List<Aula> listAulasNew = curso.getListAulas();
            List<Materia> listMateriasOld = persistentCurso.getListMaterias();
            List<Materia> listMateriasNew = curso.getListMaterias();
            List<Aula> attachedListAulasNew = new ArrayList<Aula>();
            for (Aula listAulasNewAulaToAttach : listAulasNew) {
                listAulasNewAulaToAttach = em.getReference(listAulasNewAulaToAttach.getClass(), listAulasNewAulaToAttach.getId());
                attachedListAulasNew.add(listAulasNewAulaToAttach);
            }
            listAulasNew = attachedListAulasNew;
            curso.setListAulas(listAulasNew);
            List<Materia> attachedListMateriasNew = new ArrayList<Materia>();
            for (Materia listMateriasNewMateriaToAttach : listMateriasNew) {
                listMateriasNewMateriaToAttach = em.getReference(listMateriasNewMateriaToAttach.getClass(), listMateriasNewMateriaToAttach.getId());
                attachedListMateriasNew.add(listMateriasNewMateriaToAttach);
            }
            listMateriasNew = attachedListMateriasNew;
            curso.setListMaterias(listMateriasNew);
            curso = em.merge(curso);
            for (Aula listAulasOldAula : listAulasOld) {
                if (!listAulasNew.contains(listAulasOldAula)) {
                    listAulasOldAula.setCurso(null);
                    listAulasOldAula = em.merge(listAulasOldAula);
                }
            }
            for (Aula listAulasNewAula : listAulasNew) {
                if (!listAulasOld.contains(listAulasNewAula)) {
                    Curso oldCursoOfListAulasNewAula = listAulasNewAula.getCurso();
                    listAulasNewAula.setCurso(curso);
                    listAulasNewAula = em.merge(listAulasNewAula);
                    if (oldCursoOfListAulasNewAula != null && !oldCursoOfListAulasNewAula.equals(curso)) {
                        oldCursoOfListAulasNewAula.getListAulas().remove(listAulasNewAula);
                        oldCursoOfListAulasNewAula = em.merge(oldCursoOfListAulasNewAula);
                    }
                }
            }
            for (Materia listMateriasOldMateria : listMateriasOld) {
                if (!listMateriasNew.contains(listMateriasOldMateria)) {
                    listMateriasOldMateria.setCurso(null);
                    listMateriasOldMateria = em.merge(listMateriasOldMateria);
                }
            }
            for (Materia listMateriasNewMateria : listMateriasNew) {
                if (!listMateriasOld.contains(listMateriasNewMateria)) {
                    Curso oldCursoOfListMateriasNewMateria = listMateriasNewMateria.getCurso();
                    listMateriasNewMateria.setCurso(curso);
                    listMateriasNewMateria = em.merge(listMateriasNewMateria);
                    if (oldCursoOfListMateriasNewMateria != null && !oldCursoOfListMateriasNewMateria.equals(curso)) {
                        oldCursoOfListMateriasNewMateria.getListMaterias().remove(listMateriasNewMateria);
                        oldCursoOfListMateriasNewMateria = em.merge(oldCursoOfListMateriasNewMateria);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = curso.getId();
                if (findCurso(id) == null) {
                    throw new NonexistentEntityException("The curso with id " + id + " no longer exists.");
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
            Curso curso;
            try {
                curso = em.getReference(Curso.class, id);
                curso.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The curso with id " + id + " no longer exists.", enfe);
            }
            List<Aula> listAulas = curso.getListAulas();
            for (Aula listAulasAula : listAulas) {
                listAulasAula.setCurso(null);
                listAulasAula = em.merge(listAulasAula);
            }
            List<Materia> listMaterias = curso.getListMaterias();
            for (Materia listMateriasMateria : listMaterias) {
                listMateriasMateria.setCurso(null);
                listMateriasMateria = em.merge(listMateriasMateria);
            }
            em.remove(curso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Curso> findCursoEntities() {
        return findCursoEntities(true, -1, -1);
    }

    public List<Curso> findCursoEntities(int maxResults, int firstResult) {
        return findCursoEntities(false, maxResults, firstResult);
    }

    private List<Curso> findCursoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Curso.class));
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

    public Curso findCurso(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Curso.class, id);
        } finally {
            em.close();
        }
    }

    public int getCursoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Curso> rt = cq.from(Curso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}

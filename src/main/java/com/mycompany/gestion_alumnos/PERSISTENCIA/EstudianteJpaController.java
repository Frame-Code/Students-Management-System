package com.mycompany.gestion_alumnos.PERSISTENCIA;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.gestion_alumnos.LOGICA.Aula;
import com.mycompany.gestion_alumnos.LOGICA.Estudiante;
import com.mycompany.gestion_alumnos.LOGICA.Matricula;
import com.mycompany.gestion_alumnos.LOGICA.PagoColegiatura;
import com.mycompany.gestion_alumnos.PERSISTENCIA.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * Created by Frame-Code, September 2024
 */
public class EstudianteJpaController implements Serializable {

    public EstudianteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Estudiante estudiante) {
        if (estudiante.getListPago_colegiaturas() == null) {
            estudiante.setListPago_colegiaturas(new ArrayList<PagoColegiatura>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Aula aula = estudiante.getAula();
            if (aula != null) {
                aula = em.getReference(aula.getClass(), aula.getId());
                estudiante.setAula(aula);
            }
            Matricula matricula = estudiante.getMatricula();
            if (matricula != null) {
                matricula = em.getReference(matricula.getClass(), matricula.getId());
                estudiante.setMatricula(matricula);
            }
            List<PagoColegiatura> attachedListPago_colegiaturas = new ArrayList<PagoColegiatura>();
            for (PagoColegiatura listPago_colegiaturasPagoColegiaturaToAttach : estudiante.getListPago_colegiaturas()) {
                listPago_colegiaturasPagoColegiaturaToAttach = em.getReference(listPago_colegiaturasPagoColegiaturaToAttach.getClass(), listPago_colegiaturasPagoColegiaturaToAttach.getId());
                attachedListPago_colegiaturas.add(listPago_colegiaturasPagoColegiaturaToAttach);
            }
            estudiante.setListPago_colegiaturas(attachedListPago_colegiaturas);
            em.persist(estudiante);
            if (aula != null) {
                aula.getListEstudiantes().add(estudiante);
                aula = em.merge(aula);
            }
            if (matricula != null) {
                Estudiante oldEstudianteOfMatricula = matricula.getEstudiante();
                if (oldEstudianteOfMatricula != null) {
                    oldEstudianteOfMatricula.setMatricula(null);
                    oldEstudianteOfMatricula = em.merge(oldEstudianteOfMatricula);
                }
                matricula.setEstudiante(estudiante);
                matricula = em.merge(matricula);
            }
            for (PagoColegiatura listPago_colegiaturasPagoColegiatura : estudiante.getListPago_colegiaturas()) {
                Estudiante oldEstudianteOfListPago_colegiaturasPagoColegiatura = listPago_colegiaturasPagoColegiatura.getEstudiante();
                listPago_colegiaturasPagoColegiatura.setEstudiante(estudiante);
                listPago_colegiaturasPagoColegiatura = em.merge(listPago_colegiaturasPagoColegiatura);
                if (oldEstudianteOfListPago_colegiaturasPagoColegiatura != null) {
                    oldEstudianteOfListPago_colegiaturasPagoColegiatura.getListPago_colegiaturas().remove(listPago_colegiaturasPagoColegiatura);
                    oldEstudianteOfListPago_colegiaturasPagoColegiatura = em.merge(oldEstudianteOfListPago_colegiaturasPagoColegiatura);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Estudiante estudiante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Estudiante persistentEstudiante = em.find(Estudiante.class, estudiante.getId());
            Aula aulaOld = persistentEstudiante.getAula();
            Aula aulaNew = estudiante.getAula();
            Matricula matriculaOld = persistentEstudiante.getMatricula();
            Matricula matriculaNew = estudiante.getMatricula();
            List<PagoColegiatura> listPago_colegiaturasOld = persistentEstudiante.getListPago_colegiaturas();
            List<PagoColegiatura> listPago_colegiaturasNew = estudiante.getListPago_colegiaturas();
            if (aulaNew != null) {
                aulaNew = em.getReference(aulaNew.getClass(), aulaNew.getId());
                estudiante.setAula(aulaNew);
            }
            if (matriculaNew != null) {
                matriculaNew = em.getReference(matriculaNew.getClass(), matriculaNew.getId());
                estudiante.setMatricula(matriculaNew);
            }
            List<PagoColegiatura> attachedListPago_colegiaturasNew = new ArrayList<PagoColegiatura>();
            for (PagoColegiatura listPago_colegiaturasNewPagoColegiaturaToAttach : listPago_colegiaturasNew) {
                listPago_colegiaturasNewPagoColegiaturaToAttach = em.getReference(listPago_colegiaturasNewPagoColegiaturaToAttach.getClass(), listPago_colegiaturasNewPagoColegiaturaToAttach.getId());
                attachedListPago_colegiaturasNew.add(listPago_colegiaturasNewPagoColegiaturaToAttach);
            }
            listPago_colegiaturasNew = attachedListPago_colegiaturasNew;
            estudiante.setListPago_colegiaturas(listPago_colegiaturasNew);
            estudiante = em.merge(estudiante);
            if (aulaOld != null && !aulaOld.equals(aulaNew)) {
                aulaOld.getListEstudiantes().remove(estudiante);
                aulaOld = em.merge(aulaOld);
            }
            if (aulaNew != null && !aulaNew.equals(aulaOld)) {
                aulaNew.getListEstudiantes().add(estudiante);
                aulaNew = em.merge(aulaNew);
            }
            if (matriculaOld != null && !matriculaOld.equals(matriculaNew)) {
                matriculaOld.setEstudiante(null);
                matriculaOld = em.merge(matriculaOld);
            }
            if (matriculaNew != null && !matriculaNew.equals(matriculaOld)) {
                Estudiante oldEstudianteOfMatricula = matriculaNew.getEstudiante();
                if (oldEstudianteOfMatricula != null) {
                    oldEstudianteOfMatricula.setMatricula(null);
                    oldEstudianteOfMatricula = em.merge(oldEstudianteOfMatricula);
                }
                matriculaNew.setEstudiante(estudiante);
                matriculaNew = em.merge(matriculaNew);
            }
            for (PagoColegiatura listPago_colegiaturasOldPagoColegiatura : listPago_colegiaturasOld) {
                if (!listPago_colegiaturasNew.contains(listPago_colegiaturasOldPagoColegiatura)) {
                    listPago_colegiaturasOldPagoColegiatura.setEstudiante(null);
                    listPago_colegiaturasOldPagoColegiatura = em.merge(listPago_colegiaturasOldPagoColegiatura);
                }
            }
            for (PagoColegiatura listPago_colegiaturasNewPagoColegiatura : listPago_colegiaturasNew) {
                if (!listPago_colegiaturasOld.contains(listPago_colegiaturasNewPagoColegiatura)) {
                    Estudiante oldEstudianteOfListPago_colegiaturasNewPagoColegiatura = listPago_colegiaturasNewPagoColegiatura.getEstudiante();
                    listPago_colegiaturasNewPagoColegiatura.setEstudiante(estudiante);
                    listPago_colegiaturasNewPagoColegiatura = em.merge(listPago_colegiaturasNewPagoColegiatura);
                    if (oldEstudianteOfListPago_colegiaturasNewPagoColegiatura != null && !oldEstudianteOfListPago_colegiaturasNewPagoColegiatura.equals(estudiante)) {
                        oldEstudianteOfListPago_colegiaturasNewPagoColegiatura.getListPago_colegiaturas().remove(listPago_colegiaturasNewPagoColegiatura);
                        oldEstudianteOfListPago_colegiaturasNewPagoColegiatura = em.merge(oldEstudianteOfListPago_colegiaturasNewPagoColegiatura);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = estudiante.getId();
                if (findEstudiante(id) == null) {
                    throw new NonexistentEntityException("The estudiante with id " + id + " no longer exists.");
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
            Estudiante estudiante;
            try {
                estudiante = em.getReference(Estudiante.class, id);
                estudiante.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estudiante with id " + id + " no longer exists.", enfe);
            }
            Aula aula = estudiante.getAula();
            if (aula != null) {
                aula.getListEstudiantes().remove(estudiante);
                aula = em.merge(aula);
            }
            Matricula matricula = estudiante.getMatricula();
            if (matricula != null) {
                matricula.setEstudiante(null);
                matricula = em.merge(matricula);
            }
            List<PagoColegiatura> listPago_colegiaturas = estudiante.getListPago_colegiaturas();
            for (PagoColegiatura listPago_colegiaturasPagoColegiatura : listPago_colegiaturas) {
                listPago_colegiaturasPagoColegiatura.setEstudiante(null);
                listPago_colegiaturasPagoColegiatura = em.merge(listPago_colegiaturasPagoColegiatura);
            }
            em.remove(estudiante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Estudiante> findEstudianteEntities() {
        return findEstudianteEntities(true, -1, -1);
    }

    public List<Estudiante> findEstudianteEntities(int maxResults, int firstResult) {
        return findEstudianteEntities(false, maxResults, firstResult);
    }

    private List<Estudiante> findEstudianteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Estudiante.class));
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

    public Estudiante findEstudiante(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Estudiante.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstudianteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Estudiante> rt = cq.from(Estudiante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}

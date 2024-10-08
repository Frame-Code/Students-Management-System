package com.mycompany.gestion_alumnos.PERSISTENCIA;

import com.mycompany.gestion_alumnos.LOGICA.Aula;
import com.mycompany.gestion_alumnos.LOGICA.Curso;
import com.mycompany.gestion_alumnos.LOGICA.Estudiante;
import com.mycompany.gestion_alumnos.LOGICA.Institucion;
import com.mycompany.gestion_alumnos.LOGICA.Materia;
import com.mycompany.gestion_alumnos.LOGICA.Matricula;
import com.mycompany.gestion_alumnos.LOGICA.PagoColegiatura;
import com.mycompany.gestion_alumnos.PERSISTENCIA.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Created by Frame-Code, September 2024
 */
public class ControladoraPersistencia {
    private static final JPAUtil util = new JPAUtil();
    private final AulaJpaController aulaJPA;
    private final CursoJpaController cursoJPA;
    private final EstudianteJpaController estudianteJPA;
    private final MateriaJpaController materiaJPA;
    private final MatriculaJpaController matriculaJPA;
    private final PagoColegiaturaJpaController pagoJPA;
    private final InstitucionJpaController institucionJPA;

    public ControladoraPersistencia() {
        this.aulaJPA = new AulaJpaController(util.getEntityManagerFactory());
        this.cursoJPA = new CursoJpaController(util.getEntityManagerFactory());
        this.estudianteJPA = new EstudianteJpaController(util.getEntityManagerFactory());
        this.materiaJPA = new MateriaJpaController(util.getEntityManagerFactory());
        this.matriculaJPA = new MatriculaJpaController(util.getEntityManagerFactory());
        this.pagoJPA = new PagoColegiaturaJpaController(util.getEntityManagerFactory());
        this.institucionJPA = new InstitucionJpaController(util.getEntityManagerFactory());
    }

    /*--------------------------METHODS CRUD-------------------------*/
    /*--------------------------AULA-------------------------*/
    public void crearAula(Aula aula) {
        aulaJPA.create(aula);
    }

    public Aula leerAula(Long id) {
        return aulaJPA.findAula(id);
    }

    public List<Aula> leerListAulas() {
        return aulaJPA.findAulaEntities();
    }

    public void editarAula(Aula aula) {
        try {
            aulaJPA.edit(aula);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarAula(Long id) {
        try {
            aulaJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*--------------------------CURSO-------------------------*/
    public void crearCurso(Curso curso) {
        cursoJPA.create(curso);
    }

    public Curso leerCurso(Long id) {
        return cursoJPA.findCurso(id);
    }

    public List<Curso> leerListCursos() {
        return cursoJPA.findCursoEntities();
    }

    public void editarCurso(Curso curso) {
        try {
            cursoJPA.edit(curso);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarCurso(Long id) {
        try {
            cursoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    /*--------------------------ESTUDIANTE-------------------------*/
    public void crearEstudiante(Estudiante estudiante) {
        estudianteJPA.create(estudiante);
    }

    public Estudiante leerEstudiante(Long id) {
        return estudianteJPA.findEstudiante(id);
    }

    public List<Estudiante> leerListEstudiantes() {
        return estudianteJPA.findEstudianteEntities();
    }

    public void editarEstudiante(Estudiante estudiante) {
        try {
            estudianteJPA.edit(estudiante);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarEstudiante(Long id) {
        try {
            estudianteJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*--------------------------MATERIA-------------------------*/
    public void crearMateria(Materia materia) {
        materiaJPA.create(materia);
    }

    public Materia leerMateria(Long id) {
        return materiaJPA.findMateria(id);
    }

    public List<Materia> leerListMaterias() {
        return materiaJPA.findMateriaEntities();
    }

    public void editarMateria(Materia materia) {
        try {
            materiaJPA.edit(materia);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarMateria(Long id) {
        try {
            materiaJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*--------------------------MATRICULA-------------------------*/
    public void crearMatricula(Matricula matricula) {
        matriculaJPA.create(matricula);
    }

    public Matricula leerMatricula(Long id) {
        return matriculaJPA.findMatricula(id);
    }

    public List<Matricula> leerListMatriculas() {
        return matriculaJPA.findMatriculaEntities();
    }

    public void editarMatricula(Matricula matricula) {
        try {
            matriculaJPA.edit(matricula);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarMatricula(Long id) {
        try {
            matriculaJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*--------------------------PAGO_COLEGIATURA-------------------------*/
    public void crearPago(PagoColegiatura pago) {
        pagoJPA.create(pago);
    }

    public PagoColegiatura leerPago(Long id) {
        return pagoJPA.findPagoColegiatura(id);
    }

    public List<PagoColegiatura> leerListPagos() {
        return pagoJPA.findPagoColegiaturaEntities();
    }

    public void editarPago(PagoColegiatura pago) {
        try {
            pagoJPA.edit(pago);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarPago(Long id) {
        try {
            pagoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*--------------------------INSTITUCION-------------------------*/
    public void crearInstitucion(Institucion institucion) {
        institucionJPA.create(institucion);
    }
    
    public Institucion leerInstitucion(Long id) {
        return institucionJPA.findInstitucion(id);
    }
    
    public List<Institucion> leerListInstitucion() {
        return institucionJPA.findInstitucionEntities();
    }
    
    public void editarInstitucion(Institucion institucion) {
        try {
            institucionJPA.edit(institucion);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void eliminarInstitucion(Long id) {
        try {
            institucionJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

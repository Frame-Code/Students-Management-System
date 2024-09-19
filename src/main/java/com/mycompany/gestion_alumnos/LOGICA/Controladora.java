package com.mycompany.gestion_alumnos.LOGICA;

import com.mycompany.gestion_alumnos.PERSISTENCIA.ControladoraPersistencia;
import com.mycompany.gestion_alumnos.PERSISTENCIA.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Created by Frame-Code, September 2024
 */
public class Controladora {

    private final ControladoraPersistencia persistencia;

    public Controladora() {
        this.persistencia = new ControladoraPersistencia();
    }

    /*--------------------------METHODS CRUD-------------------------*/
    /*--------------------------AULA-------------------------*/
    public void crearAula(Aula aula) {
        persistencia.crearAula(aula);
    }

    public Aula leerAula(Long id) {
        return persistencia.leerAula(id);
    }

    public List<Aula> leerListAulas() {
        return persistencia.leerListAulas();
    }

    public void editarAula(Aula aula) {
        persistencia.editarAula(aula);
    }

    public void eliminarAula(Long id) {
        persistencia.eliminarAula(id);
    }

    /*--------------------------CURSO-------------------------*/
    public void crearCurso(Curso curso) {
        persistencia.crearCurso(curso);
    }

    public Curso leerCurso(Long id) {
        return persistencia.leerCurso(id);
    }

    public List<Curso> leerListCursos() {
        return persistencia.leerListCursos();
    }

    public void editarCursos(Curso curso) {
        persistencia.editarCurso(curso);
    }

    public void eliminarCurso(Long id) {
        persistencia.eliminarCurso(id);
    }

    /*--------------------------ESTUDIANTE-------------------------*/
    public void crearEstudiante(Estudiante estudiante) {
        persistencia.crearEstudiante(estudiante);
    }

    public Estudiante leerEstudiante(Long id) {
        return persistencia.leerEstudiante(id);
    }

    public List<Estudiante> leerListEstudiantes() {
        return persistencia.leerListEstudiantes();
    }

    public void editarEstudiante(Estudiante estudiante) {
        persistencia.editarEstudiante(estudiante);
    }

    public void eliminarEstudiante(Long id) {
        persistencia.eliminarEstudiante(id);
    }

    /*--------------------------MATERIA-------------------------*/
    public void crearMateria(Materia materia) {
        persistencia.crearMateria(materia);
    }

    public Materia leerMateria(Long id) {
        return persistencia.leerMateria(id);
    }

    public List<Materia> leerListMaterias() {
        return persistencia.leerListMaterias();
    }

    public void editarMateria(Materia materia) {
        persistencia.editarMateria(materia);
    }

    public void eliminarMateria(Long id) {
        persistencia.eliminarMateria(id);
    }

    /*--------------------------MATRICULA-------------------------*/
    public void crearMatricula(Matricula matricula) {
        persistencia.crearMatricula(matricula);
    }

    public Matricula leerMatricula(Long id) {
        return persistencia.leerMatricula(id);
    }

    public List<Matricula> leerListMatriculas() {
        return persistencia.leerListMatriculas();
    }

    public void editarMatricula(Matricula matricula) {
        persistencia.editarMatricula(matricula);
    }

    public void eliminarMatricula(Long id) {
        persistencia.eliminarMatricula(id);
    }

    /*--------------------------PAGO_COLEGIATURA-------------------------*/
    public void crearPago(PagoColegiatura pago) {
        persistencia.crearPago(pago);
    }

    public PagoColegiatura leerPago(Long id) {
        return persistencia.leerPago(id);
    }

    public List<PagoColegiatura> leerListPagos() {
        return persistencia.leerListPagos();
    }

    public void editarPago(PagoColegiatura pago) {
        persistencia.editarPago(pago);
    }

    public void eliminarPago(Long id) {
        persistencia.eliminarPago(id);
    }

}

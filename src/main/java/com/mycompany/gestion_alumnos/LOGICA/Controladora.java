package com.mycompany.gestion_alumnos.LOGICA;

import com.mycompany.gestion_alumnos.PERSISTENCIA.ControladoraPersistencia;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

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

    public void crearAula(String nombre, int cantidadAsientosTotales, Long idCurso) {
        Aula aula = new Aula();
        aula.setCurso(leerCurso(idCurso));
        aula.setNombre(nombre);
        aula.setNumeroAsientosTotales(cantidadAsientosTotales);
        aula.setNumeroAsientosDisponibles(cantidadAsientosTotales);
        this.crearAula(aula);
    }

    public void cambiarNombreAula(Long idAula, String nombre) {
        Aula aula = this.leerAula(idAula);
        aula.setNombre(nombre);
        this.editarAula(aula);
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
    public void cambiarNombreCurso(Long idCurso, String nombre) {
        Curso curso = this.leerCurso(idCurso);
        curso.setNombre(nombre);
        this.editarCurso(curso);
    }

    public void crearCurso(Curso curso) {
        persistencia.crearCurso(curso);
    }

    public void crearCurso(String nombre, int n_aulas, int[] n_asientos, List<Materia> materias) {
        List<Estudiante> listEstudiante = new ArrayList<>();
        List<Aula> listAulas = new ArrayList<>();

        //Creamos un curso con aulas vacias
        Curso nuevoCurso = new Curso(1l, nombre, listAulas, materias);
        crearCurso(nuevoCurso);

        //Recorremos la lista de aulas para persistir cada aula
        char letraAula = 'A';
        for (int i = 0; i < n_aulas; i++) {
            Aula nuevaAula = new Aula(1l, (nombre + " " + letraAula), n_asientos[i], nuevoCurso, listEstudiante);
            nuevaAula.setNumeroAsientosDisponibles(n_asientos[i]);
            nuevoCurso.agregarAula(nuevaAula);
            crearAula(nuevaAula);
            letraAula++;
        }

    }

    //Mi first use of generics and some of functional programming 
    public <T> boolean verificarNombreDisponible(String nombre, List<T> lista, Function<T, String> obtenerNombre) {
        for (T elemento : lista) {
            if (obtenerNombre.apply(elemento).equals(nombre)) {
                return false;
            }
        }
        return true;
    }

    public boolean verificarNombreDisponible(String nombre) {
        List<Curso> listCursos = leerListCursos();
        for (Curso curso : listCursos) {
            if (curso.getNombre().equals(nombre)) {
                return false;
            }
        }
        return true;
    }

    //Metodo que retorna una lista de Aulas o Materias de cierto curso
    public <T> List<T> obtenerListasDelCurso(List<T> objeto, List<T> listRetornar) {
        for (T obj : objeto) {
            listRetornar.add(obj);
        }
        return listRetornar;
    }

    public List<Materia> obtenerListMateriasDeCurso(Long id) {
        Curso curso = leerCurso(id);
        return obtenerListasDelCurso(curso.getListMaterias(), new ArrayList<>());
    }

    public List<Aula> obtenerListAulasDeCurso(Long id) {
        Curso curso = leerCurso(id);
        return obtenerListasDelCurso(curso.getListAulas(), new ArrayList<>());
    }

    public Aula obtenerAulaDeCurso(String nombre, Long idCurso) {
        for (Aula aula : this.obtenerListAulasDeCurso(idCurso)) {
            if (aula.getNombre().equals(nombre)) {
                return aula;
            }
        }
        return null;
    }

    public void asignarMateriasAlCurso(List<Materia> listMateriasAgregar, Long idCurso) {
        Curso curso = leerCurso(idCurso);

        for (Materia materia : curso.getListMaterias()) {
            listMateriasAgregar.add(materia);
        }
        curso.setListMaterias(listMateriasAgregar);
        this.editarCurso(curso);

    }

    public void eliminarMateriasDeCurso(List<Materia> listMateriasEliminar, Long idCurso, List<Materia> listMateriasDeCurso) {
        //Eliminar la relacion entre curso-materia
        //De la lista de materias del curso, eliminamos las seleccionadas
        List<Materia> listMateriasNoEliminadas = new ArrayList<>(listMateriasDeCurso);

        Iterator<Materia> iterator = listMateriasNoEliminadas.iterator();

        while (iterator.hasNext()) {
            Materia materia = iterator.next();
            for (Materia materiaEliminar : listMateriasEliminar) {
                if (materia.getId().equals(materiaEliminar.getId())) {
                    iterator.remove();
                }
            }

        }

        //Agregamos al curso la lista de materias que se quedan y se mergea
        Curso curso = leerCurso(idCurso);
        curso.setListMaterias(listMateriasNoEliminadas);
        this.editarCurso(curso);

    }

    public void eliminarAulasDeCurso(List<Aula> listAulasEliminar) {
        for (Aula aula : listAulasEliminar) {
            this.eliminarAula(aula.getId());
        }

    }

    public Curso leerCurso(Long id) {
        return persistencia.leerCurso(id);
    }

    public Curso leerCurso(String curso) {
        for (Curso cur : this.leerListCursos()) {
            if (cur.getNombre().equals(curso)) {
                return this.leerCurso(cur.getId());
            }
        }
        return null;
    }

    public List<Curso> leerListCursos() {
        return persistencia.leerListCursos();
    }

    public void editarCurso(Curso curso) {
        persistencia.editarCurso(curso);
    }

    public void eliminarCurso(Long id) {
        //Obtener curso
        Curso curso = this.leerCurso(id);
        //Eliminar relacion logica para eliminar registro en tabla intermedia
        curso.setListAulas(new ArrayList<>());
        curso.setListMaterias(new ArrayList<>());

        //Se mergea el curso
        this.editarCurso(curso);

        //Se eliminan las aulas
        List<Aula> listAulas = this.leerListAulas();
        for (Aula aula : listAulas) {
            if (aula.getCurso() == null) {
                this.eliminarAula(aula.getId());
            }
        }

        //Se elimina el curso
        persistencia.eliminarCurso(id);
    }

    /*--------------------------ESTUDIANTE-------------------------*/
    public void crearEstudiante(Estudiante estudiante) {
        persistencia.crearEstudiante(estudiante);
    }

    public void crearEstudiante(String nombres, String apellidos, Long cedula, LocalDate fechaNacimiento,
            Long idCurso, String nombreAula, LocalDate fechaVencimiento, String valorMatricula) {

        Estudiante estu = new Estudiante(cedula, apellidos + " " + nombres, fechaNacimiento, this.obtenerAulaDeCurso(nombreAula, idCurso), new ArrayList<>());
        Matricula matricula = new Matricula(1l, LocalDate.now(), fechaVencimiento, Estudiante.ACTIVA, valorMatricula);
        estu.setMatricula(matricula);
        estu.setEdad();
        estu.setEstadoMatricula();
        matricula.setEstado(estu.obtenerEstadoMatricula());

        this.crearEstudiante(estu);
        this.crearMatricula(matricula);
        setEstadoMatricula(estu);

        Aula aula = this.obtenerAulaDeCurso(nombreAula, idCurso);
        aula.setNumeroAsientosDisponibles();
        this.editarAula(aula);
    }

    private void setEstadoMatricula(Estudiante estudiante) {
        estudiante.setEstadoMatricula();
        this.editarEstudiante(estudiante);
    }

    public String obtenerEstadoMatricula(Estudiante estudiante) {
        setEstadoMatricula(estudiante);
        return this.leerEstudiante(estudiante.getId()).getMatricula().getEstado();
    }

    public void anularMatricula(Long idEstudiante) {
        Estudiante estu = leerEstudiante(idEstudiante);
        Aula aulaDeEstudiante = this.leerAula(estu.getAula().getId());

        estu.getMatricula().setEstado(Estudiante.ANULADA);
        estu.setAula(null);

        List<Estudiante> listEstudiantes = new ArrayList<>(aulaDeEstudiante.getListEstudiantes());
        listEstudiantes.remove(estu);
        aulaDeEstudiante.setListEstudiantes(listEstudiantes);
        aulaDeEstudiante.setNumeroAsientosDisponibles();
        this.editarAula(aulaDeEstudiante);
        this.editarEstudiante(estu);
        this.editarMatricula(estu.getMatricula());
    }

    public Estudiante leerEstudiante(Long id) {
        return persistencia.leerEstudiante(id);
    }

    public List<Estudiante> leerListEstudiantes() {
        return persistencia.leerListEstudiantes();
    }

    public List<Estudiante> obtenerListaEstudiantesAula(Long idAula) {
        Aula aula = this.leerAula(idAula);
        return obtenerListasDelCurso(aula.getListEstudiantes(), new ArrayList<>());
    }

    public void editarEstudiante(Estudiante estudiante) {
        persistencia.editarEstudiante(estudiante);
    }

    public void editarEstudiante(Long idEstudiante, String nombresCompletos, String valorMatricula) {
        Estudiante estu = this.leerEstudiante(idEstudiante);
        estu.setNombre(nombresCompletos);
        estu.getMatricula().setValor_pagado(valorMatricula);
        this.editarEstudiante(estu);
        this.editarMatricula(estu.getMatricula());
    }

    public void eliminarEstudiante(Long id) {
        Estudiante estu = this.leerEstudiante(id);
        Aula aula = this.leerAula(estu.getAula().getId());
        Matricula matricula = this.leerMatricula(estu.getMatricula().getId());

        this.eliminarPagosEstudiante(id);

        List<Estudiante> listEstudiantes = aula.getListEstudiantes();
        Iterator<Estudiante> iterator = listEstudiantes.iterator();
        while (iterator.hasNext()) {
            Estudiante estudiante = iterator.next();
            if (estudiante.getId().equals(estu.getId())) {
                iterator.remove();
            }
        }
        aula.setListEstudiantes(listEstudiantes);
        aula.setNumeroAsientosDisponibles();

        persistencia.eliminarEstudiante(id);

        this.eliminarMatricula(matricula.getId());

        this.editarAula(aula);

    }

    public void anularMatriculas(Long idAula) {
        List<Estudiante> listEstudiantes = this.obtenerListaEstudiantesAula(idAula);
        for (Estudiante estudiante : listEstudiantes) {
            Matricula matricula = estudiante.getMatricula();
            matricula.setEstado(Estudiante.ANULADA);
            estudiante.setMatricula(matricula);
            estudiante.setAula(null);
        }

        Aula aula = this.leerAula(idAula);
        aula.getListEstudiantes().clear();
        aula.setNumeroAsientosDisponibles();

        this.editarAula(aula);
        
        for (Estudiante estudiante : listEstudiantes) {
            this.editarEstudiante(estudiante);
            this.editarMatricula(estudiante.getMatricula());
        }
    }

    /*--------------------------MATERIA-------------------------*/
    public void crearMateria(Materia materia) {
        persistencia.crearMateria(materia);
    }

    public void crearMateria(String nombre) {
        List<Curso> listCurso = new ArrayList<>();
        Materia materia = new Materia(1l, nombre, listCurso);
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

    public void editarMateria(String nombre, long id) {
        Materia materia = this.leerMateria(id);
        materia.setNombre(nombre);
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

    public void crearPago(int pago, String mes, Long idEstudiante) {
        // String mes_anio = mes + " - " + String.valueOf(LocalDate.now().getYear());
        PagoColegiatura pagoColegiatura = new PagoColegiatura();
        pagoColegiatura.setMes(mes);
        pagoColegiatura.setMonto(pago);
        pagoColegiatura.setEstudiante(this.leerEstudiante(idEstudiante));
        this.crearPago(pagoColegiatura);
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

    public void eliminarPagosEstudiante(Long idEstudiante) {
        for (PagoColegiatura pago : this.leerEstudiante(idEstudiante).getListPago_colegiaturas()) {
            this.eliminarPago(pago.getId());
        }
        this.leerEstudiante(idEstudiante).getListPago_colegiaturas().clear();
    }

}

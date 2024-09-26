package com.mycompany.gestion_alumnos.LOGICA;

import com.mycompany.gestion_alumnos.PERSISTENCIA.ControladoraPersistencia;
import java.util.ArrayList;
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
    
    public List<Materia> obtenerListMateriasDeCurso(Long id) {
        Curso curso = leerCurso(id);
        List<Materia> listMaterias = new ArrayList<>();
        
        for (Materia materia : curso.getListMaterias()) {
            listMaterias.add(materia);
        }
        return listMaterias;
    }
    
    public List<Aula> obtenerListAulasDeCurso(Long id) {
        Curso curso = leerCurso(id);
        List<Aula> listAulas = new ArrayList<>();
        
        for (Aula aula : curso.getListAulas()) {
            listAulas.add(aula);
        }
        return listAulas;
    }    

    public Curso leerCurso(Long id) {
        return persistencia.leerCurso(id);
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

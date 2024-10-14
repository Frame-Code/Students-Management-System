package com.mycompany.gestion_alumnos.DAO;

import com.mycompany.gestion_alumnos.GUI.Utils;
import com.mycompany.gestion_alumnos.LOGICA.Aula;
import com.mycompany.gestion_alumnos.LOGICA.Estudiante;
import com.mycompany.gestion_alumnos.LOGICA.Matricula;
import com.mycompany.gestion_alumnos.LOGICA.PagoColegiatura;
import com.mycompany.gestion_alumnos.PERSISTENCIA.ControladoraPersistencia;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Frame-Code, October 2024
 */
public class EstudianteImpl implements EstudianteDAO, Utils {

    private final ControlDAO control;
    private final ControladoraPersistencia persistencia;

    public EstudianteImpl(ControladoraPersistencia persistencia, ControlDAO control) {
        this.persistencia = persistencia;
        this.control = control;
    }
    
    
    /**
     * This method is used to create a new Student in a Classroom as a result in a Course
     * @param nombres Name of the Student
     * @param apellidos Last name of the Student
     * @param cedula The id of the Student
     * @param fechaNacimiento THe born date of the Student
     * @param idCurso The id of the Course to find the Classroom selected
     * @param nombreAula the name of the classroom to find this classroom on the course and register the Student here
     * @param fechaVencimiento The expiry date of the registration to the Student
     * @param valorMatricula The cost of the registration to the Student
     */
    @Override
    public void crearEstudiante(String nombres, String apellidos, Long cedula, LocalDate fechaNacimiento, Long idCurso,
            String nombreAula, LocalDate fechaVencimiento, String valorMatricula) {
        
        //Creating a new Student and a new Registration a associeated with each other
        Estudiante estu = new Estudiante(cedula, apellidos + " " + nombres, fechaNacimiento, control.getCursoI().obtenerAulaDeCurso(nombreAula, idCurso), new ArrayList<>());
        Matricula matricula = new Matricula(1l, LocalDate.now(), fechaVencimiento, Estudiante.ACTIVA, valorMatricula);
        estu.setMatricula(matricula);
        estu.setEdad();
        estu.setEstadoMatricula();
        matricula.setEstado(estu.obtenerEstadoMatricula(true));
        
        //Persisting of the previous registration and Student created to the data base
        //
        control.getMatriculaI().crear(matricula);
        crear(estu);
        setEstadoMatricula(estu);

        Aula aula = control.getCursoI().obtenerAulaDeCurso(nombreAula, idCurso);
        aula.setNumeroAsientosDisponibles();
        control.getAulaI().editar(aula);

    }
    
    //This method establishes the type state of the registration (active, inactive, cancelled)(activa, anulada, anulada) to the student
    @Override
    public void setEstadoMatricula(Estudiante estudiante) {
        estudiante.setEstadoMatricula();
        editar(estudiante);
    }
    
    
    //This method is used to get the state of the registration of a student 
    @Override
    public String obtenerEstadoMatricula(Estudiante estudiante) {
        setEstadoMatricula(estudiante);
        return leerEntidad(estudiante.getId()).getMatricula().getEstado();
    }
    
    //This method is used to cancel the registrarion of a student (the student will be not registered in a classroom as result a course)
    @Override
    public void anularMatricula(Long idEstudiante) {
        Estudiante estu = leerEntidad(idEstudiante);
        Aula aulaDeEstudiante = control.getAulaI().leerEntidad(estu.getAula().getId());

        estu.getMatricula().setEstado(Estudiante.ANULADA);
        estu.setAula(null);

        List<Estudiante> listEstudiantes = new ArrayList<>(aulaDeEstudiante.getListEstudiantes());
        listEstudiantes.remove(estu);
        aulaDeEstudiante.setListEstudiantes(listEstudiantes);
        aulaDeEstudiante.setNumeroAsientosDisponibles();
        control.getAulaI().editar(aulaDeEstudiante);
        editar(estu);
        control.getMatriculaI().editar(estu.getMatricula());
    }
    
    //This method return the student list of a classroom with state of registration active or inactive (activa or inactiva)
    @Override
    public List<Estudiante> obtenerListaEstudiantesAula(Long idAula) {
        Aula aula = control.getAulaI().leerEntidad(idAula);
        return control.getCursoI().obtenerListasDelCurso(aula.getListEstudiantes(), new ArrayList<>());
    }

    //This method return the student list with state of registration cancelled (Anulada)
    @Override
    public List<Estudiante> obtenerListaEstudiantesAnulados() {
        List<Estudiante> listEstudiantesAnulados = new ArrayList<>();
        for (Estudiante estudiante : leerListEntidad()) {
            if (estudiante.getAula() == null) {
                listEstudiantesAnulados.add(estudiante);
            }
        }
        return listEstudiantesAnulados;
    }

    //This method is used to delete a student with registration cancelled (anulada)
    @Override
    public void eliminarEstudianteAnulado(Long id) {
        Estudiante estu = leerEntidad(id);
        Matricula matricula = control.getMatriculaI().leerEntidad(estu.getMatricula().getId());

        control.getPagoI().eliminarPagosEstudiante(id);

        persistencia.eliminarEstudiante(id);

        control.getMatriculaI().eliminar(matricula.getId());
    }
    
    //This method is used to update the information of a student
    @Override
    public void editarEstudiante(Long idEstudiante, String nombresCompletos, String valorMatricula) {
        Estudiante estu = leerEntidad(idEstudiante);
        estu.setNombre(nombresCompletos);
        estu.getMatricula().setValor_pagado(valorMatricula);
        editar(estu);
        control.getMatriculaI().editar(estu.getMatricula());
    }
    
    //This metod is used to cancel all the resgitrarion from a classroom 
    //All the student of that classroom will be not a state registration cancelled (inactiva)
    @Override
    public void anularMatriculas(Long idAula) {
        List<Estudiante> listEstudiantes = this.obtenerListaEstudiantesAula(idAula);
        for (Estudiante estudiante : listEstudiantes) {
            Matricula matricula = estudiante.getMatricula();
            matricula.setEstado(Estudiante.ANULADA);
            estudiante.setMatricula(matricula);
            estudiante.setAula(null);
        }

        Aula aula = control.getAulaI().leerEntidad(idAula);
        aula.getListEstudiantes().clear();
        aula.setNumeroAsientosDisponibles();

        control.getAulaI().editar(aula);

        for (Estudiante estudiante : listEstudiantes) {
            editar(estudiante);
            control.getMatriculaI().editar(estudiante.getMatricula());
        }
    }
    
    //This method is used to register a student saved in the data base i.e student with state registration type cancelled (anulada)
    @Override
    public void matricularEstudianteExistente(Long idEstudiante, Long idCurso, String nombreAula, LocalDate fechaVencimiento, String valorMatricula) {
        Estudiante estu = leerEntidad(idEstudiante);
        estu.setAula(control.getCursoI().obtenerAulaDeCurso(nombreAula, idCurso));
        estu.setListPago_colegiaturas(new ArrayList<>());
        Matricula matricula = control.getMatriculaI().leerEntidad(estu.getMatricula().getId());
        estu.setEdad();
        matricula.setFecha_vencimiento(fechaVencimiento);
        matricula.setFecha_matriculacion(LocalDate.now());
        estu.setMatricula(matricula);
        estu.setEstadoMatricula();
        matricula.setEstado(estu.obtenerEstadoMatricula(false));
        matricula.setValor_pagado(valorMatricula);
        estu.setMatricula(matricula);

        editar(estu);
        control.getMatriculaI().editar(matricula);
        this.setEstadoMatricula(estu);

        Aula aula = control.getCursoI().obtenerAulaDeCurso(nombreAula, idCurso);
        aula.setNumeroAsientosDisponibles();
        control.getAulaI().editar(aula);
    }
    
    //This method is used to check the state of registration and set the result (active, inactive, o cancelled) (activa, inactiva, anulada)
    @Override
    public void verificarEstadoMatricula(Long idEstudiante) {
        Estudiante estu = leerEntidad(idEstudiante);
        List<PagoColegiatura> listPagos = estu.getListPago_colegiaturas();
        Matricula matricula = control.getMatriculaI().leerEntidad(estu.getMatricula().getId());
        if (listPagos.size() >= 1) {
            int mesUltimoPago = obtenerMes(listPagos.get(listPagos.size() - 1).getMes());
            int mesActual = LocalDate.now().getMonthValue();
            if (mesUltimoPago < mesActual) {
                matricula.setEstado(Estudiante.INACTIVA);
            } else {
                estu.setEstadoMatricula();
                matricula.setEstado(estu.obtenerEstadoMatricula(false));
            }
        }
        estu.setMatricula(matricula);
        editar(estu);
        control.getMatriculaI().editar(matricula);
    }
    
    //--------Basic CRUD methods----//
    @Override
    public void crear(Estudiante object) {
        persistencia.crearEstudiante(object);
    }

    @Override
    public Estudiante leerEntidad(Long id) {
        return persistencia.leerEstudiante(id);
    }

    @Override
    public List<Estudiante> leerListEntidad() {
        return persistencia.leerListEstudiantes();
    }

    @Override
    public void editar(Estudiante object) {
        persistencia.editarEstudiante(object);

    }

    @Override
    public void eliminar(Long id) {
        persistencia.eliminarEstudiante(id);
    }

}

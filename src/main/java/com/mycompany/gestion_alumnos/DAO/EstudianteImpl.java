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
 * Created by Frame-Code, September 2024
 */
public class EstudianteImpl implements EstudianteDAO, Utils {

    private final ControlDAO control;
    private final ControladoraPersistencia persistencia;

    public EstudianteImpl(ControladoraPersistencia persistencia, ControlDAO control) {
        this.persistencia = persistencia;
        this.control = control;
    }

    @Override
    public void crearEstudiante(String nombres, String apellidos, Long cedula, LocalDate fechaNacimiento, Long idCurso,
            String nombreAula, LocalDate fechaVencimiento, String valorMatricula) {

        Estudiante estu = new Estudiante(cedula, apellidos + " " + nombres, fechaNacimiento, control.getCursoI().obtenerAulaDeCurso(nombreAula, idCurso), new ArrayList<>());
        Matricula matricula = new Matricula(1l, LocalDate.now(), fechaVencimiento, Estudiante.ACTIVA, valorMatricula);
        estu.setMatricula(matricula);
        estu.setEdad();
        estu.setEstadoMatricula();
        matricula.setEstado(estu.obtenerEstadoMatricula(true));

        control.getMatriculaI().crear(matricula);
        crear(estu);
        setEstadoMatricula(estu);

        Aula aula = control.getCursoI().obtenerAulaDeCurso(nombreAula, idCurso);
        aula.setNumeroAsientosDisponibles();
        control.getAulaI().editar(aula);

    }

    @Override
    public void setEstadoMatricula(Estudiante estudiante) {
        estudiante.setEstadoMatricula();
        editar(estudiante);
    }

    @Override
    public String obtenerEstadoMatricula(Estudiante estudiante) {
        setEstadoMatricula(estudiante);
        return leerEntidad(estudiante.getId()).getMatricula().getEstado();
    }

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

    @Override
    public List<Estudiante> obtenerListaEstudiantesAula(Long idAula) {
        Aula aula = control.getAulaI().leerEntidad(idAula);
        return control.getCursoI().obtenerListasDelCurso(aula.getListEstudiantes(), new ArrayList<>());
    }

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

    @Override
    public void eliminarEstudianteAnulado(Long id) {
        Estudiante estu = leerEntidad(id);
        Matricula matricula = control.getMatriculaI().leerEntidad(estu.getMatricula().getId());

        control.getPagoI().eliminarPagosEstudiante(id);

        persistencia.eliminarEstudiante(id);

        control.getMatriculaI().eliminar(matricula.getId());
    }

    @Override
    public void editarEstudiante(Long idEstudiante, String nombresCompletos, String valorMatricula) {
        Estudiante estu = leerEntidad(idEstudiante);
        estu.setNombre(nombresCompletos);
        estu.getMatricula().setValor_pagado(valorMatricula);
        editar(estu);
        control.getMatriculaI().editar(estu.getMatricula());
    }

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

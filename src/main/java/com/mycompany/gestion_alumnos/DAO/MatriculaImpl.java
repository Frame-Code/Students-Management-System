package com.mycompany.gestion_alumnos.DAO;

import com.mycompany.gestion_alumnos.LOGICA.Matricula;
import com.mycompany.gestion_alumnos.PERSISTENCIA.ControladoraPersistencia;
import java.util.List;

/**
 *
 * Created by Frame-Code, October 2024
 */
public class MatriculaImpl implements MatriculaDAO {
    private final ControladoraPersistencia persistencia;

    public MatriculaImpl(ControladoraPersistencia persistencia) {
        this.persistencia = persistencia;
    }
    
    //--------Basic CRUD methods----//
    @Override
    public void crear(Matricula object) {
        persistencia.crearMatricula(object);
    }

    @Override
    public Matricula leerEntidad(Long id) {
        return persistencia.leerMatricula(id);
    }

    @Override
    public List<Matricula> leerListEntidad() {
        return persistencia.leerListMatriculas();
    }

    @Override
    public void editar(Matricula object) {
        persistencia.editarMatricula(object);
    }

    @Override
    public void eliminar(Long id) {
        persistencia.eliminarMatricula(id);
    }

}

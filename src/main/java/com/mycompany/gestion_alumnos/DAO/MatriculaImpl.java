package com.mycompany.gestion_alumnos.DAO;

import com.mycompany.gestion_alumnos.LOGICA.Matricula;
import com.mycompany.gestion_alumnos.PERSISTENCIA.ControladoraPersistencia;
import java.util.List;

/**
 *
 * Created by Frame-Code, September 2024
 */
public class MatriculaImpl implements MatriculaDAO {

    private final ControlDAO control;
    private final ControladoraPersistencia persistencia;

    public MatriculaImpl(ControladoraPersistencia persistencia, ControlDAO control) {
        this.persistencia = persistencia;
        this.control = control;
    }

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

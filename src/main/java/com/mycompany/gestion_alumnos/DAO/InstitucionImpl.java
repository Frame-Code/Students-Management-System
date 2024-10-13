package com.mycompany.gestion_alumnos.DAO;

import com.mycompany.gestion_alumnos.LOGICA.Institucion;
import com.mycompany.gestion_alumnos.PERSISTENCIA.ControladoraPersistencia;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * Created by Frame-Code
 */
public class InstitucionImpl implements InstitucionDAO {

    private final ControlDAO control;
    private final ControladoraPersistencia persistencia;

    public InstitucionImpl(ControladoraPersistencia persistencia, ControlDAO control) {
        this.persistencia = persistencia;
        this.control = control;
    }

    @Override
    public void crearInstitucion(String tipo, String nombre, String valorMatricula, Integer valorColegiatura, LocalDate inicioCiclo, LocalDate finalCiclo) {
        Institucion insti = new Institucion(1l, tipo, nombre, valorMatricula, valorColegiatura, inicioCiclo, finalCiclo);
        if (!leerListEntidad().isEmpty()) {
            eliminar(1l);
        }
        crear(insti);
    }

    @Override
    public void crear(Institucion object) {
        persistencia.crearInstitucion(object);
    }

    @Override
    public Institucion leerEntidad(Long id) {
        return persistencia.leerInstitucion(id);
    }

    @Override
    public List<Institucion> leerListEntidad() {
        return persistencia.leerListInstitucion();
    }

    @Override
    public void editar(Institucion object) {
        persistencia.editarInstitucion(object);
    }

    @Override
    public void eliminar(Long id) {
        persistencia.eliminarInstitucion(id);
    }
}

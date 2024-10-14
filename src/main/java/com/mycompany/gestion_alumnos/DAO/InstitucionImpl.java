package com.mycompany.gestion_alumnos.DAO;

import com.mycompany.gestion_alumnos.LOGICA.Institucion;
import com.mycompany.gestion_alumnos.PERSISTENCIA.ControladoraPersistencia;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * Created by Frame-Code, October 2024
 */
public class InstitucionImpl implements InstitucionDAO {

    private final ControladoraPersistencia persistencia;

    public InstitucionImpl(ControladoraPersistencia persistencia) {
        this.persistencia = persistencia;
    }
    
    /**
     * This method is used to register a new Institution to show certain aspects in the aplication e.g: 
     * the name and the type of the institution, the value by default of the cost registration,
     * the value by default of the tuition cost and the date by default end of the cycle, that is 
     * the date by default of the expiry of registration.
     * @param tipo
     * @param nombre
     * @param valorMatricula
     * @param valorColegiatura
     * @param inicioCiclo
     * @param finalCiclo
     */
    @Override
    public void crearInstitucion(String tipo, String nombre, String valorMatricula, Integer valorColegiatura, LocalDate inicioCiclo, LocalDate finalCiclo) {
        Institucion insti = new Institucion(1l, tipo, nombre, valorMatricula, valorColegiatura, inicioCiclo, finalCiclo);
        if (!leerListEntidad().isEmpty()) {
            eliminar(1l);
        }
        crear(insti);
    }

    //--------Basic CRUD methods----//
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

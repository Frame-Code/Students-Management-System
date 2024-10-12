package com.mycompany.gestion_alumnos.DAO;

import com.mycompany.gestion_alumnos.LOGICA.Institucion;
import java.time.LocalDate;

/**
 *
 * @author artist-code
 */
public interface InstitucionDAO extends GenericDAO<Institucion>{
    void crearInstitucion(String tipo, String nombre, String valorMatricula, Integer valorColegiatura,
            LocalDate inicioCiclo, LocalDate finalCiclo);
}

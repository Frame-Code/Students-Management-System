package com.mycompany.gestion_alumnos.DAO;

import com.mycompany.gestion_alumnos.LOGICA.Materia;

/**
 *
 * @author artist-code
 */
public interface MateriaDAO extends GenericDAO<Materia> {

    void crearMateria(String nombre);

    void editarMateria(String nombre, long id);
}

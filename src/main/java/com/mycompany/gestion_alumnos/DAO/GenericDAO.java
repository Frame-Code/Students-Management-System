package com.mycompany.gestion_alumnos.DAO;

import java.util.List;

/**
 *
 * @author artist-code
 */
public interface GenericDAO<T> {
    void crear(T object);
    T leerEntidad(Long id);
    List<T> leerListEntidad();
    void editar(T object);
    void eliminar(Long id);
}

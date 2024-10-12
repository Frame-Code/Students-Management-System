package com.mycompany.gestion_alumnos.DAO;

import com.mycompany.gestion_alumnos.LOGICA.Aula;

/**
 *
 * @author artist-code
 */
public interface AulaDAO extends GenericDAO<Aula> {
    
    void crearAula(String nombre, int cantidadAsientosTotales, Long idCurso);

    public void cambiarNombreAula(Long idAula, String nombre);
    
}

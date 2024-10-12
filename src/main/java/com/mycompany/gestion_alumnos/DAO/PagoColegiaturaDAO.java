package com.mycompany.gestion_alumnos.DAO;

import com.mycompany.gestion_alumnos.LOGICA.PagoColegiatura;

/**
 *
 * @author artist-code
 */
public interface PagoColegiaturaDAO extends GenericDAO<PagoColegiatura>{
    
    void crearPago(int pago, String mes, Long idEstudiante);
    
    void eliminarPagosEstudiante(Long idEstudiante);
}

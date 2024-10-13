package com.mycompany.gestion_alumnos.DAO;

import com.mycompany.gestion_alumnos.LOGICA.PagoColegiatura;
import com.mycompany.gestion_alumnos.PERSISTENCIA.ControladoraPersistencia;
import java.util.List;

/**
 *
 * Created by Frame-Code, September 2024
 */
public class PagoColegiaturaImpl implements PagoColegiaturaDAO {

    private final ControlDAO control;
    private final ControladoraPersistencia persistencia;

    public PagoColegiaturaImpl(ControladoraPersistencia persistencia, ControlDAO control) {
        this.persistencia = persistencia;
        this.control = control;
    }

    @Override
    public void crearPago(int pago, String mes, Long idEstudiante) {
        PagoColegiatura pagoColegiatura = new PagoColegiatura();
        pagoColegiatura.setMes(mes);
        pagoColegiatura.setMonto(pago);
        pagoColegiatura.setEstudiante(control.getEstudianteI().leerEntidad(idEstudiante));

        crear(pagoColegiatura);
    }

    @Override
    public void eliminarPagosEstudiante(Long idEstudiante) {
        for (PagoColegiatura pago : control.getEstudianteI().leerEntidad(idEstudiante).getListPago_colegiaturas()) {
            eliminar(pago.getId());
        }
        control.getEstudianteI().leerEntidad(idEstudiante).getListPago_colegiaturas().clear();
    }

    @Override
    public void crear(PagoColegiatura object) {
        persistencia.crearPago(object);
    }

    @Override
    public PagoColegiatura leerEntidad(Long id) {
        return persistencia.leerPago(id);
    }

    @Override
    public List<PagoColegiatura> leerListEntidad() {
        return persistencia.leerListPagos();
    }

    @Override
    public void editar(PagoColegiatura object) {
        persistencia.editarPago(object);
    }

    @Override
    public void eliminar(Long id) {
        persistencia.eliminarPago(id);
    }

}

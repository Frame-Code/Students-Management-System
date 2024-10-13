package com.mycompany.gestion_alumnos.DAO;

import com.mycompany.gestion_alumnos.LOGICA.Aula;
import com.mycompany.gestion_alumnos.PERSISTENCIA.ControladoraPersistencia;
import java.util.List;

/**
 *
 * Created by Frame-Code, September 2024
 */
public class AulaImpl implements AulaDAO {
    private final ControlDAO control;
    private final ControladoraPersistencia persistencia;

    public AulaImpl(ControladoraPersistencia persistencia, ControlDAO control) {
        this.control = control;
        this.persistencia = persistencia;
    }

    @Override
    public void crear(Aula aula) {
        persistencia.crearAula(aula);
    }

    @Override
    public void crearAula(String nombre, int cantidadAsientosTotales, Long idCurso) {
        Aula aula = new Aula();
        aula.setCurso(control.getCursoI().leerEntidad(idCurso));
        aula.setNombre(nombre);
        aula.setNumeroAsientosTotales(cantidadAsientosTotales);
        aula.setNumeroAsientosDisponibles(cantidadAsientosTotales);
        crear(aula);
    }

    @Override
    public void cambiarNombreAula(Long idAula, String nombre) {
        Aula aula = this.leerEntidad(idAula);
        aula.setNombre(nombre);
        editar(aula);
    }

    @Override
    public Aula leerEntidad(Long id) {
        return persistencia.leerAula(id);
    }

    @Override
    public List<Aula> leerListEntidad() {
        return persistencia.leerListAulas();
    }

    @Override
    public void editar(Aula object) {
        persistencia.editarAula(object);
    }

    @Override
    public void eliminar(Long id) {
        persistencia.eliminarAula(id);
    }

}

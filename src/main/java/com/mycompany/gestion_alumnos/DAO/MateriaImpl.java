package com.mycompany.gestion_alumnos.DAO;

import com.mycompany.gestion_alumnos.LOGICA.Curso;
import com.mycompany.gestion_alumnos.LOGICA.Materia;
import com.mycompany.gestion_alumnos.PERSISTENCIA.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Frame-Code, September 2024
 */
public class MateriaImpl implements MateriaDAO {

    private final ControlDAO control;
    private final ControladoraPersistencia persistencia;

    public MateriaImpl(ControladoraPersistencia persistencia, ControlDAO control) {
        this.persistencia = persistencia;
        this.control = control;
    }

    @Override
    public void crearMateria(String nombre) {
        List<Curso> listCurso = new ArrayList<>();
        Materia materia = new Materia(1l, nombre, listCurso);
        persistencia.crearMateria(materia);
    }

    @Override
    public void editarMateria(String nombre, long id) {
        Materia materia = leerEntidad(id);
        materia.setNombre(nombre);
        persistencia.editarMateria(materia);
    }

    @Override
    public void crear(Materia object) {
        persistencia.crearMateria(object);
    }

    @Override
    public Materia leerEntidad(Long id) {
        return persistencia.leerMateria(id);

    }

    @Override
    public List<Materia> leerListEntidad() {
        return persistencia.leerListMaterias();
    }

    @Override
    public void editar(Materia object) {
        persistencia.editarMateria(object);
    }

    @Override
    public void eliminar(Long id) {
        persistencia.eliminarMateria(id);
    }

}

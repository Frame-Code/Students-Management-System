package com.mycompany.gestion_alumnos.DAO;

import com.mycompany.gestion_alumnos.LOGICA.Aula;
import com.mycompany.gestion_alumnos.LOGICA.Curso;
import com.mycompany.gestion_alumnos.LOGICA.Estudiante;
import com.mycompany.gestion_alumnos.LOGICA.Materia;
import com.mycompany.gestion_alumnos.PERSISTENCIA.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/**
 *
 * Created by Frame-Code, September 2024
 */
public class CursoImpl implements CursoDAO {

    private final ControlDAO control;
    private final ControladoraPersistencia persistencia;

    public CursoImpl(ControladoraPersistencia persistencia, ControlDAO control) {
        this.control = control;
        this.persistencia = persistencia;
    }

    @Override
    public void crear(Curso object) {
        persistencia.crearCurso(object);
    }

    @Override
    public void crearCurso(String nombre, int n_aulas, int[] n_asientos, List<Materia> materias) {
        List<Estudiante> listEstudiante = new ArrayList<>();
        List<Aula> listAulas = new ArrayList<>();

        //Creamos un curso con aulas vacias
        Curso nuevoCurso = new Curso(1l, nombre, listAulas, materias);
        crear(nuevoCurso);

        //Recorremos la lista de aulas para persistir cada aula
        char letraAula = 'A';
        for (int i = 0; i < n_aulas; i++) {
            Aula nuevaAula = new Aula(1l, (nombre + " " + letraAula), n_asientos[i], nuevoCurso, listEstudiante);
            nuevaAula.setNumeroAsientosDisponibles(n_asientos[i]);
            nuevoCurso.agregarAula(nuevaAula);
            control.getAulaI().crear(nuevaAula);
            letraAula++;
        }
    }

    @Override
    public void cambiarNombreCurso(Long idCurso, String nombre) {
        Curso curso = leerEntidad(idCurso);
        curso.setNombre(nombre);
        editar(curso);
    }

    @Override
    public <T> boolean verificarNombreDisponible(String nombre, List<T> lista, Function<T, String> obtenerNombre) {
        for (T elemento : lista) {
            if (obtenerNombre.apply(elemento).equals(nombre)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean verificarNombreDisponible(String nombre) {
        List<Curso> listCursos = leerListEntidad();
        for (Curso curso : listCursos) {
            if (curso.getNombre().equals(nombre)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public <T> List<T> obtenerListasDelCurso(List<T> objeto, List<T> listRetornar) {
        for (T obj : objeto) {
            listRetornar.add(obj);
        }
        return listRetornar;
    }

    @Override
    public List<Materia> obtenerListMateriasDeCurso(Long id) {
        Curso curso = leerEntidad(id);
        return obtenerListasDelCurso(curso.getListMaterias(), new ArrayList<>());
    }

    @Override
    public List<Aula> obtenerListAulasDeCurso(Long id) {
        Curso curso = leerEntidad(id);
        return obtenerListasDelCurso(curso.getListAulas(), new ArrayList<>());
    }

    @Override
    public Aula obtenerAulaDeCurso(String nombre, Long idCurso) {
        for (Aula aula : obtenerListAulasDeCurso(idCurso)) {
            if (aula.getNombre().equals(nombre)) {
                return aula;
            }
        }
        return null;
    }

    @Override
    public void asignarMateriasAlCurso(List<Materia> listMateriasAgregar, Long idCurso) {
        Curso curso = leerEntidad(idCurso);

        for (Materia materia : curso.getListMaterias()) {
            listMateriasAgregar.add(materia);
        }
        curso.setListMaterias(listMateriasAgregar);
        editar(curso);
    }

    @Override
    public boolean isDisponibleParaBorrar(long idCurso) {
        for (Aula aula : obtenerListAulasDeCurso(idCurso)) {
            if (!aula.getListEstudiantes().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void eliminarMateriasDeCurso(List<Materia> listMateriasEliminar, Long idCurso, List<Materia> listMateriasDeCurso) {
        //Eliminar la relacion entre curso-materia
        //De la lista de materias del curso, eliminamos las seleccionadas
        List<Materia> listMateriasNoEliminadas = new ArrayList<>(listMateriasDeCurso);

        Iterator<Materia> iterator = listMateriasNoEliminadas.iterator();

        while (iterator.hasNext()) {
            Materia materia = iterator.next();
            for (Materia materiaEliminar : listMateriasEliminar) {
                if (materia.getId().equals(materiaEliminar.getId())) {
                    iterator.remove();
                }
            }

        }

        //Agregamos al curso la lista de materias que se quedan y se mergea
        Curso curso = leerEntidad(idCurso);
        curso.setListMaterias(listMateriasNoEliminadas);
        editar(curso);
    }

    @Override
    public void eliminarAulasDeCurso(List<Aula> listAulasEliminar) {
        for (Aula aula : listAulasEliminar) {
            eliminar(aula.getId());
        }
    }

    @Override
    public Curso leerCurso(String curso) {
        for (Curso cur : leerListEntidad()) {
            if (cur.getNombre().equals(curso)) {
                return leerEntidad(cur.getId());
            }
        }
        return null;
    }

    @Override
    public Curso leerEntidad(Long id) {
        return persistencia.leerCurso(id);
    }

    @Override
    public List<Curso> leerListEntidad() {
        return persistencia.leerListCursos();
    }

    @Override
    public void editar(Curso object) {
        persistencia.editarCurso(object);
    }

    @Override
    public void eliminar(Long id) {
        //Obtener curso
        Curso curso = leerEntidad(id);
        //Eliminar relacion logica para eliminar registro en tabla intermedia
        curso.setListAulas(new ArrayList<>());
        curso.setListMaterias(new ArrayList<>());

        //Se mergea el curso
        editar(curso);

        //Se eliminan las aulas
        List<Aula> listAulas = control.getAulaI().leerListEntidad();
        for (Aula aula : listAulas) {
            if (aula.getCurso() == null) {
                control.getAulaI().eliminar(aula.getId());
            }
        }

        //Se elimina el curso
        persistencia.eliminarCurso(id);
    }

}

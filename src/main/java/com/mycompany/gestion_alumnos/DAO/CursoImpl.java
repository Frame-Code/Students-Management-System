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

    //Method to create a new course using his attributes
    @Override
    public void crearCurso(String nombre, int n_aulas, int[] n_asientos, List<Materia> materias) {
        List<Estudiante> listEstudiante = new ArrayList<>();
        List<Aula> listAulas = new ArrayList<>();

        //Creating  a new course with emptys classrooms
        Curso nuevoCurso = new Curso(1l, nombre, listAulas, materias);
        crear(nuevoCurso);

        //Using the loop be created classrooms and each that is persisted on the data base
        char letraAula = 'A';
        for (int i = 0; i < n_aulas; i++) {
            Aula nuevaAula = new Aula(1l, (nombre + " " + letraAula), n_asientos[i], nuevoCurso, listEstudiante);
            nuevaAula.setNumeroAsientosDisponibles(n_asientos[i]);
            nuevoCurso.agregarAula(nuevaAula);
            control.getAulaI().crear(nuevaAula);
            letraAula++;
        }
    }
    
    //Method to change the name of the course
    @Override
    public void cambiarNombreCurso(Long idCurso, String nombre) {
        Curso curso = leerEntidad(idCurso);
        curso.setNombre(nombre);
        editar(curso);
    }

    /**
     * This generic method check if the name written to create A NEW COURSE OR a
     * new SUBJECT on the corresponding JPanel don't exist or isn't registered
     * on the data base
     *
     * @param nombre the name of the course to be created
     * @param <T> Can be a list of all Course or a list of all Subjects
     * @param lista The list is used in a loop for to compare each Course or
     * Subject name and verify is that is registered
     * @param obtenerNombre A function to return name (using the getter) from
     * the generic T (in this case Course or subject)
     * @return if the name of the new COURSE OR SUBJECT isn't registered return
     * true, otherwise false
     */
    @Override
    public <T> boolean verificarNombreDisponible(String nombre, List<T> lista, Function<T, String> obtenerNombre) {
        for (T elemento : lista) {
            if (obtenerNombre.apply(elemento).equals(nombre)) {
                return false;
            }
        }
        return true;
    }

    /**
     * A generic method to get a list of the different attributes of the Course
     * e.g: Subjects of the course or Clasroom of the course
     *
     * @param <T> A generic method to can be use the entity Curso or Materia
     * @param objeto List to can be a list of Course or Materia or any other
     * @param listRetornar On the loop this list added the elements necessary to
     * be retorned
     * @return the list with the elements necesaries.
     */
    @Override
    public <T> List<T> obtenerListasDelCurso(List<T> objeto, List<T> listRetornar) {
        for (T obj : objeto) {
            listRetornar.add(obj);
        }
        return listRetornar;
    }

    //Method to get the list of Subjects from the course using the previous method 
    @Override
    public List<Materia> obtenerListMateriasDeCurso(Long id) {
        Curso curso = leerEntidad(id);
        return obtenerListasDelCurso(curso.getListMaterias(), new ArrayList<>());
    }

    //Method to get the list of Classroom from the course using the previous method 
    @Override
    public List<Aula> obtenerListAulasDeCurso(Long id) {
        Curso curso = leerEntidad(id);
        return obtenerListasDelCurso(curso.getListAulas(), new ArrayList<>());
    }

    //Method to get the a specific Classroom from a course using the name of the classroom and the id of the course to check it
    @Override
    public Aula obtenerAulaDeCurso(String nombre, Long idCurso) {
        for (Aula aula : obtenerListAulasDeCurso(idCurso)) {
            if (aula.getNombre().equals(nombre)) {
                return aula;
            }
        }
        return null;
    }

    //Method to add a list of subjects to the course selected using his id
    @Override
    public void asignarMateriasAlCurso(List<Materia> listMateriasAgregar, Long idCurso) {
        Curso curso = leerEntidad(idCurso);

        for (Materia materia : curso.getListMaterias()) {
            listMateriasAgregar.add(materia);
        }
        curso.setListMaterias(listMateriasAgregar);
        editar(curso);
    }

    //Method to check if the course is enable to be deleted verifying if some classroom of the course selected have students
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
        //First delete the relation between course-subject
        //Then from the subjects list of the course, be deleted the subjectes selected
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

        //The resulting list of subject is setted to the Course and edit the course
        Curso curso = leerEntidad(idCurso);
        curso.setListMaterias(listMateriasNoEliminadas);
        editar(curso);
    }

    //Method to delete classooms of the course
    @Override
    public void eliminarAulasDeCurso(List<Aula> listAulasEliminar) {
        for (Aula aula : listAulasEliminar) {
            eliminar(aula.getId());
        }
    }

    //Method to get a course using his Name
    @Override
    public Curso leerCurso(String curso) {
        for (Curso cur : leerListEntidad()) {
            if (cur.getNombre().equals(curso)) {
                return leerEntidad(cur.getId());
            }
        }
        return null;
    }

    //Method to delete a course by id
    @Override
    public void eliminar(Long id) {
        //Get the course
        Curso curso = leerEntidad(id);

        //Eliminar relacion logica para eliminar registro en tabla intermedia
        //Delete the logic relation for delete the register of the intermediate table from the data base
        curso.setListAulas(new ArrayList<>());
        curso.setListMaterias(new ArrayList<>());

        //Edit the course to save de previous changes
        editar(curso);

        //The classrooms are eliminated
        List<Aula> listAulas = control.getAulaI().leerListEntidad();
        for (Aula aula : listAulas) {
            if (aula.getCurso() == null) {
                control.getAulaI().eliminar(aula.getId());
            }
        }

        //Deleting the course
        persistencia.eliminarCurso(id);
    }

    //------Basic CRUD methods----//
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
    public void crear(Curso object) {
        persistencia.crearCurso(object);
    }

}

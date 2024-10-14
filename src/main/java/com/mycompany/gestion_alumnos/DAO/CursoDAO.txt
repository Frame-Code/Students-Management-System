package com.mycompany.gestion_alumnos.DAO;

import com.mycompany.gestion_alumnos.LOGICA.Aula;
import com.mycompany.gestion_alumnos.LOGICA.Curso;
import com.mycompany.gestion_alumnos.LOGICA.Materia;
import java.util.List;
import java.util.function.Function;

/**
 *
 * @author artist-code
 */
public interface CursoDAO extends GenericDAO<Curso>{

    void crearCurso(String nombre, int n_aulas, int[] n_asientos, List<Materia> materias);
    
    void cambiarNombreCurso(Long idCurso, String nombre);

    <T> boolean verificarNombreDisponible(String nombre, List<T> lista, Function<T, String> obtenerNombre);

    <T> List<T> obtenerListasDelCurso(List<T> objeto, List<T> listRetornar);

    List<Materia> obtenerListMateriasDeCurso(Long id);

    List<Aula> obtenerListAulasDeCurso(Long id);
    
    Aula obtenerAulaDeCurso(String nombre, Long idCurso);
    
    void asignarMateriasAlCurso(List<Materia> listMateriasAgregar, Long idCurso);
    
    boolean isDisponibleParaBorrar(long idCurso);
    
    void eliminarMateriasDeCurso(List<Materia> listMateriasEliminar, Long idCurso, List<Materia> listMateriasDeCurso);
    
    void eliminarAulasDeCurso(List<Aula> listAulasEliminar);
    
    Curso leerCurso(String curso);

}

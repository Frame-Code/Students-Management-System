package com.mycompany.gestion_alumnos.DAO;

import com.mycompany.gestion_alumnos.LOGICA.Estudiante;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author artist-code
 */
public interface EstudianteDAO extends GenericDAO<Estudiante>{
    void crearEstudiante(String nombres, String apellidos, Long cedula, LocalDate fechaNacimiento,
            Long idCurso, String nombreAula, LocalDate fechaVencimiento, String valorMatricula);
    
    void setEstadoMatricula(Estudiante estudiante);

    String obtenerEstadoMatricula(Estudiante estudiante);

    void anularMatricula(Long idEstudiante);

    List<Estudiante> obtenerListaEstudiantesAula(Long idAula);

    List<Estudiante> obtenerListaEstudiantesAnulados();

    void eliminarEstudianteAnulado(Long id);
    
    void editarEstudiante(Long idEstudiante, String nombresCompletos, String valorMatricula);

    void anularMatriculas(Long idAula);

    void matricularEstudianteExistente(Long idEstudiante, Long idCurso, String nombreAula, LocalDate fechaVencimiento, String valorMatricula);

    void verificarEstadoMatricula(Long idEstudiante);
}

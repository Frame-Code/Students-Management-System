package com.mycompany.gestion_alumnos.DAO;

import com.mycompany.gestion_alumnos.PERSISTENCIA.ControladoraPersistencia;
import java.time.LocalDate;

/**
 * This class is used to share the information between the difference
 * implement-class through the getters Created by Frame-Code, October 2024
 */
public class ControlDAO {

    private final ControladoraPersistencia persistencia;
    private final AulaImpl aulaI;
    private final CursoImpl cursoI;
    private final EstudianteImpl estudianteI;
    private final PagoColegiaturaImpl pagoI;
    private final MateriaImpl materiaI;
    private final MatriculaImpl matriculaI;
    private final InstitucionImpl institucionI;

    public ControlDAO() {
        this.persistencia = new ControladoraPersistencia();
        this.aulaI = new AulaImpl(persistencia, this);
        this.cursoI = new CursoImpl(persistencia, this);
        this.estudianteI = new EstudianteImpl(persistencia, this);
        this.pagoI = new PagoColegiaturaImpl(persistencia, this);
        this.matriculaI = new MatriculaImpl(persistencia);
        this.materiaI = new MateriaImpl(persistencia);
        this.institucionI = new InstitucionImpl(persistencia);
    }

    public void inicializar() {
        if (getInstitucionI().leerListEntidad().isEmpty()) {
            getInstitucionI().crearInstitucion("Example", "Example", "1", 1, LocalDate.now(), LocalDate.now());
        }
    }

    public AulaImpl getAulaI() {
        return aulaI;
    }

    public CursoImpl getCursoI() {
        return cursoI;
    }

    public EstudianteImpl getEstudianteI() {
        return estudianteI;
    }

    public MatriculaImpl getMatriculaI() {
        return matriculaI;
    }

    public MateriaImpl getMateriaI() {
        return materiaI;
    }

    public PagoColegiaturaImpl getPagoI() {
        return pagoI;
    }

    public InstitucionImpl getInstitucionI() {
        return institucionI;
    }

}

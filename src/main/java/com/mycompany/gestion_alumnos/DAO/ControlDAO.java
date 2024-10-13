package com.mycompany.gestion_alumnos.DAO;

import com.mycompany.gestion_alumnos.PERSISTENCIA.ControladoraPersistencia;

/**
 *
 * Created by Frame-Code, September 2024
 */
public class ControlDAO {

    private final ControladoraPersistencia persistencia;
    private AulaImpl aulaI;
    private CursoImpl cursoI;
    private EstudianteImpl estudianteI;
    private MatriculaImpl matriculaI;
    private MateriaImpl materiaI;
    private PagoColegiaturaImpl pagoI;
    private InstitucionImpl institucionI;

    public ControlDAO(AulaImpl aulaI, CursoImpl curso) {
        this.persistencia = new ControladoraPersistencia();
        this.aulaI = new AulaImpl(persistencia, this );
        this.cursoI = new CursoImpl(persistencia, this);
        this.estudianteI = new EstudianteImpl(persistencia, this);
        this.matriculaI = new MatriculaImpl(persistencia, this);
        this.materiaI = new MateriaImpl(persistencia, this);
        this.pagoI = new PagoColegiaturaImpl(persistencia, this);
        this.institucionI = new InstitucionImpl(persistencia, this);
    }

    public AulaImpl getAulaI() {
        return aulaI;
    }

    public void setAulaI(AulaImpl aulaI) {
        this.aulaI = aulaI;
    }

    public CursoImpl getCursoI() {
        return cursoI;
    }

    public void setCursoI(CursoImpl cursoI) {
        this.cursoI = cursoI;
    }

    public EstudianteImpl getEstudianteI() {
        return estudianteI;
    }

    public void setEstudianteI(EstudianteImpl estudianteI) {
        this.estudianteI = estudianteI;
    }

    public MatriculaImpl getMatriculaI() {
        return matriculaI;
    }

    public void setMatriculaI(MatriculaImpl matriculaI) {
        this.matriculaI = matriculaI;
    }

    public MateriaImpl getMateriaI() {
        return materiaI;
    }

    public void setMateriaI(MateriaImpl materiaI) {
        this.materiaI = materiaI;
    }

    public PagoColegiaturaImpl getPagoI() {
        return pagoI;
    }

    public void setPagoI(PagoColegiaturaImpl pagoI) {
        this.pagoI = pagoI;
    }

    public InstitucionImpl getInstitucionI() {
        return institucionI;
    }

    public void setInstitucionI(InstitucionImpl institucionI) {
        this.institucionI = institucionI;
    }
    

}

package com.mycompany.gestion_alumnos.LOGICA;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * Created by Frame-Code, September 2024
 */
@Entity (name="INSTITUCION")
public class Institucion implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    
    @Column(name="TIPO_INSTUCION", nullable = false, length = 150)
    private String tipoInstitucion;
    
    @Column(name="NOMBRE", nullable = false, length = 150)
    private String nombreInstitucion;
    
    @Column(name="COSTO_MATRICULA", nullable = false, length = 15)
    private String costoMatricula;
    
    @Column(name="COSTO_COLEGIATURA")
    private Integer costoColegiatura;
    
    @Column(name="INICIO_CICLO", nullable = false)
    private LocalDate fechaInicioCiclo;
    
    @Column(name="FIN_CICLO", nullable = false)
    private LocalDate fechaFinalCiclo;

    public Institucion() {
    }

    public Institucion(Long id, String tipoInstitucion, String nombreInstitucion, String costoMatricula, Integer costoColegiatura, LocalDate fechaInicioCiclo, LocalDate fechaFinalCiclo) {
        this.id = id;
        this.tipoInstitucion = tipoInstitucion;
        this.nombreInstitucion = nombreInstitucion;
        this.costoMatricula = costoMatricula;
        this.costoColegiatura = costoColegiatura;
        this.fechaInicioCiclo = fechaInicioCiclo;
        this.fechaFinalCiclo = fechaFinalCiclo;
    }

    public Institucion(String tipoInstitucion, String nombreInstitucion, String costoMatricula, Integer costoColegiatura, LocalDate fechaInicioCiclo, LocalDate fechaFinalCiclo) {
        this.tipoInstitucion = tipoInstitucion;
        this.nombreInstitucion = nombreInstitucion;
        this.costoMatricula = costoMatricula;
        this.costoColegiatura = costoColegiatura;
        this.fechaInicioCiclo = fechaInicioCiclo;
        this.fechaFinalCiclo = fechaFinalCiclo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoInstitucion() {
        return tipoInstitucion;
    }

    public void setTipoInstitucion(String tipoInstitucion) {
        this.tipoInstitucion = tipoInstitucion;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getCostoMatricula() {
        return costoMatricula;
    }

    public void setCostoMatricula(String costoMatricula) {
        this.costoMatricula = costoMatricula;
    }

    public Integer getCostoColegiatura() {
        return costoColegiatura;
    }

    public void setCostoColegiatura(Integer costoColegiatura) {
        this.costoColegiatura = costoColegiatura;
    }

    public LocalDate getFechaInicioCiclo() {
        return fechaInicioCiclo;
    }

    public void setFechaInicioCiclo(LocalDate fechaInicioCiclo) {
        this.fechaInicioCiclo = fechaInicioCiclo;
    }

    public LocalDate getFechaFinalCiclo() {
        return fechaFinalCiclo;
    }

    public void setFechaFinalCiclo(LocalDate fechaFinalCiclo) {
        this.fechaFinalCiclo = fechaFinalCiclo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.tipoInstitucion);
        hash = 41 * hash + Objects.hashCode(this.nombreInstitucion);
        hash = 41 * hash + Objects.hashCode(this.costoMatricula);
        hash = 41 * hash + Objects.hashCode(this.costoColegiatura);
        hash = 41 * hash + Objects.hashCode(this.fechaInicioCiclo);
        hash = 41 * hash + Objects.hashCode(this.fechaFinalCiclo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Institucion other = (Institucion) obj;
        if (!Objects.equals(this.tipoInstitucion, other.tipoInstitucion)) {
            return false;
        }
        if (!Objects.equals(this.nombreInstitucion, other.nombreInstitucion)) {
            return false;
        }
        if (!Objects.equals(this.costoMatricula, other.costoMatricula)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.costoColegiatura, other.costoColegiatura)) {
            return false;
        }
        if (!Objects.equals(this.fechaInicioCiclo, other.fechaInicioCiclo)) {
            return false;
        }
        return Objects.equals(this.fechaFinalCiclo, other.fechaFinalCiclo);
    }

    @Override
    public String toString() {
        return "Institucion{" + "id=" + id + ", tipoInstitucion=" + tipoInstitucion + ", nombreInstitucion=" + nombreInstitucion + ", costoMatricula=" + costoMatricula + ", costoColegiatura=" + costoColegiatura + ", fechaInicioCiclo=" + fechaInicioCiclo + ", fechaFinalCiclo=" + fechaFinalCiclo + '}';
    }
    
    
           
}

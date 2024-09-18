package com.mycompany.gestion_alumnos.LOGICA;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;

/**
 *
 * Created by Frame-Code, September 2024
 */
class Estudiante {

    private Long id;
    private String nombre;
    private LocalDate fecha_nacimiento;
    private Integer edad;
    private Aula aula;
    private Matricula matricula;
    private List<PagoColegiatura> pago_colegiatura;

    public Estudiante() {
    }
    public Estudiante(Long id, String nombre, LocalDate fecha_nacimiento, Aula aula, Matricula matricula, List<PagoColegiatura> pago_colegiatura) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.aula = aula;
        this.matricula = matricula;
        this.pago_colegiatura = pago_colegiatura;
        edad = agregarEdad();
    }

    private Integer agregarEdad() {
        Integer edadGeneral = LocalDate.now().getYear() - this.fecha_nacimiento.getYear();
        if (LocalDate.now().getMonthValue() < this.fecha_nacimiento.getMonthValue()) {
            if (LocalDate.now().getDayOfMonth() < this.fecha_nacimiento.getDayOfMonth()) {
                edadGeneral--;
            }
        }
        return edadGeneral;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad() {
        this.edad = this.agregarEdad();
    }
    
    
    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Aula getAula() {
        return aula;
    }
    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Matricula getMatricula() {
        return matricula;
    }
    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public List<PagoColegiatura> getPago_colegiatura() {
        return pago_colegiatura;
    }
    public void setPago_colegiatura(List<PagoColegiatura> pago_colegiatura) {
        this.pago_colegiatura = pago_colegiatura;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
        hash = 23 * hash + Objects.hashCode(this.nombre);
        hash = 23 * hash + Objects.hashCode(this.fecha_nacimiento);
        hash = 23 * hash + Objects.hashCode(this.edad);
        hash = 23 * hash + Objects.hashCode(this.aula);
        hash = 23 * hash + Objects.hashCode(this.matricula);
        hash = 23 * hash + Objects.hashCode(this.pago_colegiatura);
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
        final Estudiante other = (Estudiante) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fecha_nacimiento, other.fecha_nacimiento)) {
            return false;
        }
        if (!Objects.equals(this.edad, other.edad)) {
            return false;
        }
        if (!Objects.equals(this.aula, other.aula)) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        return Objects.equals(this.pago_colegiatura, other.pago_colegiatura);
    }

    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + ", nombre=" + nombre + ", fecha_nacimiento=" + fecha_nacimiento + ", edad=" + edad + ", aula=" + aula + ", matricula=" + matricula + ", pago_colegiatura=" + pago_colegiatura + '}';
    }
}

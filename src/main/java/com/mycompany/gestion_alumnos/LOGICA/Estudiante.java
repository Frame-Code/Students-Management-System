package com.mycompany.gestion_alumnos.LOGICA;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * Created by Frame-Code, September 2024
 */
@Entity(name = "ESTUDIANTE")
public class Estudiante implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE", length = 30, nullable = false)
    private String nombre;

    @Column(name = "FECHA_NACIMIENTO", nullable = false)
    private LocalDate fecha_nacimiento;

    @Column(name = "EDAD")
    private Integer edad;

    @ManyToOne
    @JoinColumn(name = "AULA")
    private Aula aula;

    @OneToOne 
    @Column (name = "MATRICULA")
    private Matricula matricula;

    @OneToMany(mappedBy = "estudiante")
    private List<PagoColegiatura> listPago_colegiaturas;

    public Estudiante() {
    }

    public Estudiante(Long id, String nombre, LocalDate fecha_nacimiento, Aula aula, Matricula matricula, List<PagoColegiatura> listPago_colegiaturas) {
        this.id = id;
        this.nombre = nombre;
        this.fecha_nacimiento = fecha_nacimiento;
        this.aula = aula;
        this.matricula = matricula;
        this.listPago_colegiaturas = listPago_colegiaturas;
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
    
    public void agregarPagoColegiatura(PagoColegiatura pago) {
        listPago_colegiaturas.add(pago);
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

    public List<PagoColegiatura> getListPago_colegiaturas() {
        return listPago_colegiaturas;
    }

    public void setListPago_colegiaturas(List<PagoColegiatura> listPago_colegiaturas) {
        this.listPago_colegiaturas = listPago_colegiaturas;
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
        hash = 23 * hash + Objects.hashCode(this.listPago_colegiaturas);
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
        return Objects.equals(this.listPago_colegiaturas, other.listPago_colegiaturas);
    }

    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + ", nombre=" + nombre + ", fecha_nacimiento=" + fecha_nacimiento + ", edad=" + edad + ", aula=" + aula + ", matricula=" + matricula + ", pago_colegiatura=" + listPago_colegiaturas + '}';
    }
}

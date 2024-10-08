package com.mycompany.gestion_alumnos.LOGICA;

import java.io.Serializable;
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

/**
 *
 * Created by Frame-Code, September 2024
 */
@Entity(name = "AULA")
public class Aula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE", length = 15, nullable = false)
    private String nombre;

    @Column(name = "ASIENTOS_TOTALES")
    private Integer numeroAsientosTotales;
    
    @Column(name = "ASIENTOS_DISPONIBLES")
    private Integer numeroAsientosDisponibles;

    @ManyToOne
    @JoinColumn(name = "CURSO_ID")
    private Curso curso;

    @OneToMany(mappedBy = "aula")
    private List<Estudiante> listEstudiantes;

    public Aula() {
    }

    public Aula(Long id, String nombre, Integer numeroAsientosTotales, Curso curso, List<Estudiante> listEstudiantes) {
        this.id = id;
        this.nombre = nombre;
        this.numeroAsientosTotales = numeroAsientosTotales;
        this.curso = curso;
        this.listEstudiantes = listEstudiantes;
    }
    
    public void agregarEstudiante(Estudiante estudiante) {
        listEstudiantes.add(estudiante);
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

    public Integer getNumeroAsientosTotales() {
        return numeroAsientosTotales;
    }

    public void setNumeroAsientosTotales(Integer numeroAsientosTotales) {
        this.numeroAsientosTotales = numeroAsientosTotales;
    }

    public Integer getNumeroAsientosDisponibles() {
        return numeroAsientosDisponibles;
    }

    public void setNumeroAsientosDisponibles() {
        this.numeroAsientosDisponibles = numeroAsientosTotales - listEstudiantes.size();
    }
    
    public void setNumeroAsientosDisponibles(Integer numeroAsientosDisponibles) {
        this.numeroAsientosDisponibles = numeroAsientosDisponibles;
    }
    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Estudiante> getListEstudiantes() {
        return listEstudiantes;
    }

    public void setListEstudiantes(List<Estudiante> listEstudiantes) {
        this.listEstudiantes = listEstudiantes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.id);
        hash = 13 * hash + Objects.hashCode(this.nombre);
        hash = 13 * hash + Objects.hashCode(this.numeroAsientosTotales);
        hash = 13 * hash + Objects.hashCode(this.numeroAsientosDisponibles);
        hash = 13 * hash + Objects.hashCode(this.curso);
        hash = 13 * hash + Objects.hashCode(this.listEstudiantes);
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
        final Aula other = (Aula) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.numeroAsientosTotales, other.numeroAsientosTotales)) {
            return false;
        }
        if (!Objects.equals(this.numeroAsientosDisponibles, other.numeroAsientosDisponibles)) {
            return false;
        }
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        return Objects.equals(this.listEstudiantes, other.listEstudiantes);
    }

    @Override
    public String toString() {
        return "Aula{" + "id=" + id + ", nombre=" + nombre + ", numeroAsientosTotales=" + numeroAsientosTotales + ", numeroAsientosDisponibles=" + numeroAsientosDisponibles + ", curso=" + curso + '}';
    }
    
}

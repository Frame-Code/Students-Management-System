package com.mycompany.gestion_alumnos.LOGICA;

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
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE", length = 15, nullable = false)
    private String nombre;

    @Column(name = "NUMERO_ASIENTOS")
    private Integer numeroAsientos;

    @ManyToOne
    @JoinColumn(name = "CURSO")
    private Curso curso;

    @OneToMany(mappedBy = "aula")
    private List<Estudiante> estudiantes;

    public Aula() {
    }

    public Aula(Long id, String nombre, Integer numeroAsientos, Curso curso, List<Estudiante> estudiantes) {
        this.id = id;
        this.nombre = nombre;
        this.numeroAsientos = numeroAsientos;
        this.curso = curso;
        this.estudiantes = estudiantes;
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

    public Integer getNumeroAsientos() {
        return numeroAsientos;
    }

    public void setNumeroAsientos(Integer numeroAsientos) {
        this.numeroAsientos = numeroAsientos;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + Objects.hashCode(this.numeroAsientos);
        hash = 97 * hash + Objects.hashCode(this.curso);
        hash = 97 * hash + Objects.hashCode(this.estudiantes);
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
        if (!Objects.equals(this.numeroAsientos, other.numeroAsientos)) {
            return false;
        }
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        return Objects.equals(this.estudiantes, other.estudiantes);
    }

    @Override
    public String toString() {
        return "Aula{" + "id=" + id + ", nombre=" + nombre + ", numeroAsientos=" + numeroAsientos + ", curso=" + curso + ", estudiantes=" + estudiantes + '}';
    }
}

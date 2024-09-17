package com.mycompany.gestion_alumnos.LOGICA;

import java.util.List;
import java.util.Objects;

/**
 *
 * Created by Frame-Code, September 2024
 */
public class Curso {
    private Long id;
    private String nombre;
    private List<Aula> aulas;
    private List<Materia> materias;

    public Curso() {
    }
    public Curso(Long id, String nombre, List<Aula> aulas, List<Materia> materias) {
        this.id = id;
        this.nombre = nombre;
        this.aulas = aulas;
        this.materias = materias;
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

    public List<Aula> getAulas() {
        return aulas;
    }
    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    public List<Materia> getMaterias() {
        return materias;
    }
    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.aulas);
        hash = 53 * hash + Objects.hashCode(this.materias);
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
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.aulas, other.aulas)) {
            return false;
        }
        return Objects.equals(this.materias, other.materias);
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", nombre=" + nombre + ", aulas=" + aulas + ", materias=" + materias + '}';
    }
}

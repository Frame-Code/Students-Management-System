package com.mycompany.gestion_alumnos.LOGICA;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * Created by Frame-Code, September 2024
 */
@Entity(name = "CURSO")
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE", length = 15, nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "curso")
    private List<Aula> listAulas;

    @OneToMany(mappedBy = "curso")
    private List<Materia> listMaterias;

    public Curso() {
    }

    public Curso(Long id, String nombre, List<Aula> listAulas, List<Materia> listMaterias) {
        this.id = id;
        this.nombre = nombre;
        this.listAulas = listAulas;
        this.listMaterias = listMaterias;
    }
    
    public void agregarAula(Aula aula) {
        listAulas.add(aula);
    }
    
    public void agregarMateria(Materia materia) {
        listMaterias.add(materia);
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

    public List<Aula> getListAulas() {
        return listAulas;
    }

    public void setListAulas(List<Aula> listAulas) {
        this.listAulas = listAulas;
    }

    public List<Materia> getListMaterias() {
        return listMaterias;
    }

    public void setListMaterias(List<Materia> listMaterias) {
        this.listMaterias = listMaterias;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.listAulas);
        hash = 53 * hash + Objects.hashCode(this.listMaterias);
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
        if (!Objects.equals(this.listAulas, other.listAulas)) {
            return false;
        }
        return Objects.equals(this.listMaterias, other.listMaterias);
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", nombre=" + nombre + ", aulas=" + listAulas + ", materias=" + listMaterias + '}';
    }
}

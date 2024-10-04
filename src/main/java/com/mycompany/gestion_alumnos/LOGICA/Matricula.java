package com.mycompany.gestion_alumnos.LOGICA;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * Created by Frame-Code, September 2024
 */
@Entity(name = "MATRICULA")
public class Matricula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "FECHA_MATRICULACION", nullable = false)
    private LocalDate fecha_matriculacion;

    @Column(name = "FECHA_VENCIMIENTO", nullable = false)
    private LocalDate fecha_vencimiento;

    @Column(name = "ESTADO", nullable = false)
    private String estado;

    @Column(name = "VALOR_PAGADO", nullable = false)
    private String valor_pagado;

    public Matricula() {
    }

    public Matricula(Long id, LocalDate fecha_matriculacion, LocalDate fecha_vencimiento, String estado, String valor_pagado) {
        this.id = id;
        this.fecha_matriculacion = fecha_matriculacion;
        this.fecha_vencimiento = fecha_vencimiento;
        this.estado = estado;
        this.valor_pagado = valor_pagado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha_matriculacion() {
        return fecha_matriculacion;
    }

    public void setFecha_matriculacion(LocalDate fecha_matriculacion) {
        this.fecha_matriculacion = fecha_matriculacion;
    }

    public LocalDate getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(LocalDate fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getValor_pagado() {
        return valor_pagado;
    }

    public void setValor_pagado(String valor_pagado) {
        this.valor_pagado = valor_pagado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        hash = 89 * hash + Objects.hashCode(this.fecha_matriculacion);
        hash = 89 * hash + Objects.hashCode(this.fecha_vencimiento);
        hash = 89 * hash + Objects.hashCode(this.estado);
        hash = 89 * hash + Objects.hashCode(this.valor_pagado);
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
        final Matricula other = (Matricula) obj;
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.valor_pagado, other.valor_pagado)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fecha_matriculacion, other.fecha_matriculacion)) {
            return false;
        }
        return Objects.equals(this.fecha_vencimiento, other.fecha_vencimiento);
    }

    @Override
    public String toString() {
        return "Matricula{" + "id=" + id + ", fecha_matriculacion=" + fecha_matriculacion + ", fecha_vencimiento=" + fecha_vencimiento + ", estado=" + estado + ", valor_pagado=" + valor_pagado + '}';
    }

}

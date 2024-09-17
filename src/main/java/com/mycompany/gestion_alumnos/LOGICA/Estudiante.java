package com.mycompany.gestion_alumnos.LOGICA;

import java.time.LocalDate;
import java.util.List;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * Created by Frame-Code, September 2024
 */
class Estudiante {
    private Long id;
    private String nombre;
    private LocalDate fecha_nacimiento;
    private static final Integer edad = LocalDate.now().getYear();
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
        edad = (fe)
    }
    
    
    
    
            
}

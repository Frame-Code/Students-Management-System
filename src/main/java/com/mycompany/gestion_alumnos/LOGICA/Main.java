package com.mycompany.gestion_alumnos.LOGICA;

import com.mycompany.gestion_alumnos.GUI.Principal;
import java.time.LocalDate;
    
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Controladora control = new Controladora();
        if(control.leerListInstitucion().isEmpty()) {
            control.crearInstitucion("Example", "Example", "1", 1, LocalDate.now(), LocalDate.now());
        }
        Principal principal = new Principal(control);
        principal.setResizable(false);
        principal.setSize(1080, 720);
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
    }
}

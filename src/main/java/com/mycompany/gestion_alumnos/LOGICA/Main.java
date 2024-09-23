package com.mycompany.gestion_alumnos.LOGICA;

import com.mycompany.gestion_alumnos.GUI.Principal;
    
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Controladora control = new Controladora();
        
        Principal principal = new Principal();
        principal.setResizable(false);
        principal.setSize(1080, 720);
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
    }
}

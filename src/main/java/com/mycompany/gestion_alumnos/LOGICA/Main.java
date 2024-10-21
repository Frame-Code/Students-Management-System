package com.mycompany.gestion_alumnos.LOGICA;

import com.mycompany.gestion_alumnos.DAO.ControlDAO;
import com.mycompany.gestion_alumnos.GUI.Principal;
    
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        ControlDAO control = new ControlDAO();
        control.inicializar();
        
        Principal principal = new Principal(control);
        principal.setResizable(false);
        principal.setSize(1080, 720);
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
    }
}

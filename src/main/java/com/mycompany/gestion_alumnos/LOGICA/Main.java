package com.mycompany.gestion_alumnos.LOGICA;

//Library to manage enviroments variables .env
import io.github.cdimascio.dotenv.Dotenv;
import com.mycompany.gestion_alumnos.GUI.Principal;
    
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Dotenv dotenv = Dotenv.configure().load();
        
        Principal principal = new Principal();
        principal.setResizable(false);
        principal.setSize(1080, 720);
        principal.setVisible(true);
        principal.setLocationRelativeTo(null);
        
    }
}

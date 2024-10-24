package com.mycompany.gestion_alumnos.GUI;

import com.mycompany.gestion_alumnos.DAO.ControlDAO;
import java.awt.Component;
import javax.swing.JComboBox;

/**
 *
 * @author artist-code
 */
public interface Utils {
    public ControlDAO controladora = new ControlDAO();
    public Long ID_INSTITUCION = controladora.getInstitucionI().leerListEntidad().get(controladora.getInstitucionI().leerListEntidad().size()-1).getId();
    
    
    default String obtenerMesPorNumero(int mes) {
        if (mes == 1) {
            return "Enero";
        } else if(mes == 2) {
            return "Febrero";
        } else if(mes == 3) {
            return "Marzo";
        } else if(mes == 4) {
            return "Abril";
        } else if(mes == 5) {
            return "Mayo";
        } else if(mes == 6) {
            return "Junio";
        } else if(mes == 7) {
            return "Julio";
        } else if(mes == 8) {
            return "Agosto";
        } else if(mes == 9) {
            return "Septiembre";
        } else if(mes == 10) {
            return "Octubre";
        } else if(mes == 11) {
            return "Noviembre";
        } else if(mes == 12) {
            return "Diciembre";
        }
        return null;
    }
    
    default int obtenerMes(String mes) {
        if (mes.equals("Enero")) {
            return 1;
        } else if (mes.equals("Febrero")) {
            return 2;
        } else if (mes.equals("Marzo")) {
            return 3;
        } else if (mes.equals("Abril")) {
            return 4;
        } else if (mes.equals("Mayo")) {
            return 5;
        } else if (mes.equals("Junio")) {
            return 6;
        } else if (mes.equals("Julio")) {
            return 7;
        } else if (mes.equals("Agosto")) {
            return 8;
        } else if (mes.equals("Septiembre")) {
            return 9;
        } else if (mes.equals("Octubre")) {
            return 10;
        } else if (mes.equals("Noviembre")) {
            return 11;
        } else if (mes.equals("Diciembre")) {
            return 12;
        }
        return 0;
    }

    default boolean isString(String nombre, Component component) {
        try {
            Integer.valueOf(nombre);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }
    
    default boolean isNumber(String number) {
        try {
            Long.valueOf(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    
    default boolean isEmptyCombo(JComboBox cmb) {
        int cantidadElementos = 0;
        for (int i = 0; i < cmb.getItemCount(); i++) {
            cantidadElementos++;
        }
        return (cantidadElementos == 0);
    }
}

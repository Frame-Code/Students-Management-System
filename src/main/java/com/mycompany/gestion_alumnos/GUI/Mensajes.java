package com.mycompany.gestion_alumnos.GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author artist-code
 */
public interface Mensajes {

    public static final Object optionSi = UIManager.put("OptionPane.yesButtonText", "Sí");
    public static final Object optionNO = UIManager.put("OptionPane.noButtonText", "No");
    public static final Object optionCancelar = UIManager.put("OptionPane.cancelButtonText", "Cancelar");
    public static final Object optionOk = UIManager.put("OptionPane.okButtonText", "Aceptar");
    public static final Object btnBackgroung = UIManager.put("Button.background", new Color(63, 72, 100));  // Color de fondo
    public static final Object btnForeground = UIManager.put("Button.foreground", new Color(255, 255, 255)); // Color de texto
    public static final Object btnFont = UIManager.put("Button.font", new Font("Waree", 1, 12)); // Cambiar la fuente
    public static final String CANCELADO = "Cancelado";
    public static final Integer SI = 0;
    public static final Integer NO = 1;
    public static final Integer CANCELAR = 2;

    default int confirmarInformacion(Component component, String mensaje, String titulo) {
        int respuesta = JOptionPane.showConfirmDialog(component, mensaje, titulo, JOptionPane.YES_NO_CANCEL_OPTION);
        switch (respuesta) {
            case JOptionPane.YES_OPTION -> {
                return 0;
            }
            case JOptionPane.NO_OPTION -> {
                return 1;
            }
            case JOptionPane.CANCEL_OPTION -> {
                return 2;
            }
            default -> {
                break;
            }
        }
        return 1;
    }

    default void mostrarInformacion(Component component, String mensaje, String titulo) {
        JOptionPane.showMessageDialog(component, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    
    default String obtenerInformacion(Component componente, String mensaje, String titulo) {
        String respuesta = JOptionPane.showInputDialog(componente, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
        if(respuesta == optionCancelar) {
            respuesta = "Cancelado";
        }
        return respuesta;
    }

}

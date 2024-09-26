package com.mycompany.gestion_alumnos.GUI;

import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author artist-code
 */
public interface CargarTablas {

    default DefaultTableModel obtenerModeloTabla() {
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        return modeloTabla;
    }

    default DefaultTableModel cargarTabla(String titulos[]) {
        DefaultTableModel modeloTabla = obtenerModeloTabla();
        modeloTabla.setColumnIdentifiers(titulos);
        return modeloTabla;
    }
}

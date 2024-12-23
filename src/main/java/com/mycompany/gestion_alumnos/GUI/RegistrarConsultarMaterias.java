package com.mycompany.gestion_alumnos.GUI;

import com.mycompany.gestion_alumnos.DAO.ControlDAO;
import com.mycompany.gestion_alumnos.LOGICA.Materia;
import java.awt.Color;

/**
 *
 * @author Frame-Code
 */
public class RegistrarConsultarMaterias extends javax.swing.JPanel implements Mensajes, Utils, ModeloTabla {

    private final ControlDAO control;

    public RegistrarConsultarMaterias() {
        this.control = new ControlDAO();
        initComponents();
        cargarTabla();
    }

    public RegistrarConsultarMaterias(ControlDAO control) {
        this.control = control;
        this.initComponents();
        if (!control.getMateriaI().leerListEntidad().isEmpty()) {
            this.cargarTabla();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMaterias = new javax.swing.JTable();
        lblMatricula3 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnRegistrarMateria = new javax.swing.JButton();
        btnEditarMateria = new javax.swing.JButton();
        btnEliminarMateria = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(196, 196, 196));
        setPreferredSize(new java.awt.Dimension(761, 657));

        jLabel1.setFont(new java.awt.Font("Waree", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(23, 23, 23));
        jLabel1.setText("REGISTRAR - CONSULTAR MATERIAS");

        jPanel4.setBackground(new java.awt.Color(180, 180, 180));

        tblMaterias.setBackground(new java.awt.Color(180, 180, 180));
        tblMaterias.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(23, 23, 23), 1, true));
        tblMaterias.setFont(new java.awt.Font("Waree", 0, 12)); // NOI18N
        tblMaterias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblMaterias);

        lblMatricula3.setFont(new java.awt.Font("Waree", 1, 12)); // NOI18N
        lblMatricula3.setForeground(new java.awt.Color(71, 71, 71));
        lblMatricula3.setText("Selecciona una materia para editarla o eliminarla");

        btnActualizar.setBackground(new java.awt.Color(63, 72, 100));
        btnActualizar.setFont(new java.awt.Font("Waree", 1, 12)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("Actualizar datos");
        btnActualizar.setBorder(null);
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnActualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnActualizarMouseExited(evt);
            }
        });
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblMatricula3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatricula3)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(180, 180, 180));

        btnRegistrarMateria.setBackground(new java.awt.Color(63, 72, 100));
        btnRegistrarMateria.setFont(new java.awt.Font("Waree", 1, 12)); // NOI18N
        btnRegistrarMateria.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarMateria.setText("Registrar nueva Materia");
        btnRegistrarMateria.setBorder(null);
        btnRegistrarMateria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrarMateriaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarMateriaMouseExited(evt);
            }
        });
        btnRegistrarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarMateriaActionPerformed(evt);
            }
        });

        btnEditarMateria.setBackground(new java.awt.Color(63, 72, 100));
        btnEditarMateria.setFont(new java.awt.Font("Waree", 1, 12)); // NOI18N
        btnEditarMateria.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarMateria.setText("Editar Materia");
        btnEditarMateria.setBorder(null);
        btnEditarMateria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditarMateriaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditarMateriaMouseExited(evt);
            }
        });
        btnEditarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarMateriaActionPerformed(evt);
            }
        });

        btnEliminarMateria.setBackground(new java.awt.Color(165, 80, 80));
        btnEliminarMateria.setFont(new java.awt.Font("Waree", 1, 12)); // NOI18N
        btnEliminarMateria.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarMateria.setText("Eliminar Materia");
        btnEliminarMateria.setBorder(null);
        btnEliminarMateria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMateriaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMateriaMouseExited(evt);
            }
        });
        btnEliminarMateria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarMateriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrarMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(btnEditarMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btnEliminarMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel17.setForeground(new java.awt.Color(99, 99, 99));
        jLabel17.setText("_________________________________________________Materias registradas________________________________________________");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel17)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(194, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //Method to upload the JTable "tblMaterias" with all subjects from the data base
    private void cargarTabla() {
        tblMaterias.setModel(obtenerModeloTablaMaterias(new String[]{"ID", "MATERIA"}, control.getMateriaI().leerListEntidad()));
        tblMaterias.setRowHeight(20);
    }
    
    //Listener of the button "btnRegistrarMateria" to create a new Subject
    private void btnRegistrarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarMateriaActionPerformed
        String nombreMateria;
        do {
            nombreMateria = obtenerInformacion(this, "Escribe el nombre de la materia", "Registar nueva materia");
            if (!nombreMateria.equals(CANCELADO)) {
                if (nombreMateria.equals("")) {
                    mostrarInformacion(this, "No pueden haber campos vacios", "Error");
                    nombreMateria = null;
                } else {
                    if (isString(nombreMateria, this) && control.getCursoI().verificarNombreDisponible(nombreMateria, control.getMateriaI().leerListEntidad(), Materia::getNombre)) {
                        control.getMateriaI().crearMateria(nombreMateria);
                        mostrarInformacion(this, "Materia guardada correctamente", "Registro de materia exitoso");
                    } else {
                        if (!control.getCursoI().verificarNombreDisponible(nombreMateria, control.getMateriaI().leerListEntidad(), Materia::getNombre)) {
                            mostrarInformacion(this, "La materia " + nombreMateria + " ya existe", "Error");
                        }
                        nombreMateria = null;
                    }
                }
            } else {
                break;
            }
        } while (nombreMateria == null);
        cargarTabla();
    }//GEN-LAST:event_btnRegistrarMateriaActionPerformed

    //Listener of the button "btnEditarMateria" to edit the name of a subject selected
    private void btnEditarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarMateriaActionPerformed
        String nuevoNombre;
        if (tblMaterias.getRowCount() > 0) {
            if (tblMaterias.getSelectedRow() != -1) {
                do {
                    nuevoNombre = obtenerInformacion(this, "Escribe el nuevo nombre de la materia", "Editar materia");
                    if (!nuevoNombre.equals(CANCELADO)) {
                        if (nuevoNombre.equals("")) {
                            mostrarInformacion(this, "No pueden haber campos vacios", "Error");
                            nuevoNombre = null;
                        } else {
                            if (isString(nuevoNombre, this)) {
                                long idAntiguoNombre = (long) tblMaterias.getValueAt(tblMaterias.getSelectedRow(), 0);
                                control.getMateriaI().editarMateria(nuevoNombre, idAntiguoNombre);
                                mostrarInformacion(this, "Materia editada correctamente", "Editar materia ");
                                cargarTabla();
                            } else {
                                nuevoNombre = null;
                            }
                        }
                    } else {
                        break;
                    }
                } while (nuevoNombre == null);
            } else {
                mostrarInformacion(this, "Selecciona una materia por favor", "Error");
            }
        } else {
            mostrarInformacion(this, "Tabla vacia", "Error");
        }
    }//GEN-LAST:event_btnEditarMateriaActionPerformed
    
    //Listener of the button "btnEliminarMateria" to delete a subject selected
    private void btnEliminarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMateriaActionPerformed
        if (tblMaterias.getRowCount() > 0) {
            if (tblMaterias.getSelectedRow() != -1) {
                int respuesta = confirmarInformacion(this, "¿Seguro deseas eliminar la materia?", "Eliminar materia");
                if (respuesta == SI) {
                    long idMateria = (long) tblMaterias.getValueAt(tblMaterias.getSelectedRow(), 0);
                    control.getMateriaI().eliminar(idMateria);
                    mostrarInformacion(this, "Materia eliminada correctamente", "Materia eliminada!");
                }
                cargarTabla();
            } else {
                mostrarInformacion(this, "Selecciona una materia por favor", "Error");
            }
        } else {
            mostrarInformacion(this, "Tabla vacia", "Error");
        }
    }//GEN-LAST:event_btnEliminarMateriaActionPerformed
    
    //----------Listeners -----------
    private void btnRegistrarMateriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMateriaMouseEntered
        btnRegistrarMateria.setBackground(new Color(78, 90, 126));
    }//GEN-LAST:event_btnRegistrarMateriaMouseEntered

    private void btnRegistrarMateriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarMateriaMouseExited
        btnRegistrarMateria.setBackground(new Color(63, 72, 100));
    }//GEN-LAST:event_btnRegistrarMateriaMouseExited

    private void btnEditarMateriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMateriaMouseEntered
        btnEditarMateria.setBackground(new Color(78, 90, 126));
    }//GEN-LAST:event_btnEditarMateriaMouseEntered

    private void btnEditarMateriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMateriaMouseExited
        btnEditarMateria.setBackground(new Color(63, 72, 100));
    }//GEN-LAST:event_btnEditarMateriaMouseExited

    private void btnEliminarMateriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMateriaMouseEntered
        btnEliminarMateria.setBackground(new Color(201, 119, 119));
    }//GEN-LAST:event_btnEliminarMateriaMouseEntered

    private void btnEliminarMateriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMateriaMouseExited
        btnEliminarMateria.setBackground(new Color(165, 80, 80));
    }//GEN-LAST:event_btnEliminarMateriaMouseExited

    private void btnActualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseEntered
        btnEditarMateria.setBackground(new Color(78, 90, 126));
    }//GEN-LAST:event_btnActualizarMouseEntered

    private void btnActualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseExited
        btnEditarMateria.setBackground(new Color(63, 72, 100));
    }//GEN-LAST:event_btnActualizarMouseExited

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarTabla();
    }//GEN-LAST:event_btnActualizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEditarMateria;
    private javax.swing.JButton btnEliminarMateria;
    private javax.swing.JButton btnRegistrarMateria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMatricula3;
    private javax.swing.JTable tblMaterias;
    // End of variables declaration//GEN-END:variables
}

package com.mycompany.gestion_alumnos.GUI;

import com.mycompany.gestion_alumnos.DAO.ControlDAO;
import java.awt.Color;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Frame-Code
 */
public class CrearPago extends javax.swing.JFrame implements ModeloTabla, Mensajes, Utils {

    private ControlDAO control;
    private Long idEstudiante;
    private VerEditarEstudiante verEditarEstudiante;

    public CrearPago() {
        initComponents();
    }

    public CrearPago(ControlDAO control, Long idEstudiante, VerEditarEstudiante verEditarEstudiante) {
        this.control = control;
        this.idEstudiante = idEstudiante;
        this.verEditarEstudiante = verEditarEstudiante;
        this.setResizable(false);
        this.initComponents();
        this.cargarNombre();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipalData = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblMatricula3 = new javax.swing.JLabel();
        lblMatricula4 = new javax.swing.JLabel();
        int valorInicialModelPago = 1;
        if (!control.getInstitucionI().leerListEntidad().isEmpty()) {
            valorInicialModelPago = Integer.valueOf(control.getInstitucionI().leerEntidad(ID_INSTITUCION).getCostoColegiatura());
        }

        SpinnerNumberModel model = new SpinnerNumberModel(valorInicialModelPago, 1, 70, 1);
        spnMontoPagar = new javax.swing.JSpinner(model);
        jLabel13 = new javax.swing.JLabel();
        String meses[] = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" };
        cmbMes = new javax.swing.JComboBox<>();
        lblCurso = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnGenerarPago = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        lblEstudiante = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPrincipalData.setBackground(new java.awt.Color(196, 196, 196));
        pnlPrincipalData.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Waree", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(23, 23, 23));
        jLabel1.setText("Generar Pago");

        jPanel4.setBackground(new java.awt.Color(180, 180, 180));

        lblMatricula3.setFont(new java.awt.Font("Waree", 1, 12)); // NOI18N
        lblMatricula3.setForeground(new java.awt.Color(71, 71, 71));
        lblMatricula3.setText("Selecciona el mes");

        lblMatricula4.setFont(new java.awt.Font("Waree", 1, 12)); // NOI18N
        lblMatricula4.setForeground(new java.awt.Color(71, 71, 71));
        lblMatricula4.setText("Escribe el monto a pagar");

        spnMontoPagar.setBorder(null);
        spnMontoPagar.setOpaque(false);

        jLabel13.setFont(new java.awt.Font("Waree", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(23, 23, 23));
        jLabel13.setText("$");

        cmbMes.setBackground(new java.awt.Color(180, 180, 180));
        cmbMes.setFont(new java.awt.Font("Waree", 0, 12)); // NOI18N
        cmbMes.setModel(new javax.swing.DefaultComboBoxModel<>(meses));
        if (!control.getInstitucionI().leerListEntidad().isEmpty()) {
            cmbMes.setSelectedItem(obtenerMesPorNumero(control.getInstitucionI().leerEntidad(ID_INSTITUCION).getFechaFinalCiclo().getMonthValue()));
        }
        cmbMes.setBorder(null);
        cmbMes.setOpaque(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(spnMontoPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMatricula3)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cmbMes, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMatricula4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblMatricula3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMatricula4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnMontoPagar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        lblCurso.setFont(new java.awt.Font("Waree", 1, 16)); // NOI18N
        lblCurso.setForeground(new java.awt.Color(23, 23, 23));
        lblCurso.setText("Estudiante:");

        jPanel2.setBackground(new java.awt.Color(180, 180, 180));

        btnGenerarPago.setBackground(new java.awt.Color(63, 72, 100));
        btnGenerarPago.setFont(new java.awt.Font("Waree", 1, 12)); // NOI18N
        btnGenerarPago.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarPago.setText("Generar nuevo pago");
        btnGenerarPago.setBorder(null);
        btnGenerarPago.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGenerarPagoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGenerarPagoMouseExited(evt);
            }
        });
        btnGenerarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGenerarPago, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGenerarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRegresar.setBackground(new java.awt.Color(63, 72, 100));
        btnRegresar.setFont(new java.awt.Font("Waree", 1, 12)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("<-- Regresar");
        btnRegresar.setBorder(null);
        btnRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegresarMouseExited(evt);
            }
        });
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        lblEstudiante.setFont(new java.awt.Font("Waree", 0, 11)); // NOI18N
        lblEstudiante.setForeground(new java.awt.Color(23, 23, 23));
        lblEstudiante.setText("estudiante");

        javax.swing.GroupLayout pnlPrincipalDataLayout = new javax.swing.GroupLayout(pnlPrincipalData);
        pnlPrincipalData.setLayout(pnlPrincipalDataLayout);
        pnlPrincipalDataLayout.setHorizontalGroup(
            pnlPrincipalDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalDataLayout.createSequentialGroup()
                .addGroup(pnlPrincipalDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalDataLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel1))
                    .addGroup(pnlPrincipalDataLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPrincipalDataLayout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPrincipalDataLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(pnlPrincipalDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPrincipalDataLayout.createSequentialGroup()
                                .addComponent(lblCurso)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        pnlPrincipalDataLayout.setVerticalGroup(
            pnlPrincipalDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPrincipalDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurso)
                    .addComponent(lblEstudiante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipalData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipalData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Method to upload the name of the Student selected
    private void cargarNombre() {
        lblEstudiante.setText(control.getEstudianteI().leerEntidad(idEstudiante).getNombre());
    }

    @Override
    public void dispose() {
        super.dispose();
        verEditarEstudiante.cargarDatos();
    }
    
    //Listener of the button "btnGenerarPago" to create a new tuition to a student
    private void btnGenerarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPagoActionPerformed
        int montoColegiatura = (int) spnMontoPagar.getValue();
        control.getPagoI().crearPago(montoColegiatura, (String) cmbMes.getSelectedItem(), idEstudiante);
        control.getEstudianteI().verificarEstadoMatricula(idEstudiante);
        mostrarInformacion(this, "Pago generado correctamente", "Exito");
        this.dispose();
        verEditarEstudiante.cargarDatos();
    }//GEN-LAST:event_btnGenerarPagoActionPerformed
    
    //--------Listeners------//
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        verEditarEstudiante.cargarDatos();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnGenerarPagoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarPagoMouseEntered
        btnGenerarPago.setBackground(new Color(78, 90, 126));
    }//GEN-LAST:event_btnGenerarPagoMouseEntered

    private void btnGenerarPagoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarPagoMouseExited
        btnGenerarPago.setBackground(new Color(63, 72, 100));
    }//GEN-LAST:event_btnGenerarPagoMouseExited

    private void btnRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseEntered
        btnRegresar.setBackground(new Color(78, 90, 126));
    }//GEN-LAST:event_btnRegresarMouseEntered

    private void btnRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseExited
        btnRegresar.setBackground(new Color(63, 72, 100));
    }//GEN-LAST:event_btnRegresarMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarPago;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblEstudiante;
    private javax.swing.JLabel lblMatricula3;
    private javax.swing.JLabel lblMatricula4;
    private javax.swing.JPanel pnlPrincipalData;
    private javax.swing.JSpinner spnMontoPagar;
    // End of variables declaration//GEN-END:variables

}

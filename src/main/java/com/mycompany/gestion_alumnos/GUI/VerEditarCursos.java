package com.mycompany.gestion_alumnos.GUI;

import com.mycompany.gestion_alumnos.LOGICA.Aula;
import com.mycompany.gestion_alumnos.LOGICA.Controladora;
import com.mycompany.gestion_alumnos.LOGICA.Curso;
import com.mycompany.gestion_alumnos.LOGICA.Materia;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Frame-Code
 */
public class VerEditarCursos extends javax.swing.JFrame implements ModeloTabla, Mensajes, Utils {

    private Long idCurso;
    private Controladora control;
    private AgregarMaterias frameAgregarMaterias;
    private RegistrarConsultarCursos consultarCursos;

    public VerEditarCursos() {
        initComponents();
        frameAgregarMaterias = new AgregarMaterias();
    }

    public VerEditarCursos(Controladora control, Long idCurso, RegistrarConsultarCursos consultarCursos) {
        this.control = control;
        this.idCurso = idCurso;
        this.consultarCursos = consultarCursos;
        this.initComponents();
        this.cargarNombre();
        if(!control.leerListAulas().isEmpty()) {   
            this.cargarTablaAulas();
        }
        if(!control.leerListMaterias().isEmpty()) {
            this.cargarTablaMaterias();
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

        pnlPrincipalData = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMaterias = new javax.swing.JTable();
        lblMatricula3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAulas = new javax.swing.JTable();
        lblMatricula4 = new javax.swing.JLabel();
        lblCurso = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAgregarMaterias = new javax.swing.JButton();
        btnEliminarMateria = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnCrearAula = new javax.swing.JButton();
        btnEliminarAula = new javax.swing.JButton();
        btnCambiarNombreAula = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        lblNombreCurso = new javax.swing.JLabel();
        btnCambiarNombre = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPrincipalData.setBackground(new java.awt.Color(196, 196, 196));
        pnlPrincipalData.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Waree", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(23, 23, 23));
        jLabel1.setText("___________CONSULTAR CURSO_________");

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
        lblMatricula3.setText("Materias ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(lblMatricula3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lblMatricula3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(180, 180, 180));

        tblAulas.setBackground(new java.awt.Color(180, 180, 180));
        tblAulas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(23, 23, 23), 1, true));
        tblAulas.setFont(new java.awt.Font("Waree", 0, 12)); // NOI18N
        tblAulas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblAulas);

        lblMatricula4.setFont(new java.awt.Font("Waree", 1, 12)); // NOI18N
        lblMatricula4.setForeground(new java.awt.Color(71, 71, 71));
        lblMatricula4.setText("Aulas");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(lblMatricula4)
                .addContainerGap(205, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lblMatricula4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblCurso.setFont(new java.awt.Font("Waree", 1, 16)); // NOI18N
        lblCurso.setForeground(new java.awt.Color(23, 23, 23));
        lblCurso.setText("CURSO: ");

        jPanel2.setBackground(new java.awt.Color(180, 180, 180));

        btnAgregarMaterias.setBackground(new java.awt.Color(63, 72, 100));
        btnAgregarMaterias.setFont(new java.awt.Font("Waree", 1, 12)); // NOI18N
        btnAgregarMaterias.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarMaterias.setText("Agregar materias");
        btnAgregarMaterias.setBorder(null);
        btnAgregarMaterias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgregarMateriasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgregarMateriasMouseExited(evt);
            }
        });
        btnAgregarMaterias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarMateriasActionPerformed(evt);
            }
        });

        btnEliminarMateria.setBackground(new java.awt.Color(165, 80, 80));
        btnEliminarMateria.setFont(new java.awt.Font("Waree", 1, 12)); // NOI18N
        btnEliminarMateria.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarMateria.setText("Eliminar Materia/s");
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregarMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAgregarMaterias, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarMateria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(180, 180, 180));

        btnCrearAula.setBackground(new java.awt.Color(63, 72, 100));
        btnCrearAula.setFont(new java.awt.Font("Waree", 1, 12)); // NOI18N
        btnCrearAula.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearAula.setText("Crear aula");
        btnCrearAula.setBorder(null);
        btnCrearAula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCrearAulaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCrearAulaMouseExited(evt);
            }
        });
        btnCrearAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearAulaActionPerformed(evt);
            }
        });

        btnEliminarAula.setBackground(new java.awt.Color(165, 80, 80));
        btnEliminarAula.setFont(new java.awt.Font("Waree", 1, 12)); // NOI18N
        btnEliminarAula.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarAula.setText("Eliminar aula");
        btnEliminarAula.setBorder(null);
        btnEliminarAula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarAulaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarAulaMouseExited(evt);
            }
        });
        btnEliminarAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAulaActionPerformed(evt);
            }
        });

        btnCambiarNombreAula.setBackground(new java.awt.Color(63, 72, 100));
        btnCambiarNombreAula.setFont(new java.awt.Font("Waree", 1, 12)); // NOI18N
        btnCambiarNombreAula.setForeground(new java.awt.Color(255, 255, 255));
        btnCambiarNombreAula.setText("Cambiar nombre");
        btnCambiarNombreAula.setBorder(null);
        btnCambiarNombreAula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCambiarNombreAulaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCambiarNombreAulaMouseExited(evt);
            }
        });
        btnCambiarNombreAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarNombreAulaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEliminarAula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCrearAula, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(btnCambiarNombreAula, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCrearAula, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCambiarNombreAula, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarAula, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnRegresar.setBackground(new java.awt.Color(63, 72, 100));
        btnRegresar.setFont(new java.awt.Font("Waree", 1, 12)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegresar.setText("<- Regresar");
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

        lblNombreCurso.setFont(new java.awt.Font("Waree", 0, 15)); // NOI18N
        lblNombreCurso.setForeground(new java.awt.Color(23, 23, 23));
        lblNombreCurso.setText("CURSO");

        btnCambiarNombre.setBackground(new java.awt.Color(63, 72, 100));
        btnCambiarNombre.setFont(new java.awt.Font("Waree", 1, 12)); // NOI18N
        btnCambiarNombre.setForeground(new java.awt.Color(255, 255, 255));
        btnCambiarNombre.setText("Cambiar nombre curso");
        btnCambiarNombre.setBorder(null);
        btnCambiarNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCambiarNombreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCambiarNombreMouseExited(evt);
            }
        });
        btnCambiarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarNombreActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout pnlPrincipalDataLayout = new javax.swing.GroupLayout(pnlPrincipalData);
        pnlPrincipalData.setLayout(pnlPrincipalDataLayout);
        pnlPrincipalDataLayout.setHorizontalGroup(
            pnlPrincipalDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalDataLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
            .addGroup(pnlPrincipalDataLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(pnlPrincipalDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalDataLayout.createSequentialGroup()
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(167, 167, 167)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlPrincipalDataLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalDataLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlPrincipalDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPrincipalDataLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblCurso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCambiarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(196, 196, 196))
            .addGroup(pnlPrincipalDataLayout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPrincipalDataLayout.setVerticalGroup(
            pnlPrincipalDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPrincipalDataLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addGroup(pnlPrincipalDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCurso)
                    .addComponent(lblNombreCurso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCambiarNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPrincipalDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPrincipalDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlPrincipalDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
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

    private void btnAgregarMateriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarMateriasActionPerformed

        frameAgregarMaterias = new AgregarMaterias(control, idCurso, control.obtenerListMateriasDeCurso(idCurso), this);
        frameAgregarMaterias.setVisible(true);
        frameAgregarMaterias.setLocationRelativeTo(null);
        frameAgregarMaterias.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_btnAgregarMateriasActionPerformed

    private void btnEliminarMateriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarMateriaActionPerformed
        // TODO add your handling code here:
        List<Materia> listMateria = new ArrayList<>();

        if (tblMaterias.getRowCount() > 0) {
            for (int i = 0; i < tblMaterias.getRowCount(); i++) {
                boolean seleccionado = (boolean) tblMaterias.getValueAt(i, 0);
                if (seleccionado) {
                    listMateria.add(control.leerMateria((long) tblMaterias.getValueAt(i, 1)));
                }
            }
            if (listMateria.isEmpty()) {
                mostrarInformacion(this, "Selecciona al menos una materia", "Error");
            } else {
                int respuesta = confirmarInformacion(this, "¿Realmente deseas borrar la o las materias seleccionadas del curso?", "Confirmar");
                if (respuesta == SI) {
                    control.eliminarMateriasDeCurso(listMateria, idCurso, control.obtenerListMateriasDeCurso(idCurso));
                    mostrarInformacion(this, "Materia/s eliminada/s correctamente", "Materia/s eliminada/s!");
                    cargarTablaMaterias();
                }
            }
        } else {
            mostrarInformacion(this, "No existen materias para agregar", "Error");
        }
    }//GEN-LAST:event_btnEliminarMateriaActionPerformed

    private void btnCrearAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearAulaActionPerformed
        CrearAula crearAula = new CrearAula(control, idCurso, this);
        crearAula.setVisible(true);
        crearAula.setResizable(false);
        crearAula.setLocationRelativeTo(null);
        cargarTablaAulas();
        consultarCursos.recargarDatos();
    }//GEN-LAST:event_btnCrearAulaActionPerformed

    private void btnEliminarAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAulaActionPerformed
        if (tblAulas.getRowCount() > 0) {
            if (tblAulas.getSelectedRow() != -1) {
                Long idAula = (Long) tblAulas.getValueAt(tblAulas.getSelectedRow(), 0);
                if (control.leerAula(idAula).getNumeroAsientosDisponibles() >= control.leerAula(idAula).getNumeroAsientosTotales()) {
                    int respuesta = confirmarInformacion(this, "¿Realmente deseas borrar la/s Aulas del curso?", "Confirmar");
                    if (respuesta == SI) {
                        control.eliminarAula(idAula);
                        mostrarInformacion(this, "Aula eliminada correctamente", "Aula eliminada!");
                        cargarTablaAulas();
                    }
                } else {
                    mostrarInformacion(this, "No se pueden borrar aulas con estudiantes registrados", "Error");
                }
            } else {
                mostrarInformacion(this, "Selecciona un aula por favor", "Error");
            }
        } else {
            mostrarInformacion(this, "No existen Aulas para eliminar", "Error");
        }
    }//GEN-LAST:event_btnEliminarAulaActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        consultarCursos.recargarDatos();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCambiarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarNombreActionPerformed
        String nombre = obtenerInformacion(this, "Escribe el nuevo nombre", "Nuevo nombre");
        if (!nombre.equals(CANCELADO)) {
            if (nombre.equals("")) {
                mostrarInformacion(this, "No pueden haber campos vacios", "Error");
            } else {
                if (isString(nombre, this) && control.verificarNombreDisponible(nombre, control.leerListCursos(), Curso::getNombre)) {
                    control.cambiarNombreCurso(idCurso, nombre);
                    mostrarInformacion(this, "Nombre cambiado correctamente", "Cambio de nombre existoso");
                } else {
                    if (!control.verificarNombreDisponible(nombre, control.leerListCursos(), Curso::getNombre)) {
                        mostrarInformacion(this, "El curso " + nombre + " ya existe", "Error");
                    }
                }
            }
        }
        cargarNombre();
    }//GEN-LAST:event_btnCambiarNombreActionPerformed

    private void btnAgregarMateriasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMateriasMouseEntered
        btnAgregarMaterias.setBackground(new Color(78, 90, 126));
    }//GEN-LAST:event_btnAgregarMateriasMouseEntered

    private void btnAgregarMateriasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMateriasMouseExited
        btnAgregarMaterias.setBackground(new Color(63, 72, 100));
    }//GEN-LAST:event_btnAgregarMateriasMouseExited

    private void btnEliminarMateriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMateriaMouseEntered
        btnEliminarMateria.setBackground(new Color(201, 119, 119));
    }//GEN-LAST:event_btnEliminarMateriaMouseEntered

    private void btnEliminarMateriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMateriaMouseExited
        btnEliminarMateria.setBackground(new Color(165, 80, 80));
    }//GEN-LAST:event_btnEliminarMateriaMouseExited

    private void btnCrearAulaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearAulaMouseEntered
        btnCrearAula.setBackground(new Color(78, 90, 126));
    }//GEN-LAST:event_btnCrearAulaMouseEntered

    private void btnCrearAulaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCrearAulaMouseExited
        btnCrearAula.setBackground(new Color(63, 72, 100));
    }//GEN-LAST:event_btnCrearAulaMouseExited

    private void btnEliminarAulaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarAulaMouseEntered
        btnEliminarAula.setBackground(new Color(201, 119, 119));
    }//GEN-LAST:event_btnEliminarAulaMouseEntered

    private void btnEliminarAulaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarAulaMouseExited
        btnEliminarAula.setBackground(new Color(165, 80, 80));
    }//GEN-LAST:event_btnEliminarAulaMouseExited

    private void btnCambiarNombreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambiarNombreMouseEntered
        btnCambiarNombre.setBackground(new Color(78, 90, 126));
    }//GEN-LAST:event_btnCambiarNombreMouseEntered

    private void btnCambiarNombreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambiarNombreMouseExited
        btnCambiarNombre.setBackground(new Color(63, 72, 100));
    }//GEN-LAST:event_btnCambiarNombreMouseExited

    private void btnRegresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseEntered
        btnRegresar.setBackground(new Color(78, 90, 126));
    }//GEN-LAST:event_btnRegresarMouseEntered

    private void btnRegresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegresarMouseExited
        btnRegresar.setBackground(new Color(63, 72, 100));
    }//GEN-LAST:event_btnRegresarMouseExited

    private void btnActualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseEntered
        btnActualizar.setBackground(new Color(78, 90, 126));
    }//GEN-LAST:event_btnActualizarMouseEntered

    private void btnActualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseExited
        btnActualizar.setBackground(new Color(63, 72, 100));
    }//GEN-LAST:event_btnActualizarMouseExited

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        cargarNombre();
        cargarTablaAulas();
        cargarTablaMaterias();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnCambiarNombreAulaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambiarNombreAulaMouseEntered
        btnCambiarNombreAula.setBackground(new Color(78, 90, 126));
    }//GEN-LAST:event_btnCambiarNombreAulaMouseEntered

    private void btnCambiarNombreAulaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCambiarNombreAulaMouseExited
        btnCambiarNombreAula.setBackground(new Color(63, 72, 100));
    }//GEN-LAST:event_btnCambiarNombreAulaMouseExited

    private void btnCambiarNombreAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarNombreAulaActionPerformed

        if (tblAulas.getRowCount() > 0) {
            if (tblAulas.getSelectedRow() != -1) {
                String nombre = obtenerInformacion(this, "Escribe el nuevo nombre", "Nuevo nombre");
                if (!nombre.equals(CANCELADO)) {
                    if (nombre.equals("")) {
                        mostrarInformacion(this, "No pueden haber campos vacios", "Error");
                    } else {
                        if (isString(nombre, this) && control.verificarNombreDisponible(nombre, control.leerListAulas(), Aula::getNombre)) {
                            control.cambiarNombreAula((Long) tblAulas.getValueAt(tblAulas.getSelectedRow(), 0), nombre);
                            mostrarInformacion(this, "Nombre cambiado correctamente", "Cambio de nombre existoso");
                        } else {
                            if (!control.verificarNombreDisponible(nombre, control.leerListAulas(), Aula::getNombre)) {
                                mostrarInformacion(this, "El aula " + nombre + " ya existe", "Error");
                            }
                        }
                    }
                }
            } else {
                mostrarInformacion(this, "Selecciona un aula por favor", "Error");
            }
        } else {
            mostrarInformacion(this, "No existen Aulas para eliminar", "Error");
        }
        cargarTablaAulas();
    }//GEN-LAST:event_btnCambiarNombreAulaActionPerformed

    private void cargarNombre() {
        lblNombreCurso.setText(control.leerCurso(idCurso).getNombre());
    }

    public final void cargarTablaMaterias() {
        tblMaterias.setModel(obtenerModeloTablaMateriasSeleccion(new String[]{"SELECCIONAR", "ID", "MATERIA"}, control.obtenerListMateriasDeCurso(idCurso)));
        tblMaterias.setRowHeight(20);
    }

    public final void cargarTablaAulas() {
        tblAulas.setModel(obtenerModeloTablaAulas(new String[]{"ID", "AULA", "#Asientos", "#Asientos disponibles"}, control.obtenerListAulasDeCurso(idCurso)));
        tblAulas.setRowHeight(20);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnAgregarMaterias;
    private javax.swing.JButton btnCambiarNombre;
    private javax.swing.JButton btnCambiarNombreAula;
    private javax.swing.JButton btnCrearAula;
    private javax.swing.JButton btnEliminarAula;
    private javax.swing.JButton btnEliminarMateria;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblCurso;
    private javax.swing.JLabel lblMatricula3;
    private javax.swing.JLabel lblMatricula4;
    private javax.swing.JLabel lblNombreCurso;
    private javax.swing.JPanel pnlPrincipalData;
    private javax.swing.JTable tblAulas;
    private javax.swing.JTable tblMaterias;
    // End of variables declaration//GEN-END:variables

}

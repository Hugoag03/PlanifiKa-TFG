/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoTFG;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

/**
 *
 * @author Hugo
 */
public class ConsultarProyectos extends javax.swing.JFrame {

    /**
     * Creates new form GestionarEmpleados
     */
    public ConsultarProyectos() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(getIconImage());

        Connection cn = conexion.Conexion.conectar();
        try {
            DefaultTableModel modelo = new DefaultTableModel();

            if (ConsultarTrabajadores.banderaProyectos == true) {
                PreparedStatement ps2 = cn.prepareStatement("SELECT * FROM proyectos WHERE ID_JefeProyecto = ?");
                ps2.setString(1, ConsultarTrabajadores.idSeleccionado);
                ResultSet rs2 = ps2.executeQuery();

                modelo.addColumn("ID");
                modelo.addColumn("Nombre");
                modelo.addColumn("Descripcion");
                modelo.addColumn("FechaEntrega");
                modelo.addColumn("ID_JefeProyecto");

                while (rs2.next()) {
                    id = rs2.getString(1);
                    nombre = rs2.getString(2);
                    descripcion = rs2.getString(3);
                    fechaEntrega = rs2.getDate(4);
                    id_jefeProyecto = rs2.getInt(5);

                    modelo.addRow(new Object[]{id, nombre, descripcion, fechaEntrega, id_jefeProyecto});
                }

            } else {
                PreparedStatement ps = cn.prepareStatement("SELECT * FROM proyectos");
                ResultSet rs = ps.executeQuery();

                modelo.addColumn("ID");
                modelo.addColumn("Nombre");
                modelo.addColumn("Descripcion");
                modelo.addColumn("FechaEntrega");
                modelo.addColumn("ID_JefeProyecto");

                while (rs.next()) {
                    id = rs.getString(1);
                    nombre = rs.getString(2);
                    descripcion = rs.getString(3);
                    fechaEntrega = rs.getDate(4);
                    id_jefeProyecto = rs.getInt(5);

                    modelo.addRow(new Object[]{id, nombre, descripcion, fechaEntrega, id_jefeProyecto});
                }

                tdConsultarTrabajador.setModel(modelo);
                tdConsultarTrabajador.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                guardarId();

                sorter = new TableRowSorter<>(modelo);
                tdConsultarTrabajador.setRowSorter(sorter);
                cn.close();

            }
        } catch (SQLException e) {
            System.err.println("Error en la conexion a la BBDD" + e.getMessage());
        }
    }

    @Override
    public Image getIconImage() {
        Image miIcono = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("images/logoIcono.png"));
        return miIcono;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelFondo = new javax.swing.JPanel();
        LabelLogo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tdConsultarTrabajador = new javax.swing.JTable();
        ComboBoxOrdenar = new javax.swing.JComboBox<>();
        textFiltrarSegunDNI = new javax.swing.JLabel();
        LabelVolver = new javax.swing.JLabel();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        PanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoIcono.png"))); // NOI18N
        LabelLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelLogoMouseClicked(evt);
            }
        });
        PanelFondo.add(LabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 40, 40));

        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("PlanifiKa");
        PanelFondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, 40));

        tdConsultarTrabajador.setBackground(java.awt.Color.white);
        tdConsultarTrabajador.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tdConsultarTrabajador.setForeground(java.awt.Color.black);
        tdConsultarTrabajador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Descripcion", "FechaEntrega", "ID_JefeProyecto"
            }
        ));
        tdConsultarTrabajador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(tdConsultarTrabajador);

        PanelFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 1210, 550));

        ComboBoxOrdenar.setBackground(java.awt.Color.black);
        ComboBoxOrdenar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ComboBoxOrdenar.setForeground(java.awt.Color.white);
        ComboBoxOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Fecha de entrega", "Nº Tareas" }));
        ComboBoxOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxOrdenarActionPerformed(evt);
            }
        });
        PanelFondo.add(ComboBoxOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 80, 180, -1));

        textFiltrarSegunDNI.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        textFiltrarSegunDNI.setForeground(java.awt.Color.white);
        textFiltrarSegunDNI.setText("Ordenar por:");
        PanelFondo.add(textFiltrarSegunDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 80, -1, -1));

        LabelVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/volveratras.png"))); // NOI18N
        LabelVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabelVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelVolverMouseClicked(evt);
            }
        });
        PanelFondo.add(LabelVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 700, 70, 70));

        labelFondo.setBackground(java.awt.Color.black);
        labelFondo.setForeground(java.awt.Color.white);
        labelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondotfg.png"))); // NOI18N
        PanelFondo.add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 800));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 785, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LabelLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelLogoMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_LabelLogoMouseClicked

    private void ComboBoxOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxOrdenarActionPerformed
        // TODO add your handling code here:
        if (ComboBoxOrdenar.getSelectedItem().toString().equals("Fecha de entrega")) {
            try {
                Connection cn = conexion.Conexion.conectar();
                PreparedStatement ps = cn.prepareStatement("SELECT * FROM proyectos ORDER BY FechaEntrega DESC");
                ResultSet rs = ps.executeQuery();

                DefaultTableModel modelo = new DefaultTableModel();
                modelo.addColumn("ID");
                modelo.addColumn("Nombre");
                modelo.addColumn("Descripcion");
                modelo.addColumn("FechaEntrega");
                modelo.addColumn("ID_JefeProyecto");

                while (rs.next()) {
                    id = rs.getString(1);
                    nombre = rs.getString(2);
                    descripcion = rs.getString(3);
                    fechaEntrega = rs.getDate(4);
                    id_jefeProyecto = rs.getInt(5);

                    modelo.addRow(new Object[]{id, nombre, descripcion, fechaEntrega, id_jefeProyecto});

                }

                tdConsultarTrabajador.setModel(modelo);
                tdConsultarTrabajador.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                sorter = new TableRowSorter<>(modelo);
                tdConsultarTrabajador.setRowSorter(sorter);
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error en la conexion a la BBDD" + e.getMessage());
            }
        } else if (ComboBoxOrdenar.getSelectedItem().toString().equals("Nº Tareas")) {
            try {
                Connection cn = conexion.Conexion.conectar();
                PreparedStatement ps = cn.prepareStatement("SELECT p.*, COUNT(t.ID) AS NumeroDeTareas FROM proyectos AS p INNER JOIN tareas AS t ON p.ID = t.ID_PROYECTO GROUP BY p.ID ORDER BY NumeroDeTareas DESC");
                ResultSet rs = ps.executeQuery();

                DefaultTableModel modelo = new DefaultTableModel();
                modelo.addColumn("ID");
                modelo.addColumn("Nombre");
                modelo.addColumn("Descripcion");
                modelo.addColumn("FechaEntrega");
                modelo.addColumn("ID_JefeProyecto");

                while (rs.next()) {
                    id = rs.getString(1);
                    nombre = rs.getString(2);
                    descripcion = rs.getString(3);
                    fechaEntrega = rs.getDate(4);
                    id_jefeProyecto = rs.getInt(5);

                    modelo.addRow(new Object[]{id, nombre, descripcion, fechaEntrega, id_jefeProyecto});

                }

                tdConsultarTrabajador.setModel(modelo);
                tdConsultarTrabajador.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                sorter = new TableRowSorter<>(modelo);
                tdConsultarTrabajador.setRowSorter(sorter);
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error en la conexion a la BBDD" + e.getMessage());
            }
            guardarId();

        } else {
            ConsultarProyectos gestE = new ConsultarProyectos();
            gestE.setVisible(true);
        }
    }//GEN-LAST:event_ComboBoxOrdenarActionPerformed

    private boolean procesandoSeleccion = false;

    public void guardarId() {
    tdConsultarTrabajador.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting() && tdConsultarTrabajador.getSelectedRow() != -1 && !procesandoSeleccion) {
                int filaSeleccionada = tdConsultarTrabajador.getSelectedRow();
                if (filaSeleccionada >= 0 && filaSeleccionada < tdConsultarTrabajador.getModel().getRowCount()) {
                    procesandoSeleccion = true;
                    idSeleccionado = tdConsultarTrabajador.getValueAt(filaSeleccionada, 0).toString();

                    SwingUtilities.invokeLater(() -> {
                        int seleccion = JOptionPane.showOptionDialog(null, "Seleccione opcion", "Selector de opciones", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Gestionar proyecto", "Ver tareas asociadas"}, null);
                        if (seleccion == 0) {
                            GestionarProyecto gestionarP = new GestionarProyecto();
                            gestionarP.setVisible(true);
                            dispose();
                        } else if (seleccion == 1) {
                            ConsultarTareas consultarT = new ConsultarTareas();
                            consultarT.setVisible(true);
                            dispose();
                        }
                        procesandoSeleccion = false;
                    });
                }
            }
        }
    });
}




    private void LabelVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelVolverMouseClicked
        // TODO add your handling code here:
        PanelJefeProyecto panelJP = new PanelJefeProyecto();
        panelJP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LabelVolverMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConsultarProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarProyectos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxOrdenar;
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JLabel LabelVolver;
    private javax.swing.JPanel PanelFondo;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JTable tdConsultarTrabajador;
    private javax.swing.JLabel textFiltrarSegunDNI;
    // End of variables declaration//GEN-END:variables
    static String idSeleccionado;
    String id;
    String descripcion;
    String nombre;
    Date fechaEntrega;
    int id_jefeProyecto;
    TableRowSorter<TableModel> sorter;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoTFG;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Hugo
 */
public class ConsultarSolicitudes extends javax.swing.JFrame {

    /**
     * Creates new form ConsultarSolicitudes
     */
    public ConsultarSolicitudes() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(getIconImage());

        try {
            Connection cn = conexion.Conexion.conectar();
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM solicitudes WHERE ID_Empleado = ?");
            if (PanelEmpleado.bandera == true) {

                ps.setString(1, GestionarTrabajador.CampoID.getText());

            } else {
                ps.setInt(1, Login.idInicioSesion);
            }
            ResultSet rs = ps.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Título");
            modelo.addColumn("Mensaje");
            modelo.addColumn("Fecha");
            modelo.addColumn("Estado");

            modelo.addColumn("URLArchivoAdjunto");
            modelo.addColumn("ID_Empleado");
            modelo.addColumn("ID_Administrador");

            while (rs.next()) {
                id = rs.getInt(1);
                titulo = rs.getString(2);
                mensaje = rs.getString(3);
                fecha = rs.getDate(4);
                estado = rs.getString(5);
                urlArchivoAdjunto = rs.getString(6);
                id_empleado = rs.getInt(7);
                id_administrador = rs.getInt(8);

                modelo.addRow(new Object[]{id, titulo, mensaje, fecha, estado, urlArchivoAdjunto, id_empleado, id_administrador});

            }

            tdConsultarTrabajador.setModel(modelo);
            tdConsultarTrabajador.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            guardarId();
            sorter = new TableRowSorter<>(modelo);
            tdConsultarTrabajador.setRowSorter(sorter);
            cn.close();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tdConsultarTrabajador = new javax.swing.JTable();
        textFiltrarSegunDNI = new javax.swing.JLabel();
        ComboBoxOrdenar = new javax.swing.JComboBox<>();
        LabelVolver = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        LabelLogo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        PanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tdConsultarTrabajador.setBackground(new java.awt.Color(92, 116, 118));
        tdConsultarTrabajador.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tdConsultarTrabajador.setForeground(java.awt.Color.white);
        tdConsultarTrabajador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Título", "Mensaje", "Fecha", "Estado", "URLArchivoAdjunto", "ID_Empleado", "ID_Administrador"
            }
        ));
        tdConsultarTrabajador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tdConsultarTrabajador.setSelectionBackground(java.awt.Color.white);
        tdConsultarTrabajador.setSelectionForeground(java.awt.Color.black);
        jScrollPane1.setViewportView(tdConsultarTrabajador);

        PanelFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 1200, 550));

        textFiltrarSegunDNI.setBackground(java.awt.Color.black);
        textFiltrarSegunDNI.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        textFiltrarSegunDNI.setForeground(java.awt.Color.white);
        textFiltrarSegunDNI.setText("Ordenar por:");
        PanelFondo.add(textFiltrarSegunDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 80, -1, -1));

        ComboBoxOrdenar.setBackground(java.awt.Color.white);
        ComboBoxOrdenar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ComboBoxOrdenar.setForeground(java.awt.Color.black);
        ComboBoxOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Fecha", "Estado" }));
        ComboBoxOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxOrdenarActionPerformed(evt);
            }
        });
        PanelFondo.add(ComboBoxOrdenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 80, 190, -1));

        LabelVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flecha-hacia-atras.png"))); // NOI18N
        LabelVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabelVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelVolverMouseClicked(evt);
            }
        });
        PanelFondo.add(LabelVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 700, 70, 70));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setText("x");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        PanelFondo.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1370, 10, 20, 30));

        LabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoIcono.png"))); // NOI18N
        LabelLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelLogoMouseClicked(evt);
            }
        });
        PanelFondo.add(LabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 40, 40));

        jLabel4.setFont(new java.awt.Font("Poor Richard", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(87, 186, 144));
        jLabel4.setText("PlanifiKa");
        PanelFondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, 40));

        jLabel18.setBackground(new java.awt.Color(26, 46, 68));
        jLabel18.setOpaque(true);
        PanelFondo.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 790));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBoxOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxOrdenarActionPerformed
        // TODO add your handling code here:
        if (ComboBoxOrdenar.getSelectedItem().toString().equals("Fecha")) {
            try {
                Connection cn = conexion.Conexion.conectar();
                PreparedStatement ps = cn.prepareStatement("SELECT * FROM solicitudes WHERE ID_Empleado = ? ORDER BY Fecha DESC");
                if (PanelEmpleado.bandera == true) {

                    ps.setString(1, GestionarTrabajador.CampoID.getText());

                } else {
                    ps.setInt(1, Login.idInicioSesion);
                }
                ResultSet rs = ps.executeQuery();

                DefaultTableModel modelo = new DefaultTableModel();
                modelo.addColumn("ID");
                modelo.addColumn("Título");
                modelo.addColumn("Mensaje");
                modelo.addColumn("Fecha");
                modelo.addColumn("Estado");

                modelo.addColumn("URLArchivoAdjunto");
                modelo.addColumn("ID_Empleado");
                modelo.addColumn("ID_Administrador");

                while (rs.next()) {
                    id = rs.getInt(1);
                    titulo = rs.getString(2);
                    mensaje = rs.getString(3);
                    fecha = rs.getDate(4);
                    estado = rs.getString(5);
                    urlArchivoAdjunto = rs.getString(6);
                    id_empleado = rs.getInt(7);
                    id_administrador = rs.getInt(8);

                    modelo.addRow(new Object[]{id, titulo, mensaje, fecha, estado, urlArchivoAdjunto, id_empleado, id_administrador});

                }

                tdConsultarTrabajador.setModel(modelo);
                tdConsultarTrabajador.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                guardarId();
                sorter = new TableRowSorter<>(modelo);
                tdConsultarTrabajador.setRowSorter(sorter);
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error en la conexion a la BBDD" + e.getMessage());
            }
        } else if (ComboBoxOrdenar.getSelectedItem().toString().equals("Estado")) {
            try {
                Connection cn = conexion.Conexion.conectar();
                PreparedStatement ps = cn.prepareStatement("SELECT * FROM solicitudes WHERE ID_Empleado = ? ORDER BY Estado");
                if (PanelEmpleado.bandera == true) {

                    ps.setString(1, GestionarTrabajador.CampoID.getText());

                } else {
                    ps.setInt(1, Login.idInicioSesion);
                }
                ResultSet rs = ps.executeQuery();

                DefaultTableModel modelo = new DefaultTableModel();
                modelo.addColumn("ID");
                modelo.addColumn("Título");
                modelo.addColumn("Mensaje");
                modelo.addColumn("Fecha");
                modelo.addColumn("Estado");

                modelo.addColumn("URLArchivoAdjunto");
                modelo.addColumn("ID_Empleado");
                modelo.addColumn("ID_Administrador");

                while (rs.next()) {
                    id = rs.getInt(1);
                    titulo = rs.getString(2);
                    mensaje = rs.getString(3);
                    fecha = rs.getDate(4);
                    estado = rs.getString(5);
                    urlArchivoAdjunto = rs.getString(6);
                    id_empleado = rs.getInt(7);
                    id_administrador = rs.getInt(8);

                    modelo.addRow(new Object[]{id, titulo, mensaje, fecha, estado, urlArchivoAdjunto, id_empleado, id_administrador});

                }

                tdConsultarTrabajador.setModel(modelo);
                tdConsultarTrabajador.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

                guardarId();
                sorter = new TableRowSorter<>(modelo);
                tdConsultarTrabajador.setRowSorter(sorter);
                cn.close();
            } catch (SQLException e) {
                System.err.println("Error en la conexion a la BBDD" + e.getMessage());
            }

        } else {
            ConsultarTareas gestT = new ConsultarTareas();
            gestT.setVisible(true);
        }
    }//GEN-LAST:event_ComboBoxOrdenarActionPerformed
    public void cambiarColor() {
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (column == 4) {
                    Object cellValue = table.getValueAt(row, column);
                    if (cellValue != null) {
                        String estado = cellValue.toString();
                        switch (estado) {
                            case "Pendiente":
                                comp.setForeground(Color.ORANGE);
                                break;
                            case "Finalizada":
                                comp.setForeground(Color.GREEN);
                                break;
                            default:
                                comp.setForeground(Color.WHITE);
                                break;
                        }
                    } else {
                        comp.setBackground(new Color(92, 116, 118));
                        comp.setForeground(Color.WHITE);
                    }

                } else {
                    comp.setBackground(new Color(92, 116, 118));
                    comp.setForeground(Color.WHITE);
                }
                return comp;

            }

        };
        for (int i = 0; i < tdConsultarTrabajador.getColumnCount(); i++) {
            tdConsultarTrabajador.getColumnModel().getColumn(i).setCellRenderer(renderer);
        }
    }

    public void guardarId() {
        tdConsultarTrabajador.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int filaSeleccionada = tdConsultarTrabajador.getSelectedRow();

                    idSeleccionado = tdConsultarTrabajador.getValueAt(filaSeleccionada, 0).toString();
                    Connection cn = conexion.Conexion.conectar();
                    try {
                        PreparedStatement ps = cn.prepareStatement("SELECT Estado FROM solicitudes WHERE ID = ?");
                        ps.setString(1, idSeleccionado);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            if (rs.getString(1).equals("Finalizada") || PanelEmpleado.bandera == false) {
                                JOptionPane.showMessageDialog(null, "Esta solicitud está finalizada. Si desea tratar otro tema, envie una nueva solicitud");
                            } else {
                                GestionarSolicitud gestionarS = new GestionarSolicitud();
                                gestionarS.setVisible(true);
                                dispose();
                            }
                        }
                    } catch (SQLException e2) {
                        e2.printStackTrace();
                    }

                }

            }

        });
        cambiarColor();
    }
    private void LabelVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelVolverMouseClicked
        // TODO add your handling code here:
        if (PanelEmpleado.bandera == true) {
            ConsultarTrabajadores consultarT = new ConsultarTrabajadores();
            consultarT.setVisible(true);
            this.dispose();
        } else {
            PanelEmpleado panelE = new PanelEmpleado();
            panelE.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_LabelVolverMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void LabelLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelLogoMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_LabelLogoMouseClicked

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
            java.util.logging.Logger.getLogger(ConsultarSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarSolicitudes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarSolicitudes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxOrdenar;
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JLabel LabelVolver;
    private javax.swing.JPanel PanelFondo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tdConsultarTrabajador;
    private javax.swing.JLabel textFiltrarSegunDNI;
    // End of variables declaration//GEN-END:variables
    int id;
    String titulo;
    String mensaje;
    Date fecha;
    String estado;
    String urlArchivoAdjunto;
    int id_empleado;
    int id_administrador;
    TableRowSorter<TableModel> sorter;
    static String idSeleccionado;
}

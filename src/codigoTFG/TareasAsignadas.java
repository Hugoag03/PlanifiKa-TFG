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
public class TareasAsignadas extends javax.swing.JFrame {

    /**
     * Creates new form GestionarEmpleados
     */
    public TareasAsignadas() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(getIconImage());
        comprobarTipo();

        try {
            Connection cn = conexion.Conexion.conectar();

            PreparedStatement ps = cn.prepareStatement("SELECT t.* FROM TAREAS AS t INNER JOIN empleados_Tareas AS et ON t.ID = et.ID_Tarea INNER JOIN usuarios AS u ON et.ID_Empleado = u.ID WHERE u.ID = ?");
            if (tipoTrabajador.equals("Empleado")) {
                ps.setInt(1, Login.idInicioSesion);
            } else {
                ps.setString(1, ConsultarTrabajadores.idSeleccionado);
            }
            ResultSet rs = ps.executeQuery();

            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Nombre");
            modelo.addColumn("EmpleadosAsignados");
            modelo.addColumn("FechaEntrega");
            modelo.addColumn("Estado");
            modelo.addColumn("Prioridad");
            modelo.addColumn("Notas");
            modelo.addColumn("URLArchivoAdjunto");
            modelo.addColumn("ID_Proyecto");

            while (rs.next()) {
                id = rs.getString(1);
                nombre = rs.getString(2);
                empleadosAsignados = rs.getString(3);
                fechaEntrega = rs.getDate(4);
                estado = rs.getString(5);
                prioridad = rs.getString(6);
                notas = rs.getString(7);
                urlArchivoAdjunto = rs.getString(8);
                id_proyecto = rs.getInt(9);

                modelo.addRow(new Object[]{id, nombre, empleadosAsignados, fechaEntrega, estado, prioridad, notas, urlArchivoAdjunto, id_proyecto});

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
                            case "Retrasada":
                                comp.setForeground(Color.RED);
                                break;
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
        jLabel4 = new javax.swing.JLabel();
        LabelLogo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        PanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tdConsultarTrabajador.setBackground(new java.awt.Color(92, 116, 118));
        tdConsultarTrabajador.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tdConsultarTrabajador.setForeground(java.awt.Color.white);
        tdConsultarTrabajador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Empleados Asignados", "FechaEntrega", "Estado", "Prioridad", "Notas", "URLArchivoAdjunto", "ID_Proyecto"
            }
        ));
        tdConsultarTrabajador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tdConsultarTrabajador.setSelectionBackground(new java.awt.Color(92, 116, 118));
        tdConsultarTrabajador.setSelectionForeground(java.awt.Color.white);
        jScrollPane1.setViewportView(tdConsultarTrabajador);

        PanelFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 1200, 550));

        textFiltrarSegunDNI.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        textFiltrarSegunDNI.setForeground(java.awt.Color.white);
        textFiltrarSegunDNI.setText("Ordenar por:");
        PanelFondo.add(textFiltrarSegunDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 80, -1, -1));

        ComboBoxOrdenar.setBackground(java.awt.Color.white);
        ComboBoxOrdenar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ComboBoxOrdenar.setForeground(java.awt.Color.black);
        ComboBoxOrdenar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Fecha de entrega", "Estado", "Prioridad" }));
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

        jLabel4.setFont(new java.awt.Font("Poor Richard", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(87, 186, 144));
        jLabel4.setText("PlanifiKa");
        PanelFondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, 40));

        LabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoIcono.png"))); // NOI18N
        LabelLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelLogoMouseClicked(evt);
            }
        });
        PanelFondo.add(LabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 40, 40));

        jLabel6.setBackground(new java.awt.Color(26, 46, 68));
        jLabel6.setOpaque(true);
        PanelFondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 800));

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

    private void ComboBoxOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxOrdenarActionPerformed
        // TODO add your handling code here:
        if (ComboBoxOrdenar.getSelectedItem().toString().equals("Fecha de entrega")) {
            Connection cn = conexion.Conexion.conectar();
            try {
                PreparedStatement ps = cn.prepareStatement("SELECT t.* FROM TAREAS AS t INNER JOIN empleados_Tareas AS et ON t.ID = et.ID_Tarea INNER JOIN usuarios AS u ON et.ID_Empleado = u.ID WHERE u.ID = ? ORDER BY T.FechaEntrega DESC");
                if (tipoTrabajador.equals("Empleado")) {
                    ps.setInt(1, Login.idInicioSesion);
                } else {
                    ps.setString(1, ConsultarTrabajadores.idSeleccionado);
                }
                ResultSet rs = ps.executeQuery();

                DefaultTableModel modelo = new DefaultTableModel();
                modelo.addColumn("ID");
                modelo.addColumn("Nombre");
                modelo.addColumn("EmpleadosAsignados");
                modelo.addColumn("FechaEntrega");
                modelo.addColumn("Estado");

                modelo.addColumn("Prioridad");
                modelo.addColumn("Notas");
                modelo.addColumn("URLArchivoAdjunto");
                modelo.addColumn("ID_Proyecto");

                while (rs.next()) {
                    id = rs.getString(1);
                    nombre = rs.getString(2);
                    empleadosAsignados = rs.getString(3);
                    fechaEntrega = rs.getDate(4);
                    estado = rs.getString(5);
                    prioridad = rs.getString(6);
                    notas = rs.getString(7);
                    urlArchivoAdjunto = rs.getString(8);
                    id_proyecto = rs.getInt(9);

                    modelo.addRow(new Object[]{id, nombre, empleadosAsignados, fechaEntrega, estado, prioridad, notas, urlArchivoAdjunto, id_proyecto});

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
                PreparedStatement ps = cn.prepareStatement("SELECT t.* FROM TAREAS AS t INNER JOIN empleados_Tareas AS et ON t.ID = et.ID_Tarea INNER JOIN usuarios AS u ON et.ID_Empleado = u.ID WHERE u.ID = ? ORDER BY T.Estado");
                if (tipoTrabajador.equals("Empleado")) {
                    ps.setInt(1, Login.idInicioSesion);
                } else {
                    ps.setString(1, ConsultarTrabajadores.idSeleccionado);
                }
                ResultSet rs = ps.executeQuery();

                DefaultTableModel modelo = new DefaultTableModel();
                modelo.addColumn("ID");
                modelo.addColumn("Nombre");
                modelo.addColumn("EmpleadosAsignados");
                modelo.addColumn("FechaEntrega");
                modelo.addColumn("Estado");

                modelo.addColumn("Prioridad");
                modelo.addColumn("Notas");
                modelo.addColumn("URLArchivoAdjunto");
                modelo.addColumn("ID_Proyecto");

                while (rs.next()) {
                    id = rs.getString(1);
                    nombre = rs.getString(2);
                    empleadosAsignados = rs.getString(3);
                    fechaEntrega = rs.getDate(4);
                    estado = rs.getString(5);
                    prioridad = rs.getString(6);
                    notas = rs.getString(7);
                    urlArchivoAdjunto = rs.getString(8);
                    id_proyecto = rs.getInt(9);

                    modelo.addRow(new Object[]{id, nombre, empleadosAsignados, fechaEntrega, estado, prioridad, notas, urlArchivoAdjunto, id_proyecto});

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
        } else if (ComboBoxOrdenar.getSelectedItem().toString().equals("Prioridad")) {
            try {
                Connection cn = conexion.Conexion.conectar();
                PreparedStatement comprobarTipo = cn.prepareStatement("SELECT Tipo FROM usuarios WHERE ID = ?");
                comprobarTipo.setInt(1, Login.idInicioSesion);
                ResultSet rs2 = comprobarTipo.executeQuery();

                while (rs2.next()) {
                    tipoTrabajador = rs2.getString(1);
                }

                PreparedStatement ps = cn.prepareStatement("SELECT t.* FROM TAREAS AS t INNER JOIN empleados_Tareas AS et ON t.ID = et.ID_Tarea INNER JOIN usuarios AS u ON et.ID_Empleado = u.ID WHERE u.ID = ? ORDER BY T.Prioridad");
                if (tipoTrabajador.equals("Empleado")) {
                    ps.setInt(1, Login.idInicioSesion);
                } else {
                    ps.setString(1, ConsultarTrabajadores.idSeleccionado);
                }
                ResultSet rs = ps.executeQuery();

                DefaultTableModel modelo = new DefaultTableModel();
                modelo.addColumn("ID");
                modelo.addColumn("Nombre");
                modelo.addColumn("EmpleadosAsignados");
                modelo.addColumn("FechaEntrega");
                modelo.addColumn("Estado");

                modelo.addColumn("Prioridad");
                modelo.addColumn("Notas");
                modelo.addColumn("URLArchivoAdjunto");
                modelo.addColumn("ID_Proyecto");

                while (rs.next()) {
                    id = rs.getString(1);
                    nombre = rs.getString(2);
                    empleadosAsignados = rs.getString(3);
                    fechaEntrega = rs.getDate(4);
                    estado = rs.getString(5);
                    prioridad = rs.getString(6);
                    notas = rs.getString(7);
                    urlArchivoAdjunto = rs.getString(8);
                    id_proyecto = rs.getInt(9);

                    modelo.addRow(new Object[]{id, nombre, empleadosAsignados, fechaEntrega, estado, prioridad, notas, urlArchivoAdjunto, id_proyecto});

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
            TareasAsignadas gestT = new TareasAsignadas();
            gestT.setVisible(true);
        }
    }//GEN-LAST:event_ComboBoxOrdenarActionPerformed

    public void guardarId() {
        tdConsultarTrabajador.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int filaSeleccionada = tdConsultarTrabajador.getSelectedRow();

                    idSeleccionado = tdConsultarTrabajador.getValueAt(filaSeleccionada, 0).toString();

                }

            }

        });
        cambiarColor();
    }

    public void comprobarTipo() {
        Connection cn = conexion.Conexion.conectar();
        try {

            PreparedStatement comprobarTipo = cn.prepareStatement("SELECT Tipo FROM usuarios WHERE ID = ?");
            comprobarTipo.setInt(1, Login.idInicioSesion);
            ResultSet rs2 = comprobarTipo.executeQuery();

            while (rs2.next()) {
                tipoTrabajador = rs2.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void LabelVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelVolverMouseClicked
        // TODO add your handling code here:
        if(tipoTrabajador.equals("Empleado")){
            PanelEmpleado panelE = new PanelEmpleado();
            panelE.setVisible(true);
            this.dispose();
        }else{
            ConsultarTrabajadores consultarT = new ConsultarTrabajadores();
            consultarT.setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_LabelVolverMouseClicked

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
            java.util.logging.Logger.getLogger(TareasAsignadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TareasAsignadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TareasAsignadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TareasAsignadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TareasAsignadas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxOrdenar;
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JLabel LabelVolver;
    private javax.swing.JPanel PanelFondo;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tdConsultarTrabajador;
    private javax.swing.JLabel textFiltrarSegunDNI;
    // End of variables declaration//GEN-END:variables
    static String idSeleccionado;
    String id;
    String descripcion;
    String nombre;
    Date fechaEntrega;
    int id_jefeProyecto;
    String empleadosAsignados;
    String estado;
    String prioridad;
    String notas;
    String urlArchivoAdjunto;
    int id_proyecto;
    TableRowSorter<TableModel> sorter;
    String tipoTrabajador;
}

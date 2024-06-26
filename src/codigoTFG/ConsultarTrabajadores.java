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
public class ConsultarTrabajadores extends javax.swing.JFrame {

    /**
     * Creates new form GestionarEmpleados
     */
    DefaultTableModel modelo = new DefaultTableModel();

    public ConsultarTrabajadores() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(getIconImage());

        try {
            Connection cn = conexion.Conexion.conectar();
            PreparedStatement ps = cn.prepareStatement("SELECT * FROM usuarios");
            ResultSet rs = ps.executeQuery();

            modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("DNI");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellidos");
            modelo.addColumn("Telefono");
            modelo.addColumn("Email");
            modelo.addColumn("Empresa");
            modelo.addColumn("Estado");
            modelo.addColumn("Tipo");

            while (rs.next()) {
                id = rs.getString(1);
                dni = rs.getString(2);
                nombre = rs.getString(3);
                apellidos = rs.getString(4);
                telefono = rs.getLong(5);
                email = rs.getString(6);
                empresa = rs.getString(7);
                estado = rs.getString(11);
                tipo = rs.getString(12);

                modelo.addRow(new Object[]{id, dni, nombre, apellidos, telefono, email, empresa, estado, tipo});

            }

            if (ConsultarTareas.bandera == true) {
                PreparedStatement ps2 = cn.prepareStatement("SELECT * FROM usuarios AS U INNER JOIN empleados_Tareas AS et ON u.ID = et.ID_Empleado INNER JOIN tareas AS t ON et.ID_Tarea = t.ID WHERE et.ID_Tarea = ?");
                ps2.setString(1, ConsultarTareas.idSeleccionado);
                ResultSet rs2 = ps2.executeQuery();

                modelo = new DefaultTableModel();
                modelo.addColumn("ID");
                modelo.addColumn("DNI");
                modelo.addColumn("Nombre");
                modelo.addColumn("Apellidos");
                modelo.addColumn("Telefono");
                modelo.addColumn("Email");
                modelo.addColumn("Empresa");
                modelo.addColumn("Estado");
                modelo.addColumn("Tipo");

                while (rs2.next()) {
                    id = rs2.getString(1);
                    dni = rs2.getString(2);
                    nombre = rs2.getString(3);
                    apellidos = rs2.getString(4);
                    telefono = rs2.getLong(5);
                    email = rs2.getString(6);
                    empresa = rs2.getString(7);
                    estado = rs2.getString(11);
                    tipo = rs2.getString(12);

                    modelo.addRow(new Object[]{id, dni, nombre, apellidos, telefono, email, empresa, estado, tipo});

                }
            }

            tdConsultarTrabajador.setModel(modelo);
            tdConsultarTrabajador.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tdConsultarTrabajador.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        int filaSeleccionada = tdConsultarTrabajador.getSelectedRow();

                        idSeleccionado = tdConsultarTrabajador.getValueAt(filaSeleccionada, 0).toString();
                        tipoSeleccionado = tdConsultarTrabajador.getValueAt(filaSeleccionada, 8).toString();

                        if (tipoSeleccionado.equals("Empleado")) {
                            if (ConsultarTareas.bandera == true && Login.tipoEmpleado.equals("JefeProyecto")) {
                                JOptionPane.showMessageDialog(null, "Eres jefe de proyecto, no puedes gestionar trabajadores");
                            } else {

                                int seleccion = JOptionPane.showOptionDialog(null, "Seleccione opcion", "Selector de opciones", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Gestionar trabajador", "Ver tareas asociadas"}, null);
                                if (seleccion == 0) {
                                    GestionarTrabajador modE = new GestionarTrabajador();
                                    modE.setVisible(true);
                                    dispose();
                                }
                                if (seleccion == 1) {
                                    TareasAsignadas tareasA = new TareasAsignadas();
                                    tareasA.setVisible(true);
                                    dispose();
                                }
                            }
                        } else if (tipoSeleccionado.equals("JefeProyecto")) {
                            int seleccion = JOptionPane.showOptionDialog(null, "Seleccione opcion", "Selector de opciones", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Gestionar trabajador", "Ver proyectos asociados"}, null);
                            if (seleccion == 0) {
                                GestionarTrabajador modE = new GestionarTrabajador();
                                modE.setVisible(true);
                                dispose();
                            }
                            if (seleccion == 1) {
                                banderaProyectos = true;
                                ConsultarProyectos consultarP = new ConsultarProyectos();
                                consultarP.setVisible(true);
                                dispose();
                                banderaProyectos = false;
                            }
                        } else {
                            GestionarTrabajador modE = new GestionarTrabajador();
                            modE.setVisible(true);
                            dispose();
                        }

                    }

                }

            });
            sorter = new TableRowSorter<>(modelo);
            tdConsultarTrabajador.setRowSorter(sorter);
            cn.close();
        } catch (SQLException e) {
            System.err.println("Error en la conexion a la BBDD" + e.getMessage());
        }

        CampoDNI.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                filter();
            }

            public void removeUpdate(DocumentEvent e) {
                filter();
            }

            public void insertUpdate(DocumentEvent e) {
                filter();
            }

            public void filter() {
                String text = CampoDNI.getText();
                if (text.trim().length() == 0) {
                    sorter.setRowFilter(null);
                } else {
                    sorter.setRowFilter(RowFilter.regexFilter("^" + text, 1));
                }
            }
        });

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (column == 7) {
                    Object cellValue = table.getValueAt(row, column);
                    if (cellValue != null) {
                        String estado = cellValue.toString();
                        switch (estado) {
                            case "Activo":
                                comp.setForeground(Color.GREEN);
                                break;
                            case "Inactivo":
                                comp.setForeground(Color.RED);
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
        LabelVolver = new javax.swing.JLabel();
        CampoDNI = new javax.swing.JTextField();
        textFiltrarSegunDNI = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tdConsultarTrabajador = new javax.swing.JTable();
        LabelLogo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        PanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flecha-hacia-atras.png"))); // NOI18N
        LabelVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabelVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelVolverMouseClicked(evt);
            }
        });
        PanelFondo.add(LabelVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 710, 70, 70));

        CampoDNI.setBackground(new java.awt.Color(26, 46, 68));
        CampoDNI.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CampoDNI.setForeground(java.awt.Color.white);
        CampoDNI.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(255, 255, 255)));
        PanelFondo.add(CampoDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 70, 430, 40));

        textFiltrarSegunDNI.setFont(new java.awt.Font("Poor Richard", 0, 30)); // NOI18N
        textFiltrarSegunDNI.setForeground(java.awt.Color.white);
        textFiltrarSegunDNI.setText("Se podrá filtrar los trabajadores a partir de su DNI");
        PanelFondo.add(textFiltrarSegunDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, 40));

        tdConsultarTrabajador.setBackground(new java.awt.Color(92, 116, 118));
        tdConsultarTrabajador.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        tdConsultarTrabajador.setForeground(new java.awt.Color(255, 255, 255));
        tdConsultarTrabajador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DNI", "Nombre", "Apellidos", "Telefono", "Email", "Empresa", "Estado", "Tipo"
            }
        ));
        tdConsultarTrabajador.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tdConsultarTrabajador.setGridColor(new java.awt.Color(87, 186, 144));
        tdConsultarTrabajador.setSelectionBackground(new java.awt.Color(92, 116, 118));
        tdConsultarTrabajador.setSelectionForeground(java.awt.Color.white);
        jScrollPane1.setViewportView(tdConsultarTrabajador);

        PanelFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 1200, 550));

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

        jLabel18.setBackground(new java.awt.Color(26, 46, 68));
        jLabel18.setOpaque(true);
        PanelFondo.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 810));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 1402, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LabelLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelLogoMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_LabelLogoMouseClicked

    private void LabelVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelVolverMouseClicked
        // TODO add your handling code here:
        if (ConsultarTareas.bandera == true) {
            this.dispose();
        } else {
            PanelAdmin panelA = new PanelAdmin();
            panelA.setVisible(true);
            this.dispose();
        }


    }//GEN-LAST:event_LabelVolverMouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel10MouseClicked

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
            java.util.logging.Logger.getLogger(ConsultarTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarTrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarTrabajadores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CampoDNI;
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
    static String idSeleccionado;
    String tipoSeleccionado;
    String id;
    String dni;
    String nombre;
    String apellidos;
    Long telefono;
    String email;
    String direccion;
    String agregadoPor;
    String empresa;
    String usuario;
    String contraseña;
    String tipo;
    String estado;
    Date fechaInicio;
    TableRowSorter<TableModel> sorter;
    static boolean banderaProyectos = false;
}

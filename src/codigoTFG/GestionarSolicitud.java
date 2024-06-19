/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoTFG;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.sql.*;
import javax.imageio.*;
import javax.swing.*;

/**
 *
 * @author Hugo
 */
public class GestionarSolicitud extends javax.swing.JFrame {

    /**
     * Creates new form GestionarSolicitud
     */
    public GestionarSolicitud() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(getIconImage());
        Connection cn = conexion.Conexion.conectar();
        try {

            PreparedStatement ps = cn.prepareStatement("SELECT ID, Titulo, Mensaje, Fecha, Estado, URLArchivoAdjunto, Respuesta, ID_Empleado, ID_Administrador FROM solicitudes WHERE ID = ?");
            ps.setString(1, ConsultarSolicitudes.idSeleccionado);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                CampoID.setText(rs.getString(1));
                CampoTitulo.setText(rs.getString(2));
                CampoMensaje.setText(rs.getString(3));
                CampoFecha.setText(rs.getString(4));
                ComboBoxEstado.setSelectedItem(rs.getString(5));
                jLabel1.setText(rs.getString(6));
                CampoRespuesta.setText(rs.getString(7));
                CampoIDEmpleado.setText(rs.getString(8));
                CampoIDAdmin.setText(rs.getString(9));
            }

        } catch (SQLException e) {
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        CampoIDEmpleado = new javax.swing.JTextField();
        CampoIDAdmin = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        CampoID = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        CampoTitulo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        BotonModificarTarea = new javax.swing.JButton();
        BotonURL = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        CampoFecha = new javax.swing.JTextField();
        LabelVolver = new javax.swing.JLabel();
        ComboBoxEstado = new javax.swing.JComboBox<>();
        CheckBoxModificar = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CampoRespuesta = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        CampoMensaje = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        LabelLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel15.setForeground(java.awt.Color.white);
        jLabel15.setText("ID empleado:");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, -1, -1));

        CampoIDEmpleado.setBackground(new java.awt.Color(92, 116, 118));
        CampoIDEmpleado.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        CampoIDEmpleado.setForeground(java.awt.Color.white);
        CampoIDEmpleado.setDisabledTextColor(java.awt.Color.white);
        CampoIDEmpleado.setEnabled(false);
        jPanel1.add(CampoIDEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 60, 110, -1));

        CampoIDAdmin.setBackground(new java.awt.Color(92, 116, 118));
        CampoIDAdmin.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        CampoIDAdmin.setForeground(java.awt.Color.white);
        CampoIDAdmin.setDisabledTextColor(java.awt.Color.white);
        CampoIDAdmin.setEnabled(false);
        jPanel1.add(CampoIDAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 110, -1));

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel21.setForeground(java.awt.Color.white);
        jLabel21.setText("Respuesta:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 300, -1, -1));

        jLabel20.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel20.setForeground(java.awt.Color.white);
        jLabel20.setText("Mensaje:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setText("ID administrador:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, -1, -1));

        CampoID.setBackground(new java.awt.Color(92, 116, 118));
        CampoID.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        CampoID.setForeground(java.awt.Color.white);
        CampoID.setDisabledTextColor(java.awt.Color.white);
        CampoID.setEnabled(false);
        jPanel1.add(CampoID, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 70, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setText("ID:");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, -1, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setForeground(java.awt.Color.white);
        jLabel13.setText("Estado:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 150, -1, -1));

        CampoTitulo.setBackground(new java.awt.Color(92, 116, 118));
        CampoTitulo.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        CampoTitulo.setForeground(java.awt.Color.white);
        CampoTitulo.setDisabledTextColor(java.awt.Color.white);
        CampoTitulo.setEnabled(false);
        jPanel1.add(CampoTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 270, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setText("Título");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel16.setForeground(java.awt.Color.white);
        jLabel16.setText("URL archivo adjunto:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, -1, -1));

        BotonModificarTarea.setBackground(new java.awt.Color(87, 186, 144));
        BotonModificarTarea.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        BotonModificarTarea.setForeground(java.awt.Color.white);
        BotonModificarTarea.setText("Modificar solicitud");
        BotonModificarTarea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonModificarTarea.setEnabled(false);
        BotonModificarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonModificarTareaActionPerformed(evt);
            }
        });
        jPanel1.add(BotonModificarTarea, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 510, 290, 60));

        BotonURL.setBackground(new java.awt.Color(92, 116, 118));
        BotonURL.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        BotonURL.setForeground(java.awt.Color.white);
        BotonURL.setText("Cambiar foto");
        BotonURL.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonURL.setEnabled(false);
        BotonURL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonURLActionPerformed(evt);
            }
        });
        jPanel1.add(BotonURL, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 260, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(java.awt.Color.white);
        jLabel8.setText("Fecha:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, -1, -1));

        CampoFecha.setBackground(new java.awt.Color(92, 116, 118));
        CampoFecha.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        CampoFecha.setForeground(java.awt.Color.white);
        CampoFecha.setDisabledTextColor(java.awt.Color.white);
        CampoFecha.setEnabled(false);
        jPanel1.add(CampoFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, 250, -1));

        LabelVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flecha-hacia-atras.png"))); // NOI18N
        LabelVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabelVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelVolverMouseClicked(evt);
            }
        });
        jPanel1.add(LabelVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 70, 70));

        ComboBoxEstado.setBackground(new java.awt.Color(92, 116, 118));
        ComboBoxEstado.setForeground(java.awt.Color.white);
        ComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Retrasada", "Pendiente" }));
        ComboBoxEstado.setEnabled(false);
        jPanel1.add(ComboBoxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 180, 250, 40));

        CheckBoxModificar.setBackground(new java.awt.Color(26, 46, 68));
        CheckBoxModificar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        CheckBoxModificar.setForeground(java.awt.Color.white);
        CheckBoxModificar.setText("Modificar");
        CheckBoxModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CheckBoxModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBoxModificarActionPerformed(evt);
            }
        });
        jPanel1.add(CheckBoxModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, -1, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel14.setForeground(java.awt.Color.white);
        jLabel14.setText("x");
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1380, 20, 20, 30));

        CampoRespuesta.setBackground(new java.awt.Color(92, 116, 118));
        CampoRespuesta.setColumns(20);
        CampoRespuesta.setForeground(java.awt.Color.white);
        CampoRespuesta.setRows(5);
        CampoRespuesta.setDisabledTextColor(java.awt.Color.white);
        CampoRespuesta.setEnabled(false);
        jScrollPane2.setViewportView(CampoRespuesta);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 330, 260, 100));

        CampoMensaje.setBackground(new java.awt.Color(92, 116, 118));
        CampoMensaje.setColumns(20);
        CampoMensaje.setForeground(java.awt.Color.white);
        CampoMensaje.setRows(5);
        CampoMensaje.setDisabledTextColor(java.awt.Color.white);
        CampoMensaje.setEnabled(false);
        jScrollPane1.setViewportView(CampoMensaje);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, 260, 100));

        jLabel4.setFont(new java.awt.Font("Poor Richard", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(87, 186, 144));
        jLabel4.setText("PlanifiKa");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, 40));

        LabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoIcono.png"))); // NOI18N
        LabelLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelLogoMouseClicked(evt);
            }
        });
        jPanel1.add(LabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 40));

        jLabel1.setForeground(java.awt.Color.white);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 260, 30));

        jLabel19.setBackground(new java.awt.Color(26, 46, 68));
        jLabel19.setOpaque(true);
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1420, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonModificarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonModificarTareaActionPerformed
        // TODO add your handling code here:

        Connection cn = conexion.Conexion.conectar();
        try {

            PreparedStatement ps = cn.prepareStatement("UPDATE solicitudes SET Titulo = ?, Mensaje = ?, Fecha = ?, Estado = ?, URLArchivoAdjunto = ? WHERE ID = ?");

            ps.setString(1, CampoTitulo.getText());
            ps.setString(2, CampoMensaje.getText());
            ps.setString(3, CampoFecha.getText());
            ps.setString(4, ComboBoxEstado.getSelectedItem().toString());
            ps.setString(5, jLabel1.getText());
            ps.setString(6, CampoID.getText());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Solicitud actualizada con éxito");
            ConsultarTrabajadores consultarT = new ConsultarTrabajadores();
            consultarT.setVisible(true);
            this.dispose();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_BotonModificarTareaActionPerformed

    private void LabelVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelVolverMouseClicked
        // TODO add your handling code here:
        ConsultarTrabajadores consultarT = new ConsultarTrabajadores();
        consultarT.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_LabelVolverMouseClicked

    private void CheckBoxModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBoxModificarActionPerformed
        // TODO add your handling code here:
        if (CheckBoxModificar.isSelected()) {
            CampoTitulo.setEnabled(true);
            CampoMensaje.setEnabled(true);
            ComboBoxEstado.setEnabled(true);
            BotonModificarTarea.setEnabled(true);
            BotonURL.setEnabled(true);
        }
        if (!CheckBoxModificar.isSelected()) {
            CampoTitulo.setEnabled(false);
            CampoMensaje.setEnabled(false);
            ComboBoxEstado.setEnabled(false);
            BotonModificarTarea.setEnabled(false);
            BotonURL.setEnabled(false);
        }
    }//GEN-LAST:event_CheckBoxModificarActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void BotonURLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonURLActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        String rutaCarpeta = "src/images";
        File carpeta = new File(rutaCarpeta);
        fileChooser.setCurrentDirectory(carpeta);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            urlImagen = archivoSeleccionado.getName();
            try {
                fotoSeleccionada = ImageIO.read(archivoSeleccionado);
                jLabel1.setText(urlImagen);
            } catch (IOException e) {
                System.out.println("Error al cargar la foto: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_BotonURLActionPerformed

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
            java.util.logging.Logger.getLogger(GestionarSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionarSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionarSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionarSolicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarSolicitud().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonModificarTarea;
    private javax.swing.JButton BotonURL;
    private javax.swing.JTextField CampoFecha;
    private javax.swing.JTextField CampoID;
    private javax.swing.JTextField CampoIDAdmin;
    private javax.swing.JTextField CampoIDEmpleado;
    private javax.swing.JTextArea CampoMensaje;
    private javax.swing.JTextArea CampoRespuesta;
    private javax.swing.JTextField CampoTitulo;
    private javax.swing.JCheckBox CheckBoxModificar;
    private javax.swing.JComboBox<String> ComboBoxEstado;
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JLabel LabelVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
  String urlImagen;
    public static BufferedImage fotoSeleccionada;
}

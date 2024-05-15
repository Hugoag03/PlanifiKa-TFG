/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoTFG;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Hugo
 */
public class CrearTrabajador extends javax.swing.JFrame {

    /**
     * Creates new form CrearEmpleado
     */
    public CrearTrabajador() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(getIconImage());
        CampoFechaInicio.setText(LocalDate.now().toString());

        Connection cn = conexion.Conexion.conectar();
        try {

            PreparedStatement ps = cn.prepareStatement("SELECT Nombre, Apellidos FROM usuarios WHERE Tipo = ?");
            ps.setString(1, "Administrador");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ComboBoxAgregadoPor.addItem(rs.getString(1) + " " + rs.getString(2));
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        PanelFondo = new javax.swing.JPanel();
        LabelLogo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CampoTelefono = new javax.swing.JTextField();
        CampoEmail = new javax.swing.JTextField();
        CampoEmpresa = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        CampoDireccion = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        CampoFechaInicio = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        CampoDNI = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        CampoNombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        BotonCrearEmpleado = new javax.swing.JButton();
        BotonFoto = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        CampoApellidos = new javax.swing.JTextField();
        ComboTipo = new javax.swing.JComboBox<>();
        BotonActivo = new javax.swing.JRadioButton();
        BotonInactivo = new javax.swing.JRadioButton();
        ComboBoxAgregadoPor = new javax.swing.JComboBox<>();
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
        PanelFondo.add(LabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 40, 40));

        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("PlanifiKa");
        PanelFondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, 40));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("Teléfono:");
        PanelFondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 310, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setText("Correo electrónico:");
        PanelFondo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, -1, -1));

        CampoTelefono.setBackground(java.awt.Color.black);
        CampoTelefono.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        CampoTelefono.setForeground(java.awt.Color.white);
        PanelFondo.add(CampoTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, 250, -1));

        CampoEmail.setBackground(java.awt.Color.black);
        CampoEmail.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        CampoEmail.setForeground(java.awt.Color.white);
        PanelFondo.add(CampoEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 270, -1));

        CampoEmpresa.setBackground(java.awt.Color.black);
        CampoEmpresa.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        CampoEmpresa.setForeground(java.awt.Color.white);
        PanelFondo.add(CampoEmpresa, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 650, 270, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setText("Empresa:");
        PanelFondo.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 620, -1, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setForeground(java.awt.Color.white);
        jLabel13.setText("Estado:");
        PanelFondo.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, -1, -1));

        CampoDireccion.setBackground(java.awt.Color.black);
        CampoDireccion.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        CampoDireccion.setForeground(java.awt.Color.white);
        CampoDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoDireccionActionPerformed(evt);
            }
        });
        PanelFondo.add(CampoDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 340, 260, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setForeground(java.awt.Color.white);
        jLabel14.setText("Dirección:");
        PanelFondo.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 310, -1, -1));

        CampoFechaInicio.setBackground(java.awt.Color.black);
        CampoFechaInicio.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        CampoFechaInicio.setForeground(java.awt.Color.white);
        CampoFechaInicio.setEnabled(false);
        PanelFondo.add(CampoFechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 480, 260, -1));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel15.setForeground(java.awt.Color.white);
        jLabel15.setText("Fecha de inicio:");
        PanelFondo.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 450, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("Tipo:");
        PanelFondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 450, -1, -1));

        CampoDNI.setBackground(java.awt.Color.black);
        CampoDNI.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        CampoDNI.setForeground(java.awt.Color.white);
        CampoDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CampoDNIActionPerformed(evt);
            }
        });
        PanelFondo.add(CampoDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 180, 260, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setText("DNI:");
        PanelFondo.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 150, -1, -1));

        CampoNombre.setBackground(java.awt.Color.black);
        CampoNombre.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        CampoNombre.setForeground(java.awt.Color.white);
        PanelFondo.add(CampoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 270, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setText("Nombre:");
        PanelFondo.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel16.setForeground(java.awt.Color.white);
        jLabel16.setText("Foto:");
        PanelFondo.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 620, -1, -1));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel17.setForeground(java.awt.Color.white);
        jLabel17.setText("Agregado por:");
        PanelFondo.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 620, -1, -1));

        BotonCrearEmpleado.setBackground(java.awt.Color.black);
        BotonCrearEmpleado.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        BotonCrearEmpleado.setForeground(java.awt.Color.white);
        BotonCrearEmpleado.setText("Crear empleado");
        BotonCrearEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonCrearEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCrearEmpleadoActionPerformed(evt);
            }
        });
        PanelFondo.add(BotonCrearEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 760, 240, 60));

        BotonFoto.setBackground(java.awt.Color.black);
        BotonFoto.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        BotonFoto.setForeground(java.awt.Color.white);
        BotonFoto.setText("Añadir foto");
        BotonFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonFotoActionPerformed(evt);
            }
        });
        PanelFondo.add(BotonFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 650, 260, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(java.awt.Color.white);
        jLabel8.setText("Apellidos:");
        PanelFondo.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, -1, -1));

        CampoApellidos.setBackground(java.awt.Color.black);
        CampoApellidos.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        CampoApellidos.setForeground(java.awt.Color.white);
        PanelFondo.add(CampoApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, 250, -1));

        ComboTipo.setBackground(java.awt.Color.black);
        ComboTipo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        ComboTipo.setForeground(java.awt.Color.white);
        ComboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Jefe de proyecto", "Empleado" }));
        ComboTipo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelFondo.add(ComboTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 480, 260, -1));

        buttonGroup1.add(BotonActivo);
        BotonActivo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        BotonActivo.setForeground(java.awt.Color.white);
        BotonActivo.setText("Activo");
        BotonActivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelFondo.add(BotonActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 480, -1, -1));

        buttonGroup1.add(BotonInactivo);
        BotonInactivo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        BotonInactivo.setForeground(java.awt.Color.white);
        BotonInactivo.setText("Inactivo");
        BotonInactivo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelFondo.add(BotonInactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 480, -1, -1));

        ComboBoxAgregadoPor.setBackground(java.awt.Color.black);
        ComboBoxAgregadoPor.setForeground(java.awt.Color.white);
        PanelFondo.add(ComboBoxAgregadoPor, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 650, 270, 40));

        LabelVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/volveratras.png"))); // NOI18N
        LabelVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabelVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelVolverMouseClicked(evt);
            }
        });
        PanelFondo.add(LabelVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 760, 70, 70));

        labelFondo.setBackground(java.awt.Color.black);
        labelFondo.setForeground(java.awt.Color.white);
        labelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondotfg.png"))); // NOI18N
        PanelFondo.add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 870));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 1401, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 859, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LabelLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelLogoMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_LabelLogoMouseClicked

    private void CampoDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoDireccionActionPerformed

    private void CampoDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CampoDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CampoDNIActionPerformed
    public static BufferedImage fotoSeleccionada;
    private void BotonFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonFotoActionPerformed
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
            } catch (IOException e) {
                System.out.println("Error al cargar la foto: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_BotonFotoActionPerformed

    private void BotonCrearEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCrearEmpleadoActionPerformed
        // TODO add your handling code here:

        if (CampoNombre.getText() != null && CampoApellidos.getText() != null && CampoDNI.getText() != null && CampoDireccion.getText() != null && CampoEmail.getText() != null && CampoEmpresa.getText() != null && CampoFechaInicio.getText() != null) {

            String usuario = JOptionPane.showInputDialog("Introduzca el nombre de usuario para el empleado");
            String contraseña = JOptionPane.showInputDialog("Introduzca la contraseña para el empleado");

            Connection cn = conexion.Conexion.conectar();
            if (BotonActivo.isSelected()) {
                estado = "Activo";
            }
            if (BotonInactivo.isSelected()) {
                estado = "Inactivo";
            }

            if (ComboTipo.getSelectedItem().toString().equals("Administrador")) {
                tipoEmpleado = "Administrador";
            }
            if (ComboTipo.getSelectedItem().toString().equals("Jefe de proyecto")) {
                tipoEmpleado = "Jefe de proyecto";
            }
            if (ComboTipo.getSelectedItem().toString().equals("Empleado")) {
                tipoEmpleado = "Empleado";
            }

            try {
                PreparedStatement ps = cn.prepareStatement("INSERT INTO usuarios (DNI, Nombre, Apellidos, Telefono, Email, Empresa, Direccion, NombreUsuario, Contraseña, Estado, Tipo, FechaInicio, AgregadoPor, URLFoto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

                ps.setString(1, CampoDNI.getText());
                ps.setString(2, CampoNombre.getText());
                ps.setString(3, CampoApellidos.getText());
                ps.setString(4, CampoTelefono.getText());
                ps.setString(5, CampoEmail.getText());
                ps.setString(6, CampoEmpresa.getText());
                ps.setString(7, CampoDireccion.getText());
                ps.setString(8, usuario);
                ps.setString(9, contraseña);
                ps.setString(10, estado);
                ps.setString(11, tipoEmpleado);
                ps.setString(12, CampoFechaInicio.getText());
                ps.setString(13, ComboBoxAgregadoPor.getSelectedItem().toString());
                ps.setString(14, urlImagen);

                ps.executeUpdate();

                System.out.println("Trabajador creado con éxito");
                PanelAdmin panelA = new PanelAdmin();
                panelA.setVisible(true);
                this.dispose();

            } catch (SQLException e) {
                e.printStackTrace();

            }
        } else {
            JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");
        }
    }//GEN-LAST:event_BotonCrearEmpleadoActionPerformed

    private void LabelVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelVolverMouseClicked
        // TODO add your handling code here:
        PanelAdmin panelA = new PanelAdmin();
        panelA.setVisible(true);
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
            java.util.logging.Logger.getLogger(CrearTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearTrabajador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton BotonActivo;
    private javax.swing.JButton BotonCrearEmpleado;
    private javax.swing.JButton BotonFoto;
    private javax.swing.JRadioButton BotonInactivo;
    private javax.swing.JTextField CampoApellidos;
    private javax.swing.JTextField CampoDNI;
    private javax.swing.JTextField CampoDireccion;
    private javax.swing.JTextField CampoEmail;
    private javax.swing.JTextField CampoEmpresa;
    private javax.swing.JTextField CampoFechaInicio;
    private javax.swing.JTextField CampoNombre;
    private javax.swing.JTextField CampoTelefono;
    private javax.swing.JComboBox<String> ComboBoxAgregadoPor;
    private javax.swing.JComboBox<String> ComboTipo;
    private javax.swing.JLabel LabelLogo;
    private javax.swing.JLabel LabelVolver;
    private javax.swing.JPanel PanelFondo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labelFondo;
    // End of variables declaration//GEN-END:variables
    String urlImagen;
    String estado;
    String tipoEmpleado;
}

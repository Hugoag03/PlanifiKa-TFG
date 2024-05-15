/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoTFG;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author Hugo
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form PantallaInicio
     */
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(getIconImage());
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

        jLabel3 = new javax.swing.JLabel();
        PanelFondo = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CampoUsuario = new javax.swing.JTextField();
        CampoContraseña = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelFondo = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 20)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Bienvenido al menú de inicio de sesión");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        PanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoTFGGrande.png"))); // NOI18N
        PanelFondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 470, 490));

        jSeparator1.setBackground(java.awt.Color.white);
        jSeparator1.setForeground(java.awt.Color.white);
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        PanelFondo.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 10, 530));

        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("PlanifiKa");
        PanelFondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoIcono.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        PanelFondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 40));

        CampoUsuario.setBackground(java.awt.Color.black);
        CampoUsuario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CampoUsuario.setForeground(java.awt.Color.white);
        PanelFondo.add(CampoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 300, 40));

        CampoContraseña.setBackground(java.awt.Color.black);
        CampoContraseña.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CampoContraseña.setForeground(java.awt.Color.white);
        PanelFondo.add(CampoContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 300, 40));

        jButton1.setBackground(java.awt.Color.black);
        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setForeground(java.awt.Color.white);
        jButton1.setText("Acceder");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        PanelFondo.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, 150, 50));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Contraseña");
        PanelFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, -1, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Usuario");
        PanelFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, -1, -1));

        labelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/fondotfg.png"))); // NOI18N
        PanelFondo.add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 1068, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String contraseña = new String(CampoContraseña.getPassword());

        if (CampoUsuario.getText().isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos");

        } else {

            Connection cn = conexion.Conexion.conectar();
            try {
                PreparedStatement ps = cn.prepareStatement("SELECT * FROM usuarios WHERE NombreUsuario = ? AND Contraseña = ?");
                ps.setString(1, CampoUsuario.getText());
                ps.setString(2, contraseña);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    tipoEmpleado = rs.getString("tipo");
                    idInicioSesion = rs.getInt("ID");
                    PanelGeneral panelG = new PanelGeneral();
                    panelG.setVisible(true);
                    this.dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "Sus credenciales no coinciden");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField CampoContraseña;
    private javax.swing.JTextField CampoUsuario;
    private javax.swing.JPanel PanelFondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelFondo;
    // End of variables declaration//GEN-END:variables
    static String nombreUsuario;
    static String contraseña;
    static String tipoEmpleado;
    static int idInicioSesion;
}

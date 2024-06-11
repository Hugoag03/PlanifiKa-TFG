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
import org.netbeans.lib.awtextra.AbsoluteConstraints;

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

        ShadowPanel shadowPanel = new ShadowPanel();
        shadowPanel.setLayout(new BorderLayout()); 

        shadowPanel.add(jPanel1, BorderLayout.CENTER);

        PanelFondo.add(shadowPanel, new AbsoluteConstraints(310, 110, 1050, 530));
        ojoCerradoIcon = new ImageIcon(getClass().getResource("/images/ojo-cerrado.png"));
        ojoAbiertoIcon = new ImageIcon(getClass().getResource("/images/ojo-abierto.png"));

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
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        CampoUsuario = new javax.swing.JTextField();
        CampoContraseña = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        labelFondo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 20)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Bienvenido al menú de inicio de sesión");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelFondo.setBackground(new java.awt.Color(27, 29, 41));
        PanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoIcono.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 40));

        jLabel12.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setText("gestionar tareas, organizar proyectos");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

        jLabel13.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel13.setForeground(java.awt.Color.white);
        jLabel13.setText("y mantener un control efectivo de tu tiempo.");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jLabel15.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel15.setForeground(java.awt.Color.white);
        jLabel15.setText("PlanifiKa te ayuda a alcanzar tus metas de");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        jLabel14.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel14.setForeground(java.awt.Color.white);
        jLabel14.setText("Con una interfaz intuitiva y funciones poderosas,");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jLabel16.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel16.setForeground(java.awt.Color.white);
        jLabel16.setText("manera eficiente y sin complicaciones.");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jButton2.setBackground(new java.awt.Color(26, 44, 68));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setForeground(java.awt.Color.white);
        jButton2.setText("Conocer más");
        jButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(89, 192, 145)));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 150, 50));

        jLabel11.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setText("PlanifiKa es tu solución completa para gestionar tareas");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, 20));

        jLabel5.setFont(new java.awt.Font("Lucida Sans", 1, 36)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("Planifica con PlanifiKa");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setText("x");
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, 20, 30));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ojo-cerrado.png"))); // NOI18N
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel17MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 270, 40, 30));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(java.awt.Color.lightGray);
        jLabel2.setText("Introduzca su usuario");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, -1, -1));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(java.awt.Color.lightGray);
        jLabel1.setText("Introduzca su contraseña");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, -1, -1));

        CampoUsuario.setBackground(java.awt.Color.white);
        CampoUsuario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CampoUsuario.setForeground(java.awt.Color.black);
        CampoUsuario.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(89, 192, 145)));
        CampoUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CampoUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                CampoUsuarioFocusLost(evt);
            }
        });
        CampoUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CampoUsuarioMouseClicked(evt);
            }
        });
        jPanel1.add(CampoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 300, 40));

        CampoContraseña.setBackground(java.awt.Color.white);
        CampoContraseña.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CampoContraseña.setForeground(java.awt.Color.black);
        CampoContraseña.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(89, 192, 145)));
        CampoContraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CampoContraseñaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                CampoContraseñaFocusLost(evt);
            }
        });
        jPanel1.add(CampoContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 260, 40));

        jButton1.setBackground(java.awt.Color.white);
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setForeground(java.awt.Color.black);
        jButton1.setText("Acceder");
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(89, 192, 145)));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 310, 50));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(java.awt.Color.black);
        jLabel7.setText("Inicio de sesión");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, -1, -1));

        labelFondo.setBackground(java.awt.Color.white);
        labelFondo.setForeground(java.awt.Color.white);
        labelFondo.setOpaque(true);
        jPanel1.add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, 370, 410));

        jLabel6.setBackground(new java.awt.Color(26, 46, 68));
        jLabel6.setOpaque(true);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 530));

        jLabel4.setBackground(new java.awt.Color(92, 116, 118));
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 470, 540));

        PanelFondo.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 1050, 530));

        jLabel9.setFont(new java.awt.Font("Poor Richard", 1, 55)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setText("Bienvenido a tu Sistema Gestor de Tareas");
        PanelFondo.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        getContentPane().add(PanelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 711));

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

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void CampoUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CampoUsuarioMouseClicked
        // TODO add your handling code here:+

    }//GEN-LAST:event_CampoUsuarioMouseClicked

    private void CampoUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CampoUsuarioFocusGained
        // TODO add your handling code here:
        jLabel2.setVisible(false);
    }//GEN-LAST:event_CampoUsuarioFocusGained

    private void CampoUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CampoUsuarioFocusLost
        // TODO add your handling code here:
        if (CampoUsuario.getText().isEmpty()) {
            jLabel2.setVisible(true);
        }
    }//GEN-LAST:event_CampoUsuarioFocusLost

    private void CampoContraseñaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CampoContraseñaFocusGained
        // TODO add your handling code here:
        jLabel1.setVisible(false);
    }//GEN-LAST:event_CampoContraseñaFocusGained

    private void CampoContraseñaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CampoContraseñaFocusLost
        // TODO add your handling code here:
        if (CampoContraseña.getText().isEmpty()) {
            jLabel1.setVisible(true);
        }
    }//GEN-LAST:event_CampoContraseñaFocusLost

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel10MouseClicked
  
    private void jLabel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseClicked
        // TODO add your handling code here:
         if (showing) {
                    // Ocultar la contraseña
                    CampoContraseña.setEchoChar('*');
                    jLabel17.setIcon(ojoCerradoIcon);
                } else {
                    // Mostrar la contraseña
                    CampoContraseña.setEchoChar((char) 0);
                    jLabel17.setIcon(ojoAbiertoIcon);
                }
                showing = !showing;
                
    }//GEN-LAST:event_jLabel17MouseClicked

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
    public static javax.swing.JPasswordField CampoContraseña;
    private javax.swing.JTextField CampoUsuario;
    private javax.swing.JPanel PanelFondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    public static javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelFondo;
    // End of variables declaration//GEN-END:variables
    static String nombreUsuario;
    static String contraseña;
    static String tipoEmpleado;
    static int idInicioSesion;
     public Icon ojoCerradoIcon;
    public Icon ojoAbiertoIcon;
    private boolean showing = false;
    
}

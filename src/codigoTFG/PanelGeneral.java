/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoTFG;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

/**
 *
 * @author Hugo
 */
public class PanelGeneral extends javax.swing.JFrame {

    /**
     * Creates new form PanelAdministracion
     */
    public PanelGeneral() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        LabelCirculo.setVisible(false);
        LabelCirculo1.setVisible(false);
        LabelCirculo2.setVisible(false);
        LabelCirculo3.setVisible(false);
        setIconImage(getIconImage());
        jLabel1.setBackground(new Color(255, 255, 255, 100)); 
        
        if (Login.tipoEmpleado.equals("JefeProyecto")) {
            ImagenAdmin.setEnabled(false);
            ImagenEmpleado.setEnabled(false);

        }
        if (Login.tipoEmpleado.equals("Empleado")) {
            ImagenAdmin.setEnabled(false);
            ImagenJefeProyecto.setEnabled(false);
            LabelCirculo.setEnabled(false);
            LabelCirculo1.setEnabled(false);
            LabelAdmin.setEnabled(false);
            LabelJefeProyecto.setEnabled(false);

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
        jLabel9 = new javax.swing.JLabel();
        ImagenJefeProyecto = new javax.swing.JLabel();
        ImagenPerfil = new javax.swing.JLabel();
        ImagenEmpleado = new javax.swing.JLabel();
        ImagenAdmin = new javax.swing.JLabel();
        LabelJefeProyecto = new javax.swing.JLabel();
        LabelPerfil = new javax.swing.JLabel();
        LabelEmpleado = new javax.swing.JLabel();
        LabelAdmin = new javax.swing.JLabel();
        LabelCirculo = new javax.swing.JLabel();
        LabelCirculo1 = new javax.swing.JLabel();
        LabelCirculo2 = new javax.swing.JLabel();
        LabelCirculo3 = new javax.swing.JLabel();
        LabelCerrarSesion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        PanelFondo.setMinimumSize(new java.awt.Dimension(1266, 587));
        PanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei Light", 1, 36)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setText("¿Qué departamento desea visitar?");
        PanelFondo.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, -1, -1));

        ImagenJefeProyecto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lider.png"))); // NOI18N
        ImagenJefeProyecto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ImagenJefeProyecto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImagenJefeProyectoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ImagenJefeProyectoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ImagenJefeProyectoMouseExited(evt);
            }
        });
        PanelFondo.add(ImagenJefeProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 140, 150));

        ImagenPerfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/perfil.png"))); // NOI18N
        ImagenPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ImagenPerfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImagenPerfilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ImagenPerfilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ImagenPerfilMouseExited(evt);
            }
        });
        PanelFondo.add(ImagenPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 220, 140, 130));

        ImagenEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/empleados.png"))); // NOI18N
        ImagenEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ImagenEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImagenEmpleadoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ImagenEmpleadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ImagenEmpleadoMouseExited(evt);
            }
        });
        PanelFondo.add(ImagenEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, 140, 130));

        ImagenAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/admin.png"))); // NOI18N
        ImagenAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ImagenAdmin.setFocusable(false);
        ImagenAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ImagenAdminMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ImagenAdminMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ImagenAdminMouseExited(evt);
            }
        });
        PanelFondo.add(ImagenAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 140, 140));

        LabelJefeProyecto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelJefeProyecto.setForeground(java.awt.Color.black);
        LabelJefeProyecto.setText("JEFES DE PROYECTO");
        PanelFondo.add(LabelJefeProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, -1, -1));

        LabelPerfil.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelPerfil.setForeground(java.awt.Color.black);
        LabelPerfil.setText("VER PERFIL");
        PanelFondo.add(LabelPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 390, 110, -1));

        LabelEmpleado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelEmpleado.setForeground(java.awt.Color.black);
        LabelEmpleado.setText("EMPLEADOS ");
        PanelFondo.add(LabelEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 390, 120, -1));

        LabelAdmin.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        LabelAdmin.setForeground(java.awt.Color.black);
        LabelAdmin.setText("ADMINISTRADORES");
        PanelFondo.add(LabelAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, -1, -1));

        LabelCirculo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelCirculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circuloback.png"))); // NOI18N
        PanelFondo.add(LabelCirculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 220, 190));

        LabelCirculo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelCirculo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circuloback.png"))); // NOI18N
        PanelFondo.add(LabelCirculo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 220, 190));

        LabelCirculo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelCirculo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circuloback.png"))); // NOI18N
        PanelFondo.add(LabelCirculo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 190, 220, 190));

        LabelCirculo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelCirculo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/circuloback.png"))); // NOI18N
        PanelFondo.add(LabelCirculo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 190, 220, 190));

        LabelCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cerrar-sesion.png"))); // NOI18N
        LabelCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabelCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelCerrarSesionMouseClicked(evt);
            }
        });
        PanelFondo.add(LabelCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 70, 70));

        jLabel1.setBackground(java.awt.Color.white);
        jLabel1.setOpaque(true);
        PanelFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 1130, 280));

        jLabel6.setBackground(new java.awt.Color(147, 63, 63));
        jLabel6.setOpaque(true);
        PanelFondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 1256, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ImagenPerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenPerfilMouseClicked
        // TODO add your handling code here:
        Perfil perfil = new Perfil();
        perfil.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ImagenPerfilMouseClicked

    private void ImagenAdminMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenAdminMouseEntered
        // TODO add your handling code here:
        LabelCirculo.setVisible(true);
    }//GEN-LAST:event_ImagenAdminMouseEntered

    private void ImagenAdminMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenAdminMouseExited
        // TODO add your handling code here:
        LabelCirculo.setVisible(false);
    }//GEN-LAST:event_ImagenAdminMouseExited

    private void ImagenJefeProyectoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenJefeProyectoMouseEntered
        // TODO add your handling code here:
        LabelCirculo1.setVisible(true);
    }//GEN-LAST:event_ImagenJefeProyectoMouseEntered

    private void ImagenJefeProyectoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenJefeProyectoMouseExited
        // TODO add your handling code here:
        LabelCirculo1.setVisible(false);
    }//GEN-LAST:event_ImagenJefeProyectoMouseExited

    private void ImagenEmpleadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenEmpleadoMouseEntered
        // TODO add your handling code here:
        LabelCirculo2.setVisible(true);
    }//GEN-LAST:event_ImagenEmpleadoMouseEntered

    private void ImagenEmpleadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenEmpleadoMouseExited
        // TODO add your handling code here:
        LabelCirculo2.setVisible(false);
    }//GEN-LAST:event_ImagenEmpleadoMouseExited

    private void ImagenPerfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenPerfilMouseEntered
        // TODO add your handling code here:
        LabelCirculo3.setVisible(true);
    }//GEN-LAST:event_ImagenPerfilMouseEntered

    private void ImagenPerfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenPerfilMouseExited
        // TODO add your handling code here:
        LabelCirculo3.setVisible(false);
    }//GEN-LAST:event_ImagenPerfilMouseExited

    private void ImagenAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenAdminMouseClicked
        // TODO add your handling code here:
        if (Login.tipoEmpleado.equals("Empleado") || Login.tipoEmpleado.equals("JefeProyecto")) {
            JOptionPane.showMessageDialog(null, "No tienes acceso a este departamento");
        } else {
            PanelAdmin panelA = new PanelAdmin();
            panelA.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_ImagenAdminMouseClicked

    private void ImagenJefeProyectoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenJefeProyectoMouseClicked
        // TODO add your handling code here:
        if (Login.tipoEmpleado.equals("Empleado")) {
            JOptionPane.showMessageDialog(null, "No tienes acceso a este departamento");
        } else {
            PanelJefeProyecto panelJP = new PanelJefeProyecto();
            panelJP.setVisible(true);
            this.dispose();
        }

    }//GEN-LAST:event_ImagenJefeProyectoMouseClicked

    private void ImagenEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ImagenEmpleadoMouseClicked
        // TODO add your handling code here:
        PanelEmpleado panelE = new PanelEmpleado();
        panelE.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ImagenEmpleadoMouseClicked

    private void LabelCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelCerrarSesionMouseClicked
        // TODO add your handling code here:
        int respuesta = JOptionPane.showOptionDialog(null, "¿Desea cerrar sesión?", "Cerrar sesión", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION, null, null, null);

        if (respuesta == 0) {
            Login login = new Login();
            login.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_LabelCerrarSesionMouseClicked

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
            java.util.logging.Logger.getLogger(PanelGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelGeneral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelGeneral().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    javax.swing.JLabel ImagenAdmin;
    javax.swing.JLabel ImagenEmpleado;
    javax.swing.JLabel ImagenJefeProyecto;
    private javax.swing.JLabel ImagenPerfil;
    private javax.swing.JLabel LabelAdmin;
    private javax.swing.JLabel LabelCerrarSesion;
    private javax.swing.JLabel LabelCirculo;
    private javax.swing.JLabel LabelCirculo1;
    private javax.swing.JLabel LabelCirculo2;
    private javax.swing.JLabel LabelCirculo3;
    private javax.swing.JLabel LabelEmpleado;
    private javax.swing.JLabel LabelJefeProyecto;
    private javax.swing.JLabel LabelPerfil;
    javax.swing.JPanel PanelFondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}

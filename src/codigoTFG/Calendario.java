/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigoTFG;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Hugo
 */
public class Calendario extends javax.swing.JFrame {

    /**
     * Creates new form PanelAdministracion
     */
    private JLabel mesLabel;
    private JPanel panelDias;

    public Calendario() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(getIconImage());
        Timer timer = new Timer(0, new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                ActualizarHora.actualizarHora(labelhora);

            }
        });
        timer.start();

        setTitle("Calendario");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mesLabel = new JLabel();
        mesLabel.setHorizontalAlignment(SwingConstants.CENTER);

        panelDias = new JPanel(new GridLayout(0, 7));

        JButton mesAnteriorButton = new JButton("<<");
        mesAnteriorButton.setFont(new Font("Arial", Font.BOLD, 16));
        mesAnteriorButton.setFocusPainted(false);
        mesAnteriorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para mostrar el mes anterior
            }
        });
        mesAnteriorButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mesAnteriorButton.setBackground(Color.LIGHT_GRAY);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                mesAnteriorButton.setBackground(UIManager.getColor("control"));
            }
        });

        JButton mesSiguienteButton = new JButton(">>");
        mesSiguienteButton.setFont(new Font("Arial", Font.BOLD, 16));
        mesSiguienteButton.setFocusPainted(false);
        mesSiguienteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para mostrar el siguiente mes
            }
        });
        mesSiguienteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mesSiguienteButton.setBackground(Color.LIGHT_GRAY);
                
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                mesSiguienteButton.setBackground(UIManager.getColor("control"));
            }
        });

        JPanel panelBotones = new JPanel(new BorderLayout());
        panelBotones.add(mesAnteriorButton, BorderLayout.WEST);
        panelBotones.add(mesLabel, BorderLayout.CENTER);
        panelBotones.add(mesSiguienteButton, BorderLayout.EAST);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelBotones, BorderLayout.NORTH);
        getContentPane().add(panelDias, BorderLayout.CENTER);

        setVisible(true);

        mostrarMesActual();

    }

    private void mostrarMesActual() {
        Calendar calendario = Calendar.getInstance();
        int mes = calendario.get(Calendar.MONTH);
        int año = calendario.get(Calendar.YEAR);

        mostrarMes(año, mes);
    }

    private void mostrarMes(int año, int mes) {
        Calendar calendario = new GregorianCalendar(año, mes, 1);
        int diasEnMes = calendario.getActualMaximum(Calendar.DAY_OF_MONTH);
        int diaSemanaInicio = calendario.get(Calendar.DAY_OF_WEEK);

        mesLabel.setText(new SimpleDateFormat("MMMM yyyy").format(calendario.getTime()));

        panelDias.removeAll();

        String[] diasSemana = {"Dom", "Lun", "Mar", "Mié", "Jue", "Vie", "Sáb"};
        for (String dia : diasSemana) {
            JLabel label = new JLabel(dia, SwingConstants.CENTER);
            panelDias.add(label);
        }

        for (int i = 1; i < diaSemanaInicio; i++) {
            panelDias.add(new JLabel(""));
        }

        for (int i = 1; i <= diasEnMes; i++) {
            final int dia = i;
            JButton button = new JButton(Integer.toString(dia));
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.setFocusPainted(false);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Has seleccionado el día " + dia);
                }
            });
            button.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    button.setBackground(Color.LIGHT_GRAY);
                }

                public void mouseExited(java.awt.event.MouseEvent evt) {
                    button.setBackground(UIManager.getColor("control"));
                }
            });
            panelDias.add(button);
        }

        revalidate();
        repaint();
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
        labelhora = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        PanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/volveratras.png"))); // NOI18N
        LabelVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LabelVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelVolverMouseClicked(evt);
            }
        });
        PanelFondo.add(LabelVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 70, 70));

        labelhora.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        PanelFondo.add(labelhora, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 530, 150, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 1014, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LabelVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelVolverMouseClicked
        // TODO add your handling code here:
        PanelGeneral panelG = new PanelGeneral();
        panelG.setVisible(true);
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
            java.util.logging.Logger.getLogger(Calendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calendario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelVolver;
    private javax.swing.JPanel PanelFondo;
    public static javax.swing.JLabel labelhora;
    // End of variables declaration//GEN-END:variables
    int hora, minutos, segundos;
}

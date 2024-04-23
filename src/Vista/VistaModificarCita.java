package Vista;

import Controlador.ControladorAgendarCita;
import Controlador.ControladorDetalleCita;
import Controlador.ControladorMenuInicio;
import Controlador.ControladorModificarCita;
import Controlador.ControladorVerCitas;
import Modelo.VO.Cita;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
/**
 *
 * @author pesca
 */
public class VistaModificarCita extends javax.swing.JDialog {

    /**
     * Creates new form Ventana_4
     */
    public VistaModificarCita(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public VistaModificarCita() {
        super();
        initComponents();

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
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btn_regresar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lb_estetico = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comb_tipo = new javax.swing.JComboBox<>();
        comb_estetico = new javax.swing.JComboBox<>();
        combo_fechas = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txt_nomMascota = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);
        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel4.setBackground(new java.awt.Color(200, 228, 228));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setBackground(new java.awt.Color(0, 153, 204));
        jLabel1.setFont(new java.awt.Font("The munday free version", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 204));
        jLabel1.setText("MODIFICAR CITA");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBackground(new java.awt.Color(200, 228, 228));

        btn_regresar.setBackground(new java.awt.Color(255, 255, 255));
        btn_regresar.setFont(new java.awt.Font("The munday free version", 1, 14)); // NOI18N
        btn_regresar.setForeground(new java.awt.Color(0, 102, 255));
        btn_regresar.setText("Regresar");
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });

        btn_modificar.setBackground(new java.awt.Color(255, 255, 255));
        btn_modificar.setFont(new java.awt.Font("The munday free version", 1, 14)); // NOI18N
        btn_modificar.setForeground(new java.awt.Color(0, 102, 255));
        btn_modificar.setText("Modificar");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btn_modificar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btn_regresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(142, Short.MAX_VALUE)
                .addComponent(btn_regresar)
                .addGap(31, 31, 31)
                .addComponent(btn_modificar)
                .addGap(29, 29, 29))
        );

        getContentPane().add(jPanel5, java.awt.BorderLayout.LINE_END);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lb_estetico.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        lb_estetico.setForeground(new java.awt.Color(0, 153, 204));
        lb_estetico.setText("Estetico");
        lb_estetico.setVisible(false);

        jLabel4.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 204));
        jLabel4.setText("TIpo de cita");

        jLabel5.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 204));
        jLabel5.setText("FECHA");

        comb_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Revision", "Esterelizacion", "Estetico", "Vacunacion" }));
        comb_tipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comb_tipoItemStateChanged(evt);
            }
        });
        comb_tipo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                comb_tipoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                comb_tipoFocusLost(evt);
            }
        });
        comb_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comb_tipoActionPerformed(evt);
            }
        });

        comb_estetico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Baño", "Corte" }));
        comb_estetico.setVisible(false);
        comb_estetico.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                comb_esteticoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                comb_esteticoFocusLost(evt);
            }
        });

        combo_fechas.setEnabled(false);
        combo_fechas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                combo_fechasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                combo_fechasFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 204));
        jLabel3.setText("Nombre de tu mascota");

        txt_nomMascota.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_nomMascotaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_nomMascotaFocusLost(evt);
            }
        });
        txt_nomMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nomMascotaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txt_nomMascota, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(comb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb_estetico)
                            .addComponent(comb_estetico, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_fechas, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(45, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lb_estetico)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comb_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comb_estetico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_fechas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txt_nomMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void comb_tipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comb_tipoItemStateChanged
        // TODO add your handling code here:
        ControladorAgendarCita.evento();
    }//GEN-LAST:event_comb_tipoItemStateChanged

    private void comb_tipoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comb_tipoFocusGained
        // TODO add your handling code here:
        comb_tipo.setBackground(new Color(102,204,255));
    }//GEN-LAST:event_comb_tipoFocusGained

    private void comb_tipoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comb_tipoFocusLost
        // TODO add your handling code here:
        comb_tipo.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_comb_tipoFocusLost

    private void comb_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comb_tipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comb_tipoActionPerformed

    private void comb_esteticoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comb_esteticoFocusGained
        // TODO add your handling code here:
        comb_estetico.setBackground(new Color(102,204,255));

    }//GEN-LAST:event_comb_esteticoFocusGained

    private void comb_esteticoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_comb_esteticoFocusLost
        // TODO add your handling code here:
        comb_estetico.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_comb_esteticoFocusLost

    private void combo_fechasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_fechasFocusGained
        // TODO add your handling code here:
        combo_fechas.setBackground(new Color(102,204,255));
    }//GEN-LAST:event_combo_fechasFocusGained

    private void combo_fechasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_combo_fechasFocusLost
        // TODO add your handling code here:
        combo_fechas.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_combo_fechasFocusLost

    private void txt_nomMascotaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nomMascotaFocusGained
        // TODO add your handling code here:
        txt_nomMascota.setBackground(new Color(102,204,255));
    }//GEN-LAST:event_txt_nomMascotaFocusGained

    private void txt_nomMascotaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nomMascotaFocusLost
        // TODO add your handling code here:
        txt_nomMascota.setBackground(new Color(204,204,204));
    }//GEN-LAST:event_txt_nomMascotaFocusLost

    private void txt_nomMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nomMascotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nomMascotaActionPerformed

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        ControladorModificarCita.modificar();
    }//GEN-LAST:event_btn_regresarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:
        ControladorModificarCita.modificar();
    }//GEN-LAST:event_btn_modificarActionPerformed

    public JTextField getTxt_nomMascota() {
        return txt_nomMascota;
    }

    public void setTxt_nomMascota(JTextField txt_nomMascota) {
        this.txt_nomMascota = txt_nomMascota;
    }

    
    
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
            java.util.logging.Logger.getLogger(VistaModificarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaModificarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaModificarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaModificarCita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VistaModificarCita dialog = new VistaModificarCita(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public JLabel getLb_estetico() {
        return lb_estetico;
    }

    public void setLb_estetico(JLabel lb_estetico) {
        this.lb_estetico = lb_estetico;
    }

    public JButton getBtn_agendar() {
        return btn_modificar;
    }

    public void setBtn_agendar(JButton btn_agendar) {
        this.btn_modificar = btn_agendar;
    }

    public JButton getBtn_regresar() {
        return btn_regresar;
    }

    public void setBtn_regresar(JButton btn_regresar) {
        this.btn_regresar = btn_regresar;
    }

    public JComboBox<String> getComb_estetico() {
        return comb_estetico;
    }

    public void setComb_estetico(JComboBox<String> comb_estetico) {
        this.comb_estetico = comb_estetico;
    }

    public JComboBox<String> getComb_tipo() {
        return comb_tipo;
    }

    public void setComb_tipo(JComboBox<String> comb_tipo) {
        this.comb_tipo = comb_tipo;
    }

    public JComboBox<String> getCombo_fechas() {
        return combo_fechas;
    }

    public void setCombo_fechas(JComboBox<String> combo_fechas) {
        this.combo_fechas = combo_fechas;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> comb_estetico;
    private javax.swing.JComboBox<String> comb_tipo;
    private javax.swing.JComboBox<String> combo_fechas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lb_estetico;
    private javax.swing.JTextField txt_nomMascota;
    // End of variables declaration//GEN-END:variables
}

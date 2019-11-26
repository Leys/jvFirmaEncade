/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import jvfirmaencade.jfrmUsPrincipal;
import clases.clsDatos;
import clases.clsUsuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author diego
 */
public class jplAcceso extends javax.swing.JPanel {

    /**
     * Creates new form jpnAcceso
     */
    public jplAcceso() {
        initComponents();
        jlblError.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtbnAceptar = new javax.swing.JButton();
        jlblError = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtxtUsuario = new javax.swing.JTextField();
        jtxtContra = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(100, 200));

        jtbnAceptar.setText("Aceptar");
        jtbnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtbnAceptarActionPerformed(evt);
            }
        });

        jlblError.setText("jLabel2");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Acceso");

        jtxtUsuario.setText("dig");

        jtxtContra.setText("dig");
        jtxtContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtContraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblError)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jtxtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtbnAceptar)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jlblError)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtxtContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jtbnAceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtbnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtbnAceptarActionPerformed
        // TODO add your handling code here:

        String usuario = jtxtUsuario.getText();
        String pwd = jtxtContra.getText();
        if (!"".equals(usuario) && !"".equals(pwd)) {
            try {
                clsDatos usu = new clsDatos(0, usuario, pwd, "", 0, "");

                Connection cnn = usu.conexion();
                clsUsuario user = new clsUsuario();

                ResultSet rsFrm;
                rsFrm = usu.validarAcceso();
                while (rsFrm.next()) {
                    user.setId(Integer.parseInt(rsFrm.getString(1)));
                    usu.setCve(Integer.parseInt(rsFrm.getString(1)));
                    if (usu.getCve() != 0) {
                        user.setNombre(rsFrm.getString(2));
                        usu.setNombre(rsFrm.getString(2));

                        user.setEstatus(Integer.parseInt(rsFrm.getString(3)));
                        usu.setEstatus(Integer.parseInt(rsFrm.getString(3)));

                        user.setUsuario(rsFrm.getString(4));
                        usu.setUsu(rsFrm.getString(4));

                    }
                }

                //se cierra la conexin
                rsFrm.close();
                cnn.close();
                if (usu.getCve() != 0) {
                    //se genera una sesion con los datos del modelo
                    //acceso correcto
                    jlblError.setText("Acceso autorizado");
                    jfrmUsPrincipal frm = new jfrmUsPrincipal(user);
                    frm.setVisible(true);

                    JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
                    frame.dispose();

                } else {
                    //Acceso incorrecto
                    jlblError.setText("Datos incorrectos");
                }
            } catch (SQLException ex) {
                jlblError.setText(ex.getMessage());
            }

        } else {
            jlblError.setText("Llenar todos los campos");
        }
    }//GEN-LAST:event_jtbnAceptarActionPerformed

    private void jtxtContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtContraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtContraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jlblError;
    private javax.swing.JButton jtbnAceptar;
    private javax.swing.JTextField jtxtContra;
    private javax.swing.JTextField jtxtUsuario;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import clases.clsFirma;
import clases.clsUsuario;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author diego
 */
public class jplVerFirma extends javax.swing.JPanel {

    /**
     * Creates new form jplVerFirma
     */
    int v = 0;
    byte[] archivo;
    byte[][] firma;
    String faux;

    public jplVerFirma() {
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

        jbtnArchivo = new javax.swing.JButton();
        jlblArchivo = new javax.swing.JLabel();
        jbtnFirma = new javax.swing.JButton();
        jlblFirma = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbtnVerificar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblClose = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblMin = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(615, 315));

        jbtnArchivo.setBackground(new java.awt.Color(127, 140, 141));
        jbtnArchivo.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jbtnArchivo.setText("Subir");
        jbtnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnArchivoActionPerformed(evt);
            }
        });

        jlblArchivo.setText("Seleccione su archivo");

        jbtnFirma.setBackground(new java.awt.Color(127, 140, 141));
        jbtnFirma.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jbtnFirma.setText("Subir");
        jbtnFirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnFirmaActionPerformed(evt);
            }
        });

        jlblFirma.setText("Seleccione su archivo");

        jLabel2.setText("Archivo firmado");

        jLabel3.setText("Firma del archivo");

        jbtnVerificar.setBackground(new java.awt.Color(127, 140, 141));
        jbtnVerificar.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jbtnVerificar.setText("Verificar");
        jbtnVerificar.setEnabled(false);
        jbtnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVerificarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(20, 60, 80));

        lblClose.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        lblClose.setForeground(new java.awt.Color(255, 255, 255));
        lblClose.setText("X");
        lblClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCloseMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Verificar firma");

        lblMin.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        lblMin.setForeground(new java.awt.Color(255, 255, 255));
        lblMin.setText("-");
        lblMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMinMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblClose)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMin, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnVerificar)
                        .addGap(544, 544, 544))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlblArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnArchivo))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlblFirma, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtnFirma))
                            .addComponent(jLabel3))
                        .addContainerGap())))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnArchivo)
                    .addComponent(jlblArchivo)
                    .addComponent(jbtnFirma)
                    .addComponent(jlblFirma))
                .addGap(18, 18, 18)
                .addComponent(jbtnVerificar)
                .addContainerGap(127, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnArchivoActionPerformed

        try {
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(this);

            File sel = file.getSelectedFile();
            archivo = Files.readAllBytes(sel.toPath());

            jlblArchivo.setText(sel.getName());
            v++;
            if (v > 1) {
                jbtnVerificar.setEnabled(true);
            }

        } catch (HeadlessException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jbtnArchivoActionPerformed

    private void jbtnFirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnFirmaActionPerformed
        try {
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(this);

            File sel = file.getSelectedFile();

            FileReader fr = new FileReader(sel);
            BufferedReader bf = new BufferedReader(fr);

            faux = bf.readLine();
            bf.close();

            firma = clsFirma.getFirmaByte(faux.split(","));

            if (firma.length == 16) {
                jlblFirma.setText(sel.getName());
                v++;
                if (v > 1) {
                    jbtnVerificar.setEnabled(true);
                }
            } else {
                v--;
                jlblFirma.setText("Firma incorrecta");
                jbtnVerificar.setEnabled(false);
            }

        } catch (HeadlessException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jbtnFirmaActionPerformed

    private void jbtnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVerificarActionPerformed
        try {
            clsUsuario us = new clsUsuario();

            us.conexion();
            if (!us.buscarUsuario(faux).equals("0")) {

                String[] uhaux = us.getUh().split(",");
                int[] uh = new int[uhaux.length];//obtener h anterior, ultima h-1
                for (int i = 0; i < uh.length; i++) {
                    uh[i] = Integer.parseInt(uhaux[i]);
                }

                String[] f0aux = us.getLink().split(",");
                byte[][] f0 = new byte[16][16]; //obtner link de base de datos
                for (int i = 0; i < f0aux.length; i++) {
                    f0[i] = clsFirma.hextoByte(f0aux[i]);
                }

                String[] llaveaux = us.getLlave().split(",");
                byte[][] llave = new byte[16][16];     //obtener llave publica de base de datos
                for (int i = 0; i < llaveaux.length; i++) {
                    f0[i] = clsFirma.hextoByte(llaveaux[i]);
                }

                String[] ultFirmaaux = us.getUltFirma().split(",");
                byte[][] ultFirma = new byte[16][16];     //obtener ultFirma-1
                for (int i = 0; i < ultFirmaaux.length; i++) {
                    f0[i] = clsFirma.hextoByte(ultFirmaaux[i]);
                }

                clsFirma verif = new clsFirma();
                verif.verificarFirma(firma.clone(), f0.clone(), uh.clone(), archivo.clone());

                System.out.println(" \nPrimer verificacion: ");

                for (int i = 0; i < 16; i++) {
                    if (verif.toDouble(verif.getLlave()[i]) == verif.toDouble(llave[i])) {
                        System.out.println("Correcto");
                    } else {
                        System.out.println("ERROR");
                    }
                }

                System.out.println("\nSegunda verificacion: ");
                for (int i = 0; i < 16; i++) {
                    if (verif.toDouble(verif.getLink()[i]) == verif.toDouble(ultFirma[i])) {
                        System.out.println(i + "Correcto: " + verif.toDouble(verif.getLink()[i]));
                    } else {
                        System.out.print(i + " ERROR: ");
                        System.out.println(verif.toDouble(verif.getLink()[i]) + ":" + verif.toDouble(ultFirma[i]));
                    }
                }
            } else {
                System.out.println("La firma no pertenece a ningun usuario");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jbtnVerificarActionPerformed

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked

    private void lblMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMinMouseClicked
        //this.setState(jplAcceso.ICONIFIED);
    }//GEN-LAST:event_lblMinMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtnArchivo;
    private javax.swing.JButton jbtnFirma;
    private javax.swing.JButton jbtnVerificar;
    private javax.swing.JLabel jlblArchivo;
    private javax.swing.JLabel jlblFirma;
    private javax.swing.JLabel lblClose;
    private javax.swing.JLabel lblMin;
    // End of variables declaration//GEN-END:variables
}
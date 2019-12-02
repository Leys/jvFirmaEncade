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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author diego
 */
public class jpnlFirmar extends javax.swing.JPanel {

    /**
     * Creates new form jpnlFirmar
     */
    byte[] archivo;
    clsUsuario user;
    String fir;

    public jpnlFirmar() {
        initComponents();
        jlblEstado.setText("");
        jbtnDescargar.setVisible(false);
    }
    
    public jpnlFirmar(clsUsuario us) {
        initComponents();
        jlblEstado.setText("");
        jbtnDescargar.setVisible(false);
        user=us;
    }

    public void setUser(clsUsuario User) {
        this.user = User;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtnFirmar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jlblArchivo = new javax.swing.JLabel();
        jlblEstado = new javax.swing.JLabel();
        jbtnDescargar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblClose = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtAInformacion = new javax.swing.JTextArea();

        setPreferredSize(new java.awt.Dimension(450, 300));

        jbtnFirmar.setBackground(new java.awt.Color(204, 204, 204));
        jbtnFirmar.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jbtnFirmar.setText("Firmar");
        jbtnFirmar.setEnabled(false);
        jbtnFirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnFirmarActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jButton1.setText("Subir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jlblArchivo.setText("Seleccione su archivo");

        jlblEstado.setText("jLabel2");

        jbtnDescargar.setBackground(new java.awt.Color(204, 204, 204));
        jbtnDescargar.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jbtnDescargar.setText("Descargar Firma");
        jbtnDescargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDescargarActionPerformed(evt);
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
        jLabel4.setText("Firma de documentos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblClose)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblClose, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtxtAInformacion.setColumns(20);
        jtxtAInformacion.setRows(5);
        jScrollPane1.setViewportView(jtxtAInformacion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlblArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnFirmar))
                            .addComponent(jlblEstado)
                            .addComponent(jbtnDescargar))
                        .addGap(0, 85, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnFirmar)
                    .addComponent(jButton1)
                    .addComponent(jlblArchivo))
                .addGap(18, 18, 18)
                .addComponent(jlblEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnDescargar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnFirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnFirmarActionPerformed
        double inicio = System.currentTimeMillis();

        String token = "";
        File seed = new File("./"+user.getUsuario()+"/seed.key");
        if (seed.exists()) {
            try {
                FileReader archivos = new FileReader(seed);
                BufferedReader lee = new BufferedReader(archivos);
                String aux;
                while ((aux = lee.readLine()) != null) {
                    token += aux + "\n";
                }
                lee.close();

                if (token != null && archivo != null) {

                    clsFirma firmar = new clsFirma();

                    //asignar ultima semilla
                    firmar.setUltSeedHex(token.split("\n")[0], token.split("\n")[1]);

                    //Asignar H
//                    clsUsuario user = (clsUsuario) request.getSession().getAttribute("usuario");
                    user.conexion();
                    String[] ultHAux = user.getUltH().split(",");
                    int ultH[] = new int[ultHAux.length];
                    for (int i = 0; i < ultHAux.length; i++) {
                        ultH[i] = Integer.parseInt(ultHAux[i]);
                    }
                    firmar.setUltH(ultH);

                    //firmar
                    String inf = firmar.Firmar(archivo);

                    String firma = firmar.getFirmaHex();
                    String link = firmar.getLinkHex();
                    String llaveP = firmar.getLlaveHex();
                    String h = "";

                    for (int uh : firmar.getH()) {
                        h += String.valueOf(uh) + ",";
                    }
                    h = h.substring(0, h.length() - 1);

                    if (user.firmar(link, firma, llaveP, h).equals("0")) {
                        jtxtAInformacion.setText("Error");
                    } else {
                        //Mostrar información en pantalla
                        jtxtAInformacion.setText(inf);

                        //Actualizar semilla
                        String[] aux1 = firmar.getSeedHex();
                        String semilla = aux1[0] + "\n" + aux1[1];

                        BufferedWriter bw;
                        bw = new BufferedWriter(new FileWriter(seed));
                        bw.write(semilla);
                        bw.close();

                        //Descargar firma
                        fir = firma;

                        jlblEstado.setText("Firma relizada");
                        jbtnFirmar.setEnabled(false);
                        jButton1.setEnabled(false);
                        jbtnDescargar.setVisible(true);
                    }
                    System.out.println("DoneF");
                } else {
                    jtxtAInformacion.setText("Error con los archivos");
                }

                System.out.println("Tiempo firma: " + (System.currentTimeMillis() - inicio));
            } catch (IOException | NumberFormatException | SQLException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            jtxtAInformacion.setText("No se encontro semilla");
        }

    }//GEN-LAST:event_jbtnFirmarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(this);

            File sel = file.getSelectedFile();
            archivo = Files.readAllBytes(sel.toPath());

            jlblArchivo.setText(sel.getName());
            jbtnFirmar.setEnabled(true);

        } catch (HeadlessException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(jpnlFirmar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbtnDescargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDescargarActionPerformed
        JFileChooser s = new JFileChooser();
        int returnVal = s.showSaveDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File ruta_destino;
            ruta_destino = s.getSelectedFile().getAbsoluteFile();

            try {

                BufferedWriter out;

                if (ruta_destino.getName().endsWith(".key")) {
                    out = new BufferedWriter(new FileWriter(ruta_destino));
                } else {
                    out = new BufferedWriter(new FileWriter(ruta_destino + ".key"));
                }
                out.write(fir);
                out.close();

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    }//GEN-LAST:event_jbtnDescargarActionPerformed

    private void lblCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCloseMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lblCloseMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnDescargar;
    private javax.swing.JButton jbtnFirmar;
    private javax.swing.JLabel jlblArchivo;
    private javax.swing.JLabel jlblEstado;
    private javax.swing.JTextArea jtxtAInformacion;
    private javax.swing.JLabel lblClose;
    // End of variables declaration//GEN-END:variables
}

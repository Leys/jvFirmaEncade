/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import clases.clsUsuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author diego
 */
public class jpnlVerUsuarios extends javax.swing.JPanel {

    /**
     * Creates new form jpnlVerUsuarios
     */
    List<String> users;

    public jpnlVerUsuarios() {
        initComponents();
        jlblError.setText("");
        clsUsuario obj = new clsUsuario();
        try {
            obj.conexion();
            ResultSet rs = obj.listarUsuarios("");
            users = new ArrayList<String>();
            while (rs.next()) {
                users.add(rs.getString(1));
            }
            rs.close();
            jListUsuario.removeAll();
            jListUsuario.setListData(users.toArray(new String[0]));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jtxtBuqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListUsuario = new javax.swing.JList<>();
        jbtnBuscar = new javax.swing.JButton();
        jbtnVerificar = new javax.swing.JButton();
        jlblError = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxaResultado = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        lblClose1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel2.setText("Buscar");

        jListUsuario.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListUsuario.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jListUsuario);

        jbtnBuscar.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jbtnBuscar.setText("Buscar");
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });

        jbtnVerificar.setFont(new java.awt.Font("Comic Sans MS", 0, 12)); // NOI18N
        jbtnVerificar.setText("Veririfcar");
        jbtnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVerificarActionPerformed(evt);
            }
        });

        jlblError.setText("jLabel3");

        jtxaResultado.setColumns(20);
        jtxaResultado.setRows(5);
        jScrollPane2.setViewportView(jtxaResultado);

        jPanel2.setBackground(new java.awt.Color(20, 60, 80));

        lblClose1.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        lblClose1.setForeground(new java.awt.Color(255, 255, 255));
        lblClose1.setText("X");
        lblClose1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblClose1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblClose1MouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Demi", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Usuarios");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblClose1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblClose1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jlblError))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtxtBuqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 178, Short.MAX_VALUE)))
                        .addGap(176, 176, 176))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbtnBuscar)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnVerificar))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblError)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtBuqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jbtnVerificar)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVerificarActionPerformed
        // TODO add your handling code here:
        int sel = jListUsuario.getSelectedIndex();
        if (sel != -1) {
            try {
                //llenar campos, recibe el usuario
                clsUsuario usu = new clsUsuario(users.get(sel));

                if (usu.verificar()) {
                    //Cadena correcta
                } else {
                    //Cadena incorrexta
                }
                jtxaResultado.setText(usu.getResultado());

            } catch (SQLException ex) {
                Logger.getLogger(jpnlVerUsuarios.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            jlblError.setText("Seleccionar un usuario");
        }
        //-1: ninguno seleccionado

    }//GEN-LAST:event_jbtnVerificarActionPerformed

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        // TODO add your handling code here:
        clsUsuario obj = new clsUsuario();
        try {
            obj.conexion();
            ResultSet rs = obj.listarUsuarios(jtxtBuqueda.getText());
            users = new ArrayList<String>();
            while (rs.next()) {
                users.add(rs.getString(1));
            }
            rs.close();
            jListUsuario.removeAll();
            jListUsuario.setListData(users.toArray(new String[0]));
            if(users.get(0).equals("0")){
                jlblError.setText("No se encontró ningún usuario");
                            jListUsuario.removeAll();

            }
            else{
                jlblError.setText("");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }//GEN-LAST:event_jbtnBuscarActionPerformed

    private void lblClose1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClose1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lblClose1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jListUsuario;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JButton jbtnVerificar;
    private javax.swing.JLabel jlblError;
    private javax.swing.JTextArea jtxaResultado;
    private javax.swing.JTextField jtxtBuqueda;
    private javax.swing.JLabel lblClose1;
    // End of variables declaration//GEN-END:variables
}

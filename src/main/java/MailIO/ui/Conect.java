/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MailIO.ui;

import MailIO.util.Conf;
import java.sql.SQLException;
import javax.xml.bind.JAXBException;

/**
 *
 * @author ai
 */
public class Conect extends javax.swing.JFrame {

    /**
     * Creates new form Conect
     */
    public Conect() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        host = new javax.swing.JTextField();
        dbname = new javax.swing.JTextField();
        port = new javax.swing.JSpinner();
        user = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        s = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Configurasi Basis Data");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Host");

        jLabel2.setText("Database Name");

        jLabel3.setText("Port");

        jLabel4.setText("User");

        jLabel5.setText("Password");

        host.setText("localhost");
        host.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                hostKeyReleased(evt);
            }
        });

        dbname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dbnameKeyReleased(evt);
            }
        });

        port.setModel(new javax.swing.SpinnerNumberModel(3306, 1000, 90000, 1));
        port.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                portStateChanged(evt);
            }
        });

        user.setText("root");
        user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                userKeyReleased(evt);
            }
        });

        s.setText("SAVE");
        s.setEnabled(false);
        s.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(s, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(host, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(dbname)
                            .addComponent(user)
                            .addComponent(pass))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(host, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dbname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(s)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.out.println("System berhenti berjalan");
    }//GEN-LAST:event_formWindowClosing

    private void hostKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hostKeyReleased
        s.setEnabled(!host.getText().isEmpty()&&!dbname.getText().isEmpty()&&!user.getText().isEmpty());
    }//GEN-LAST:event_hostKeyReleased

    private void dbnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dbnameKeyReleased
        this.hostKeyReleased(evt);
    }//GEN-LAST:event_dbnameKeyReleased

    private void portStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_portStateChanged
        this.hostKeyReleased(null);
    }//GEN-LAST:event_portStateChanged

    private void userKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userKeyReleased
        this.hostKeyReleased(evt);
    }//GEN-LAST:event_userKeyReleased

    private void sActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sActionPerformed
        new Thread(()->{
            try {
                Conf c=new Conf(host.getText(), Integer.parseInt(""+port.getValue()), dbname.getText(), user.getText(), pass.getText());
                MailIO.util.Work.save(c);
                dbCreate(c);
                toDashBoard();
            } catch (JAXBException ex) {
                enableAll();
                MailIO.util.Db.hindar(ex);
            } catch (SQLException ex) {
                MailIO.util.Work.f.delete();
                enableAll();
                MailIO.util.Db.hindar(ex);
            }
        }).start();
        disableAll();
    }//GEN-LAST:event_sActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dbname;
    private javax.swing.JTextField host;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField pass;
    private javax.swing.JSpinner port;
    private javax.swing.JButton s;
    private javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables

    private void disableAll() {
        s.setEnabled(false);
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        host.setEnabled(false);
        dbname.setEnabled(false);
        pass.setEnabled(false);
        port.setEnabled(false);
        user.setEnabled(false);
    }

    private void enableAll() {
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        host.setEnabled(true);
        dbname.setEnabled(true);
        pass.setEnabled(true);
        port.setEnabled(true);
        user.setEnabled(true);
    }

    private void dbCreate(Conf c) throws SQLException {
        c.setName("mysql");
        MailIO.util.Db d=new MailIO.util.Db(c);
        d.exec("create database "+dbname.getText());
        d.close();
        c.setName(dbname.getText());
        d=new MailIO.util.Db(c);
        new MailIO.entity.dao.DAOMasuk(d).createTable();
        new MailIO.entity.dao.DAOKeluar(d).createTable();
        d.close();
    }

    private void toDashBoard() throws JAXBException {
        Conf c=MailIO.util.Work.loadConf();
        new Dash(c).setVisible(true);
        this.setVisible(false);
        this.dispose();
    }
}

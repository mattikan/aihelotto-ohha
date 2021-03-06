/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.nakki.aihelotto.gui;

import fi.nakki.aihelotto.io.SubjectIO;
import fi.nakki.aihelotto.logic.SubjectLogic;
import fi.nakki.aihelotto.subject.Subject;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.DefaultListModel;

/**
 * This class handles all the GUI stuff. The user can grab a random subject or
 * write new subjects to the file through the GUI.
 *
 * @author nakki
 */
public class MainGUI extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainGUI() {
        initComponents();
        this.readGroupsForList();
    }

    /**
     * This method reads groups for the group selection list in the GUI.
     */
    public void readGroupsForList() {
        jList1.setListData(MainGUI.sl.getGroups().toArray(new String[0]));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        randomSubjectButton = new javax.swing.JButton();
        description = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        group = new javax.swing.JLabel();
        clearGroups = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setText("Paina Arvo aihe -nappia arpoaksesi aiheen!");

        randomSubjectButton.setText("Arvo aihe");
        randomSubjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomSubjectButtonActionPerformed(evt);
            }
        });

        description.setText(" ");

        jList1.setModel(new DefaultListModel());
        jScrollPane2.setViewportView(jList1);

        jTextField1.setText("Uusi aihe");

        jTextField2.setText("Uusi kuvaus");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setText("Uusi ryhmä");

        jButton1.setText("Lisää aihe");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        group.setText(" ");

        clearGroups.setText("Putsaa valitut ryhmät");
        clearGroups.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearGroupsActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(title)
                            .addComponent(randomSubjectButton)
                            .addComponent(description)
                            .addComponent(group)
                            .addComponent(clearGroups)))
                    .addComponent(jButton1))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(title)
                        .addGap(18, 18, 18)
                        .addComponent(description)
                        .addGap(18, 18, 18)
                        .addComponent(group)
                        .addGap(52, 52, 52)
                        .addComponent(randomSubjectButton)
                        .addGap(18, 18, 18)
                        .addComponent(clearGroups)))
                .addGap(53, 53, 53)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * This method handles updating the GUI when the button for a random subject
     * is pressed.
     *
     * @param evt
     */
    private void randomSubjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomSubjectButtonActionPerformed
        List<String> groups = new ArrayList<>();
        for (String s : jList1.getSelectedValuesList()) {
            groups.add(s);
        }
        Subject subject = this.sl.getRandomSubject(groups);
        title.setText(subject.getName());
        description.setText(subject.getDescription());
        group.setText(subject.getGroup());

    }//GEN-LAST:event_randomSubjectButtonActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    /**
     * This method creates a new subject and tells SubjectLogic to write it to
     * the file. It grabs the subject's information from the text boxes in the
     * GUI.
     *
     * @param evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!jTextField1.equals("")
                && !jTextField2.equals("")) {
            ArrayList<Subject> subjects = new ArrayList<>();
            Subject subject = new Subject(jTextField1.getText(), jTextField3.getText(), jTextField2.getText());
            subjects.add(subject);
            MainGUI.sl.writeSubjects(subjects);
            this.readGroupsForList();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * This method clears the groups list selection.
     *
     * @param evt
     */
    private void clearGroupsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearGroupsActionPerformed
        this.jList1.clearSelection();
    }//GEN-LAST:event_clearGroupsActionPerformed

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
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        MainGUI.sl = new SubjectLogic(new SubjectIO("aiheet.txt"));

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGUI().setVisible(true);
            }
        });
    }

    private static SubjectLogic sl;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearGroups;
    private javax.swing.JLabel description;
    private javax.swing.JLabel group;
    private javax.swing.JButton jButton1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton randomSubjectButton;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}

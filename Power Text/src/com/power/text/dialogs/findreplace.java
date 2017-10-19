/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.dialogs;

import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JDesktopPane;
import static com.power.text.Main.jTabbedPane1;
import com.power.text.PTextEditor;
//import power.text.Main.Editor;

/**
 *
 * @author thecarisma
 */
public class findreplace extends javax.swing.JDialog {
    
    public static ArrayList<PTextEditor> Editor = com.power.text.Main.Editor;
    public static int currentPos = 0;
    private static int pos = -1;

    /**
     * Creates new form findreplace
     */
    public findreplace(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        findword = new javax.swing.JTextField();
        replaceword = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        notfound = new javax.swing.JLabel();
        notfound.setVisible(false)
        ;

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        findword.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                findwordCaretUpdate(evt);
            }
        });
        findword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                findwordMouseClicked(evt);
            }
        });
        findword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                findwordKeyTyped(evt);
            }
        });

        replaceword.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                replacewordCaretUpdate(evt);
            }
        });
        replaceword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                replacewordActionPerformed(evt);
            }
        });
        replaceword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                replacewordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                replacewordKeyTyped(evt);
            }
        });

        jLabel1.setText("Find text :");

        jLabel2.setText("Replace with :");

        jButton1.setText("Find Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Find Previous");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Replace");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Replace All");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        notfound.setFont(new java.awt.Font("Sitka Subheading", 3, 12)); // NOI18N
        notfound.setForeground(java.awt.Color.red);
        notfound.setText("Text Not Found !!!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(findword, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                        .addComponent(replaceword))
                    .addComponent(notfound, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(findword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(replaceword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addComponent(notfound))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Find and Replace", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void replacewordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_replacewordKeyReleased
        notfound.setVisible(false);
    }//GEN-LAST:event_replacewordKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //jTabbedPane1.setSelectedIndex(selectedIndex);
        findNext();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //jTabbedPane1.setSelectedIndex(selectedIndex);
        findPrevious();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //jTabbedPane1.setSelectedIndex(selectedIndex);
        replace();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //jTabbedPane1.setSelectedIndex(selectedIndex);
        replaceAll();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void replacewordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_replacewordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_replacewordActionPerformed

    private void findwordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_findwordMouseClicked
        notfound.setVisible(false);
    }//GEN-LAST:event_findwordMouseClicked

    private void replacewordCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_replacewordCaretUpdate
        notfound.setVisible(false);
    }//GEN-LAST:event_replacewordCaretUpdate

    private void findwordCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_findwordCaretUpdate
        notfound.setVisible(false);
    }//GEN-LAST:event_findwordCaretUpdate

    private void findwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_findwordKeyTyped
        notfound.setVisible(false);
    }//GEN-LAST:event_findwordKeyTyped

    private void replacewordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_replacewordKeyTyped
        notfound.setVisible(false);
    }//GEN-LAST:event_replacewordKeyTyped

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
            java.util.logging.Logger.getLogger(findreplace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(findreplace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(findreplace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(findreplace.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and Editor the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                findreplace dialog = new findreplace(new javax.swing.JFrame(), true);
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

    private static void replaceAll() {
        int sel = jTabbedPane1.getSelectedIndex();
            JTextPane textPane = (JTextPane) ((JScrollPane) ((JDesktopPane)jTabbedPane1.getComponentAt(sel)).getComponent(0)).getViewport().getComponent(0);
        if (!findword.getText().isEmpty()) {
            String oldContent = textPane.getText();
            String newContent = oldContent.replaceAll(findword.getText(),
                    replaceword.getText());
            textPane.setText(newContent);
        }
    }

    private static void replace() {
        int sel = jTabbedPane1.getSelectedIndex();
        JTextPane textPane = (JTextPane) ((JScrollPane) ((JDesktopPane)jTabbedPane1.getComponentAt(sel)).getComponent(0)).getViewport().getComponent(0);
        String replaceWord = replaceword.getText();
        if (textPane.getSelectedText() != null)
            textPane.replaceSelection(replaceWord);
    }

    public static void findNext() {
        int sel = jTabbedPane1.getSelectedIndex();
        JTextPane textPane = (JTextPane) ((JScrollPane) ((JDesktopPane)jTabbedPane1.getComponentAt(sel)).getComponent(0)).getViewport().getComponent(0);
        if (findword.getText().isEmpty())
            return;
        String context = textPane.getText();
        String wordToFind = findword.getText();
        pos = context.indexOf(wordToFind, currentPos);
        if (pos == -1)
            currentPos = 0;
        pos = context.indexOf(wordToFind, currentPos);
        currentPos = pos;
        if (pos != -1) {
            textPane.setSelectionStart(pos);
            textPane.setSelectionEnd(pos + wordToFind.length());
            textPane.requestFocusInWindow();
            currentPos = (currentPos + 1);
        } else {
            currentPos = 0;
            notfound.setVisible(true);
        }
    }

    public static void findPrevious() {
        int sel = jTabbedPane1.getSelectedIndex();
        JTextPane textPane = (JTextPane) ((JScrollPane) ((JDesktopPane)jTabbedPane1.getComponentAt(sel)).getComponent(0)).getViewport().getComponent(0);
        boolean found = false;
        if (findword.getText().isEmpty())
            return;
        String context = textPane.getText();
        String wordToFind = findword.getText();
        if (wordToFind.length() > context.length())
            return;
        pos = currentPos - wordToFind.length();
        while (pos != currentPos) {
            if (pos < 0) {
                pos = context.length() - wordToFind.length();
            }
            if (context.subSequence(pos, pos + wordToFind.length()).equals(
                    wordToFind)) {
                found = true;
                currentPos = pos + 1;
                textPane.setSelectionStart(pos);
                textPane.setSelectionEnd(pos + wordToFind.length());
                textPane.requestFocusInWindow();
                break;
            }
            pos--;
        }
        if (found == false)
            notfound.setVisible(true);
    }    

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField findword;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane;
    private static javax.swing.JLabel notfound;
    public static javax.swing.JTextField replaceword;
    // End of variables declaration//GEN-END:variables
}
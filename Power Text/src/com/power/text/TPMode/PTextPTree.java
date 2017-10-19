/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.TPMode;

import static com.power.text.dialogs.NewProject.main;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import static com.power.text.Main.jTabbedPane1;

/**
 *
 * @author thecarisma
 */
public class PTextPTree extends JScrollPane{
    
        public JTree  jTree = new JTree(); 
        public String fileDir = "" ;  
        
        
    public PTextPTree(){
        jTree.setShowsRootHandles(true);
        jTree.setVisibleRowCount(1000);
        setViewportView(jTree);
        //jTree.addTreeSelectionListener(new TreeSelect());
        jTree.addMouseListener(new TreeMouse());
    }
    
    public String getTreeDir(){
        return this.fileDir ;
    }
    
    public void setTreeDir(String fD){
        fileDir = fD ;
    }

        
    public JTree getJTree(){
        return this.jTree ;
    }
    
    
    public class TreeMouse implements MouseListener {
                
        @Override
        public void mouseClicked(MouseEvent me) {
            
        }

        @Override
        public void mousePressed(MouseEvent me) {
            if (me.getClickCount()==2) { 
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();
            Object nodeInfo = node.getUserObject(); String ptt = Arrays.toString(node.getPath()) ; String fileD1 = ptt.replace("[", "");
            String fileD2 = fileD1.replace("]", "");  String fileD = fileD2.replace(", ", "\\");            
            if (fileD.contains(".")) {
                    try {
                        int selectedIndex = jTabbedPane1.getSelectedIndex() ; String filep =fileDir.substring(fileDir.lastIndexOf("\\"));
                        //JOptionPane.showMessageDialog(null, "the path is >>   " + fileDir + fileD );
                        String fileP = fileDir.replace(filep, "\\") ; //String finalP = fileD.replace(node.getParent().toString(), "");
                        File file = new File(fileP+fileD);  System.out.println(fileP+""+fileD+"\n");
                        Scanner scn = new Scanner(new FileInputStream(file));
                        main.openFile(file, scn);
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                        //Logger.getLogger(PTextPTree.class.getName()).log(Level.SEVERE, null, ex);
                    }
            } else {
                
            }
                    
            }
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            
        }

        @Override
        public void mouseExited(MouseEvent me) {
            
        }

        
        
    }
    
    public class TreeSelect implements TreeSelectionListener  {

        @Override
        public void valueChanged(TreeSelectionEvent tse) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) jTree.getLastSelectedPathComponent();
            Object nodeInfo = node.getUserObject(); String ptt = Arrays.toString(node.getPath()) ; String fileD1 = ptt.replace("[", "");
            String fileD2 = fileD1.replace("]", "");  String fileD = fileD2.replace(", ", "\\"); 
            
            if (fileD.contains(".")) {
                JOptionPane.showMessageDialog(null, "the path is >>   " + fileDir + fileD );
            } else {
                
            }
        }
        
    }
    
}

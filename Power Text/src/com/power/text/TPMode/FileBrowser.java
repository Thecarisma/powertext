/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.TPMode;

/**
 *
 * @author thecarisma
 */
import java.io.File;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class FileBrowser {
    
    private DefaultMutableTreeNode root;
    public static DefaultTreeModel treeModel;
    
    public void run(File fileRoot) {
        root = new DefaultMutableTreeNode(new FileNode(fileRoot));
        treeModel = new DefaultTreeModel(root);
        
        CreateChildNodes ccn = new CreateChildNodes(fileRoot, root);
        new Thread(ccn).start();
        }
    
    public class CreateChildNodes implements Runnable{

            private DefaultMutableTreeNode root;
            private File fileroot;
            
            public CreateChildNodes(File fileRoot, DefaultMutableTreeNode root){
                this.fileroot = fileRoot;
                this.root = root;
            }
            
        @Override
        public void run() {
            createChildren(fileroot, root);
        }
        
        private void createChildren(File fileRoot, DefaultMutableTreeNode node){
            File[] files = fileRoot.listFiles();
            if (files == null) return ;
            
            for (File file : files) {
                DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(new FileNode(file));
                node.add(childNode);
                if (file.isDirectory()){
                    createChildren(file, childNode);
                }
            }
        }
            
        }
       
    public class FileNode {
            private File file ;
            public FileNode(File file){
                this.file = file ;
            }
            
            public String toString(){
                String name = file.getName();
                if (name.equals("")){
                    return file.getAbsolutePath();
                } else {
                    return name ; 
                }
            }
        }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.MenuFunctions;

import com.power.text.Main;
import com.power.text.PTextEditor;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Thecarisma
 */
public class MenuFunctions {
    
    static Main main = null ;
    
    public void setMain(Main maini) {
        main = maini ;
    }
    
    public static void loadFile(File file) {

        try {
            System.out.println("DEBUG: " + file.getAbsolutePath());
            if (file.isDirectory()) { // Clicking on a space character
                JOptionPane.showMessageDialog(null, file.getAbsolutePath()
                        + " is a directory", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else if (!file.isFile()) {
                JOptionPane.showMessageDialog(null, "No such file: "
                        + file.getAbsolutePath(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            Scanner scn = new Scanner(new FileInputStream(file));
            main.openFile(file, scn); main.addRecent(file.getAbsolutePath());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PTextEditor.class.getName()).log(Level.SEVERE, null, ex);
        }

   }
    
}

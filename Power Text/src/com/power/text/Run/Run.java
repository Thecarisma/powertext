/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.Run;

import java.awt.Desktop;
import java.io.File;
import static com.power.text.dialogs.RunDialog.select;

/**
 *
 * @author thecarisma
 */
public class Run {
    
    public static void run(){
        try {
                        File f = select.getSelectedFile();
                        if (f.exists()) 
                        {
                            if (Desktop.isDesktopSupported()) 
                            {
                            Desktop.getDesktop().open(f);
                            } 
                 
                            else
                            {
                            System.out.println("File does not exists!");
                            }
             
                        } else {
                            System.out.println("File does not exists!");
                        }
                    }
                    catch(Exception ert)
                    {}
    }
	
}

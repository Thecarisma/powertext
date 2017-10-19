/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.Run;

import java.awt.Desktop;
import java.io.File;

/**
 *
 * @author thecarisma
 */
public class RunDBrowser {
    
        public static void run(String file){
        try {
                        File f = new File(file);
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

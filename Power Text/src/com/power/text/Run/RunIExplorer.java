/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.Run;

import java.io.IOException;
import javax.swing.JOptionPane;
import static com.power.text.Main.titleText;

/**
 *
 * @author thecarisma
 */
public class RunIExplorer {
   public static void ie(){
    String url = "file:///" + titleText.getText() ;
    Runtime rt = Runtime.getRuntime();
    int bit64 = 0 ;
    try{
    Process clientProcess = rt.exec(new String[] {"C:\\Program Files\\Internet Explorer\\iexplore.exe", url});
    clientProcess.waitFor();
    } catch (IOException | InterruptedException e){
        
        bit64 = 2 ;
    } if (bit64 == 2){
        try{
    Process clientProcess = rt.exec(new String[] {"C:\\Program Files (x86)\\Internet Explorer\\iexplore.exe", url});
    clientProcess.waitFor();
    } catch (IOException | InterruptedException e){
        JOptionPane.showMessageDialog(null, "Internet Explorer cant't be found on your computer");
    }
    }
  }
}
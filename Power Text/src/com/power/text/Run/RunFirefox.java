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
public class RunFirefox{
 
public static void firefox(){
    String url = "file:///" + titleText.getText() ;
    Runtime rt = Runtime.getRuntime();
    int bit64f = 0 ;
    try{
        rt.exec(new String[] {"C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe", url});
    } catch (IOException e){
        //JOptionPane.showMessageDialog(null, e.getMessage());
        bit64f = 2 ;
    }  if (bit64f == 2){
        try{
    Process clientProcess = rt.exec(new String[] {"C:\\Program Files\\Mozilla Firefox\\firefox.exe", url});
    clientProcess.waitFor();
    } catch (IOException | InterruptedException e){
        JOptionPane.showMessageDialog(null, "Mozilla Firefox cant't be found on your computer");
    }
    }
}
 
}

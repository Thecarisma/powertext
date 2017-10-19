/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.internallibrary;

import static com.power.text.dialogs.Summary.jLabel16;
import static com.power.text.dialogs.Summary.jLabel21;
import static com.power.text.dialogs.Summary.jLabel22;
import static com.power.text.dialogs.Summary.jLabel23;
import static com.power.text.dialogs.Summary.jLabel24;
import static com.power.text.dialogs.Summary.jLabel25;
import static com.power.text.dialogs.Summary.jLabel27;
import static com.power.text.dialogs.Summary.jLabel5;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import static com.power.text.Main.jTabbedPane1;
import static com.power.text.Main.titleText;
import static com.power.text.Main.titleExtLa;

/**
 *
 * @author thecarisma
 */
public class summary {
    static int dat = 0 ; //Summary sum ;
    
    public static void summaryAll() throws IOException{
        int sel = jTabbedPane1.getSelectedIndex();
        jLabel23.setText(jTabbedPane1.getTitleAt(sel));
        jLabel24.setText("File Location : " + titleText.getText());
        /**String[] {splitStrings = filesave.getSelectedFile().getName().split("\\.") ;
            String extension = splitStrings[splitStrings.length-1] ;
            fileext.setText(extension);}**/
        jLabel16.setText("File Extention : " + titleExtLa.getText());
        JTextArea textPane = (JTextArea) ((JScrollPane) ((JDesktopPane)jTabbedPane1.getComponentAt(sel)).getComponent(0)).getViewport().getComponent(0);
        String totaltext=  textPane.getText();
        String totalwords[]=totaltext.split("\\s");  
        jLabel21.setText("Total Word Typed : " + totalwords.length);
        jLabel5.setText("Total Characters With Spaces : " + totaltext.length());
        jLabel22.setText("Total Line : " + BasicEvents.getLineCount(textPane));
    	if (titleText.getText().contains("Untitled")) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                Calendar cal = Calendar.getInstance();
            jLabel27.setText(dateFormat.format(cal.getTime())); 
            jLabel25.setText(dateFormat.format(cal.getTime()));
        } else {
            Path filepath = Paths.get(titleText.getText()) ;
            BasicFileAttributes attr = Files.readAttributes(filepath, BasicFileAttributes.class);
                String dateCreate = ""+attr.creationTime() ; String dateCreat = dateCreate.replace("T", "  Time Created : ");
                String lastModi = ""+attr.lastModifiedTime() ; String lastMod = lastModi.replace("T", "  Last Time Modified : ");
                 jLabel25.setText("Date Created : " + dateCreat );
                jLabel27.setText("Last Date Modified : " + lastMod );
        }
    }
    
}

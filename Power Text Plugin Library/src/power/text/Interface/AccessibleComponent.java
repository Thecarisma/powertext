/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package power.text.Interface;

import javax.swing.*;
import static com.power.text.Main.*;
import com.power.text.PTextEditor;
import java.util.*;

/**
 *
 * @author Thecarisma
 */
public interface AccessibleComponent {
    
    /**
     * 
     * @return 
     * this method getCurrentPTextArea() returns the currently 
     * focused PTextArea for manipulation and adding functions
     * or to get the content or the context of the Component
     */
    public static JTextArea getCurrentPTextArea() {
        return Editor.get(jTabbedPane1.getSelectedIndex()).adddisplay;
    }
    
    /**
     * 
     * @return the method getTabbedParent() returns the main tabbed pane 
     * (parent) that house all the PTextArea in the application
     */
    public static JTabbedPane getTabbedParent() {
        return jTabbedPane1 ;
    }
    
    /**
     * 
     * @return getPluginMenu() is the Primary menu where you add your newly 
     * added plugin and consequent menuitem are place as a child to the
     * main menu you add to the pluginMenu
     */
    public static JMenu getPluginMenu() {
        return pluginMenu ;
    }
    
    /**
     * 
     * @return getCodeMenu() is the primary menu that you add your new code 
     * completion definations, code snippet , code examples and anything code 
     */
    public static JMenu getCodeMenu() {
        return codeMenu ;
    }
    
    /**
     * 
     * @return getComponent() returns a component that you can reference in place of 
     * null eg. in a JOptionPane, DialogBox, Open/Save Dialog, About Dialog Screen
     */
    public static JFrame getComponent() {
        return main ;
    }
    
    /**
     * 
     * @return getCurrentFileName() shows the currently edited document file name 
     * @see getCurrentFilePath() 
     * @see getCurrentFileExtension()
     */
    public static String getCurrentFileName() {
        return Editor.get(jTabbedPane1.getSelectedIndex()).getFileName() ;
    }
    
    /**
     * 
     * @return getCurrentFileName() shows the currently edited document full file Path
     * @see getCurrentFileName() 
     * @see getCurrentFileExtension()
     */
    public static String getCurrentFilePath() {
        return Editor.get(jTabbedPane1.getSelectedIndex()).getFileDir() ;
    }
    
    /**
     * 
     * @return getCurrentFileName() shows the currently edited document file extension
     * @see getCurrentFilePath()
     * @see getCurrentFileName()
     */
    public static String getCurrentFileExtension() {
        return Editor.get(jTabbedPane1.getSelectedIndex()).getExt() ;
    }
    
    /**
     * 
     * @return getCurrentFileName() shows the currently edited document extension type
     * in string e.g a java document type returns ~java~ in String 
     * @see getCurrentFileName() 
     * @see getCurrentFileExtension()
     */
    public static String getDocumentType() {
        return Editor.get(jTabbedPane1.getSelectedIndex()).getExt() ;
    }
    
    /**
     * 
     * @return getCurrentFileName() shows the currently edited document extension type
     * in string e.g a java document type returns ~java~ in String 
     * @see getCurrentFileName() 
     * @see getCurrentFileExtension()
     */
    public static ArrayList<PTextEditor> getEditor() {
        return Editor ;
    }
    
}

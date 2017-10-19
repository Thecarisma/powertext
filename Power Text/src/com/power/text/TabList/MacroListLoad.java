/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.TabList;

import com.power.text.Main;
import static com.power.text.Main.*;
import static com.power.text.internallibrary.PTPaths.*;
import com.power.text.rtextarea.*;
import java.io.*;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author Thecarisma
 */
public class MacroListLoad  implements ListSelectionListener {

    @Override
    public void valueChanged(ListSelectionEvent lse) {
        try { if (jList2.getSelectedValue()!=null) {
                File file = new File(getMyMacroFolder()+""+jList2.getSelectedValue()+".xml");
                if (file.exists()) { 
                    int selectedIndex = jTabbedPane1.getSelectedIndex();
                    RTextScrollPane scrollPane = (RTextScrollPane) ((JDesktopPane)jTabbedPane1.getComponentAt(selectedIndex)).getComponent(0);
                    RTextArea textPane = scrollPane.getTextArea(); 
                    textPane.loadMacro(new Macro(file)); jMenuItem152.setEnabled(true);
                } }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

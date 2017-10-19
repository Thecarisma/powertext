/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.internallibrary;

import static com.power.text.Main.jTabbedPane1;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import com.power.text.fontSelector;
import com.power.text.rtextarea.RTextArea;
import com.power.text.rtextarea.RTextScrollPane;

/**
 *
 * @author thecarisma
 */
public class FontS {    
    public static fontSelector fontS = new fontSelector();
    
    
    public static void font() {
        int selectedIndex = jTabbedPane1.getSelectedIndex() ;
				fontS.setVisible(true);
				fontS.okButton.addActionListener((ActionEvent ae) -> {
                                    RTextScrollPane scrollPane = (RTextScrollPane) ((JDesktopPane)jTabbedPane1.getComponentAt(selectedIndex)).getComponent(0);
                                    RTextArea textPane = scrollPane.getTextArea();
                                    java.awt.Font selectedFont = fontS.returnFont();
                                    scrollPane.getGutter().setLineNumberFont(selectedFont);
                                    textPane.setFont(selectedFont);
                                    fontS.setVisible(false);
        });
					
				fontS.cancelButton.addActionListener((ActionEvent ae) -> {
                                    fontS.setVisible(false);
        });
		}
    
    
}

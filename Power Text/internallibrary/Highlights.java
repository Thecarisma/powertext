/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.internallibrary;

//import static dialogs.findreplace.Editor;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import static com.power.text.Main.jTabbedPane1;
import com.power.text.PTextEditor;

/**
 *
 * @author thecarisma
 */
public class Highlights {
    public static int currentPos = 0;
    private static int pos = -1;
    public static ArrayList<PTextEditor> Editor = com.power.text.Main.Editor;
    //private static JTabbedPane jTabbedPane1;
    
    public static void highlightNext(String findText) {
    int sel = jTabbedPane1.getSelectedIndex();
            JTextPane textPane = (JTextPane) ((JScrollPane) ((JDesktopPane)jTabbedPane1.getComponentAt(sel)).getComponent(0)).getViewport().getComponent(0);
    if (findText.isEmpty())
            return;
        String context = textPane.getText();
        String wordToFind = findText;
        pos = context.indexOf(wordToFind, currentPos);
        if (pos == -1)
            currentPos = 0;
        pos = context.indexOf(wordToFind, currentPos);
        currentPos = pos;
        if (pos != -1) {
            textPane.setSelectionStart(pos);
            textPane.setSelectionEnd(pos + wordToFind.length());
            textPane.requestFocusInWindow();
            currentPos = (currentPos + 1);
        } else {
            currentPos = 0;
        }
    }
    
    public static void highlightPrevious(String findText) {
    int sel = jTabbedPane1.getSelectedIndex();
            JTextPane textPane = (JTextPane) ((JScrollPane) ((JDesktopPane)jTabbedPane1.getComponentAt(sel)).getComponent(0)).getViewport().getComponent(0);
    boolean found = false;
        if (findText.isEmpty())
            return;
        String context = textPane.getText();
        String wordToFind = findText;
        if (wordToFind.length() > context.length())
            return;
        pos = currentPos - wordToFind.length();
        while (pos != currentPos) {
            if (pos < 0) {
                pos = context.length() - wordToFind.length();
            }
            if (context.subSequence(pos, pos + wordToFind.length()).equals(
                    wordToFind)) {
                found = true;
                currentPos = pos + 1;
                textPane.setSelectionStart(pos);
                textPane.setSelectionEnd(pos + wordToFind.length());
                textPane.requestFocusInWindow();
                break;
            }
            pos--;
        }
    }
}
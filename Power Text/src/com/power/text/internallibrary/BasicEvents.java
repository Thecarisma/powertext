/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.internallibrary;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JDesktopPane;
import javax.swing.text.Element;
import static com.power.text.Main.jTabbedPane1;
import com.power.text.PTextEditor;

/**
 *
 * @author thecarisma
 */
public class BasicEvents {
       static StringBuffer sbufer;
       static int ind = 0;
       static String findString;
       public static ArrayList<PTextEditor> Editor = com.power.text.Main.Editor;
    
   public static void FindWord(){
        int sel = jTabbedPane1.getSelectedIndex();
            JTextArea textPane = (JTextArea) ((JScrollPane) ((JDesktopPane)jTabbedPane1.getComponentAt(sel)).getComponent(0)).getViewport().getComponent(0);

            String input=(String) JOptionPane.showInputDialog(null,"Enter Text to Find :  ", "Find",JOptionPane.PLAIN_MESSAGE, null, null, null);
            if(input!=null)
            {
              int start = textPane.getText().indexOf(input);
              int end = input.length();
              if (start >= 0 && end > 0)
              {
                  textPane.select(start, start + end);
              }
            }
        }

    public static void GoToLine(){
        int sel = jTabbedPane1.getSelectedIndex();
            JTextArea textPane = (JTextArea) ((JScrollPane) ((JDesktopPane)jTabbedPane1.getComponentAt(sel)).getComponent(0)).getViewport().getComponent(0);

            do
            {
                try
                {
                    String str = (String) JOptionPane.showInputDialog(null,"Enter Line number :  "+"(1 - "+getLineCount(textPane)+" )", "GoTo Line",JOptionPane.PLAIN_MESSAGE, null, null, null);
                    if (str == null)
                    {
                        break;
                    }

                    int lineNumber = Integer.parseInt(str);
                    _lineCount = getLineCount(textPane);
                    if (lineNumber > _lineCount)
                    {
                        JOptionPane.showMessageDialog(null,"Line number out of range", "Error....",JOptionPane.ERROR_MESSAGE);
                        continue;
                    }
                    textPane.setCaretPosition(0);
                    textPane.setCaretPosition(SetCursor(lineNumber,textPane));
                    return;
                }
                catch (Exception e) { }
            }
            while (true);
    }

    public static int _lineCount;
    public static int getLineCount(JTextArea textPane)
    {
        _lineCount = 0;
        Scanner scanner = new Scanner(textPane.getText());
        while (scanner.hasNextLine())
        {
            String line = scanner.nextLine();
            _lineCount++;
        }
        return _lineCount;
    }

    public static int SetCursor(int newlineno,JTextArea textPane)
    {
        int pos = 0;
        int i = 0;
        String line = "";
        Scanner scanner = new Scanner(textPane.getText());
        while (scanner.hasNextLine())
        {
            line = scanner.nextLine();
            i++;
            if (newlineno > i)
            {
                pos = pos + line.length() + 1;
            }
        }
        return pos;
    }

    public static void Replace(){
        int sel = jTabbedPane1.getSelectedIndex();
        JTextArea textPane = (JTextArea) ((JScrollPane) ((JDesktopPane)jTabbedPane1.getComponentAt(sel)).getComponent(0)).getViewport().getComponent(0);
        try
				{
					String replace = JOptionPane.showInputDialog(null, "Replace");
					textPane.replaceSelection(replace);
				}catch(NumberFormatException nfe){}
    }
}

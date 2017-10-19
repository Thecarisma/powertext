/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.internallibrary;

import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;
import static com.power.text.Main.Totalsel;
import static com.power.text.Main.doti;
import static com.power.text.Main.cal;
import static com.power.text.dialogs.Summary.jLabel26;
import javax.swing.JTextArea;
import static com.power.text.Main.cln;
import static com.power.text.Main.jLabel500;
import static com.power.text.Main.jLabel501;
import static com.power.text.Main.statusLabel;

/**
 *
 * @author thecarisma
 */
public class Caretlistener implements CaretListener {
  
    
    public int getRow(int pos,JTextArea textPane1)
        {
            int rn=(pos==0) ? 1:0;
            try
            {
                int offs=pos;
                while(offs>0)
                {
                    offs=Utilities.getRowStart(textPane1, offs)-1;
                    rn++;
                }
            }
            catch(BadLocationException evt){ evt.printStackTrace();}

            return rn;
        }

        public int getColumn(int pos,JTextArea textPane1)
        {
            try
            {
                return pos-Utilities.getRowStart(textPane1, pos)+1;
            }
            catch (BadLocationException evt) {evt.printStackTrace();  }

            return -1;
        }

    
    @Override        
        public void caretUpdate(CaretEvent evt) {
           JTextArea textPane1 =(JTextArea)evt.getSource();
            int row = getRow(evt.getDot(), textPane1); //row += 1;
            int col = getColumn(evt.getDot(), textPane1);
            
    cal.setText("Line: " + row + " Column: " + col);
    cln = row;
                    
            //Get the location in the text
    int dot = evt.getDot();
    int mark = evt.getMark();
    int totalsel = mark - dot ;
    int totalsele = dot - mark ;
    if (dot == mark) {  
        //Rectangle caretCoords = textPane.modelToView(dot);
        
        Totalsel.setText("Caret Position: " + dot ); doti = dot;
        //jLabel17.setText("Caret Position : " + dot);
        //jLabel18.setText("Current Line : " + row);
        jLabel500.setText(""+row);   jLabel501.setText(""+col);
        //jLabel19.setText("Current Column : " + col);
        mark +=1 ;
     } else if (dot < mark) {
        statusLabel.setText("Selection : " + totalsel + "\t | \t" + row);
        jLabel26.setText("Selection : " + totalsel + "\t | \t" + row);
        
     } else {
        jLabel26.setText("Selection : " + totalsele + "\t | " + row);
        statusLabel.setText("Selection : " + totalsele + "\t | \t" + row);
     }
        }   
    
        /**public static String getText(){
		int caretPosition = textPane.getDocument().getLength();
		Element root = textPane.getDocument().getDefaultRootElement();
		String text = "1\n";
		for(int i = 2; i < root.getElementIndex( caretPosition ) + 2; i++)
			text += i + "\n";
		return text;
	}
                
	public void updateLineNumbers(){
        String lineNumbersText = getLineNumbersText();
        statusLabel.setText(lineNumbersText);
    }
    
    private String getLineNumbersText(){
        int caretPosition = textPane.getDocument().getLength();
        Element root = textPane.getDocument().getDefaultRootElement();
        StringBuilder lineNumbersTextBuilder = new StringBuilder();
        lineNumbersTextBuilder.append("1").append(System.lineSeparator());

        for (int elementIndex = 2; elementIndex < root.getElementIndex(caretPosition) + 2; elementIndex++)
        {
            lineNumbersTextBuilder.append(elementIndex).append(System.lineSeparator());
        }

        return lineNumbersTextBuilder.toString();
    }**/
    
}

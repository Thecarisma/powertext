/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.internallibrary;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
 
public class ConsoleNavigationFilter extends NavigationFilter
{
    private int prefixLength;
    private Action deletePrevious;
 
    public ConsoleNavigationFilter(int prefixLength, JTextComponent component)
    {
        this.prefixLength = prefixLength;
        deletePrevious = component.getActionMap().get("delete-previous");
        component.getActionMap().put("delete-previous", new BackspaceAction());
        //component.setCaretPosition(prefixLength);
    }
 
    public void setDot(NavigationFilter.FilterBypass fb, int dot, Position.Bias bias)
    {
        fb.setDot(Math.max(dot, prefixLength), bias);
    }
 
    public void moveDot(NavigationFilter.FilterBypass fb, int dot, Position.Bias bias)
    {
        fb.moveDot(Math.max(dot, prefixLength), bias);
    }
 
    class BackspaceAction extends AbstractAction
    {
        public void actionPerformed(ActionEvent e)
        {
            JTextComponent component = (JTextComponent)e.getSource();
 
            if (component.getCaretPosition() > prefixLength)
            {
                deletePrevious.actionPerformed( null );
            }
        }
    }
 
}

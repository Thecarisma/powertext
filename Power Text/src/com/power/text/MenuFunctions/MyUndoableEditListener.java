/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.MenuFunctions;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;

/**
 *
 * @author thecarisma
 */
public class MyUndoableEditListener implements UndoableEditListener {
    
	
    
    public void undoableEditHappened(UndoableEditEvent e) {
        //Remember the edit and update the menus
        //undo.addEdit(e.getEdit());
        //undoAction.update();
        //redoAction.update();
    }
}  


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.MenuFunctions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.undo.CannotUndoException;
//import static com.power.text.PTextEditor.undo;
//import static MenuFunctions.MyUndoableEditListener.undo;
/**
 *
 * @author thecarisma
 */
public class UndoAction extends AbstractAction {
    
	//public static UndoAction undoAction = new UndoAction();
    
	public UndoAction() {
	    super("Undo");
	    setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {
	    try {
		//undo.undo();
	    } catch (CannotUndoException ex) {
		System.out.println("Unable to undo: " + ex);
		ex.printStackTrace();
	    }
	    update();
	    //redoAction.update();
	}

	public void update() {
	    /**if(undo.canUndo()) {
		setEnabled(true); Tundo.setEnabled(true); Undo.setEnabled(true);
		putValue("Undo", undo.getUndoPresentationName());
	    }
	    else {
		setEnabled(false); Tundo.setEnabled(false); Undo.setEnabled(false);
		putValue(Action.NAME, "Undo");
	    }**/
	}
    }

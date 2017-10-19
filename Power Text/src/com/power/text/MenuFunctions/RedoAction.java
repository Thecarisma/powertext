/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.MenuFunctions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author thecarisma
 */
public class RedoAction extends AbstractAction {
    
    //public static RedoAction redoAction = new RedoAction();
    
	public RedoAction() {
	    super("Redo");
	    setEnabled(false);
	}

	public void actionPerformed(ActionEvent e) {
	    /*try {
		undo.redo();
	    } catch (CannotRedoException ex) {
		System.out.println("Unable to redo: " + ex);
		ex.printStackTrace();
	    }
	    update();
	    undoAction.update();*/
	}

	public void update() {
	    /*if(undo.canRedo()) {
		setEnabled(true); Tredo.setEnabled(true); redo.setEnabled(true);
		putValue("Redo", undo.getRedoPresentationName());
	    }
	    else {
		setEnabled(false); Tredo.setEnabled(false); redo.setEnabled(false);
		putValue(Action.NAME, "Redo");
	    }*/
	}
    }
  
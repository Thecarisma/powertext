package com.power.text;

import com.power.text.internallibrary.Caretlistener;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.Element;
import javax.swing.undo.*;

//import static power.text.Main.addlineNumberingTextArea;
import static com.power.text.Main.c;
import com.power.text.internallibrary.Caretlistener;
//import static power.text.Main.addScrollPane;

/**
 * Class for the text area used in each tab
 * 
 **/
public class TextPane extends JPanel {
    private static final long serialVersionUID = 5342961201711426309L;
    private JScrollPane scrollPane ;
    private JTextPane adddisplay = null;
    private JTextArea lineNumberBar ;
    private JTextField cursorStatusBar;
    private boolean savedStatus = false;
    private String fileName = "";
    private String fileDir = "";
    Caretlistener caretListenerLabel = new Caretlistener();
    final UndoManager undo = new UndoManager();

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileDir() {
        return fileDir;
    }

    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }

    public boolean getSavedStatus() {
        return savedStatus;
    }

    public void setSavedStatus(boolean savedStatus) {
        this.savedStatus = savedStatus;
    }

    public JTextPane getTextArea() {
        return (adddisplay);
    }

    public JTextArea getLineNumberBarArea() {
        return (lineNumberBar);
    }

    public TextPane() {
        //adddisplay.setFont(new Font("Serif", Font.PLAIN, 14));
        adddisplay.addCaretListener(caretListenerLabel);
        adddisplay.setEditable(true);
        //adddisplay.setEditorKit(editorKit);
        adddisplay.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        adddisplay.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        adddisplay.setDragEnabled(true);
        adddisplay.setSelectionColor(c);
        //scrollPane = addScrollPane;
        scrollPane.getViewport().add(adddisplay);
        scrollPane.setRowHeaderView(lineNumberBar);
        scrollPane.setBorder(null);
        scrollPane
                .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBorder(BorderFactory.createCompoundBorder(BorderFactory
                .createCompoundBorder(
                        BorderFactory.createLineBorder(new Color(111)),
                        BorderFactory.createEmptyBorder(6, 6, 6, 6)),
                scrollPane.getBorder()));
        this.setLayout(new BorderLayout());
        this.add(scrollPane, BorderLayout.CENTER);
        //cursorStatusBar = new JTextField();
        //this.add(cursorStatusBar, BorderLayout.SOUTH);
        //updatesBar(1, 0);
        adddisplay.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
                    public void undoableEditHappened(UndoableEditEvent e) {
                        undo.addEdit(e.getEdit());
                    }
                });
        adddisplay.getActionMap().put("Undo", new AbstractAction("Undo") {
            private static final long serialVersionUID = 5346267885089932145L;

            public void actionPerformed(ActionEvent evt) {
                undo();
            }
        });
        adddisplay.getActionMap().put("Redo", new AbstractAction("Redo") {
            private static final long serialVersionUID = 1890793635382898796L;

            public void actionPerformed(ActionEvent evt) {
                redo();
            }
        });
    }

    public void undo() {
        try {
            if (undo.canUndo()) {
                undo.undo();
            }
        } catch (CannotUndoException e) {
        }
    }

    public void redo() {
        try {
            if (undo.canRedo()) {
                undo.redo();
            }
        } catch (CannotRedoException e) {
        }
    }

    /**private void updatesBar(int rowNum, int colNum) {
        cursorStatusBar.setText("Line: " + rowNum + " Column: " + colNum);
    }**/
}

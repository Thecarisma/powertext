package com.power.text;

import java.awt.*;
import java.io.File;
import javax.swing.*;
import javax.swing.undo.*;

import javax.swing.JTextField;
import com.power.text.internallibrary.Caretlistener;
import com.power.text.Editor.PTDocumentListener;
import static com.power.text.Main.*;
import com.power.text.ui.pteditor.RSyntaxDocument;
import com.power.text.rtextarea.RTextScrollPane;
import com.power.text.ui.pteditor.RSyntaxTextArea;
import com.power.text.ui.pteditor.SyntaxScheme;
import java.awt.event.ActionEvent;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.JTextComponent;
import javax.swing.text.TextAction;

/**
 * Class for the text area used in each tab
 * 
 **/
public class PTextEditor extends JDesktopPane {
    private static final long serialVersionUID = 5342961201711426309L; public static RSyntaxTextArea adddisplays = new RSyntaxTextArea()  ;
    public RSyntaxTextArea adddisplay = new RSyntaxTextArea()  ; public static Color activeLineRangeColor = Color.BLUE;
    RTextScrollPane addScrollPane = new RTextScrollPane(adddisplay, true, Color.BLACK);  
    String styleSyntax = "java";  String ext = "txt";  ImageIcon bookmark = new ImageIcon(getClass().getResource("/com/power/text/images/bookmark.png"));
    RSyntaxDocument doc = new RSyntaxDocument(styleSyntax); public static Color addBackground = Color.WHITE ;
    public static JPopupMenu pop ;  public File file ; public static Color addForeground = Color.BLACK;
    /*public EditorKit addeditorKit = HashMapMJava.editorKit; */ public static Border border = BorderFactory.createLineBorder(new java.awt.Color(240,240,240)) ;
    public GroupLayout thisLayout = new GroupLayout(this); JCheckBoxMenuItem newWin = new JCheckBoxMenuItem();
    public JTextArea addlineNumberingTextArea = new JTextArea(); public static Color line = Color.DARK_GRAY ;
    public String content = ""  ; String parentFolder = "" ; public static SyntaxScheme addscheme = adddisplays.getSyntaxScheme();
    public Caretlistener addaddcaretListenerLabel = new Caretlistener();
    private boolean savedStatus = true;  PTDocumentListener documentlistener = new PTDocumentListener();
    private String fileName = ""; public JTextField fileExtL = new JTextField();
    private String fileDir =  "" ;public JTextField titletext = new JTextField();
    public int IndexNum = 0 ; public JPanel panel = new JPanel();  UndoManager _undoManager = new UndoManager();
   

    public PTextEditor() { 
        pop = adddisplay.getPopupMenu();
        pop.addSeparator();
        pop.add(new JMenuItem(new OpenFileAction()));
        pop.add(jMenu9); 
        pop.add(jMenuItem59);
        adddisplay.setDocument(doc);
        adddisplay.setCurrentLineHighlightColor(line);
        adddisplay.setBackground(addBackground);
        adddisplay.setForeground(addForeground);
        adddisplay.addCaretListener(addaddcaretListenerLabel);
        adddisplay.setEditable(true);
        adddisplay.setSyntaxScheme(addscheme);  
        adddisplay.setCodeFoldingEnabled(true);
        adddisplay.setFont(new java.awt.Font("Corbel", 0, 14)); 
        adddisplay.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        adddisplay.setDragEnabled(true);
        adddisplay.getFoldManager().setCodeFoldingEnabled(true);
        addScrollPane.setBorder(BorderFactory.createEmptyBorder());
        addScrollPane.setIconRowHeaderEnabled(true);
        addScrollPane.setFoldIndicatorEnabled(true);
        addScrollPane.getGutter().setFoldIndicatorEnabled(true);
        addScrollPane.getGutter().setFoldIndicatorEnabled(true);
        addScrollPane.getGutter().setBackground(addBackground);
        addScrollPane.setBackground(addBackground);
        addScrollPane.setBackground(addForeground);
        addScrollPane.setForeground(addForeground);
        addScrollPane.getGutter().setBackground(addBackground);
        addScrollPane.getGutter().setForeground(addForeground);
        addScrollPane.getGutter().setBorder(border);
        addScrollPane.getGutter().setFoldBackground(addBackground);
        addScrollPane.getGutter().setFoldIndicatorForeground(addForeground);
        addScrollPane.getGutter().setLineNumberColor(addForeground);
        addScrollPane.getGutter().setBorderColor(addBackground);
        addScrollPane.getGutter().setActiveLineRangeColor(activeLineRangeColor);
        addScrollPane.getGutter().setBookmarkIcon(bookmark); 
        addScrollPane.getGutter().setBookmarkingEnabled(true);
        addScrollPane.getGutter().setIconRowHeaderInheritsGutterBackground(true);
        this.setBackground(java.awt.Color.white);
        this.setLayer(addScrollPane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        this.setLayout(thisLayout);
        thisLayout.setHorizontalGroup(
            thisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 981, Short.MAX_VALUE)
        );
        thisLayout.setVerticalGroup(
            thisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
        );
    }
    
    public JDesktopPane getDesktopPane() {
        return this ;
    }
    
    public void setExt(String ext) {
        this.ext = ext ;
    }
    
    public String getExt() {
        return ext ;
    }
    
    public void setSyntaxDocument(String styleSyntax) {
        this.doc.setSyntaxStyle(styleSyntax); 
        this.styleSyntax = styleSyntax;
    }
    
    public String getSyntaxKey() {
        return styleSyntax;
    }
    
    public RSyntaxDocument getDocument() {
        return doc ;
    }
    
    public void setParentFolder(String parentFolderS) {
        this.parentFolder = parentFolderS;
    }
    
    public String getParentFolder() {
        return parentFolder ;
    }
    
    public void setContent(String contentS) {
        this.content = contentS;
    }
    
    public String getContent() {
        return content ;
    }
    
    public int getIndexNumber() {
        return IndexNum;
    }
    
    public String getFileName() {
        return fileName;
    }
    
    public void setMenuItem(JCheckBoxMenuItem menuItem){
        this.newWin = menuItem ;
    }
    
    public JCheckBoxMenuItem getMenuItem(){
        return newWin ;
    }
    
    public JTextField getFileDire(){
        return titletext;
    }
    
    public JTextField getFileExt(){
        return fileExtL;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    public void setIndexNumber(int IndexNum) {
        this.IndexNum = IndexNum;
    }

    public String getFileDir() {
        return fileDir;
    }
    
    public File getFile(){
        return file ;
    }
    
    public void setFile(String fileD) {
        this.file = new File(fileD);
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

    public JTextArea getTextPane() {
        return (adddisplay);
    }
    
    public JScrollPane getScrollPane() {
        return (addScrollPane);
    }

    public JTextArea getLineNumberBarArea() {
        return (addlineNumberingTextArea);
    }

    
    private class OpenFileAction extends TextAction {

      public OpenFileAction() {
         super("Open File");
      }

      public void actionPerformed(ActionEvent e) {

         JTextComponent tc = getTextComponent(e);
         String filename = null;

         // Get the name of the file to load. If there is a selection, use
         // that as the file name, otherwise, scan for a filename around
         // the caret.
         try {
            int selStart = tc.getSelectionStart();
            int selEnd = tc.getSelectionEnd();
            if (selStart != selEnd) {
               filename = tc.getText(selStart, selEnd - selStart);
            } else {
               filename = getFilenameAtCaret(tc);
            }
         } catch (BadLocationException ble) {
            ble.printStackTrace();
            UIManager.getLookAndFeel().provideErrorFeedback(tc);
            return;
         }

         menuFunctions.loadFile(new File(filename));

      }

      /**
       * Gets the filename that the caret is sitting on. Note that this is a
       * somewhat naive implementation and assumes filenames do not contain
       * whitespace or other "funny" characters, but it will catch most common
       * filenames.
       * 
       * @param tc The text component to look at.
       * @return The filename at the caret position.
       * @throws BadLocationException Shouldn't actually happen.
       */
      public String getFilenameAtCaret(JTextComponent tc) throws BadLocationException {
         int caret = tc.getCaretPosition();
         int start = caret;
         Document doc = tc.getDocument();
         while (start > 0) {
            char ch = doc.getText(start - 1, 1).charAt(0);
            if (isFilenameChar(ch)) {
               start--;
            } else {
               break;
            }
         }
         int end = caret;
         while (end < doc.getLength()) {
            char ch = doc.getText(end, 1).charAt(0);
            if (isFilenameChar(ch)) {
               end++;
            } else {
               break;
            }
         }
         return doc.getText(start, end - start);
      }

      public boolean isFilenameChar(char ch) {
         return Character.isLetterOrDigit(ch) || ch == ':' || ch == '.'
               || ch == File.separatorChar;
      }

   }

}

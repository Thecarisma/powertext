/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.power.text.Editor;

import static com.power.text.Main.Editor;
import java.awt.Cursor;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import static com.power.text.Main.jProgressBar1;
import static com.power.text.Main.jTabbedPane1;
import com.power.text.ui.pteditor.RSyntaxTextArea;
import static com.power.text.ui.pteditor.SyntaxConstants.*;

/**
 *
 * @author thecarisma
 */
public class PTEditorKit extends Thread implements PropertyChangeListener {
    
    String contentType = "" ;
    
    public void setContentType(String contentTypo){
       contentType = contentTypo; 
    }  
    
    @Override
    public void run(){
        int selectedIndex = jTabbedPane1.getSelectedIndex() ;
            JTextArea textPane = Editor.get(jTabbedPane1.getSelectedIndex()).getTextPane();
        if (contentType.equals("java")) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_JAVA); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if ("xml".equals(contentType) || "xaml".equals(contentType) || "xsl".equals(contentType) || "xslt".equals(contentType) || "xsd".equals(contentType)
                || "xul".equals(contentType) || "kml".equals(contentType) || "suq".equals(contentType) || "mxml".equals(contentType) || "xsml".equals(contentType)
                || "wsdl".equals(contentType) || "xlf".equals(contentType) || "xliff".equals(contentType) || "xbl".equals(contentType) || "sxbl".equals(contentType)
                || "sitemap".equals(contentType) || "gml".equals(contentType) || "gpx".equals(contentType) || "plist".equals(contentType)) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_XML); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("txt") || contentType.equals("text")) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_NONE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("css") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_CSS); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if ("html".equals(contentType) || "shtml".equals(contentType) || "xhtml".equals(contentType) || "htm".equals(contentType)
                  || "hmt".equals(contentType) || "shtm".equals(contentType) || "xht".equals(contentType) || "hta".equals(contentType)) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_HTML); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if ("as".equals(contentType) || "mx".equals(contentType) ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_ACTIONSCRIPT); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("asm") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_ASSEMBLER_X86); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("ada") ) { //ada not supported yet
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_NONE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("asp") ) { //active server page script not supprted yet
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_NONE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("au3") ) { //Autolt not supported yet
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_NONE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("bash") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_UNIX_SHELL); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("bat") ) { //batch file not supported yet using unix shell
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_WINDOWS_BATCH); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("c") ||  contentType.equals("lex")) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_C); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("bbcode") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_BBCODE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("clojure") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_CLOJURE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if ("ml".equals(contentType) || "mli".equals(contentType) || "sml".equals(contentType) || "thy".equals(contentType) ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_NONE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this); //manchine language not supported yet
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("cmake") ) {  
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_MAKEFILE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if ("cbl".equals(contentType) || "cbf".equals(contentType) || "cdb".equals(contentType) || "cdc".equals(contentType) || "cob".equals(contentType) ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_NONE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this); //common busines lang not supported yet
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("litcofee") ) {  //Coffee script not supported yet
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_NONE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if ("h".equals(contentType) || "hpp".equals(contentType) || "hxx".equals(contentType) || "cpp".equals(contentType) || "cxx".equals(contentType) || "cc".equals(contentType)) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_CPLUSPLUS); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("cs") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_CSHARP); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("d") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_D); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("diff") || contentType.equals("patch") ) { //Diff file not supported yet
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_NONE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("dockerfile") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_DOCKERFILE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("dart") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_DART); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("delphi") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_DELPHI); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("dtd") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_DTD); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("f77") || "f".equals(contentType) || "for".equals(contentType) || "f90".equals(contentType) || "f95".equals(contentType) || "f2k".equals(contentType) || "f23".equals(contentType)) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_FORTRAN); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if ("hs".equals(contentType) || "lsh".equals(contentType) || "las".equals(contentType)) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_NONE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this); //haskell not supported yet
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("groovy") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_GROOVY); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("hosts") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_HOSTS); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("htaccess") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_HTACCESS); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if ("jsm".equals(contentType) || "js".equals(contentType) || "jsx".equals(contentType) || "ts".equals(contentType) || "tsx".equals(contentType) ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_JAVASCRIPT); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("json") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_JSON); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("jsp") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_JSP); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("kix") ) { //kixtart not supported yet
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_NONE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if ("lsp".equals(contentType) || "lisp".equals(contentType)) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_LISP); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("lua") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_LUA); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("mak") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_MAKEFILE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("m") ) { //matric lab file not supported yet
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_NONE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("nfo") ) { //MDOS Style/ASCII Arts not supported yet
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_NONE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("less") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_LESS); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("tex") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_LATEX); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("jshintrc") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_JSON_WITH_COMMENTS); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("mm") ) { // Objective-C" file not supported yet
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_NONE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if ("nsi".equals(contentType) || "nsh".equals(contentType) ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_NSIS); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if ("pas".equals(contentType) || "pp".equals(contentType) || "inc".equals(contentType) || "ipr".equals(contentType)) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_NONE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);// pascal not supported yet
            jProgressBar1.setIndeterminate(true);
        } else if ("pl".equals(contentType) || "pm".equals(contentType) || "plx".equals(contentType)) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_PERL); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this); 
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("ps") ) { //post cript file not supported yet
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_NONE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if ("ps1".equals(contentType) || "psm".equals(contentType)) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_VISUAL_BASIC); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this); // windows powershell sharing with visual basic
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("properties") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_PROPERTIES_FILE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if ("py".equals(contentType) || "pyw".equals(contentType)) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_PYTHON); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if ("r".equals(contentType) || "s".equals(contentType) || "splus".equals(contentType)) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_CPLUSPLUS); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this); // r lang not supported yet sharing with c++
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("rc") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_WINDOWS_BATCH); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this); //Windows Resources not supported yet sharing with windows batch file
            jProgressBar1.setIndeterminate(true);
        } else if ("rb".equals(contentType) || "rbw".equals(contentType)) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_RUBY); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if ("scm".equals(contentType) || "smd".equals(contentType) || "ss".equals(contentType)) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_NONE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this); // Scheme file not supported yet
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("st") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_NONE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this); // small talk not supported yet
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("sql") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_SQL); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if ("sca".equals(contentType) || "scala".equals(contentType)) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_SCALA); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("sas") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_SAS); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("tcl") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_TCL); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if ("vb".equals(contentType) || "vbs".equals(contentType)) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_VISUAL_BASIC); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("typescript") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_TYPESCRIPT); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if ("v".equals(contentType) || "sv".equals(contentType) || "shv".equals(contentType) || "svh".equals(contentType)) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_NONE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this); //verilog not supported yet 
            jProgressBar1.setIndeterminate(true);
        } else if ("yml".equals(contentType) || "yaml".equals(contentType)) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_NONE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this); //yaml file not supported yet
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("pteditor") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_NONE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this); //power text editor generated file not supported yet
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("ptestate") ) {  //power text editor saved state file not supported yet
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_NONE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("pteplugin") ) { //power text editor plugin file not supported yet
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_NONE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else if (contentType.equals("form") ) { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_XML); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);
        } else { 
            Task task = new Task(selectedIndex, textPane, SYNTAX_STYLE_NONE); task.execute(); jProgressBar1.setVisible(true);
            task.addPropertyChangeListener(this);
            jProgressBar1.setIndeterminate(true);        
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("progress".equals(evt.getPropertyName())) {
            int progress = (Integer) evt.getNewValue();
            jProgressBar1.setIndeterminate(false);
            jProgressBar1.setValue(progress);
        }
    }
    
    class Task extends SwingWorker<Void, Void> {
        
        JTextArea textPane ; int sel = 0; String syntax = "";
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        
        public Task(int sel, JTextArea textPane, String syntax){
            this.sel = sel; this.textPane = textPane; this.syntax = syntax;
            textPane.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        }
        /*
         * Main task. Executed in background thread.
         */
        @Override 
        public Void doInBackground() throws InterruptedException {
            Random random = new Random();
            int progress = 0; 
            //Initialize progress property.
            setProgress(0); int sel = jTabbedPane1.getSelectedIndex() ;
            Editor.get(sel).setSyntaxDocument(syntax);
            while (progress < textPane.getText().length()) {
                //Sleep for up to one second.
                try {
                    Thread.sleep(random.nextInt(100));
                } catch (InterruptedException ignore) {}
                //Make random progress.
                progress += textPane.getText().length()/10;
                setProgress(Math.min(progress, 100));
            }   
            return null;
        }
        

        /*
         * Executed in event dispatch thread
         */
        @Override
        public void done() {
            Toolkit.getDefaultToolkit().beep();
            textPane.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
            jProgressBar1.setVisible(false);  
        }
    }
    
}

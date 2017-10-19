 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text;


import com.power.text.dialogs.*;
import com.power.text.TabList.*;
import com.power.text.Editor.*;
import java.awt.*;
import javax.swing.*;
import java.nio.file.*;
import java.awt.event.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.logging.*;
import javax.swing.text.*;
import javax.swing.undo.*;
import java.awt.print.*;
import javax.swing.Timer;

import java.awt.Desktop;
import com.power.text.Run.*;

import com.power.text.internallibrary.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.net.*;

import com.power.text.FileLibrary.*;
import com.power.text.MenuFunctions.MenuFunctions;
import java.awt.datatransfer.*;
import javax.swing.text.Highlighter.HighlightPainter;
import static com.power.text.internallibrary.BasicEvents.*;
import javax.swing.tree.*;

import com.power.text.TPMode.*;
import static com.power.text.dialogs.Summary.*;
import static com.power.text.internallibrary.PTPaths.*;
import com.power.text.rtextarea.*;
import java.nio.charset.*;
import java.security.*;
import javax.swing.filechooser.*;
import javax.swing.table.*;
import power.text.plugin.*;
import static com.power.text.ui.pteditor.SyntaxConstants.*;
import com.power.text.dialogs.Console;
import com.power.text.pteditor.themes.Theme;
import static com.power.text.rtextarea.RTextArea.redoAction;
import static com.power.text.rtextarea.RTextArea.undoAction;
import com.power.text.rtextarea.RTextAreaEditorKit.*;
import com.power.text.ui.pteditor.*;
import com.power.text.ui.pteditor.RSyntaxTextAreaEditorKit.DecreaseIndentAction;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author thecarisma
 **/


public final class Main extends javax.swing.JFrame {

    public String currentFileD ; public static DefaultListModel listModel =new DefaultListModel(); int consoleInt = 1 ;
    public static DefaultListModel filesHoldListModel=new DefaultListModel(); public static Main main ; public static Theme tm ;
    File currentFile = null; JSplitPane jsplit;  JList filesHoldList=new JList(filesHoldListModel); public static int cln =  0;
    public static JTextArea lineNumberingTextArea;   public static DefaultListModel documentModel =new DefaultListModel();
    private JTextArea lines;  Toolkit toolkit=Toolkit.getDefaultToolkit(); public static Color backgroundColor = Color.WHITE ;
    JLabel tab1Label = new JLabel("tab1");  //public static ArrayList<JTextField> contentModel =new ArrayList<JTextField>();
    JPanel tab1 = new JPanel(); public static JTextField titleText = new JTextField(); Console console ; Object customTag = "" ;
    String newline = null ; public static JTextField titleExtLa = new JTextField(); public static String version = "Power Text Editor v0.1" ;
    public static String word; public DefaultMutableTreeNode root; public static ArrayList<PowerTextPlugin> Plugins = new ArrayList<>();
    private PrinterJob job;   ; public static String fullVersion = "Power Text Editor v0.1 (Build 0072)" ; public static int firstrun = 1 ;
    public PageFormat format; NewProject newProj = new NewProject(this, opened); public static String versionNumber = "0.1" ;
    public static int lastMatch;  public static String build = "Build 0072" ; public static String buildNumber = "0272" ; 
    public static String find = "Method"; public static String releaseDate = "1st June 2017" ;  public static String date = "01/06/17" ; 
    public static Color c = new Color(255,102,102); public static String author = "Azeez Adewale" ; public static String location = "Ibadan" ; 
    public static HighlightPainter highlightPainter ; public static String language = "JAVA" ; public static String system = "DELL Latitude" ; 
    public static Object highlightTag;  public static String os = "Windows OS" ; public static ArrayList<String> pluginPath = new ArrayList<>();
        private String  lastClosedFile;  public static ArrayList<String> pluginMapPath = new ArrayList<>(); Object greenTag = "";
        public String documentType;    public com.power.text.dialogs.Documents documentPane = new com.power.text.dialogs.Documents(this, opened); 
        public PluginManager pluginManager ; public com.power.text.dialogs.About aboutPanel = new com.power.text.dialogs.About(this, opened);
        private final DefaultStyledDocument document = new DefaultStyledDocument();  Object redTag = ""; Object blueTag = ""; Object yellowTag = "";
        int start, end, offset1,length1;    int rfcount = 0 ; public static DefaultListModel macroModel =new DefaultListModel();
    int dat = 0; public static String sel = "Selected Text" ; public static String selu ; String OS = System.getProperty("os.name").toUpperCase();
    public static ArrayList<PTextEditor> Editor = new ArrayList<>(); public static String themePath = "" ; public int documentMapFontSize = 3 ;
    public final int STATUS_ERROR = -1; public static ArrayList<PTextPTree> PTree = new ArrayList<PTextPTree>(); 
    public final int STATUS_OK = 0; public int saveint = 0 ; public static RSyntaxTextArea documentMap = new RSyntaxTextArea()  ; 
    public final int STATUS_NO = 1;  DefaultListModel copylistModel = new DefaultListModel(); public static Color activeLineRangeColor = Color.BLUE;
    public final int STATUS_CANCEL = 2; public static ArrayList<PTextPTree> Editree = new ArrayList<PTextPTree>(); public FirstRun firstrund = new FirstRun(this, true);
    public static int count = 1; ArrayList<JMenuItem> newWinA = new ArrayList<>(); public ThemeManager themeManager = new ThemeManager(this, opened);
    public int sessionCounter = 0; public com.power.text.dialogs.Summary summaryPane ; int x= this.getWidth(); int y = this.getHeight(); int l = getX(); int b = getY();
    Clipboard clip = getToolkit().getSystemClipboard(); public com.power.text.dialogs.RunDialog runPanel = new com.power.text.dialogs.RunDialog(this, opened);
    public DefaultListModel fileListModel =new DefaultListModel(); public static MenuFunctions menuFunctions = new MenuFunctions();
    public com.power.text.dialogs.WebSearch websearchPanel = new com.power.text.dialogs.WebSearch(null, opened);
    
    /**
     * Creates new form main
     * @throws java.io.FileNotFoundException
     */
    
    /**
     * Creates new form Main
     * @return
     */
    
    public Point getCenterPoints(){
        Point pt=new Point(0,0);
        Dimension d=  toolkit.getScreenSize();
        pt.x=d.width/4;
        pt.y=d.height/4;

        return pt;
    }
    
    static void readin(String fn, JTextComponent pane) {
            try {
                FileReader fr = new FileReader(fn);
                pane.read(fr, null);
                fr.close();
            }
            catch (IOException e) {
                System.err.println(e);
            }
        }
    
    @SuppressWarnings("RedundantStringToString")
    public Main() throws FileNotFoundException {
        initComponents(); jMenuItem151.setEnabled(false); main = this; jScrollPane2.getViewport().add(documentMap);
        jPanel3.setVisible(false); jPanel1.setVisible(false); jMenuItem152.setEnabled(false); 
        jPanel10.setVisible(false); jProgressBar1.setVisible(false); jTabbedPane1.setUI(new CustomTabbedPaneUI(Color.WHITE, Color.BLACK, false));
        jMenu19.setVisible(false); jMenuItem85.setEnabled(false);  jMenuItem154.setEnabled(false); 
        summaryPane = new com.power.text.dialogs.Summary(this, opened); setLocationRelativeTo(null);
        Undo.addActionListener(undoAction); redo.addActionListener(redoAction);
        Undo1.addActionListener(undoAction); redoaction1.addActionListener(redoAction);
        Tundo.addActionListener(undoAction); Tredo.addActionListener(redoAction);
        togglesearch.setSelected(false); searchbox.setVisible(false); searchbutton.setVisible(false);
 
        setIcon(); documentMap.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int selectedIndex = jTabbedPane1.getSelectedIndex();
                RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
                textPane.setCaretPosition(documentMap.getCaretPosition());
            }
        });
        Timer timer = new Timer(1000, timerListener); timer.setInitialDelay(0); timer.start();
        
        Timer statussel = new Timer(1, statustime); statussel.setInitialDelay(0); statussel.start();
        
        Timer statustimer = new Timer(5000, statusListener); statustimer.setInitialDelay(0); statustimer.start();
        
        createIfDoesNotExist(); 
        File macroFolder = new File(getMyMacroFolder()); 
        //get list of saved macros
        File[] macroFiles = macroFolder.listFiles();
        if (macroFolder.listFiles()!=null) {for (File macroFile : macroFiles) {
            macroModel.addElement(macroFile.getName().replace(".xml", ""));
        } }
    
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
                Calendar cal = Calendar.getInstance();
                dateLabel.setText(date.format(cal.getTime()));
                
                this.addWindowListener(new WindowAdapter() {
                    
            @Override public void windowClosing(WindowEvent e) {
                super.windowClosing(e); setCurrentSizeAndLocation() ;
                setOpendFiles() ; deleteOpened(); System.exit(0); 
            }
            //@Override public void windowOpened(WindowEvent e) {
               // initiateEditor(); loadRecent();  getSavedSizeAndLocation(); checkIncomingFile();
            //}
            @Override public void windowClosed(WindowEvent e) {}
            @Override public void windowIconified(WindowEvent e) {}
            @Override public void windowDeiconified(WindowEvent e) {}
            @Override public void windowActivated(WindowEvent e) {}
            @Override public void windowDeactivated(WindowEvent e) {}

        });
                
    }
    
    private void loadPlugins() {
        try {
            Policy.setPolicy(new PluginPolicy());
            System.setSecurityManager(new SecurityManager());
            if (new File(getPluginPath()).listFiles()!=null) {
            File[] pluginFiles = new File(getPluginPath()).listFiles();
            File[] pluginXml = new File(getPluginXmlPath()).listFiles();
            for (File plugin : pluginFiles) {
                pluginPath.add(plugin.getAbsolutePath());
                ClassLoader authorizedLoader = URLClassLoader.newInstance(new URL[] { plugin.toURL() });//
                for (File xml : pluginXml ) { 
                    if (xml.getName().contains(plugin.getName())) {
                        String text = new String(Files.readAllBytes(Paths.get(xml.getAbsolutePath())), StandardCharsets.UTF_8);
                        PowerTextPlugin authorizedPlugin = (PowerTextPlugin) authorizedLoader.loadClass(text.replace(" deactivated", "")).newInstance();
                        if (!text.contains(" deactivated")) { authorizedPlugin.run(); } else {} 
                        Plugins.add(authorizedPlugin); pluginMapPath.add(xml.getAbsolutePath()); 

                    }
                }
            } }
        } catch (ClassNotFoundException | MalformedURLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public TableColumn setTableModel(){
        TableColumn col = new TableColumn();
        
        return col;
    }
    
    public void setCurrentSizeAndLocation() {
        BufferedWriter bufferedWriter = null; String size = "" ; try { 
                    int width = this.getWidth() ; int height = this.getHeight() ;
                    Point locationPoint = this.getLocation(); int locationX = locationPoint.x; int locationY = locationPoint.y;
                    size = "" + width + "\n" + height + "\n" + locationX + "\n" + locationY + "\n" + themePath; 
                    String filePath = getPowerTextGen()+"sizeandlocation.pteditor";
                    bufferedWriter = new BufferedWriter(new FileWriter(filePath, false));
                    bufferedWriter.write(size);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                try {
                    if (bufferedWriter != null) {
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    } 
                } catch (IOException ex) {
                    ex.getMessage();
                }
            }
    }
    
    private void deleteOpened() {
        if (new File(getPowerTextGen()+"powertextopened.pteditor").exists()) {
           new File(getPowerTextGen()+"powertextopened.pteditor").deleteOnExit();
        }
    }
    
    public void checkIncomingFile() {
        String buffer = "";
         try { File logFile = new File(getOSAppDataFolder()+"incoming.pteditor"); 
         if (logFile.exists()) { Scanner scn = new Scanner(new FileInputStream(logFile)); 
        while (scn.hasNext()) {  buffer = scn.nextLine() ;  }   openFromContext(buffer); }
         else { createFile(getOSAppDataFolder()+"incoming.pteditor"); } 
         } catch (IOException ex) {  Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void openFromContext(String incoming) {
        if (!incoming.equals("")) {
            File openFile = new File(incoming.replace("\n", "")); 
            if (openFile.exists()) { try { 
                    Scanner scn1 = new Scanner(new FileInputStream(openFile)); openFile(openFile, scn1);
                    } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } } 
            else { System.out.println("File Does not exist anymore"); }
        } else {
             System.out.println("No parameters are passed");
        }
        
        //currently a work aroud to enable only one window is open
        if (new File(getPowerTextGen()+"powertextopened.pteditor").exists()) {
            File inFile = new File(getOSAppDataFolder()+"incoming.pteditor");
            if (inFile.exists()) {
            BufferedWriter bufferedWriter ;
            try {
                    bufferedWriter = new BufferedWriter(new FileWriter(inFile.getAbsolutePath(), false));
                    bufferedWriter.write(incoming); bufferedWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }  System.exit(0);
        } }
        
    }
    
    public static void createFile(String filePath) {
                    try { 
                        FileOutputStream d = new FileOutputStream(filePath);
                        String line = ""; d.write(line.getBytes()); d.close(); 
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
     }    
    
    public void getSavedSizeAndLocation() {
        int width = 0 ; int height = 0; int locationX = 0 ; int locationY = 0; String theme = "default";
        try { File OpenedFile = new File(getPowerTextGen()+"sizeandlocation.pteditor"); if (OpenedFile.exists()) {
            Scanner scn = new Scanner(new FileInputStream(OpenedFile)); if (scn.hasNext()) {
        while (scn.hasNextInt()) { if (width==0) { width = scn.nextInt();  System.out.println("width > "+width);} 
                else if (height==0){height = scn.nextInt();  System.out.println("height> "+height);}
                else if (locationX==0) { locationX =  scn.nextInt(); System.out.println("locationX > "+locationX); } 
                else if (locationY==0) {locationY =  scn.nextInt(); System.out.println("locationY > "+locationY);}
                else {  }
         } while (scn.hasNextLine()) { theme = scn.nextLine(); System.out.println("theme > "+theme); }  this.setSize(width, height); 
            this.setLocation(locationX, locationY); } else { 
            System.out.println("size file list is empty"); newInitFile(""); }
        }else { System.out.println("No size file found"); createFile(getPowerTextGen()+"sizeandlocation.pteditor"); newInitFile(""); }
        } catch (FileNotFoundException ex) { Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex); } main = this ;
        console = new Console(this); loadDefaultPlugin(); loadPlugins(); menuFunctions.setMain(this); 
        pluginManager = new PluginManager(this, opened);  checkIncomingFile(); loadTheme(theme); this.setVisible(true); 
        if (firstrun==100000000&&OS.contains("WIN")) { firstrund.setVisible(true); } File opened = new File(getPowerTextGen()+"powertextopened.pteditor"); 
        if (opened.exists()) {} else { try { opened.createNewFile(); } catch (IOException ex) {
        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex); }
}
    }
    
    private void loadDefaultPlugin() {
        try {
            Policy.setPolicy(new PluginPolicy());
            System.setSecurityManager(new SecurityManager());
            if (new File("plugins/").listFiles()!=null) {
            File[] pluginFiles = new File("plugins/").listFiles();
            File[] pluginXml = new File("plugins/packages/").listFiles();
            for (File plugin : pluginFiles) {
                pluginPath.add(plugin.getAbsolutePath());
                ClassLoader authorizedLoader = URLClassLoader.newInstance(new URL[] { plugin.toURL() });//
                for (File xml : pluginXml ) { 
                    if (xml.getName().contains(plugin.getName())) {
                        String text = new String(Files.readAllBytes(Paths.get(xml.getAbsolutePath())), StandardCharsets.UTF_8);
                        PowerTextPlugin authorizedPlugin = (PowerTextPlugin) authorizedLoader.loadClass(text.replace(" deactivated", "")).newInstance();
                        if (!text.contains(" deactivated")) { authorizedPlugin.run(); } else {} 
                        Plugins.add(authorizedPlugin); pluginMapPath.add(xml.getAbsolutePath()); 

                    }
                }
            } }
        } catch (ClassNotFoundException | MalformedURLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadTheme(String theme) {
        InputStream stream = null ;
        if (theme==null||theme.equals("")) {
            stream = Main.class.getResourceAsStream("/com/power/text/pteditor/themes/default.xml") ;
            themePath = "/com/power/text/pteditor/themes/default.xml" ;
        } else if (theme.contains("/com/power/text/pteditor/")) {
            stream = Main.class.getResourceAsStream(theme) ;System.out.println(theme);
        } else {
            try {
                stream = new FileInputStream(theme);
                themePath = theme ;
            } catch (FileNotFoundException ex) {
                stream = Main.class.getResourceAsStream("/com/power/text/pteditor/themes/default.xml") ;
                themePath = "/com/power/text/pteditor/themes/default.xml";
            }
        }
        tm = new Theme(new RSyntaxTextArea(), this);
        tm.loadTheme(stream); tm.apply(); 
    }
    
    public void loadRecent() {
        JMenuItem menuI ;
        String buffer = ""; try { File OpenedFile = new File(getPowerTextGen()+"recentfiles.pteditor"); if (OpenedFile.exists()) {Scanner scn = new Scanner(new FileInputStream(OpenedFile));
        if (scn.hasNext()) {
        while (scn.hasNext()) { buffer = scn.nextLine();  System.out.println("path > "+buffer);/**if (buffer.contains("administrator")) {**/ 
        rfcount = rfcount + 1; menuI = new JMenuItem(rfcount+" -"+buffer); setRecentMI(menuI); }  } else { 
            System.out.println("recently opened file list is empty"); }
        }else { System.out.println("No recently opend file found"); createFile(getPowerTextGen()+"recentfiles.pteditor"); }
        } catch (FileNotFoundException ex) { Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex); }   
    }
    
    public void setOpendFiles() {
        BufferedWriter bufferedWriter = null; String directories = "" ; try {
                    int tabs = jTabbedPane1.getTabCount() - 1; //10
                        for (int i = 0; i <= tabs; i++) {
                        String dir = Editor.get(i).getFileDire().getText(); directories += dir+"\n" ;
                      } String filePath = getPowerTextGen()+"opendfiles.pteditor";
                    bufferedWriter = new BufferedWriter(new FileWriter(filePath, false));
                    bufferedWriter.write(directories);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                try {
                    if (bufferedWriter != null) {
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    } 
                } catch (IOException ex) {
                    ex.getMessage();
                }
            }
    }
    
    public JMenuItem setRecentMI(JMenuItem newRecent){
            menuItem.add(newRecent); String newRecent1 = newRecent.getText();
            String[] splitStrings = newRecent1.split("\\-") ; //[Untitled 0, txt]
            String recentFinal = splitStrings[splitStrings.length-1] ;
            newRecent.addActionListener((java.awt.event.ActionEvent evt) -> {
                try {
                    File files = new File(recentFinal);
                    Scanner scn = new Scanner(new FileInputStream(files));
                    openFile(files, scn);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        return newRecent;
    }
   
    private void initiateEditor() {
        String buffer = ""; try { File OpenedFile = new File(getPowerTextGen()+"opendfiles.pteditor"); if (OpenedFile.exists()) {Scanner scn = new Scanner(new FileInputStream(OpenedFile));
        if (scn.hasNext()) {
        while (scn.hasNext()) { buffer = scn.nextLine();  System.out.println("path > "+buffer);/**if (buffer.contains("administrator")) {**/ 
        File openFile = new File(buffer); 
        if (openFile.exists()) { Scanner scn1 = new Scanner(new FileInputStream(openFile)); openFile(openFile, scn1); } 
        else { System.out.println("File Does not exist anymore"); } } } else { 
            System.out.println("opened file list is empty"); newInitFile(""); }
        } else { System.out.println("No opend file found"); createFile(getPowerTextGen()+"opendfiles.pteditor"); newInitFile(""); }
        } catch (FileNotFoundException ex) { Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex); }         
    }
    
    private String getUntitledList(String Untitled) {
        DefaultListModel ulm = new DefaultListModel(); 
        File[] ufiles = new File(getUnsavedFiles()).listFiles();
        for (File ufile : ufiles) {
            String uname = ufile.getAbsolutePath(); 
            ulm.addElement(uname); if (ulm.contains(Untitled.replace("/", "\\"))||ulm.contains(Untitled)) {
                count = count + 1 ;
                Untitled = getUnsavedFiles()+"Untitled "+ count +".txt" ;
            }
        } 
        return Untitled ;
    }
    
    public void newInitFile(String name) {
        String nam = name ; 
        if (name.equals("")) { 
            if (OS.contains("WIN")) {
                name = getUntitledList(getUnsavedFiles()+"Untitled "+ count +".txt"); 
            } else if (OS.contains("MAC")) {
                name = getUntitledList(getUnsavedFiles()+"Untitled "+ count +".txt").replace("Untitled", ".Untitled"); 
            } else if (OS.contains("NUX")||OS.contains("NIX")) {
                name = getUntitledList(getUnsavedFiles()+"Untitled "+ count +".txt").replace("Untitled", ".Untitled"); 
            }
        } else { name = System.getProperty("user.home")+"/Documents/"+nam; }
        
        File NewFile =  new File(name); 
        try {
            try (DataOutputStream d = new DataOutputStream(new FileOutputStream(NewFile))) {
                String line = "" ;
                d.writeBytes(line);
            } Scanner scn = new Scanner(new FileInputStream(NewFile)); openFile(NewFile, scn);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        menucopy1 = new javax.swing.JMenuItem();
        menucut1 = new javax.swing.JMenuItem();
        menupaste1 = new javax.swing.JMenuItem();
        menuclear1 = new javax.swing.JMenuItem();
        filesave = new javax.swing.JFileChooser();
        filesaveas = new javax.swing.JFileChooser();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenuItem40 = new javax.swing.JMenuItem();
        line7 = new javax.swing.JPopupMenu.Separator();
        jMenuItem42 = new javax.swing.JMenuItem();
        jMenuItem43 = new javax.swing.JMenuItem();
        jMenuItem44 = new javax.swing.JMenuItem();
        jMenuItem45 = new javax.swing.JMenuItem();
        jMenuItem46 = new javax.swing.JMenuItem();
        line8 = new javax.swing.JPopupMenu.Separator();
        jMenuItem47 = new javax.swing.JMenuItem();
        jMenuItem48 = new javax.swing.JMenuItem();
        jMenuItem49 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem50 = new javax.swing.JMenuItem();
        jMenuItem59 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        Undo1 = new javax.swing.JMenuItem();
        redoaction1 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        selectDir = new javax.swing.JFileChooser();
        jPanel8 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jSlider1 = new javax.swing.JSlider();
        jLabel500 = new javax.swing.JLabel();
        jLabel501 = new javax.swing.JLabel();
        jMenu18 = new javax.swing.JMenu();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jMenuItem61 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem60 = new javax.swing.JMenuItem();
        jMenuItem64 = new javax.swing.JMenuItem();
        jMenuItem65 = new javax.swing.JMenuItem();
        jMenuItem67 = new javax.swing.JMenuItem();
        jMenuItem66 = new javax.swing.JMenuItem();
        jDialog1 = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        saveStateD = new javax.swing.JFileChooser();
        macroChooser = new javax.swing.JFileChooser();
        macroList = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jList2.addListSelectionListener(new MacroListLoad());
        ;
        jColorChooser1 = new javax.swing.JColorChooser();
        toolbar = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        TnewFile = new javax.swing.JButton();
        TopenFile = new javax.swing.JButton();
        TsaveFile = new javax.swing.JButton();
        TsaveFile1 = new javax.swing.JButton();
        Tprint = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Tcopy = new javax.swing.JButton();
        Tcut = new javax.swing.JButton();
        Tpaste = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Tif = new javax.swing.JButton();
        Tsf = new javax.swing.JButton();
        Tdf = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Tundo = new javax.swing.JButton();
        Tredo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        editoronly = new javax.swing.JButton();
        searchbox = new javax.swing.JTextField();
        searchbutton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        statusPanel = new javax.swing.JPanel();
        statusPanel1 = new javax.swing.JPanel();
        statusPanel1.add(status, BorderLayout.CENTER);
        ;
        statusLabel = new javax.swing.JLabel();
        notification = new javax.swing.JLabel();
        cal = new javax.swing.JLabel();
        Totalsel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        fileext = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel16 = new javax.swing.JLabel();
        osEncoding = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel10 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        incresearch = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton1.setVisible(false)
        ;
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jPanel11 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane1.addChangeListener(new TabChanged());
        ;
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jList1.addListSelectionListener(new SelectTabFromListItem())
        ;
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jList3.addListSelectionListener(new CopyListBoard())
        ;
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuItem = new javax.swing.JMenu();
        jMenuItem82 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu20 = new javax.swing.JMenu();
        jMenuItem86 = new javax.swing.JMenuItem();
        jMenuItem87 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem88 = new javax.swing.JMenuItem();
        jMenuItem89 = new javax.swing.JMenuItem();
        jMenuItem69 = new javax.swing.JMenuItem();
        jMenuItem68 = new javax.swing.JMenuItem();
        line17 = new javax.swing.JPopupMenu.Separator();
        jMenuItem90 = new javax.swing.JMenuItem();
        jMenuItem91 = new javax.swing.JMenuItem();
        line3 = new javax.swing.JPopupMenu.Separator();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        line15 = new javax.swing.JPopupMenu.Separator();
        jMenuItem85 = new javax.swing.JMenuItem();
        jMenuItem83 = new javax.swing.JMenuItem();
        jMenuItem84 = new javax.swing.JMenuItem();
        line16 = new javax.swing.JPopupMenu.Separator();
        jMenuItem15 = new javax.swing.JMenuItem();
        line18 = new javax.swing.JPopupMenu.Separator();
        jMenu19 = new javax.swing.JMenu();
        jMenuItem63 = new javax.swing.JMenuItem();
        jMenuItem77 = new javax.swing.JMenuItem();
        line13 = new javax.swing.JPopupMenu.Separator();
        jMenuItem78 = new javax.swing.JMenuItem();
        jMenuItem79 = new javax.swing.JMenuItem();
        line14 = new javax.swing.JPopupMenu.Separator();
        jMenuItem80 = new javax.swing.JMenuItem();
        jMenuItem81 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Undo = new javax.swing.JMenuItem();
        redo = new javax.swing.JMenuItem();
        line1 = new javax.swing.JPopupMenu.Separator();
        menucut = new javax.swing.JMenuItem();
        menucopy = new javax.swing.JMenuItem();
        menupaste = new javax.swing.JMenuItem();
        menuclear = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        line9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem176 = new javax.swing.JMenuItem();
        jMenu11 = new javax.swing.JMenu();
        jMenuItem55 = new javax.swing.JMenuItem();
        jMenuItem56 = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        jMenuItem158 = new javax.swing.JMenuItem();
        jMenuItem159 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem51 = new javax.swing.JMenuItem();
        jMenuItem52 = new javax.swing.JMenuItem();
        jMenuItem53 = new javax.swing.JMenuItem();
        jMenuItem54 = new javax.swing.JMenuItem();
        jMenu12 = new javax.swing.JMenu();
        jMenuItem57 = new javax.swing.JMenuItem();
        jMenuItem58 = new javax.swing.JMenuItem();
        jMenuItem157 = new javax.swing.JMenuItem();
        jMenu22 = new javax.swing.JMenu();
        jMenuItem97 = new javax.swing.JMenuItem();
        jMenuItem98 = new javax.swing.JMenuItem();
        jMenuItem99 = new javax.swing.JMenuItem();
        jMenuItem100 = new javax.swing.JMenuItem();
        jMenu21 = new javax.swing.JMenu();
        jMenuItem93 = new javax.swing.JMenuItem();
        jMenuItem92 = new javax.swing.JMenuItem();
        jMenuItem175 = new javax.swing.JMenuItem();
        jMenuItem94 = new javax.swing.JMenuItem();
        jMenuItem177 = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        jMenuItem95 = new javax.swing.JMenuItem();
        jMenuItem96 = new javax.swing.JMenuItem();
        jMenu34 = new javax.swing.JMenu();
        jMenuItem155 = new javax.swing.JMenuItem();
        jMenuItem156 = new javax.swing.JMenuItem();
        line10 = new javax.swing.JPopupMenu.Separator();
        editableMI = new javax.swing.JRadioButtonMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem29 = new javax.swing.JMenuItem();
        jMenuItem30 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        line2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem41 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem172 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        line11 = new javax.swing.JPopupMenu.Separator();
        jMenu35 = new javax.swing.JMenu();
        jMenuItem160 = new javax.swing.JMenuItem();
        jMenuItem161 = new javax.swing.JMenuItem();
        jMenuItem162 = new javax.swing.JMenuItem();
        jMenuItem163 = new javax.swing.JMenuItem();
        jMenuItem164 = new javax.swing.JMenuItem();
        jMenu36 = new javax.swing.JMenu();
        jMenuItem171 = new javax.swing.JMenuItem();
        jMenuItem165 = new javax.swing.JMenuItem();
        jMenuItem166 = new javax.swing.JMenuItem();
        jMenuItem167 = new javax.swing.JMenuItem();
        jMenuItem168 = new javax.swing.JMenuItem();
        jMenuItem169 = new javax.swing.JMenuItem();
        jMenuItem170 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        jMenuItem178 = new javax.swing.JMenuItem();
        jMenuItem179 = new javax.swing.JMenuItem();
        jMenuItem173 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        toggletoolbar = new javax.swing.JCheckBoxMenuItem();
        togglesearch = new javax.swing.JCheckBoxMenuItem();
        line4 = new javax.swing.JPopupMenu.Separator();
        docuselector = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        cliphist = new javax.swing.JCheckBoxMenuItem();
        jMenuItem149 = new javax.swing.JMenuItem();
        line12 = new javax.swing.JPopupMenu.Separator();
        toglestatuspanel = new javax.swing.JCheckBoxMenuItem();
        jMenu17 = new javax.swing.JMenu();
        togglecaretpos = new javax.swing.JCheckBoxMenuItem();
        toggletimeelapsed = new javax.swing.JCheckBoxMenuItem();
        toglecal = new javax.swing.JCheckBoxMenuItem();
        togleselection = new javax.swing.JCheckBoxMenuItem();
        togledate = new javax.swing.JCheckBoxMenuItem();
        togletime = new javax.swing.JCheckBoxMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        jCheckBoxMenuItem5 = new javax.swing.JCheckBoxMenuItem();
        jMenu14 = new javax.swing.JMenu();
        jMenu23 = new javax.swing.JMenu();
        jMenuItem102 = new javax.swing.JMenuItem();
        jMenuItem108 = new javax.swing.JMenuItem();
        jMenu24 = new javax.swing.JMenu();
        jMenuItem109 = new javax.swing.JMenuItem();
        jMenuItem110 = new javax.swing.JMenuItem();
        jMenu25 = new javax.swing.JMenu();
        jMenuItem111 = new javax.swing.JMenuItem();
        jMenuItem112 = new javax.swing.JMenuItem();
        jMenuItem113 = new javax.swing.JMenuItem();
        jMenuItem114 = new javax.swing.JMenuItem();
        jMenuItem116 = new javax.swing.JMenuItem();
        jMenuItem115 = new javax.swing.JMenuItem();
        jMenu26 = new javax.swing.JMenu();
        jMenuItem117 = new javax.swing.JMenuItem();
        jMenuItem118 = new javax.swing.JMenuItem();
        jMenuItem119 = new javax.swing.JMenuItem();
        jMenuItem120 = new javax.swing.JMenuItem();
        jMenuItem121 = new javax.swing.JMenuItem();
        jMenuItem123 = new javax.swing.JMenuItem();
        jMenuItem124 = new javax.swing.JMenuItem();
        jMenu27 = new javax.swing.JMenu();
        jMenuItem122 = new javax.swing.JMenuItem();
        jMenuItem125 = new javax.swing.JMenuItem();
        jMenuItem126 = new javax.swing.JMenuItem();
        jMenu15 = new javax.swing.JMenu();
        jMenuItem75 = new javax.swing.JMenuItem();
        jMenuItem103 = new javax.swing.JMenuItem();
        jMenuItem104 = new javax.swing.JMenuItem();
        jMenuItem105 = new javax.swing.JMenuItem();
        jMenuItem106 = new javax.swing.JMenuItem();
        jMenu28 = new javax.swing.JMenu();
        jMenuItem107 = new javax.swing.JMenuItem();
        jMenuItem127 = new javax.swing.JMenuItem();
        jMenuItem128 = new javax.swing.JMenuItem();
        jMenuItem129 = new javax.swing.JMenuItem();
        jMenu29 = new javax.swing.JMenu();
        jMenuItem131 = new javax.swing.JMenuItem();
        jMenuItem132 = new javax.swing.JMenuItem();
        jMenuItem130 = new javax.swing.JMenuItem();
        jMenu30 = new javax.swing.JMenu();
        jMenuItem133 = new javax.swing.JMenuItem();
        jMenuItem134 = new javax.swing.JMenuItem();
        jMenuItem135 = new javax.swing.JMenuItem();
        jMenuItem136 = new javax.swing.JMenuItem();
        jMenuItem137 = new javax.swing.JMenuItem();
        jMenu31 = new javax.swing.JMenu();
        jMenuItem138 = new javax.swing.JMenuItem();
        jMenuItem139 = new javax.swing.JMenuItem();
        jMenuItem140 = new javax.swing.JMenuItem();
        jMenu32 = new javax.swing.JMenu();
        jMenuItem141 = new javax.swing.JMenuItem();
        jMenuItem142 = new javax.swing.JMenuItem();
        jMenuItem143 = new javax.swing.JMenuItem();
        jMenuItem144 = new javax.swing.JMenuItem();
        jMenuItem76 = new javax.swing.JMenuItem();
        line19 = new javax.swing.JPopupMenu.Separator();
        jMenuItem101 = new javax.swing.JMenuItem();
        jMenuItem145 = new javax.swing.JMenuItem();
        codeMenu = new javax.swing.JMenu();
        jMenuItem147 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        pluginMenu = new javax.swing.JMenu();
        jMenuItem146 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenu33 = new javax.swing.JMenu();
        jMenuItem150 = new javax.swing.JMenuItem();
        jMenuItem151 = new javax.swing.JMenuItem();
        jMenuItem152 = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem153 = new javax.swing.JMenuItem();
        jMenuItem154 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem4 = new javax.swing.JCheckBoxMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem174 = new javax.swing.JMenuItem();
        jMenuItem180 = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jMenuItem181 = new javax.swing.JMenuItem();
        jMenu13 = new javax.swing.JMenu();
        jMenuItem70 = new javax.swing.JMenuItem();
        jMenu16 = new javax.swing.JMenu();
        jMenuItem71 = new javax.swing.JMenuItem();
        jMenuItem73 = new javax.swing.JMenuItem();
        jMenuItem74 = new javax.swing.JMenuItem();
        jMenuItem72 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem62 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem31 = new javax.swing.JMenuItem();
        line5 = new javax.swing.JPopupMenu.Separator();
        jMenuItem32 = new javax.swing.JMenuItem();
        jMenuItem33 = new javax.swing.JMenuItem();
        jMenuItem34 = new javax.swing.JMenuItem();
        jMenuItem35 = new javax.swing.JMenuItem();
        jMenuItem36 = new javax.swing.JMenuItem();
        line6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem37 = new javax.swing.JMenuItem();
        jMenuItem38 = new javax.swing.JMenuItem();
        jMenuItem39 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem28 = new javax.swing.JMenuItem();
        jMenuItem27 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();

        fileChooser.setApproveButtonText("Open");
        fileChooser.setApproveButtonToolTipText("Open File To Edit");
        fileChooser.setDialogTitle("Open");
        fileChooser.setFileFilter(new MyCustomFilter());
        fileChooser.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);

        menucopy1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menucopy1.setText("Copy");
        menucopy1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menucopy1ActionPerformed(evt);
            }
        });

        menucut1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menucut1.setText("Cut");
        menucut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menucut1ActionPerformed(evt);
            }
        });

        menupaste1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        menupaste1.setText("Paste");
        menupaste1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menupaste1ActionPerformed(evt);
            }
        });

        menuclear1.setText("Clear All");
        menuclear1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuclear1ActionPerformed(evt);
            }
        });

        filesave.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        filesave.setApproveButtonText("Save");
        filesave.setApproveButtonToolTipText("Save File");
        filesave.setDialogTitle("Save");
        filesave.setFileFilter(new MyCustomFilter());
        filesave.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);

        filesaveas.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        filesaveas.setApproveButtonText("Save As");
        filesaveas.setApproveButtonToolTipText("Save As New Document Type");
        filesaveas.setDialogTitle("Save As");
        filesaveas.setFileSelectionMode(javax.swing.JFileChooser.FILES_AND_DIRECTORIES);

        jMenu9.setText("Run");

        jMenuItem40.setText("Run");
        jMenuItem40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem40ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem40);
        jMenu9.add(line7);

        jMenuItem42.setText("Launch In Default Browser");
        jMenuItem42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem42ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem42);

        jMenuItem43.setText("Launch In Mozilla Firefox");
        jMenuItem43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem43ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem43);

        jMenuItem44.setText("Launch In Chrome");
        jMenuItem44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem44ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem44);

        jMenuItem45.setText("Launch In Safari");
        jMenuItem45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem45ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem45);

        jMenuItem46.setText("Launch In Internet Explorer");
        jMenuItem46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem46ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem46);
        jMenu9.add(line8);

        jMenuItem47.setText("Google Search");
        jMenuItem47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem47ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem47);

        jMenuItem48.setText("Bing Search");
        jMenuItem48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem48ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem48);

        jMenuItem49.setText("Wikipedia Search");
        jMenuItem49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem49ActionPerformed(evt);
            }
        });
        jMenu9.add(jMenuItem49);

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem13.setText("Select All");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });

        jMenuItem50.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem50.setText("Exit");
        jMenuItem50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem50ActionPerformed(evt);
            }
        });

        jMenuItem59.setText("Search "+sel+" In Google");
        jMenuItem59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem59ActionPerformed(evt);
            }
        });

        Undo1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        Undo1.setText("Undo");
        Undo1.setEnabled(false);
        Undo1.setName("undo"); // NOI18N
        Undo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Undo1ActionPerformed(evt);
            }
        });

        redoaction1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        redoaction1.setText("Redo");
        redoaction1.setEnabled(false);
        redoaction1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoaction1ActionPerformed(evt);
            }
        });

        jPanel5.setBackground(java.awt.Color.white);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("PROJECT SELECTION MODE");

        jTabbedPane2.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jButton7.setText("New Dir/Project");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Open Dir/Project");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7)
                    .addComponent(jButton8))
                .addContainerGap())
        );

        selectDir.setDialogType(javax.swing.JFileChooser.CUSTOM_DIALOG);
        selectDir.setApproveButtonText("Select Directory");
        selectDir.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Document Map");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );

        jSlider1.setBackground(new java.awt.Color(255, 255, 255));
        jSlider1.setMaximum(20);
        jSlider1.setSnapToTicks(true);
        jSlider1.setValue(1);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                .addGap(8, 8, 8))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel500.setText("jLabel5");

        jLabel501.setText("jLabel5");

        jMenu18.setText("jMenu18");

        jButton3.setText("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("Add collapsible area");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jMenuItem61.setText("Get Selected Tree Path");
        jMenuItem61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem61ActionPerformed(evt);
            }
        });

        jMenu8.setText("Mark Selcted Text");

        jMenuItem60.setText("Using Red Color");
        jMenuItem60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem60ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem60);

        jMenuItem64.setText("Using Blue Color");
        jMenu8.add(jMenuItem64);

        jMenuItem65.setText("Using Green Color");
        jMenu8.add(jMenuItem65);

        jMenuItem67.setText("Using Yellow Color");
        jMenu8.add(jMenuItem67);

        jMenuItem66.setText("Using Purple Color");
        jMenu8.add(jMenuItem66);

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        saveStateD.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        saveStateD.setApproveButtonText("Save Current State");
        saveStateD.setApproveButtonToolTipText("Save Current State");
        saveStateD.setDialogTitle("Save Current State");

        macroChooser.setFileFilter(new FileNameExtensionFilter("Macro Files(*.xml)", "xml", "XML"));

        macroList.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("SAVED MACRO LIST");

        jList2.setModel(macroModel);
        jScrollPane1.setViewportView(jList2);

        javax.swing.GroupLayout macroListLayout = new javax.swing.GroupLayout(macroList);
        macroList.setLayout(macroListLayout);
        macroListLayout.setHorizontalGroup(
            macroListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(macroListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(macroListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                .addContainerGap())
        );
        macroListLayout.setVerticalGroup(
            macroListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(macroListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(titleText.getText());
        setLocation(new java.awt.Point(6, 6));
        setName("frame"); // NOI18N

        toolbar.setBackground(java.awt.Color.white);

        jToolBar1.setBackground(java.awt.Color.white);
        jToolBar1.setRollover(true);

        TnewFile.setBackground(java.awt.Color.white);
        TnewFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/power/text/images/new.gif"))); // NOI18N
        TnewFile.setToolTipText("New File");
        TnewFile.setFocusable(false);
        TnewFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TnewFile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        TnewFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TnewFileActionPerformed(evt);
            }
        });
        jToolBar1.add(TnewFile);

        TopenFile.setBackground(java.awt.Color.white);
        TopenFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/power/text/images/open.gif"))); // NOI18N
        TopenFile.setToolTipText("Open");
        TopenFile.setFocusable(false);
        TopenFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TopenFile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        TopenFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TopenFileActionPerformed(evt);
            }
        });
        jToolBar1.add(TopenFile);

        TsaveFile.setBackground(java.awt.Color.white);
        TsaveFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/power/text/images/save.gif"))); // NOI18N
        TsaveFile.setToolTipText("Save");
        TsaveFile.setFocusable(false);
        TsaveFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TsaveFile.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        TsaveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TsaveFileActionPerformed(evt);
            }
        });
        jToolBar1.add(TsaveFile);

        TsaveFile1.setBackground(java.awt.Color.white);
        TsaveFile1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/power/text/images/saveall.gif"))); // NOI18N
        TsaveFile1.setToolTipText("Save All");
        TsaveFile1.setFocusable(false);
        TsaveFile1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TsaveFile1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        TsaveFile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TsaveFile1ActionPerformed(evt);
            }
        });
        jToolBar1.add(TsaveFile1);

        Tprint.setBackground(java.awt.Color.white);
        Tprint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/power/text/images/Printer-icon.png"))); // NOI18N
        Tprint.setToolTipText("Print");
        Tprint.setFocusable(false);
        Tprint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Tprint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Tprint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TprintActionPerformed(evt);
            }
        });
        jToolBar1.add(Tprint);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/power/text/images/rename.png"))); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.lightGray);
        jLabel1.setText("|");
        jToolBar1.add(jLabel1);

        Tcopy.setBackground(java.awt.Color.white);
        Tcopy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/power/text/images/copy.gif"))); // NOI18N
        Tcopy.setToolTipText("Copy");
        Tcopy.setFocusable(false);
        Tcopy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Tcopy.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Tcopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TcopyActionPerformed(evt);
            }
        });
        jToolBar1.add(Tcopy);

        Tcut.setBackground(java.awt.Color.white);
        Tcut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/power/text/images/cut.gif"))); // NOI18N
        Tcut.setToolTipText("Cut");
        Tcut.setFocusable(false);
        Tcut.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Tcut.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Tcut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TcutActionPerformed(evt);
            }
        });
        jToolBar1.add(Tcut);

        Tpaste.setBackground(java.awt.Color.white);
        Tpaste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/power/text/images/paste.gif"))); // NOI18N
        Tpaste.setToolTipText("Paste");
        Tpaste.setFocusable(false);
        Tpaste.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Tpaste.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Tpaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TpasteActionPerformed(evt);
            }
        });
        jToolBar1.add(Tpaste);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setForeground(java.awt.Color.lightGray);
        jLabel2.setText("|");
        jToolBar1.add(jLabel2);

        Tif.setBackground(java.awt.Color.white);
        Tif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/power/text/images/Editing-Increase-Font-icon.png"))); // NOI18N
        Tif.setToolTipText("Increase Font");
        Tif.setFocusable(false);
        Tif.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Tif.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Tif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TifActionPerformed(evt);
            }
        });
        jToolBar1.add(Tif);

        Tsf.setBackground(java.awt.Color.white);
        Tsf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/power/text/images/Apps-preferences-desktop-font-icon.png"))); // NOI18N
        Tsf.setToolTipText("Setup Font");
        Tsf.setFocusable(false);
        Tsf.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Tsf.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Tsf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TsfActionPerformed(evt);
            }
        });
        jToolBar1.add(Tsf);

        Tdf.setBackground(java.awt.Color.white);
        Tdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/power/text/images/Editing-Decrease-Font-icon.png"))); // NOI18N
        Tdf.setToolTipText("Decrease Font");
        Tdf.setFocusable(false);
        Tdf.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Tdf.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Tdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TdfActionPerformed(evt);
            }
        });
        jToolBar1.add(Tdf);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setForeground(java.awt.Color.lightGray);
        jLabel3.setText("|");
        jToolBar1.add(jLabel3);

        Tundo.setBackground(java.awt.Color.white);
        Tundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/power/text/images/Actions-edit-undo-icon.png"))); // NOI18N
        Tundo.setToolTipText("Undo");
        Tundo.setFocusable(false);
        Tundo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Tundo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(Tundo);

        Tredo.setBackground(java.awt.Color.white);
        Tredo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/power/text/images/redo.png"))); // NOI18N
        Tredo.setToolTipText("Redo");
        Tredo.setFocusable(false);
        Tredo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Tredo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(Tredo);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setForeground(java.awt.Color.lightGray);
        jLabel4.setText("|");
        jToolBar1.add(jLabel4);

        editoronly.setBackground(java.awt.Color.white);
        editoronly.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/power/text/images/Apps-accessories-text-editor-icon.png"))); // NOI18N
        editoronly.setToolTipText("Editor Only");
        editoronly.setFocusable(false);
        editoronly.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editoronly.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        editoronly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editoronlyActionPerformed(evt);
            }
        });
        jToolBar1.add(editoronly);

        searchbox.setToolTipText("Search CTRL + SHIFT S");
        searchbox.setDoubleBuffered(true);
        searchbox.setDragEnabled(true);

        searchbutton.setText("...");
        searchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbuttonActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("X");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout toolbarLayout = new javax.swing.GroupLayout(toolbar);
        toolbar.setLayout(toolbarLayout);
        toolbarLayout.setHorizontalGroup(
            toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolbarLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        toolbarLayout.setVerticalGroup(
            toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(toolbarLayout.createSequentialGroup()
                .addGroup(toolbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(toolbarLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(searchbox))
                    .addComponent(searchbutton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        statusPanel.setBackground(java.awt.Color.white);

        statusPanel1.setBackground(java.awt.Color.white);

        statusLabel.setBackground(java.awt.Color.white);
        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusLabel.setText("Selection : ");

        notification.setBackground(new java.awt.Color(255, 255, 255));
        notification.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        notification.setText(".");

        cal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cal.setText("Line:   Column: ");

        Totalsel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Totalsel.setText("Caret Position: ");
        Totalsel.setMinimumSize(new java.awt.Dimension(10, 14));

        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLabel.setText("00/00/0000");

        timeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timeLabel.setText("00:00:00");

        fileext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fileext.setText("Plain Text");

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("UTF-8");

        osEncoding.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        osEncoding.setText(" ");

        javax.swing.GroupLayout statusPanel1Layout = new javax.swing.GroupLayout(statusPanel1);
        statusPanel1.setLayout(statusPanel1Layout);
        statusPanel1Layout.setHorizontalGroup(
            statusPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fileext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Totalsel, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(cal, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(notification)
                .addGap(10, 10, 10)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(osEncoding, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        statusPanel1Layout.setVerticalGroup(
            statusPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, statusPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(statusPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statusPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dateLabel)
                        .addComponent(timeLabel)
                        .addComponent(jLabel16)
                        .addComponent(osEncoding))
                    .addGroup(statusPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(notification)
                        .addComponent(cal)
                        .addComponent(Totalsel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(statusLabel)
                        .addComponent(fileext, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setText("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaccccccccccccccccccccccccccccccccaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaccccccccccccccccccccccccccccccccaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaccccccccccccccccccccccccccccccccaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaccccccccccccccccccccccccccccccccaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaacccccccccccccccccccccccccccccccc");
        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8))
        );

        jSplitPane1.setBackground(new java.awt.Color(255, 255, 255));
        jSplitPane1.setBorder(null);
        jSplitPane1.setDividerLocation(400);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setMinimumSize(new java.awt.Dimension(627, 47));
        jPanel10.setLayout(new java.awt.CardLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Find  :");

        jButton4.setText("Previous");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setText("Next");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel10.setText("No Matches");

        jToggleButton1.setText("Aa");

        jToggleButton2.setText("\" \"");

        jToggleButton3.setText("Regex");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(incresearch, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(incresearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(jButton6)
                    .addComponent(jLabel10)
                    .addComponent(jToggleButton1)
                    .addComponent(jToggleButton2)
                    .addComponent(jToggleButton3))
                .addContainerGap())
        );

        jPanel10.add(jPanel4, "card2");

        jSplitPane1.setBottomComponent(jPanel10);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setName(""); // NOI18N
        jTabbedPane1.setOpaque(true);

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));
        jPanel3.setLayout(new java.awt.CardLayout());

        jPanel6.setBackground(java.awt.Color.white);
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jList1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jList1.setModel(listModel);
        jScrollPane4.setViewportView(jList1);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Document Selector");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel6, "card2");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.CardLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton9.setText("Clear Clipboard History");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jList3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jList3.setModel(copylistModel);
        jScrollPane3.setViewportView(jList3);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("When You Click An Item It is Copied To Clipboard");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Clipboard History");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(8, 8, 8))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addContainerGap())
        );

        jPanel1.add(jPanel7, "card2");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jSplitPane1.setLeftComponent(jPanel11);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(null);
        jMenuBar1.setBorderPainted(false);

        menuItem.setText("File");
        menuItem.setAutoscrolls(true);

        jMenuItem82.setText("New");
        jMenuItem82.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem82ActionPerformed(evt);
            }
        });
        menuItem.add(jMenuItem82);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("New Disposable");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuItem.add(jMenuItem2);

        jMenu20.setText("Open Parent Folder");

        jMenuItem86.setText("Windows Explorer");
        jMenuItem86.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem86ActionPerformed(evt);
            }
        });
        jMenu20.add(jMenuItem86);

        jMenuItem87.setText("Command Prompt");
        jMenuItem87.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem87ActionPerformed(evt);
            }
        });
        jMenu20.add(jMenuItem87);

        menuItem.add(jMenu20);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Open");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuItem.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Save");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuItem.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Save As");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menuItem.add(jMenuItem5);

        jMenuItem88.setText("Save A Copy As");
        jMenuItem88.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem88ActionPerformed(evt);
            }
        });
        menuItem.add(jMenuItem88);

        jMenuItem89.setText("Save All");
        jMenuItem89.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem89ActionPerformed(evt);
            }
        });
        menuItem.add(jMenuItem89);

        jMenuItem69.setText("Rename");
        jMenuItem69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem69ActionPerformed(evt);
            }
        });
        menuItem.add(jMenuItem69);

        jMenuItem68.setText("Delete File");
        jMenuItem68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem68ActionPerformed(evt);
            }
        });
        menuItem.add(jMenuItem68);
        menuItem.add(line17);

        jMenuItem90.setText("Load Saved State");
        jMenuItem90.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem90ActionPerformed(evt);
            }
        });
        menuItem.add(jMenuItem90);

        jMenuItem91.setText("Save Current State");
        jMenuItem91.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem91ActionPerformed(evt);
            }
        });
        menuItem.add(jMenuItem91);
        menuItem.add(line3);

        jMenuItem26.setText("Page Setup");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        menuItem.add(jMenuItem26);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem11.setText("Print");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        menuItem.add(jMenuItem11);
        menuItem.add(line15);

        jMenuItem85.setText("Restore Currently Closed File");
        jMenuItem85.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem85ActionPerformed(evt);
            }
        });
        menuItem.add(jMenuItem85);

        jMenuItem83.setText("Open All Recent Files");
        jMenuItem83.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem83ActionPerformed(evt);
            }
        });
        menuItem.add(jMenuItem83);

        jMenuItem84.setText("Clear Recent Files List");
        jMenuItem84.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem84ActionPerformed(evt);
            }
        });
        menuItem.add(jMenuItem84);
        menuItem.add(line16);

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem15.setText("Exit");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        menuItem.add(jMenuItem15);
        menuItem.add(line18);

        jMenuBar1.add(menuItem);

        jMenu19.setText("Project");

        jMenuItem63.setText("New Project");
        jMenuItem63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem63ActionPerformed(evt);
            }
        });
        jMenu19.add(jMenuItem63);

        jMenuItem77.setText("Open Project");
        jMenuItem77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem77ActionPerformed(evt);
            }
        });
        jMenu19.add(jMenuItem77);
        jMenu19.add(line13);

        jMenuItem78.setText("New File In Project");
        jMenuItem78.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem78ActionPerformed(evt);
            }
        });
        jMenu19.add(jMenuItem78);

        jMenuItem79.setText("Delete File In Project");
        jMenuItem79.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem79ActionPerformed(evt);
            }
        });
        jMenu19.add(jMenuItem79);
        jMenu19.add(line14);

        jMenuItem80.setText("Close Project");
        jMenu19.add(jMenuItem80);

        jMenuItem81.setText("Delete Project");
        jMenu19.add(jMenuItem81);

        jMenuBar1.add(jMenu19);

        jMenu2.setText("Edit");
        jMenu2.setDoubleBuffered(true);

        Undo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        Undo.setText("Undo");
        Undo.setName("undo"); // NOI18N
        Undo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UndoActionPerformed(evt);
            }
        });
        jMenu2.add(Undo);

        redo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Y, java.awt.event.InputEvent.CTRL_MASK));
        redo.setText("Redo");
        jMenu2.add(redo);
        jMenu2.add(line1);

        menucut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        menucut.setText("Cut");
        menucut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menucutActionPerformed(evt);
            }
        });
        jMenu2.add(menucut);

        menucopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        menucopy.setText("Copy");
        menucopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menucopyActionPerformed(evt);
            }
        });
        jMenu2.add(menucopy);

        menupaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        menupaste.setText("Paste");
        menupaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menupasteActionPerformed(evt);
            }
        });
        jMenu2.add(menupaste);

        menuclear.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_BACK_SPACE, java.awt.event.InputEvent.CTRL_MASK));
        menuclear.setText("Clear All");
        menuclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuclearActionPerformed(evt);
            }
        });
        jMenu2.add(menuclear);

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem12.setText("Select All");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem12);

        jMenuItem18.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem18.setText("Delete Selected");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem18);
        jMenu2.add(line9);

        jMenuItem176.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem176.setText("Copy As Rich Text Format");
        jMenuItem176.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem176ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem176);

        jMenu11.setText("Indent");

        jMenuItem55.setText("Increase Indent");
        jMenuItem55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem55ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem55);

        jMenuItem56.setText("Decrease Indent");
        jMenuItem56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem56ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem56);
        jMenu11.add(jSeparator9);

        jMenuItem158.setText("Increase Current Line Indent");
        jMenuItem158.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem158ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem158);

        jMenuItem159.setText("Decrease Current Line Indent");
        jMenuItem159.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem159ActionPerformed(evt);
            }
        });
        jMenu11.add(jMenuItem159);

        jMenu2.add(jMenu11);

        jMenu10.setText("Copy To Clipboard");

        jMenuItem51.setText("Copy Filename To Clipboard");
        jMenuItem51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem51ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem51);

        jMenuItem52.setText("Copy Full File Path To Clipboard");
        jMenuItem52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem52ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem52);

        jMenuItem53.setText("Copy File Extension To Clipboard");
        jMenuItem53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem53ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem53);

        jMenuItem54.setText("Copy File Summary To Clipboard");
        jMenuItem54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem54ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem54);

        jMenu2.add(jMenu10);

        jMenu12.setText("Change Case To");

        jMenuItem57.setText("lowercase");
        jMenuItem57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem57ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem57);

        jMenuItem58.setText("UPPERCASE");
        jMenuItem58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem58ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem58);

        jMenuItem157.setText("Invert Case");
        jMenuItem157.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem157ActionPerformed(evt);
            }
        });
        jMenu12.add(jMenuItem157);

        jMenu2.add(jMenu12);

        jMenu22.setText("Comment And Uncomment");

        jMenuItem97.setText("Comment Current Line");
        jMenuItem97.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem97ActionPerformed(evt);
            }
        });
        jMenu22.add(jMenuItem97);

        jMenuItem98.setText("Uncomment Current Line");
        jMenuItem98.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem98ActionPerformed(evt);
            }
        });
        jMenu22.add(jMenuItem98);

        jMenuItem99.setText("Multi Comment Current Line");
        jMenuItem99.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem99ActionPerformed(evt);
            }
        });
        jMenu22.add(jMenuItem99);

        jMenuItem100.setText("Uncomment Multi Comment Line");
        jMenuItem100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem100ActionPerformed(evt);
            }
        });
        jMenu22.add(jMenuItem100);

        jMenu2.add(jMenu22);

        jMenu21.setText("Line Operations");

        jMenuItem93.setText("Split Lines");
        jMenuItem93.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem93ActionPerformed(evt);
            }
        });
        jMenu21.add(jMenuItem93);

        jMenuItem92.setText("Join Lines");
        jMenuItem92.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem92ActionPerformed(evt);
            }
        });
        jMenu21.add(jMenuItem92);

        jMenuItem175.setText("Delete Current Line");
        jMenuItem175.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem175ActionPerformed(evt);
            }
        });
        jMenu21.add(jMenuItem175);

        jMenuItem94.setText("Move Current Line Up");
        jMenuItem94.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem94ActionPerformed(evt);
            }
        });
        jMenu21.add(jMenuItem94);

        jMenuItem177.setText("Move Current Line Down");
        jMenuItem177.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem177ActionPerformed(evt);
            }
        });
        jMenu21.add(jMenuItem177);
        jMenu21.add(jSeparator8);

        jMenuItem95.setText("Insert Empty Line Above Current Line");
        jMenuItem95.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem95ActionPerformed(evt);
            }
        });
        jMenu21.add(jMenuItem95);

        jMenuItem96.setText("Insert Empty Line Below Current Line");
        jMenuItem96.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem96ActionPerformed(evt);
            }
        });
        jMenu21.add(jMenuItem96);

        jMenu2.add(jMenu21);

        jMenu34.setText("Blank Space Operations");

        jMenuItem155.setText("Convert Tabs To Space");
        jMenuItem155.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem155ActionPerformed(evt);
            }
        });
        jMenu34.add(jMenuItem155);

        jMenuItem156.setText("Convert Space To Tab");
        jMenuItem156.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem156ActionPerformed(evt);
            }
        });
        jMenu34.add(jMenuItem156);

        jMenu2.add(jMenu34);
        jMenu2.add(line10);

        editableMI.setText("Not Editable");
        editableMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editableMIActionPerformed(evt);
            }
        });
        jMenu2.add(editableMI);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Actions");

        jMenuItem29.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem29.setText("Find Next Text");
        jMenuItem29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem29ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem29);

        jMenuItem30.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem30.setText("Find Previous Text");
        jMenuItem30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem30ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem30);

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem14.setText("Find Word");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem14);

        jMenuItem16.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem16.setText("Replace");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem16);

        jMenuItem19.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem19.setText("Find/Replace");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem19);

        jCheckBoxMenuItem1.setText("Continous Word Search");
        jCheckBoxMenuItem1.setEnabled(false);
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu4.add(jCheckBoxMenuItem1);
        jMenu4.add(line2);

        jMenuItem41.setText("Summary");
        jMenuItem41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem41ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem41);

        jMenuItem17.setText("Go To Line");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem17);

        jMenuItem172.setText("Clipboard History");
        jMenuItem172.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem172ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem172);

        jMenu7.setText("Font");

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText("Setup Font");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem7);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_UP, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem8.setText("Zoom In");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem8);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DOWN, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setText("Zoom Out");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem9);

        jMenu4.add(jMenu7);
        jMenu4.add(line11);

        jMenu35.setText("HighLight Current Line Using");

        jMenuItem160.setText("First Colour (RED)");
        jMenuItem160.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem160ActionPerformed(evt);
            }
        });
        jMenu35.add(jMenuItem160);

        jMenuItem161.setText("Second Color (BLUE)");
        jMenuItem161.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem161ActionPerformed(evt);
            }
        });
        jMenu35.add(jMenuItem161);

        jMenuItem162.setText("Third Colour (YELLOW)");
        jMenuItem162.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem162ActionPerformed(evt);
            }
        });
        jMenu35.add(jMenuItem162);

        jMenuItem163.setText("Forth Colour (GREEN)");
        jMenuItem163.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem163ActionPerformed(evt);
            }
        });
        jMenu35.add(jMenuItem163);

        jMenuItem164.setText("Fifth Colour (CUSTOM COLOR)");
        jMenuItem164.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem164ActionPerformed(evt);
            }
        });
        jMenu35.add(jMenuItem164);

        jMenu4.add(jMenu35);

        jMenu36.setText("Remove Line Highlight");

        jMenuItem171.setText("Current Line Highlight");
        jMenuItem171.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem171ActionPerformed(evt);
            }
        });
        jMenu36.add(jMenuItem171);

        jMenuItem165.setText("First Colour (RED)");
        jMenuItem165.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem165ActionPerformed(evt);
            }
        });
        jMenu36.add(jMenuItem165);

        jMenuItem166.setText("Second Color (BLUE)");
        jMenuItem166.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem166ActionPerformed(evt);
            }
        });
        jMenu36.add(jMenuItem166);

        jMenuItem167.setText("Third Colour (YELLOW)");
        jMenuItem167.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem167ActionPerformed(evt);
            }
        });
        jMenu36.add(jMenuItem167);

        jMenuItem168.setText("Forth Colour (GREEN)");
        jMenuItem168.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem168ActionPerformed(evt);
            }
        });
        jMenu36.add(jMenuItem168);

        jMenuItem169.setText("Fifth Colour (CUSTOM COLOR)");
        jMenuItem169.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem169ActionPerformed(evt);
            }
        });
        jMenu36.add(jMenuItem169);

        jMenuItem170.setText("Clear All Line Highlight");
        jMenuItem170.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem170ActionPerformed(evt);
            }
        });
        jMenu36.add(jMenuItem170);

        jMenu4.add(jMenu36);
        jMenu4.add(jSeparator7);

        jMenuItem178.setText("Next Bookmark");
        jMenuItem178.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem178ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem178);

        jMenuItem179.setText("Previous Bookmark");
        jMenuItem179.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem179ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem179);

        jMenuItem173.setText("Bookmark/UnBookmark Current Line");
        jMenuItem173.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem173ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem173);

        jMenuBar1.add(jMenu4);

        jMenu1.setText("View");

        toggletoolbar.setSelected(true);
        toggletoolbar.setText("ToolBar");
        toggletoolbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggletoolbarActionPerformed(evt);
            }
        });
        jMenu1.add(toggletoolbar);

        togglesearch.setSelected(true);
        togglesearch.setText("Search Box");
        togglesearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                togglesearchActionPerformed(evt);
            }
        });
        jMenu1.add(togglesearch);
        jMenu1.add(line4);

        docuselector.setText("Document Selector");
        docuselector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docuselectorActionPerformed(evt);
            }
        });
        jMenu1.add(docuselector);

        jCheckBoxMenuItem2.setText("Project Mode");
        jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jCheckBoxMenuItem2);

        jCheckBoxMenuItem3.setText("Document Map");
        jCheckBoxMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jCheckBoxMenuItem3);

        cliphist.setText("Clipboard History");
        cliphist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cliphistActionPerformed(evt);
            }
        });
        jMenu1.add(cliphist);

        jMenuItem149.setText("Line Wrap");
        jMenuItem149.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem149ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem149);
        jMenu1.add(line12);

        toglestatuspanel.setSelected(true);
        toglestatuspanel.setText("Status Panel");
        toglestatuspanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toglestatuspanelActionPerformed(evt);
            }
        });
        jMenu1.add(toglestatuspanel);

        jMenu17.setText("Status Panel Component");

        togglecaretpos.setSelected(true);
        togglecaretpos.setText("Caret Position");
        togglecaretpos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                togglecaretposActionPerformed(evt);
            }
        });
        jMenu17.add(togglecaretpos);

        toggletimeelapsed.setSelected(true);
        toggletimeelapsed.setText("Time Elapsed");
        toggletimeelapsed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toggletimeelapsedActionPerformed(evt);
            }
        });
        jMenu17.add(toggletimeelapsed);

        toglecal.setSelected(true);
        toglecal.setText("Column And LIne");
        toglecal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toglecalActionPerformed(evt);
            }
        });
        jMenu17.add(toglecal);

        togleselection.setSelected(true);
        togleselection.setText("Selection");
        togleselection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                togleselectionActionPerformed(evt);
            }
        });
        jMenu17.add(togleselection);

        togledate.setSelected(true);
        togledate.setText("Date");
        togledate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                togledateActionPerformed(evt);
            }
        });
        jMenu17.add(togledate);

        togletime.setSelected(true);
        togletime.setText("Time");
        togletime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                togletimeActionPerformed(evt);
            }
        });
        jMenu17.add(togletime);

        jMenu1.add(jMenu17);
        jMenu1.add(jSeparator5);

        jCheckBoxMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F11, 0));
        jCheckBoxMenuItem5.setText("Full Screen");
        jCheckBoxMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jCheckBoxMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu14.setText("Syntax");

        jMenu23.setText("A");

        jMenuItem102.setText("Action Script");
        jMenuItem102.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem102ActionPerformed(evt);
            }
        });
        jMenu23.add(jMenuItem102);

        jMenuItem108.setText("Assembly");
        jMenuItem108.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem108ActionPerformed(evt);
            }
        });
        jMenu23.add(jMenuItem108);

        jMenu14.add(jMenu23);

        jMenu24.setText("B");

        jMenuItem109.setText("BBCode");
        jMenuItem109.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem109ActionPerformed(evt);
            }
        });
        jMenu24.add(jMenuItem109);

        jMenuItem110.setText("Batch");
        jMenuItem110.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem110ActionPerformed(evt);
            }
        });
        jMenu24.add(jMenuItem110);

        jMenu14.add(jMenu24);

        jMenu25.setText("C");

        jMenuItem111.setText("C");
        jMenuItem111.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem111ActionPerformed(evt);
            }
        });
        jMenu25.add(jMenuItem111);

        jMenuItem112.setText("C++");
        jMenuItem112.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem112ActionPerformed(evt);
            }
        });
        jMenu25.add(jMenuItem112);

        jMenuItem113.setText("C#");
        jMenuItem113.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem113ActionPerformed(evt);
            }
        });
        jMenu25.add(jMenuItem113);

        jMenuItem114.setText("Clojure");
        jMenuItem114.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem114ActionPerformed(evt);
            }
        });
        jMenu25.add(jMenuItem114);

        jMenuItem116.setText("CMake");
        jMenuItem116.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem116ActionPerformed(evt);
            }
        });
        jMenu25.add(jMenuItem116);

        jMenuItem115.setText("CSS");
        jMenuItem115.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem115ActionPerformed(evt);
            }
        });
        jMenu25.add(jMenuItem115);

        jMenu14.add(jMenu25);

        jMenu26.setText("D");

        jMenuItem117.setText("D");
        jMenuItem117.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem117ActionPerformed(evt);
            }
        });
        jMenu26.add(jMenuItem117);

        jMenuItem118.setText("Docker");
        jMenuItem118.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem118ActionPerformed(evt);
            }
        });
        jMenu26.add(jMenuItem118);

        jMenuItem119.setText("Dart");
        jMenuItem119.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem119ActionPerformed(evt);
            }
        });
        jMenu26.add(jMenuItem119);

        jMenuItem120.setText("Delphi");
        jMenuItem120.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem120ActionPerformed(evt);
            }
        });
        jMenu26.add(jMenuItem120);

        jMenuItem121.setText("DTD");
        jMenuItem121.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem121ActionPerformed(evt);
            }
        });
        jMenu26.add(jMenuItem121);

        jMenu14.add(jMenu26);

        jMenuItem123.setText("Fortran");
        jMenuItem123.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem123ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem123);

        jMenuItem124.setText("Groovy");
        jMenuItem124.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem124ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem124);

        jMenu27.setText("H");

        jMenuItem122.setText("Hosts");
        jMenuItem122.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem122ActionPerformed(evt);
            }
        });
        jMenu27.add(jMenuItem122);

        jMenuItem125.setText("Htaccess");
        jMenuItem125.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem125ActionPerformed(evt);
            }
        });
        jMenu27.add(jMenuItem125);

        jMenuItem126.setText("HTML");
        jMenuItem126.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem126ActionPerformed(evt);
            }
        });
        jMenu27.add(jMenuItem126);

        jMenu14.add(jMenu27);

        jMenu15.setText("J");

        jMenuItem75.setText("Java");
        jMenuItem75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem75ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem75);

        jMenuItem103.setText("JavaScript");
        jMenuItem103.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem103ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem103);

        jMenuItem104.setText("JSON");
        jMenuItem104.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem104ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem104);

        jMenuItem105.setText("JSON with Comment");
        jMenuItem105.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem105ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem105);

        jMenuItem106.setText("JSP");
        jMenuItem106.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem106ActionPerformed(evt);
            }
        });
        jMenu15.add(jMenuItem106);

        jMenu14.add(jMenu15);

        jMenu28.setText("L");

        jMenuItem107.setText("LaTex");
        jMenuItem107.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem107ActionPerformed(evt);
            }
        });
        jMenu28.add(jMenuItem107);

        jMenuItem127.setText("Less");
        jMenuItem127.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem127ActionPerformed(evt);
            }
        });
        jMenu28.add(jMenuItem127);

        jMenuItem128.setText("LISP");
        jMenuItem128.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem128ActionPerformed(evt);
            }
        });
        jMenu28.add(jMenuItem128);

        jMenuItem129.setText("LUA");
        jMenuItem129.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem129ActionPerformed(evt);
            }
        });
        jMenu28.add(jMenuItem129);

        jMenu14.add(jMenu28);

        jMenu29.setText("M");

        jMenuItem131.setText("Make File");
        jMenuItem131.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem131ActionPerformed(evt);
            }
        });
        jMenu29.add(jMenuItem131);

        jMenuItem132.setText("MXML");
        jMenuItem132.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem132ActionPerformed(evt);
            }
        });
        jMenu29.add(jMenuItem132);

        jMenu14.add(jMenu29);

        jMenuItem130.setText("NSIS");
        jMenuItem130.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem130ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem130);

        jMenu30.setText("P");

        jMenuItem133.setText("PERL");
        jMenuItem133.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem133ActionPerformed(evt);
            }
        });
        jMenu30.add(jMenuItem133);

        jMenuItem134.setText("PHP");
        jMenuItem134.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem134ActionPerformed(evt);
            }
        });
        jMenu30.add(jMenuItem134);

        jMenuItem135.setText("Properties File");
        jMenuItem135.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem135ActionPerformed(evt);
            }
        });
        jMenu30.add(jMenuItem135);

        jMenuItem136.setText("Python");
        jMenuItem136.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem136ActionPerformed(evt);
            }
        });
        jMenu30.add(jMenuItem136);

        jMenu14.add(jMenu30);

        jMenuItem137.setText("Ruby");
        jMenuItem137.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem137ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem137);

        jMenu31.setText("S");

        jMenuItem138.setText("SAS");
        jMenuItem138.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem138ActionPerformed(evt);
            }
        });
        jMenu31.add(jMenuItem138);

        jMenuItem139.setText("Scala");
        jMenuItem139.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem139ActionPerformed(evt);
            }
        });
        jMenu31.add(jMenuItem139);

        jMenuItem140.setText("SQL");
        jMenuItem140.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem140ActionPerformed(evt);
            }
        });
        jMenu31.add(jMenuItem140);

        jMenu14.add(jMenu31);

        jMenu32.setText("T");

        jMenuItem141.setText("TCL");
        jMenuItem141.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem141ActionPerformed(evt);
            }
        });
        jMenu32.add(jMenuItem141);

        jMenuItem142.setText("Type Script");
        jMenuItem142.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem142ActionPerformed(evt);
            }
        });
        jMenu32.add(jMenuItem142);

        jMenu14.add(jMenu32);

        jMenuItem143.setText("Unix Shell");
        jMenuItem143.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem143ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem143);

        jMenuItem144.setText("Visual Basic");
        jMenuItem144.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem144ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem144);

        jMenuItem76.setText("XML");
        jMenuItem76.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem76ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem76);
        jMenu14.add(line19);

        jMenuItem101.setText("Plain Text");
        jMenuItem101.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem101ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem101);

        jMenuItem145.setText("Default Syntax");
        jMenuItem145.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem145ActionPerformed(evt);
            }
        });
        jMenu14.add(jMenuItem145);

        jMenuBar1.add(jMenu14);

        codeMenu.setText("Code");

        jMenuItem147.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem147.setText("Console");
        jMenuItem147.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem147ActionPerformed(evt);
            }
        });
        codeMenu.add(jMenuItem147);
        codeMenu.add(jSeparator4);

        jMenuBar1.add(codeMenu);

        pluginMenu.setText("Plugin");

        jMenuItem146.setText("Plugin Manager");
        jMenuItem146.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem146ActionPerformed(evt);
            }
        });
        pluginMenu.add(jMenuItem146);
        pluginMenu.add(jSeparator3);

        jMenuBar1.add(pluginMenu);

        jMenu33.setText("Macro");

        jMenuItem150.setText("Start Macro");
        jMenuItem150.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem150ActionPerformed(evt);
            }
        });
        jMenu33.add(jMenuItem150);

        jMenuItem151.setText("Stop Macro");
        jMenuItem151.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem151ActionPerformed(evt);
            }
        });
        jMenu33.add(jMenuItem151);

        jMenuItem152.setText("Play Macro");
        jMenuItem152.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem152ActionPerformed(evt);
            }
        });
        jMenu33.add(jMenuItem152);
        jMenu33.add(jSeparator6);

        jMenuItem153.setText("Load Macro From File");
        jMenuItem153.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem153ActionPerformed(evt);
            }
        });
        jMenu33.add(jMenuItem153);

        jMenuItem154.setText("Save Current Macro");
        jMenuItem154.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem154ActionPerformed(evt);
            }
        });
        jMenu33.add(jMenuItem154);

        jCheckBoxMenuItem4.setText("Saved Macro List");
        jCheckBoxMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem4ActionPerformed(evt);
            }
        });
        jMenu33.add(jCheckBoxMenuItem4);

        jMenuBar1.add(jMenu33);

        jMenu6.setText("Themes");

        jMenuItem6.setText("Theme Manager");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem6);
        jMenu6.add(jSeparator10);

        jMenuItem10.setText("Sleek Black");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem10);

        jMenuItem22.setText("Dark Feeling ");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem22);

        jMenuItem23.setText("Cool Dark");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem23);

        jMenuItem24.setText("Cool Light");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem24);

        jMenuItem25.setText("Lunar Eclipse");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem25);

        jMenuItem1.setText("Think Theme Think");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem1);

        jMenuItem174.setText("Monokai");
        jMenuItem174.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem174ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem174);

        jMenuItem180.setText("Pink Print");
        jMenuItem180.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem180ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem180);
        jMenu6.add(jSeparator11);

        jMenuItem181.setText("Default Theme");
        jMenuItem181.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem181ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem181);

        jMenuBar1.add(jMenu6);

        jMenu13.setText("Windows");

        jMenuItem70.setText("Close Current Document");
        jMenuItem70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem70ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem70);

        jMenu16.setText("Close All ......");

        jMenuItem71.setText("Close All But Active Ducument");
        jMenuItem71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem71ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem71);

        jMenuItem73.setText("Close All To Left");
        jMenuItem73.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem73ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem73);

        jMenuItem74.setText("Close All To Right");
        jMenuItem74.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem74ActionPerformed(evt);
            }
        });
        jMenu16.add(jMenuItem74);

        jMenu13.add(jMenu16);

        jMenuItem72.setText("Close All Documents");
        jMenuItem72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem72ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem72);
        jMenu13.add(jSeparator1);

        jMenuItem62.setText("View All Documents");
        jMenuItem62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem62ActionPerformed(evt);
            }
        });
        jMenu13.add(jMenuItem62);

        jMenuBar1.add(jMenu13);

        jMenu3.setText("Run");

        jMenuItem31.setText("Run");
        jMenuItem31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem31ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem31);
        jMenu3.add(line5);

        jMenuItem32.setText("Launch In Default Application");
        jMenuItem32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem32ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem32);

        jMenuItem33.setText("Launch In Mozilla Firefox");
        jMenuItem33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem33ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem33);

        jMenuItem34.setText("Launch In Chrome");
        jMenuItem34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem34ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem34);

        jMenuItem35.setText("Launch In Safari");
        jMenuItem35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem35ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem35);

        jMenuItem36.setText("Launch In Internet Explorer");
        jMenuItem36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem36ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem36);
        jMenu3.add(line6);

        jMenuItem37.setText("Google Search");
        jMenuItem37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem37ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem37);

        jMenuItem38.setText("Bing Search");
        jMenuItem38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem38ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem38);

        jMenuItem39.setText("Wikipedia Search");
        jMenuItem39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem39ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem39);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("More..");

        jMenuItem20.setText("PowerText Homepage");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem20);

        jMenuItem28.setText("PowerText Download Page");
        jMenuItem28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem28ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem28);

        jMenuItem27.setText("PowerText Community (forum)");
        jMenuItem27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem27ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem27);

        jMenuItem21.setText("About");
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem21);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(statusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
   
        String file = null;
	String fileN;
        int fontSize = 12 ;
        public int sum = 0;
       
	
	public static boolean opened = false;
	UndoManager _undoManager = new UndoManager();
        JTextArea display1 = new JTextArea();
  
    private void menucopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menucopyActionPerformed
        Copy(jTabbedPane1.getSelectedIndex());
    }//GEN-LAST:event_menucopyActionPerformed
    
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        int status = fileChooser.showOpenDialog(rootPane); fileChooser.setCurrentDirectory(new File(Editor.get(jTabbedPane1.getSelectedIndex()).getParentFolder()));
        if (status == JFileChooser.APPROVE_OPTION) {
            try {
                File files = fileChooser.getSelectedFile();
                Scanner scn = new Scanner(new FileInputStream(files));
                openFile(files, scn); addRecent(files.getAbsolutePath());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("No file selected");
        }
    
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        newFile("Untitled " + count + ".txt", "Untitled " + count, "Untitled " + count, "", "Unknown File", "file");
        
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        saveFile(jTabbedPane1.getSelectedIndex());
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void menucutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menucutActionPerformed
        Cut();
    }//GEN-LAST:event_menucutActionPerformed

    private void menupasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menupasteActionPerformed
        Paste();
    }//GEN-LAST:event_menupasteActionPerformed

    private void menuclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuclearActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(sel).getTextPane();
        textPane.setText(null);
    }//GEN-LAST:event_menuclearActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        opened = false;
	saveFileAs(jTabbedPane1.getSelectedIndex(), 0);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(sel).getTextPane();
        textPane.selectAll();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
        if(textPane.getText().equals(""))
	JOptionPane.showMessageDialog(this, "Text Area is empty.");
        else
	print(createBuffer(jTabbedPane1.getSelectedIndex()));
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        BasicEvents.FindWord();
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this,
            "Would you like to save?",
            "Exit Application",
            JOptionPane.YES_NO_CANCEL_OPTION);

        switch (confirm) {
            case JOptionPane.YES_OPTION:
                saveFile(jTabbedPane1.getSelectedIndex());
                dispose();
                System.exit(0);
            case JOptionPane.CANCEL_OPTION:
                break;
            default:
                dispose();
                System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        BasicEvents.Replace();
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        BasicEvents.GoToLine();
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(sel).getTextPane();
        textPane.replaceSelection(null);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        aboutPanel.setVisible(true);
    }//GEN-LAST:event_jMenuItem21ActionPerformed
        
    private void menucopy1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menucopy1ActionPerformed
        Copy(jTabbedPane1.getSelectedIndex()); 
    }//GEN-LAST:event_menucopy1ActionPerformed
        
    private void menucut1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menucut1ActionPerformed
        Cut();
    }//GEN-LAST:event_menucut1ActionPerformed

    private void menupaste1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menupaste1ActionPerformed
        Paste();
    }//GEN-LAST:event_menupaste1ActionPerformed

    private void menuclear1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuclear1ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(sel).getTextPane();
        textPane.setText(null);
    }//GEN-LAST:event_menuclear1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
         themeManager.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        tm = new Theme((RSyntaxTextArea)Editor.get(jTabbedPane1.getSelectedIndex()).getTextPane(), this);
        tm.loadTheme(Main.class.getResourceAsStream("/com/power/text/pteditor/themes/darkfeeling.xml"));
        tm.apply(); themePath = "/com/power/text/pteditor/themes/darkfeeling.xml" ;
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        tm = new Theme((RSyntaxTextArea)Editor.get(jTabbedPane1.getSelectedIndex()).getTextPane(), this);
        tm.loadTheme(Main.class.getResourceAsStream("/com/power/text/pteditor/themes/cooldark.xml"));
        tm.apply(); themePath = "/com/power/text/pteditor/themes/cooldark.xml" ;
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        tm = new Theme((RSyntaxTextArea)Editor.get(jTabbedPane1.getSelectedIndex()).getTextPane(), this);
        tm.loadTheme(Main.class.getResourceAsStream("/com/power/text/pteditor/themes/lunareclipse.xml"));
        tm.apply(); themePath = "/com/power/text/pteditor/themes/lunareclipse.xml" ;
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        tm = new Theme((RSyntaxTextArea)Editor.get(jTabbedPane1.getSelectedIndex()).getTextPane(), this);
        tm.loadTheme(Main.class.getResourceAsStream("/com/power/text/pteditor/themes/coollight.xml"));
        tm.apply(); themePath = "/com/power/text/pteditor/themes/coollight.xml";
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        tm = new Theme((RSyntaxTextArea)Editor.get(jTabbedPane1.getSelectedIndex()).getTextPane(), this);
        tm.loadTheme(Main.class.getResourceAsStream("/com/power/text/pteditor/themes/thinktheme.xml"));
        tm.apply(); themePath = "/com/power/text/pteditor/themes/thinktheme.xml" ;
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        FontS.font();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RTextScrollPane scrollPane = (RTextScrollPane) Editor.get(selectedIndex).getScrollPane();
        RTextArea textPane = scrollPane.getTextArea();
        scrollPane.getGutter().setLineNumberFont(new java.awt.Font(textPane.getFont().getFontName(), textPane.getFont().getStyle(), textPane.getFont().getSize()+1));;//textPane.get
        textPane.setFont(new java.awt.Font(textPane.getFont().getFontName(), textPane.getFont().getStyle(), textPane.getFont().getSize()+1));
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RTextScrollPane scrollPane = (RTextScrollPane) Editor.get(selectedIndex).getScrollPane();
        RTextArea textPane = scrollPane.getTextArea();
        scrollPane.getGutter().setLineNumberFont(new java.awt.Font(textPane.getFont().getFontName(), textPane.getFont().getStyle(), textPane.getFont().getSize()-1));;//textPane.get
        textPane.setFont(new java.awt.Font(textPane.getFont().getFontName(), textPane.getFont().getStyle(), textPane.getFont().getSize()-1));
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        tm = new Theme((RSyntaxTextArea)Editor.get(jTabbedPane1.getSelectedIndex()).getTextPane(), this);
        tm.loadTheme(Main.class.getResourceAsStream("/com/power/text/pteditor/themes/sleekblack.xml"));
        tm.apply(); themePath = "/com/power/text/pteditor/themes/sleekblack.xml" ;
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        job = PrinterJob.getPrinterJob();
        format = job.pageDialog(job.defaultPage());
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void searchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbuttonActionPerformed
        String findText = searchbox.getText();
                    if (!findText.equals(find)) {
                        find = findText ;
                        lastMatch = 0;
                    }
                    Highlights.highlightNext(findText);
    }//GEN-LAST:event_searchbuttonActionPerformed

    private void TdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TdfActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RTextScrollPane scrollPane = (RTextScrollPane) Editor.get(selectedIndex).getScrollPane();
        RTextArea textPane = scrollPane.getTextArea();
        scrollPane.getGutter().setLineNumberFont(new java.awt.Font(textPane.getFont().getFontName(), textPane.getFont().getStyle(), textPane.getFont().getSize()-1));;//textPane.get
        textPane.setFont(new java.awt.Font(textPane.getFont().getFontName(), textPane.getFont().getStyle(), textPane.getFont().getSize()-1));
    }//GEN-LAST:event_TdfActionPerformed

    private void TifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TifActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RTextScrollPane scrollPane = (RTextScrollPane) Editor.get(selectedIndex).getScrollPane();
        RTextArea textPane = scrollPane.getTextArea();
        scrollPane.getGutter().setLineNumberFont(new java.awt.Font(textPane.getFont().getFontName(), textPane.getFont().getStyle(), textPane.getFont().getSize()+1));;//textPane.get
        textPane.setFont(new java.awt.Font(textPane.getFont().getFontName(), textPane.getFont().getStyle(), textPane.getFont().getSize()+1));
    }//GEN-LAST:event_TifActionPerformed

    private void TpasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TpasteActionPerformed
        Paste();
    }//GEN-LAST:event_TpasteActionPerformed

    private void TcutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TcutActionPerformed
        Cut();
    }//GEN-LAST:event_TcutActionPerformed

    private void TcopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TcopyActionPerformed
        Copy(jTabbedPane1.getSelectedIndex());
    }//GEN-LAST:event_TcopyActionPerformed

    private void TsaveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TsaveFileActionPerformed
        saveFile(jTabbedPane1.getSelectedIndex());
    }//GEN-LAST:event_TsaveFileActionPerformed

    private void TopenFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TopenFileActionPerformed
       int status = fileChooser.showOpenDialog(rootPane); 
       fileChooser.setCurrentDirectory(new File(Editor.get(jTabbedPane1.getSelectedIndex()).getParentFolder()));
        if (status == JFileChooser.APPROVE_OPTION) {
           try {
               File files = fileChooser.getSelectedFile();
               Scanner scn = new Scanner(new FileInputStream(files));
               openFile(files, scn); addRecent(files.getAbsolutePath());
           } catch (FileNotFoundException ex) {
               Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
           }
        } else {
            System.out.println("No file selected");
        }
    }//GEN-LAST:event_TopenFileActionPerformed

    public void addRecent(String newDirectory) {
            String filePath = getPowerTextGen()+"recentfiles.pteditor";  int lineCount = 0 ; try { 
                BufferedWriter bufferedWriter = null;  Scanner scn = new Scanner(new FileInputStream(getPowerTextGen()+"recentfiles.pteditor")); try {
                String buffer = ""; while (scn.hasNextLine()) { buffer += scn.nextLine() + "\n"; lineCount++; } if (lineCount<15) {
                buffer += newDirectory + "\n" ;
                bufferedWriter = new BufferedWriter(new FileWriter(filePath, false));
                bufferedWriter.write(buffer);} else { String[] splitStrings = buffer.split("\\\n", 2) ; //[Untitled 0, txt]
                String bufferFinal = splitStrings[splitStrings.length-1] ; buffer = newDirectory + "\n" + bufferFinal ;
                bufferedWriter = new BufferedWriter(new FileWriter(filePath, false));
                bufferedWriter.write(buffer);
                        System.out.println("it is over 15 lines \n"+bufferFinal); }
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                if (bufferedWriter != null) {
                bufferedWriter.flush();
                bufferedWriter.close();
            } } catch (IOException ex) {
            ex.getMessage();
            }
    }
} catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }  menuItem.add(newDirectory);
    }
    
    private void TnewFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TnewFileActionPerformed
        newInitFile("");
    }//GEN-LAST:event_TnewFileActionPerformed

    private void toggletoolbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggletoolbarActionPerformed
      if  (toolbar.isVisible()){
          toolbar.setVisible(false);
          togglesearch.setSelected(false); 
          searchbox.setVisible(false); searchbutton.setVisible(false);
      } else {
          toolbar.setVisible(true);
          togglesearch.setSelected(true); 
          searchbox.setVisible(true); searchbutton.setVisible(true);
      }
    }//GEN-LAST:event_toggletoolbarActionPerformed

    private void togglesearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_togglesearchActionPerformed
        if  (searchbox.isVisible()&&searchbutton.isVisible()){
          searchbox.setVisible(false);
          searchbutton.setVisible(false);
      } else {
          searchbox.setVisible(true);
          searchbutton.setVisible(true);
      }
    }//GEN-LAST:event_togglesearchActionPerformed

    private void toglestatuspanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toglestatuspanelActionPerformed
      if  (statusPanel.isVisible()){
          statusPanel.setVisible(false);
          togglecaretpos.setSelected(false); Totalsel.setVisible(false);
        toggletimeelapsed.setSelected(false); notification.setVisible(false);
        toglecal.setSelected(false); cal.setVisible(false);
        togleselection.setSelected(false); statusLabel.setVisible(false);
        togledate.setSelected(false); dateLabel.setVisible(false);
        togletime.setSelected(false); timeLabel.setVisible(false);
      } else {
          statusPanel.setVisible(true);
          togglecaretpos.setSelected(true); Totalsel.setVisible(true);
        toggletimeelapsed.setSelected(true); notification.setVisible(true);
        toglecal.setSelected(true); cal.setVisible(true);
        togleselection.setSelected(true); statusLabel.setVisible(true);
        togledate.setSelected(true); dateLabel.setVisible(true);
        togletime.setSelected(true); timeLabel.setVisible(true);
      }
    }//GEN-LAST:event_toglestatuspanelActionPerformed

    private void togglecaretposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_togglecaretposActionPerformed
        if  (Totalsel.isVisible()){
          Totalsel.setVisible(false);
      } else {
          Totalsel.setVisible(true);
      }
    }//GEN-LAST:event_togglecaretposActionPerformed

    private void toglecalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toglecalActionPerformed
      if  (cal.isVisible()){
          cal.setVisible(false);
      } else {
          cal.setVisible(true);
      }
    }//GEN-LAST:event_toglecalActionPerformed

    private void togleselectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_togleselectionActionPerformed
       if  (statusLabel.isVisible()){
          statusLabel.setVisible(false);
      } else {
          statusLabel.setVisible(true);
      }
    }//GEN-LAST:event_togleselectionActionPerformed

    private void togledateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_togledateActionPerformed
       if  (dateLabel.isVisible()){
          dateLabel.setVisible(false);
      } else {
          dateLabel.setVisible(true);
      }
    }//GEN-LAST:event_togledateActionPerformed

    private void togletimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_togletimeActionPerformed
      if  (timeLabel.isVisible()){
          timeLabel.setVisible(false);
      } else {
          timeLabel.setVisible(true);
      }
    }//GEN-LAST:event_togletimeActionPerformed

    private void toggletimeelapsedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toggletimeelapsedActionPerformed
        if  (notification.isVisible()){
          notification.setVisible(false);
      } else {
          notification.setVisible(true);
      }
    }//GEN-LAST:event_toggletimeelapsedActionPerformed

    private void TsfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TsfActionPerformed
        FontS.font();
    }//GEN-LAST:event_TsfActionPerformed

    private void editoronlyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editoronlyActionPerformed
        jPanel3.setVisible(false); jCheckBoxMenuItem1.setSelected(false);
        toolbar.setVisible(false); toggletoolbar.setSelected(false);
        jPanel3.setVisible(false); docuselector.setSelected(false);
        jPanel1.setVisible(false); cliphist.setSelected(false);
        togglesearch.setSelected(false); searchbox.setVisible(false); searchbutton.setVisible(false);
        statusPanel.setVisible(false); toglestatuspanel.setSelected(false);
        togglecaretpos.setSelected(false); Totalsel.setVisible(false);
        toggletimeelapsed.setSelected(false); notification.setVisible(false);
        toglecal.setSelected(false); cal.setVisible(false);
        togleselection.setSelected(false); statusLabel.setVisible(false);
        togledate.setSelected(false); dateLabel.setVisible(false);
        togletime.setSelected(false); timeLabel.setVisible(false);
    }//GEN-LAST:event_editoronlyActionPerformed

    private void TprintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TprintActionPerformed
        print(createBuffer(jTabbedPane1.getSelectedIndex()));
    }//GEN-LAST:event_TprintActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        //new FindReplaceDialog();
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem27ActionPerformed

    private void jMenuItem28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem28ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
            new com.power.text.dialogs.findreplace(this, opened).setVisible(true);
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jMenuItem29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem29ActionPerformed
               String findText = searchbox.getText();
                    if (!findText.equals(find)) {
                        find = findText;
                        lastMatch = 0;
                    }
                    Highlights.highlightNext(findText);
    }//GEN-LAST:event_jMenuItem29ActionPerformed

    private void jMenuItem30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem30ActionPerformed
         String findText = searchbox.getText();
                    if (!findText.equals(find)) {
                        find = findText;
                        lastMatch = 0;
                    }
                    Highlights.highlightPrevious(findText);
    }//GEN-LAST:event_jMenuItem30ActionPerformed

    private void jMenuItem31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem31ActionPerformed
       runPanel.setVisible(true);     
    }//GEN-LAST:event_jMenuItem31ActionPerformed

    private void jMenuItem32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem32ActionPerformed
        RunDB rd = new RunDB();
        rd.start();
    }//GEN-LAST:event_jMenuItem32ActionPerformed

    class RunDB extends Thread {
        @Override
        public void run(){
            saveFile(jTabbedPane1.getSelectedIndex());
            RunDBnow(Editor.get(jTabbedPane1.getSelectedIndex()).getFileDire().getText()); 
        }}
    
    private void jMenuItem33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem33ActionPerformed
        RunF rf = new RunF();
        rf.start();
    }//GEN-LAST:event_jMenuItem33ActionPerformed

    class RunF extends Thread {
        @Override
        public void run(){
            saveFile(jTabbedPane1.getSelectedIndex());
            RunFirefox.firefox();  
        }}
    
    private void jMenuItem34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem34ActionPerformed
        RunC rc = new RunC();
        rc.start();
    }//GEN-LAST:event_jMenuItem34ActionPerformed

    class RunC extends Thread {
        @Override
        public void run(){
            saveFile(jTabbedPane1.getSelectedIndex());
            RunChrome.chrome(); 
        }}
    
    private void jMenuItem35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem35ActionPerformed
        RunS rs = new RunS();
        rs.start();
    }//GEN-LAST:event_jMenuItem35ActionPerformed

    class RunS extends Thread {
        @Override
        public void run(){
            saveFile(jTabbedPane1.getSelectedIndex());
            RunSafari.safari(); 
        }}
    
    private void jMenuItem36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem36ActionPerformed
        RunIE rie = new RunIE();
        rie.start();
    }//GEN-LAST:event_jMenuItem36ActionPerformed

    class RunIE extends Thread {
        @Override
        public void run(){
            saveFile(jTabbedPane1.getSelectedIndex());
            RunIExplorer.ie(); 
        }}
    
    private void jMenuItem37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem37ActionPerformed
        WebSearch1 ws = new WebSearch1();
        ws.start();
    }//GEN-LAST:event_jMenuItem37ActionPerformed

    class WebSearch1 extends Thread {
        @Override
        public void run(){
            String comp = searchbox.getText(); 
        if ("".equals(comp)) {
            websearchPanel.setVisible(true);
        } else {
            GoogleSearch.googlesearch();
        } 
        }}
    
    private void jMenuItem38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem38ActionPerformed
        WebSearch2 ws = new WebSearch2();
        ws.start();
    }//GEN-LAST:event_jMenuItem38ActionPerformed

    class WebSearch2 extends Thread {
        @Override
        public void run(){
            String comp = searchbox.getText(); 
        if ("".equals(comp)) {
            websearchPanel.setVisible(true);
        } else {
            BingSearch.bingsearch();
        } 
        }}
    
    private void jMenuItem39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem39ActionPerformed
        WebSearch3 ws = new WebSearch3();
        ws.start();
    }//GEN-LAST:event_jMenuItem39ActionPerformed

    class WebSearch3 extends Thread {
        @Override
        public void run(){
            String comp = searchbox.getText(); 
        if ("".equals(comp)) {
            websearchPanel.setVisible(true);
        } else {
            WikiSearch.wikisearch();
        }
        }}
    
    class WebSearch extends Thread {
        @Override
        public void run(){
            new com.power.text.dialogs.WebSearch(null, opened).setVisible(true);
        }
    }
    
    private void jMenuItem41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem41ActionPerformed
        try {
            summaryPane.setVisible(true); 
            summary.summaryAll(); osEncoding.setText("Caret Position : " + Totalsel.getText());
            jLabel18.setText("Current Line : " + jLabel500.getText()); jLabel19.setText("Current Column : " + jLabel501.getText());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem41ActionPerformed

    private void jMenuItem40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem40ActionPerformed
        new com.power.text.dialogs.RunDialog(this, opened).setVisible(true);
    }//GEN-LAST:event_jMenuItem40ActionPerformed

    private void jMenuItem42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem42ActionPerformed
        saveFile(jTabbedPane1.getSelectedIndex());
        RunDBnow(Editor.get(jTabbedPane1.getSelectedIndex()).getFileDire().getText());
    }//GEN-LAST:event_jMenuItem42ActionPerformed

    private void jMenuItem43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem43ActionPerformed
        saveFile(jTabbedPane1.getSelectedIndex());
        RunFirefox.firefox();
    }//GEN-LAST:event_jMenuItem43ActionPerformed

    private void jMenuItem44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem44ActionPerformed
        saveFile(jTabbedPane1.getSelectedIndex());
        RunChrome.chrome();
    }//GEN-LAST:event_jMenuItem44ActionPerformed

    private void jMenuItem45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem45ActionPerformed
        saveFile(jTabbedPane1.getSelectedIndex());
        RunSafari.safari();
    }//GEN-LAST:event_jMenuItem45ActionPerformed

    private void jMenuItem46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem46ActionPerformed
        saveFile(jTabbedPane1.getSelectedIndex());
        RunIExplorer.ie();
    }//GEN-LAST:event_jMenuItem46ActionPerformed

    private void jMenuItem47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem47ActionPerformed
        String comp = searchbox.getText(); 
        if ("".equals(comp)) {
            new com.power.text.dialogs.WebSearch(this, opened).setVisible(true);
        } else {
            GoogleSearch.googlesearch();
        }
    }//GEN-LAST:event_jMenuItem47ActionPerformed

    private void jMenuItem48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem48ActionPerformed
        String comp = searchbox.getText(); 
        if ("".equals(comp)) {
            new com.power.text.dialogs.WebSearch(this, opened).setVisible(true);
        } else {
            BingSearch.bingsearch();
        }
    }//GEN-LAST:event_jMenuItem48ActionPerformed

    private void jMenuItem49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem49ActionPerformed
        String comp = searchbox.getText(); 
        if ("".equals(comp)) {
            new com.power.text.dialogs.WebSearch(this, opened).setVisible(true);
        } else {
            WikiSearch.wikisearch();
        }
    }//GEN-LAST:event_jMenuItem49ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(sel).getTextPane();
        textPane.selectAll();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem50ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this,
            "Would you like to save?",
            "Exit Application",
            JOptionPane.YES_NO_CANCEL_OPTION);

        switch (confirm) {
            case JOptionPane.YES_OPTION:
                saveFile(jTabbedPane1.getSelectedIndex());
                dispose();
                System.exit(0);
            case JOptionPane.CANCEL_OPTION:
                break;
            default:
                dispose();
                System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem50ActionPerformed

    private void jMenuItem51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem51ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        String filename = jTabbedPane1.getTitleAt(sel);
        StringSelection stringSelection = new StringSelection(filename);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
        copylistModel.addElement(filename);
    }//GEN-LAST:event_jMenuItem51ActionPerformed

    private void jMenuItem52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem52ActionPerformed
        String filepath = titleText.getText() ;
        StringSelection stringSelection = new StringSelection(filepath);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
        copylistModel.addElement(filepath);
    }//GEN-LAST:event_jMenuItem52ActionPerformed

    private void jMenuItem53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem53ActionPerformed
        String fileExt = fileext.getText() ;
        StringSelection stringSelection = new StringSelection(fileExt);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);
        copylistModel.addElement(fileExt);
    }//GEN-LAST:event_jMenuItem53ActionPerformed

    private void jMenuItem54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem54ActionPerformed
        try {
            //new dialogs.Summary(this, opened).setVisible(true);
            summary.summaryAll(); osEncoding.setText("Caret Position : " + Totalsel.getText());
            jLabel18.setText("Current Line : " + jLabel500.getText()); jLabel19.setText("Current Column : " + jLabel501.getText());
            String fileSum = "\t\t"+jLabel23.getText()+"\n"+osEncoding.getText()+"\t\t"+
                    jLabel18.getText()+"\n"+jLabel19.getText()+"\t\t"+jLabel20.getText()
                    +"\n"+jLabel21.getText()+"\t\t"+jLabel22.getText()+"\n"+jLabel16.getText()
                    +"\t\t"+jLabel24.getText()+"\n"+jLabel25.getText()+"\t\t"+jLabel26.getText()
                    +"\n"+jLabel27.getText()+"\t\t"+jLabel500.getText();
            StringSelection stringSelection = new StringSelection(fileSum);
            Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
            clpbrd.setContents(stringSelection, null);
            copylistModel.addElement(fileSum);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
          
    }//GEN-LAST:event_jMenuItem54ActionPerformed

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
    
    private void jMenuItem55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem55ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
        new com.power.text.ui.pteditor.RSyntaxTextAreaEditorKit.InsertTabAction().actionPerformedImpl(evt, textPane);
    }//GEN-LAST:event_jMenuItem55ActionPerformed

    private void jMenuItem57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem57ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(sel).getTextPane();
        if (textPane.getSelectedText() == null) {
            notification.setText("No Text Selected ");
        } else {
            String njm = textPane.getSelectedText().toLowerCase();
            textPane.replaceSelection(njm);}
    }//GEN-LAST:event_jMenuItem57ActionPerformed

    private void jMenuItem58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem58ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(sel).getTextPane();
        if (textPane.getSelectedText() == null) {
            notification.setText("No Text Selected ");
        } else {
            String njm = textPane.getSelectedText().toUpperCase();
            textPane.replaceSelection(njm);}
    }//GEN-LAST:event_jMenuItem58ActionPerformed

    private void jMenuItem59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem59ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(sel).getTextPane();
        String comp = textPane.getSelectedText();; 
        String url = "https://www.google.com.ng/search?site=&source=hp&q=" + comp;
        try
        {
            URI uri = new URL(url).toURI();
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE))
                desktop.browse(uri);
        }
    catch (Exception e)
        {}
    }//GEN-LAST:event_jMenuItem59ActionPerformed

    private void editableMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editableMIActionPerformed
        if (editableMI.isSelected()){
            int selectedIndex = jTabbedPane1.getSelectedIndex();
            RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
            textPane.setEditable(false);
        } else {
            int selectedIndex = jTabbedPane1.getSelectedIndex();
            RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
            textPane.setEditable(true);
        }
        
    }//GEN-LAST:event_editableMIActionPerformed

    private void jMenuItem60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem60ActionPerformed
        try {
            int selectedIndex = jTabbedPane1.getSelectedIndex();
            RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
            Highlighter h = textPane.getHighlighter();
            String select = textPane.getSelectedText();String context = textPane.getText();
            String words[] = select.split(" ");
            for (int i = 0 ; i < words.length; i++) {
                String temp = words[i];
                if (temp.equals(select)){
            h.addHighlight(i, temp.length(), (HighlightPainter) Color.RED);}
        }} catch (BadLocationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem60ActionPerformed

    private void jMenuItem61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem61ActionPerformed
        String ptt = PTree.get(1).getTreeDir();
        JOptionPane.showMessageDialog(this, "the path is " + ptt);
    }//GEN-LAST:event_jMenuItem61ActionPerformed

    private void jMenuItem68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem68ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        Path deleteFile = Paths.get(titleText.getText());
        Editor.remove(selectedIndex);
        listModel.removeElementAt(selectedIndex);
        File del = new File(titleText.getText());
        jTabbedPane1.remove(selectedIndex);
        del.delete(); 
    }//GEN-LAST:event_jMenuItem68ActionPerformed

    private void jMenuItem69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem69ActionPerformed
        File currentFile = new File(titleText.getText()); String ext = "" ;
        int sel = jTabbedPane1.getSelectedIndex() ; String title = jTabbedPane1.getTitleAt(sel);
        if (title.contains(".")) { ext = title.substring(title.lastIndexOf(".")); }
        if (titleText.getText().contains("Untitled")) {
            opened = false;
            saveFileAs(jTabbedPane1.getSelectedIndex(), 0);
        } else {
            String rename = JOptionPane.showInputDialog(this, "Input New Name. Add Extension" );
            if (rename!=null&&title.endsWith(ext)&&!rename.endsWith(ext)) {
                rename = rename + ext; 
            } String oldName = Editor.get(sel).getFileDir(); String newName = Editor.get(sel).getParentFolder()+"\\"+rename; 
            new File(oldName).renameTo(new File(newName)); 
            if (new File(newName).exists()) { 
                try {
                    closeFile(sel); Scanner scn = new Scanner(new FileInputStream(new File(newName)));
                    openFile(new File(newName), scn); addRecent(newName);
                    System.out.println(oldName+" rename to "+newName+" successfull");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
        }
    }//GEN-LAST:event_jMenuItem69ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        File currentFile = new File(titleText.getText()); String ext = "" ;
        int sel = jTabbedPane1.getSelectedIndex() ; String title = jTabbedPane1.getTitleAt(sel);
        if (title.contains(".")) { ext = title.substring(title.lastIndexOf(".")); }
        if (titleText.getText().contains("Untitled")) {
            opened = false;
            saveFileAs(jTabbedPane1.getSelectedIndex(), 0);
        } else {
            String rename = JOptionPane.showInputDialog(this, "Input New Name. Add Extension" );
            if (rename!=null&&title.endsWith(ext)&&!rename.endsWith(ext)) {
                rename = rename + ext; 
            } String oldName = Editor.get(sel).getFileDir(); String newName = Editor.get(sel).getParentFolder()+"\\"+rename; 
            new File(oldName).renameTo(new File(newName)); 
            if (new File(newName).exists()) { 
                try {
                    closeFile(sel); Scanner scn = new Scanner(new FileInputStream(new File(newName)));
                    openFile(new File(newName), scn); addRecent(newName);
                    System.out.println(oldName+" rename to "+newName+" successfull");
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
}
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem70ActionPerformed
        closeFile(jTabbedPane1.getSelectedIndex());
    }//GEN-LAST:event_jMenuItem70ActionPerformed

    private void jMenuItem72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem72ActionPerformed
        closeAllFiles();
    }//GEN-LAST:event_jMenuItem72ActionPerformed

    private void jMenuItem71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem71ActionPerformed
        closeAllButActiveFile();
    }//GEN-LAST:event_jMenuItem71ActionPerformed

    private void Undo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Undo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Undo1ActionPerformed

    private void redoaction1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoaction1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_redoaction1ActionPerformed

    private void cliphistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cliphistActionPerformed
      jPanel1.removeAll(); jPanel1.revalidate(); jPanel1.repaint(); jPanel1.add(jPanel7);      
      if  (jPanel1.isVisible() && !jCheckBoxMenuItem3.isSelected()){
            jPanel1.setVisible(false); jCheckBoxMenuItem3.setSelected(false);
      } else if (!jCheckBoxMenuItem2.isSelected()) {
            jPanel1.setVisible(true); jCheckBoxMenuItem3.setSelected(false);
      } else if (jPanel1.isVisible() && jCheckBoxMenuItem3.isSelected()){
             jCheckBoxMenuItem3.setSelected(false);
      }
    }//GEN-LAST:event_cliphistActionPerformed

    private void docuselectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docuselectorActionPerformed
        jMenu19.setVisible(false); 
        jPanel3.removeAll(); jPanel3.revalidate(); jPanel3.repaint(); jPanel3.add(jPanel6);      
       if (!docuselector.isSelected() && jPanel3.isVisible()) {
            jPanel3.setVisible(false); jCheckBoxMenuItem2.setSelected(false); docuselector.setSelected(false);
            jCheckBoxMenuItem4.setSelected(false);
      }else if (docuselector.isSelected()) {
            jPanel3.setVisible(true); docuselector.setSelected(true); jCheckBoxMenuItem2.setSelected(false); 
            jCheckBoxMenuItem4.setSelected(false);
      }
    }//GEN-LAST:event_docuselectorActionPerformed

    private void jMenuItem56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem56ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
        new DecreaseIndentAction().actionPerformedImpl(evt, textPane);
    }//GEN-LAST:event_jMenuItem56ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //makeCollapsibleArea();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jMenuItem73ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem73ActionPerformed
        CloseATL(jTabbedPane1.getSelectedIndex());
    }//GEN-LAST:event_jMenuItem73ActionPerformed

    private void jMenuItem74ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem74ActionPerformed
        CloseATR(jTabbedPane1.getSelectedIndex());
    }//GEN-LAST:event_jMenuItem74ActionPerformed

    private void jMenuItem75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem75ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_JAVA);
    }//GEN-LAST:event_jMenuItem75ActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        if  (jPanel4.isVisible()){
          jPanel4.setVisible(false);
      } else {
          jPanel4.setVisible(true);
      }
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem2ActionPerformed
        jMenu19.setVisible(false); 
        jPanel3.removeAll(); jPanel3.revalidate(); jPanel3.repaint(); jPanel3.add(jPanel5);      
       if (!jCheckBoxMenuItem2.isSelected() && jPanel3.isVisible()) {
            jPanel3.setVisible(false); jCheckBoxMenuItem2.setSelected(false); docuselector.setSelected(false);
            jCheckBoxMenuItem4.setSelected(false);
      }else if (jCheckBoxMenuItem2.isSelected()) {
            jPanel3.setVisible(true); jCheckBoxMenuItem2.setSelected(true); jCheckBoxMenuItem4.setSelected(false);
            docuselector.setSelected(false);
      }
    }//GEN-LAST:event_jCheckBoxMenuItem2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        OpenProj();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        try {
            NewProj();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        copylistModel.removeAllElements();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jCheckBoxMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem3ActionPerformed
        jPanel1.removeAll(); jPanel1.revalidate(); jPanel1.repaint(); jPanel1.add(jPanel8);      
      if  (jPanel1.isVisible() && !cliphist.isSelected()){
            jPanel1.setVisible(false); cliphist.setSelected(false);
      } else if (!jCheckBoxMenuItem2.isSelected()) {
            jPanel1.setVisible(true); cliphist.setSelected(false);
      } else if (jPanel1.isVisible() && cliphist.isSelected()){
             cliphist.setSelected(false);
      }
    }//GEN-LAST:event_jCheckBoxMenuItem3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //ProgressBarDemo2 demil = new ProgressBarDemo2();
        jPanel3.removeAll(); jPanel3.revalidate(); jPanel3.repaint(); //jPanel3.add(demil);      
        if  (jPanel3.isVisible() && !jCheckBoxMenuItem2.isSelected()){
            jPanel3.setVisible(false); jCheckBoxMenuItem2.setSelected(false);
      } else if (!jCheckBoxMenuItem2.isSelected()) {
            jPanel3.setVisible(true); jCheckBoxMenuItem2.setSelected(false);
      } else if (jPanel3.isVisible() && jCheckBoxMenuItem2.isSelected()){
             jCheckBoxMenuItem2.setSelected(false);
      }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem76ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem76ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_XML);
    }//GEN-LAST:event_jMenuItem76ActionPerformed

    private void jMenuItem62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem62ActionPerformed
      documentPane.setVisible(true);
    }//GEN-LAST:event_jMenuItem62ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String findText = incresearch.getText();
                    if (!findText.equals(find)) {
                        find = findText;
                        lastMatch = 0;
                    }
                    Highlights.highlightNext(findText);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String findText = incresearch.getText();
                    if (!findText.equals(find)) {
                        find = findText;
                        lastMatch = 0;
                    }
                    Highlights.highlightPrevious(findText);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jMenuItem63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem63ActionPerformed
        try {
            NewProj();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem63ActionPerformed

    private void jMenuItem77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem77ActionPerformed
        OpenProj();
    }//GEN-LAST:event_jMenuItem77ActionPerformed

    private void jMenuItem78ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem78ActionPerformed
        if (jTabbedPane2.getTabCount()>0) { 
            int seL = jTabbedPane2.getSelectedIndex();
            String locaTe = Editree.get(jTabbedPane2.getSelectedIndex()).getTreeDir(); 
            String fileNa = JOptionPane.showInputDialog(this, "Create File In "+jTabbedPane2.getTitleAt(seL)+"\nAdd Extension");
            String projFName = "\\"+fileNa; File projNFile =  new File(locaTe+projFName);
            if (projNFile.exists()) {
                JOptionPane.showInputDialog(this, "File Already exist");
            } else {
                try {
                    try (DataOutputStream d = new DataOutputStream(new FileOutputStream(projNFile))) {
                        String line = "" ;
                        d.writeBytes(line);
                    }
                    Scanner scn = new Scanner(new FileInputStream(projNFile));
                    openFile(projNFile, scn); DefaultTreeModel model = (DefaultTreeModel) Editree.get(jTabbedPane2.getSelectedIndex()).getJTree().getModel();
                    TreeNode root = (TreeNode) model.getRoot();
                    //root.add(new DefaultMutableTreeNode("another_child"));
                    model.nodeStructureChanged(root);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        //System.out.println(Editree.get(jTabbedPane2.getSelectedIndex()).getTreeDir());
    }//GEN-LAST:event_jMenuItem78ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        closeFile(jTabbedPane1.getSelectedIndex());
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jMenuItem79ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem79ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem79ActionPerformed

    private void jMenuItem82ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem82ActionPerformed
        newInitFile("");
    }//GEN-LAST:event_jMenuItem82ActionPerformed

    private void jMenuItem84ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem84ActionPerformed
        int recentFileInt = menuItem.getMenuComponentCount() ;
        for (int a = recentFileInt - 1; a >= 23; a--) {
                menuItem.remove(a); BufferedWriter bufferedWriter = null;  try {
                String filePath = "pteditor gen files//recentfiles.pteditor";
                bufferedWriter = new BufferedWriter(new FileWriter(filePath, false));
                bufferedWriter.write("");
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                if (bufferedWriter != null) {
                bufferedWriter.flush();
                bufferedWriter.close();
            } } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } } }
    }//GEN-LAST:event_jMenuItem84ActionPerformed
    
    private void jMenuItem87ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem87ActionPerformed
        try {
            String path = Editor.get(jTabbedPane1.getSelectedIndex()).getParentFolder() ;
            System.out.println(path); rt = Runtime.getRuntime();
            rt.exec("cmd.exe /c start cd "+path); 
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem87ActionPerformed

    private void jMenuItem86ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem86ActionPerformed
        try {
            String path = Editor.get(jTabbedPane1.getSelectedIndex()).getParentFolder() ;
            Desktop.getDesktop().open(new File(path));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem86ActionPerformed

    private void jMenuItem88ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem88ActionPerformed
        opened = false;
	saveFileAs(jTabbedPane1.getSelectedIndex(), 1);
    }//GEN-LAST:event_jMenuItem88ActionPerformed

    private void jMenuItem89ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem89ActionPerformed
        int tabs = jTabbedPane1.getTabCount();
        for (int i = tabs - 1; i >= 0; i--) {
         saveFile(i);
        } 
    }//GEN-LAST:event_jMenuItem89ActionPerformed

    private void jMenuItem91ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem91ActionPerformed
            saveStateD.setApproveButtonText("Save Current State"); saveStateD.setToolTipText("Save Current State");
            saveStateD.setDialogTitle("Save Current State");
            int retVal = 0 ; int retnVal = 0 ; do {
            retVal = this.STATUS_CANCEL;
            int returnVal = saveStateD.showSaveDialog(this);
            if (returnVal == JFileChooser.CANCEL_OPTION) {
                retnVal = this.STATUS_CANCEL;
            } else if (returnVal == JFileChooser.APPROVE_OPTION) {
                File f = saveStateD.getSelectedFile(); if (f.getAbsolutePath().contains(".")) {
                } else {f = new File(f.getAbsolutePath()+".ptestate"); }
                retVal = this.STATUS_OK;
                if (f.exists()) {
                    retVal = JOptionPane.showConfirmDialog(this,
                            "File already exists!\nReplace?");
                    switch (retVal) {
                        case JOptionPane.YES_OPTION:
                            retVal = this.STATUS_OK;
                            break;
                        case JOptionPane.NO_OPTION:
                            retVal = this.STATUS_NO;
                            break;
                        case JOptionPane.CANCEL_OPTION:
                            retVal = this.STATUS_CANCEL;
                            break;
                        default:
                            break;
                    }
                }
                if (retVal == this.STATUS_OK) {
                    try { String line = "" ;
                    int tabs = jTabbedPane1.getTabCount() - 1; //10
                        for (int i = 0; i <= tabs; i++) {
                        String dir = Editor.get(i).getFileDire().getText(); line += dir+"\n" ;
                      } 
                        DataOutputStream d = new DataOutputStream(new FileOutputStream(f));
                        d.writeBytes(line);
                        d.close(); Scanner scn = new Scanner(new FileInputStream(f));
                        retVal = this.STATUS_ERROR; 
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } } while (retVal == this.STATUS_NO);
    }//GEN-LAST:event_jMenuItem91ActionPerformed

    private void jMenuItem90ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem90ActionPerformed
        saveStateD.setApproveButtonText("Load Saved State"); saveStateD.setToolTipText("Load Saved State");
        saveStateD.setDialogTitle("Load Saved State");
        int status = saveStateD.showOpenDialog(rootPane);
        if (status == JFileChooser.APPROVE_OPTION) {
            File OpenedFile = saveStateD.getSelectedFile(); closeAllFiles();
            String buffer = ""; try {  if (OpenedFile.exists()) {Scanner scn = new Scanner(new FileInputStream(OpenedFile));
        if (scn.hasNext()) {
        while (scn.hasNext()) { buffer = scn.nextLine();  System.out.println("path > "+buffer);/**if (buffer.contains("administrator")) {**/ 
        File openFile = new File(buffer); 
        if (openFile.exists()) { Scanner scn1 = new Scanner(new FileInputStream(openFile)); openFile(openFile, scn1); } 
        else { System.out.println("File Does not exist anymore"); } } } else { 
            System.out.println("opened file list is empty"); newInitFile(""); }
        }else { System.out.println("No opend file found"); newInitFile(""); }
        } catch (FileNotFoundException ex) { Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex); } 
        } else {
            System.out.println("No file selected");
        }
    }//GEN-LAST:event_jMenuItem90ActionPerformed

    public static int doti = 0 ;
    
    private void jMenuItem85ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem85ActionPerformed
        try {
            File openFile = new File(lastClosedFile);
            Scanner scn1 = new Scanner(new FileInputStream(openFile)); openFile(openFile, scn1);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem85ActionPerformed

    private void jMenuItem83ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem83ActionPerformed
        String buffer = ""; try { File OpenedFile = new File("pteditor gen files//recentfiles.pteditor"); if (OpenedFile.exists()) {Scanner scn = new Scanner(new FileInputStream(OpenedFile));
        if (scn.hasNext()) {
        while (scn.hasNext()) { buffer = scn.nextLine();  System.out.println("path > "+buffer);/**if (buffer.contains("administrator")) {**/ 
        File openFile = new File(buffer); 
        if (openFile.exists()) { Scanner scn1 = new Scanner(new FileInputStream(openFile)); openFile(openFile, scn1); } 
        else { System.out.println("File Does not exist anymore"); } } } else { 
            System.out.println("opened file list is empty"); newInitFile(""); }
        }else { System.out.println("No opend file found"); newInitFile(""); }
        } catch (FileNotFoundException ex) { Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex); }    
    }//GEN-LAST:event_jMenuItem83ActionPerformed

    private void TsaveFile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TsaveFile1ActionPerformed
        int tabs = jTabbedPane1.getTabCount();
        for (int i = tabs - 1; i >= 0; i--) {
         saveFile(i);
        }
    }//GEN-LAST:event_TsaveFile1ActionPerformed

    private void jMenuItem92ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem92ActionPerformed
         int selectedIndex = jTabbedPane1.getSelectedIndex();
         RTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
         new JoinLinesAction().actionPerformedImpl(evt, textPane);
    }//GEN-LAST:event_jMenuItem92ActionPerformed

    private void jMenuItem93ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem93ActionPerformed
        System.out.println("Doin nothing i guess shitty i know");
    }//GEN-LAST:event_jMenuItem93ActionPerformed

    private void jMenuItem94ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem94ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
        new LineMoveAction(RTextAreaEditorKit.rtaLineUpAction, -1).actionPerformedImpl(evt, textPane);
    }//GEN-LAST:event_jMenuItem94ActionPerformed

    private void jMenuItem95ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem95ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(sel).getTextPane();
        textPane.setCaretPosition(SetCursor(cln,textPane)); textPane.replaceSelection("\n");
    }//GEN-LAST:event_jMenuItem95ActionPerformed

    private void jMenuItem96ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem96ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(sel).getTextPane();
        textPane.setCaretPosition(textPane.getLineEndOffsetOfCurrentLine()); textPane.replaceSelection("\n");
    }//GEN-LAST:event_jMenuItem96ActionPerformed

    private void jMenuItem97ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem97ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex(); //currently testing for java
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(sel).getTextPane();
        textPane.setCaretPosition(SetCursor(cln,textPane)); textPane.replaceSelection("//");
    }//GEN-LAST:event_jMenuItem97ActionPerformed

    private void jMenuItem98ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem98ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(sel).getTextPane();
        textPane.setCaretPosition(SetCursor(cln, textPane));
        int tabLoc = textPane.getCaret().getDot() ;
        textPane.setSelectionStart(tabLoc); textPane.setSelectionEnd(tabLoc + 2);
        String s = textPane.getSelectedText();
        if (!s.equals("//")) { System.out.println("Not uncommentable"); textPane.setSelectionStart(tabLoc); textPane.setSelectionEnd(tabLoc);
        } else { textPane.replaceSelection("");}
    }//GEN-LAST:event_jMenuItem98ActionPerformed

    private void jMenuItem99ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem99ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem99ActionPerformed

    private void jMenuItem100ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem100ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem100ActionPerformed

    private void jMenuItem102ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem102ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_ACTIONSCRIPT);
    }//GEN-LAST:event_jMenuItem102ActionPerformed

    private void jMenuItem108ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem108ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_ASSEMBLER_X86);
    }//GEN-LAST:event_jMenuItem108ActionPerformed

    private void jMenuItem109ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem109ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_BBCODE);
    }//GEN-LAST:event_jMenuItem109ActionPerformed

    private void jMenuItem110ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem110ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_WINDOWS_BATCH);
    }//GEN-LAST:event_jMenuItem110ActionPerformed

    private void jMenuItem101ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem101ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_NONE);
    }//GEN-LAST:event_jMenuItem101ActionPerformed

    private void jMenuItem111ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem111ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_C);
    }//GEN-LAST:event_jMenuItem111ActionPerformed

    private void jMenuItem112ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem112ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_CPLUSPLUS);
    }//GEN-LAST:event_jMenuItem112ActionPerformed

    private void jMenuItem113ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem113ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_CSHARP);
    }//GEN-LAST:event_jMenuItem113ActionPerformed

    private void jMenuItem114ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem114ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_CLOJURE);
    }//GEN-LAST:event_jMenuItem114ActionPerformed

    private void jMenuItem115ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem115ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_CSS);
    }//GEN-LAST:event_jMenuItem115ActionPerformed

    private void jMenuItem116ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem116ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_MAKEFILE);
    }//GEN-LAST:event_jMenuItem116ActionPerformed

    private void jMenuItem117ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem117ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_D);
    }//GEN-LAST:event_jMenuItem117ActionPerformed

    private void jMenuItem118ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem118ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_DOCKERFILE);
    }//GEN-LAST:event_jMenuItem118ActionPerformed

    private void jMenuItem119ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem119ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_DART);
    }//GEN-LAST:event_jMenuItem119ActionPerformed

    private void jMenuItem120ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem120ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_DELPHI);
    }//GEN-LAST:event_jMenuItem120ActionPerformed

    private void jMenuItem121ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem121ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_DTD);
    }//GEN-LAST:event_jMenuItem121ActionPerformed

    private void jMenuItem123ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem123ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_FORTRAN);
    }//GEN-LAST:event_jMenuItem123ActionPerformed

    private void jMenuItem124ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem124ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_GROOVY);
    }//GEN-LAST:event_jMenuItem124ActionPerformed

    private void jMenuItem122ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem122ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_HOSTS);
    }//GEN-LAST:event_jMenuItem122ActionPerformed

    private void jMenuItem125ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem125ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_HTACCESS);
    }//GEN-LAST:event_jMenuItem125ActionPerformed

    private void jMenuItem126ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem126ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_HTML);
    }//GEN-LAST:event_jMenuItem126ActionPerformed

    private void jMenuItem103ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem103ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_JAVASCRIPT);
    }//GEN-LAST:event_jMenuItem103ActionPerformed

    private void jMenuItem104ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem104ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_JSON);
    }//GEN-LAST:event_jMenuItem104ActionPerformed

    private void jMenuItem105ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem105ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_JSON_WITH_COMMENTS);
    }//GEN-LAST:event_jMenuItem105ActionPerformed

    private void jMenuItem106ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem106ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_JSP);
    }//GEN-LAST:event_jMenuItem106ActionPerformed

    private void jMenuItem107ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem107ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_LATEX);
    }//GEN-LAST:event_jMenuItem107ActionPerformed

    private void jMenuItem127ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem127ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_LESS);
    }//GEN-LAST:event_jMenuItem127ActionPerformed

    private void jMenuItem128ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem128ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_LISP);
    }//GEN-LAST:event_jMenuItem128ActionPerformed

    private void jMenuItem129ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem129ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_LUA);
    }//GEN-LAST:event_jMenuItem129ActionPerformed

    private void jMenuItem131ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem131ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_MAKEFILE);
    }//GEN-LAST:event_jMenuItem131ActionPerformed

    private void jMenuItem132ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem132ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_MXML);
    }//GEN-LAST:event_jMenuItem132ActionPerformed

    private void jMenuItem130ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem130ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_NSIS);
    }//GEN-LAST:event_jMenuItem130ActionPerformed

    private void jMenuItem133ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem133ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_PERL);
    }//GEN-LAST:event_jMenuItem133ActionPerformed

    private void jMenuItem134ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem134ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_PHP);
    }//GEN-LAST:event_jMenuItem134ActionPerformed

    private void jMenuItem135ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem135ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_PROPERTIES_FILE);
    }//GEN-LAST:event_jMenuItem135ActionPerformed

    private void jMenuItem136ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem136ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_PYTHON);
    }//GEN-LAST:event_jMenuItem136ActionPerformed

    private void jMenuItem137ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem137ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_RUBY);
    }//GEN-LAST:event_jMenuItem137ActionPerformed

    private void jMenuItem138ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem138ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_SAS);
    }//GEN-LAST:event_jMenuItem138ActionPerformed

    private void jMenuItem139ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem139ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_SCALA);
    }//GEN-LAST:event_jMenuItem139ActionPerformed

    private void jMenuItem140ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem140ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_SQL);
    }//GEN-LAST:event_jMenuItem140ActionPerformed

    private void jMenuItem141ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem141ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_TCL);
    }//GEN-LAST:event_jMenuItem141ActionPerformed

    private void jMenuItem142ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem142ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_TYPESCRIPT);
    }//GEN-LAST:event_jMenuItem142ActionPerformed

    private void jMenuItem143ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem143ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_UNIX_SHELL);
    }//GEN-LAST:event_jMenuItem143ActionPerformed

    private void jMenuItem144ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem144ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        Editor.get(sel).setSyntaxDocument(SYNTAX_STYLE_VISUAL_BASIC);
    }//GEN-LAST:event_jMenuItem144ActionPerformed

    private void jMenuItem145ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem145ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        String ext = Editor.get(sel).getExt();
        PTEditorKit pt = new PTEditorKit(); pt.setContentType(ext); pt.start();
    }//GEN-LAST:event_jMenuItem145ActionPerformed

    private void jMenuItem146ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem146ActionPerformed
        pluginManager.setVisible(true);
    }//GEN-LAST:event_jMenuItem146ActionPerformed

    private void jMenuItem147ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem147ActionPerformed
        jPanel10.removeAll(); jPanel10.revalidate(); jPanel10.repaint(); jPanel10.add(console); 
        if (consoleInt==1) {
            jPanel10.setVisible(true); jSplitPane1.setDividerLocation(jTabbedPane1.getHeight()/2);
            consoleInt = 0 ;
        } else {
            jPanel10.setVisible(false);
            consoleInt = 1 ;
        }
        
    }//GEN-LAST:event_jMenuItem147ActionPerformed

    
    class read implements Runnable {

        @Override
        public void run() {
            jProgressBar1.setVisible(true);  Reader in = null;
        try {
            int selectedIndex = jTabbedPane1.getSelectedIndex();
            RTextScrollPane scrollPane = (RTextScrollPane) Editor.get(selectedIndex).getScrollPane();
            RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
            File f = new File("C:\\Users\\Thecarisma\\Downloads\\wordpress.2017-05-09.xml");
            textPane.setFile(f);in = new FileReader(f);
            textPane.read(in, "i dont understand"); 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close(); jProgressBar1.setVisible(false); 
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        
    }
    
    private void jMenuItem150ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem150ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RTextScrollPane scrollPane = (RTextScrollPane) Editor.get(selectedIndex).getScrollPane();
        RTextArea textPane = scrollPane.getTextArea(); jMenuItem152.setEnabled(false); jMenuItem153.setEnabled(false); 
        scrollPane.getGutter(); jMenuItem150.setEnabled(false); jMenuItem154.setEnabled(false); 
        jMenuItem151.setEnabled(true); textPane.beginRecordingMacro();
    }//GEN-LAST:event_jMenuItem150ActionPerformed

    private void jMenuItem151ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem151ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex(); jMenuItem153.setEnabled(true);
        RTextScrollPane scrollPane = (RTextScrollPane) Editor.get(selectedIndex).getScrollPane();
        RTextArea textPane = scrollPane.getTextArea();  scrollPane.getGutter();  jMenuItem150.setEnabled(true);
        jMenuItem151.setEnabled(false); textPane.endRecordingMacro(); jMenuItem152.setEnabled(true); jMenuItem154.setEnabled(true); 
    }//GEN-LAST:event_jMenuItem151ActionPerformed

    private void jMenuItem152ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem152ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RTextScrollPane scrollPane = (RTextScrollPane) Editor.get(selectedIndex).getScrollPane();
        RTextArea textPane = scrollPane.getTextArea();
        scrollPane.getGutter();
        textPane.playbackLastMacro();
    }//GEN-LAST:event_jMenuItem152ActionPerformed

    private void jMenuItem153ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem153ActionPerformed
        loadMacro();
    }//GEN-LAST:event_jMenuItem153ActionPerformed

    private void jMenuItem154ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem154ActionPerformed
        try {
            String name = JOptionPane.showInputDialog(rootPane, "Input file name ");
            int selectedIndex = jTabbedPane1.getSelectedIndex();
            RTextScrollPane scrollPane = (RTextScrollPane) Editor.get(selectedIndex).getScrollPane();
            RTextArea textPane = scrollPane.getTextArea(); 
            if (name!=null&&!name.endsWith("xml")) {} else { name = name + ".xml"; }
            textPane.getCurrentMacro().setName(name.replace(".xml", "")); 
            textPane.getCurrentMacro().saveToFile(getMyMacroFolder()+name);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem154ActionPerformed

    private void jCheckBoxMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem4ActionPerformed
        jMenu19.setVisible(false); 
        jPanel3.removeAll(); jPanel3.revalidate(); jPanel3.repaint(); jPanel3.add(macroList);      
       if (!jCheckBoxMenuItem4.isSelected() && jPanel3.isVisible()) {
            jPanel3.setVisible(false); jCheckBoxMenuItem2.setSelected(false); docuselector.setSelected(false);
            jCheckBoxMenuItem4.setSelected(false);
      }else if (jCheckBoxMenuItem4.isSelected()) {
            jPanel3.setVisible(true); jCheckBoxMenuItem4.setSelected(true); jCheckBoxMenuItem2.setSelected(false); 
            docuselector.setSelected(false);
      }
    }//GEN-LAST:event_jCheckBoxMenuItem4ActionPerformed

    private void jMenuItem149ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem149ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RTextScrollPane scrollPane = (RTextScrollPane) Editor.get(selectedIndex).getScrollPane();
        RTextArea textPane = scrollPane.getTextArea(); 
        if (textPane.getLineWrap()==false) {
            textPane.setLineWrap(true);
        } else {
            textPane.setLineWrap(false);
        }
    }//GEN-LAST:event_jMenuItem149ActionPerformed

    private void jMenuItem155ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem155ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RTextScrollPane scrollPane = (RTextScrollPane) Editor.get(selectedIndex).getScrollPane();
        RTextArea textPane = scrollPane.getTextArea(); textPane.convertTabsToSpaces();
    }//GEN-LAST:event_jMenuItem155ActionPerformed

    private void jMenuItem156ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem156ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RTextScrollPane scrollPane = (RTextScrollPane) Editor.get(selectedIndex).getScrollPane();
        RTextArea textPane = scrollPane.getTextArea(); textPane.convertSpacesToTabs();
    }//GEN-LAST:event_jMenuItem156ActionPerformed

    private void jMenuItem160ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem160ActionPerformed
        try {
            int selectedIndex = jTabbedPane1.getSelectedIndex();
            RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
            redTag = textPane.addLineHighlight(textPane.getCaretLineNumber(), new Color(255,0,0, 80));
        } catch (BadLocationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem160ActionPerformed

    private void jMenuItem161ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem161ActionPerformed
        try {
            int selectedIndex = jTabbedPane1.getSelectedIndex();
            RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
            blueTag = textPane.addLineHighlight(textPane.getCaretLineNumber(), new Color(0,0,204,80));
        } catch (BadLocationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem161ActionPerformed

    private void jMenuItem162ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem162ActionPerformed
        try {
            int selectedIndex = jTabbedPane1.getSelectedIndex();
            RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
            yellowTag = textPane.addLineHighlight(textPane.getCaretLineNumber(), new Color(255,255,0,80));
        } catch (BadLocationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem162ActionPerformed

    private void jMenuItem163ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem163ActionPerformed
        try {
            int selectedIndex = jTabbedPane1.getSelectedIndex();
            RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
            greenTag = textPane.addLineHighlight(textPane.getCaretLineNumber(), new Color(0,153,0,80));
        } catch (BadLocationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem163ActionPerformed

    private void jMenuItem164ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem164ActionPerformed
        //Color color = jColorChooser1.;
        try {
            int selectedIndex = jTabbedPane1.getSelectedIndex();
            RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
            customTag = textPane.addLineHighlight(textPane.getCaretLineNumber(), new Color(255,53,12,80));
        } catch (BadLocationException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem164ActionPerformed

    private void jMenuItem165ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem165ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
        textPane.removeLineHighlight(redTag);
    }//GEN-LAST:event_jMenuItem165ActionPerformed

    private void jMenuItem166ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem166ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
        textPane.removeLineHighlight(blueTag);
    }//GEN-LAST:event_jMenuItem166ActionPerformed

    private void jMenuItem167ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem167ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
        textPane.removeLineHighlight(yellowTag);
    }//GEN-LAST:event_jMenuItem167ActionPerformed

    private void jMenuItem168ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem168ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
        textPane.removeLineHighlight(greenTag);
    }//GEN-LAST:event_jMenuItem168ActionPerformed

    private void jMenuItem169ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem169ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
        textPane.removeLineHighlight(customTag);
    }//GEN-LAST:event_jMenuItem169ActionPerformed

    private void jMenuItem170ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem170ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
        textPane.removeAllLineHighlights();
    }//GEN-LAST:event_jMenuItem170ActionPerformed

    private void jMenuItem172ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem172ActionPerformed
            int selectedIndex = jTabbedPane1.getSelectedIndex();
            RTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
            new ClipboardHistoryAction().actionPerformedImpl(evt, textPane);
    }//GEN-LAST:event_jMenuItem172ActionPerformed

    private void jMenuItem173ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem173ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
        new ToggleBookmarkAction().actionPerformedImpl(evt, textPane);
    }//GEN-LAST:event_jMenuItem173ActionPerformed

    private void jMenuItem175ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem175ActionPerformed
            int selectedIndex = jTabbedPane1.getSelectedIndex();
            RTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
            new DeleteLineAction().actionPerformedImpl(evt, textPane);
    }//GEN-LAST:event_jMenuItem175ActionPerformed

    private void jMenuItem176ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem176ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
        textPane.copyAsRtf();
    }//GEN-LAST:event_jMenuItem176ActionPerformed

    private void jMenuItem177ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem177ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
        new LineMoveAction(RTextAreaEditorKit.rtaLineDownAction, 1).actionPerformedImpl(evt, textPane);
    }//GEN-LAST:event_jMenuItem177ActionPerformed

    private void jMenuItem178ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem178ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
        new NextBookmarkAction(RTextAreaEditorKit.rtaNextBookmarkAction, true).actionPerformedImpl(evt, textPane);
    }//GEN-LAST:event_jMenuItem178ActionPerformed

    private void jMenuItem179ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem179ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
        new NextBookmarkAction(RTextAreaEditorKit.rtaPrevBookmarkAction, false).actionPerformedImpl(evt, textPane);
    }//GEN-LAST:event_jMenuItem179ActionPerformed

    private void jMenuItem157ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem157ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
        new InvertSelectionCaseAction().actionPerformedImpl(evt, textPane);
    }//GEN-LAST:event_jMenuItem157ActionPerformed

    private void jMenuItem158ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem158ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(sel).getTextPane();
        textPane.setCaretPosition(SetCursor(cln,textPane));
        String tab  = "\t";
        textPane.replaceSelection(tab);
    }//GEN-LAST:event_jMenuItem158ActionPerformed

    private void jMenuItem159ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem159ActionPerformed
        int sel = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(sel).getTextPane();
        textPane.setCaretPosition(SetCursor(cln, textPane));
        int tabLoc = textPane.getCaret().getDot() ;
        textPane.setSelectionStart(tabLoc); textPane.setSelectionEnd(tabLoc + 1);
        String s = textPane.getSelectedText();
        if (!s.equals("\t")) { System.out.println("Not deletable"); 
        } else { textPane.replaceSelection("");}
    }//GEN-LAST:event_jMenuItem159ActionPerformed

    private void jMenuItem171ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem171ActionPerformed
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
        if (textPane.getCurrentLineHighlightColor()!=null) {
            Object ob  = textPane.getCurrentLineHighlightColor() ;
            textPane.removeLineHighlight(ob); System.out.println("reached here "+ob);

        }
    }//GEN-LAST:event_jMenuItem171ActionPerformed

    private void jMenuItem174ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem174ActionPerformed
        tm = new Theme((RSyntaxTextArea)Editor.get(jTabbedPane1.getSelectedIndex()).getTextPane(), this);
        tm.loadTheme(Main.class.getResourceAsStream("/com/power/text/pteditor/themes/monokai.xml"));
        tm.apply(); themePath = "/com/power/text/pteditor/themes/monokai.xml" ;
    }//GEN-LAST:event_jMenuItem174ActionPerformed

    private void jMenuItem180ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem180ActionPerformed
        tm = new Theme((RSyntaxTextArea)Editor.get(jTabbedPane1.getSelectedIndex()).getTextPane(), this);
        tm.loadTheme(Main.class.getResourceAsStream("/com/power/text/pteditor/themes/pinkprint.xml"));
        tm.apply(); themePath = "/com/power/text/pteditor/themes/pinkprint.xml" ;
    }//GEN-LAST:event_jMenuItem180ActionPerformed

    private void jMenuItem181ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem181ActionPerformed
        tm = new Theme((RSyntaxTextArea)Editor.get(jTabbedPane1.getSelectedIndex()).getTextPane(), this);
        tm.loadTheme(Main.class.getResourceAsStream("/com/power/text/pteditor/themes/default.xml"));
        tm.apply(); themePath = "/com/power/text/pteditor/themes/default.xml" ;
    }//GEN-LAST:event_jMenuItem181ActionPerformed

    private void UndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UndoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UndoActionPerformed

    private void jCheckBoxMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem5ActionPerformed
        fullScreen();
    }//GEN-LAST:event_jCheckBoxMenuItem5ActionPerformed

    private void fullScreen() {
        
        if (!jCheckBoxMenuItem5.isSelected()) {
            setLocation(l, b); dispose(); setUndecorated(false);
             setSize(x, y); setVisible(true);
        } else {
            l = getX(); b = getY(); setLocation(0,0); x = this.getWidth(); 
            y = this.getHeight(); dispose(); setUndecorated(true); 
            setSize(Toolkit.getDefaultToolkit().getScreenSize());
            setVisible(true);
            
        }
    }
    
        Runtime rt ;

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /**
         * try {
            // Set System L&F
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    getTweakLAF(); //this make some unresponding laf component to adpt to theme and deal cruely to scrollbar no mercy
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                System.out.println(getOSAppDataFolder()+" > "+getOSDocumentFolder()+" > "+getOSDependenciesFolder());
                Main main = new Main(); main.repaint();
                String incomming = Arrays.toString(args).replace("[", "");
                String incommingF = incomming.replace("]", "");
                System.out.println(incommingF); main.initiateEditor();
                /*main.loadRecent(); */main.openFromContext(incommingF); main.getSavedSizeAndLocation();
                //using time to check already opened instance
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        
        

                    // wait for read to complete and update tim
    }
    
    public static void getTweakLAF() {
        UIManager.put("ScrollBar.trackHighlightForeground", (new Color(255,255,255,0))); 
        UIManager.put("scrollbar", (new Color(255,255,255,0))); 
        UIManager.put("ScrollBar.thumb", new ColorUIResource(new Color(255,255,255,0))); 
        UIManager.put("ScrollBar.thumbHeight", 1); 
        UIManager.put("ScrollBar.background", (new Color(255,255,255,0)));
        UIManager.put("ScrollBar.thumbDarkShadow", new ColorUIResource(new Color(255,255,255,0)));
        UIManager.put("ScrollBar.thumbShadow", new ColorUIResource(new Color(255,255,255,0)));
        UIManager.put("ScrollBar.thumbHighlight", new ColorUIResource(new Color(255,255,255,0)));
        UIManager.put("ScrollBar.trackForeground", new ColorUIResource(new Color(255,255,255,0)));
        UIManager.put("ScrollBar.trackHighlight", new ColorUIResource(new Color(255,255,255,0)));
        UIManager.put("ScrollBar.foreground", new ColorUIResource(new Color(255,255,255,0)));
        UIManager.put("ScrollBar.shadow", new ColorUIResource(new Color(255,255,255,0)));
        UIManager.put("ScrollBar.highlight", new ColorUIResource(new Color(255,255,255,0)));
        UIManager.put("ScrollBar.width", 10);
        UIManager.getDefaults().put("TabbedPane.contentBorderInsets", new Insets(0,0,0,0));
        UIManager.getDefaults().put("TabbedPane.tabAreaInsets", new Insets(0,0,0,0));
        UIManager.getDefaults().put("TabbedPane.tabsOverlapBorder", true);
    }
    
    public void loadMacro() {
        try {
            int status = macroChooser.showOpenDialog(rootPane);
            if (status == JFileChooser.APPROVE_OPTION) {
                File file = macroChooser.getSelectedFile();
                if (file.getName().endsWith("xml")) {
                    int selectedIndex = jTabbedPane1.getSelectedIndex();
                    RTextScrollPane scrollPane = (RTextScrollPane) Editor.get(selectedIndex).getScrollPane();
                    RTextArea textPane = scrollPane.getTextArea(); 
                    textPane.loadMacro(new Macro(file)); jMenuItem152.setEnabled(true);
                } else {
                   JOptionPane.showMessageDialog(rootPane, "Invalid Macro File", "Invalid Macro", JOptionPane.ERROR_MESSAGE);
                   loadMacro();
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public static int getRow(int pos, JTextComponent editor) {
        int rn = (pos==0) ? 1 : 0;
        try {
            int offs=pos;
            while( offs>0) {
                offs=Utilities.getRowStart(editor, offs)-1;
                rn++;
            }
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        return rn;
    }
    
    public static int getColumn(int pos, JTextComponent editor) {
        try {
            return pos-Utilities.getRowStart(editor, pos)+1;
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    JTextField status = new JTextField();
    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/com/power/text/images/powertext.png")));
    }
    
    public int saveFile(int selectedIndex) {
        String fileName = jTabbedPane1.getTitleAt(selectedIndex); 
        int retVal = this.STATUS_ERROR; String filePath = Editor.get(selectedIndex).getFileDir();
        if (fileName.contains("Untitled")) {
            retVal = saveFileAs(selectedIndex, 0);
        } else {
            BufferedWriter bufferedWriter = null; String fileContent = Editor.get(selectedIndex).getTextPane().getText() ;
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(filePath, false));
                bufferedWriter.write(fileContent);  jTabbedPane1.setIconAt(selectedIndex, new ImageIcon(this.getClass().getResource("/com/power/text/images/save.gif")));
                Editor.get(selectedIndex).setContent(fileContent);
                Editor.get(selectedIndex).setSavedStatus(true); //saveLabel();
                notification.setText(fileName + " is saved");
                retVal = this.STATUS_OK;
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Failed to save file"
                        + fileName);
                retVal = this.STATUS_ERROR;
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Failed to save file"
                        + fileName);
                retVal = this.STATUS_ERROR;
            } finally {
                try {
                    if (bufferedWriter != null) {
                        bufferedWriter.flush();
                        bufferedWriter.close();
                    }
                } catch (IOException ex) {
                    ex.getMessage();
                }
            }
        }
        return retVal;
    }

    public void saveLabel(){
        int sel = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(sel).getTextPane();       
        final long s_time = System.currentTimeMillis();
                readin(currentFile.toString(), textPane);
                double y = System.currentTimeMillis() -
                                   s_time;
                double t = y / 100 ;
                notification.setText(jTabbedPane1.getTitleAt(jTabbedPane1.getSelectedIndex()) + " saved in " + t + " sec");
    }
    
    public void OpenProj(){
        int status = selectDir.showOpenDialog(this);
        if (status == selectDir.APPROVE_OPTION) {
            File files = selectDir.getSelectedFile();
               String  filename = files.getName(); String currentFileDi = files.getPath();
               PTextPTree pt = new PTextPTree(); pt.setTreeDir(currentFileDi);
               Editree.add(pt);
               File file = new File(currentFileDi); FileBrowser fileBrowser = new FileBrowser();
               fileBrowser.run(file);    pt.jTree.setModel(fileBrowser.treeModel);
               jTabbedPane2.add(filename, pt); jTabbedPane2.setSelectedIndex(jTabbedPane2.getTabCount()-1);
        }else {
            System.out.println("No file selected");
        }
    }
    
    public void NewProj() throws IOException{
        newProj.setVisible(true);
    }
    
    public void OpenNPCF(File files){
               String  filename = files.toString();
               String currentFileDi = files.getAbsolutePath();
               String file=filename.substring(filename.lastIndexOf("\\")+1);
            System.out.println("File chosen. File name = " + files.getName());
            //FileExtLabel.FileExtension(); openlabel(); 
            String fileExtL = "Testing File Extension";
            filesHoldListModel.addElement(currentFileDi); String parentFolder = files.getParent();
            try {
                //Now read the contents of file
                Scanner scn = new Scanner(new FileInputStream(files));
                String buffer = "";
                int vc = 0;
                while (scn.hasNext()) {
                    buffer += scn.nextLine() + "\n";
                }if ( listModel.contains(files.getName())){
                    JOptionPane.showMessageDialog(this, files.getName() + " Is Already Opened");
                } else {
                    newFile(files.getName(), currentFileDi, parentFolder, buffer, fileExtL, "file");
                }
                openlabel();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } jTabbedPane2.setSelectedIndex(jTabbedPane2.getTabCount());
    }
    
    /**public void OpenFileT(File files) {
            //File files = file; 
              // String  filename = files.toString();
               //String currentFileDi = files.getAbsolutePath();
               //String filem =filename.substring(filename.lastIndexOf("\\")+1);
            //System.out.println("File chosen. File name = " + fileChooser.getSelectedFile().getName());
            //FileExtLabel.FileExtension(); openlabel(); 
            String fileExtL = fileext.getText();
            //filesHoldListModel.addElement(currentFileDi);
            try {
                //Now read the contents of file
                Scanner scn = new Scanner(new FileInputStream(files));
                String buffer = "";
                int vc = 0;
                while (scn.hasNext()) {
                    buffer += scn.nextLine() + "\n";
                }
                    newFile("kmkmkm", "kmkmkm", buffer, fileExtL, "file");
                //}
                //openlabel();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
   }
     * @param selectedIndex
     * @return  **/
    
	//PRINT FUNCTION
	public String createBuffer(int selectedIndex){
            RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
		String buffer;
		buffer = textPane.getText();
		return buffer;
	}

    public void print(String s){
        int selectedIndex = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
        StringReader sr = new StringReader(s);
		LineNumberReader lnr = new LineNumberReader(sr);
		Font typeface = new Font("Monospaced", Font.PLAIN, 12);
		Properties p = new Properties();
		PrintJob pjob = getToolkit().getPrintJob(this, "Print report", p);

		if (pjob != null) {
			Graphics pg = pjob.getGraphics();
			if (pg != null) {
				FontMetrics fm = pg.getFontMetrics(typeface);
				int margin = 20;
				int pageHeight = pjob.getPageDimension().height - margin;
    			int fontHeight = fm.getHeight();
    			int fontDescent = fm.getDescent();
    			int curHeight = margin;

				String nextLine;
				pg.setFont (textPane.getFont());

				try
				{
					do
					{
						nextLine = lnr.readLine();
						if (nextLine != null) {
							if ((curHeight + fontHeight) > pageHeight)
							{ // New Page
								pg.dispose();
								pg = pjob.getGraphics();
								curHeight = margin;
							}

							curHeight += fontHeight;

							if (pg != null)
							{
								pg.setFont (typeface);
								pg.drawString (nextLine, margin, curHeight - fontDescent);
							}
						}
					}
					while (nextLine != null);

				}
				catch (EOFException eof)
				{
				}
				catch (Throwable t)
				{
				}
			}
			pg.dispose();
		}
		if (pjob != null)
			pjob.end();
	}
    
    public void RunDBnow(String file){
        RunDBrowser.run(file);
    }
   
    
    public void newFile(String fileName, String fileDir, String parentFolder, String fileContent, String fileExt, String ext){
    JCheckBoxMenuItem newWin = new JCheckBoxMenuItem(); checkFileName(fileName);
    PTextEditor addEditor = new PTextEditor(); newWin.setText(name); addEditor.setExt(ext);
    addEditor.getTextPane().setText(fileContent); addEditor.setFileName(name);
    addEditor.setContent(fileContent); addEditor.setParentFolder(parentFolder);
    addEditor.setFileDir(fileDir);
    addEditor.getFileDire().setText(fileDir); String fN = addEditor.getFileName();
    addEditor.getFileExt().setText(fileExt); String FD = addEditor.getFileDir();
    addEditor.setMenuItem(newWin); getNewWinMI(addEditor.getMenuItem(), name); 
    currentFileD = fileDir ;  Editor.add(addEditor);  int index = jTabbedPane1.getTabCount();
                jTabbedPane1.add(fN, addEditor);  jTabbedPane1.setToolTipTextAt(index, fileDir); if (name.contains("Untitled")) {
                jTabbedPane1.setIconAt(index, new ImageIcon(this.getClass().getResource("/com/power/text/images/unsave.gif")));
                } else  {jTabbedPane1.setIconAt(index, new ImageIcon(this.getClass().getResource("/com/power/text/images/save.gif")));}
                //jTabbedPane1.setTabComponentAt(count, new CustomTabButton(jTabbedPane1, this));
                jTabbedPane1.setSelectedIndex(index);  PTEditorKit pt = new PTEditorKit(); pt.setContentType(ext); pt.start();
    listModel.addElement(fN);  addEditor.setIndexNumber(index); fileListModel.addElement(FD);
    jList1.setSelectedIndex(index);  if(!fileName.contains("Untitled")) { notification.setText(fileName+" is opened");} 
    else {notification.setText(fileName+" is created ");}
    //loadDefaultPlugin();
    }
    
    String name = "" ;
    
    public void checkFileName(String nameF) {
       if (nameF.contains("Untitled")) { 
            String[] splitStrings = nameF.split("\\.") ; //[Untitled 0, txt]
            String nameFinal = splitStrings[splitStrings.length-2] ;
            name=nameFinal; 
        } else {
            name = nameF;
        }
    }
        
    public JCheckBoxMenuItem getNewWinMI(JCheckBoxMenuItem newWin, String name){
        //buttonGroup1.add(newWin);jMenu13.add(newWin); 
        documentModel.addElement(name) ;
        newWin.addActionListener((java.awt.event.ActionEvent evt) -> {
        String list_item=newWin.getText().trim();
        Object[] files= filesHoldListModel.toArray();
        if (jTabbedPane1.getTabCount() >0) {
            int tabcount=jTabbedPane1.getTabCount();
            for (int i = 0; i<tabcount; i++) {
                String title1 = jTabbedPane1.getTitleAt(i).trim();
                if (title1.equals(list_item)) {
                    jTabbedPane1.setSelectedIndex(i);
                    titleExtLa.setText(Editor.get(jTabbedPane1.getSelectedIndex()).getFileExt().getText());
                    titleText.setText(jTabbedPane1.getTitleAt(jTabbedPane1.getSelectedIndex()) + "  -  Power Text") ;
                }
                for (Object filename : files) {
                    String file1 = filename.toString().substring(filename.toString().lastIndexOf("\\")+1);
                    String tabtext = jTabbedPane1.getTitleAt(jTabbedPane1.getSelectedIndex()).trim();
                    if (file1.equals(tabtext)) {
                        titleExtLa.setText(Editor.get(jTabbedPane1.getSelectedIndex()).getFileExt().getText());
                        titleText.setText(filename.toString() + "  - Power Text") ;
                    } else {
                        titleExtLa.setText(Editor.get(jTabbedPane1.getSelectedIndex()).getFileExt().getText());
                        titleText.setText(jTabbedPane1.getTitleAt(jTabbedPane1.getSelectedIndex()) + "  - Power Text") ;
                    }
                }
            }
        }
    });
        return newWin ;
    }
   
    public int closeFile(int selectedIndex) {
        int retVal = this.STATUS_ERROR;
        if (retVal != this.STATUS_CANCEL) {
            jMenu13.remove(Editor.get(selectedIndex).getMenuItem()); String tiT = Editor.get(selectedIndex).getFileDire().getText();
            if (tiT.contains("Untitled")) { String dir = Editor.get(selectedIndex).getFileDire().getText();
            File delFile = new File(dir); delFile.deleteOnExit(); } lastClosedFile = Editor.get(selectedIndex).getFileDire().getText();
            jMenuItem85.setEnabled(true) ; Editor.remove(selectedIndex);  listModel.removeElementAt(selectedIndex);
            fileListModel.removeElementAt(selectedIndex); documentModel.removeElementAt(selectedIndex); jTabbedPane1.remove(selectedIndex);   
            jTabbedPane1.getSelectedIndex(); notification.setText(new File(tiT).getName()+" is closed ");
        }
        return retVal;
    }
  
    public void CloseATL(int selectedIndex){
        for (int i = selectedIndex - 1; i >= 0; i--) {
            if (i != selectedIndex) {
                closeFile(i);
            }
        }  
  }
  
    public void CloseATR(int selectedIndex){
        int tabs = jTabbedPane1.getTabCount();
        for (int i = tabs - 1; i >= selectedIndex; i--) {
            if (i != selectedIndex) {
                closeFile(i);
            }
        }  
  }

    private void closeAllButActiveFile() {
        int current = jTabbedPane1.getSelectedIndex();
        int tabs = jTabbedPane1.getTabCount();
        for (int i = tabs - 1; i >= 0; i--) {
            if (i != current) {
                closeFile(i);
            }
        }
    }

    private int saveFileAs(int selectedIndex, int copy) {
        if (Editor.isEmpty()) {
            return this.STATUS_ERROR;
        }
        if (Editor.get(selectedIndex) == null) {
            return this.STATUS_ERROR;
        }
        int retVal;  int retnVal = this.STATUS_ERROR;
        do {
            retVal = this.STATUS_CANCEL;
            int returnVal = filesaveas.showSaveDialog(this);
            if (returnVal == JFileChooser.CANCEL_OPTION) {
                retnVal = this.STATUS_CANCEL;
            } else if (returnVal == JFileChooser.APPROVE_OPTION) {
                File f = filesaveas.getSelectedFile();
                retVal = this.STATUS_OK;
                if (f.exists()) {
                    retVal = JOptionPane.showConfirmDialog(this,
                            "File already exists!\nReplace?");
                    switch (retVal) {
                        case JOptionPane.YES_OPTION:
                            retVal = this.STATUS_OK;
                            break;
                        case JOptionPane.NO_OPTION:
                            retVal = this.STATUS_NO;
                            break;
                        case JOptionPane.CANCEL_OPTION:
                            retVal = this.STATUS_CANCEL;
                            break;
                        default:
                            break;
                    }
                }
                if (retVal == this.STATUS_OK) {
                    try { int downFile = jTabbedPane1.getSelectedIndex();
                        DataOutputStream d = new DataOutputStream(new FileOutputStream(f));
                        String line = Editor.get(downFile).getTextPane().getText();
                        d.writeBytes(line);
                        d.close(); Scanner scn = new Scanner(new FileInputStream(f));
                        openFile(f, scn);
                        retVal = this.STATUS_ERROR; if (copy==0) { closeFile(downFile); }
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } }
         while (retVal == this.STATUS_NO);
        if (retnVal == this.STATUS_OK) {
            
        }
        return retnVal;
    }

    
    final DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        
    ActionListener timerListener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Date date = new Date(); 
                jList1.setSelectedIndex(jTabbedPane1.getSelectedIndex());
                String time = timeFormat.format(date);
                timeLabel.setText(time); 
            }
        };
        
    ActionListener statusListener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e)
            { if  (jTabbedPane1.getTabCount() > 0) {
                //5 seconds fire
                notification.setText("");
            }}
        };
        
    ActionListener statustime = new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if (jTabbedPane1.getTabCount() > 0) {
                    setTitle(titleText.getText()  + "  - Power Text");
                } else {
                    setTitle("Power Text");
                } checkFileContent();  getSelected(); checkRightClickContext();
            }
        };
    
    public void checkRightClickContext() {
        File inFile = new File(getOSAppDataFolder()+"incoming.pteditor");
        if (inFile.exists()) {
            BufferedWriter bufferedWriter ;
            try {
                String text = new String(Files.readAllBytes(Paths.get(inFile.getAbsolutePath())), StandardCharsets.UTF_8);
                if (new File(text).isFile()&&!fileListModel.contains(text)) {
                    Scanner scn = new Scanner(new FileInputStream(new File(text)));
                    openFile(new File(text), scn); addRecent(new File(text).getAbsolutePath());
                    bufferedWriter = new BufferedWriter(new FileWriter(inFile.getAbsolutePath(), false));
                    bufferedWriter.write(""); bufferedWriter.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void getSelected() {
        if (jTabbedPane1.getTabCount()>0) {
                int selectedIndex = jTabbedPane1.getSelectedIndex();
                RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
                jLabel8.setText(textPane.getSelectedText());
                String selectetedText = textPane.getSelectedText(); sel = selectetedText+"";
                /*notification.setText(sel); */if (sel.length() < 20) {
                jMenuItem59.setText("Search - "+ sel +" - In Google");} else { jMenuItem59.setText("Search - "+ "Selected Text" +" - In Google"); }
        }
    }
        
    public void checkFileContent() {
           if (jTabbedPane1.getTabCount() > 0) {
                fileext.setText(titleExtLa.getText()); int selectedIndex = jTabbedPane1.getSelectedIndex(); String tiT = jTabbedPane1.getTitleAt(selectedIndex);
                RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(selectedIndex).getTextPane();
                String fileContent = Editor.get(selectedIndex).getContent(); String currentContent = textPane.getText(); 
                File checkFile = new File(titleText.getText());
                if (textPane.isEditable() && tiT.contains("Untitled")||!fileContent.equals(currentContent)) {
                        jTabbedPane1.setIconAt(selectedIndex, new ImageIcon(this.getClass().getResource("/com/power/text/images/unsave.gif")));
                        Editor.get(selectedIndex).setSavedStatus(false); saveUntitled();
                } else if (textPane.isEditable() && fileContent.equals(currentContent)) {
                        jTabbedPane1.setIconAt(selectedIndex, new ImageIcon(this.getClass().getResource("/com/power/text/images/save.gif")));
                        Editor.get(selectedIndex).setSavedStatus(true);
                } else if (!textPane.isEditable()) {
                        jTabbedPane1.setIconAt(selectedIndex, new ImageIcon(this.getClass().getResource("/com/power/text/images/noteditable.gif")));
                } if (!checkFile.exists()&&!tiT.contains("Untitled")) {
                        int retVal = JOptionPane.showConfirmDialog(this,
                            "File "+tiT+" Does Not Exist Anymore"
                            + "\n Do You Will Wish To Save It ");
                        notification.setText(tiT+" Does Not Exist Anymore ");
                        switch (retVal) {
                            case JOptionPane.YES_OPTION:
                                saveFileAs(selectedIndex, 0);
                                break;
                            case JOptionPane.NO_OPTION:
                                closeFile(selectedIndex);
                                break;
                            case JOptionPane.CANCEL_OPTION:
                                jTabbedPane1.setIconAt(selectedIndex, new ImageIcon(this.getClass().getResource("/power/text/images/unsave.gif")));
                                Editor.get(selectedIndex).setSavedStatus(false);
                                break;
                            default:
                                break;
                        }
                }
                }
       }
    
    public void saveUntitled() {
        int sel = jTabbedPane1.getSelectedIndex(); if (jTabbedPane1.getTitleAt(sel).contains("Untitled")) { try { 
            String filePath = Editor.get(sel).getFileDire().getText();
            BufferedWriter bufferedWriter = null; String fileContent = Editor.get(sel).getTextPane().getText() ;
            bufferedWriter = new BufferedWriter(new FileWriter(filePath, false));
            bufferedWriter.write(fileContent);  //jTabbedPane1.setIconAt(selectedIndex, new ImageIcon(this.getClass().getResource("/power/text/images/save.gif")));
            Editor.get(sel).setContent(fileContent); Editor.get(sel).setSavedStatus(false); 
            bufferedWriter.flush(); bufferedWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } }
    }
 
    public void closeAllFiles() throws IndexOutOfBoundsException {// taber = 1;
     int tabs = jTabbedPane1.getTabCount();
     for (int i = tabs - 1; i >= 0; i--) {
         closeFile(i);
     } 
    }       
 
	//FUNCTION TO OPEN THE FILE
    public void openFile(File files, Scanner scn) {
               String  filename = files.toString();
               String currentFileDi = files.getAbsolutePath();
               String file=filename.substring(filename.lastIndexOf("\\")+1);
            System.out.println("File chosen. File name = " + files.getName());
            FileExtLabel.FileExtension(files); openlabel(); String[] splitStrings = files.getName().split("\\.") ;
            String extension = splitStrings[splitStrings.length-1] ;  String fileExtL = fileext.getText();
            filesHoldListModel.addElement(currentFileDi); String parentFolder = files.getParent();
            //try {
                //Now read the contents of file
                //Scanner scn = new Scanner(new FileInputStream(files));
                String buffer = "";
                while (scn.hasNext()) {
                    buffer += scn.nextLine() + "\n";
                }if ( listModel.contains(files.getName())){
                    alreadyOpened(files.getName());
                } else { 
                    newFile(files.getName(), currentFileDi, parentFolder, buffer, fileExtL, extension);
                }
                openlabel();
   }
   
   private void alreadyOpened(String title) {
       if(jList1.getSelectedValue()!=null)
                  {
                      if(jTabbedPane1.getTabCount() >0)
                      {
                          int tabcount=jTabbedPane1.getTabCount();
                         for(int i=0;i<tabcount;i++)
                          { 
                             jTabbedPane1.setSelectedIndex(i);   
                          }
                      }

                  }
   } 
    
   public void openlabel(){
       if (currentFile != null) { 
                int sel = jTabbedPane1.getSelectedIndex();
        RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(sel).getTextPane();
               final long s_time = System.currentTimeMillis();
                readin(currentFile.toString(), textPane);
                double y = System.currentTimeMillis() -
                                   s_time;
                double t = y / 100;
                notification.setText(currentFile.getName() + " opened in " + t + " sec");
            }
   }




    /**
     * Thread to load a file into the text storage model
     * @param sel
     */


 public void Copy(int sel)
    {
        if (jTabbedPane1.getTabCount() > 0)
        {
            RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(sel).getTextPane();
            String selected_text = textPane.getSelectedText();
            StringSelection ss = new StringSelection(selected_text);
            clip.setContents(ss, ss);
            copylistModel.addElement(selected_text);
        }
    }
 
 public void Paste()
    {
        if (jTabbedPane1.getTabCount() > 0)
        {
            int sel = jTabbedPane1.getSelectedIndex();
            RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(sel).getTextPane();
            Transferable cliptran = clip.getContents(Main.this);
            try
            {
                String selected_text = (String) cliptran.getTransferData(DataFlavor.stringFlavor);
                textPane.replaceSelection(selected_text);
            }
            catch (Exception exc)
            {
                System.out.println("error to paste");
            }
        }
    }

    public void Cut()
    {
        if(jTabbedPane1.getTabCount()>0)
        {
            int sel = jTabbedPane1.getSelectedIndex();
            RSyntaxTextArea textPane = (RSyntaxTextArea) Editor.get(sel).getTextPane();
            String selected_text = textPane.getSelectedText();
            StringSelection ss = new StringSelection(selected_text);
            clip.setContents(ss, ss); copylistModel.addElement(selected_text);
            textPane.replaceSelection("");

            String tabtext = jTabbedPane1.getTitleAt(sel);
            if (tabtext.contains("*"))
            {  }
            else
            {
                jTabbedPane1.setTitleAt(sel, jTabbedPane1.getTitleAt(sel) + "*");
                //jTabbedPane1.setIconAt(sel, new ImageIcon(this.getClass().getResource("resources/unsaved.png")));
            }
        }
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Tcopy;
    public javax.swing.JButton Tcut;
    public javax.swing.JButton Tdf;
    public javax.swing.JButton Tif;
    public javax.swing.JButton TnewFile;
    public javax.swing.JButton TopenFile;
    public static javax.swing.JLabel Totalsel;
    public javax.swing.JButton Tpaste;
    public javax.swing.JButton Tprint;
    public static javax.swing.JButton Tredo;
    public javax.swing.JButton TsaveFile;
    public javax.swing.JButton TsaveFile1;
    public javax.swing.JButton Tsf;
    public static javax.swing.JButton Tundo;
    public static javax.swing.JMenuItem Undo;
    public javax.swing.JMenuItem Undo1;
    public javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JLabel cal;
    public javax.swing.JCheckBoxMenuItem cliphist;
    public static javax.swing.JMenu codeMenu;
    public javax.swing.JLabel dateLabel;
    public javax.swing.JCheckBoxMenuItem docuselector;
    public static javax.swing.JRadioButtonMenuItem editableMI;
    public javax.swing.JButton editoronly;
    public static javax.swing.JFileChooser fileChooser;
    public static javax.swing.JLabel fileext;
    public static javax.swing.JFileChooser filesave;
    public static javax.swing.JFileChooser filesaveas;
    public javax.swing.JTextField incresearch;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    public javax.swing.JButton jButton5;
    public javax.swing.JButton jButton6;
    public javax.swing.JButton jButton7;
    public javax.swing.JButton jButton8;
    public javax.swing.JButton jButton9;
    public javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    public javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    public javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    public javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem4;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem5;
    public javax.swing.JColorChooser jColorChooser1;
    public javax.swing.JDialog jDialog1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel15;
    public javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel500;
    public static javax.swing.JLabel jLabel501;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public static javax.swing.JList<String> jList1;
    public static javax.swing.JList<String> jList2;
    public static javax.swing.JList<String> jList3;
    public javax.swing.JMenu jMenu1;
    public javax.swing.JMenu jMenu10;
    public javax.swing.JMenu jMenu11;
    public javax.swing.JMenu jMenu12;
    public javax.swing.JMenu jMenu13;
    public javax.swing.JMenu jMenu14;
    public javax.swing.JMenu jMenu15;
    public javax.swing.JMenu jMenu16;
    public javax.swing.JMenu jMenu17;
    public javax.swing.JMenu jMenu18;
    public javax.swing.JMenu jMenu19;
    public javax.swing.JMenu jMenu2;
    public javax.swing.JMenu jMenu20;
    public javax.swing.JMenu jMenu21;
    public javax.swing.JMenu jMenu22;
    public javax.swing.JMenu jMenu23;
    public javax.swing.JMenu jMenu24;
    public javax.swing.JMenu jMenu25;
    public javax.swing.JMenu jMenu26;
    public javax.swing.JMenu jMenu27;
    public javax.swing.JMenu jMenu28;
    public javax.swing.JMenu jMenu29;
    public javax.swing.JMenu jMenu3;
    public javax.swing.JMenu jMenu30;
    public javax.swing.JMenu jMenu31;
    public javax.swing.JMenu jMenu32;
    public javax.swing.JMenu jMenu33;
    public javax.swing.JMenu jMenu34;
    public javax.swing.JMenu jMenu35;
    public javax.swing.JMenu jMenu36;
    public javax.swing.JMenu jMenu4;
    public javax.swing.JMenu jMenu5;
    public static javax.swing.JMenu jMenu6;
    public javax.swing.JMenu jMenu7;
    public javax.swing.JMenu jMenu8;
    public static javax.swing.JMenu jMenu9;
    public javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem jMenuItem1;
    public javax.swing.JMenuItem jMenuItem10;
    public javax.swing.JMenuItem jMenuItem100;
    public javax.swing.JMenuItem jMenuItem101;
    public javax.swing.JMenuItem jMenuItem102;
    public javax.swing.JMenuItem jMenuItem103;
    public javax.swing.JMenuItem jMenuItem104;
    public javax.swing.JMenuItem jMenuItem105;
    public javax.swing.JMenuItem jMenuItem106;
    public javax.swing.JMenuItem jMenuItem107;
    public javax.swing.JMenuItem jMenuItem108;
    public javax.swing.JMenuItem jMenuItem109;
    public javax.swing.JMenuItem jMenuItem11;
    public javax.swing.JMenuItem jMenuItem110;
    public javax.swing.JMenuItem jMenuItem111;
    public javax.swing.JMenuItem jMenuItem112;
    public javax.swing.JMenuItem jMenuItem113;
    public javax.swing.JMenuItem jMenuItem114;
    public javax.swing.JMenuItem jMenuItem115;
    public javax.swing.JMenuItem jMenuItem116;
    public javax.swing.JMenuItem jMenuItem117;
    public javax.swing.JMenuItem jMenuItem118;
    public javax.swing.JMenuItem jMenuItem119;
    public javax.swing.JMenuItem jMenuItem12;
    public javax.swing.JMenuItem jMenuItem120;
    public javax.swing.JMenuItem jMenuItem121;
    public javax.swing.JMenuItem jMenuItem122;
    public javax.swing.JMenuItem jMenuItem123;
    public javax.swing.JMenuItem jMenuItem124;
    public javax.swing.JMenuItem jMenuItem125;
    public javax.swing.JMenuItem jMenuItem126;
    public javax.swing.JMenuItem jMenuItem127;
    public javax.swing.JMenuItem jMenuItem128;
    public javax.swing.JMenuItem jMenuItem129;
    public javax.swing.JMenuItem jMenuItem13;
    public javax.swing.JMenuItem jMenuItem130;
    public javax.swing.JMenuItem jMenuItem131;
    public javax.swing.JMenuItem jMenuItem132;
    public javax.swing.JMenuItem jMenuItem133;
    public javax.swing.JMenuItem jMenuItem134;
    public javax.swing.JMenuItem jMenuItem135;
    public javax.swing.JMenuItem jMenuItem136;
    public javax.swing.JMenuItem jMenuItem137;
    public javax.swing.JMenuItem jMenuItem138;
    public javax.swing.JMenuItem jMenuItem139;
    public javax.swing.JMenuItem jMenuItem14;
    public javax.swing.JMenuItem jMenuItem140;
    public javax.swing.JMenuItem jMenuItem141;
    public javax.swing.JMenuItem jMenuItem142;
    public javax.swing.JMenuItem jMenuItem143;
    public javax.swing.JMenuItem jMenuItem144;
    public javax.swing.JMenuItem jMenuItem145;
    public javax.swing.JMenuItem jMenuItem146;
    public javax.swing.JMenuItem jMenuItem147;
    public javax.swing.JMenuItem jMenuItem149;
    public javax.swing.JMenuItem jMenuItem15;
    public javax.swing.JMenuItem jMenuItem150;
    public javax.swing.JMenuItem jMenuItem151;
    public static javax.swing.JMenuItem jMenuItem152;
    public javax.swing.JMenuItem jMenuItem153;
    public javax.swing.JMenuItem jMenuItem154;
    public javax.swing.JMenuItem jMenuItem155;
    public javax.swing.JMenuItem jMenuItem156;
    public javax.swing.JMenuItem jMenuItem157;
    public javax.swing.JMenuItem jMenuItem158;
    public javax.swing.JMenuItem jMenuItem159;
    public javax.swing.JMenuItem jMenuItem16;
    public javax.swing.JMenuItem jMenuItem160;
    public javax.swing.JMenuItem jMenuItem161;
    public javax.swing.JMenuItem jMenuItem162;
    public javax.swing.JMenuItem jMenuItem163;
    public javax.swing.JMenuItem jMenuItem164;
    public javax.swing.JMenuItem jMenuItem165;
    public javax.swing.JMenuItem jMenuItem166;
    public javax.swing.JMenuItem jMenuItem167;
    public javax.swing.JMenuItem jMenuItem168;
    public javax.swing.JMenuItem jMenuItem169;
    public javax.swing.JMenuItem jMenuItem17;
    public javax.swing.JMenuItem jMenuItem170;
    public javax.swing.JMenuItem jMenuItem171;
    public javax.swing.JMenuItem jMenuItem172;
    public javax.swing.JMenuItem jMenuItem173;
    public javax.swing.JMenuItem jMenuItem174;
    public javax.swing.JMenuItem jMenuItem175;
    public javax.swing.JMenuItem jMenuItem176;
    public javax.swing.JMenuItem jMenuItem177;
    public javax.swing.JMenuItem jMenuItem178;
    public javax.swing.JMenuItem jMenuItem179;
    public javax.swing.JMenuItem jMenuItem18;
    public javax.swing.JMenuItem jMenuItem180;
    public javax.swing.JMenuItem jMenuItem181;
    public javax.swing.JMenuItem jMenuItem19;
    public javax.swing.JMenuItem jMenuItem2;
    public javax.swing.JMenuItem jMenuItem20;
    public javax.swing.JMenuItem jMenuItem21;
    public javax.swing.JMenuItem jMenuItem22;
    public javax.swing.JMenuItem jMenuItem23;
    public javax.swing.JMenuItem jMenuItem24;
    public javax.swing.JMenuItem jMenuItem25;
    public javax.swing.JMenuItem jMenuItem26;
    public javax.swing.JMenuItem jMenuItem27;
    public javax.swing.JMenuItem jMenuItem28;
    public javax.swing.JMenuItem jMenuItem29;
    public javax.swing.JMenuItem jMenuItem3;
    public javax.swing.JMenuItem jMenuItem30;
    public javax.swing.JMenuItem jMenuItem31;
    public javax.swing.JMenuItem jMenuItem32;
    public javax.swing.JMenuItem jMenuItem33;
    public javax.swing.JMenuItem jMenuItem34;
    public javax.swing.JMenuItem jMenuItem35;
    public javax.swing.JMenuItem jMenuItem36;
    public javax.swing.JMenuItem jMenuItem37;
    public javax.swing.JMenuItem jMenuItem38;
    public javax.swing.JMenuItem jMenuItem39;
    public javax.swing.JMenuItem jMenuItem4;
    public javax.swing.JMenuItem jMenuItem40;
    public javax.swing.JMenuItem jMenuItem41;
    public javax.swing.JMenuItem jMenuItem42;
    public javax.swing.JMenuItem jMenuItem43;
    public javax.swing.JMenuItem jMenuItem44;
    public javax.swing.JMenuItem jMenuItem45;
    public javax.swing.JMenuItem jMenuItem46;
    public javax.swing.JMenuItem jMenuItem47;
    public javax.swing.JMenuItem jMenuItem48;
    public javax.swing.JMenuItem jMenuItem49;
    public javax.swing.JMenuItem jMenuItem5;
    public javax.swing.JMenuItem jMenuItem50;
    public javax.swing.JMenuItem jMenuItem51;
    public javax.swing.JMenuItem jMenuItem52;
    public javax.swing.JMenuItem jMenuItem53;
    public javax.swing.JMenuItem jMenuItem54;
    public javax.swing.JMenuItem jMenuItem55;
    public javax.swing.JMenuItem jMenuItem56;
    public javax.swing.JMenuItem jMenuItem57;
    public javax.swing.JMenuItem jMenuItem58;
    public static javax.swing.JMenuItem jMenuItem59;
    public javax.swing.JMenuItem jMenuItem6;
    public javax.swing.JMenuItem jMenuItem60;
    public javax.swing.JMenuItem jMenuItem61;
    public javax.swing.JMenuItem jMenuItem62;
    public javax.swing.JMenuItem jMenuItem63;
    public javax.swing.JMenuItem jMenuItem64;
    public javax.swing.JMenuItem jMenuItem65;
    public javax.swing.JMenuItem jMenuItem66;
    public javax.swing.JMenuItem jMenuItem67;
    public javax.swing.JMenuItem jMenuItem68;
    public javax.swing.JMenuItem jMenuItem69;
    public javax.swing.JMenuItem jMenuItem7;
    public javax.swing.JMenuItem jMenuItem70;
    public javax.swing.JMenuItem jMenuItem71;
    public javax.swing.JMenuItem jMenuItem72;
    public javax.swing.JMenuItem jMenuItem73;
    public javax.swing.JMenuItem jMenuItem74;
    public javax.swing.JMenuItem jMenuItem75;
    public javax.swing.JMenuItem jMenuItem76;
    public javax.swing.JMenuItem jMenuItem77;
    public javax.swing.JMenuItem jMenuItem78;
    public javax.swing.JMenuItem jMenuItem79;
    public javax.swing.JMenuItem jMenuItem8;
    public javax.swing.JMenuItem jMenuItem80;
    public javax.swing.JMenuItem jMenuItem81;
    public javax.swing.JMenuItem jMenuItem82;
    public javax.swing.JMenuItem jMenuItem83;
    public javax.swing.JMenuItem jMenuItem84;
    public javax.swing.JMenuItem jMenuItem85;
    public javax.swing.JMenuItem jMenuItem86;
    public javax.swing.JMenuItem jMenuItem87;
    public javax.swing.JMenuItem jMenuItem88;
    public javax.swing.JMenuItem jMenuItem89;
    public javax.swing.JMenuItem jMenuItem9;
    public javax.swing.JMenuItem jMenuItem90;
    public javax.swing.JMenuItem jMenuItem91;
    public javax.swing.JMenuItem jMenuItem92;
    public javax.swing.JMenuItem jMenuItem93;
    public javax.swing.JMenuItem jMenuItem94;
    public javax.swing.JMenuItem jMenuItem95;
    public javax.swing.JMenuItem jMenuItem96;
    public javax.swing.JMenuItem jMenuItem97;
    public javax.swing.JMenuItem jMenuItem98;
    public javax.swing.JMenuItem jMenuItem99;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel10;
    public javax.swing.JPanel jPanel11;
    public javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    public javax.swing.JPanel jPanel5;
    public javax.swing.JPanel jPanel6;
    public javax.swing.JPanel jPanel7;
    public javax.swing.JPanel jPanel8;
    public javax.swing.JPanel jPanel9;
    public javax.swing.JPopupMenu jPopupMenu2;
    public static javax.swing.JProgressBar jProgressBar1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    public javax.swing.JSeparator jSeparator2;
    public javax.swing.JPopupMenu.Separator jSeparator3;
    public javax.swing.JPopupMenu.Separator jSeparator4;
    public javax.swing.JPopupMenu.Separator jSeparator5;
    public javax.swing.JPopupMenu.Separator jSeparator6;
    public javax.swing.JPopupMenu.Separator jSeparator7;
    public javax.swing.JPopupMenu.Separator jSeparator8;
    public javax.swing.JPopupMenu.Separator jSeparator9;
    public javax.swing.JSlider jSlider1;
    public javax.swing.JSplitPane jSplitPane1;
    public static javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTabbedPane jTabbedPane2;
    public javax.swing.JToggleButton jToggleButton1;
    public javax.swing.JToggleButton jToggleButton2;
    public javax.swing.JToggleButton jToggleButton3;
    public javax.swing.JToolBar jToolBar1;
    public javax.swing.JPopupMenu.Separator line1;
    public javax.swing.JPopupMenu.Separator line10;
    public javax.swing.JPopupMenu.Separator line11;
    public javax.swing.JPopupMenu.Separator line12;
    public javax.swing.JPopupMenu.Separator line13;
    public javax.swing.JPopupMenu.Separator line14;
    public javax.swing.JPopupMenu.Separator line15;
    public javax.swing.JPopupMenu.Separator line16;
    public javax.swing.JPopupMenu.Separator line17;
    public javax.swing.JPopupMenu.Separator line18;
    public javax.swing.JPopupMenu.Separator line19;
    public javax.swing.JPopupMenu.Separator line2;
    public javax.swing.JPopupMenu.Separator line3;
    public javax.swing.JPopupMenu.Separator line4;
    public javax.swing.JPopupMenu.Separator line5;
    public javax.swing.JPopupMenu.Separator line6;
    public javax.swing.JPopupMenu.Separator line7;
    public javax.swing.JPopupMenu.Separator line8;
    public javax.swing.JPopupMenu.Separator line9;
    public javax.swing.JFileChooser macroChooser;
    public javax.swing.JPanel macroList;
    public javax.swing.JMenu menuItem;
    public javax.swing.JMenuItem menuclear;
    public javax.swing.JMenuItem menuclear1;
    public javax.swing.JMenuItem menucopy;
    public javax.swing.JMenuItem menucopy1;
    public javax.swing.JMenuItem menucut;
    public javax.swing.JMenuItem menucut1;
    public javax.swing.JMenuItem menupaste;
    public javax.swing.JMenuItem menupaste1;
    public javax.swing.JLabel notification;
    public javax.swing.JLabel osEncoding;
    public static javax.swing.JMenu pluginMenu;
    public static javax.swing.JMenuItem redo;
    public javax.swing.JMenuItem redoaction1;
    public javax.swing.JFileChooser saveStateD;
    public static javax.swing.JTextField searchbox;
    public javax.swing.JButton searchbutton;
    public javax.swing.JFileChooser selectDir;
    public static javax.swing.JLabel statusLabel;
    public javax.swing.JPanel statusPanel;
    public javax.swing.JPanel statusPanel1;
    public javax.swing.JLabel timeLabel;
    public javax.swing.JCheckBoxMenuItem togglecaretpos;
    public javax.swing.JCheckBoxMenuItem togglesearch;
    public javax.swing.JCheckBoxMenuItem toggletimeelapsed;
    public javax.swing.JCheckBoxMenuItem toggletoolbar;
    public javax.swing.JCheckBoxMenuItem toglecal;
    public javax.swing.JCheckBoxMenuItem togledate;
    public javax.swing.JCheckBoxMenuItem togleselection;
    public javax.swing.JCheckBoxMenuItem toglestatuspanel;
    public javax.swing.JCheckBoxMenuItem togletime;
    public javax.swing.JPanel toolbar;
    // End of variables declaration//GEN-END:variables
   
    
    /**
     *
     */




          //********************************************************
          // actions when frame is loading & closing
          //********************************************************
          class Load_Close_Frame_Action extends WindowAdapter
          {
              public void windowOpened(WindowEvent evt)
              {
                  //File_New_Action();
              }

              public void windowClosing(WindowEvent evt)
              {
                  //closeAllFiles();
                  if (jTabbedPane1.getTabCount() == 0)
                  {
                      System.exit(0);
                  }
              }
          }



public class PerformUndoAction extends AbstractAction
    {
       UndoManager _manager;

        public PerformUndoAction(UndoManager manager)
        {
            this._manager = manager;
        }

        public void actionPerformed(ActionEvent evt)
        {
            try
            {
                _manager.undo();
            }
            catch (CannotUndoException e)
            {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
    
    public class PerformRedoAction extends AbstractAction
    {
       UndoManager _manager;

        public PerformRedoAction(UndoManager manager)
        {
            this._manager = manager;
        }

        public void actionPerformed(ActionEvent evt)
        {
            try
            {
                _manager.redo();
            }
            catch (CannotRedoException e)
            {
                Toolkit.getDefaultToolkit().beep();
            }
        }
    }
  
  }


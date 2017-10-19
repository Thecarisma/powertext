/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.FileLibrary;

import java.io.File;
import static com.power.text.Main.fileext;

/**
 *
 * @author thecarisma
 */
public class FileExtLabel {
    
    public static void FileExtension(File file){
       String[] splitStrings = file.getName().split("\\.") ;
       String extension = splitStrings[splitStrings.length-1] ;
       //fileext.setText(extension);
       if ("txt".equals(extension) || "text".equals(extension)) {
                  fileext.setText("Plain Text");
       } else if ("xml".equals(extension) || "xaml".equals(extension) || "xsl".equals(extension) || "xslt".equals(extension) || "xsd".equals(extension)
                || "xul".equals(extension) || "kml".equals(extension) || "suq".equals(extension) || "mxml".equals(extension) || "xsml".equals(extension)
                || "wsdl".equals(extension) || "xlf".equals(extension) || "xliff".equals(extension) || "xbl".equals(extension) || "sxbl".equals(extension)
                || "sitemap".equals(extension) || "gml".equals(extension) || "gpx".equals(extension) || "plist".equals(extension)) {
                  fileext.setText("eXtensible Markup Language");
       } else if ("css".equals(extension)) {
                  fileext.setText("Cascade Style Sheet");
       } else if ("html".equals(extension) || "shtml".equals(extension) || "xhtml".equals(extension) || "htm".equals(extension)
                  || "hmt".equals(extension) || "shtm".equals(extension) || "xht".equals(extension) || "hta".equals(extension)) {
                  fileext.setText("HyperText Markup Language");
       } else if ("as".equals(extension) || "mx".equals(extension)) {
                  fileext.setText("Flash ActionScript File");
       } else if ("asm".equals(extension)) {
                  fileext.setText("Assembly Language");
       } else if ("ada".equals(extension) || "ads".equals(extension) || "adb".equals(extension)) {
                  fileext.setText("Ada File");
       }  else if ("asp".equals(extension)) {
                  fileext.setText("Active Server Page Script");
       } else if ("au3".equals(extension)) {
                  fileext.setText("Autolt");
       } else if ("bash".equals(extension) || "sh".equals(extension) || "bsh".equals(extension)|| "csh".equals(extension)) {
                  fileext.setText("Unix Script File");
       } else if ("bat".equals(extension) || "cmd".equals(extension) || "nt".equals(extension)) {
                  fileext.setText("Batch File");
       } else if ("c".equals(extension) || "lex".equals(extension) ) {
                  fileext.setText("C ");
       } else if ("bbcode".equals(extension)) {
                  fileext.setText("BBCode File ");
       } else if ("clojure".equals(extension)) {
                  fileext.setText("CLOJURE File ");
       } else if ("ml".equals(extension) || "mli".equals(extension) || "sml".equals(extension) || "thy".equals(extension)) {
                  fileext.setText("Categorical Abstract Manchine Language");
       } else if ("cmake".equals(extension)) {
                  fileext.setText("C Make ");
       } else if ("cbl".equals(extension) || "cbf".equals(extension) || "cdb".equals(extension) || "cdc".equals(extension) || "cob".equals(extension)) {
                  fileext.setText("Common Business Oriented Language");
       } else if ("litcofee".equals(extension)) {
                  fileext.setText("Cofee Script");
       } else if ("h".equals(extension) || "hpp".equals(extension) || "hxx".equals(extension) || "cpp".equals(extension) || "cxx".equals(extension) || "cc".equals(extension)) {
                  fileext.setText("C++");
       } else if ("cs".equals(extension)) {
                  fileext.setText("C# Sharp");
       } else if ("d".equals(extension)) {
                  fileext.setText("D Language");
       } else if ("diff".equals(extension) || "patch".equals(extension)) {
                  fileext.setText("Diff File");
       } else if ("dockerfile".equals(extension)) {
                  fileext.setText("Dockerfile File");
       } else if ("dart".equals(extension)) {
                  fileext.setText("Dart File");
       } else if ("delphi".equals(extension)) {
                  fileext.setText("Delphi File");
       } else if ("dtd".equals(extension)) {
                  fileext.setText("DTD File");
       } else if ("f".equals(extension) || "for".equals(extension) || "f90".equals(extension) || "f95".equals(extension) || "f2k".equals(extension) || "f23".equals(extension)) {
                  fileext.setText("Fortran Free Form");
       } else if ("f77".equals(extension)) {
                  fileext.setText("Fortran Fixed Form");
       } else if ("hs".equals(extension) || "lsh".equals(extension) || "las".equals(extension)) {
                  fileext.setText("Haskell");
       } else if ("groovy".equals(extension)) {
                  fileext.setText("Groovy File");
       } else if ("hosts".equals(extension)) {
                  fileext.setText("Hosts File");
       } else if ("htaccess".equals(extension)) {
                  fileext.setText("Htaccess File");
       } else if ("ini".equals(extension) || "inf".equals(extension) || "reg".equals(extension) || "url".equals(extension) || "wer".equals(extension)) {
                  fileext.setText("MS Ini");
       } else if ("iss".equals(extension)) {
                  fileext.setText("Inno Setup Script");
       } else if ("jsm".equals(extension) || "js".equals(extension) || "jsx".equals(extension) || "ts".equals(extension) || "tsx".equals(extension)) {
                  fileext.setText("JavaScript");
       } else if ("json".equals(extension)) {
                  fileext.setText("JSON");
       } else if ("jsp".equals(extension)) {
                  fileext.setText("JavaServer Page Script");
       } else if ("kix".equals(extension)) {
                  fileext.setText("KiXtart");
       } else if ("lsp".equals(extension) || "lisp".equals(extension)) {
                  fileext.setText("List Processing Langusge");
       } else if ("lua".equals(extension)) {
                  fileext.setText("Lua Source");
       } else if ("mak".equals(extension)) {
                  fileext.setText("MakeFile");
       } else if ("m".equals(extension)) {
                  fileext.setText("MATrix LABoratory");
       } else if ("nfo".equals(extension)) {
                  fileext.setText("MDOS Style/ASCII Arts");
       } else if ("less".equals(extension)) {
                  fileext.setText("LESS File");
       } else if ("nsi".equals(extension) || "nsh".equals(extension)) {
                  fileext.setText("Nullsoft Scriptable Install System script");
       } else if ("mm".equals(extension)) {
                  fileext.setText("Objective-C");
       } else if ("pas".equals(extension) || "pp".equals(extension) || "inc".equals(extension) || "ipr".equals(extension)) {
                  fileext.setText("Pascal");
       } else if ("pl".equals(extension) || "pm".equals(extension) || "plx".equals(extension)) {
                  fileext.setText("PERL");
       } else if ("php".equals(extension) || "php3".equals(extension) || "php4".equals(extension) || "php5".equals(extension)
                || "phps".equals(extension) || "phpt".equals(extension) || "phtm".equals(extension)) {
                  fileext.setText("PHP Hytertext PreProcessor");
       } else if ("ps".equals(extension)) {
                  fileext.setText("PostScript");
       } else if ("properties".equals(extension)) {
                  fileext.setText("Properties File");
       } else if ("ps1".equals(extension) || "psm".equals(extension)) {
                  fileext.setText("Windows PowerShell");
       } else if ("py".equals(extension) || "pyw".equals(extension)) {
                  fileext.setText("Python");
       } else if ("r".equals(extension) || "s".equals(extension) || "splus".equals(extension)) {
                  fileext.setText("R Language");
       } else if ("rc".equals(extension)) {
                  fileext.setText("Windows Resources");
       } else if ("rb".equals(extension) || "rbw".equals(extension)) {
                  fileext.setText("Ruby");
       } else if ("scm".equals(extension) || "smd".equals(extension) || "ss".equals(extension)) {
                  fileext.setText("Scheme");
       } else if ("st".equals(extension)) {
                  fileext.setText("SmallTalk");
       } else if ("sql".equals(extension)) {
                  fileext.setText("Structured Query Language");
       } else if ("sca".equals(extension) || "scala".equals(extension)) {
                  fileext.setText("Scala File");
       } else if ("sas".equals(extension)) {
                  fileext.setText("SAS File");
       } else if ("tcl".equals(extension)) {
                  fileext.setText("Tool Command Language");
       } else if ("tex".equals(extension)) {
                  fileext.setText("LaTeX File");
       } else if ("jshintrc".equals(extension)) {
                  fileext.setText("JSON WITH COMMENTS File");
       } else if ("typescript".equals(extension)) {
                  fileext.setText("TypeScript File");
       } else if ("vb".equals(extension) || "vbs".equals(extension)) {
                  fileext.setText("Visual Basic");
       } else if ("v".equals(extension) || "sv".equals(extension) || "shv".equals(extension) || "svh".equals(extension)) {
                  fileext.setText("Verilog");
       } else if ("yml".equals(extension) || "yaml".equals(extension)) {
                  fileext.setText("YAML Ain't Markup Language");
       } else if ("java".equals(extension)) {
                  fileext.setText("java");
       } else if ("pteditor".equals(extension)) {
                  fileext.setText("Power Text Editor Generated File");
       } else if ("ptestate".equals(extension)) {
                  fileext.setText("Power Text Editor Saved State File");
       } else if ("pteplugin".equals(extension)) {
                  fileext.setText("Power Text Editor Plugin File");
       } else if ("form".equals(extension)) {
                  fileext.setText("Netbeans Form / XML File");
       } else {
                  //javax.swing.JOptionPane.showMessageDialog(null, "You cant edit " + fileChooser.getSelectedFile().getName() + "\n With Power Text Editor");
                  fileext.setText("Unknown File ( "+extension+" )");
       }
   
    }
}

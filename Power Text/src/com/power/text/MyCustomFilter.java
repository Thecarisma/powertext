/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text;

import java.io.File;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import static com.power.text.Main.fileChooser;
import static com.power.text.Main.filesave;
import static com.power.text.Main.filesaveas;

/**
 *
 * @author thecarisma
 */
public class MyCustomFilter extends FileFilter {

    public static int intjava = 0, intjson = 0;
    
    public MyCustomFilter(){
    
                FileNameExtensionFilter java;
                java = new FileNameExtensionFilter("java source file(*.java)", "java", "java");
                fileChooser.setFileFilter(java);filesave.setFileFilter(java);filesaveas.setFileFilter(java);
                
                FileNameExtensionFilter json;
                json = new FileNameExtensionFilter("JSON file(*.json)", "json", "JSON");
                fileChooser.setFileFilter(json);filesave.setFileFilter(json);filesaveas.setFileFilter(json);
                
                FileNameExtensionFilter csource;
                csource = new FileNameExtensionFilter("C Source file(*.c;*.lex)", "c", "lex");
                fileChooser.setFileFilter(csource);filesave.setFileFilter(csource);filesaveas.setFileFilter(csource);
                
                FileNameExtensionFilter batch;
                batch = new FileNameExtensionFilter("Batch file(*.bat;*.cmd;*.nt)", "bat", "cmd","nt");
                fileChooser.setFileFilter(batch);filesave.setFileFilter(batch);filesaveas.setFileFilter(batch);
                
                /**FileNameExtensionFilter Normaltext;
                Normaltext = new FileNameExtensionFilter("Normal text file(*.txt)", "txt", "TXT");
                fileChooser.setFileFilter(Normaltext);filesave.setFileFilter(Normaltext);filesaveas.setFileFilter(Normaltext);**/
                
                FileNameExtensionFilter flash;
                flash = new FileNameExtensionFilter("Flash ActionScript file(*.as;*.mx)", "as", "mx");
                fileChooser.setFileFilter(flash);filesave.setFileFilter(flash);filesaveas.setFileFilter(flash);
                
                FileNameExtensionFilter ada;
                ada = new FileNameExtensionFilter("Ada file(*.ada;*.ads;*.adb)", "ada", "ads", "adb");
                fileChooser.setFileFilter(ada);filesave.setFileFilter(ada);filesaveas.setFileFilter(ada);
                
                FileNameExtensionFilter assembly;
                assembly = new FileNameExtensionFilter("Assembly Language source file(*.asm)", "asm" );
                fileChooser.setFileFilter(assembly);filesave.setFileFilter(assembly);filesaveas.setFileFilter(assembly);
                
                FileNameExtensionFilter activesp;
                activesp = new FileNameExtensionFilter("Active Server Pages Script file(*.asp)", "asp");
                fileChooser.setFileFilter(activesp);filesave.setFileFilter(activesp);filesaveas.setFileFilter(activesp);
                
                FileNameExtensionFilter autolt;
                autolt = new FileNameExtensionFilter("Autolt file(*.au3)", "au3");
                fileChooser.setFileFilter(autolt);filesave.setFileFilter(autolt);filesaveas.setFileFilter(autolt);
                
                FileNameExtensionFilter unix;
                unix = new FileNameExtensionFilter("Unix Script file(*.bash;*.sh;*.bsh;*.csh)", "bash", "sh", "bsh", "csh");
                fileChooser.setFileFilter(unix);filesave.setFileFilter(unix);filesaveas.setFileFilter(unix);
                
                FileNameExtensionFilter cmake;
                cmake = new FileNameExtensionFilter("CMake file(*.cmake;*.CMAKE)", "cmake", "CMAKE");
                fileChooser.setFileFilter(cmake);filesave.setFileFilter(cmake);filesaveas.setFileFilter(cmake);
                
                FileNameExtensionFilter commonbuss;
                commonbuss = new FileNameExtensionFilter("Common Bussiness Oriented Language file(*.cbl;*.cbd;*.cdb;*.cdc;*.cob)", "cbl", "cbd", "cdb", "cdc", "cob");
                fileChooser.setFileFilter(commonbuss);filesave.setFileFilter(commonbuss);filesaveas.setFileFilter(commonbuss);
                
                FileNameExtensionFilter cofee;
                cofee = new FileNameExtensionFilter("Cofee Script file(*.litcofee)", "litcofee");
                fileChooser.setFileFilter(cofee);filesave.setFileFilter(cofee);filesaveas.setFileFilter(cofee);
                
                FileNameExtensionFilter cplus;
                cplus = new FileNameExtensionFilter("C++ Source file(*.h;*.hpp;*.hxx;*.cpp;*.cxx;*.cc)", "h", "hpp", "hxx", "cpp", "cxx", "cc");
                fileChooser.setFileFilter(cplus);filesave.setFileFilter(cplus);filesaveas.setFileFilter(cplus);
                
                FileNameExtensionFilter csharp;
                csharp = new FileNameExtensionFilter("C# source file(*.cs)", "cs");
                fileChooser.setFileFilter(csharp);filesave.setFileFilter(csharp);filesaveas.setFileFilter(csharp);
                
                FileNameExtensionFilter css;
                css = new FileNameExtensionFilter("Cascade Style Sheet file(*.css)", "css");
                fileChooser.setFileFilter(css);filesave.setFileFilter(css);filesaveas.setFileFilter(css);
                
                FileNameExtensionFilter dlang;
                dlang = new FileNameExtensionFilter("D Programming Language file(*.d)", "d");
                fileChooser.setFileFilter(dlang);filesave.setFileFilter(dlang);filesaveas.setFileFilter(dlang);
                
                FileNameExtensionFilter diff;
                diff = new FileNameExtensionFilter("Diff file(*.diff;*.patch)", "diff", "patch");
                fileChooser.setFileFilter(diff);filesave.setFileFilter(diff);filesaveas.setFileFilter(diff);
                
                FileNameExtensionFilter fortran;
                fortran = new FileNameExtensionFilter("Fortran Fixed Form Source file(*.f77)", "f77");
                fileChooser.setFileFilter(fortran);filesave.setFileFilter(fortran);filesaveas.setFileFilter(fortran);
                
                FileNameExtensionFilter javascript;
                javascript = new FileNameExtensionFilter("JavaScript file(*.js;*.jsm;*.jsx;*.ts;*.tsx)", "js", "jsm", "jsx", "ts", "tsx");
                fileChooser.setFileFilter(javascript);filesave.setFileFilter(javascript);filesaveas.setFileFilter(javascript);
                
                FileNameExtensionFilter javaserver;
                javaserver = new FileNameExtensionFilter("JavaServer Pages Script file(*.jsp)", "jsp");
                fileChooser.setFileFilter(javaserver);filesave.setFileFilter(javaserver);filesaveas.setFileFilter(javaserver);
                
                FileNameExtensionFilter Normaltext;
                Normaltext = new FileNameExtensionFilter("Normal text file(*.txt)", "txt", "TXT");
                fileChooser.setFileFilter(Normaltext);filesave.setFileFilter(Normaltext);filesaveas.setFileFilter(Normaltext);
                
                fileChooser.setAcceptAllFileFilterUsed(true);filesave.setAcceptAllFileFilterUsed(true);filesaveas.setAcceptAllFileFilterUsed(true);
    
                
    }
        

        @Override
        public boolean accept(File file) {
            if (file.isDirectory()) {
            return true;
        } else {
            return file.getName().toLowerCase().endsWith(".txt");
        }
            
        }

        @Override
        public String getDescription() {
            return "Normal text Files (*.txt)";
        }
    }

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.internallibrary;

import java.io.File;
import static com.power.text.Main.*;

/**
 *
 * @author Thecarisma
 */
public interface PTPaths {
    
    public static String getOSAppDataFolder() {
        String OS = System.getProperty("os.name").toUpperCase();
        if (OS.contains("WIN"))
            return System.getenv("APPDATA")+"/Power Text/";
        else if (OS.contains("MAC"))
            return System.getProperty("user.home") + "/Library/Application"
                + "Support"+"/.Power Text/";
        else if (OS.contains("NUX")||OS.contains("NIX"))
            return System.getProperty("user.home")+"/.Power Text/";
        return System.getProperty("user.dir");
    }
    
    public static String getOSDocumentFolder() {
        return System.getProperty("user.home")+"/Documents/" ;
    }
    
    public static String getOSDependenciesFolder() {
        String OS = System.getProperty("os.name").toUpperCase();
        if (OS.contains("WIN"))
            return System.getenv("LOCALAPPDATA")+"/Power Text/";
        else if (OS.contains("MAC"))
            return System.getProperty("user.home") + "/Library/Application"
                + "Support"+"/";
        else if (OS.contains("NUX")||OS.contains("NIX"))
            return System.getProperty("user.home")+"/.Power Text/";
        return System.getProperty("user.dir");
    }
    
    public static String getPowerTextGen() {
        return getOSAppDataFolder()+"Pteditor Gen Files/";
    }
    
    public static String getUnsavedFiles() {
        return getOSAppDataFolder()+"Power Text Unsaved/";
    }
    
    public static String getPluginPath() {
        return getOSDependenciesFolder()+"plugins/";
    }
    
    public static String getDictionaryPath() {
        return getOSDependenciesFolder()+"dictionaries/";
    }
    
    public static String getPluginXmlPath() {
        return getOSDependenciesFolder()+"plugins/packages/";
    }
    
    public static String getPTDocumentFolder() {
        return getOSDocumentFolder()+"Power Text/";
    }
    
    public static String getMyPluginFolder() {
        return getOSDocumentFolder()+"Power Text/My Plugins/";
    }
    
    public static String getMyMacroFolder() {
        return getOSDocumentFolder()+"Power Text/My Macros/";
    }
    
    public static String getMyThemeFolder() {
        return getOSDocumentFolder()+"Power Text/My Themes/";
    }
    
    public static void createIfDoesNotExist() {
        File appDataPath = new File(getOSAppDataFolder()); 
        if (appDataPath.exists()) {} else { appDataPath.mkdir(); firstrun = 1000 ;} 
        File dependenciesPath = new File(getOSDependenciesFolder()); 
        if (dependenciesPath.exists()) {} else { dependenciesPath.mkdir(); } 
        File doumentPath = new File(getPTDocumentFolder()); 
        if (doumentPath.exists()) {} else { doumentPath.mkdir(); } 
        File doumentPlugin = new File(getMyPluginFolder()); 
        if (doumentPlugin.exists()) {} else { doumentPlugin.mkdir(); }
        File macroFolder = new File(getMyMacroFolder()); 
        if (macroFolder.exists()) {} else { macroFolder.mkdir(); }
        File pluginPath = new File(getPluginPath()); 
        if (pluginPath.exists()) {} else { pluginPath.mkdir(); }
        File pluginXMLPath = new File(getPluginXmlPath()); 
        if (pluginXMLPath.exists()) {} else { pluginXMLPath.mkdir(); }
        File genFiles = new File(getPowerTextGen()); 
        if (genFiles.exists()) {} else { genFiles.mkdir(); }
        File unsavedFiles = new File(getUnsavedFiles()); 
        if (unsavedFiles.exists()) {} else { unsavedFiles.mkdir(); }
        File dicFiles = new File(getDictionaryPath()); 
        if (dicFiles.exists()) {} else { dicFiles.mkdir(); }
        File dictionary = new File(getDictionaryPath()+"english_dic.zip"); 
        if (dictionary.exists()) {System.out.println("dictionary exist");
        } else { new File("english_dic.zip").renameTo(dictionary); }
        File themeFolder = new File(getMyThemeFolder()); 
        if (themeFolder.exists()) {} else { themeFolder.mkdir(); }
        
    }
    
}

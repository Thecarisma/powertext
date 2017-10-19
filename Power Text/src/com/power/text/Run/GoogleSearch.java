/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.Run;

import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.net.URI;
import java.net.URL;

import static com.power.text.Main.searchbox;
import static com.power.text.dialogs.WebSearch.squerry;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JOptionPane;

/**
 *
 * @author thecarisma
 */
public class GoogleSearch {
    
    public static void googlesearch(){
    String searchquery = searchbox.getText();
    searchquery = searchquery.replace(' ', '-');
    String squery = squerry.getText();
    squery = squery.replace(' ', '-');
    if ("".equals(searchquery)){
        searchquery = squery ;
    } else {}
    String url = "https://www.google.com.ng/search?site=&source=hp&q=" + searchquery ;
    try
        {
            URI uri = new URL(url).toURI();
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE))
                desktop.browse(uri);
        }
    catch (URISyntaxException | IOException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            // Copy URL to the clipboard so the user can paste it into their browser
            StringSelection stringSelection = new StringSelection(searchquery);
            Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
            clpbrd.setContents(stringSelection, null);
            // Notify the user of the failure
            System.out.println("This program just tried to open a webpage." + "\n"
                + "The URL has been copied to your clipboard, simply paste into your browser to accessWebpage: " + url);
        }
}
    
    
}

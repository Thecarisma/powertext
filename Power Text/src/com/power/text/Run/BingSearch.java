/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.Run;

import static com.power.text.dialogs.WebSearch.squerry;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.swing.JOptionPane;
import static com.power.text.Main.searchbox;

/**
 *
 * @author thecarisma
 */
public class BingSearch {
    
    public static void bingsearch(){
    String searchqueryb = searchbox.getText();
    String squeryb = squerry.getText();
    searchqueryb = searchqueryb.replace(' ', '-');
    squeryb = squeryb.replace(' ', '-');
    if ("".equals(searchqueryb)){
        searchqueryb = squeryb ;
    } else {}
    String url = "https://www.bing.com/search?q=" + searchqueryb ;
    try
        {
            URI uri = new URL(url).toURI();
            Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE))
                desktop.browse(uri);
        }
    catch (URISyntaxException | IOException e)
        {
            /*
             *  I know this is bad practice 
             *  but we don't want to do anything clever for a specific error
             */
            JOptionPane.showMessageDialog(null, e.getMessage());
            // Copy URL to the clipboard so the user can paste it into their browser
            StringSelection stringSelection = new StringSelection(searchqueryb);
            Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
            clpbrd.setContents(stringSelection, null);
            // Notify the user of the failure
            System.out.println("This program just tried to open a webpage." + "\n"
                + "The URL has been copied to your clipboard, simply paste into your browser to accessWebpage: " + url);
        }
}
    
    
}

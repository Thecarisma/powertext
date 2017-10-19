/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builtin.browser;

import javax.swing.*;
import power.text.Interface.PowerTextProperties;
import power.text.plugin.PowerTextPlugin;

/**
 *
 * @author Thecarisma
 */
public class BuiltInBrowser implements PowerTextPlugin {
    
    JMenuItem browser = new JMenuItem("BI Browser");

    private void setBrowser() {
        
    }
    
    @Override
    public void run() {
        setBrowser();
    }

    @Override
    public String getName() {
        return "BuiltIn Browser" ;
    }

    @Override
    public String author() {
        return "Azeez Adewale" ;
    }

    @Override
    public String source() {
        return PowerTextProperties.getFullVersion();
    }

    @Override
    public String category() {
        return "HTML/PHP/Browser" ;
    }

    @Override
    public String version() {
        return "v1.0" ;
    }

    @Override
    public String description() {
        return "BuiltIn Browser allow browser based file to be test within the Editor without launching any external browser " ;
    }
    
}

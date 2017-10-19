/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code.snippets;

import code.snippets.Menus.JavaMenu;
import static power.text.Interface.AccessibleComponent.*;
import static power.text.Interface.PowerTextProperties.*;
import power.text.plugin.PowerTextPlugin;

/**
 *
 * @author Thecarisma
 */
public class CodeSnippets implements PowerTextPlugin {
    
    JavaMenu javaMenu = new JavaMenu();
    
    private void code() {
        addToCodeMenu();
    }
    
    private void addToCodeMenu() {
        getCodeMenu().add(javaMenu.getJavaMenu());
    }

    @Override
    public void run() {
        code();
    }

    @Override
    public String getName() {
        return "Power Text Code Snippets" ;
    }

    @Override
    public String author() {
        return "Azeez Adewale" ;
    }

    @Override
    public String description() {
        return "This plugin is a pack of the code snippets that can be found under "
                + "the code menu in Power Text. It is installed as a default dependency"
                + " if you wish you can deactivate it if you have your own customized "
                + "code snippet menu. Note if deactivated all the default code snippets "
                + "in the code menu disappears." ;
    }

    @Override
    public String source() {
        return getFullVersion() ;
    }

    @Override
    public String category() {
        return "Base Editor" ;
    }

    @Override
    public String version() {
        return getVersionNumber() ;
    }
    
    
    
}

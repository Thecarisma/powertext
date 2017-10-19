/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.ac;

import com.power.text.Completions.AutoComplete;
import static com.power.text.Main.Editor;
import com.power.text.ui.pteditor.RSyntaxTextArea;
import static power.text.Interface.AccessibleComponent.*;
import static power.text.Interface.PowerTextProperties.*;
import power.text.plugin.PowerTextPlugin;

/**
 *
 * @author Thecarisma
 */
public class Main  implements PowerTextPlugin {
    
    private void loadCompletion() {
        for (int a = 0; a < getTabbedParent().getTabCount(); a++) {
            AutoComplete javaAC = new AutoComplete((RSyntaxTextArea) Editor.get(a).getTextPane());
            javaAC.getCompletion();
        }
    }

    @Override
    public void run() {
        loadCompletion();
    }

    @Override
    public String getName() {
        return "PT Auto Completion" ;
    }

    @Override
    public String author() {
        return "Azeez Adewale" ;
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
        return getVersion();
    }

    @Override
    public String description() {
        return "It enables the Power Text code completion that fetch various "
                + "programming language keywords base on the current type of "
                + "document that is been edited. it also automatically add "
                + "every single type word to the autocomplete feature for easy"
                + " and smoth typing" ;
    }
    
}

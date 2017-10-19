/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package power.text.spellchecker;

import com.power.text.ui.pteditor.RSyntaxTextArea;
import power.text.Interface.AccessibleComponent;
import static power.text.Interface.AccessibleComponent.*;
import static power.text.Interface.PowerTextProperties.*;
import power.text.plugin.PowerTextPlugin;

/**
 *
 * @author Thecarisma
 */
public class Main implements PowerTextPlugin {
    
    public void main() {
        for (int a = 0; a < getTabbedParent().getTabCount(); a++) {
            new SpellChecker((RSyntaxTextArea) AccessibleComponent.getEditor().get(a).getTextPane());
        }
    }

    @Override
    public void run() {
        main();
    }

    @Override
    public String getName() {
        return "Power Text Spell Checker" ;
    }

    @Override
    public String author() {
        return getAuthor() ;
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

    @Override
    public String description() {
        return "All typed word are checked in the American and British "
                + "Dictionaries. Non-English Words are underlined. This is "
                + "a plugin that further extends the Jazzy Spell Checker which is "
                + "released under the GNUL License" ;
    }
    
}

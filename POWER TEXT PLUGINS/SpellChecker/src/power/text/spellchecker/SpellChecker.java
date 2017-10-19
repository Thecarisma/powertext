/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package power.text.spellchecker;

import com.power.text.rtextarea.RTextScrollPane;
import com.power.text.ui.pteditor.RSyntaxTextArea;
import com.power.text.ui.pteditor.SyntaxConstants;
import com.power.text.util.SpellingParser;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.*;

/**
 *
 * @author Thecarisma
 */
public final class SpellChecker implements HyperlinkListener, SyntaxConstants {
    
        private RSyntaxTextArea textArea;
	private SpellingParser parser;
        
        public SpellChecker(RSyntaxTextArea textArea) {
            this.textArea = textArea ; addNotify();
        }

    @Override
    public void hyperlinkUpdate(HyperlinkEvent he) {
        if (he.getEventType()==HyperlinkEvent.EventType.ACTIVATED) {
			URL url = he.getURL();
			if (url==null) {
				UIManager.getLookAndFeel().provideErrorFeedback(null);
			}
			else {
				JOptionPane.showMessageDialog(null, "URL clicked:\n" + url.toString());
			}
		}
    }
    
        /**
	 * Starts a thread to load the spell checker when the app is made visible,
	 * since the dictionary is somewhat large (takes 0.9 seconds to load on
	 * a 3.0 GHz Core 2 Duo).<p>
	 * This assumes the app will only be made visible once, which is certainly
	 * true for our demo.
	 */
	public void addNotify() {
		new Thread() {
			@Override
			public void run() {
				parser = createSpellingParser();
				if (parser!=null) {
					try {
						File userDict= File.createTempFile("spellDemo", ".txt");
						parser.setUserDictionary(userDict);
						System.out.println("User dictionary: " +
											userDict.getAbsolutePath());
					} catch (IOException ioe) { // Applets, IO errors
						System.err.println("Can't open user dictionary: " +
									ioe.getMessage());
					} catch (SecurityException se) { // Applets
						System.err.println("Can't open user dictionary: " +
								se.getMessage());
					}
					SwingUtilities.invokeLater(new Runnable() {
						@Override
						public void run() {
							textArea.addParser(parser);
						}
					});
				}
			}
		}.start(); System.out.println("now spell checking");
	}
        
        private SpellingParser createSpellingParser() {
		File zip = new File("dictionaries/english_dic.zip");
		try {
			return SpellingParser.createEnglishSpellingParser(zip, true);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return null;
	}

    
}

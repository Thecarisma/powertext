/*
 * 07/21/2009
 *
 * SpellingParser.java - A spell-checker for RSyntaxTextArea.
 *
 * This library is distributed under the LGPL.  See the included
 * SpellChecker.License.txt file for details.
 */
package com.power.text.util;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.MessageFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.zip.ZipFile;

import javax.swing.UIManager;
import javax.swing.event.EventListenerList;
import javax.swing.event.HyperlinkEvent;
import javax.swing.text.Element;

import com.power.text.spell.engine.Configuration;
import com.power.text.spell.engine.SpellDictionary;
import com.power.text.spell.engine.SpellDictionaryHashMap;
import com.power.text.spell.engine.Word;
import com.power.text.spell.event.DocumentWordTokenizer;
import com.power.text.spell.event.SpellCheckEvent;
import com.power.text.spell.event.SpellCheckListener;
import com.power.text.spell.event.SpellChecker;
import com.power.text.spell.event.StringWordTokenizer;
import com.power.text.ui.pteditor.RSyntaxDocument;
import com.power.text.ui.pteditor.RSyntaxTextArea;
import com.power.text.ui.pteditor.SyntaxConstants;
import com.power.text.ui.pteditor.Token;
import com.power.text.pteditor.parser.AbstractParser;
import com.power.text.pteditor.parser.DefaultParseResult;
import com.power.text.pteditor.parser.DefaultParserNotice;
import com.power.text.pteditor.parser.ExtendedHyperlinkListener;
import com.power.text.pteditor.parser.ParseResult;
import com.power.text.pteditor.fo.FocusableTip;
import com.power.text.ui.rsyntaxtextarea.spell.DefaultSpellCheckableTokenIdentifier;
import com.power.text.ui.rsyntaxtextarea.spell.SpellCheckableTokenIdentifier;
import com.power.text.ui.rsyntaxtextarea.spell.event.SpellingParserEvent;
import com.power.text.ui.rsyntaxtextarea.spell.event.SpellingParserListener;


/**
 * A parser that spell-checks documents.  The spelling engine is a lightly
 * modified version of <a href="http://jazzy.sourceforge.net/">Jazzy</a>.
 * All Jazzy source, modified or otherwise, is licensed under the LGPL. just
 * like the entirety of this library.<p>
 *
 * For source code only comments are spell checked.  For plain text files,
 * the entire content is spell checked.<p>
 *
 * This parser can be shared among multiple <code>RSyntaxTextArea</code>
 * instances.<p>
 *
 * Usage:
 * <pre>
 * RSyntaxTextArea textArea = new RSyntaxTextArea(40, 25);
 * File englishZip = new File("english_dic.zip");
 * SpellingParser parser = SpellingParser.createEnglishSpellingParser(englishZip, true);
 * textArea.addParser(parser);
 * </pre>
 *
 * @author Robert Futrell
 * @version 0.5
 */
public class SpellingParser extends AbstractParser
			implements SpellCheckListener, ExtendedHyperlinkListener {

	private DefaultParseResult result;
	private SpellChecker sc;
	private RSyntaxDocument doc;
	private int startOffs;
	private int errorCount;
	private int maxErrorCount;
	private boolean allowAdd;
	private boolean allowIgnore;
	private Color squiggleUnderlineColor;
	private String noticePrefix;
	private String noticeSuffix;
	private EventListenerList listenerList;
	private SpellCheckableTokenIdentifier spellCheckableTokenIdentifier;


	/**
	 * The "user dictionary."  If this is non-<code>null</code>, then the
	 * user will be able to select "Add word to dictionary" for spelling
	 * errors.  When this option is selected, the word is added to this
	 * file.
	 */
	private File dictionaryFile;

	//private static final String MSG = "org.fife.com.swabunga.util.SpellingParser";
	//private static final ResourceBundle msg = ResourceBundle.getBundle(MSG);

	private static final String ADD			= "add";
	private static final String IGNORE		= "ignore";
	private static final String REPLACE		= "replace";
	private static final String TOOLTIP_TEXT_FORMAT =
		"<html><body dir='{0}'><img src='lightbulb.png' width='16' height='16'>{1}<hr><img src='spellcheck.png' width='16' height='16'>{2}<br>{3}<br>&nbsp;";

	/**
	 * The default maximum number of spelling errors to report for a document.
	 */
	private static final int DEFAULT_MAX_ERROR_COUNT			= 100;


	/**
	 * Constructor.
	 *
	 * @param dict The dictionary to use.
	 */
	public SpellingParser(SpellDictionary dict) {

		result = new DefaultParseResult(this);
		sc = new SpellChecker(dict);
		sc.addSpellCheckListener(this);
		setSquiggleUnderlineColor(Color.BLUE);
		setHyperlinkListener(this);
		setMaxErrorCount(DEFAULT_MAX_ERROR_COUNT);
		setAllowAdd(true);
		setAllowIgnore(true);
		setSpellCheckableTokenIdentifier(
				new DefaultSpellCheckableTokenIdentifier());

		// Since the spelling callback can possibly be called many times
		// per parsing, we're extremely cheap here and pre-split our message
		// format instead of using MessageFormat.
		//String temp = msg.getString("IncorrectSpelling");
		//int offs = temp.indexOf("{0}");
		//noticePrefix = temp.substring(0, offs);
		//noticeSuffix = temp.substring(offs+3);

		listenerList = new EventListenerList();

	}


	/**
	 * Adds a listener to this spelling parser.
	 *
	 * @param l The new listener.
	 * @see #removeSpellingParserListener(SpellingParserListener)
	 */
	public void addSpellingParserListener(SpellingParserListener l) {
		listenerList.add(SpellingParserListener.class, l);
	}


	/**
	 * A utility method to easily create a parser for American or British
	 * English.
	 *
	 * @param zip The location of the <code>english_dic.zip</code> file
	 *        distributed with the spell checker add-on.
	 * @param american Whether the parser should be for American (as opposed
	 *        to British) English.
	 * @return The parser.
	 * @throws IOException If an error occurs reading the zip file.
	 */
	public static SpellingParser createEnglishSpellingParser(File zip, boolean american) throws IOException {

//		long start = System.currentTimeMillis();

		SpellDictionaryHashMap dict = null;

		ZipFile zf = new ZipFile(zip);

		try {

			// Words common to American and British English
			InputStream in = zf.getInputStream(zf.getEntry("eng_com.dic"));
			BufferedReader r = new BufferedReader(new InputStreamReader(in));
			try {
				dict = new SpellDictionaryHashMap(r);
			} finally {
				r.close();
			}

			String[] others = null;
			if (american) {
				others = new String[] { "color", "labeled", "center", "ize",
										"yze" };
			}
			else { // British
				others = new String[] { "colour", "labelled", "centre",
										"ise", "yse" };
			}

			// Load words specific to the English dialect.
			for (int i=0; i<others.length; i++) {
				in = zf.getInputStream(zf.getEntry(others[i] + ".dic"));
				r = new BufferedReader(new InputStreamReader(in));
				try {
					dict.addDictionary(r);
				} finally {
					r.close();
				}
			}

		} finally {
			zf.close();
		}

//		float secs = (System.currentTimeMillis() - start)/1000f;
//		System.out.println("Loading dictionary took " + secs + " seconds");

		return new SpellingParser(dict);

	}


	/**
	 * Notifies all listeners about an event in this parser.
	 *
	 * @param e The event.
	 */
	protected void fireSpellingParserEvent(SpellingParserEvent e) {
		// Guaranteed to return a non-null array
		Object[] listeners = listenerList.getListenerList();
		// Process the listeners last to first, notifying
		// those that are interested in this event
		for (int i = listeners.length-2; i>=0; i-=2) {
			if (listeners[i]==SpellingParserListener.class) {
				((SpellingParserListener)listeners[i+1]).spellingParserEvent(e);
			}
		}
	}


	/**
	 * Returns whether an "Add word to dictionary" link is added to tool tips
	 * returned by this parser.  Note that for an add operation to be
	 * successful, a user dictionary must also be defined.
	 *
	 * @return Whether words can be added to the user dictionary.
	 * @see #setAllowAdd(boolean)
	 * @see #setUserDictionary(File)
	 */
	public boolean getAllowAdd() {
		return allowAdd;
	}


	/**
	 * Returns whether an "Ignore this word for this session" link is
	 * added to tool tips returns by this parser.
	 *
	 * @return Whether words can be ignored.
	 * @see #setAllowIgnore(boolean)
	 */
	public boolean getAllowIgnore() {
		return allowIgnore;
	}


	/**
	 * Overridden to return the image base for {@link FocusableTip}s made
	 * from this parser's notices.
	 *
	 * @return The image base.
	 */
	@Override
	public URL getImageBase() {
		return getClass().getResource("/com/power/text/util/images/");
	}


	private final int getLineOfOffset(int offs) {
		return doc.getDefaultRootElement().getElementIndex(offs);
	}


	/**
	 * Returns the maximum number of errors this parser will report for a
	 * single document.
	 *
	 * @return The maximum number of errors that will be reported.
	 * @see #setMaxErrorCount(int)
	 */
	public int getMaxErrorCount() {
		return maxErrorCount;
	}


	/**
	 * Returns the strategy to use to identify tokens to spell check.
	 *
	 * @return The strategy.
	 * @see #setSpellCheckableTokenIdentifier(SpellCheckableTokenIdentifier)
	 */
	public SpellCheckableTokenIdentifier getSpellCheckableTokenIdentifier() {
		return spellCheckableTokenIdentifier;
	}


	/**
	 * Returns the color to use when painting spelling errors in an editor.
	 *
	 * @return The color to use.
	 * @see #setSquiggleUnderlineColor(Color)
	 */
	public Color getSquiggleUnderlineColor() {
		return squiggleUnderlineColor;
	}


	/**
	 * Returns the user's dictionary file.
	 *
	 * @return The user's dictionary file, or <code>null</code> if none has
	 *         been set.
	 * @see #setUserDictionary(File)
	 */
	public File getUserDictionary() {
		return dictionaryFile;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void linkClicked(RSyntaxTextArea textArea, HyperlinkEvent e) {

		if (e.getEventType()==HyperlinkEvent.EventType.ACTIVATED) {

			String desc = e.getDescription();
			int temp = desc.indexOf("://");
			String operation = desc.substring(0, temp);
			String[] tokens = desc.substring(temp + 3).split(",");

			if (REPLACE.equals(operation)) {
				int offs = Integer.parseInt(tokens[0]);
				int len = Integer.parseInt(tokens[1]);
				String replacement = tokens[2];
				textArea.replaceRange(replacement, offs, offs+len);
				textArea.setSelectionStart(offs);
				textArea.setSelectionEnd(offs + replacement.length());
			}

			else if (ADD.equals(operation)) {
				if (dictionaryFile==null) {
					// TODO: Add callback for application to prompt to create
					// a user dictionary
					UIManager.getLookAndFeel().provideErrorFeedback(textArea);
				}
				String word = tokens[0];
				if (sc.addToDictionary(word)) {
					textArea.forceReparsing(this);
					SpellingParserEvent se = new SpellingParserEvent(this,
							textArea, SpellingParserEvent.WORD_ADDED, word);
					fireSpellingParserEvent(se);
				}
				else { // IO error adding the word
					UIManager.getLookAndFeel().provideErrorFeedback(textArea);
				}
			}

			else if (IGNORE.equals(operation)) {
				String word = tokens[0];
				sc.ignoreAll(word);
				textArea.forceReparsing(this);
				SpellingParserEvent se = new SpellingParserEvent(this,
						textArea, SpellingParserEvent.WORD_IGNORED, word);
				fireSpellingParserEvent(se);
			}

		}

	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public ParseResult parse(RSyntaxDocument doc, String style) {

//		long startTime = System.currentTimeMillis();

		Element root = doc.getDefaultRootElement();
		int lineCount = root.getElementCount();
		result.clearNotices();
		// Always spell check all lines, for now.
		result.setParsedLines(0, lineCount-1);
		this.doc = doc;
		errorCount = 0;

		// Use a faster method for spell-checking plain text.
		if (style==null || SyntaxConstants.SYNTAX_STYLE_NONE.equals(style)) {
			startOffs = 0;
			parseEntireDocument(doc);
		}

		else {

			SpellCheckableTokenIdentifier scti =
					getSpellCheckableTokenIdentifier();

			scti.begin();
			try {
				for (Token t : doc) {
					if (scti.isSpellCheckable(t)) {
						startOffs = t.getOffset();
						// TODO: Create a wordTokenizer that uses char[] array
						// to prevent String allocation.
						StringWordTokenizer swt =
									new StringWordTokenizer(t.getLexeme());
						int rc = sc.checkSpelling(swt);
						if (rc==SpellChecker.SPELLCHECK_CANCEL) {
							break; // Stop spell checking comments
						}
					}
				}
			} finally {
				scti.end();
			}

		}

//		float secs = (System.currentTimeMillis() - startTime)/1000f;
//		System.out.println("Spell check completed in: " + secs + " seconds");
//		System.out.println("Error count==" + errorCount);
		return result;

	}


	/**
	 * Spell-checks a plain text document.
	 *
	 * @param doc The document to spell check.
	 */
	private void parseEntireDocument(RSyntaxDocument doc) {
		DocumentWordTokenizer dwt = new DocumentWordTokenizer(doc);
		sc.checkSpelling(dwt);
	}


	/**
	 * Removes a listener from this spelling parser.
	 *
	 * @param l The listener to remove.
	 * @see #addSpellingParserListener(SpellingParserListener)
	 */
	public void removeSpellingParserListener(SpellingParserListener l) {
		listenerList.remove(SpellingParserListener.class, l);
	}


	/**
	 * Sets whether an "Add word to dictionary" link is added to tool tips
	 * returned by this parser.  Note that for an add operation to be
	 * successful, a user dictionary must also be defined.
	 *
	 * @param add Whether the option should be available.
	 * @see #getAllowAdd()
	 * @see #setUserDictionary(File)
	 */
	public void setAllowAdd(boolean add) {
		allowAdd = add;
	}


	/**
	 * Returns whether an "Ignore this word for this session" link is
	 * added to tool tips returns by this parser.
	 *
	 * @param ignore Whether the option should be available.
	 * @see #getAllowIgnore()
	 */
	public void setAllowIgnore(boolean ignore) {
		allowIgnore = ignore;
	}


	/**
	 * Sets the maximum number of spelling errors this parser will report for a
	 * single text file.  Note that the file should be re-parsed after changing
	 * this value.
	 *
	 * @param max The new maximum error count.
	 * @see #getMaxErrorCount()
	 */
	public void setMaxErrorCount(int max) {
		maxErrorCount = max;
	}


	/**
	 * Sets the strategy to use to identify tokens to spell check.
	 *
	 * @param scti The new strategy to use.  This cannot be <code>null</code>.
	 * @see #getSpellCheckableTokenIdentifier()
	 */
	public void setSpellCheckableTokenIdentifier(
			SpellCheckableTokenIdentifier scti) {
		if (scti==null) {
			throw new IllegalArgumentException(
					"SpellCheckableTokenIdentifier cannot be null");
		}
		this.spellCheckableTokenIdentifier = scti;
	}


	/**
	 * Sets the color to use when painting spelling errors in an editor.
	 *
	 * @param color The color to use.
	 * @see #getSquiggleUnderlineColor()
	 */
	public void setSquiggleUnderlineColor(Color color) {
		squiggleUnderlineColor = color;
	}


	/**
	 * Sets the "user dictionary," that is, the dictionary that words can be
	 * added to at runtime.<p>
	 *
	 * If this is non-<code>null</code>, then on the focusable tool tip for
	 * spelling errors, there will be an option available: "Add word to
	 * dictionary."  If this is clicked then the "error" word is added to the
	 * user's dictionary and the document is re-parsed.
	 *
	 * @param dictionaryFile The dictionary file.  If this is <code>null</code>
	 *        then the user will not be able to add words.
	 * @throws IOException If an IO error occurs.
	 * @see #getUserDictionary()
	 */
	public void setUserDictionary(File dictionaryFile) throws IOException {
		SpellDictionaryHashMap userDict = null;
		if (dictionaryFile!=null) {
			if (!dictionaryFile.exists()) {
				// The file must exist for Jazzy to be happy
				FileWriter w = new FileWriter(dictionaryFile);
				w.close();
			}
			userDict = new SpellDictionaryHashMap(dictionaryFile);
		}
		else {
			// Unfortunately cannot use null, Jazzy won't allow it
			userDict = new SpellDictionaryHashMap();
		}
		sc.setUserDictionary(userDict);
		this.dictionaryFile = dictionaryFile;
	}


	/**
	 * Callback called when a spelling error is found.
	 *
	 * @param e The event.
	 */
	@Override
	public void spellingError(SpellCheckEvent e) {
//		e.ignoreWord(true);
		String word = e.getInvalidWord();
		int offs = startOffs + e.getWordContextPosition();
		int line = getLineOfOffset(offs);
		String text = noticePrefix + word + noticeSuffix;
		SpellingParserNotice notice =
			new SpellingParserNotice(this, text, line, offs, word, sc);
		result.addNotice(notice);
		if (++errorCount>=maxErrorCount) {
			//System.out.println("Cancelling the spelling check!");
			e.cancel();
		}
	}


	/**
	 * The notice type returned by this parser.
	 */
	private static class SpellingParserNotice extends DefaultParserNotice {

		private String word;
		private SpellChecker sc;

		public SpellingParserNotice(SpellingParser parser, String msg,
									int line, int offs, String word,
									SpellChecker sc) {
			super(parser, msg, line, offs, word.length());
			setLevel(Level.INFO);
			this.word = word;
			this.sc = sc;
		}

		@Override
		public Color getColor() {
			return ((SpellingParser)getParser()).getSquiggleUnderlineColor();
		}

		@Override
		public String getToolTipText() {

			StringBuilder sb = new StringBuilder();
			String spacing = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
			int threshold = sc.getConfiguration().getInteger(Configuration.SPELL_THRESHOLD);
			List<Word> suggestions = sc.getSuggestions(word, threshold);
			if (suggestions==null || suggestions.size()==0) {
				sb.append(spacing).append("&#8226;&nbsp;<em>");
				//sb.append(msg.getString("None"));
				sb.append("</em><br><br>");
			}
			else {
				sb.append("<center>");
				sb.append("<table width='75%'>");
				for (int i=0; i<suggestions.size(); i++) {
					if ((i%2)==0) {
						sb.append("<tr>");
					}
					sb.append("<td>&#8226;&nbsp;");
					Word suggestion = suggestions.get(i);
					// Surround with double quotes, not single, since
					// replacement words can have single quotes in them.
					sb.append("<a href=\"").append(REPLACE).append("://").
					append(getOffset()).append(',').
					append(getLength()).append(',').
					append(suggestion.getWord()).
					append("\">").
					append(suggestion.getWord()).
					append("</a>").
					append("</td>");
					if ((i&1)==1) {
						sb.append("</tr>");
					}
				}
				if ((suggestions.size()%2)==0) {
					sb.append("<td></td></tr>");
				}
				sb.append("</table>");
				sb.append("</center>");
			}

			SpellingParser sp = (SpellingParser)getParser();
			if (sp.getAllowAdd()) {
				sb.append("<img src='add.png' width='16' height='16'>&nbsp;").
						append("<a href='").append(ADD).
						append("://").append(word).append("'>").
						append("Add To Dictionary").
						append("</a><br>");
			}

			if (sp.getAllowIgnore()) {
				String text = "" ;
				text = MessageFormat.format(text, new Object[] { word });
				sb.append("<img src='ignore.png' width='16' height='16'>&nbsp;").
						append("<a href='").append(IGNORE).
						append("://").append(word).append("'>").
						append("Ignore").append("</a>");
			}

			String firstLine = MessageFormat.format(
									"",
									new Object[] { word });
			ComponentOrientation o = ComponentOrientation.getOrientation(
												Locale.getDefault());
			String dirAttr = o.isLeftToRight() ? "ltr" : "rtl";
			String temp = MessageFormat.format(TOOLTIP_TEXT_FORMAT,
							new Object[] {
								dirAttr,
								firstLine,
								//msg.getString("ErrorToolTip.SuggestionsHtml"),
								sb.toString() });

			return temp;

		}

		@Override
		public String toString() {
			return "[SpellingParserNotice: " + word + "]";
		}

	}


}
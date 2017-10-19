/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.pteditor.themes;

import com.power.text.Main;
import static com.power.text.PTextEditor.*;
import com.power.text.TabList.CustomTabbedPaneUI;
import com.power.text.rtextarea.*;
import com.power.text.ui.pteditor.*;
import java.awt.*;
import java.io.*;
import java.lang.reflect.Field;
import java.util.logging.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.text.StyleContext;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

/**
 *
 * @author Thecarisma
 */
public class Theme {
    
        Main main ;
        Border border = null ;
        public static Color background = Color.BLUE;
        public Color foreground;
        public Color borderColor;
        public Color selected;
        public Color unselected;
        public Font baseFont;
        public boolean gradient = true;
	public Color caretColor;
	public boolean useSelctionFG;
	public Color selectionFG;
	public Color selectionBG;
	public boolean selectionRoundedEdges;
	public Color currentLineHighlight;
	public boolean fadeCurrentLineHighlight;
	public Color marginLineColor;
	public Color markAllHighlightColor;
	public Color markOccurrencesColor;
	public boolean markOccurrencesBorder;
	public Color matchedBracketFG;
	public Color matchedBracketBG;
	public boolean matchedBracketHighlightBoth;
	public boolean matchedBracketAnimate;
	public Color hyperlinkFG;
	public Color[] secondaryLanguages;

	public SyntaxScheme scheme;
        public SyntaxScheme dMScheme;
        public SyntaxScheme pluginManagercheme;

	public Color gutterBorderColor;
	public Color activeLineRangeColor;
	public boolean iconRowHeaderInheritsGutterBG;
	public Color lineNumberColor;
	public String lineNumberFont;
	public int lineNumberFontSize;
	public Color foldIndicatorFG;
	public Color foldBG;
        
        public Theme(RSyntaxTextArea textArea, Main main) {
            
                baseFont = textArea.getFont();
		background = textArea.getBackground();
		caretColor = textArea.getCaretColor();
		useSelctionFG = textArea.getUseSelectedTextColor();
		selectionFG = textArea.getSelectedTextColor();
		selectionBG = textArea.getSelectionColor();
		selectionRoundedEdges = textArea.getRoundedSelectionEdges();
		currentLineHighlight = textArea.getCurrentLineHighlightColor();
		fadeCurrentLineHighlight = textArea.getFadeCurrentLineHighlight();
		marginLineColor = textArea.getMarginLineColor();
		markAllHighlightColor = textArea.getMarkAllHighlightColor();
		markOccurrencesColor = textArea.getMarkOccurrencesColor();
		markOccurrencesBorder = textArea.getPaintMarkOccurrencesBorder();
		matchedBracketBG = textArea.getMatchedBracketBGColor();
		matchedBracketFG = textArea.getMatchedBracketBorderColor();
		matchedBracketHighlightBoth = textArea.getPaintMatchedBracketPair();
		matchedBracketAnimate = textArea.getAnimateBracketMatching();
		hyperlinkFG = textArea.getHyperlinkForeground();

		int count = textArea.getSecondaryLanguageCount();
		secondaryLanguages = new Color[count];
		for (int i=0; i<count; i++) {
			secondaryLanguages[i]= textArea.getSecondaryLanguageBackground(i+1);
		}

		scheme = textArea.getSyntaxScheme();

		Gutter gutter = RSyntaxUtilities.getGutter(textArea);
		if (gutter!=null) {
			background = gutter.getBackground();
			gutterBorderColor = gutter.getBorderColor();
			activeLineRangeColor = gutter.getActiveLineRangeColor();
			iconRowHeaderInheritsGutterBG = gutter.getIconRowHeaderInheritsGutterBackground();
			lineNumberColor = gutter.getLineNumberColor();
			lineNumberFont = gutter.getLineNumberFont().getFamily();
			lineNumberFontSize = gutter.getLineNumberFont().getSize();
			foldIndicatorFG = gutter.getFoldIndicatorForeground();
			foldBG = gutter.getFoldBackground();
		} this.main = main ;
            
        }
        
        public void apply() {
            main.jTabbedPane1.setUI(new CustomTabbedPaneUI(selected, unselected, gradient));
            main.jTabbedPane2.setUI(new CustomTabbedPaneUI(selected, unselected, gradient));
            Main.jTabbedPane2.setBackground(background);
            main.jTabbedPane1.setForeground(foreground); main.jTabbedPane2.setForeground(foreground);
            main.jMenuBar1.setBackground(background); main.jMenuBar1.setForeground(foreground);
            main.jSplitPane1.setForeground(foreground); main.jSplitPane1.setUI(new ApplyToDivider(unselected));
            main.jSlider1.setForeground(foreground); main.jSlider1.setBackground(background);
            Main.jTabbedPane1.setBorder(border); Main.jTabbedPane2.setBorder(border);
            main.jSplitPane1.setBorder(border);  main.jPanel1.setBackground(background);
            main.jPanel1.setBorder(border); main.jPanel1.setForeground(foreground); 
            main.macroList.setBackground(background);
            main.macroList.setBorder(border); main.macroList.setForeground(foreground); 
            main.jPanel2.setBackground(background); Main.jTabbedPane1.setBackground(background);
            main.jPanel2.setBorder(border); main.jPanel2.setForeground(foreground);
            main.jPanel3.setBorder(border); main.jPanel3.setBackground(background);
            main.jPanel3.setForeground(foreground); main.jPanel4.setBackground(background);
            main.jPanel4.setBorder(border); main.jPanel4.setForeground(foreground); 
            main.jPanel5.setBorder(border); main.jPanel5.setBackground(background);
            main.jPanel5.setForeground(foreground); main.jPanel6.setBackground(background);
            main.jPanel6.setBorder(border); main.jPanel6.setForeground(foreground);
            main.jPanel7.setBorder(border); main.jPanel7.setBackground(background);
            main.jPanel7.setForeground(foreground); main.jPanel8.setBackground(background);
            main.jPanel8.setBorder(border); main.jPanel8.setForeground(foreground); 
            main.jPanel9.setBorder(border); main.jPanel9.setBackground(background);
            main.jPanel9.setForeground(foreground); main.jPanel10.setBackground(background);
            main.jPanel10.setBorder(border); main.jPanel10.setForeground(foreground);
            main.jPanel11.setBorder(border); main.jPanel11.setBackground(background);
            main.jPanel11.setForeground(foreground); main.jPanel3.setForeground(foreground);
            main.jPanel3.setBorder(border); main.jPanel3.setBackground(background);
            main.jList1.setForeground(foreground); main.jList1.setBorder(border); 
            main.jList1.setBackground(background); main.jList3.setForeground(foreground); 
            main.jList2.setForeground(foreground); main.jList2.setBorder(border); 
            main.jList2.setBackground(background); main.jList3.setBorder(border); 
            main.jList3.setBackground(background); main.jScrollPane1.setBackground(background); 
            main.jScrollPane1.setForeground(foreground); main.jScrollPane1.setBorder(border); 
            main.jScrollPane3.setForeground(foreground); main.jScrollPane3.setBorder(border); 
            main.jScrollPane3.setBackground(background); main.jScrollPane4.setBackground(background); 
            main.jScrollPane4.setForeground(foreground); main.jScrollPane4.setBorder(border);
            main.jSplitPane1.setBackground(background);  main.jScrollPane2.setBackground(background); 
            main.jScrollPane2.setForeground(foreground); main.jScrollPane2.setBorder(border);
            //main.jButton1.setForeground(foreground); main.jButton1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            //main.jButton1.setBackground(background); main.jButton1.setContentAreaFilled(false);
            main.jButton2.setForeground(foreground); main.jButton2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected)); 
            main.jButton2.setBackground(background); main.jButton2.setContentAreaFilled(false);
            main.jButton3.setForeground(foreground); main.jButton3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.jButton3.setBackground(background); main.jButton3.setContentAreaFilled(false);
            main.jButton9.setForeground(foreground); main.jButton9.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected)); 
            main.jButton9.setBackground(background); main.jButton9.setContentAreaFilled(false);
            main.jButton4.setForeground(foreground); main.jButton4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.jButton4.setBackground(background); main.jButton4.setContentAreaFilled(false);
            main.jButton5.setForeground(foreground); main.jButton5.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected)); 
            main.jButton5.setBackground(background); main.jButton5.setContentAreaFilled(false);
            main.jButton6.setForeground(foreground); main.jButton6.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.jButton6.setBackground(background); main.jButton6.setContentAreaFilled(false);
            main.jButton7.setForeground(foreground); main.jButton7.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected)); 
            main.jButton7.setBackground(background); main.jButton7.setContentAreaFilled(false);
            main.jButton8.setForeground(foreground); main.jButton8.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.jButton8.setBackground(background); main.jButton8.setContentAreaFilled(false);
            //main.jButton10.setForeground(foreground); main.jButton10.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected)); 
            //main.jButton10.setBackground(background); main.jButton10.setContentAreaFilled(false);
            //main.jButton11.setForeground(foreground); main.jButton11.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            //main.jButton11.setBackground(background); main.jButton11.setContentAreaFilled(false);
            main.searchbutton.setForeground(foreground); main.searchbutton.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.searchbutton.setBackground(background); main.searchbutton.setContentAreaFilled(false);
            main.jToggleButton1.setForeground(foreground); main.jToggleButton1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.jToggleButton1.setBackground(background); main.jToggleButton1.setContentAreaFilled(false);
            main.jToggleButton2.setForeground(foreground); main.jToggleButton2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.jToggleButton2.setBackground(background); main.jToggleButton2.setContentAreaFilled(false);
            main.jToggleButton3.setForeground(foreground); main.jToggleButton3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.jToggleButton3.setBackground(background); main.jToggleButton3.setContentAreaFilled(false);
            main.jToolBar1.setBackground(background); main.jToolBar1.setForeground(foreground);
            main.toolbar.setBackground(background);
            main.jToolBar1.setBackground(background); main.jToolBar1.setForeground(foreground);
            main.toolbar.setBackground(background);
            main.toolbar.setBorder(border); main.toolbar.setForeground(foreground);
            main.statusPanel.setBackground(background);
            main.statusPanel.setBorder(border); main.statusPanel.setForeground(foreground);
            main.statusPanel1.setBackground(background);
            main.statusPanel1.setBorder(border); main.statusPanel1.setForeground(foreground);
            main.jLabel1.setForeground(foreground); main.jLabel2.setForeground(foreground);
            main.jLabel3.setForeground(foreground); main.jLabel4.setForeground(foreground);
            main.jLabel5.setForeground(foreground); main.jLabel6.setForeground(foreground);
            main.jLabel7.setForeground(foreground); main.jLabel8.setForeground(foreground);
            main.jLabel9.setForeground(foreground); main.jLabel10.setForeground(foreground);
            main.jLabel11.setForeground(foreground); main.jLabel12.setForeground(foreground);
            main.jLabel13.setForeground(foreground); main.jLabel14.setForeground(foreground);
            main.jLabel15.setForeground(foreground); main.jLabel16.setForeground(foreground);
            main.statusLabel.setForeground(foreground); main.cal.setForeground(foreground);
            main.notification.setForeground(foreground); main.Totalsel.setForeground(foreground);
            main.dateLabel.setForeground(foreground); main.timeLabel.setForeground(foreground);
            main.fileext.setForeground(foreground); main.jLabel2.setForeground(foreground);
            main.osEncoding.setForeground(foreground);
            main.jScrollPane1.getVerticalScrollBar().setUI(new SBV());
            main.jScrollPane1.getHorizontalScrollBar().setUI(new SBH());
            main.jScrollPane2.getVerticalScrollBar().setUI(new SBV());
            main.jScrollPane2.getHorizontalScrollBar().setUI(new SBH());
            main.jScrollPane3.getVerticalScrollBar().setUI(new SBV());
            main.jScrollPane3.getHorizontalScrollBar().setUI(new SBH());
            main.jScrollPane4.getVerticalScrollBar().setUI(new SBV());
            main.jScrollPane4.getHorizontalScrollBar().setUI(new SBH());
            
            //Toolbar buttons
            main.TnewFile.setForeground(foreground); main.TnewFile.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected)); 
            main.TnewFile.setBackground(background); main.TnewFile.setContentAreaFilled(false);
            main.TopenFile.setForeground(foreground); main.TopenFile.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected)); 
            main.TopenFile.setBackground(background); main.TopenFile.setContentAreaFilled(false);
            main.TsaveFile.setForeground(foreground); main.TsaveFile.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected)); 
            main.TsaveFile.setBackground(background); main.TsaveFile.setContentAreaFilled(false);
            main.TsaveFile1.setForeground(foreground); main.TsaveFile1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected)); 
            main.TsaveFile1.setBackground(background); main.TsaveFile1.setContentAreaFilled(false);
            main.Tprint.setForeground(foreground); main.Tprint.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected)); 
            main.Tprint.setBackground(background); main.Tprint.setContentAreaFilled(false);
            main.Tcopy.setForeground(foreground); main.Tcopy.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected)); 
            main.Tcopy.setBackground(background); main.Tcopy.setContentAreaFilled(false);
            main.Tcut.setForeground(foreground); main.Tcut.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected)); 
            main.Tcut.setBackground(background); main.Tcut.setContentAreaFilled(false);
            main.Tpaste.setForeground(foreground); main.Tpaste.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected)); 
            main.Tpaste.setBackground(background); main.Tpaste.setContentAreaFilled(false);
            main.Tif.setForeground(foreground); main.Tif.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected)); 
            main.Tif.setBackground(background); main.Tif.setContentAreaFilled(false);
            main.Tsf.setForeground(foreground); main.Tsf.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected)); 
            main.Tsf.setBackground(background); main.Tsf.setContentAreaFilled(false);
            main.Tdf.setForeground(foreground); main.Tdf.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected)); 
            main.Tdf.setBackground(background); main.Tdf.setContentAreaFilled(false);
            main.Tundo.setForeground(foreground); main.Tundo.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected)); 
            main.Tundo.setBackground(background); main.Tundo.setContentAreaFilled(false);
            main.Tredo.setForeground(foreground); main.Tundo.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected)); 
            main.Tredo.setBackground(background); main.Tredo.setContentAreaFilled(false);
            main.editoronly.setForeground(foreground); main.editoronly.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected)); 
            main.editoronly.setBackground(background); main.editoronly.setContentAreaFilled(false);
            
            //Summary panel 
            main.summaryPane.jLabel18.setForeground(foreground); main.summaryPane.jLabel16.setForeground(foreground);
            main.summaryPane.jLabel17.setForeground(foreground); main.summaryPane.jLabel19.setForeground(foreground);
            main.summaryPane.jLabel20.setForeground(foreground); main.summaryPane.jLabel21.setForeground(foreground);
            main.summaryPane.jLabel22.setForeground(foreground); main.summaryPane.jLabel23.setForeground(foreground);
            main.summaryPane.jLabel24.setForeground(foreground); main.summaryPane.jLabel25.setForeground(foreground);
            main.summaryPane.jLabel26.setForeground(foreground); main.summaryPane.jLabel27.setForeground(foreground);
            main.summaryPane.jLabel5.setForeground(foreground); main.summaryPane.jPanel2.setForeground(foreground); 
            main.summaryPane.jButton1.setForeground(foreground); main.summaryPane.jButton1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.summaryPane.jButton1.setBackground(background); main.summaryPane.jButton1.setContentAreaFilled(false);
            main.summaryPane.jPanel2.setBorder(border); main.summaryPane.jPanel2.setBackground(background);
            
            //Document panel
            main.documentPane.jButton1.setForeground(foreground); main.documentPane.jButton1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.documentPane.jButton1.setBackground(background); main.documentPane.jButton1.setContentAreaFilled(false);
            main.documentPane.jButton2.setForeground(foreground); main.documentPane.jButton2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.documentPane.jButton2.setBackground(background); main.documentPane.jButton2.setContentAreaFilled(false);
            main.documentPane.jButton3.setForeground(foreground); main.documentPane.jButton3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.documentPane.jButton3.setBackground(background); main.documentPane.jButton3.setContentAreaFilled(false);
            main.documentPane.jButton5.setForeground(foreground); main.documentPane.jButton5.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.documentPane.jButton5.setBackground(background); main.documentPane.jButton5.setContentAreaFilled(false);
            main.documentPane.jLabel1.setForeground(foreground); main.documentPane.jLabel2.setForeground(foreground);
            main.documentPane.jPanel1.setBorder(border); main.documentPane.jPanel1.setBackground(background);
            main.documentPane.jPanel1.setForeground(foreground); main.documentPane.jScrollPane1.setBackground(background); 
            main.documentPane.jScrollPane1.setForeground(foreground); main.documentPane.jScrollPane1.setBorder(border);
            main.documentPane.jScrollPane2.setBackground(background); 
            main.documentPane.jScrollPane2.setForeground(foreground); main.documentPane.jScrollPane2.setBorder(border);
            main.documentPane.docList.setForeground(foreground); main.documentPane.docList.setBorder(border); 
            main.documentPane.docList.setBackground(background); main.documentPane.jTextArea1.setBorder(border); 
            main.documentPane.jTextArea1.setBackground(background); main.documentPane.jTextArea1.setForeground(foreground); 
            main.documentPane.jScrollPane2.getVerticalScrollBar().setUI(new SBV());
            main.documentPane.jScrollPane2.getHorizontalScrollBar().setUI(new SBH());
            main.documentPane.jScrollPane1.getVerticalScrollBar().setUI(new SBV());
            main.documentPane.jScrollPane1.getHorizontalScrollBar().setUI(new SBH());
            
            //plugin manager
            main.pluginManager.jButton1.setForeground(foreground); main.pluginManager.jButton1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.pluginManager.jButton1.setBackground(background); main.pluginManager.jButton1.setContentAreaFilled(false);
            main.pluginManager.jButton2.setForeground(foreground); main.pluginManager.jButton2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.pluginManager.jButton2.setBackground(background); main.pluginManager.jButton2.setContentAreaFilled(false);
            main.pluginManager.jButton3.setForeground(foreground); main.pluginManager.jButton3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.pluginManager.jButton3.setBackground(background); main.pluginManager.jButton3.setContentAreaFilled(false);
            main.pluginManager.jButton5.setForeground(foreground); main.pluginManager.jButton5.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.pluginManager.jButton5.setBackground(background); main.pluginManager.jButton5.setContentAreaFilled(false);
            main.pluginManager.jButton6.setForeground(foreground); main.pluginManager.jButton6.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.pluginManager.jButton6.setBackground(background); main.pluginManager.jButton6.setContentAreaFilled(false);
            main.pluginManager.jButton7.setForeground(foreground); main.pluginManager.jButton7.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.pluginManager.jButton7.setBackground(background); main.pluginManager.jButton7.setContentAreaFilled(false);
            main.pluginManager.jButton4.setForeground(foreground); main.pluginManager.jButton4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.pluginManager.jButton4.setBackground(background); main.pluginManager.jButton4.setContentAreaFilled(false);
            main.pluginManager.jButton8.setForeground(foreground); main.pluginManager.jButton8.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.pluginManager.jButton8.setBackground(background); main.pluginManager.jButton8.setContentAreaFilled(false);
            main.pluginManager.jButton9.setForeground(foreground); main.pluginManager.jButton9.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.pluginManager.jButton9.setBackground(background); main.pluginManager.jButton9.setContentAreaFilled(false);
            main.pluginManager.jLabel1.setForeground(foreground); main.pluginManager.jLabel2.setForeground(foreground);
            main.pluginManager.jLabel3.setForeground(foreground); main.pluginManager.jLabel4.setForeground(foreground);
            main.pluginManager.jLabel5.setForeground(foreground); main.pluginManager.jLabel6.setForeground(foreground);
            main.pluginManager.jLabel7.setForeground(foreground); main.pluginManager.jLabel8.setForeground(foreground);
            main.pluginManager.jLabel9.setForeground(foreground); main.pluginManager.jLabel10.setForeground(foreground);
            main.pluginManager.jLabel11.setForeground(foreground); main.pluginManager.jLabel12.setForeground(foreground);
            main.pluginManager.jLabel13.setForeground(foreground); main.pluginManager.jLabel14.setForeground(foreground);
            main.pluginManager.jLabel15.setForeground(foreground); main.pluginManager.jLabel16.setForeground(foreground);
            main.pluginManager.jLabel17.setForeground(foreground); main.pluginManager.jLabel18.setForeground(foreground);
            main.pluginManager.jLabel19.setForeground(foreground); 
            main.pluginManager.jPanel1.setBorder(border); main.pluginManager.jPanel1.setBackground(background);
            main.pluginManager.jPanel1.setForeground(foreground); main.pluginManager.jPanel2.setForeground(foreground); 
            main.pluginManager.jPanel2.setBorder(border); main.pluginManager.jPanel2.setBackground(background);
            main.pluginManager.jPanel3.setBorder(border); main.pluginManager.jPanel3.setBackground(background);
            main.pluginManager.jPanel3.setForeground(foreground); main.pluginManager.jPanel4.setForeground(foreground); 
            main.pluginManager.jPanel4.setBorder(border); main.pluginManager.jPanel4.setBackground(background);
            main.pluginManager.jPanel5.setBorder(border); main.pluginManager.jPanel5.setBackground(background);
            main.pluginManager.jPanel5.setForeground(foreground); main.pluginManager.jPanel6.setForeground(foreground); 
            main.pluginManager.jPanel6.setBorder(border); main.pluginManager.jPanel6.setBackground(background);
            main.pluginManager.jPanel7.setBorder(border); main.pluginManager.jPanel7.setBackground(background);
            main.pluginManager.jPanel7.setForeground(foreground); main.pluginManager.jPanel8.setForeground(foreground); 
            main.pluginManager.jPanel8.setBorder(border); main.pluginManager.jPanel8.setBackground(background);
            main.pluginManager.jPanel9.setBorder(border); main.pluginManager.jPanel9.setBackground(background);
            main.pluginManager.jPanel9.setForeground(foreground); main.pluginManager.jPanel10.setForeground(foreground); 
            main.pluginManager.jPanel10.setBorder(border); main.pluginManager.jPanel10.setBackground(background);
            main.pluginManager.jPanel1.setBorder(border); main.pluginManager.jPanel11.setBackground(background);
            main.pluginManager.jPanel11.setForeground(foreground); main.pluginManager.jTabbedPane1.setForeground(foreground);
            main.pluginManager.jScrollPane1.setForeground(foreground); main.pluginManager.jScrollPane1.setBorder(border);
            main.pluginManager.jScrollPane2.setBackground(background); main.pluginManager.jScrollPane1.setBackground(background); 
            main.pluginManager.jScrollPane2.setForeground(foreground); main.pluginManager.jScrollPane2.setBorder(border);
            main.pluginManager.jScrollPane3.setForeground(foreground); main.pluginManager.jScrollPane3.setBorder(border);
            main.pluginManager.jScrollPane4.setBackground(background); main.pluginManager.jScrollPane3.setBackground(background); 
            main.pluginManager.jScrollPane4.setForeground(foreground); main.pluginManager.jScrollPane4.setBorder(border);
            main.pluginManager.jScrollPane5.setForeground(foreground); main.pluginManager.jScrollPane5.setBorder(border);
            main.pluginManager.jScrollPane6.setBackground(background); main.pluginManager.jScrollPane5.setBackground(background); 
            main.pluginManager.jScrollPane6.setForeground(foreground); main.pluginManager.jScrollPane6.setBorder(border);
            main.pluginManager.jList1.setForeground(foreground); main.pluginManager.jList1.setBorder(border); 
            main.pluginManager.jList1.setBackground(background); main.pluginManager.jList2.setForeground(foreground); 
            main.pluginManager.jList2.setBorder(border); main.pluginManager.jList2.setBackground(background); 
            main.pluginManager.jTextArea1.setBorder(border); main.pluginManager.jTextArea2.setBorder(border); 
            main.pluginManager.jTextArea1.setBackground(background); main.pluginManager.jTextArea1.setForeground(foreground); 
            main.pluginManager.jTextArea2.setBackground(background); main.pluginManager.jTextArea2.setForeground(foreground); 
            main.pluginManager.jTextArea3.setBackground(background); main.pluginManager.jTextArea3.setForeground(foreground);
            main.pluginManager.jTextArea3.setBorder(border); main.pluginManager.jTabbedPane1.setUI(new CustomTabbedPaneUI(selected, unselected, gradient)); 
            main.pluginManager.jScrollPane2.getVerticalScrollBar().setUI(new SBV()); main.pluginManager.jScrollPane2.getHorizontalScrollBar().setUI(new SBH());
            main.pluginManager.jScrollPane1.getVerticalScrollBar().setUI(new SBV()); main.pluginManager.jScrollPane1.getHorizontalScrollBar().setUI(new SBH());
            main.pluginManager.jScrollPane3.getVerticalScrollBar().setUI(new SBV()); main.pluginManager.jScrollPane3.getHorizontalScrollBar().setUI(new SBH());
            main.pluginManager.jScrollPane4.getVerticalScrollBar().setUI(new SBV()); main.pluginManager.jScrollPane4.getHorizontalScrollBar().setUI(new SBH());
            main.pluginManager.jScrollPane5.getVerticalScrollBar().setUI(new SBV()); main.pluginManager.jScrollPane5.getHorizontalScrollBar().setUI(new SBH());
            main.pluginManager.jScrollPane6.getVerticalScrollBar().setUI(new SBV()); main.pluginManager.jScrollPane6.getHorizontalScrollBar().setUI(new SBH());
            main.pluginManager.jTable1.setBackground(background); main.pluginManager.jTable1.setForeground(foreground);
            main.pluginManager.jSplitPane1.setUI(new ApplyToDivider(unselected)); main.pluginManager.setForeground(foreground);
            main.pluginManager.jTable1.setBorder(border); main.pluginManager.jSplitPane1.setBorder(border);
            
            //About panel
            main.aboutPanel.jPanel1.setBorder(border); main.aboutPanel.jPanel1.setBackground(background);
            main.aboutPanel.jPanel1.setForeground(foreground); 
            main.aboutPanel.jButton1.setForeground(foreground); main.aboutPanel.jButton1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.aboutPanel.jButton1.setBackground(background); main.aboutPanel.jButton1.setContentAreaFilled(false);
            main.aboutPanel.jLabel1.setForeground(foreground); main.aboutPanel.jLabel2.setForeground(foreground);
            main.aboutPanel.jLabel3.setForeground(foreground); main.aboutPanel.jLabel4.setForeground(foreground);
            main.aboutPanel.jLabel5.setForeground(foreground); main.aboutPanel.jLabel6.setForeground(foreground);
            main.aboutPanel.jLabel7.setForeground(foreground); main.aboutPanel.jLabel8.setForeground(foreground);
            main.aboutPanel.jLabel9.setForeground(foreground); main.aboutPanel.jLabel10.setForeground(foreground);
            main.aboutPanel.jLabel11.setForeground(foreground); main.aboutPanel.jLabel12.setForeground(foreground);
            main.aboutPanel.jLabel13.setForeground(foreground); main.aboutPanel.jLabel14.setForeground(foreground);
            main.aboutPanel.jLabel15.setForeground(foreground); main.aboutPanel.jLabel16.setForeground(foreground);
            main.aboutPanel.jLabel17.setForeground(foreground); main.aboutPanel.jLabel18.setForeground(foreground);
            main.aboutPanel.jLabel18.setForeground(foreground); main.aboutPanel.jLabel20.setForeground(foreground);
            main.aboutPanel.jLabel21.setForeground(foreground); main.aboutPanel.jLabel22.setForeground(foreground);
            main.aboutPanel.jLabel23.setForeground(foreground); main.aboutPanel.jLabel24.setForeground(foreground);
            main.aboutPanel.jLabel25.setForeground(foreground); main.aboutPanel.jLabel26.setForeground(foreground);
            main.aboutPanel.jLabel19.setForeground(foreground);
            
            //Run Panel
            main.runPanel.jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Program/File To Run", javax.swing.
                    border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new 
                    java.awt.Font("Tahoma", 0, 11), foreground)); 
            main.runPanel.jPanel1.setBackground(background);
            main.runPanel.jPanel1.setForeground(foreground); main.runPanel.jPanel2.setForeground(foreground); 
            main.runPanel.jPanel2.setBorder(border); main.runPanel.jPanel2.setBackground(background);
            main.runPanel.jButton1.setForeground(foreground); main.runPanel.jButton1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.runPanel.jButton1.setBackground(background); main.runPanel.jButton1.setContentAreaFilled(false);
            main.runPanel.jButton2.setForeground(foreground); main.runPanel.jButton2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.runPanel.jButton2.setBackground(background); main.runPanel.jButton2.setContentAreaFilled(false);
            main.runPanel.jButton3.setForeground(foreground); main.runPanel.jButton3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.runPanel.jButton3.setBackground(background); main.runPanel.jButton3.setContentAreaFilled(false);
            
            //Websearch Panel
            main.websearchPanel.jPanel1.setForeground(foreground); 
            main.websearchPanel.jPanel1.setBorder(border); main.websearchPanel.jPanel1.setBackground(background);
            main.websearchPanel.jButton1.setForeground(foreground); main.websearchPanel.jButton1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.websearchPanel.jButton1.setBackground(background); main.websearchPanel.jButton1.setContentAreaFilled(false);
            main.websearchPanel.jButton2.setForeground(foreground); main.websearchPanel.jButton2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.websearchPanel.jButton2.setBackground(background); main.websearchPanel.jButton2.setContentAreaFilled(false);
            main.websearchPanel.jButton3.setForeground(foreground); main.websearchPanel.jButton3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.websearchPanel.jButton3.setBackground(background); main.websearchPanel.jButton3.setContentAreaFilled(false);
            main.websearchPanel.jButton4.setForeground(foreground); main.websearchPanel.jButton4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.websearchPanel.jButton4.setBackground(background); main.websearchPanel.jButton4.setContentAreaFilled(false);
            main.websearchPanel.jButton5.setForeground(foreground); main.websearchPanel.jButton5.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.websearchPanel.jButton5.setBackground(background); main.websearchPanel.jButton5.setContentAreaFilled(false);
            
            //first run panel
            main.firstrund.jPanel1.setBackground(background);
            main.firstrund.jPanel1.setForeground(foreground); main.firstrund.jPanel2.setForeground(foreground); 
            main.firstrund.jPanel2.setBorder(border); main.firstrund.jPanel2.setBackground(background);
            main.firstrund.jPanel3.setForeground(foreground); 
            main.firstrund.jPanel3.setBorder(border); main.firstrund.jPanel3.setBackground(background);
            main.firstrund.jPanel4.setForeground(foreground); 
            main.firstrund.jPanel4.setBorder(border); main.firstrund.jPanel4.setBackground(background);
            main.firstrund.jPanel5.setForeground(foreground); 
            main.firstrund.jPanel5.setBorder(border); main.firstrund.jPanel5.setBackground(background);
            main.firstrund.jPanel6.setForeground(foreground); 
            main.firstrund.jPanel6.setBorder(border); main.firstrund.jPanel6.setBackground(background);
            main.firstrund.jPanel7.setForeground(foreground); 
            main.firstrund.jPanel7.setBorder(border); main.firstrund.jPanel7.setBackground(background);
            main.firstrund.jButton1.setForeground(foreground); main.firstrund.jButton1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.firstrund.jButton1.setBackground(background); main.firstrund.jButton1.setContentAreaFilled(false);
            main.firstrund.jLabel1.setForeground(foreground); main.firstrund.jLabel2.setForeground(foreground);
            main.firstrund.jLabel3.setForeground(foreground); main.firstrund.jLabel4.setForeground(foreground);
            main.firstrund.jLabel5.setForeground(foreground); main.firstrund.jLabel6.setForeground(foreground);
            main.firstrund.jLabel7.setForeground(foreground); main.firstrund.jLabel8.setForeground(foreground);
            main.firstrund.jLabel9.setForeground(foreground); main.firstrund.jTextArea1.setBorder(border); 
            main.firstrund.jTextArea1.setBackground(background); main.firstrund.jTextArea1.setForeground(foreground); 
            main.firstrund.jTextArea2.setBorder(border); 
            main.firstrund.jTextArea2.setBackground(background); main.firstrund.jTextArea2.setForeground(foreground); 
            main.firstrund.jTextArea3.setBorder(border); 
            main.firstrund.jTextArea3.setBackground(background); main.firstrund.jTextArea3.setForeground(foreground); 
            main.firstrund.jTextArea4.setBorder(border); 
            main.firstrund.jTextArea4.setBackground(background); main.firstrund.jTextArea4.setForeground(foreground); 
            main.firstrund.jProgressBar1.setForeground(foreground); main.firstrund.jProgressBar1.setBackground(background); 
            
            themeThemeManager(); applyToEditor(); dealWithDMap();
        }
        
        private void themeThemeManager() {
            //theme manager panels
            main.themeManager.jPanel1.setForeground(foreground); 
            main.themeManager.jPanel1.setBorder(border); main.themeManager.jPanel1.setBackground(background);
            main.themeManager.jPanel2.setForeground(foreground); 
            main.themeManager.jPanel2.setBorder(border); main.themeManager.jPanel2.setBackground(borderColor);
            main.themeManager.jPanel3.setForeground(foreground); 
            main.themeManager.jPanel3.setBorder(border); main.themeManager.jPanel3.setBackground(background);
            main.themeManager.jPanel4.setForeground(foreground); 
            main.themeManager.jPanel4.setBorder(border); main.themeManager.jPanel4.setBackground(background);
            main.themeManager.jPanel5.setForeground(foreground); 
            main.themeManager.jPanel5.setBorder(border); main.themeManager.jPanel5.setBackground(background);
            main.themeManager.jPanel6.setForeground(foreground); 
            main.themeManager.jPanel6.setBorder(border); main.themeManager.jPanel6.setBackground(background);
            main.themeManager.jPanel8.setForeground(foreground); 
            main.themeManager.jPanel8.setBorder(border); main.themeManager.jPanel8.setBackground(background);
            main.themeManager.tabPane.setForeground(foreground); 
            main.themeManager.tabPane.setBorder(border); main.themeManager.tabPane.setBackground(background);
            main.themeManager.tabPane.setUI(new CustomTabbedPaneUI(selected, unselected, gradient)); 
            
            //theme manager buttons
            main.themeManager.jButton1.setForeground(foreground); main.themeManager.jButton1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.themeManager.jButton1.setBackground(background); main.themeManager.jButton1.setContentAreaFilled(false);
            main.themeManager.jButton2.setForeground(foreground); main.themeManager.jButton2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.themeManager.jButton2.setBackground(background); main.themeManager.jButton2.setContentAreaFilled(false);
            main.themeManager.jButton3.setForeground(foreground); main.themeManager.jButton3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.themeManager.jButton3.setBackground(background); main.themeManager.jButton3.setContentAreaFilled(false);
            //main.themeManager.jButton4.setForeground(foreground); main.themeManager.jButton4.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            //main.themeManager.jButton4.setBackground(background); main.themeManager.jButton4.setContentAreaFilled(false);
            main.themeManager.jButton5.setForeground(foreground); main.themeManager.jButton5.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.themeManager.jButton5.setBackground(background); main.themeManager.jButton5.setContentAreaFilled(false);
            main.themeManager.jButton6.setForeground(foreground); main.themeManager.jButton6.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, unselected));
            main.themeManager.jButton6.setBackground(background); main.themeManager.jButton6.setContentAreaFilled(false);
            
            //theme manager checkbox
            main.themeManager.jCheckBox1.setForeground(foreground); main.themeManager.jCheckBox1.setBackground(background);
            main.themeManager.jCheckBox2.setForeground(foreground); main.themeManager.jCheckBox2.setBackground(background);
            main.themeManager.jCheckBox3.setForeground(foreground); main.themeManager.jCheckBox3.setBackground(background);
            main.themeManager.jCheckBox4.setForeground(foreground); main.themeManager.jCheckBox4.setBackground(background);
            main.themeManager.jCheckBox5.setForeground(foreground); main.themeManager.jCheckBox5.setBackground(background);
            main.themeManager.jCheckBox6.setForeground(foreground); main.themeManager.jCheckBox6.setBackground(background);
            main.themeManager.jCheckBox7.setForeground(foreground); main.themeManager.jCheckBox7.setBackground(background);
            main.themeManager.jCheckBox8.setForeground(foreground); main.themeManager.jCheckBox8.setBackground(background);
            main.themeManager.jCheckBox9.setForeground(foreground); main.themeManager.jCheckBox9.setBackground(background);
            main.themeManager.jCheckBox10.setForeground(foreground); main.themeManager.jCheckBox10.setBackground(background);
            main.themeManager.jCheckBox11.setForeground(foreground); main.themeManager.jCheckBox11.setBackground(background);
            main.themeManager.jCheckBox12.setForeground(foreground); main.themeManager.jCheckBox12.setBackground(background);
            
            //theme manager scrllpane and ptextarea
            main.themeManager.display.setForeground(foreground); main.themeManager.display.setBackground(background);
            main.themeManager.display2.setForeground(foreground); main.themeManager.display2.setBackground(background);
            main.themeManager.display.setSyntaxScheme(pluginManagercheme);  main.themeManager.display2.setSyntaxScheme(pluginManagercheme);
            main.themeManager.display.setForeground(foreground); main.themeManager.display.setBackground(background);
            main.themeManager.scrollPane.setForeground(foreground); main.themeManager.scrollPane.setBackground(background);
            main.themeManager.scrollPane2.setForeground(foreground); main.themeManager.scrollPane2.setBackground(background);
            main.themeManager.scrollPane.getGutter().setBackground(background); main.themeManager.scrollPane2.getGutter().setBackground(background);
            main.themeManager.scrollPane.getGutter().setBorder(border); main.themeManager.scrollPane2.getGutter().setBorder(border);
            main.themeManager.scrollPane.getGutter().setLineNumberColor(foreground); main.themeManager.scrollPane2.getGutter().setLineNumberColor(foreground);
            main.themeManager.scrollPane.getVerticalScrollBar().setUI(new SBV()); main.themeManager.scrollPane.getHorizontalScrollBar().setUI(new SBH());
            main.themeManager.scrollPane2.getVerticalScrollBar().setUI(new SBV()); main.themeManager.scrollPane2.getHorizontalScrollBar().setUI(new SBH());
            main.themeManager.scrollPane.setBorder(border); main.themeManager.scrollPane2.setBorder(border);
            main.themeManager.scrollPane.getGutter().setActiveLineRangeColor(activeLineRangeColor); main.themeManager.scrollPane2.getGutter().setActiveLineRangeColor(activeLineRangeColor);
            main.themeManager.scrollPane.getGutter().setBorderColor(borderColor); main.themeManager.scrollPane2.getGutter().setBorderColor(borderColor);
            
            //theme manager labels
            main.themeManager.jLabel1.setForeground(foreground); main.themeManager.jLabel2.setForeground(foreground);
            main.themeManager.jLabel3.setForeground(foreground); main.themeManager.jLabel4.setForeground(foreground);
            main.themeManager.jLabel5.setForeground(foreground); main.themeManager.jLabel6.setForeground(foreground);
            main.themeManager.jLabel7.setForeground(foreground); main.themeManager.jLabel8.setForeground(foreground);
            main.themeManager.jLabel9.setForeground(foreground); main.themeManager.jLabel10.setForeground(foreground);
            main.themeManager.jLabel11.setForeground(foreground); main.themeManager.jLabel12.setForeground(foreground);
            main.themeManager.jLabel13.setForeground(foreground); main.themeManager.jLabel14.setForeground(foreground);
            main.themeManager.jLabel15.setForeground(foreground); main.themeManager.jLabel16.setForeground(foreground);
            main.themeManager.jLabel17.setForeground(foreground); main.themeManager.jLabel18.setForeground(foreground);
            main.themeManager.jLabel54.setForeground(foreground); main.themeManager.jLabel20.setForeground(foreground);
            main.themeManager.jLabel21.setForeground(foreground); main.themeManager.jLabel22.setForeground(foreground);
            main.themeManager.jLabel23.setForeground(foreground); main.themeManager.jLabel24.setForeground(foreground);
            main.themeManager.jLabel25.setForeground(foreground); main.themeManager.jLabel26.setForeground(foreground);
            main.themeManager.jLabel19.setForeground(foreground); main.themeManager.jLabel27.setForeground(foreground); 
            main.themeManager.jLabel28.setForeground(foreground); main.themeManager.jLabel29.setForeground(foreground);
            main.themeManager.jLabel30.setForeground(foreground); main.themeManager.jLabel31.setForeground(foreground);
            main.themeManager.jLabel32.setForeground(foreground); main.themeManager.jLabel33.setForeground(foreground);
            main.themeManager.jLabel34.setForeground(foreground); main.themeManager.jLabel35.setForeground(foreground);
            main.themeManager.jLabel36.setForeground(foreground); main.themeManager.jLabel37.setForeground(foreground);
            main.themeManager.jLabel38.setForeground(foreground); main.themeManager.jLabel39.setForeground(foreground);
            main.themeManager.jLabel40.setForeground(foreground); main.themeManager.jLabel41.setForeground(foreground);
            main.themeManager.jLabel42.setForeground(foreground); main.themeManager.jLabel43.setForeground(foreground);
            main.themeManager.jLabel44.setForeground(foreground); main.themeManager.jLabel45.setForeground(foreground);
            main.themeManager.jLabel46.setForeground(foreground); main.themeManager.jLabel47.setForeground(foreground);
            main.themeManager.jLabel48.setForeground(foreground); main.themeManager.jLabel49.setForeground(foreground);
            main.themeManager.jLabel50.setForeground(foreground); main.themeManager.jLabel51.setForeground(foreground);
            main.themeManager.jLabel52.setForeground(foreground); main.themeManager.jLabel53.setForeground(foreground);
            main.themeManager.jLabel55.setForeground(foreground); main.themeManager.jLabel56.setForeground(foreground);
            main.themeManager.jLabel57.setForeground(foreground); main.themeManager.jLabel58.setForeground(foreground);
            main.themeManager.jLabel59.setForeground(foreground); main.themeManager.jLabel60.setForeground(foreground);
            main.themeManager.jLabel61.setForeground(foreground); main.themeManager.jLabel62.setForeground(foreground);
            main.themeManager.jLabel63.setForeground(foreground); main.themeManager.jLabel64.setForeground(foreground);
            main.themeManager.jLabel65.setForeground(foreground); main.themeManager.jLabel66.setForeground(foreground);
            main.themeManager.jLabel67.setForeground(foreground); main.themeManager.jLabel69.setForeground(foreground);
            main.themeManager.jLabel69.setForeground(foreground); main.themeManager.jLabel70.setForeground(foreground);
            main.themeManager.jLabel71.setForeground(foreground); main.themeManager.jLabel72.setForeground(foreground);
            main.themeManager.jLabel68.setForeground(foreground);
            
            //theme manager textfields
            main.themeManager.jTextField1.setBackground(background); main.themeManager.jTextField2.setBackground(foreground);
            main.themeManager.jTextField3.setBackground(borderColor); main.themeManager.jTextField4.setBackground(selected);
            main.themeManager.jTextField5.setBackground(unselected); main.themeManager.jTextField6.setBackground(caretColor);
            main.themeManager.jTextField7.setBackground(selectionBG); main.themeManager.jTextField8.setBackground(selectionFG);
            main.themeManager.jTextField9.setBackground(currentLineHighlight); main.themeManager.jTextField14.setBackground(matchedBracketBG);
            main.themeManager.jTextField15.setBackground(hyperlinkFG); main.themeManager.jTextField12.setBackground(markOccurrencesColor);
            main.themeManager.jTextField10.setBackground(marginLineColor); main.themeManager.jTextField11.setBackground(markAllHighlightColor);
            main.themeManager.jTextField13.setBackground(matchedBracketFG); main.themeManager.jTextField16.setBackground(secondaryLanguages[0]);
            main.themeManager.jTextField17.setBackground(secondaryLanguages[1]); main.themeManager.jTextField18.setBackground(secondaryLanguages[2]);
            main.themeManager.jTextField19.setBackground(scheme.getStyle(0).foreground); main.themeManager.jTextField20.setBackground(scheme.getStyle(1).foreground);
            main.themeManager.jTextField21.setBackground(scheme.getStyle(2).foreground); main.themeManager.jTextField22.setBackground(scheme.getStyle(3).foreground);
            main.themeManager.jTextField23.setBackground(scheme.getStyle(4).foreground); main.themeManager.jTextField24.setBackground(scheme.getStyle(5).foreground);
            main.themeManager.jTextField25.setBackground(scheme.getStyle(6).foreground); main.themeManager.jTextField26.setBackground(scheme.getStyle(7).foreground);
            main.themeManager.jTextField27.setBackground(scheme.getStyle(8).foreground); main.themeManager.jTextField28.setBackground(scheme.getStyle(9).foreground);
            main.themeManager.jTextField29.setBackground(scheme.getStyle(10).foreground); main.themeManager.jTextField30.setBackground(scheme.getStyle(11).foreground);
            main.themeManager.jTextField31.setBackground(scheme.getStyle(12).foreground); main.themeManager.jTextField32.setBackground(scheme.getStyle(13).foreground);
            main.themeManager.jTextField33.setBackground(scheme.getStyle(14).foreground); main.themeManager.jTextField34.setBackground(scheme.getStyle(15).foreground);
            main.themeManager.jTextField35.setBackground(scheme.getStyle(16).foreground); main.themeManager.jTextField36.setBackground(scheme.getStyle(17).foreground);
            main.themeManager.jTextField37.setBackground(scheme.getStyle(18).foreground); main.themeManager.jTextField38.setBackground(scheme.getStyle(19).foreground);
            main.themeManager.jTextField39.setBackground(scheme.getStyle(20).foreground); main.themeManager.jTextField40.setBackground(scheme.getStyle(21).foreground);
            main.themeManager.jTextField41.setBackground(scheme.getStyle(22).foreground); main.themeManager.jTextField42.setBackground(scheme.getStyle(23).foreground);
            main.themeManager.jTextField43.setBackground(scheme.getStyle(24).foreground); main.themeManager.jTextField44.setBackground(scheme.getStyle(25).foreground);
            main.themeManager.jTextField45.setBackground(scheme.getStyle(26).foreground); main.themeManager.jTextField46.setBackground(scheme.getStyle(27).foreground);
            main.themeManager.jTextField47.setBackground(scheme.getStyle(28).foreground); main.themeManager.jTextField48.setBackground(scheme.getStyle(29).foreground);
            main.themeManager.jTextField49.setBackground(scheme.getStyle(30).foreground); main.themeManager.jTextField50.setBackground(scheme.getStyle(31).foreground);
            main.themeManager.jTextField51.setBackground(scheme.getStyle(32).foreground); main.themeManager.jTextField52.setBackground(scheme.getStyle(33).foreground);
            main.themeManager.jTextField53.setBackground(scheme.getStyle(34).foreground); main.themeManager.jTextField54.setBackground(scheme.getStyle(35).foreground);
            main.themeManager.jTextField55.setBackground(scheme.getStyle(36).foreground); main.themeManager.jTextField56.setBackground(scheme.getStyle(37).foreground);
            
            //theme manager variables > colors and booleans <
            main.themeManager.background = background ;
            main.themeManager.foreground = foreground;;
            main.themeManager.borderColor = borderColor;
            main.themeManager.selected = selected;
            main.themeManager.unselected = unselected;
            main.themeManager.baseFont = baseFont;
            main.themeManager.gradient = gradient;
            main.themeManager.caretColor = caretColor;
            main.themeManager.useSelctionFG = useSelctionFG;
            main.themeManager.selectionFG = selectionFG;
            main.themeManager.selectionBG = selectionBG;
            main.themeManager.selectionRoundedEdges = selectionRoundedEdges;
            main.themeManager.currentLineHighlight = currentLineHighlight;
            main.themeManager.fadeCurrentLineHighlight = fadeCurrentLineHighlight;
            main.themeManager.marginLineColor = marginLineColor;
            main.themeManager.markAllHighlightColor = markAllHighlightColor;
            main.themeManager.markOccurrencesColor = markOccurrencesColor;
            main.themeManager.markOccurrencesBorder = markOccurrencesBorder;
            main.themeManager.matchedBracketFG = matchedBracketFG;
            main.themeManager.matchedBracketBG = matchedBracketBG;
            main.themeManager.matchedBracketHighlightBoth = matchedBracketHighlightBoth;
            main.themeManager.matchedBracketAnimate = matchedBracketAnimate;
            main.themeManager.hyperlinkFG = hyperlinkFG;
            main.themeManager.secondaryLanguages = secondaryLanguages;
            main.themeManager.scheme = scheme;
            main.themeManager.gutterBorderColor = gutterBorderColor;
            main.themeManager.activeLineRangeColor = activeLineRangeColor;
            main.themeManager.iconRowHeaderInheritsGutterBG = iconRowHeaderInheritsGutterBG;
            main.themeManager.lineNumberColor = lineNumberColor;
            main.themeManager.lineNumberFont = lineNumberFont;
            main.themeManager.lineNumberFontSize = lineNumberFontSize;
            main.themeManager.foldIndicatorFG = foldIndicatorFG;
            main.themeManager.foldBG = foldBG;
            
        }
        
        private void dealWithDMap() {
                main.themeManager.setFont(new java.awt.Font("Corbel", 0, 5)); 
                main.documentMap.setBackground(background); main.documentMap.setForeground(foreground);
                main.documentMap.setSelectionColor(selectionBG);
                main.documentMap.setCurrentLineHighlightColor(currentLineHighlight);
                main.documentMap.setHyperlinkForeground(hyperlinkFG);
                main.documentMap.setCaretColor(background);
                main.documentMap.setEditable(false);
                main.documentMap.setFadeCurrentLineHighlight(fadeCurrentLineHighlight);
                
                int count = secondaryLanguages.length;
		for (int i=0; i<count; i++) {
			main.documentMap.setSecondaryLanguageBackground(i+1, secondaryLanguages[i]);
		}

                main.documentMap.setSyntaxScheme(dMScheme);  
        }
        
        private void applyToEditor() {
            for (int a = 0; a < main.jTabbedPane1.getTabCount(); a++) {
                applyPTScrollPane((RTextScrollPane) main.Editor.get(a).getScrollPane());
                applyPTextArea((RSyntaxTextArea) main.Editor.get(a).getTextPane());
                main.Editor.get(a).getDesktopPane().setBackground(background);
            }  addBackground = background ;addForeground = foreground ; line = currentLineHighlight;
            addscheme = scheme ;
        }
        
        private void applyPTextArea(RSyntaxTextArea textArea) {
                textArea.setFont(baseFont);
		textArea.setBackground(background);
                textArea.setForeground(foreground);
		textArea.setCaretColor(caretColor);
		textArea.setUseSelectedTextColor(false);
		textArea.setSelectedTextColor(selectionFG);
		textArea.setSelectionColor(selectionBG);
		textArea.setRoundedSelectionEdges(selectionRoundedEdges);
		textArea.setCurrentLineHighlightColor(currentLineHighlight);
		textArea.setFadeCurrentLineHighlight(fadeCurrentLineHighlight);
		textArea.setMarginLineColor(marginLineColor);
		textArea.setMarkAllHighlightColor(markAllHighlightColor);
		textArea.setMarkOccurrencesColor(markOccurrencesColor);
		textArea.setPaintMarkOccurrencesBorder(markOccurrencesBorder);
		textArea.setMatchedBracketBGColor(matchedBracketBG);
		textArea.setMatchedBracketBorderColor(matchedBracketFG);
		textArea.setPaintMatchedBracketPair(matchedBracketHighlightBoth);
		textArea.setAnimateBracketMatching(matchedBracketAnimate);
		textArea.setHyperlinkForeground(hyperlinkFG);

		int count = secondaryLanguages.length;
		for (int i=0; i<count; i++) {
			textArea.setSecondaryLanguageBackground(i+1, secondaryLanguages[i]);
		}

		textArea.setSyntaxScheme(scheme);  

        }
        
        private void applyPTScrollPane(RTextScrollPane scrollPane) {
            scrollPane.setBackground(foreground);
            scrollPane.setForeground(foreground);
            scrollPane.setBorder(border);
            scrollPane.getGutter().setBackground(background);
            scrollPane.getGutter().setForeground(foreground);
            scrollPane.getGutter().setBorder(border);
            scrollPane.getGutter().setFoldBackground(background);
            scrollPane.getGutter().setFoldIndicatorForeground(foreground);
            scrollPane.getGutter().setLineNumberColor(foreground);
            scrollPane.getGutter().setBorderColor(borderColor);
            scrollPane.getGutter().setActiveLineRangeColor(activeLineRangeColor);
            scrollPane.getGutter().setIconRowHeaderInheritsGutterBackground(true);
            scrollPane.getViewport().setBackground(background);
            scrollPane.setOpaque(false);
            scrollPane.getVerticalScrollBar().setUI(new SBV());
            scrollPane.getHorizontalScrollBar().setUI(new SBH());
            
            /*Gutter gutter = scrollPane.getGutter();
		if (gutter!=null) {
			gutter.setBackground(background);
			gutter.setBorderColor(gutterBorderColor);
			gutter.setActiveLineRangeColor(activeLineRangeColor);
			gutter.setIconRowHeaderInheritsGutterBackground(iconRowHeaderInheritsGutterBG);
			gutter.setLineNumberColor(lineNumberColor);
			String fontName = lineNumberFont!=null ? lineNumberFont :
				baseFont.getFamily();
			int fontSize = lineNumberFontSize>0 ? lineNumberFontSize :
				baseFont.getSize();
			Font font = getFont(fontName, Font.PLAIN, fontSize);
			gutter.setLineNumberFont(font);
			gutter.setFoldIndicatorForeground(foldIndicatorFG);
			gutter.setFoldBackground(foldBG);
		}*/ //
        }
        
        private static Font getFont(String family, int style, int size) {
		// Use StyleContext to get a composite font for Asian glyphs.
		StyleContext sc = StyleContext.getDefaultStyleContext();
		return sc.getFont(family, style, size);
	}
        
        public static String colorToString(Color c) {
		int color = c.getRGB() & 0xffffff;
        StringBuilder stringBuilder = new StringBuilder(Integer.toHexString(color));
		while (stringBuilder.length()<6) {
            stringBuilder.insert(0, "0");
		}
		return stringBuilder.toString();
	}
        
        private Color getDefaultBG() {
		Color c = UIManager.getColor("nimbusLightBackground");
		if (c==null) {
			// Don't search for "text", as Nimbus defines that as the text
			// component "text" color, but Basic LAFs use it for text
			// component backgrounds!  Nimbus also defines TextArea.background
			// as too dark, not what it actually uses for text area backgrounds
			c = UIManager.getColor("TextArea.background");
			if (c==null) {
				c = new ColorUIResource(SystemColor.text);
			}
		}
		return c;
	}
        
        public void loadTheme(InputStream in) {
            LoadThemeXML ltxml = new LoadThemeXML(in) ;
            ltxml.run();
        }
        
        private static Color stringToColor(String s) {
		return stringToColor(s, null);
	}
        
        private static Color stringToColor(String s, Color defaultVal) {
		if (s==null || "default".equalsIgnoreCase(s)) {
			return defaultVal;
		}
		if (s.length()==6 || s.length()==7) {
			if (s.charAt(0)=='$') {
				s = s.substring(1);
			}
			return new Color(Integer.parseInt(s, 16));
		}
		return null;
	}

        
        public void createTheme(OutputStream out) {
            
        }
        
        class LoadThemeXML implements Runnable {

        InputStream stream ;
        
        public LoadThemeXML(InputStream in) {
            this.stream = in ;
        }
        
        @Override
        public void run() {
            try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(stream); doc.getDocumentElement().normalize();
                
                System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
                
                NodeList nList = doc.getElementsByTagName("Basic-Components");
                System.out.println("----------------------------");
                for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element : " + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("Id : " + eElement.getAttribute("id"));
                    String backgroundXML = eElement.getElementsByTagName("background").item(0).getTextContent();
                    System.out.println("Backgound : " + backgroundXML); background = stringToColor(backgroundXML);
                    String foregroundXML = eElement.getElementsByTagName("foreground").item(0).getTextContent();
                    System.out.println("Foreground : " + foregroundXML); foreground = stringToColor(foregroundXML);
                    String borderXML = eElement.getElementsByTagName("border").item(0).getTextContent();
                    System.out.println("border : " + borderXML); 
                    if (borderXML.equals("null")) {
                        border = null ; borderColor = background ;
                    } else {
                        border = BorderFactory.createLineBorder(stringToColor(borderXML)) ;
                        borderColor = stringToColor(borderXML);
                    }
                    
                    
                }
              }
                
              NodeList nList1 = doc.getElementsByTagName("Tab-Component");
                System.out.println("----------------------------");
                for (int temp = 0; temp < nList1.getLength(); temp++) {
                Node nNode = nList1.item(temp);
                System.out.println("\nCurrent Element : " + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("Id : " + eElement.getAttribute("id"));
                    String selectedXML = eElement.getElementsByTagName("selected").item(0).getTextContent();
                    System.out.println("selected : " + selectedXML); selected = stringToColor(selectedXML);
                    String unselectedXML = eElement.getElementsByTagName("unselected").item(0).getTextContent();
                    System.out.println("unselected : " + unselectedXML); unselected = stringToColor(unselectedXML);
                    String gradientXML = eElement.getElementsByTagName("gradient").item(0).getTextContent();
                    System.out.println("gradient : " + gradientXML); gradient = Boolean.parseBoolean(gradientXML);
                }
              }
                
              NodeList nList2 = doc.getElementsByTagName("PTextArea-Editor");
                System.out.println("----------------------------");
                for (int temp = 0; temp < nList2.getLength(); temp++) {
                Node nNode = nList2.item(temp);
                System.out.println("\nCurrent Element : " + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("Id : " + eElement.getAttribute("id"));
                    String caretXML = eElement.getElementsByTagName("caret").item(0).getTextContent();
                    System.out.println("caret : " + caretXML); caretColor = stringToColor(caretXML);
                    String selectionbackgroundXML = eElement.getElementsByTagName("selectionbackground").item(0).getTextContent();
                    System.out.println("selectionbackground : " + selectionbackgroundXML); selectionBG = stringToColor(selectionbackgroundXML);
                    String selectionforegroundXML = eElement.getElementsByTagName("selectionforeground").item(0).getTextContent();
                    System.out.println("selectionforeground : " + selectionforegroundXML); selectionFG = stringToColor(selectionforegroundXML);
                    String currentlinehighlightXML = eElement.getElementsByTagName("currentlinehighlight").item(0).getTextContent();
                    System.out.println("currentlinehighlight : " + currentlinehighlightXML); currentLineHighlight = stringToColor(currentlinehighlightXML);
                    String fadeCurrentLineHighlightXML = eElement.getElementsByTagName("currentlinehighlight-fade").item(0).getTextContent();
                    System.out.println("fadeCurrentLineHighlight : " + fadeCurrentLineHighlightXML); fadeCurrentLineHighlight = Boolean.parseBoolean(fadeCurrentLineHighlightXML);
                    String marginlineXML = eElement.getElementsByTagName("marginline").item(0).getTextContent();
                    System.out.println("marginline : " + marginlineXML); marginLineColor= stringToColor(marginlineXML);
                    String markallhighlightXML = eElement.getElementsByTagName("markallhighlight").item(0).getTextContent();
                    System.out.println("markallhighlight : " + markallhighlightXML); markAllHighlightColor = stringToColor(markallhighlightXML);
                    String markoccurrencehighlightXML = eElement.getElementsByTagName("markoccurrencehighlight").item(0).getTextContent();
                    System.out.println("markoccurrencehighlight : " + markoccurrencehighlightXML); markOccurrencesColor = stringToColor(markoccurrencehighlightXML);
                    String markoccurrenceborderXML = eElement.getElementsByTagName("markoccurrenceborder").item(0).getTextContent();
                    System.out.println("markoccurrenceborder : " + markoccurrenceborderXML); markOccurrencesBorder = Boolean.parseBoolean(markoccurrenceborderXML);
                    String matchbracketbackgroundXML = eElement.getElementsByTagName("matchbracketbackground").item(0).getTextContent();
                    System.out.println("matchbracketbackground : " + matchbracketbackgroundXML); matchedBracketBG = stringToColor(matchbracketbackgroundXML);
                    String matchbracketforegroundXML = eElement.getElementsByTagName("matchbracketforeground").item(0).getTextContent();
                    System.out.println("matchbracketforeground : " + matchbracketforegroundXML); matchedBracketFG = stringToColor(matchbracketforegroundXML);
                    String matchbracketanimateXML = eElement.getElementsByTagName("matchbracketanimate").item(0).getTextContent();
                    System.out.println("matchbracketanimate : " + matchbracketanimateXML); matchedBracketAnimate = Boolean.parseBoolean(matchbracketanimateXML);
                    String hyperlinksXML = eElement.getElementsByTagName("hyperlinks").item(0).getTextContent();
                    System.out.println("hyperlinks : " + hyperlinksXML); hyperlinkFG = stringToColor(hyperlinksXML);
                }
              }
                
              NodeList nList3 = doc.getElementsByTagName("Secondary-Languages");
                System.out.println("----------------------------");
                for (int temp = 0; temp < nList3.getLength(); temp++) {
                Node nNode = nList3.item(temp);
                System.out.println("\nCurrent Element : " + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("Id : " + eElement.getAttribute("id"));
                    String language1XML = eElement.getElementsByTagName("language1").item(0).getTextContent();
                    String language1bgXML = eElement.getElementsByTagName("language1bg").item(0).getTextContent();
                    System.out.println("index : " + language1XML+" bg : "+language1bgXML); 
                    secondaryLanguages[Integer.parseInt(language1XML)] = stringToColor(language1bgXML);
                    String language2XML = eElement.getElementsByTagName("language2").item(0).getTextContent();
                    String language2bgXML = eElement.getElementsByTagName("language2bg").item(0).getTextContent();
                    System.out.println("index : " + language2XML+" bg : "+language2bgXML); 
                    secondaryLanguages[Integer.parseInt(language2XML)] = stringToColor(language2bgXML);
                    String language3XML = eElement.getElementsByTagName("language3").item(0).getTextContent();
                    String language3bgXML = eElement.getElementsByTagName("language3bg").item(0).getTextContent();
                    System.out.println("index : " + language3XML+" bg : "+language3bgXML); 
                    secondaryLanguages[Integer.parseInt(language3XML)] = stringToColor(language3bgXML);
                    
                }
              }
                
              NodeList nList4 = doc.getElementsByTagName("tokenStyles");
                System.out.println("----------------------------");
                for (int temp = 0; temp < nList4.getLength(); temp++) {
                Node nNode = nList4.item(temp);
                System.out.println("\nCurrent Element : " + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("Id : " + eElement.getAttribute("id"));
                    scheme = new SyntaxScheme(baseFont, false);
                    dMScheme = new SyntaxScheme(new java.awt.Font("Corbel", 0, 5), false);
                    pluginManagercheme = new SyntaxScheme(new java.awt.Font("Corbel", 0, 10), false);
                }
              }
                
              NodeList nList5 = doc.getElementsByTagName("style");
                System.out.println("----------------------------");
                for (int temp = 0; temp < nList5.getLength(); temp++) {
                Node nNode = nList5.item(temp);
                System.out.println("\nCurrent Element : " + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    System.out.println("Id : " + eElement.getAttribute("token")+" bg : "+eElement.getAttribute("fg"));
                    String type = eElement.getAttribute("token"); Field field = null; 
		    try {
			field = Token.class.getField(type);
		    } catch (RuntimeException re) {
			throw re; // FindBugs
		    } catch (Exception e) {
			System.err.println("Invalid token type: " + type);
			return;
		   }
                    if (field.getType()==int.class) {

					int index = 0; int dmindex = 0 ; int tmindex = 0 ;
					try {
                                                dmindex = field.getInt(dMScheme);
                                                tmindex = field.getInt(pluginManagercheme);
						index = field.getInt(scheme);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
						return;
					} catch (IllegalAccessException e) {
						e.printStackTrace();
						return;
					}

					String fgStr = eElement.getAttribute("fg");
					Color fg = stringToColor(fgStr);
					scheme.getStyle(index).foreground = fg;
                                        dMScheme.getStyle(index).foreground = fg;
                                        pluginManagercheme.getStyle(index).foreground = fg;

					String bgStr = eElement.getAttribute("bg");
					Color bg = stringToColor(bgStr);
					scheme.getStyle(index).background = bg;
                                        dMScheme.getStyle(index).background = bg;
                                        pluginManagercheme.getStyle(index).background = bg;

					Font font = baseFont;
					String familyName = eElement.getAttribute("fontFamily");
					if (familyName!=null&&!familyName.equals("")) {
						font = getFont(familyName, font.getStyle(),
								font.getSize());
					}
					String sizeStr = eElement.getAttribute("fontSize");
                                        //System.out.println("floattttttt = "+sizeStr);
					if (sizeStr!=null&&!sizeStr.equals("")) {
						try {
							float size = Float.parseFloat(sizeStr);
							size = Math.max(size, 1f);
							font = font.deriveFont(size);
						} catch (NumberFormatException nfe) {
							//nfe.printStackTrace();
						}
					}
					scheme.getStyle(index).font = font;
                                        dMScheme.getStyle(index).font = new java.awt.Font("Corbel", 0, 5);
                                        pluginManagercheme.getStyle(index).font = new java.awt.Font("Corbel", 0, 10);

					boolean styleSpecified = false;
					boolean bold = false;
					boolean italic = false;
					String boldStr = eElement.getAttribute("bold");
					if (boldStr!=null) {
						bold = Boolean.parseBoolean(boldStr);
						styleSpecified = true;
					}
					String italicStr = eElement.getAttribute("italic");
					if (italicStr!=null&&!italicStr.equals("")) {
						italic = Boolean.parseBoolean(italicStr);
						styleSpecified = true;
					}
					if (styleSpecified) {
						int style = 0;
						if (bold) {
							style |= Font.BOLD;
						}
						if (italic) {
							style |= Font.ITALIC;
						}
						Font orig = scheme.getStyle(index).font;
						scheme.getStyle(index).font =
							orig.deriveFont(style);
					}

					String ulineStr = eElement.getAttribute("underline");
					if (ulineStr!=null&&!ulineStr.equals("")) {
						boolean uline= Boolean.parseBoolean(ulineStr);
						scheme.getStyle(index).underline = uline;
                                                dMScheme.getStyle(index).underline = uline;
                                                pluginManagercheme.getStyle(index).underline = uline;
					}

				}
                }
              }
              
             
                
                
            } catch (SAXException | IOException | ParserConfigurationException ex) {
                Logger.getLogger(Theme.class.getName()).log(Level.SEVERE, null, ex);
            }
                               
        }

        
            
    }
        
        class ApplyToDivider extends BasicSplitPaneUI {
            
            Color c = Color.BLUE ;
            
            public ApplyToDivider(Color c) {
                this.c = c ;
            }
            
            @Override
            public BasicSplitPaneDivider createDefaultDivider() {
            return new BasicSplitPaneDivider(this) {
                
                @Override
                public void setBorder(Border b) {
                    b = border ;
                }

            @Override
                public void paint(Graphics g) {
                g.setColor(c);
                g.fillRect(0, 0, getSize().width, getSize().height);
                    super.paint(g);
                }
            };
            }
        }
        
        class SBV extends BasicScrollBarUI {
            
            JScrollPane pane ;
            
            @Override
        protected JButton createDecreaseButton(int orientation) {
            return createZeroButton();
        }

        @Override    
        protected JButton createIncreaseButton(int orientation) {
              return createZeroButton();
        }
        @Override 
        protected void configureScrollBarColors(){
              this.thumbColor = unselected;
        }
        }

        class SBH extends BasicScrollBarUI {
            @Override
        protected JButton createDecreaseButton(int orientation) {
            return createZeroButton();
        }

        @Override    
        protected JButton createIncreaseButton(int orientation) {
              return createZeroButton();
        }
        
        @Override 
        protected void configureScrollBarColors(){
              this.thumbColor = unselected;
        }
        }
        

        private JButton createZeroButton() {
            JButton jbutton = new JButton();
            jbutton.setPreferredSize(new Dimension(0, 0));
            jbutton.setMinimumSize(new Dimension(0, 0));
            jbutton.setMaximumSize(new Dimension(0, 0));
            return jbutton;
        }
        
    
}

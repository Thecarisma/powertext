/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author thecarisma
 */
public class fontSelector extends JDialog
{
	
	public String fontString[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	public JComboBox fontSelector = new JComboBox(fontString);
	public JLabel fontLabel = new JLabel("Select Font");
	
	public String fontSizeString[] = {"10","12","14","16","18","20","22","24","28","30","35"};
	public JComboBox fontSize = new JComboBox(fontSizeString);
	public JLabel sizeLabel = new JLabel("Select Size");
	
	public String fontStyleString[] = {"Normal","Bold","Italic","Bold Italic"};
	public JComboBox fontStyle = new JComboBox(fontStyleString);
	public JLabel styleLabel = new JLabel("Select Style");
	
	public JButton okButton = new JButton("OK");
	public JButton cancelButton = new JButton("Cancel");
	
	public JLabel previewLabel = new JLabel("Preview:");
	public JLabel preview = new JLabel("   AaBbCc");
	
	Font selectedFont;
	
	public fontSelector()
	{
		this.setSize(300,200);
		this.setBackground(Color.blue);
		this.setTitle("Font Selector");
                this.setLocationRelativeTo(null);
		
		getContentPane().setLayout(null);
		
		fontLabel.setBounds(10,10,100,20);
		fontSelector.setBounds(110,10,150,20);
		sizeLabel.setBounds(10,35,100,20);
		fontSize.setBounds(110,35,100,20);
		styleLabel.setBounds(10,60,100,20);
		fontStyle.setBounds(110,60,100,20);
		
		okButton.setBounds(10,100,100,20);
		cancelButton.setBounds(110,100,100,20);
		
		previewLabel.setBounds(50,130,100,30);
		preview.setBorder(BorderFactory.createLineBorder(Color.black));
		preview.setBounds(120,130,70,30);
		
		getContentPane().add(fontLabel);
		getContentPane().add(fontSelector);
		getContentPane().add(sizeLabel);
		getContentPane().add(fontSize);
		getContentPane().add(styleLabel);
		getContentPane().add(fontStyle);
		getContentPane().add(okButton);
		getContentPane().add(cancelButton);
		getContentPane().add(previewLabel);
		getContentPane().add(preview);
		
		//SETS THE PREVIEW
		fontSelector.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				preview.setFont(new Font(String.valueOf(fontSelector.getSelectedItem()),fontStyle.getSelectedIndex(),14));
			}

                    
		});
		fontStyle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				preview.setFont(new Font(String.valueOf(fontSelector.getSelectedItem()),fontStyle.getSelectedIndex(),14));
			}
		});
	}
	
	public Font returnFont()
	{
		String fontSS = String.valueOf(fontSelector.getSelectedItem());
		int fontSZ = Integer.parseInt(String.valueOf(fontSize.getSelectedItem()));
		int fontST = fontStyle.getSelectedIndex();
		
		selectedFont = new Font(fontSS,fontST,fontSZ);
		
		return selectedFont;
	}

}
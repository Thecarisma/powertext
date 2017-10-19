/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.TabList;

import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import static com.power.text.Main.*;
import java.awt.Component;
import java.awt.Font;

/**
 *
 * @author thecarisma
 */
public class TabChanged implements ChangeListener
          { 
            @Override
              public void stateChanged(ChangeEvent evt){
                  if (jTabbedPane1.getTabCount() > 0) {
                      //JTabbedPane source = (JTabbedPane) evt.getSource();
                   int selectedIndex = jTabbedPane1.getSelectedIndex();
                  JTextArea textPane = Editor.get(selectedIndex).getTextPane();
                  documentMap.setText(Editor.get(selectedIndex).getTextPane().getText());
                  documentMap.setSyntaxEditingStyle(Editor.get(selectedIndex).getSyntaxKey());
                  //main.documentMap.setFont(new java.awt.Font(textPane.getFont().getFontName(), textPane.getFont().getStyle(), main.documentMapFontSize));
                  //textPane.getDocument().addDocumentListener(new PTDocumentListener());
                  //jTabbedPane1.setForegroundAt(selectedIndex, addForeground);
                  String title = jTabbedPane1.getTitleAt(jTabbedPane1.getSelectedIndex());
                  String tabtext = jTabbedPane1.getTitleAt(jTabbedPane1.getSelectedIndex()).trim();
                  for(int i = 0 ; i < jTabbedPane1.getTabCount() ;i++){
                     String list_item = jTabbedPane1.getTitleAt(i).trim();
                       //jList1.getComponent(i).toString().trim();
                                            if(title.equals(list_item)){
                        jList1.setSelectedIndex(i);
                     }
                  }
                  if ( !textPane.isEditable()){
                      editableMI.setSelected(true);
                  } else {
                      editableMI.setSelected(false);
                  }  Editor.get(selectedIndex).getMenuItem().setSelected(true);
                  /**if ( Editor.get(selectedIndex).getSavedStatus()==false){
                      jTabbedPane1.setIconAt(selectedIndex, new ImageIcon(this.getClass().getResource("/power/text/images/unsave.gif")));
                  } else if (tabtext.contains("Untitled")) {
                      jTabbedPane1.setIconAt(selectedIndex, new ImageIcon(this.getClass().getResource("/power/text/images/unsave.gif")));
                  } else {
                      jTabbedPane1.setIconAt(selectedIndex, new ImageIcon(this.getClass().getResource("/power/text/images/save.gif")));    
                  }**/
                  if(jTabbedPane1.getTabCount()>0){
                      Object[] files= filesHoldListModel.toArray();
                      if(tabtext.contains("*")){
                          tabtext=tabtext.replace("*", "");
                      Component selComp = jTabbedPane1.getTabComponentAt(jTabbedPane1.getSelectedIndex());
                      selComp.setFont(jTabbedPane1.getFont().deriveFont(Font.BOLD));
                      }
                      
                      for(Object filename : files){
                          String file = filename.toString().substring(filename.toString().lastIndexOf("\\")+1);
                              //System.out.println("oya now oya");
                              titleExtLa.setText(Editor.get(selectedIndex).getFileExt().getText());
                              titleText.setText(Editor.get(selectedIndex).getFileDire().getText() ) ;
                          if(tabtext.contains("Untitled")){
                              titleExtLa.setText(Editor.get(selectedIndex).getFileExt().getText());
                               titleText.setText(Editor.get(selectedIndex).getFileDire().getText());
                          }
                      }
                  }if(tabtext.contains("Untitled")){
                         titleExtLa.setText(Editor.get(selectedIndex).getFileExt().getText());
                         titleText.setText(jTabbedPane1.getTitleAt(jTabbedPane1.getSelectedIndex()));
                  }} 
                      
              }
          }
              


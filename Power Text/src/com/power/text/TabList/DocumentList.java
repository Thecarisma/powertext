/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.TabList;

import static com.power.text.dialogs.Documents.docList;
import static com.power.text.dialogs.Documents.jTextArea1;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import static com.power.text.Main.Editor;

/**
 *
 * @author Thearisma
 */
public class DocumentList implements ListSelectionListener
          {
              @Override
              public void valueChanged(ListSelectionEvent evt)
              {                  
                  if(docList.getSelectedValue()!=null)
                  {
                      int selectedIndex = docList.getSelectedIndex();
                      jTextArea1.setText(Editor.get(selectedIndex).getFileName()+"\n"+Editor.get(selectedIndex).getFileDire().getText()+"\n"+Editor.get(selectedIndex).getFileExt().getText());
                  }
              }
          }

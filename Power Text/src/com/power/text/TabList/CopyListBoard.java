/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.TabList;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import static com.power.text.Main.jList3;

/**
 *
 * @author Thearisma
 */
public class CopyListBoard implements ListSelectionListener
          {
              @Override
              public void valueChanged(ListSelectionEvent evt)
              {                  
                  if(jList3.getSelectedValue()!=null)
                  {
                      //System.out.println("it not copying oo ");
                      String list_item =jList3.getSelectedValue().trim();
                      StringSelection ss = new StringSelection(list_item);
                      Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
                      clpbrd.setContents(ss, ss);
                  }
              }
          }
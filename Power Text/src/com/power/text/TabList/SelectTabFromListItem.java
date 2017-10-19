/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.TabList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import static com.power.text.Main.filesHoldListModel;
import static com.power.text.Main.jList1;
import static com.power.text.Main.jTabbedPane1;

/**
 *
 * @author Thearisma
 */
public class SelectTabFromListItem implements ListSelectionListener
          {
              @Override
              public void valueChanged(ListSelectionEvent evt)
              {                  
                  if(jList1.getSelectedValue()!=null)
                  {
                      String list_item=jList1.getSelectedValue().trim();
                      Object[] files= filesHoldListModel.toArray();
                      if(jTabbedPane1.getTabCount() >0)
                      {
                          int tabcount=jTabbedPane1.getTabCount();
                         for(int i=0;i<tabcount;i++)
                          {
                              String title=jTabbedPane1.getTitleAt(i).trim();
                              if (title.contains("*"))
                              {
                                  title = title.replace("*", "").trim();
                              }

                             if(title.equals(list_item))
                              {
                                  jTabbedPane1.setSelectedIndex(i);
                              }
                             for(Object filename : files){
                          String file=filename.toString().substring(filename.toString().lastIndexOf("\\")+1);
                          String tabtext = jTabbedPane1.getTitleAt(jTabbedPane1.getSelectedIndex()).trim();
                          
                      }
                             
                          }
                      }

                  }
              }
          }

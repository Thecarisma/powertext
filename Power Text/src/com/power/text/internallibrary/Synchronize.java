/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.internallibrary;

import static com.power.text.dialogs.Console.jTextArea2;
import static com.power.text.dialogs.Console.type;
import static com.power.text.internallibrary.BasicEvents.SetCursor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import javax.swing.JTextArea;

/**
 *
 * @author Thecarisma
 */
public class Synchronize implements Runnable {
    
    JTextArea area ;
    
public Synchronize(InputStream istrm, OutputStream ostrm, JTextArea area) {
      istrm_ = istrm; this.area = area;
      ostrm_ = ostrm;
  }
@Override
  public void run() {
      try
      {
          final byte[] buffer = new byte[1024]; String line=null;
          for (int length = 0; (length = istrm_.read(buffer)) != -1; )
          {
              ostrm_.write(buffer, 0, length);
              BufferedReader input = new BufferedReader(new InputStreamReader(istrm_));
              while((line=input.readLine()) != null) {
                    jTextArea2.append(line.replace("\n", "").replace("\n\n", "")+"\n");
                    jTextArea2.setCaretPosition(SetCursor(jTextArea2.getText().length(),jTextArea2));
                    jTextArea2.setNavigationFilter(new ConsoleNavigationFilter(jTextArea2.getText().length(), jTextArea2) ); 
              } 
                //
                
          }
      }
      catch (IOException e)
      {
      }
  }
  private final OutputStream ostrm_;
  private final InputStream istrm_;
}

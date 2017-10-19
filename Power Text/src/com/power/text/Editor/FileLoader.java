/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.Editor;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import static com.power.text.Main.jProgressBar1;

/**
 *
 * @author thecarisma
 */
public class FileLoader extends Thread {

	FileLoader(File f, Document doc) {
	    setPriority(4);
	    this.f = f;
	    this.doc = doc;
	}

        @Override
        public void run() {
	    try {
		// initialize the statusbar
		jProgressBar1.setMinimum(0);
		jProgressBar1.setMaximum((int) f.length());

		// try to start reading
		Reader in = new FileReader(f);
		char[] buff = new char[4096];
		int nch;
	    while ((nch = in.read(buff, 0, buff.length)) != -1) {
		    doc.insertString(doc.getLength(), new String(buff, 0, nch), null);
		    jProgressBar1.setValue(jProgressBar1.getValue() + nch);
		}

		// we are done... get rid of jProgressBar1bar

	    }
	    catch (java.io.IOException e) {
		System.err.println(e.toString());
	    } catch (BadLocationException e) {
		System.err.println(e.getMessage());
	    }
		//TnewFile.setEnabled(true);
	}
	Document doc;
	File f;
}

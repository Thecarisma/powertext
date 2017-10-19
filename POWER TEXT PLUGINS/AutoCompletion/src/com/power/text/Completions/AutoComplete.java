/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.power.text.Completions;

import com.power.text.autocomplete.*;
import com.power.text.ui.pteditor.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;

/**
 *
 * @author Thecarisma
 */
public class AutoComplete {
    
    CompletionProvider cprovider ; public DefaultCompletionProvider javaProvider = new DefaultCompletionProvider();
    final AutoCompletion ac ; RSyntaxTextArea area ; int space = 0 ; 
    String all = "" ;
    
    public AutoComplete(RSyntaxTextArea areaa) {
        area = areaa ; space = area.getCaretPosition();
        cprovider = createCompletionProvider(); 
        ac = new AutoCompletion(cprovider);  addFormerWords();
    }
    
    public void addFormerWords() {
        String lineSplit[] = area.getText().split("\n");
        ArrayList<String> lineList = new ArrayList<>(Arrays.asList(lineSplit)) ;
        lineList.stream().map((line) -> line.split(" ")).map((spaceSplit) -> new ArrayList<>(Arrays.asList(spaceSplit))).forEachOrdered((spaceList) -> {
            spaceList.stream().filter((oldWord) -> (!all.contains(oldWord) && !oldWord.contains("\n"))).map((oldWord) -> {
                javaProvider.addCompletion(new BasicCompletion(javaProvider, oldWord));
                return oldWord;
            }).forEachOrdered((oldWord) -> {
                all = all + oldWord ;
            });
        });
    }
    
    public void getCompletion() {
        ac.install(area);
        area.addKeyListener(new KeyAdapter() {
        @Override
        public void keyReleased(KeyEvent e) {
            
            if (e.getKeyCode()==32) {
                area.setSelectionStart(area.getLineStartOffsetOfCurrentLine()); area.setSelectionEnd(area.getCaretPosition());
                String lineSplit[] = area.getSelectedText().split(" "); area.setCaretPosition(area.getCaret().getDot());
                String newWord = lineSplit[lineSplit.length-1] ; System.out.println(newWord);
                if (newWord!=null && !all.contains(newWord) && !newWord.equals("`") && !newWord.equals("~") && !newWord.equals("1")
                         && !newWord.equals("2") && !newWord.equals("3") && !newWord.equals("4") && !newWord.equals("5")
                         && !newWord.equals("6") && !newWord.equals("7") && !newWord.equals("8") && !newWord.equals("9")
                         && !newWord.equals("0") && !newWord.equals("-") && !newWord.equals("=") && !newWord.equals("!")
                         && !newWord.equals("@") && !newWord.equals("#") && !newWord.equals("$") && !newWord.equals("%")
                         && !newWord.equals("^") && !newWord.equals("&") && !newWord.equals("*") && !newWord.equals("(")
                         && !newWord.equals(")") && !newWord.equals("_") && !newWord.equals("+") && !newWord.equals("[")
                         && !newWord.equals("]") && !newWord.equals("\\") && !newWord.equals(";") && !newWord.equals("'")
                         && !newWord.equals(",") && !newWord.equals(".") && !newWord.equals("/") && !newWord.equals("{")
                         && !newWord.equals("}") && !newWord.equals("|") && !newWord.equals(":") && !newWord.equals("\"")
                         && !newWord.equals("<") && !newWord.equals(">") && !newWord.equals("?") && !newWord.equals("()")
                         && !newWord.equals("{}") && !newWord.equals("[]") && !newWord.contains(".")) {
                    all = all + newWord ; 
                    javaProvider.addCompletion(new BasicCompletion(javaProvider, newWord.replace(" ", "")));
                }
            }
            if (e.getKeyCode()!=10 &&e.getKeyCode()!=9 && e.getKeyCode()!=524 &&
                    e.getKeyCode()!=20 &&e.getKeyCode()!=16 &&e.getKeyCode()!=17 &&e.getKeyCode()!=18 &&
                    e.getKeyCode()!=162 && e.getKeyCode()!=8 && e.getKeyCode()!=192 && e.getKeyCode()!=45
                    &&e.getKeyCode()!=61 && e.getKeyCode()!=92 && e.getKeyCode()!=33 && e.getKeyCode()!=38 &&
                    e.getKeyCode()!=93 &&e.getKeyCode()!=91 &&e.getKeyCode()!=59 &&e.getKeyCode()!=222 &&
                    e.getKeyCode()!=44 && e.getKeyCode()!=46 && e.getKeyCode()!=47 && e.getKeyCode()!=34 &&
                    e.getKeyCode()!=44 && e.getKeyCode()!=37 && e.getKeyCode()!=40 && e.getKeyCode()!=39 &&
                    e.getKeyCode()!=27 && e.getKeyCode()!=127 && e.getKeyCode()!=32) {
                ac.doCompletion(); 
            }
          }
        });
    }
    
    public CompletionProvider createCompletionProvider() {

         
  
  /**BasicCompletion bc = new BasicCompletion(javaProvider, "abstract");
  bc.setSummary("Abstract is used to implement the abstraction in java. A method which doesn’t have method definition must be declared as abstract and the class containing it must be declared as abstract. You can’t instantiate abstract classes. Abstract methods must be implemented in the sub classes. You can’t use abstract keyword with variables and constructors"); 
  javaProvider.addCompletion(bc);
  
  BasicCompletion bc1 = new BasicCompletion(javaProvider, "assert");
  bc1.setSummary("Assert describes a predicate (a true–false statement) placed in a java-program to indicate that the developer thinks that the predicate is always true at that place. If an assertion evaluates to false at run-time, an assertion failure results, which typically causes execution to abort. Optionally enable by ClassLoader method.");
  javaProvider.addCompletion(bc1);
  
  
  BasicCompletion bc2 = new BasicCompletion(javaProvider, "boolean");
  bc2.setSummary("Defines a boolean variable for the values \"true\" or \"false\" only.");
  javaProvider.addCompletion(bc2);
  
  
  BasicCompletion bc3 = new BasicCompletion(javaProvider, "break");
  bc3.setSummary("Used to end the execution in the current loop body.");
  javaProvider.addCompletion(bc3);
  
  
  BasicCompletion bc4 = new BasicCompletion(javaProvider, "byte");
  bc4.setSummary("The byte keyword is used to declare a field that can hold an 8-bit signed two's complement integer. This keyword is also used to declare that a method returns a value of the primitive type byte");
  javaProvider.addCompletion(bc4);
  
  
  BasicCompletion bc5 = new BasicCompletion(javaProvider, "case");
  bc5.setSummary("A statement in the switch block can be labeled with one or more case or default labels. The switch statement evaluates its expression, then executes all statements that follow the matching case label");
  javaProvider.addCompletion(bc5);
  
  
  BasicCompletion bc6 = new BasicCompletion(javaProvider, "catch");
  bc6.setSummary("Used in conjunction with a try block and an optional finally block. The statements in the catch block specify what to do if a specific type of exception is thrown by the try block.");
  javaProvider.addCompletion(bc6);
  
  
  BasicCompletion bc7 = new BasicCompletion(javaProvider, "char");
  bc7.setSummary("Defines a character variable capable of holding any character of the java source file's character set.");
  javaProvider.addCompletion(bc7);
  
  
  javaProvider.addCompletion(new ShorthandCompletion(javaProvider, "sysout",
        "System.out.println(", "System.out.println("));
  javaProvider.addCompletion(new ShorthandCompletion(javaProvider, "syserr",
        "System.err.println(", "System.err.println("));**/

  return javaProvider;


}

    
}

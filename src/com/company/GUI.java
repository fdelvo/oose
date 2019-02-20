package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JPanel implements ActionListener {
  JButton b1 = new JButton("eins");
  JButton b2 = new JButton("zwei");
  JTextField tf = new JTextField(30);
  JTextField input = new JTextField(30);

  private class ZweiteVersion implements ActionListener {
    int i = 0;

    @Override
    public void actionPerformed(ActionEvent e) {
      String result = BigIntegerFactorial.factorial(Long.parseLong(input.getText())).toString();
      tf.setText(result);
    }
  }

  public GUI() {
    this.add(b1);
    this.add(b2);
    this.add(tf);
    this.add(input);

    // 1. Klasse schreiben, die ActionListener implementiert.
    // Objekt dieser Klasse erzeugen
    // Nachteil: UmstÃ¤ndlich. Die neue Klasse muss alles, was sie braucht
    // im Konstruktor Ã¼bergeben bekommen. (hier das JTextField)
    // b1.addActionListener(new ErsteVersion(input, tf));

    // 2. innere Klasse schreiben und Objekt erzeugen
    // Vorteil: Objekte der inneren KJlasse leben in Objekten der Ã¤uÃŸeren
    // und kÃ¶nnen deren Eigenschaften verwenden (hier z.B. tf)
    // Meist: Konstruktor entfÃ¤llt.
    // Implementierung kann in der Ã¤uÃŸeren Klasse versteckt werden
    // Nachteil: wird unÃ¼bersichtlich, wenn innere Klasse zu groÃŸ
    // und komplex
    // b1.addActionListener(new ZweiteVersion());

    // 3. Version: als anonyme innere Klasse implementieren
    // Vorteil: kurz
    // Nachteil: schnell sehr unÃ¼bersichtlich
    /* b1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String result = BigIntegerFactorial.factorial(Long.parseLong(input.getText())).toString();
        tf.setText(result);
      }
    }); */

    // 4. Version
    // mit Lambda-Ausdruck, da ActionListener eine funktionale Schnittstelle
    // Vorteil: richtig kurz
    // Nachteil: nur sinnvoll bei kurzen kleinen Methoden
    // kein Zustand, kein Feld in dem Lambda-Ausdruck
    b1.addActionListener(e -> tf.setText(BigIntegerFactorial.factorial(Long.parseLong(input.getText())).toString()));

    // 5. Version: keine neue Klasseschreiben. Ã„uÃŸere Klasse implementiert
    // selbst den ActionListener
    //schlecht (dont do at home), da nicht wirklich objektorientiert.
    //bei mehreren KnÃ¶pfen muss in einem if geklÃ¤rt werden, welcher
    //Knopf gedrÃ¼ckt wurde.
    // b1.addActionListener(this);
    b2.addActionListener(this);
  }

  int i = 0;

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == b1) {
      i = i + 1;
      tf.setText("" + i);
    } else if (e.getSource() == b2) {
      System.exit(0);
    }
  }

  public static void main(String[] args) {
    JFrame f = new JFrame("hier kÃ¶nnte Ihre Werbung stehen");
    f.addWindowListener(new WindowAdapter()  {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });


    f.add(new GUI());
    f.pack();
    f.setVisible(true);
  }

}
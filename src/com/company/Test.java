package com.company;

import javax.swing.*;

public class Test extends JPanel {
  JTextField input = new JTextField();
  JLabel output = new JLabel();
  JButton button = new JButton("Drücken");
  Test() {
    this.add(input);
    this.add(output);
    this.add(button);
  }

  public static void main(String[] args) {
    JPanel f = new Test();
    f.setVisible(true);
  }
}

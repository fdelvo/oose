package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ErsteVersion implements ActionListener {
  JTextField input;
  JTextField tf;

  public ErsteVersion (JTextField input, JTextField tf) {
    this.input = input;
    this.tf = tf;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String result = BigIntegerFactorial.factorial(Long.parseLong(input.getText())).toString();
    tf.setText(result);
  }

}
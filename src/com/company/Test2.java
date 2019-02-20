package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test2 extends Test implements ActionListener {
  @Override
  public void actionPerformed(ActionEvent e) {
    String result = BigIntegerFactorial.factorial(Long.parseLong(input.getText())).toString();
    output.setText(result);
  }
}

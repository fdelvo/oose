package com.company;

class StringLengthLogic extends ButtonLogic {
  String getButtonLabel() {
    return "Length";
  }

  String eval(String input) {
    return Integer.toString(input.length());
  }

  public static void main(String[] args) {
    new Dialogue(new StringLengthLogic());
    new ConsoleDialogue(new StringLengthLogic()).run();
  }
}

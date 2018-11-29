package com.company;

class ToUpperLogic extends ButtonLogic {
  String getButtonLabel() {
    return "Upper";
  }

  String eval(String input) {
    return input.toUpperCase();
  }

  public static void main(String[] args) {
    new Dialogue(new ToUpperLogic());
    new ConsoleDialogue(new ToUpperLogic()).run();
  }
}

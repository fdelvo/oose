package com.company;

class FactorialLogic extends ButtonLogic {
  String getButtonLabel() {
    return "Factorial";
  }

  String eval(String input) {
    return BigIntegerFactorial.factorial(Long.parseLong(input)).toString();
  }

  public static void main(String[] args){
    new Dialogue(new FactorialLogic());
    new ConsoleDialogue(new FactorialLogic()).run();
  }
}
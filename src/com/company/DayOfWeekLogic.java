package com.company;

class DayOfWeekLogic extends ButtonLogic {
  String getButtonLabel() {
    return "dayOfWeek";
  }

  String eval(String input) {
    String[] dateArray = input.split("\\.");
    System.out.println(dateArray.length);
    String[] weekDays = {"Sonntag", "Montag", "Dienstag", "Mittwoch",
            "Donnerstag", "Freitag", "Sonnabend"};
    int dayOfWeek = new Date(Integer.parseInt(dateArray[0]),
            Integer.parseInt(dateArray[1]),
            Integer.parseInt(dateArray[2])).dayOfWeek();
    return weekDays[dayOfWeek];
  }



  public static void main(String[] args){
    new Dialogue(new DayOfWeekLogic());
    new ConsoleDialogue(new DayOfWeekLogic()).run();
  }
}

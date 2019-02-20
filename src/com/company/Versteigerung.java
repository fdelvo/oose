package com.company;

public class Versteigerung extends java.util.ArrayList<Kunstwerk> {
  public long gesamtWert() {
    long result = 0;
    for (Kunstwerk k : this) {
      result = result + k.estimate;
    }
    return result;
  }

  public Kunstwerk teuerstesKunstwerk() {
    Kunstwerk result = this.get(0);
    for (Kunstwerk k : this) {
      if (k.estimate > result.estimate) result = k;
    }
    return result;
  }

  public static void main(String[] args) {
    Versteigerung v = new Versteigerung();
    v.add(new Kunstwerk("Test1", "Test1"));
    v.add(new Kunstwerk("Test2", "Test2"));
    v.add(new Kunstwerk("Test3", 100, "Test3"));
    v.add(new Kunstwerk("Test4", 150, "Test4"));
    v.add(new Kunstwerk("Test5", 10, "Test5"));
    System.out.println(v.gesamtWert());
    System.out.println(v.teuerstesKunstwerk().title);
  }
}

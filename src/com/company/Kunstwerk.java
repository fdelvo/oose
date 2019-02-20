package com.company;

public class Kunstwerk {
  String artistName;
  int estimate;
  String title;

  public Kunstwerk(String artistName, int estimate, String title) {
    this.artistName = artistName;
    this.estimate = estimate;
    this.title = title;
  }

  public Kunstwerk(String artistName, String title) {
    this.artistName = artistName;
    this.estimate = 42;
    this.title = title;
  }

  @Override
  public boolean equals(Object o) {
    return this.getClass() == o.getClass();
  }

  public static void main(String[] args) {
    Kunstwerk k1 = new Kunstwerk("Name1", 22, "Titel1");
    Kunstwerk k2 = new Kunstwerk("Name2", "Titel2");
    Gemaelde g1 = new Gemaelde("Name3", 23, "Titel1", 50, 50);
    System.out.println(k1.equals(k2));
  }
}


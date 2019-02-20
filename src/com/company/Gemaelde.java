package com.company;

import java.lang.reflect.Array;

public class Gemaelde extends Kunstwerk {
  int height;
  int width;

  public Gemaelde(String artistName, int estimate, String title, int height, int width) {
    super(artistName, estimate, title);
    this.height = height;
    this.width = width;
  }

  public Gemaelde(String artistName, String title, int height, int width) {
    super(artistName, title);
    this.height = height;
    this.width = width;
  }
}

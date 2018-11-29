package com.company;

public class Circle extends Ellipse {
  Circle() {
    super(new Vertex(0.0, 0.0), 100.0, 100.0,
      new Vertex(0.0, 0.0));
  }

  Circle(Vertex corner) {
    super(corner, 100.0, 100.0, new Vertex(0.0, 0.0));
  }

  Circle(Vertex corner, double diameter) {
    super(corner, diameter, diameter, new Vertex(0.0, 0.0));
  }

  Circle(Vertex corner, double diameter, Vertex velocity) {
    super(corner, diameter, diameter, velocity);
  }

  public String toString() {return "Kreis";}

  public static void main(String[] args) {}
}

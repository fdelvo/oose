package com.company;

class Ellipse extends GeometricObject {
  Ellipse() {
    super(new Vertex(0.0, 0.0), 100.0, 100.0, new Vertex(0.0, 0.0));
  }

  Ellipse(Vertex corner) {
    super(corner, 100.0, 100.0, new Vertex(0.0, 0.0));
  }

  Ellipse(Vertex corner, double width, double height) {
    super(corner, width, height, new Vertex(0.0, 0.0));
  }

  Ellipse(Vertex corner, double width, double height, Vertex velocity) {
    super(corner, width, height, velocity);
  }

  public String toString() {
    return "";
  };

  double size() {
    return Math.PI * (this.width / 2.0) * (this.height / 2.0);
  };

  public static void main(String[] args) {};
}

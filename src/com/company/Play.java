package com.company;

public class Play extends Gapplication {
  public Play() {
    super(new GeometricObject(new Vertex(0, 111.0), 10, 10, new Vertex(0.2, 0.7)),
      new IsoscelesTriangle(new Vertex(300.0, 300.0), 80.0, 100.0, new Vertex(0.0, 0.0)),
      new Star(8, 25, new Vertex(280, 90), 150, new Vertex(0.01, 0.0)),
      new SquaresObject(2, new Vertex(180, 20), 300, new Vertex(0, 0.0))

    );
  }
}
package com.company;

public class Play extends Gapplication {
  public Play() {
    super(new GeometricObject(new Vertex(0, 111.0), 10, 10, new Vertex(0.2, 0.7)),
            new IsoscelesTriangle(new Vertex(300.0,300.0), 80.0, 100.0, new Vertex(0.0,0.0))

    );
  }
}
package com.company;

public class IsoscelesTriangle extends PolygonObject {
  double legLength;

  public IsoscelesTriangle(Vertex corner, double baseLength,
                           double legLength, Vertex velocity) {

    // TODO super-Aufruf, Länge der Schenkel initialisieren
    // und initPolygon() Aufrufen
    // height = sqrt(a^2-((c^2)/4))
    super(corner, baseLength, Math.sqrt(Math.pow(legLength, 2.0)
      - (Math.pow(baseLength, 2) / 4)), velocity);
    this.legLength = legLength;
    initPolygon();
  }

  @Override
  void initPolygon() {
    p.add(0.0, height);
    p.add(width, height);
    p.add(width / 2.0, 0.0);
  }

  @Override
  double size() {
    return (width / 2) * height;
  }

  @Override
  public String toString() {
    return "new IsoscelesTriangle(new Vertex"
      + corner + ", " + width + ", " + legLength + ", new Vertex" + velocity + ")";
  }
}

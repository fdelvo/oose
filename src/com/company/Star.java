package com.company;

public class Star extends PolygonObject {
  int beams;
  double innerRadius;

  public Star(int beams,double innerRadius, Vertex corner,
              double width, Vertex velocity) {
    // TODO
    // korrekte Initalisierung des Super-Objekts
    // Initialisierung der Felder dieser Klasse
    // Aufruf von initPolygon
    super(corner, width, width, velocity);
    this.beams = beams;
    this.innerRadius = innerRadius;
    initPolygon();
  }
  @Override
  public String toString() {
    return "new Star("+beams+", "+innerRadius+", new Vertex"
      +corner+", "+width+", new Vertex"+velocity+")";
  }

  @Override
  void initPolygon() {
    Vertex centerPoint = new Vertex(width/2, height/2);
    double degreeIncrement = 360.0 / (double)(beams*2);
    double startDegree = 90.0;
    System.out.println("Cos90=" + Math.round(Math.cos(Math.toRadians(90.0))));
    System.out.println("Sin90=" + Math.sin(Math.toRadians(90.0)));
    double x = (width / 2) * Math.round(Math.cos(Math.toRadians(startDegree)));
    double y = (width / 2) * Math.sin(Math.toRadians(startDegree));
    System.out.println("Width=" + width);
    System.out.println("X=" + x);
    System.out.println("Y=" + y);
    for(int i = 0; i < beams*2; i++) {
      if(i%2!=0) {
        System.out.println("Degree Increment: " + degreeIncrement);
        double x2 = (width / 2) * Math.cos(Math.toRadians(
          startDegree + (degreeIncrement * (i + 1))));
        double y2 = (width / 2) * Math.sin(Math.toRadians(
          startDegree + degreeIncrement * (i + 1)));
        System.out.println("X" + i + ":" + x2 + ";" + "Y" + i + ":" + y2 + ";");
        p.add(centerPoint.x + x2, centerPoint.y + y2);
      } else {
        System.out.println("Degree Increment: " + degreeIncrement);
        double x2 = innerRadius * Math.cos(Math.toRadians(
          startDegree + degreeIncrement * (i + 1)));
        double y2 = innerRadius * Math.sin(Math.toRadians(
          startDegree + (degreeIncrement * (i + 1))));
        System.out.println("X" + i + ":" + x2 + ";" + "Y" + i + ":" + y2 + ";");
        p.add(centerPoint.x + x2, centerPoint.y + y2);
      }
    }
  }
}

package com.company;

public class SquaresObject extends PolygonObject{
  int depth;
  public SquaresObject(int depth,Vertex corner,double width,Vertex velocity){
    //TODO super,...
    super(corner, width, width, velocity);
    this.depth = depth;
    initPolygon();
  }

  @Override
  public String toString() {
    return "new SquaresObject("+depth+", new Vertex"+corner+", "
      +width+", new Vertex"+velocity+")";
  }


  @Override
  void initPolygon() {
    //TODO Die Punkte der Figur ins Polygon einfügen
    // Berechnung der Kantenlänge des inneresten Quadrats
    double oo = 1;
    for (int i = 1;i<=depth;i++){
      oo +=  2/Math.pow(3, i);
    }
    //w ist die Kantenlänge des inneren Quadrats
    int w = (int)(width/oo);
    double offset = (width - w) / 2;

    p.add(oo+offset, oo+offset);
    p.add(oo+w+offset, oo+offset);
    p.add(oo+w+offset, oo+w+offset);
    p.add(oo+offset, oo+w+offset);

    helper(new Vertex(oo+offset, oo+offset), w);

  }

  void helper(Vertex corner, double w) {
    double width = w/3;
    double offset = (w-width)/2;
    p.add(corner.x + offset, corner.y + offset);
    p.add(corner.x + offset + w, corner.y + offset);
    p.add(corner.x + offset + w, corner.y + w + offset);
    p.add(corner.x + offset, corner.y + w + offset);
  }


}

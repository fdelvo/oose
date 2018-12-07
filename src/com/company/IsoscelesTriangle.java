package com.company;

public class IsoscelesTriangle extends PolygonObject {
    double legLength;

    public IsoscelesTriangle(Vertex corner, double baseLength,
                             double legLength, Vertex velocity) {

        // TODO super-Aufruf, Länge der Schenkel initialisieren
        // und initPolygon() Aufrufen
        super(corner, baseLength, legLength, velocity);
        initPolygon();
    }

    @Override
    void initPolygon() {
        p.add(0.0,height);
        p.add(width,height);
        p.add(width/2.0,0.0);
    }

    @Override
    double size() {
        return 0.5 * width * height;
    }

    @Override
    public String toString() {
        return "new IsoscelesTriangle(new Vertex"
                +corner+", "+width+", "+legLength+", new Vertex"+velocity+")";
    }
}

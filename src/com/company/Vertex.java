package com.company;

public class Vertex {
    double x;
    double y;

    public Vertex(double x, double y) {
        super();
        this.x = x;
        this.y = y;
    }

    void move(Vertex v) {
        x += v.x;
        y += v.y;
    }

    void moveTo(Vertex v) {
        x = v.x;
        y = v.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public boolean equals(Vertex that) {
        // verbindungsvektor berechnen
        Vertex verbindungsVektor = new Vertex(this.x-that.x, this.y-that.y);
        // länge verbindungsvektor berechnen
        double abstand = Math.sqrt(Math.pow(verbindungsVektor.x,2.0)
          + Math.pow(verbindungsVektor.y,2.0));
        return abstand <= 1;
    }

    public static void main(String[] args) {
        System.out.println(new Vertex(1.0,1.0).equals(new Vertex(2.1,0.1)));
    }
}

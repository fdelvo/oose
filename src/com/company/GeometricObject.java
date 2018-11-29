package com.company;

class GeometricObject {
    Vertex corner;
    double width;
    double height;
    Vertex velocity;

    GeometricObject(Vertex corner, double width, double height, Vertex velocity) {
        this.corner = corner;
        this.width = width;
        this.height = height;
        this.velocity = velocity;
    }

    double size() {
        return width * height;
    }

    boolean isLargerThan(GeometricObject that) {
        return this.size() > that.size();
    }

    boolean isAbove(GeometricObject that) {
        if(corner.y == that.corner.y) return false;
        return that.corner.y > corner.y + height;
    }

    boolean isUnderneath(GeometricObject that) {
        if(corner.y == that.corner.y) return false;
        return that.corner.y + that.height < corner.y;
    }

    boolean isLeftOf(GeometricObject that) {
        if(corner.y == that.corner.y) return false;
        return corner.x + width < that.corner.x;
    }

    boolean isRightOf(GeometricObject that) {
        if(corner.y == that.corner.y) return false;
        return corner.x > that.corner.x + that.width;
    }

    boolean touches(GeometricObject that) {
        return !this.isLeftOf(that) && !this.isRightOf(that)
                && ((that.corner.y >= corner.y && that.corner.y <= corner.y + height)
                || (that.corner.y + that.height >= corner.y && that.corner.y+
                + that.height <= corner.y + height)) ;
    }

    public String toString() {
        return "Corner: " + corner + " Width: " + width + " Height: " + height + " Velocity: " + velocity;
    }
    //Hier jetzt die Methoden implementieren!
    public static void main(String[] args) {
        GeometricObject g0 = new GeometricObject(new Vertex(0.0,50.0), 150.0,50.0, new Vertex(0.0,0.0));
        GeometricObject g1 = new GeometricObject(new Vertex(50.0,0.0), 50.0,150.0, new Vertex(0.0,0.0));
        System.out.println(g0.touches(g1));
    }
}
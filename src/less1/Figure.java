package less1;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.Serializable;

/*
Написать пример кода, который реализует принцип полиморфизма, на примере фигур — круг, квадрат, треугольник.
 */

class PointF  {
    public float x;
    public float y;

    public PointF() {
        this.x = 0f;
        this.y = 0f;
    }

    public PointF(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return (double)this.x;
    }

    public double getY() {
        return (double)this.y;
    }

    public void setLocation(double x, double y) {
        this.x = (float)x;
        this.y = (float)y;
    }

    public void setLocation(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "Point2D.Float[" + this.x + ", " + this.y + "]";
    }
}

public abstract class Figure {
    protected PointF center;

    public void draw() {
        System.out.println("Рисовать @" + center.toString());
    }
    public abstract double area();


    protected static double length(PointF a1, PointF b1) {
        double xDistanceSquare = Math.pow(a1.getX() - b1.getX(), 2);
        double yDistanceSquare = Math.pow(a1.getY() - b1.getY(), 2);
        return Math.sqrt(xDistanceSquare + yDistanceSquare);
    }}

class Triangle extends Figure  {
    PointF a,b,c;

    public Triangle(PointF a, PointF b, PointF c) {
        this.a = a;
        this.b = b;
        this.c = c;
        super.center = centroid();
    }


    @Override
    public double area( ) {
        double s= (length(a,b)+length(a,c)+length(c,b))/2;
        return  Math.sqrt(s*(s-length(a,b))*(s-length(a,c))*(s-length(c,b)));
    }

    private PointF centroid() {
        float xc = (float) ((a.getX() + b.getX() + c.getX()) / 3);
        float yc = (float) ((a.getY() + b.getY() + c.getY()) / 3);
        return new PointF(xc,yc);
    }
}


class Circle extends Figure  {
    protected int radius;

    public Circle (PointF center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double area( ) {
        return 3.14 * radius*radius;
    }
}

class Square extends Figure {
    protected PointF a,b,c,d;

    public Square(PointF a, PointF b, PointF c, PointF d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        super.center = centroid();
    }

    @Override
    public double area() {
        double len = super.length(a,b);
        return len*len ;
    }

    private PointF centroid() {
        double af = Math.sqrt((a.x -a.y) * (a.x - b.x)  + (a.y-b.y) * (a.y-b.y) );
        af /= 2;
        double c = af / Math.sin(Math.toRadians(45));

        float xc = (float) (Math.sin(Math.toRadians(45)) * c + a.x);
        float yc = (float) (Math.cos(Math.toRadians(45)) * c + b.y);
        return new PointF(xc, yc);
    }
}
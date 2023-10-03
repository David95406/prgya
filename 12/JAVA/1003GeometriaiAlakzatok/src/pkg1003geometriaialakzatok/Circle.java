package pkg1003geometriaialakzatok;

public class Circle extends GeometricShape {
    double radius; //kor sugara

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Circle(String nev, double radius, double area) {
        super(nev, area);
        this.radius = radius;
    }
    
    @Override
    public String toString() {
        return "Alakzat neve: " + super.getNev() + "\nAlakzat területe: " + super.getArea() + "\nSugar: " + getRadius();
    }
}

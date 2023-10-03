package pkg1003geometriaialakzatok;

public class GeometricShape {
    String nev; //alakzat neve
    double area; //alakzat terulete

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public GeometricShape(String nev, double area) {
        this.nev = nev;
        this.area = area;
    }
    
    @Override
    public String toString() {
        return "Alakzat neve: " + getNev() + "\nAlakzat területe: " + getArea();
    }
}

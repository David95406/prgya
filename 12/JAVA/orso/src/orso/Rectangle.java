package orso;

public class Rectangle {

    private double a, b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Rectangle() {
        this.a = 0;
        this.b = 0;
    }

    public boolean isSquare() {
        return (a == b);
    }

    public double getTerulet() {
        return this.a * this.b;
    }

    public double getKerulet() {
        return 2 * (this.a + this.b);
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public String toString() {
        return "A: " + this.a + ", B: " + this.b;
    }
}

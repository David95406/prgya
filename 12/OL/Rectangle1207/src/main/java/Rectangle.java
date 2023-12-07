public class Rectangle {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.setA(a);
        this.setB(b);
    }

    public Rectangle() {
        this(0, 0);
    }



    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + getA() +
                ", b=" + getB() +
                ", K= " + getKerulet() +
                ", T= " + getTerulet() +
                ", Negyzet? " + (isNegyzet() ? "Igen" : "Nem") +
                '}';
    }

    public double getKerulet() {
        return 2 * (a + b);
    }

    public double getTerulet() {
        return a * b;
    }

    public boolean isNegyzet() {
        return a == b;
    }

    public Rectangle getNagyobb(Rectangle r1, Rectangle r2) {
        return (r1.getTerulet() > r2.getTerulet() ? r1 : r2);
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
}

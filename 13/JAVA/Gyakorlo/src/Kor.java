import java.util.Arrays;

public class Kor {
    private double radius;
    private double[] center;

    public Kor(double radius, double[] center) {
        setRadius(radius);
        setCenter(center);
    }

    public void nagyit(double arany) {
        if (arany < 1) throw new IllegalArgumentException("hiba");
        setRadius(getRadius() * arany);
    }

    public void kicsinyit(double arany) {
        if (arany >= 1) throw new IllegalArgumentException("hiba");
        setRadius(getRadius() * arany);
    }

    @Override
    public String toString() {
        return "Kor{" +
                "radius=" + radius +
                ", center=" + Arrays.toString(center) +
                '}';
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double[] getCenter() {
        return center;
    }

    public void setCenter(double[] center) {
        this.center = center;
    }
}

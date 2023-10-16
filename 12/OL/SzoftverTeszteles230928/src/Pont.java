public class Pont {

    private int x, y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Pont() {
        this(0, 0);
    }

    public Pont(int x, int y) {
        this.setX(x); //tesztelve van a setter
        this.setY(y);
    }

    public double getTavolsag() {
        return  Math.sqrt(this.x * this.y + this.x + this.y);
    }

    public String getKoordinatak() {
        return "(" + this.x + "," + this.y + ")";
    }

    public String toString() { //mindig kell (igy tesztelve vannak a getterek)
        return "X: " + getX() + ", Y: " + getY() + ", Origotol mert tavolsag: " + getTavolsag();
    }

}

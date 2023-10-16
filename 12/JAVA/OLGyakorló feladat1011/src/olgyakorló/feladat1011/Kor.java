package olgyakorló.feladat1011;

public class Kor {
    private int x;
    private int y;
    private int r;

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

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    
    
    public Kor(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public Kor(int r) {
        this(0, 0, r);
    }

    public String getXYR() {
        return "(" + getX() + "," + getY() + "," + getR() + ")";
    }

    public String ABKor(Kor bKor) {
        final double tavolsag = Math.sqrt(Math.pow(bKor.getX() - getX(), 2) + Math.pow(bKor.getY() - getY(), 2));
                
        if (tavolsag < getR() + bKor.getR()) {
            if (getR() < bKor.r) {
                return "Az aKor teljesen beleesik a bKorbe.";
            } else {
                return "Az bKor teljesen beleesik az aKorbe.";
            }
        } else if (tavolsag < getR() + bKor.getR() && tavolsag > Math.abs(getR() - bKor.getR())) {
            return "A ket kor metszi egymast.";
        } else {
            return "A ket kor nem erinti egymast";
        } 
    }
}

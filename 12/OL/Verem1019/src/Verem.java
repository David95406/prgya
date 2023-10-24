public class Verem {
    private int v[]; //verem
    private int k; //tomb aktualis merete
    private int n; //tomb max merete


    public Verem(int n) {
        this.setK(0);
        this.setN(n);
        v = new int[n];
    }

    public boolean add(int szam) {
        if (k != n) {
            v[k] = szam;
            setK(getK() + 1);
            //k++;
            return true;
        }
        return false;

    }

    public boolean remove() {
        if (k > 0) {
            setK(getK() - 1);
            //k--;
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return k == 0;
    }

    public int search(int szam) {
        for (int i = k - 1; i >= 0; i--) {
            if (v[i] == szam) {
                return i;
            }
        }
        return -1;
    }

    public boolean isContains(int szam) {
        return search(szam) != -1;
    }

    public String toString() {
        String str = "A verem maximalis merete: " + this.getN() +
                "\nA verem aktualis merete: " + this.getK();
        if (!isEmpty()) {
            str += "\nVerem elemei: ";
            for (int i = k - 1; i >= 0; i--) {
                str += v[i] + ", ";
            }
        } else {
            str += "\nA verem ures";
        }

        return str;
    }

    //getter setter


    public int getN() {
        return n;
    }

    private void setN(int n) {
        this.n = n;
    }

    public int getK() {
        return k;
    }

    private void setK(int k) {
        this.k = k;
    }


}

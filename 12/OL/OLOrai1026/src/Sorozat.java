public class Sorozat {
    private int n, k;
    private int[] elemek;

    public Sorozat(int n) {
        this.n = n;
        this.k = 0;
    }

    public Sorozat(int[] elemek) {
        this.n = elemek.length;
        k = n;
        this.elemek = new int[n];

        for (int i = 0; i < elemek.length; i++) {
            this.elemek[i] = elemek[i];

        }
    }

    public String toString() {
        String str = "Elemek: ";
        for (int i = 0; i < k; i++) {
            str += String.valueOf(elemek[i]) + " ";
        }
        return str;
    }

    public void add(int value) {
        if (k < n) {
            elemek[k++] = value;
        }
    }

    public void remove() {
        if (k > 0) {
            k--;
        }
    }

    public boolean isSzamtani() {
        if (k >= 3) {
            final int differencial = elemek[1] - elemek[0];
            for (int i = 0; i < elemek.length - 1; i++) {
                if (!(elemek[i + 1] == elemek[i] + differencial)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }

    public int kozosElemek(Sorozat masikSorozat) {
        int returnValue = 0;

        if (k > 0 && masikSorozat.k > 0) {
            for (int masikElem : masikSorozat.elemek) {
                for (int elem : elemek) {
                    if (masikElem == elem) {
                        returnValue++;
                    }
                }
            }
        } else {
            return returnValue;
        }

        return returnValue;
    }

    public void removeFromIndex(int index) {
        if (index <= k) {
            k--;
            for (int i = index; i < elemek.length - index - 1; i++) {
                elemek[i] = elemek[i + 1];
            }
        }
    }

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

    public int[] getElemek() {
        return elemek;
    }

    private void setElemek(int[] elemek) {
        this.elemek = elemek;
    }
}
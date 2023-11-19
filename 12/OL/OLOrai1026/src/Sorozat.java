public class Sorozat {
    private int n, k;
    private int[] elemek;

    public Sorozat(int n) {
        setN(n);
        setK(0);
    }

    public Sorozat(int[] elemek) {
        setN(elemek.length);
        setK(this.getN());
        setElemek(elemek);
    }

    public String toString() {
        String text = "Elemek: ";

        for (int i = 0; i < k; i++) {
            text += String.valueOf(elemek[i]) + " ";
        }

        return text;
    }

    public int kozosElemek(Sorozat masikSorozat) {
        int kozos = 0;

        if (getK() > 0 && masikSorozat.getK() > 0) {
            for (int masikElem : masikSorozat.elemek) {
                for (int elem : elemek) {
                    if (masikElem == elem) {
                        kozos++;
                    }
                }
            }
        } else {
            return kozos;
        }

        return kozos;
    }

    public void add(int value) {
        if (k < n) {
            elemek[k++] = value;
        }
    }

    public void remove(int index) {
        if (index >= 0 && index <= getK()) {
            int[] uj = new int[k--];
            for (int i = 0; i < uj.length; i++) {
                if (i != index) {
                    uj[i] = elemek[i];
                    System.out.println(elemek[i] + " cserelve " + uj[i]);
                }
            }
            setElemek(uj);
        }
    }

    public void removea(int index) {
        if (index >= 0 && index <= getK() - 1) {
            setK(getK() - 1);

            final int[] regi = getElemek();
            System.out.println(k);
            System.out.println(k - index);
            for (int i = index; i < k++; i++) {
                System.out.println(elemek[i] + " cserelve " + elemek[i + 1]);
                elemek[i] = regi[i + 1];
            }
        }
    }

    public boolean isSzamtani() {
        if (k >= 3) {
            final int differencial = elemek[1] - elemek[0];
            for (int i = 0; i < k - 1; i++) {
                if (!(elemek[i + 1] == elemek[i] + differencial)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
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
        int[] elemek = new int[k];

        for (int i = 0; i < k; i++) {
            elemek[i] = this.elemek[i];
        }
        return elemek;
    }

    private void setElemek(int[] elemek) {
        this.elemek = elemek;
    }
}
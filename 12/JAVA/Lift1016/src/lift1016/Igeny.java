package lift1016;

public class Igeny {
    private int ora;
    private int perc;
    private int masodperc;
    private int csapat;
    private int induloSzint;
    private int celSzint;

    public int getOra() {
        return ora;
    }

    public void setOra(int ora) {
        if (ora >= 0 && ora <= 24) {
            this.ora = ora;
        }
    }

    public int getPerc() {
        return perc;
    }

    public void setPerc(int perc) {
        if (perc >= 0 && perc <= 60) {
            this.perc = perc;
        }
    }

    public int getMasodperc() {
        return masodperc;
    }

    public void setMasodperc(int masodperc) {
        if (masodperc >= 0 && masodperc <= 60) {
            this.masodperc = masodperc;
        }
    }

    public int getCsapat() {
        return csapat;
    }

    public void setCsapat(int csapat) {
        if (csapat > 0 && csapat <= 50) {
            this.csapat = csapat;
        }
    }

    public int getInduloSzint() {
        return induloSzint;
    }

    public void setInduloSzint(int induloSzint) {
        if (induloSzint > 0) {
            this.induloSzint = induloSzint;
        }
    }

    public int getCelSzint() {
        return celSzint;
    }

    public void setCelSzint(int celSzint) {
        if (celSzint > 0) {
            this.celSzint = celSzint;
        }
    }
    
    public Igeny(int ora, int perc, int masodperc, int csapat, int induloSzint, int celSzint) {
        this.ora = ora;
        this.perc = perc;
        this.masodperc = masodperc;
        this.csapat = csapat;
        this.induloSzint = induloSzint;
        this.celSzint = celSzint;
    }
    
    @Override
    public String toString() {
        return "Befejezes ideje: " + ora + ":" + perc + ":" + masodperc
                + "\nCsapat: " + csapat + "\nIndulószint: " + induloSzint + "\nCélszint: " + celSzint;
    }
}

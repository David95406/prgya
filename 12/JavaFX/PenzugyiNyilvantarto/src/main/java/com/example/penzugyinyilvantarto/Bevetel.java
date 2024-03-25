package com.example.penzugyinyilvantarto;

public class Bevetel {
    private int osszeg;
    private String datum;
    private String leiras;

    public Bevetel(int osszeg, String datum, String leiras) {
        setOsszeg(osszeg);
        setDatum(datum);
        setLeiras(leiras);
    }

    @Override
    public String toString() {
        return "Bevetel{" +
                "osszeg=" + getOsszeg() +
                ", datum='" + getDatum() + '\'' +
                ", leiras='" + getLeiras() + '\'' +
                '}';
    }

    public int getOsszeg() {
        return osszeg;
    }

    public void setOsszeg(int osszeg) {
        this.osszeg = osszeg;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }
}

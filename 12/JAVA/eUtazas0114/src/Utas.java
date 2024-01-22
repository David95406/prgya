/*
FEB Felnőtt bérlet
TAB Tanulóbérlet (kedvezményes)
NYB Nyugdíjas bérlet (kedvezményes)
NYP 65 év feletti bérlet (ingyenes)
RVS Rokkant, vak, siket vagy kísérő bérlet (ingyenes)
GYK Iskolakezdés előtti gyerekbérlet (ingyenes)
JGY Jegy
*/

public class Utas {
    private int megalloId;
    private String felszallasDatum;
    private int kartyaId;
    private String kartyaTipusa;
    private int ervenyesseg;

    //if felszallasdatum >= ervenyessg -> ervenytelen
    public boolean isErvenyes() {
        if (getKartyaTipusa().equals("JGY") && getErvenyesseg() == 0) {
            return false;
        } else if (!getKartyaTipusa().equals("JGY") && getFelszallasEvHonapNap() > getErvenyesseg()){
            return false;
        }

        return true;
    }

    public int getFelszallasEvHonapNap() {
        return Integer.parseInt(getFelszallasDatum().split("-")[0]);
    }

    public Utas(String[] adatok) {
        this.setMegalloId(Integer.parseInt(adatok[0]));
        this.setFelszallasDatum(adatok[1]);
        this.setKartyaId(Integer.parseInt(adatok[2]));
        this.setKartyaTipusa(adatok[3]);
        this.setErvenyesseg(Integer.parseInt(adatok[4]));
    }

    public Utas(int megalloId, String felszallasDatum, int kartyId, String kartyTipusa, int ervenyesseg) {
        this.megalloId = megalloId;
        this.felszallasDatum = felszallasDatum;
        this.kartyaId = kartyId;
        this.kartyaTipusa = kartyTipusa;
        this.ervenyesseg = ervenyesseg;
    }

    @Override
    public String toString() {
        return "Utas{" +
                "megalloId=" + megalloId +
                ", felszallasDatum='" + felszallasDatum + '\'' +
                ", kartyaId=" + kartyaId +
                ", kartyaTipusa='" + kartyaTipusa + '\'' +
                ", ervenyesseg='" + ervenyesseg + '\'' +
                '}' + '\n';
    }

    public int getMegalloId() {
        return megalloId;
    }

    public void setMegalloId(int megalloId) {
        this.megalloId = megalloId;
    }

    public String getFelszallasDatum() {
        return felszallasDatum;
    }

    public void setFelszallasDatum(String felszallasDatum) {
        this.felszallasDatum = felszallasDatum;
    }

    public int getKartyaId() {
        return kartyaId;
    }

    public void setKartyaId(int kartyaId) {
        this.kartyaId = kartyaId;
    }

    public String getKartyaTipusa() {
        return kartyaTipusa;
    }

    public void setKartyaTipusa(String kartyaTipusa) {
        this.kartyaTipusa = kartyaTipusa;
    }

    public int getErvenyesseg() {
        return ervenyesseg;
    }

    public void setErvenyesseg(int ervenyesseg) {
        this.ervenyesseg = ervenyesseg;
    }
}

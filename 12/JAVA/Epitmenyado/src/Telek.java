public class Telek {
    private String adoszam;
    private String utca;
    private String hazszam;
    private String adosav;
    private int alapterulet;

    public boolean getBaj() {
        if ((hazszam.contains("A") && adosav.equals("A")) ||
                (hazszam.contains("B") && adosav.equals("B")) ||
                (hazszam.contains("C") && adosav.equals("C"))) {
            return true;
        }
        return false;
    }

    public Telek(String adoszam, String utca, String hazszam, String adosav, int alapterulet) {
        this.setAdoszam(adoszam);
        this.setUtca(utca);
        this.setHazszam(hazszam);
        this.setAdosav(adosav);
        this.setAlapterulet(alapterulet);
    }

    @Override
    public String toString() {
        return "Telek{" +
                "adoszam='" + getAdoszam() + '\'' +
                ", utca='" + getUtca() + '\'' +
                ", hazszam='" + getHazszam() + '\'' +
                ", adosav='" + getAdosav() + '\'' +
                ", alapterulet=" + getAlapterulet() +
                '}';
    }

    public String getAdoszam() {
        return adoszam;
    }

    public void setAdoszam(String adoszam) {
        this.adoszam = adoszam;
    }

    public String getUtca() {
        return utca;
    }

    public void setUtca(String utca) {
        this.utca = utca;
    }

    public String getHazszam() {
        return hazszam;
    }

    public void setHazszam(String hazszam) {
        this.hazszam = hazszam;
    }

    public String getAdosav() {
        return adosav;
    }

    public void setAdosav(String adosav) {
        this.adosav = adosav;
    }

    public int getAlapterulet() {
        return alapterulet;
    }

    public void setAlapterulet(int alapterulet) {
        this.alapterulet = alapterulet;
    }
}

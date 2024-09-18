public class Film implements iFilm {
    private String magyarCim;
    private String rendezo;
    private int jatekido;

    public Film(String magyarCim, String rendezo, int jatekido) {
        setMagyarCim(magyarCim);
        setRendezo(rendezo);
        setJatekido(jatekido);
    }

    @Override
    public String getHossz() {
        String hosszString = (getJatekido() / 60) + ":" + (getJatekido() - ((getJatekido() / 60) * 60));
        if (hosszString.split(":")[0].length() == 1) {
            hosszString = "0" + hosszString;
        }
        if (hosszString.split(":")[1].length() == 1) {
            hosszString = hosszString.split(":")[0] + ":0" + hosszString.split(":")[1];
        }
        return hosszString;
    }

    @Override
    public String toString() {
        return "Film{" +
                "magyarCim='" + getMagyarCim() + '\'' +
                ", rendezo='" + getRendezo() + '\'' +
                ", hossz=" + getJatekido() +
                '}';
    }

    public String getMagyarCim() {
        return magyarCim;
    }

    public void setMagyarCim(String magyarCim) {
        this.magyarCim = magyarCim;
    }

    public String getRendezo() {
        return rendezo;
    }

    public void setRendezo(String rendezo) {
        this.rendezo = rendezo;
    }

    public int getJatekido() {
        return jatekido;
    }

    public void setJatekido(int jatekido) {
        this.jatekido = jatekido;
    }
}

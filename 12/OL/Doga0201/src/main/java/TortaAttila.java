public class Torta {
    private int emeletekSzama;
    private boolean kremesE;
    private String alak;


    public Torta(int emeletekSzama, boolean kremesE, String alak) throws IllegalArgumentException{
        setEmeletekSzama(emeletekSzama);
        setAlak(alak);
        setKremesE(kremesE);
    }
    public Torta() throws IllegalArgumentException{
        this(1, false, "kör");
    }

    public void ujEmelet(){
        setEmeletekSzama(emeletekSzama+1);
    }
    public void kremmelMegken() throws TortaException {
        if(isKremesE()){
            throw new TortaException("A torta már megvan kenve");
        }
        else{
            setKremesE(true);
        }
    }
    public int mennyiKaloria(){
        if(isKremesE()){
            return this.getEmeletekSzama()*2000;
        }
        else{
            return getEmeletekSzama()*1000;
        }
    }

    public int getEmeletekSzama() {
        return emeletekSzama;
    }

    public void setEmeletekSzama(int emeletekSzama) throws IllegalArgumentException{
        if(emeletekSzama <= 0){
            throw new IllegalArgumentException("Legalább egy emeletnek lenni kell");
        }
        this.emeletekSzama = emeletekSzama;
    }

    public boolean isKremesE() {
        return kremesE;
    }

    public void setKremesE(boolean kremesE) {
        this.kremesE = kremesE;
    }

    public String getAlak() {
        return alak;
    }

    public void setAlak(String alak) {
        this.alak = alak;
    }

    @Override
    public String toString() {
        return "{" + getAlak() + ";" + getEmeletekSzama() + ";" + isKremesE() + "}";
    }
}

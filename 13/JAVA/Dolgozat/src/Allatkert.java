import java.util.ArrayList;

public class Allatkert {
    private ArrayList<Allat> allatok = new ArrayList<>();

    public Allatkert() {
        this.allatok = new ArrayList<>();
    }

    public Allatkert(ArrayList<Allat> allatok) {
        this();
        this.allatok.addAll(allatok);
    }

    public void addAllat(Allat allat) {
        this.allatok.add(allat);
    }

    public void removeAllat(Allat allat) {
        this.allatok.remove(allat);
    }

    public void removeAllatByName(String name) {
        for (Allat a : getAllatok()) {
            if (a.getNev().contains(name)) {
                this.allatok.remove(a);
                System.out.println("Sikeres toles!");
                break;
            }
        }
    }

    public void removeAllatByIndex(int index) {
        this.allatok.remove(index);
    }

    public void soutAllatok() {
        String str = "";
        for (Allat a : getAllatok()) {
            str += a.toString() + "\n";
        }
        System.out.println(str);
    }

    @Override
    public String toString() {
        return "Allatkert{" +
                "allatok=" + getAllatok() +
                '}';
    }

    public ArrayList<Allat> getAllatok() {
        return allatok;
    }
}

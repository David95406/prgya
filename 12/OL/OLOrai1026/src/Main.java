public class Main {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 6, 8, 10};
        int[] szamok = {3, 4, 6, 10};

        Sorozat masikSorozat = new Sorozat(1);


        Sorozat ujSorozat = new Sorozat(numbers);
        Sorozat uj2Sorozat = new Sorozat(szamok);
        System.out.println(ujSorozat);
        ujSorozat.remove(3);
        System.out.println(ujSorozat);



    }
}
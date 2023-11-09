public class Main {
    public static void main(String[] args) {
        int[] myNum = {2, 4, 6, 8};
        int[] szamok = {3, 4, 6, 10};

        Sorozat masikSorozat = new Sorozat(1);


        Sorozat ujSorozat = new Sorozat(myNum);
        Sorozat uj2Sorozat = new Sorozat(szamok);


        System.out.println(ujSorozat);

        System.out.println(ujSorozat.isSzamtani());
        System.out.println(ujSorozat.kozosElemek(uj2Sorozat));

        System.out.println(ujSorozat);
        ujSorozat.removeFromIndex(2);
        System.out.println(ujSorozat);
    }
}
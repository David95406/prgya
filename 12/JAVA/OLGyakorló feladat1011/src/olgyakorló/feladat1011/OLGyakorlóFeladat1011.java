package olgyakorló.feladat1011;

import java.util.Random;

public class OLGyakorlóFeladat1011 {

    public static void main(String[] args) {
        Kor alapKor = new Kor(10, 10, 10);
        System.out.println(alapKor.getXYR());
        Kor aKor = new Kor(4);
        Kor bKor = new Kor(2, 2, 3);
        System.out.println(aKor.ABKor(bKor));
    }
    
}

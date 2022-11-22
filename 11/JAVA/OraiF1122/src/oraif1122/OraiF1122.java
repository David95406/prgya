package oraif1122;

public class OraiF1122 {

    public static int haromMin(int a, int b, int c) {
        return (Math.min(a, Math.min(b, c)));
    }

    public static String centerChar(String text) {
        if (text.length() % 2 != 0) {
            return Character.toString(text.charAt(text.length() / 2));
        } else {
            return text.charAt(text.length() / 2) + Character.toString(text.charAt((text.length() / 2) + 1));
        }

    }

    public static int mgh(String text) {
        int i, mghDb = 0;
        text = text.toLowerCase();

        for (i = 0; i < text.length(); i++) { //a, e, i, o, u, y
            if (text.charAt(i) == 'a' || text.charAt(i) == 'e' || text.charAt(i) == 'o' || text.charAt(i) == 'u' || text.charAt(i) == 'y') {
                mghDb++;
            }
        }

        return mghDb;
    }

    public static int szavakSzam(String text) {
        return text.split(" ").length;
    }

    public static boolean passwdCheck(String password) {
        int i, passwdDigit = 0, passwdLetter = 0;
        char[] chars = password.toCharArray();

        for (i = 0; i < password.length(); i++) {
            if (Character.isDigit(chars[i])) {
                passwdDigit++;
            } else if (Character.isLetter(chars[i])) {
                passwdLetter++;
            }
        }

        return (password.length() > 10 && passwdDigit >= 2 && passwdLetter > 0);
    }

    public static boolean novekvoSorrend(int a, int b, int c) {
        return (a < b && b < c);
    }
    
    public static int szamjegyekOssz(int num) {
        int i, szjegyOssz = 0;
        
        for (i = 0; i < String.valueOf(num).length(); i++) {
            szjegyOssz = szjegyOssz + (Integer.valueOf(String.valueOf(num).charAt(i)) - 48);
        }
        
        return szjegyOssz;
    }
    
    public static String ketKarKozt(String text, String startChar, String stopChar) {
        int start = text.indexOf(startChar), stop = text.indexOf(stopChar);
        
        return (text.substring(start, stop + 1));
    }
    
    public static void main(String[] args) {
        String szoveg = "Ez egy test szoveg", jelszo = "Jelszo123";

        System.out.println(haromMin(5, 2, 8));
        System.out.println(centerChar(szoveg));
        System.out.println(mgh(szoveg));
        System.out.println(szavakSzam(szoveg));
        System.out.println(passwdCheck(jelszo));
        System.out.println(novekvoSorrend(1,2,3));
        System.out.println(ketKarKozt(szoveg, "E", "t"));
        System.out.println(szamjegyekOssz(123));
        

    }

}
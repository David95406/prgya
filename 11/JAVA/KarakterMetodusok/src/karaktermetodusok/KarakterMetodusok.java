package karaktermetodusok;

public class KarakterMetodusok {

    public static void main(String[] args) {
        char kar = 'a';
        //alfabetikus e?
        System.out.println(Character.isAlphabetic(kar));
        //betu e:
        System.out.println(Character.isLetter(kar));
        //szam e?
        System.out.println(Character.isDigit(kar));
        //betu vagy szam e?
        System.out.println(Character.isLetterOrDigit(kar));
        //kisbetus e?
        System.out.println(Character.isLowerCase(kar));
        //nagybetus e?
        System.out.println(Character.isUpperCase(kar));
        //whitespace karakter e?
        System.out.println(Character.isWhitespace(kar));
        //kisbetusites
        System.out.println(Character.toLowerCase(kar));
        //nagybetusites
        System.out.println(Character.toUpperCase(kar));
    }

}

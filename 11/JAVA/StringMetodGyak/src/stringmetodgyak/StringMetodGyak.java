package stringmetodgyak;

public class StringMetodGyak {
    public static void main(String[] args) {
        String nev, szoveg, email;
        int i, nevKezd = 0, nevVeg = 0;
        szoveg = "A Diak osztaly objektuma (Vad Alma Korte) peldanyositas utjan jon letre.";
        
        nevKezd = szoveg.indexOf('(');
        nevVeg = szoveg.indexOf(')');
        nev = szoveg.substring(nevKezd + 1, nevVeg).trim().toUpperCase();
        
        System.out.println(nev);
        System.out.println(nev.replace("ALMA", "KORTE"));
        
        email = nev.toLowerCase().replace(" ", ".").concat(".2022i@bankitatabanya.hu");
        System.out.println(email);
        
        
        //doga ell
        String ujszoveg = "Sok lúd disznót győz.";
        String masikszoveg = "";
        
        System.out.println(ujszoveg.length());
        System.out.println(ujszoveg.charAt(0));
        System.out.println(ujszoveg.equals(masikszoveg));
        System.out.println(ujszoveg.contains("lúd"));
        System.out.println(szoveg.indexOf("lúd"));
        System.out.println(ujszoveg.replace("lúd", "veréb"));
        System.out.println(szoveg.substring(ujszoveg.indexOf(" ")));
    }
    
}

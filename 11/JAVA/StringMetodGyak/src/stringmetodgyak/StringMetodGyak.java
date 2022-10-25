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
        
    }
    
}

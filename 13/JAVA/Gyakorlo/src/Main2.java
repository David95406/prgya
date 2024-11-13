public class Main2 {
    public static void main(String[] args) {
        Kutya Lena = new Kutya("Léna");
        Macska Otto = new Macska("Ottó");
        Medve Dormi = new Medve("Dörmi");

        Lena.hangotAd();
        Lena.eszik();

        Otto.hangotAd();
        Otto.eszik();
        
        Dormi.hangotAd();
        Dormi.eszik();
    }
}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static double szazalek(ArrayList<Dijazott> dijazottak){
        int db = 0;
        for (int i=0;i<dijazottak.size();i++){
            if(dijazottak.get(i).getMegjegyzes().equals("I. fokozat")){
                db++;
            }
        }
        return ((double) db / dijazottak.size())*100;
    }

    public static void main(String[] args) {
        ArrayList<Dijazott> dijazottak = new ArrayList<>();
        try{
            FileReader fr = new FileReader("dijazottak.csv");
            BufferedReader br = new BufferedReader(fr);
            String sor = br.readLine();
            while ((sor = br.readLine())!=null){
                StringTokenizer st = new StringTokenizer(sor,"\t");
                st.nextToken();
                Dijazott d = new Dijazott(st.nextToken(), Integer.parseInt(st.nextToken()), st.nextToken(), st.nextToken());
                dijazottak.add(d);
            }
            br.close();
            fr.close();
        }catch (FileNotFoundException fnfe){
            System.out.println(fnfe);
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println("8. feladat:");
        int db = 0;
        for (int i=0;i<dijazottak.size();i++){
            if(dijazottak.get(i).getNev().contains(" László")){
                db++;
            }
        }
        System.out.println("László keresztnevű díjazottak száma: " + db);

        int maxDb = 0, maxEv = 0;
        for(int ev = 1948; ev<=2008; ev++){
            db = 0;
            for (int i=0;i<dijazottak.size();i++){
                if(dijazottak.get(i).getEv() == ev){
                    db++;
                }
            }
            if(db > maxDb){
                maxDb = db;
                maxEv = ev;
            }
        }
        System.out.println("9. feladat:");
        System.out.println("A legtöbb díjat "+maxEv+"-ban adták.");
        System.out.println("10. feladat:");
        System.out.printf("I. fokozatú díjazott: %.1f%%",szazalek(dijazottak));

    }
}

package filebeolvasas2;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class file5 {
    
    public static void main(String[] args) {
        RandomAccessFile raf;
        String sorMatrix;
        
        ArrayList<ArrayList<Integer>> szamokMatrix = new ArrayList<>();

        try {
            raf = new RandomAccessFile("adat3.txt", "r");
            sorMatrix = raf.readLine();
            
            ArrayList<Integer> sor = new ArrayList<>();

            while (sorMatrix != null) {
                sor = new ArrayList<>();
                for (int i = 0; i < sorMatrix.split(" ").length; i++) {
                    sor.add(Integer.parseInt(sorMatrix.split(" ")[i]));
                }
                szamokMatrix.add(sor);
                sorMatrix = raf.readLine();
            }

            raf.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        
        System.out.println(szamokMatrix);

        
    }
}

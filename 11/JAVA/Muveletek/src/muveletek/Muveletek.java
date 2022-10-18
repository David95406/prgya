/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package muveletek;

/**
 *
 * @author user3
 */
public class Muveletek {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // matematikai muveletek
            // ket operatosu
            int a = 43;
            int b = 35;
            
            
            int osszeg = a + b;
            int kulonbseg = a - b;
            int szorzat = a * b;
            double hanyados = (double)a / (double)b;
            
            System.out.println(hanyados);
            
            int maradek = a % b;
            System.out.println(maradek);
            
            System.out.println("\n\n");
            
            // egy operanduso
            int x = 5;
            System.out.println(x);
            x++;
            System.out.println(x);
            System.out.println(x++);
            int y = x++;
            System.out.println(y);
            System.out.println(x);
            ++x;
            System.out.println(x);
            System.out.println(++x);
            //orai(leon)
            System.out.println("orai\n\n");
            int c = 5;
            c++; // c értékének növelése 1-gyel postfix formában
            System.out.println(c);//c érétéke 6
            System.out.println(c++);//c értéke 6 majd növeli 1-gyel ->7
            System.out.println(++c); //c értéke 8 lesz, ezt iratjuk ki
            
            int n = 9;
            int k = 14;
            
            System.out.println(n > k); //f
            System.out.println(n < k); //t
            System.out.println(n >= k); //f
            System.out.println(n <= k); //t
            System.out.println(n == k); //f
            System.out.println(n != k); //t
            
            System.out.println("\n\nLogikai muveletek\n");
            
            //logikai muveletek
            boolean t = true;
            boolean f = false;
            
            System.out.println(t && f); //ÉS muvelet
            System.out.println(f && t); //-||-
            
            System.out.println(t || f); //VAGY muvelet
            System.out.println(!t); //negacio (tagadas) muvelet
            
            //ertekado muvelet
            System.out.println("\nertekado muveletek\n");
            
            int r;
            r = 3;
            r = r + 1;
            r += 1; //osszevontuk a muveletet mint pyben
            System.out.println(r);
            r -= 2;
            System.out.println(r);
            r *= 2;
            System.out.println(r);
            r /= 4;
            System.out.println(r);
            r %= 2;
            System.out.println(r);
            
            System.out.println("\nosszetett muveletek\n");
            
            //osszetett muveletek
            int z = 12;
            System.out.println((z % 3 == 0) && (z % 4 == 0));
            System.out.println((z % 3 == 0) || (z % 4 == 0));
            System.out.println(!(z % 3 == 0) && (z % 5 == 0));
            System.out.println(!(z % 3 == 0) && !(z % 5 == 0));
            System.out.println((z % 5 == 0) && !(z < 0));        
            
            
    }
    
}

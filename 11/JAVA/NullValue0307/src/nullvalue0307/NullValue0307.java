package nullvalue0307;

public class NullValue0307 {

    public static void main(String[] args) {
        Integer tt = 20;
        int test = 10;
        
        System.out.println(tt);
        System.out.println(tt == null);
        System.out.println(tt + test);
        System.out.println(tt.equals(null));
        
        if (tt != null) {
            System.out.println(tt == 8);
        }
    }
    
}

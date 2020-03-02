package laborator1;

import java.util.*;

public class ex4{
    public static void main( String [] args ){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        double rez = 1;
        for ( int i = 2; i <= a; i++) {
            rez = rez * i;
        }
        System.out.println (rez);
        sc.close();
    }
}
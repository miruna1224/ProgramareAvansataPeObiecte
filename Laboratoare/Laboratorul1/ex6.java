package laborator1;

import java.util.*;
import java.lang.Math;

public class ex6{
    public static void main( String [] args ){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a;
        int d = b;
        System.out.println( a ^ b);
        int rez = 1;
        while ( b > 0 ){
            rez = rez * a;
            b--;
        }
        System.out.println(rez);
        System.out.println(Math.pow(c, d));
        sc.close();
    }
}
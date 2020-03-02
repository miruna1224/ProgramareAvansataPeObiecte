package laborator1;

import java.util.*;
import java.lang.Math;

public class ex3{
    public static void main( String [] args ){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println ( 1 );
        System.out.println ( a );
        for( int i = 2; i <= Math.sqrt(a); i++ ){
            if ( a % i == 0){
                System.out.println (i );
                System.out.println ( a / i );}
            }
        sc.close();
    }
}
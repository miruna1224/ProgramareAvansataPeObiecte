package laborator1;

import java.util.*;
import java.lang.Math;

public class ex5{
    public static void main( String [] args ){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        if ( a < 2 )
            System.out.println ("Numarul nu este prim");
        else{
            if ( a < 6 )
                System.out.println ("Numarul este prim");
             else{
                 boolean b = true;
                 for (int i = 2; i <= Math.sqrt(a); i++ ){
                        if ( a % i == 0 ){
                            b = false;
                            break;
                        }
                 }
                 if ( b == true ){
                    System.out.println ("Numarul este prim");
                 }
                 else{
                     System.out.println("Numarul nu este prim");
                 }
             }
        }
        
        sc.close();
    }
}
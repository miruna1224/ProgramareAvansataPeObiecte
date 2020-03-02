package laborator1;

import java.util.*;
import java.lang.Math;

public class ex7{
    public static void main( String [] args ){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        sc.close();
        int nr = 2;
        int t1 = 0, t2 = 1;
        if ( a == 1 ){
            System.out.println(0);
        }
         else{
             if (a == 2)
                System.out.println (1);
              else{
                  while (nr < a){
                    nr++;
                    int aux = t2;
                    t2 = aux + t1;
                    t1 = aux;
                    }
                   System.out.println ( t2);
                }
          }
    }
}
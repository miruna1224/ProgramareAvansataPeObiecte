package laborator2;

import java.util.*;

public class ex2{
   public static void main( String [] args ){
      Scanner sc = new Scanner(System.in);
      int dim = sc.nextInt(), dim_p = 0, dim_i = 0;
      int nr_p[] = new int [dim + 1];
      int nr_i[] = new int [dim + 1];
      for (int i = 0; i < dim; i++){
          int x = sc.nextInt();
          if ( x % 2 == 0 ){
              nr_p[dim_p] = x;
              dim_p ++;
            }
           else {
              nr_i[dim_i] = x;
              dim_i ++;
            }
      }
      if ( dim_i > dim_p )
        for (int i = 0; i < dim_i; i++)
            System.out.println( nr_i[i] );
      else
        for (int i = 0; i < dim_p; i++)
             System.out.println( nr_p[i]);
   }
}

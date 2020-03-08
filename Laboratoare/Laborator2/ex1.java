package laborator2;

import java.util.*;

public class ex1{
   public static void main( String [] args ){
       Scanner sc = new Scanner(System.in);
       int x, i;
       float medie = 0;
       Queue<Integer> q = new LinkedList<>();
       x = sc.nextInt();
       while (x != -1){
            medie += x;
            q.add(x);
            x = sc.nextInt();
        }
       System.out.println(medie/q.size());
   }
}

package laborator1;

import java.util.*;

public class ex2{
    public static void main( String [] args ){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println( a < b ? b : a);
        sc.close();
    }
}
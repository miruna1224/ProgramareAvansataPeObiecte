
import java.util.*;

public class temaex1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();

        if (a.length() != b.length()){
            System.out.println("Nu sunt anagrame");
            System.exit(0);
        }

        int check[] = new int[27];
        for (int i = 0; i < 27; i++ )
            check[i] = 0;
        for (int i = 0; i < a.length(); i++)
            check[(int)a.charAt(i) - 97] += 1;
        for (int i = 0; i < a.length(); i++)
            check[(int)b.charAt(i) - 97] -= 1;
        for (int i = 0; i < 27; i++ )
            if (check[i] != 0){
                System.out.println("Nu sunt anagrame");
                System.exit(0);
            }
        System.out.print( "Sunt anagrame");
    }
}

//public class temaex1 {
//
//    public static void main(String[] args) {
//        String s1,s2;
//        Scanner sc = new Scanner(System.in);
//        s1 = sc.nextLine();
//        s2 = sc.nextLine();
//        char[] ch1 = s1.toCharArray();
//        char[] ch2 = s2.toCharArray();
//        Arrays.sort(ch1);
//        Arrays.sort(ch2);
//        s1 = new String(ch1);
//        s2 = new String(ch2);
//        //System.out.println(s1);
//        //System.out.println(s2);
//        if (s1.equals(s2))
//            System.out.println("Stringurile sunt anagrame");
//        else
//            System.out.println("Stringurile nu sunt anagrame");
//    }
//}
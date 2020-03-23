import java.util.*;

public class temaex2_corect {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int n  = sc.nextInt(), maxLength = -1;
        sc.nextLine();
        String sMaxL = new String("");

        Vector<String> a = new Vector<String>();
        Vector<String> b = new Vector<String>();

        for (int i = 0; i < n; i++ ){
            String s;
            s = sc.nextLine();
            if (maxLength < s.length()) {
                maxLength = s.length();
                sMaxL = s;
            }
            a.add(s);
            StringBuilder str = new StringBuilder(s);
            StringBuilder revStr = str.reverse();
            String rs = revStr.toString();
            if (s.equals(rs))
                b.add(s);
        }

        System.out.println("Lungimea maxima este : " + maxLength);
        System.out.println("Sirul cu lungimea maxima este : " + sMaxL);
        System.out.println("Tot vector este : " + a);
        System.out.println("Vectorul de palindroame este : " + b);
    }
}


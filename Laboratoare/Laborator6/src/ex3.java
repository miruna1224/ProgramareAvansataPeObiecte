import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ex3 {
    static int transformIntoNumber(String s){
        int nr = 0;
        char zero = '0';
        for(int i = 0; i < s.length(); i++ )
            if(s.charAt(i) <= '9' && s.charAt(i) >= '0')
                nr = nr * 10 + ((int)s.charAt(i) - (int)zero);
        return nr;
    }

    public static void main(String [] args) {
        final int carrigeReturn = 13;

        ArrayList<String> minori = new ArrayList<>();
        ArrayList<String> majori = new ArrayList<>();
        String nume, prenume, varsta;
        int nrMinori = 0;
        int nrMajori = 0;
        try {
            File file = new File("clienti.txt");
            FileInputStream fin = new FileInputStream(file);
            String aux = "";
            int ch = fin.read();
            while (ch != -1) {
                while ((char) ch != '\n' && ch != -1 && (char) ch != ' ') {
                    aux = aux + (char) ch;
                    ch = fin.read();
                }
                nume = aux;
                aux = "";
                ch = fin.read();
                while ((char) ch != '\n' && ch != -1 && (char)ch != ' ') {
                    aux = aux + (char) ch;
                    ch = fin.read();
                }
                prenume = aux;
                aux = "";
                ch = fin.read();
                while ((char) ch != '\n' && ch != -1 && ch != ' ') {
                    aux = aux + (char) ch;
                    ch = fin.read();
                }
                varsta = aux;
                aux = nume + " " + prenume + " " + varsta;
                int v = transformIntoNumber(varsta);
                if (v >= 18){
                    nrMajori += 1;
                    majori.add(aux);
                }
                else{
                    nrMinori += 1;
                    minori.add(aux);
                }
                aux = "";
                ch = fin.read();
            }
            System.out.println( nrMajori + " majori");
            for(int i = 0; i < nrMajori; i++ )
                System.out.println(majori.get(i));
            System.out.println( nrMinori + " minori");
            for(int i = 0; i < nrMinori; i++ )
                System.out.println(minori.get(i));
            fin.close();
        } catch (Exception e) {
            System.out.println(e);
            java.lang.System.exit(0);
        }
    }
}

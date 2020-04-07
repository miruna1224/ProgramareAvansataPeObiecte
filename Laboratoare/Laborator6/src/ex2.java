import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ex2 {
    public static void main(String [] args){
        final int carrigeReturn = 13;

        ArrayList<String> users = new ArrayList<>();
        ArrayList<String> passwords = new ArrayList<>();
        try{
            File file = new File("parole.txt");
            FileInputStream fin=new FileInputStream(file);
            String aux = "";
            int nrLinesFile = 0;
            int ch = fin.read();
            while( ch != -1 ){
                while( (char)ch != ' '){
                    aux = aux + (char)ch;
                    ch = fin.read();
                }
                users.add(aux);
                aux = "";
                ch = fin.read();
                while( (char) ch != '\n' && ch != -1 && ch != ' '){
                    aux = aux + (char) ch;
                    ch = fin.read();
                }
                passwords.add(aux);
                aux = "";
                ch = fin.read();
                nrLinesFile += 1;
            }
            for (int i = 0; i < nrLinesFile; i++)
                System.out.println(users.get(i) + " " + passwords.get(i));
            fin.close();
        }catch(Exception e){
            System.out.println(e);
            java.lang.System.exit(0);
        }

    Scanner sc = new Scanner(System.in);
    int ix = 0;
    int bl = -1;
    while(ix < 5) {
        System.out.println("Introduceti un user :");
        String user = sc.nextLine();
        for (int i = 0; i < users.size() && bl == -1; i++)
            if (users.get(i).equals(user))
                bl = i;
        if (bl == -1) {
            System.out.println("Nu exista userul in baza de date");
            ix += 1;
        }
        else break;
    }
    if( bl == -1){
        System.out.println("Nu ai cont. Inregistreaza-te");
    }
    else {
        int i = 0;
        while (i < 3) {
            System.out.println("Introduceti o parola :");
            String pass = sc.nextLine() + (char)carrigeReturn;
            if (pass.equals(passwords.get(bl) )) {
                System.out.println("Acces permis");
                break;
            }
            else {
                System.out.println("Parola este gresita. Rrintroduceti parola");
                i += 1;
            }
        }
        if (i >= 3)
            System.out.println("Cont blocat");
    }
    sc.close();
    }
}

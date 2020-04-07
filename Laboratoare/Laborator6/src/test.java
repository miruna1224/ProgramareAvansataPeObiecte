
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class test {
    public static void main( String [] args){
        BufferedWriter fileWriter = null;
        try{
            File file2 = new File("output.txt");
            fileWriter = new BufferedWriter(new FileWriter(file2));
            for(int i = 0; i < 3; i++) {
                fileWriter.write('a');
                System.out.println('a');
            }
            fileWriter.close();
        }
        catch( IOException | ArithmeticException e1){
            e1.printStackTrace();
            System.out.println("Input file error");
        }
    }
}


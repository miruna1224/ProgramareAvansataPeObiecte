
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class ex1 {

    public static <invalidCondition extends Throwable> void main(String [] args) {
        BufferedReader fileReader = null;
        BufferedWriter fileWriter = null;

        try {
            File file2 = new File("output.txt");
            fileWriter = new BufferedWriter(new FileWriter(file2));
            try {
                File file = new File("date.txt");
                fileReader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = fileReader.readLine()) != null) {
                    //                System.out.println(line);
                    String[] no = line.split(" ");
                    int a = Integer.parseInt(no[0]);
                    int b = Integer.parseInt(no[1]);

                    try {
                        if (a > b)
                            throw new invalidConditionData("a > b");
                        else
                            fileWriter.write(line + '\n');
                    } catch (invalidConditionData e) {
                        System.out.println("Conditia a fost incalcata pentru linia " + line);
                        int aux = a;
                        a = b;
                        b = aux;
                        line = String.valueOf(a) + " " + String.valueOf(b) + '\n';
                        fileWriter.write(line);
                    }
                }
            }
             catch (IOException | ArithmeticException e1) {
            e1.printStackTrace();
            System.out.println("Input file error");
            }
            fileWriter.close();
        }
        catch(IOException | ArithmeticException e1){
           e1.printStackTrace();
            System.out.println("Output file error");
         }
    }

}

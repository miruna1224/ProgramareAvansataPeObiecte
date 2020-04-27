package ReadWrite;

import Task.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SingletonOut {
    private static SingletonOut instance = null;
    private SingletonOut(ArrayList<Task> c){
        Audit a = new Audit("fileWrite");
        FileWriter w = null;
        String csvFile = "output.csv";
        try{
            w = new FileWriter(csvFile);
            for ( int  i = 0; i < c.size(); i++ ) {
                c.get(i).writeInfo(w);
                c.get(i).show();
            }
            w.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static SingletonOut getInstance(ArrayList<Task> c)
    {
        if (instance == null)
            instance = new SingletonOut(c);
        return instance;
    }
}

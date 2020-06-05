package main.java.Task;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class Audit {
    public Audit( String name ){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String fileName = "audit" + name + ".csv";
        //System.out.println(timestamp);
        FileWriter w = null;
        try{
            w = new FileWriter(fileName, true);
            w.write( name + " " + timestamp + '\n' );
            w.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    public Audit( String name, String thread ){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String fileName = "audit" + name + ".csv";
        //System.out.println(timestamp);
        FileWriter w = null;
        try{
            w = new FileWriter(fileName, true);
            w.write( name + " " + timestamp  + " Thread: " + thread + '\n' );
            w.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}

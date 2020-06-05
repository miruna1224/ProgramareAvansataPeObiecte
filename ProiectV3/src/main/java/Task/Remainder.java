package main.java.Task;

import main.java.Exceptions.InvalidDataException;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Remainder extends Note {
    int imp;

    public int getImp() {
        return imp;
    }

    public void setImp(int imp) {
        this.imp = imp;
    }

    public Remainder(){
        super("unknown");
        setImp(0);
    }

    public Remainder(int imp){
        try {
            if( imp < 0 || imp > 100)
                throw new InvalidDataException("Invalid importance rate");
            setImp(imp);
        }
        catch(InvalidDataException e){
            System.out.println("Error");
        }
    }

    public Remainder (Remainder r){
        super(r.getNoteText());
        setImp(r.getImp());
    }

    @Override
    public void show(){
        Audit a = new Audit("showRemainder");
        System.out.println("The note text is :");
        System.out.println(getNoteText());
        System.out.println("The importance rate of the remainder is " + getImp());
    }


    @Override
    public void showThread( String nameThread){
        Audit a = new Audit("showRemainder", nameThread);
        System.out.println("The note text is :");
        System.out.println(getNoteText());
        System.out.println("The importance rate of the remainder is " + getImp());
    }


    @Override
    public void writeInfo(FileWriter w){
        try{
            w.write("The note text is :");
            w.write(getNoteText());
            w.write("The importance rate of the remainder is " + getImp());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

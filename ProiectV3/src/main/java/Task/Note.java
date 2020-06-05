package main.java.Task;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Note extends Task {
    protected String noteText;
    private String vcolours[] = {"white", "green", "black", "red", "yellow", "blue", "magenta", "cyan"};
    String Green = "\u001B[32m";
    String White =  "\u001B[37m";
    String Black = "\u001B[30m";
    String Red = "\u001B[31m";
    String Yellow = "\u001B[33m";
    String Blue = "\u001B[34m";
    String Magenta = "\u001B[35m";
    String Cyan= "\u001B[36m";
    private String vcodes[] = {White, Green, Black, Red, Yellow, Blue, Magenta, Cyan};


    public void setNoteText(String noteText){
        this.noteText = noteText;
    }
    public String getNoteText(){
        return this.noteText;
    }

    public Note (){ setNoteText("This is a note"); }

    public Note (String s){
        setNoteText(s);
    }

    public Note (Note n){ setNoteText(n.getNoteText()); }

    @Override
    public void show(){
        Audit a = new Audit("showNote");
        System.out.println("The content of the note is :");
        System.out.println("\t" + getNoteText());
    }

    @Override
    public void showThread( String nameThread){
        Audit a = new Audit("showNote", nameThread);
        System.out.println("The content of the note is :");
        System.out.println("\t" + getNoteText());
    }

    @Override
    public void writeInfo(FileWriter w){
        try{
            w.write("The content of the note is :");
            w.write("\t" + getNoteText());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void modifyNote(){
        System.out.println("The current content of the note is:");
        System.out.println("\t" +  getNoteText());
        System.out.println("Do tou want to modify it ?");
        System.out.println("\t 0 - No     1 - Yes");
        Scanner scanner = new Scanner (System.in);
        int raspuns = scanner.nextInt();
        if(raspuns == 0)
            return;
        System.out.println("Text the new content :");
        setNoteText(scanner.nextLine());
    }

    public void changeDesign( String color){
        for (int i = 0; i < vcolours.length; i++)
            if (vcolours[i].equals(color)) {
                System.out.println(vcodes[i] + " ");
                show();
                System.out.println(vcodes[0] + " ");
                return;
            }
        System.out.println("Culoarea nu exista");
    }

}

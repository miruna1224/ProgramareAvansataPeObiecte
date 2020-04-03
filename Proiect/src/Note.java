import java.util.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;


public class Note extends Task {
    protected String noteText;
    private String vcolours[]={"red", "blue", "green", "white"};

    void setNoteText(String noteText){
        this.noteText = noteText;
    }
    String getNoteText(){
        return this.noteText;
    }

    Note (){ setNoteText("This is a note"); }

    Note (String s){
        setNoteText(s);
    }

    Note (Note n){ setNoteText(n.getNoteText()); }

    @Override
    void show(){
        System.out.println("The content of the note is :");
        System.out.println("\t" + getNoteText());
    }

    void modifyNote(){
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

    void changeDesign(String font, String color){
        try {
            Font f = new Font(font, Font.BOLD, 30);
            JTextField tf = new JTextField(60);
            tf.setFont(f);
            for (int i = 0; i < 4; i++)
                if(vcolours[i].equals(color))
                    tf.setForeground(Color.red);
                else{
                    if(vcolours[i].equals(color))
                        tf.setForeground(Color.blue);
                    else{
                        if(vcolours[i].equals(color))
                            tf.setForeground(Color.green);
                        else{
                            if(vcolours[i].equals(color))
                                tf.setForeground(Color.white);
                            else throw new InexStException("The colour doesn't exist");
                        }
                    }
                }
        }
        catch(InexStException e){
            System.out.println("Error");
        }
    }

}

package main.java.Task;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Todo extends Task {
    String content;
    boolean checked;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean getChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Todo(){
        setChecked(false);
        setContent("");
    }
    public Todo(String content){
        setChecked(false);
        setContent(content);
    }
    public Todo(String content, boolean checked){
        setContent(content);
        setChecked(checked);
    }

    public Todo(Todo x){
        setChecked(x.getChecked());
        setContent(x.getContent());
    }

    public void showContent(){
        System.out.println("The task is " + getContent());
    }

    @Override
    public void show(){
        Audit a = new Audit("showTodo");
        System.out.println("The task is " + getContent());
        if (getChecked() == false )
            System.out.println("The task is NOT finished");
        else System.out.println("The task is finished");
    }

    @Override
    public void showThread(String threadname){
        Audit a = new Audit("showTodo", threadname);
        System.out.println("The task is " + getContent());
        if (getChecked() == false )
            System.out.println("The task is NOT finished");
        else System.out.println("The task is finished");
    }

    @Override
    public void writeInfo(FileWriter w){
        try{
            w.write("The task is " + getContent());
            if (getChecked() == false )
                w.write("The task is NOT finished");
            else w.write("The task is finished");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showChecked(){
        showContent();
        if(getChecked())
            System.out.println("  That task is resolved");
        else System.out.println("   That task is not resolved");
    }
}

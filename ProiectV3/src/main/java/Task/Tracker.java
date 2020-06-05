package main.java.Task;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Tracker extends Task {
    private String objective;
    private int done;
    private int toDo;

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public void setDone(int done) {
        this.done = done;
    }

    public void setToDo(int toDo) {
        this.toDo = toDo;
    }

    public String getObjective() {
        return this.objective;
    }

    public int getDone() {
        return this.done;
    }

    public int getToDo() {
        return this.toDo;
    }


    public Tracker() {
        setObjective("unknown");
        setDone(0);
        setToDo(100);
    }

    public Tracker(String objective) {
        setObjective(objective);
        setDone(0);
        setToDo(100);
    }

    public Tracker(int done) {
        System.out.println("toDo variable willl be automatically initialized");
        setObjective("unknown");
        setDone(done);
        if (done <= 100)
            setToDo(100);
        else setToDo(done + 1);
    }

    public Tracker(String objective, int done, int toDo) {
        if (done < 0) {
            System.out.println("You can't initialize done with a negativ no, it will be set on 0");
            setDone(0);
        }
        if (toDo < 0) {
            System.out.println("You can't initialize toDo with a negativ no, it will be set on 100");
            setToDo(100);
        }
        if (done > toDo) {
            System.out.println("done > toDo => swap");
            int aux = done;
            done = toDo;
            toDo = aux;
        }
        setObjective(objective);
        setDone(done);
        setToDo(toDo);
    }

    public Tracker(Tracker t) {
        setObjective(t.getObjective());
        setDone(t.getDone());
        setToDo(t.getToDo());
    }


    @Override
    public void show() {
        Audit a = new Audit("showTracker");
        System.out.println("The objective of the tracker is " + getObjective());
        System.out.println("\tYou made  " + getDone() + " of " + getToDo());
    }


    @Override
    public void showThread(String threadName) {
        Audit a = new Audit("showTracker", threadName);
        System.out.println("The objective of the tracker is " + getObjective());
        System.out.println("\tYou made  " + getDone() + " of " + getToDo());
    }
    @Override
    public void writeInfo(FileWriter w){
        try{
            w.write("The objective of the tracker is " + getObjective());
            w.write("\tYou made  " + getDone() + " of " + getToDo());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

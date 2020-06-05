package main.java.Threads;

import main.java.Database.CRUDRemainder;
import main.java.Database.CRUDToDo;
import main.java.Task.Audit;

public class remainderReadThread  extends Thread {
    public remainderReadThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        CRUDRemainder.readAllRemainder();
        new Audit("read", remainderReadThread.super.getName());
    }
}

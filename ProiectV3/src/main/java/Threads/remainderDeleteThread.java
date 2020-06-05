package main.java.Threads;

import main.java.Database.CRUDRemainder;
import main.java.Task.Audit;

public class remainderDeleteThread  extends Thread {
    public remainderDeleteThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        CRUDRemainder.deleteAllRemainder();
        new Audit("delete", remainderDeleteThread.super.getName());
    }
}

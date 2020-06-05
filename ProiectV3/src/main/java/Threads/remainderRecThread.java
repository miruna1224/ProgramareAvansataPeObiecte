package main.java.Threads;

import main.java.Database.CRUDNote;
import main.java.Database.CRUDRemainder;
import main.java.Task.Audit;

public class remainderRecThread extends Thread {
    public remainderRecThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        CRUDRemainder.recreateDBRemainder(11);
        new Audit("recreateDB", remainderRecThread.super.getName());
    }
}
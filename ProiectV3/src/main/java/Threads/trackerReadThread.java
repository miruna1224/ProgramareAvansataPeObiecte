package main.java.Threads;

import main.java.Database.CRUDToDo;
import main.java.Database.CRUDTracker;
import main.java.Task.Audit;

public class trackerReadThread extends Thread {
    public trackerReadThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        CRUDTracker.readAllTracker();
        new Audit("read", trackerReadThread.super.getName());
    }
}
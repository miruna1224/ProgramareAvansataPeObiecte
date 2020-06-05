package main.java.Threads;

import main.java.Database.CRUDTracker;
import main.java.Task.Audit;

public class trackerDeleteThread extends Thread {
    public trackerDeleteThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        CRUDTracker.deleteAllTracker();
        new Audit("delete", trackerDeleteThread.super.getName());
    }
}
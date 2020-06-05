package main.java.Threads;

import main.java.Database.CRUDNote;
import main.java.Database.CRUDTracker;
import main.java.Task.Audit;

public class trackerRecThread  extends Thread {
    public trackerRecThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        CRUDTracker.recreateDBTracker(11);
        new Audit("recreateDB", trackerRecThread.super.getName());
    }
}
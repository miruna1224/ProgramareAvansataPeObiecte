package main.java.Threads;

import main.java.Database.CRUDNote;
import main.java.Task.Audit;

public class noteReadThread extends Thread {
    public noteReadThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        CRUDNote.readAllNote();
        new Audit("read", noteReadThread.super.getName());
    }
}

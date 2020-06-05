package main.java.Threads;

import main.java.Database.CRUDNote;
import main.java.Task.Audit;

public class noteRecThread extends Thread {
    public noteRecThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        CRUDNote.recreateDBNote(11);
        new Audit("recreateDB", noteRecThread.super.getName());
    }
}
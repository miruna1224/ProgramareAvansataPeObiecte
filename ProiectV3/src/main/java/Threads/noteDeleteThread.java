package main.java.Threads;

import main.java.Database.CRUDNote;
import main.java.Task.Audit;

public class noteDeleteThread extends Thread {
    public noteDeleteThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        CRUDNote.deleteAllNote();
        new Audit("delete", noteDeleteThread.super.getName());
    }
}
package main.java.Threads;

import main.java.Database.CRUDNote;
import main.java.Database.CRUDToDo;
import main.java.Task.Audit;

public class todoReadThread  extends Thread {
    public todoReadThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        CRUDToDo.readAllToDo();
        new Audit("read", todoReadThread.super.getName());
    }
}

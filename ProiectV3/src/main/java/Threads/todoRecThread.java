package main.java.Threads;

import main.java.Database.CRUDNote;
import main.java.Database.CRUDToDo;
import main.java.Task.Audit;

public class todoRecThread  extends Thread {
    public todoRecThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        CRUDToDo.recreateDBToDo(11);
        new Audit("recreateDB", todoRecThread.super.getName());
    }
}
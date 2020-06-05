package main.java.Threads;

import main.java.Database.CRUDToDo;
import main.java.Task.Audit;

public class todoDeleteThread extends Thread {
    public todoDeleteThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        CRUDToDo.deleteAllToDo();
        new Audit("delete", todoDeleteThread.super.getName());
    }
}

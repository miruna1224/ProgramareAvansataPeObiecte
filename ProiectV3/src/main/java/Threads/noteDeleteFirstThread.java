package main.java.Threads;

import main.java.Database.CRUDNote;
import main.java.Task.Audit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class noteDeleteFirstThread extends Thread {
    public noteDeleteFirstThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        JFrame f = new JFrame("NoteText");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("submit");
        JButton jButton1 = new JButton("close");
        JTextField  testField = new JTextField(10);
        JPanel j = new JPanel();
        j.add(testField);
        j.add(button);
        j.add(jButton1);
        f.add(j);
        f.pack();
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String content = testField.getText();
                if(!content.equals("")){
                    CRUDNote.deleteOneNote(content);
                    new Audit("deleteFirst", noteDeleteFirstThread.super.getName());
                }
            }
        });

        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                f.dispose();
            }
        });
        f.setSize(400,500);
        f.setLayout(null);
        f.setVisible(true);
    }
}

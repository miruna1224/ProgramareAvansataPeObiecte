package main.java.Threads;

import main.java.Database.CRUDRemainder;
import main.java.Task.Audit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class remainderDeleteFirstThread extends Thread {
    public remainderDeleteFirstThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        JFrame f = new JFrame("importance");
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
            public void actionPerformed(ActionEvent e){
                String content = testField.getText();
                if(!content.equals("")) {
                    CRUDRemainder.deleteOneRemainder(Integer.parseInt(content));
                    new Audit("deleteFirst", remainderDeleteFirstThread.super.getName());
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
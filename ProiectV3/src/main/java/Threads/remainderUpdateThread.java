package main.java.Threads;

import main.java.Database.CRUDRemainder;
import main.java.Task.Audit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class remainderUpdateThread extends Thread {
    public remainderUpdateThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        JFrame f = new JFrame("impToUpdate - impUpdateWith");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("submit");
        JButton jButton1 = new JButton("close");
        JTextField  testField1 = new JTextField(10);
        JTextField  testField2 = new JTextField(10);
        JPanel j = new JPanel();
        j.add(testField1);
        j.add(testField2);
        j.add(button);
        j.add(jButton1);
        f.add(j);
        f.pack();
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String content1 = testField1.getText();
                String content2 = testField2.getText();
                if(!content1.equals("") && !content2.equals("")) {
                    CRUDRemainder.updateRemainder(Integer.parseInt(content1), Integer.parseInt(content2));
                    new Audit("update", remainderUpdateThread.super.getName());
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
package main.java.Threads;

import main.java.Database.CRUDToDo;
import main.java.Task.Audit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class todoUpdateThread extends Thread {
    public todoUpdateThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        JFrame f = new JFrame("ContentToUpd - CheckedtoUp - ContentUpW - CheckedUpW");

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("submit");
        JButton jButton1 = new JButton("close");
        JTextField  testField1 = new JTextField(10);
        JTextField  testField2 = new JTextField(10);
        JTextField  testField3 = new JTextField(10);
        JTextField  testField4 = new JTextField(10);
        JPanel j = new JPanel();
        j.add(testField1);
        j.add(testField2);
        j.add(testField3);
        j.add(testField4);
        j.add(button);
        j.add(jButton1);
        f.add(j);
        f.pack();
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String content = testField1.getText();
                String content2 = testField3.getText();
                boolean bl = Boolean.parseBoolean(testField2.getText());
                boolean bl2 = Boolean.parseBoolean(testField4.getText());
                if (!testField1.equals("") && !testField2.equals("")) {
                    CRUDToDo.updateToDo(content, bl, content2, bl2);
                    new Audit("update", todoUpdateThread.super.getName());
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


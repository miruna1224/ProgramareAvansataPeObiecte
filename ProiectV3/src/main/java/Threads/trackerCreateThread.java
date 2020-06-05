package main.java.Threads;

import main.java.Database.CRUDToDo;
import main.java.Database.CRUDTracker;
import main.java.Task.Audit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class trackerCreateThread  extends Thread {
    public trackerCreateThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        JFrame f = new JFrame("TrackerContent - done - toDo");

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton button = new JButton("submit");
        JButton jButton1 = new JButton("close");
        JTextField  testField1 = new JTextField(10);
        JTextField  testField2 = new JTextField(10);
        JTextField  testField3 = new JTextField(10);
        JPanel j = new JPanel();
        j.add(testField1);
        j.add(testField2);
        j.add(testField3);
        j.add(button);
        j.add(jButton1);
        f.add(j);
        f.pack();
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                String content = testField1.getText();
                int n1 = Integer.parseInt(testField2.getText());
                int n2 = Integer.parseInt(testField3.getText());
                if (!testField1.equals("") && !testField2.equals("") && !testField3.equals("")) {
                    CRUDTracker.createTracker(content, n1, n2);
                    new Audit("create", trackerCreateThread.super.getName());
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
//        System.out.println("Write a note content: ");
//        Scanner scan = new Scanner(System.in);
//        String content = scan.nextLine();
//        int n1 = scan.nextInt();
//        int n2 = scan.nextInt();
//        CRUDTracker.createTracker(content, n1, n2);
    }
}

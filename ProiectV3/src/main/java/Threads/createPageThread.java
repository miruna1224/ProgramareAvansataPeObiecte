package main.java.Threads;

import main.java.Agenda;
import main.java.Database.CRUDNote;
import main.java.Database.CRUDRemainder;
import main.java.Database.CRUDToDo;
import main.java.Database.CRUDTracker;
import main.java.Page.Footer;
import main.java.Page.Header;
import main.java.Page.Page;
import main.java.Task.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class createPageThread extends Thread {

    public createPageThread(String name) {
        super(name);
    }

    public static void show(Page p){
        p.getHeaderClass().showHeader();
        if(p.getArchived())
            System.out.println("  This page is archived");
        else System.out.println("  This page is not archived");
        System.out.println("   " + p.getTitle());
        if(p.getNextE())
            System.out.println(" - The next page is " + p.getNext());
        else{
            if(p.getPreviousE())
                System.out.println(" - This is the only page");
            else System.out.println(" - This is the last page");
        }
        if(p.getPreviousE())
            System.out.println(" - The previous page is " + p.getPrevious());
        System.out.println(" This page contains the following tasks : \n");
        CRUDNote.readAllNote();
        CRUDToDo.readAllToDo();
        CRUDTracker.readAllTracker();
        CRUDRemainder.readAllRemainder();
        if (p.getPermissionType() == 0 )
            System.out.println("You don't have admin permission");
        else System.out.println("You have admin permission");
        System.out.println("\t- Page.Page " + p.getFooterClass().getNoPage() + " -");
    }

    @Override
    public void run(){
        JFrame f = new JFrame("Create Page");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Contact admin = new Contact("Miruna", "Floroiu", "miruna1224@yahoo.com");
        Agenda agenda = new Agenda(admin);

        int x, next = 0;
        String title = "";
        boolean archived = false, nextE = false, y;

        Footer footerClass = new Footer();
        Header headerClass = new Header();
        Page pag = new Page();

        JPanel j = new JPanel();
        JButton b = new JButton("Submit");
        JButton jButton1 = new JButton("Close");
        JLabel l;
        JTextField field;

        l = new JLabel();
        l.setText("  Introduce a title for the page : ");
        field = new JTextField(10);
        j.add(l);
        j.add(field);
        title = field.getText();

        l = new JLabel();
        l.setText("  Is the file archived? 0 - no  1 - yes");
        field = new JTextField(10);
        j.add(l);
        j.add(field);
        String aux = field.getText();
        if (aux.equals(""))
            x = 0;
        else x = Integer.parseInt(aux);

        if ( x == 1 )
            archived = true;

        l = new JLabel();
        l.setText("  Read a permission type for the page: 0 - non-admin  1 - admin");
        field = new JTextField(10);
        j.add(l);
        j.add(field);
        y = Boolean.parseBoolean(field.getText());

        Task [] t = new Note[1];
        Note n = new Note();
        t[0] = n;
        boolean [] perm = new boolean[1];
        perm[0] = y;
        pag = new Page(title, archived, footerClass, headerClass, 0, 0, false, false, t, 1, 1, perm);


        Page finalPag = pag;
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e1) {
                show(finalPag);
            }
        });
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                f.dispose();
            }
        });
        b.setBounds(130,40,140, 40);
        j.add(b);
        j.add(jButton1);
        f.add(j);
        f.setSize(400,500);
        f.setLayout(new GridLayout(1,5));
        f.setVisible(true);
    }
}

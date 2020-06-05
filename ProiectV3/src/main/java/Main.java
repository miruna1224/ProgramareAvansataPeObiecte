package main.java;

import main.java.Database.*;
import main.java.Page.*;
import main.java.ReadWrite.*;
import main.java.Task.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

import main.java.GUI.*;
import main.java.Threads.*;

public class Main {
    public static void showMenu2(){
        System.out.println("////////////////////////////////////////");
        System.out.println("///    0 - Create an Agenda          ///");
        System.out.println("///    1 - Create a page             ///");
        System.out.println("///    2 - Add a page to the agenda  ///");
        System.out.println("///    3 - Delete a page from agenda ///");
        System.out.println("///    4 - Show Agenda               ///");
        System.out.println("///    5 - Search and show a page    ///");
        System.out.println("///    6 - Exit                      ///");
        System.out.println("////////////////////////////////////////");
    }
    public static void showMenu(){
        System.out.println("//////////////////////////////////////////");
        System.out.println("///    0 - Create an Agenda            ///");
        System.out.println("///    1 - Create a page               ///");
        System.out.println("///    4 - Show Agenda                 ///");
        System.out.println("///    5 - Search and show a page      ///");
        System.out.println("///    6 - Read some tasks from file   ///");
        System.out.println("///    7 - Exit                        ///");
        System.out.println("//////////////////////////////////////////");
    }
    static public void option0(){
        System.out.println("//////////////////////////////////////////////");
        System.out.println("///   0 - Create an admin for the agenda   ///");
        System.out.println("///   1 - Mondify  info about the admin    ///");
        System.out.println("///   2 - Create the agenda                ///");
        System.out.println("///   3 - Exit                             ///");
        System.out.println("//////////////////////////////////////////////");
    }
    static public void option2(){
        System.out.println("//////////////////////////////////////////////");
        System.out.println("/// 0 - Create Tasks for the page          ///");
        System.out.println("/// 1 - Create Page.Page                        ///");
        System.out.println("/// 2 - Add page to the agenda             ///");
        System.out.println("/// 3 - Exit                             ///");
        System.out.println("//////////////////////////////////////////////");
    }
    static public void option3(){
        System.out.println("//////////////////////////////////////////////");
        System.out.println("/// 0 - Delete all pages                   ///");
        System.out.println("/// 1 - Delete Page.Page  with a specific no     ///");
        System.out.println("/// 2 - Delete a specific page              ///");
        System.out.println("/// 3 - Exit                             ///");
        System.out.println("//////////////////////////////////////////////");
    }
    static public void option5(){
        System.out.println("//////////////////////////////////////////////");
        System.out.println("/// 0 - Create Tasks for the page          ///");
        System.out.println("/// 1 - Create Page.Page                        ///");
        System.out.println("/// 2 - Search and show the page           ///");
        System.out.println("/// 3 - Exit                             ///");
        System.out.println("//////////////////////////////////////////////");
    }

    static public void contactChange(Contact admin){
        System.out.println("The current admin information is :");
        admin.showContact();
        System.out.println("What do you want to modify?");
        System.out.println(" 0 - last name");
        System.out.println(" 1 - first name");
        System.out.println(" 2 - phone number");
        System.out.println(" 3 - email address");
        System.out.println(" 4 - picture");
        System.out.println(" 5 - address");
        System.out.println(" 6 - exit");
    }

    static public int readTaskType(Scanner sc){
        System.out.println("What kind of task do you want to create? ");
        System.out.println("\t1 - Task.Note");
        System.out.println("\t2 - Task.Meeting");
        System.out.println("\t3 - Task.Remainder");
        System.out.println("\t4 - Shop list");
        System.out.println("\t5 - Task.Todo");
        System.out.println("\t6 - Task.Tracker");
        int x = sc.nextInt();
        if ( x <= 0 || x > 6){
            System.out.println(" Invalid option, retry...");
            x = sc.nextInt();
        }
        return x;
    }

    static public Page logicOption1(Scanner sc, Agenda agenda, Contact admin){
        int x;
        String title = "";
        boolean archived = false;
        Footer footerClass = new Footer();
        Header headerClass = new Header();
        Page pag = new Page();
        System.out.println("  Introduce a title for the page : ");
        sc.nextLine();
        title = sc.nextLine();
        while(title.equals("") || title.equals("\n")) {
            System.out.println( "  Introduce a valid title, retry ... ");
            title = sc.nextLine();
        }
        System.out.println("  Is the file archived? 0 - no  1 - yes");
        x = sc.nextInt();
        while ( x != 0 && x != 1 ){
            System.out.println("Invalid option, retry  ");
            x = sc.nextInt();
        }
        if ( x == 1 )
            archived = true;
        System.out.println("  In the header do you want to use current date or another date? 0 - current 1 - another");
        x = sc.nextInt();
        while ( x != 0 && x != 1 ){
            System.out.println("Invalid option, retry  ");
            x = sc.nextInt();
        }
        if ( x == 1 ){
            System.out.println("\tIntroduce a day");
            int day = sc.nextInt();
            sc.nextLine();
            System.out.println("\tIntroduce a month");
            String month = sc.nextLine();
            System.out.println("\tIntroduce a year");
            int year = sc.nextInt();
            Header newH = new Header(day, month, year);
            headerClass = newH;
        }
        System.out.println("  The footer has been created");
        int next = 0;
        boolean nextE = false;
        System.out.println("  Is there a further pege? 0 - no 1 - yes");
        x = sc.nextInt();
        while (x != 0 && x != 1)
            x = sc.nextInt();
        if(x == 1){
            nextE = true;
            System.out.println("  Introduce the number of the further page");
            next = sc.nextInt();
            while( next <= 0 || next == agenda.getNoPages()){
                System.out.println("  Invalid no of page, retry ... ");
                next = sc.nextInt();
            }
        }
        int previous = 0;
        boolean previousE = false;
        System.out.println("  Is there a previous page? 0 - no  1 - yes");
        x = sc.nextInt();
        while (x != 0 && x != 1)
            x = sc.nextInt();
        if(x == 1){
            previousE = true;
            System.out.println("  Introduce the number of the further page");
            previous = sc.nextInt();
            while( previous <= 0 || previous == agenda.getNoPages()){
                System.out.println("  Invalid no of page, retry ... ");
                previous = sc.nextInt();
            }
        }
        System.out.println("  How many tasks are in this agenda?");
        int noTasks = sc.nextInt();
        while(noTasks <= 0){
            System.out.println("  Invalid no of pages, retry ... ");
            noTasks = sc.nextInt();
        }
        boolean [] permissions;
        permissions = new boolean[noTasks + 1];
        Task[] t = new Task[noTasks];
        for(int z = 0; z < noTasks; z++ ){
            int option = readTaskType(sc);
            if(option == 1)
                t[z] = new Note();
            else{
                if(option == 2)
                    t[z] = new Meeting();
                else{
                    if(option == 3)
                        t[z] = new Remainder();
                    else{
                        if(option == 4)
                            t[z] = new Shopping();
                        else{
                            if(option == 5)
                                t[z] = new Todo();
                            else t[z] = new Tracker();
                        }
                    }
                }
            }
            System.out.println("  Read a permission type for the task: 0 - non-admin  1 - admin");
            x = sc.nextInt();
            while( x != 0 && x != 1)
                x = sc.nextInt();
            if( x == 0 )
                permissions[z] = false;
            else permissions[z] = true;
        }
        int permissionType = 0;
        System.out.println("  Read a permission type for the page: 0 - non-admin  1 - admin");
        permissionType = sc.nextInt();
        while( permissionType != 0 && permissionType != 1)
            permissionType = sc.nextInt();
        pag = new Page(title, archived, footerClass, headerClass, next, previous, nextE, previousE, t, permissionType, noTasks, permissions);
        System.out.println("The page has been created");
        return pag;
    }

    public static void mainLogic1(){
        showMenu();
        int x;
        Scanner sc = new Scanner(System.in);
        Contact admin = new Contact( "test", "test", "test@yahoo.com");
        Agenda agenda = new Agenda(admin);
        agenda.setNoPages(1);
        agenda.setPermission(1);
        Page pag = new Page();
        pag.setNoTasks(1);
        Task[] t = new Task[1];
        t[0] = new Note("note");
        pag.setT(t);
        pag.setPermissionType(1);
        boolean [] s  = pag.getPermissions();
        s[0] = true;
        pag.setPermissions(s);
        agenda.addPage(pag, 6534);
        File pic = new File();
        int optionM = sc.nextInt();
        while( optionM != 7 ){
            while(optionM < 0 || optionM > 7){
                System.out.println("This option does not exist, try again....");
                optionM = sc.nextInt();
            }
            if( optionM == 0 ){
                option0();
                int option = sc.nextInt();
                while(option < 0 || option > 3){
                    option0();
                    System.out.println("Invalid option, please try again...");
                    option = sc.nextInt();
                }
                if( option == 0 ){
                    sc.nextLine();
                    System.out.println(" Introduce the First Name :");
                    String fn = sc.nextLine();
                    System.out.println(" Introduce the Last Name :");
                    String ln = sc.nextLine();
                    String ad = "";
                    int [ ] phone = new int[10];
                    phone[0] = 0;
                    phone[1] = 7;
                    phone[3] = -1;
                    String em = "";
                    int raspuns;
                    System.out.println("Do you want to introduce an Email? 1 - yes 0 - no" );
                    raspuns = sc.nextInt();
                    while( raspuns != 0 && raspuns != 1){
                        raspuns = sc.nextInt();
                        System.out.println("Not an option, try again ... ");
                    }
                    if( raspuns == 1 ){
                        sc.nextLine();
                        em = sc.nextLine();
                    }
                    System.out.println("Do you want to introduce an phone number? 1 - yes 0 - no" );
                    raspuns = sc.nextInt();
                    while( raspuns != 0 && raspuns != 1){
                        raspuns = sc.nextInt();
                        System.out.println("Not an option, try again ... ");
                    }
                    if( raspuns == 1 ){
                        for(int z = 0; z < 10; z++ )
                            phone[z] = sc.nextInt();
                    }
                    System.out.println("Do you want to introduce an adress? 1 - yes 0 - no" );
                    raspuns = sc.nextInt();
                    while( raspuns != 0 && raspuns != 1){
                        raspuns = sc.nextInt();
                        System.out.println("Not an option, try again ... ");
                    }
                    if( raspuns == 1 ){
                        sc.nextLine();
                        ad = sc.nextLine();
                    }
                    if(em.equals("") && phone[3] == -1){
                        sc.nextLine();
                        while( em.equals("") && phone[3] == -1){
                            System.out.println("Introduce an email");
                            em = sc.nextLine();
                        }
                    }
                    System.out.println("Do you want to introduce a Task.File? 1 - yes 0 - no" );
                    raspuns = sc.nextInt();
                    while( raspuns != 0 && raspuns != 1){
                        raspuns = sc.nextInt();
                        System.out.println("Not an option, try again ... ");
                    }
                    if( raspuns == 1 ){
                        admin.setEmailA("testEmail@yahoo.com");
                        String path = "";
                        System.out.println("Do you want to introduce a path? 1 - yes 0 - no" );
                        raspuns = sc.nextInt();
                        while( raspuns != 0 && raspuns != 1){
                            raspuns = sc.nextInt();
                            System.out.println("Not an option, try again ... ");
                        }
                        if( raspuns == 1 ){
                            sc.nextLine();
                            path = sc.nextLine();
                        }
                        String extension = "";
                        System.out.println("Do you want to introduce an extension? 1 - yes 0 - no" );
                        raspuns = sc.nextInt();
                        while( raspuns != 0 && raspuns != 1){
                            raspuns = sc.nextInt();
                            System.out.println("Not an option, try again ... ");
                        }
                        if( raspuns == 1 ){
                            sc.nextLine();
                            extension = sc.nextLine();
                        }
                        String name = "";
                        System.out.println("Do you want to introduce a name? 1 - yes 0 - no" );
                        raspuns = sc.nextInt();
                        while( raspuns != 0 && raspuns != 1){
                            raspuns = sc.nextInt();
                            System.out.println("Not an option, try again ... ");
                        }
                        if( raspuns == 1 ) {
                            sc.nextLine();
                            name = sc.nextLine();
                        }
                        int permission = -1;
                        System.out.println("Do you want to introduce a permission? 1 - yes 0 - no" );
                        raspuns = sc.nextInt();
                        while( raspuns != 0 && raspuns != 1){
                            raspuns = sc.nextInt();
                            System.out.println("Not an option, try again ... ");
                        }
                        if( raspuns == 1 )
                            permission = sc.nextInt();
                        File pic2 = new File(path, extension, name, permission);
                        admin = new Contact(fn, ln, phone, em, pic2, ad);
                    }
                    else {
                        admin = new Contact(fn, ln, phone, em, pic, ad);
                        System.out.println("admin account created");
                        showMenu();
                    }
                }else{
                    if(option == 1 ){
                        contactChange(admin);
                        String lastName = "";
                        String firstName = "";
                        int phoneNo[] = new int[11];
                        String emailA = "";
                        File picure = new File();
                        String address = "";
                        x = sc.nextInt();
                        if ( x < 0 || x > 6 )
                            while ( x < 0 || x > 6 ){
                                System.out.println("Invalid option , retry ... ");
                                x = sc.nextInt();
                            }
                        else {
                            while (x >= 0 && x < 6){
                                if (x == 6)
                                    continue;
                                sc.nextLine();
                                if (x == 0) {
                                    lastName = sc.nextLine();
                                    contactChange(admin);
                                } else {
                                    if (x == 1) {
                                        firstName = sc.nextLine();
                                        contactChange(admin);
                                    } else {
                                        if (x == 2) {
                                            for (int z = 0; z < 10; z++)
                                                phoneNo[z] = sc.nextInt();
                                            contactChange(admin);
                                        } else {
                                            if (x == 3) {
                                                emailA = sc.nextLine();
                                                contactChange(admin);
                                            } else {
                                                if (x == 4) {
                                                    pic.read();
                                                    contactChange(admin);
                                                } else {
                                                    if (x == 5) {
                                                        address = sc.nextLine();
                                                        contactChange(admin);
                                                    } else continue;
                                                }
                                            }
                                        }
                                    }
                                }
                                x = sc.nextInt();
                            }
                            continue;
                        }
                    } else {
                        if(option == 2)
                            System.out.println(".");
                        else showMenu();
                    }
                }
            }
            else{
                if( optionM == 1 ){
                    pag = logicOption1(sc, agenda, admin);
                    pag.showPage();
                    showMenu();
                }
                else{
                    if(optionM == 2){
                        option2();
                    }
                    else {
                        if (optionM == 3) {
                            option3();
                        } else {
                            if (optionM == 4) {
                                System.out.println(".");
                                agenda.showAgenda();
                                showMenu();
                            } else {
                                boolean blf = false;
                                if (optionM == 5) {
                                    option5();
                                    System.out.println("What page do you want to search?");
                                    Page p1 = logicOption1(sc, agenda, admin);
                                    p1.showPage();
                                    ArrayList<Page> pages = agenda.getPages();
                                    int noPages = agenda.getNoPages();
                                    for (int z = 0; z < noPages && !blf; z++ ){
                                        if(pages.get(z).equals(p1)){
                                            System.out.println("The page was found on " + z + " position in pages' vector");
                                            p1 = pages.get(z);
                                            p1.showPage();
                                            blf = true;
                                            break;
                                        }
                                    }
                                    if(!blf)
                                        System.out.println("Page.Page not found");
                                    showMenu();
                                } else {
                                    if (optionM == 6){
                                        SingletonIn sIn = SingletonIn.getInstance();
                                        ArrayList<Task> continut = sIn.getContinut();
                                        SingletonOut.getInstance(continut);
                                        showMenu();
                                    }
                                    else {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            optionM = sc.nextInt();
        }
    }

    public static void mainLogic2(){
        MyGUIForm myGuiForm = new MyGUIForm();
    }


    public static void main(String [] args){
       mainLogic2();
    }
}

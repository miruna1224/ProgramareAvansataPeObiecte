package main.java;

import main.java.Exceptions.InvalidDataException;
import main.java.Page.Page;
import main.java.Task.Contact;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.Console;

import static java.lang.Thread.sleep;

public class Agenda {
    Contact admin;
    int permission;
    ArrayList<Page> pages;
    int noPages;

    public Contact getAdmin() {
        return admin;
    }

    public void setAdmin(Contact admin) {
        this.admin = admin;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public int getNoPages() {
        return noPages;
    }

    public void setNoPages(int noPages) {
        this.noPages = noPages;
    }

    public ArrayList<Page> getPages() {
        return pages;
    }

    public void setPages(ArrayList<Page> pages) {
        int noPages = getNoPages();
        ArrayList<Page> v = new ArrayList<>();
        for(int i = 0; i < noPages; i++ )
            v.add(pages.get(i));
        this.pages = v;
    }

    public Agenda(Contact admin){
        setAdmin(admin);
        setPermission(0);
        setNoPages(0);
        ArrayList<Page> pages = new ArrayList<>();
        setPages(pages);
    }

    public Agenda(Contact admin, int permission){
        setAdmin(admin);
        setPermission(permission);
        setNoPages(0);
        ArrayList<Page> pages = new ArrayList<>();
        setPages(pages);
    }

    public Agenda(Contact admin, int permission, int noPages, ArrayList<Page>pages){
        setAdmin(admin);
        setPermission(permission);
        setNoPages(noPages);
        setPages(pages);
    }

    public Agenda(Agenda a){
        setAdmin(a.getAdmin());
        setPermission(a.getPermission());
        setNoPages(a.getNoPages());
        setPages(a.getPages());
    }

    public void addPage( Page a ){
        if( getPermission() == 1) {
            System.out.println("Is this the first page? 1 - yes  0 - no ");
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            try {
                if (x != 0 && x != 1)
                    throw new InvalidDataException("This is not a valid answer");
                ArrayList<Page> vec = getPages();
                if (x == 1) {
                    a.setPreviousE(false);
                    a.setPrevious(-1);
                } else {
                    System.out.println("Has this page a previous one? 1 - yes 0 - no");
                    int x2 = sc.nextInt();
                    if (x2 != 0 && x2 != 1)
                        throw new InvalidDataException("This is not a valid answer");
                    if (x2 == 1) {
                        System.out.println("What is the previous page?");
                        int x3 = sc.nextInt();
                        a.setPrevious(x3);
                        a.setPreviousE(true);
                    }
                }
                vec.add(a);
                setPages(vec);
                setNoPages(getNoPages() + 1);
            } catch (InvalidDataException e) {
                System.out.println("Error");
            }
        }
        else{
            System.out.println("You don't have permission to add pages");
        }
    }

    void addPage( Page a, int b ){
        if(b == 6534){
            ArrayList<Page> vec = getPages();
            vec.add(a);
            setPages(vec);;
        }
    }

    void deletePage(Page a){
        if(getPermission() == 1) {
            ArrayList<Page> vec = getPages();
            vec.remove(a);
            setPages(vec);
            setNoPages(getNoPages() - 1);
        }
        else{
            System.out.println("You don't have permission to delete pages");
        }
    }

    void deletePage(int i){
        if(getPermission() == 1) {
            ArrayList<Page> vec = getPages();
            Page a = vec.get(i);
            vec.remove(a);
            setPages(vec);
            setNoPages(getNoPages() - 1);
        }
        else{
            System.out.println("You don't have permission to delete pages");
        }
    }

    void showPages(){
        try {
            if(getNoPages() == 0)
                throw new InvalidDataException("Nothing to show");
            Console c = System.console();
            System.out.println("The agenda's no pages is : " + getNoPages());
            ArrayList<Page> vec = getPages();
            for (int i = 0; i < getNoPages(); i++) {
                Page x = vec.get(i);
                if(x.getTitle().equals("")){
                    System.out.println("There are no valid pages in agenda");
                    return;
                }
                x.showPage();
                sleep(60);
            }
        }
        catch (InvalidDataException | InterruptedException e){
            System.out.println("Add pages in Agenda");
        }
    }

    void showAdminInfo(){
        System.out.println("The admin's information is : ");
        getAdmin().showContact();
    }

    void showAgenda(){
        showAdminInfo();
        showPages();
    }
}

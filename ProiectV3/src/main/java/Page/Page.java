package main.java.Page;

import main.java.Exceptions.InvalidDataException;
import main.java.Task.*;

public class Page {
    private String title;
    private boolean archived;
    private Footer footerClass;
    private Header headerClass;
    private int next;
    private int previous;
    private boolean nextE;
    private boolean previousE;
    private Task[] t;
    private int noTasks;
    private int permissionType;
    private boolean [] permissions;

    public String getTitle(){ return this.title;}
    public boolean getArchived(){return this.archived;}
    public Footer getFooterClass(){return this.footerClass;}
    public Header getHeaderClass(){return this.headerClass;}
    public int getNext(){return this.next;}
    public int getPrevious(){return this.previous;}
    public boolean getNextE(){return this.nextE;}
    public boolean getPreviousE(){return this.previousE;}
    public Task [] getT(){return this.t;}
    public int getNoTasks(){return this.noTasks;}
    public int getPermissionType(){return this.permissionType;}
    public boolean [] getPermissions(){return this.permissions;}



    public void setPermissionType (int x){this.permissionType = x; }
    public void setTitle( String x ){ this.title = x;}
    public void setArchived(boolean x ){ this.archived = x;}
    public void setFooterClass(Footer x){ this.footerClass = new Footer(x);}
    public void setHeaderClass(Header x){ this.headerClass = new Header(x);}
    public void setNext(int x){this.next = x;}
    public void setPrevious(int x){this.previous = x;}
    public void setNextE(boolean x){this.nextE = x;}
    public void setPreviousE(boolean x){this.previousE = x;}
    public void setNoTasks(int x){ this.noTasks = x;}
    public void setT( Task[] x){
        this.t = new Task[getNoTasks()];
        for(int i = 0; i < getNoTasks(); i++) {
            String ty = x[i].getClass().getName();
            String jl = "java.lang.";
            if (ty.equals(jl + "Task.Tracker"))
                this.t[i] = new Tracker();
            else {
                if (ty.equals(jl + "Task.Meeting"))
                    this.t[i] = new Meeting();
                else {
                    if (ty.equals(jl + "Task.Todo"))
                        this.t[i] = new Todo();
                    else {
                        if (ty.equals(jl + "Task.Shopping"))
                            this.t[i] = new Shopping();
                        else {
                            if (ty.equals(jl + "Task.Remainder"))
                                this.t[i] = new Remainder();
                            else this.t[i] = new Note();
                        }
                    }
                }
                }
            this.t[i] = x[i];
        }
    }
    public void setPermissions( boolean [] permissions ){
        this.permissions = new boolean[getNoTasks() + 1];
//        for(int i = 0; i < getNoTasks(); i++ )
//            this.permissions[i] = permissions[i];
        if (getNoTasks() >= 0) System.arraycopy(permissions, 0, this.permissions, 0, getNoTasks());
    }



    public Page (String title, boolean archived, Footer footerClass, Header headerClass, int next, int previous, boolean nextE, boolean previousE,  Task [] t, int permissionType, int noTasks, boolean [] permissions){
        try {
            if ( next < 0 || previous < 0 ||  permissionType < 0 || permissionType > 2 || noTasks < 1 )
                throw new InvalidDataException("Invalid variables' values");
            setTitle(title);
            setArchived(archived);
            setFooterClass(footerClass);
            setHeaderClass(headerClass);
            setNext(next);
            setPrevious(previous);
            setNextE(nextE);
            setPreviousE(previousE);
            setNoTasks(noTasks);
            setPermissionType(permissionType);
            setPermissions(permissions);
            setT(t);
        }
        catch (InvalidDataException e){
            System.out.println("Error");
        }
    }

    public Page (Page p){
        setTitle(p.getTitle());
        setArchived(p.getArchived());
        setFooterClass(p.getFooterClass());
        setHeaderClass(p.getHeaderClass());
        setNext(p.getNext());
        setPrevious(p.getPrevious());
        setNextE(p.getNextE());
        setPreviousE(p.getPreviousE());
        setNoTasks(p.getNoTasks());
        setPermissionType(p.getPermissionType());
        setPermissions(p.getPermissions());
        setT(p.getT());
    }

    public Page (){
        Footer f = new Footer();
        Header h = new Header();
        setTitle("New Page.Page");
        setArchived(false);
        setFooterClass(f);
        setHeaderClass(h);
        setNext(-1);
        setPrevious(-1);
        setNextE(false);
        setPreviousE(false);
        setNoTasks(0);
        setPermissionType( permissionType );
        Task [] t = new Note[1];
        t[0] = new Note();
        setT(t);
        boolean [] p;
        p = new boolean[this.noTasks + 1];
        for(int i = 0; i < this.noTasks + 1; i++ )
            p[i] = ( getPermissionType() == 0 ? false : true);
        setPermissions(p);
    }

    public void showTasks(){
        if(getPermissionType() == 1) {
            System.out.println("  Tasks : ");
            Task[] aux = getT();
            for (int i = 0; i < getNoTasks(); i++) {
                String ty = aux[i].getClass().getName();
                String jl = "java.lang.";
                if (ty.equals(jl + "Task.Tracker"))
                    aux[i].show();
                else {
                    if (ty.equals(jl + "Task.Meeting"))
                        aux[i].show();
                    else {
                        if (ty.equals(jl + "Task.Todo"))
                            aux[i].show();
                        else {
                            if (ty.equals(jl + "Task.Shopping"))
                                aux[i].show();
                            else {
                                if (ty.equals(jl + "Task.Remainder"))
                                    aux[i].show();
                                else aux[i].show();
                            }
                        }
                    }
                }
            }
        }
        else{
            System.out.println("You haven't the right to read");
        }
    }

    public void showPage(){
        headerClass.showHeader();
        if(getArchived())
            System.out.println("  This page is archived");
        else System.out.println("  This page is not archived");
        System.out.println("   " + getTitle());
        if(getNextE())
            System.out.println(" - The next page is " + getNext());
        else{
            if(getPreviousE())
                System.out.println(" - This is the only page");
            else System.out.println(" - This is the last page");
        }
        if(getPreviousE())
            System.out.println(" - The previous page is " + getPrevious());
        System.out.println(" This page contains " + getNoTasks() + " tasks");
        showTasks();
        if (getPermissionType() == 0 )
            System.out.println("You don't have admin permission");
        else System.out.println("You have admin permission");
        System.out.println("\t- Page.Page " + getFooterClass().getNoPage() + " -");
    }

    public void connect(Page p){
        Footer x = new Footer(p.getFooterClass());
        setNext(x.getNoPage());
        setNextE(true);
        Footer thisx = new Footer(getFooterClass());
        p.setPrevious(thisx.getNoPage());
        p.setPreviousE(true);
    }

    public boolean equals(Page o) {
        if (!o.getTitle().equals(getTitle()))
            return false;
        if( o.getArchived() != getArchived() )
            return false;
        if (!o.getFooterClass().equals(getFooterClass()))
            return false;
        if (!o.getHeaderClass().equals(getHeaderClass()))
            return false;
        if(o.getNextE() != getNextE() || o.getPreviousE()!=getPreviousE())
            return false;
        if(o.getNoTasks() != getNoTasks())
            return false;
        for(int i = 0; i < getNoTasks(); i++)
            if(o.getT()[i].getMaxWeight() != getT()[i].getMaxWeight() || o.getT()[i].getWeight() != getT()[i].getWeight())
                return false;
        if(o.getPermissionType() != getPermissionType())
            return false;
        return true;
    }
}

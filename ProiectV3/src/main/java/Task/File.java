package main.java.Task;

import main.java.Exceptions.InvalidDataException;

import java.util.Scanner;

public class File implements Comparable<File>{
    private String path;
    private String extension;
    private String name;
    private int permission;

    private void setExtension(String extension) {
        this.extension = extension;
    }
    private void setPath(String path) {
        this.path = path;
    }
    private void setPermission(int permission) {
        this.permission = permission;
    }
    private void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return this.extension;
    }
    public String getPath() {
        return this.path;
    }
    public int getPermission() {
        return this.permission;
    }
    public String getName(){ return this.name; }

    public File(){
        setExtension("");
        setPath("");
        setName("unknown");
        setPermission(0);
    }

    public File(String path, String extension, String name, int permission){
        try {
            setExtension(path);
            setPath(extension);
            setName(name);
            if (permission != 0 && permission != 1)
                throw new InvalidDataException(" Permission can only be 0 (non admin) or 1 (admin)");
            setPermission(permission);
        }
        catch(InvalidDataException e){
            System.out.println("Error");
        }
    }

    public File(File x){
        setExtension(x.getPath());
        setPath(x.getExtension());
        setName(x.getName());
        setPermission(x.getPermission());
    }

    public void showFile(){
        Audit a = new Audit("showFile");
        System.out.println("Fisierul " + getName());
        System.out.println("   care se gaseste" + getExtension());
        System.out.println("    care are extensia" + getExtension());
        if(getPermission() == 0)
            System.out.println("You have the non-admin permission ");
        System.out.println("You have admin permission");
    }

    public void modify( String path, String extension, String name){
        if(getPermission() == 1) {
            System.out.println("You have admin permission");
            setPath(path);
            setName(name);
            setExtension(extension);
        }
        else System.out.println("You don't have admin permission ");
    }

    @Override
    public int compareTo (File a){
        if (this.getName().compareTo(a.getName()) == 0){
            if (this.getPermission() < a.getPermission())
                return 1;
            else{
                if (this.getPermission() > a.getPermission())
                    return -1;
                else return 0;
            }
        }
        else{
            if (this.getName().compareTo(a.getName()) < 0)
                return -1;
            else return 1;
        }
    }

    public void read (){
        Scanner sc = new Scanner(System.in);
        String path = sc.nextLine();
        String extension = sc.nextLine();
        String name = sc.nextLine();
        int permission = sc.nextInt();
        File f = new File(path, extension, name, permission);
        setExtension(f.getExtension());
        setName(f.getName());
        setPath(f.getPath());
        setPermission(f.getPermission());
    }

}

package main.java.Task;

import main.java.Exceptions.InvalidDataException;

import java.util.Scanner;

public class Contact implements Comparable<Contact>{
    String firstName;
    String lastName;
    int phoneNo[];
    String emailA;
    File picure;
    String address;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNo(int[] phoneNo) {
        this.phoneNo = new int[10];
        for(int i = 0; i < 10; i++)
            this.phoneNo[i] = phoneNo[i];
    }

    public void setEmailA(String emailA) {
        this.emailA = emailA;
    }

    public void setPicure(File picure) {
        this.picure = picure;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int[] getPhoneNo() {
        return phoneNo;
    }

    public String getEmailA() {
        return emailA;
    }

    public File getPicure() {
        return picure;
    }

    public String getAddress() {
        return address;
    }
    public Contact( String firstName, String lastName, int phoneNo[]){
        try {
            setAddress("unknown");
            setEmailA("unknown");
            File f = new File();
            setPicure(f);
            setFirstName(firstName);
            setLastName(lastName);
            if( phoneNo.length != 10 || phoneNo[0] != 0 || phoneNo[1] != 7)
                throw new InvalidDataException("Phone number invalid");
            else setPhoneNo(phoneNo);
        }
        catch(InvalidDataException e){
            System.out.println("Error");
        }
    }

    public Contact( String firstName, String lastName, String emailA){
        setAddress("unknown");
        File f = new File();
        setPicure(f);
        setFirstName(firstName);
        setLastName(lastName);
        int aux[] = new int[10];
        aux[0] = -1;
        setPhoneNo(aux);
        try {
            if (!emailA.contains("@") || (!emailA.contains(".com") && !emailA.contains(".ro")))
                throw new InvalidDataException("Email address invalid");
            else setEmailA(emailA);
        }
        catch(InvalidDataException e){
            System.out.println("Error");
        }
    }

    public Contact( String firstName, String lastName, int phoneNo[], String emailA, File picture, String address){
        try {
            setAddress(address);
            if (!emailA.contains("@") || (!emailA.contains(".com") && !emailA.contains(".ro")))
                throw new InvalidDataException("Email address invalid");
            else setEmailA(emailA);
            setFirstName(firstName);
            setLastName(lastName);
            if( phoneNo.length != 10 || phoneNo[0] != 0 || phoneNo[1] != 7)
                throw new InvalidDataException("Phone number invalid");
            else setPhoneNo(phoneNo);
            setPicure(picture);
        }
        catch(InvalidDataException e){
            System.out.println("Error");
        }
    }


    public Contact( Contact c){
        setAddress(c.getAddress());
        setEmailA(c.getEmailA());
        setFirstName(c.getFirstName());
        setLastName(c.getLastName());
        setPhoneNo(c.getPhoneNo());
        setPicure(c.getPicure());
    }

    public void showContact(){
        Audit a = new Audit("showContact");
        System.out.println( getFirstName() + " " + getLastName() + " " );
        if(getPhoneNo()[0] == 0 ) {
            System.out.println("    who has the phone no : " + getPhoneNo());
            if(getEmailA().equals("unknown"))
                System.out.println("   and do not have an email address given");
            else  System.out.println("   and  have an email address given : " + getEmailA());
        }
        else System.out.println("    who has the email address : " + getEmailA() + " and dows not have an phone number specified");
    }

    public void modifyElement(){
        try {
            System.out.println("What element do you want to modify?");
            System.out.println("\t 0 - First name");
            System.out.println("\t 1 - Last name");
            System.out.println("\t 2 - Phone Number");
            System.out.println("\t 3 - Email address");
            System.out.println("\t 4 - Picture");
            System.out.println("\t 5 - Address");
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            if (x < 0 || x > 5)
                throw new InvalidDataException("Invalid option");
            if (x == 0 ) {
                String newN = sc.nextLine();
                setFirstName(newN);
                System.out.println("The updated name is " + newN);
            }
            else{
                if (x == 1 ) {
                    String newN = sc.nextLine();
                    setLastName(newN);
                    System.out.println("The updated name is " + newN);
                }
                else{
                    if (x == 2 ) {
                        int v[] = new int[10];
                        for(int i = 0; i < 10; i++)
                            v[i] = sc.nextInt();
                        if( v[0] != 0 || v[1] != 7)
                            throw new InvalidDataException("Phone number invalid");
                        setPhoneNo(v);
                        System.out.println("The updated phone no is " + getPhoneNo());
                    }
                    else{
                        if (x == 3 ) {
                            String newE= sc.nextLine();
                            setEmailA(newE);
                            if (!emailA.contains("@") || (!emailA.contains(".com") && !emailA.contains(".ro")))
                                throw new InvalidDataException("Email address invalid");
                            System.out.println("The updated email address is " + newE);
                        }
                        else {
                            if (x == 5) {
                                String newE = sc.nextLine();
                                setAddress(newE);
                                System.out.println("The updated address is " + newE);
                            } else {
                                File f = new File();
                                f.read();
                                setPicure(f);
                                System.out.println("The updated image has next details : ");
                                f.showFile();
                            }
                        }
                    }
                }
            }
        }
        catch(InvalidDataException e){
            System.out.println("Error");
        }
    }

    @Override
    public int compareTo (Contact a){
        if (this.getFirstName().compareTo(a.getFirstName()) == 0){
            if (this.getLastName().compareTo(a.getLastName()) < 0)
                return 1;
            else{
                if (this.getLastName().compareTo(a.getLastName()) > 0)
                    return -1;
                else return 0;
            }
        }
        else{
            if (this.getFirstName().compareTo(a.getFirstName()) < 0)
                return -1;
            else return 1;
        }
    }
}

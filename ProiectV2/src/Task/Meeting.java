package Task;

import Exceptions.InvalidDataException;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Meeting extends Task {
    Vector<Contact> participants;
    int noP;
    int hour;
    int minute;
    boolean pm;
    int day;
    String month;
    String location;
    static final String [] vmonths = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    static final int [] vdays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


    public Vector<Contact> getParticipants() {
        return participants;
    }

    public void setParticipants(Vector<Contact> participants) {
        int dim = getNoP();
        if (dim != participants.size())
            dim = participants.size();
        this.participants = new Vector<>();
        for (Contact c : participants) this.participants.add(c);
    }

    public int getNoP() {
        return noP;
    }

    public void setNoP(int noP) {
        this.noP = noP;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public boolean getPm() {
        return pm;
    }

    public void setPm(boolean pm) {
        this.pm = pm;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Meeting(){
        Vector<Contact> p = new Vector<>();
        setParticipants(p);
        setNoP (0);
        setHour(0);
        setMinute(0);
        setDay(0);
        setMonth("unknown");
        setPm(false);
        setLocation("unknown");
    }

    public Meeting(Meeting m){
        setParticipants(m.getParticipants());
        setNoP(m.getNoP());
        setHour(m.getHour());
        setMinute(m.getMinute());
        setDay(m.getDay());
        setMonth(m.getMonth());
        setPm(m.getPm());
        setLocation(m.getLocation());
    }

    public Meeting(int hour, int minute, boolean pm, int day, String month ){
        try {
            Vector<Contact> p = new Vector<>();
            setParticipants(p);
            setNoP(0);
            if (hour >= 0 && hour <= 23)
                setHour(hour);
            else throw new InvalidDataException("Invalid hour!");
            if(minute >= 0 && minute < 60)
                setMinute(minute);
            else throw new InvalidDataException("Invalid minute!");
            setPm(pm);
            setLocation("unknown");

            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
            int tday = calendar.get(Calendar.DATE);
            int tmonth = calendar.get(Calendar.MONTH);
            int tyear = calendar.get(Calendar.YEAR);
            int j = -1;
            for (int i = 0; i < 12; i++)
                if (vmonths[i].equals(month)) {
                    j = i;
                    break;
                }
            if (j == -1) {
                throw new InvalidDataException("The month you want to use does not exist!");
            }
            else setMonth(month);
            int add_day = 0;
            if (tyear % 100 == 0 && tyear % 400 != 0 && getMonth().equals(vmonths[1]))
                add_day = 1;
            day += add_day;
            if (day > 0 && day <= vdays[j])
                setDay(day);
            else {
                throw new InvalidDataException( "The day you want yo use is either negative, either does not exist in the given month!");
            }
        }
        catch(InvalidDataException e){
            System.out.println("Error");
        }
    }

    public Meeting(int hour, int minute, boolean pm, int day, String month, int noP, Vector<Contact> participants){
        try {
            setParticipants(participants);
            setNoP(noP);
            if (hour >= 0 && hour <= 23)
                setHour(hour);
            else throw new InvalidDataException("Invalid hour!");
            if(minute >= 0 && minute < 60)
                setMinute(minute);
            else throw new InvalidDataException("Invalid minute!");
            setPm(pm);
            setLocation("unknown");

            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
            int tday = calendar.get(Calendar.DATE);
            int tmonth = calendar.get(Calendar.MONTH);
            int tyear = calendar.get(Calendar.YEAR);
            int j = -1;
            for (int i = 0; i < 12; i++)
                if (vmonths[i].equals(month)) {
                    j = i;
                    break;
                }
            if (j == -1) {
                throw new InvalidDataException("The month you want to use does not exist!");
            }
            else setMonth(month);
            int add_day = 0;
            if (tyear % 100 == 0 && tyear % 400 != 0 && getMonth().equals(vmonths[1]))
                add_day = 1;
            day += add_day;
            if (day > 0 && day <= vdays[j])
                setDay(day);
            else {
                throw new InvalidDataException( "The day you want yo use is either negative, either does not exist in the given month!");
            }
        }
        catch(InvalidDataException e){
            System.out.println("Error");
        }
    }

    public Meeting(int hour, int minute, boolean pm, int day, String month, int noP, Vector<Contact> participants, String location){
        try {
            setParticipants(participants);
            setNoP(noP);
            setLocation(location);
            if (hour >= 0 && hour <= 23)
                setHour(hour);
            else throw new InvalidDataException("Invalid hour!");
            if(minute >= 0 && minute < 60)
                setMinute(minute);
            else throw new InvalidDataException("Invalid minute!");
            setPm(pm);
            setLocation("unknown");

            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
            int tday = calendar.get(Calendar.DATE);
            int tmonth = calendar.get(Calendar.MONTH);
            int tyear = calendar.get(Calendar.YEAR);
            int j = -1;
            for (int i = 0; i < 12; i++)
                if (vmonths[i].equals(month)) {
                    j = i;
                    break;
                }
            if (j == -1) {
                throw new InvalidDataException("The month you want to use does not exist!");
            }
            else setMonth(month);
            int add_day = 0;
            if (tyear % 100 == 0 && tyear % 400 != 0 && getMonth().equals(vmonths[1]))
                add_day = 1;
            day += add_day;
            if (day > 0 && day <= vdays[j])
                setDay(day);
            else {
                throw new InvalidDataException( "The day you want yo use is either negative, either does not exist in the given month!");
            }
        }
        catch(InvalidDataException e){
            System.out.println("Error");
        }
    }

    public void showParticipants(){
        System.out.println( " There are " + getNoP() + " participants :");
        for (Contact c : getParticipants() )
            c.showContact();
    }

    public void showMeeting(){
        Audit a = new Audit("showMeeting");
        String location;
        System.out.println( "Task.Meeting details:");
        if(getPm() == true)
            System.out.println("  - starts at: " + getHour() + " : " + getMinute() + " PM");
        else System.out.println("  - starts at: " + getHour() + " : " + getMinute() + " AM");
        System.out.println("  - the date is day: " + getDay() + " month: " + getMonth());
        if(!getLocation().equals("unknown"))
             System.out.println("  - the location is: " + getLocation());
        showParticipants();
    }
    @Override
    public void show(){
        showMeeting();
    }


    @Override
    public void writeInfo(FileWriter w){
        try{
            String location;
            w.write( "Task.Meeting details:");
            if(getPm() == true)
                 w.write("  - starts at: " + getHour() + " : " + getMinute() + " PM");
            else  w.write("  - starts at: " + getHour() + " : " + getMinute() + " AM");
            w.write("  - the date is day: " + getDay() + " month: " + getMonth());
            if(!getLocation().equals("unknown"))
                w.write("  - the location is: " + getLocation());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortParticipants(){
        Vector<Contact> c = getParticipants();
        Collections.sort(c);
        setParticipants(c);
    }

    public void addContact(Contact c){
        Vector<Contact> aux = getParticipants();
        aux.add(c);
        if (getParticipants().size() != getNoP())
            setNoP(getNoP() + 1);
    }

    public void deleteContact(Contact c){
        Vector<Contact> aux = getParticipants();
        aux.remove(c);
        if (getParticipants().size() != getNoP())
            setNoP(getNoP() - 1);
    }

    public void deleteContact(int i){
        try {
            if(getNoP() <= i)
                throw new InvalidDataException("Limits out of bound");
            Vector<Contact> aux = getParticipants();
            Contact c = aux.get(i);
            aux.remove(c);
            setNoP(getNoP() - 1);
        }
        catch(InvalidDataException e){
            System.out.println("Error");
        }
    }
}

package ReadWrite;

import Exceptions.*;
import Task.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class SingletonIn {
    private static SingletonIn instance = null;
    private ArrayList<Task> continut;

    public boolean cifra(char ch){
        if (ch != '0' && ch != '1' && ch != '2' && ch != '3' && ch != '4' && ch != '5' && ch != '6' && ch != '7' && ch != '8' && ch != '9')
            return false;
        return true;
    }

    private SingletonIn(){
        String csvFile2 = "tipDate.csv";
        String csvFile = "date.csv";
        continut = new ArrayList<>();
        BufferedReader bufferR = null;
        BufferedReader bufferR2 = null;
        try{
            bufferR = new BufferedReader(new FileReader(csvFile));
            bufferR2 = new BufferedReader(new FileReader(csvFile2));
            String line = bufferR.readLine();
            String tip = bufferR2.readLine();
            while (line != null && tip != null){
                String [] dates = line.split(",");
                String [] dates2 = tip.split(",");
                String type = dates2[0].toLowerCase();
                if (type.equals("task.note")){
                    String tt = "";
                    Note s = new Note(dates[0]);
                    continut.add(s);
                }
                else{
                    if (type.equals("task.tracker")){
                        try{
                            if (dates.length < 2 )
                                throw new InexNoException("Task.Tracker must have 3 parameters");
                            String obiectiv =  dates[0];
                            boolean verif = true;
                            for (int i = 0; i < dates[1].length(); i++) {
                                char ch = dates[1].charAt(i);
                                if (cifra(ch) == false){
                                    verif = false;
                                    break;
                                }
                            }
                            for (int i = 0; i < dates[2].length(); i++) {
                                char ch = dates[2].charAt(i);
                                if (cifra(ch) == false){
                                    verif = false;
                                    break;
                                }
                            }
                            if (verif == false)
                                throw new InvalidDataException("Task.Tracker must have diffrent parameters");
                            int done = Integer.parseInt(dates[1]);
                            int toDo = Integer.parseInt(dates[2]);
                            Tracker s = new Tracker(obiectiv, done, toDo);
                            continut.add(s);
                        }
                        catch(InvalidDataException e){
                            System.out.println("Invalid types of datas");
                        }
                        catch(InexNoException e){
                            System.out.println("Invalid number of parameters");
                        }
                    }
                    else{
                        if (type.equals("task.meeting")){
                            try{
                                boolean verif = true;
                                if (dates.length != 5)
                                    throw new InexNoException("Too many or too fewer arguments");
                                for (int i = 0; i < dates[1].length(); i++) {
                                    char ch = dates[1].charAt(i);
                                    if (cifra(ch) == false){
                                        verif = false;
                                        break;
                                    }
                                }
                                for (int i = 0; i < dates[0].length(); i++) {
                                    char ch = dates[0].charAt(i);
                                    if (cifra(ch) == false){
                                        verif = false;
                                        break;
                                    }
                                }
                                for (int i = 0; i < dates[3].length(); i++) {
                                    char ch = dates[3].charAt(i);
                                    if (cifra(ch) == false){
                                        verif = false;
                                        break;
                                    }
                                }
                                if (verif == false)
                                    throw new InvalidDataException("Task.Tracker must have diffrent parameters");
                                int hour = Integer.parseInt(dates[0]);
                                int min = Integer.parseInt(dates[1]);
                                boolean pm = Boolean.parseBoolean(dates[2]);
                                int day = Integer.parseInt(dates[3]);
                                String month = dates[4];
                                Meeting s = new Meeting(hour, min, pm, day, month);
                                continut.add(s);
                            } catch (InexNoException e) {
                                e.printStackTrace();
                                System.out.println("Invalid no of datas");
                            } catch (InvalidDataException e) {
                                System.out.println("Invalid type of datas");
                                e.printStackTrace();
                            }
                        }
                        else{
                            if (type.equals("task.todo")){
                                try{
                                    if (!dates[1].equals("true") && !dates[1].equals("false") && !dates[1].equals("1") && !dates[1].equals("0") && !dates[1].equals("True") && !dates[1].equals("False")  ){
                                        throw new InvalidDataException("Not a boolean variable");
                                    }
                                    boolean ch = Boolean.parseBoolean(dates[1]);
                                    Todo s = new Todo(dates[0], ch);
                                    continut.add(s);
                                } catch (InvalidDataException e) {
                                    System.out.println("Invalid type of datas");
                                }
                            }
                            else{
                                if (type.equals("task.remainder")){
                                    try{
                                        boolean verif = true;
                                        for (int i = 0; i < dates[0].length(); i++) {
                                            char ch = dates[0].charAt(i);
                                            if ((int)ch < (int)'0' || (int)ch > (int)'9') {
                                                verif = false;
                                                break;
                                            }
                                        }
                                        if (verif == false)
                                            throw new InvalidDataException("Task.Tracker must have diffrent parameters");
                                        int no = Integer.parseInt(dates[0]);
                                        Remainder s = new Remainder(no);
                                        continut.add(s);
                                    } catch (InvalidDataException e) {
                                        System.out.println("Invalid type of datas");
                                    }
                                }
                                else {
                                    System.out.println("Tasks can't have the type " + type);
                                    java.lang.System.exit(0);
                                }
                            }
                        }
                    }
                }
                line = bufferR.readLine();
                tip = bufferR2.readLine();
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        } finally{
            if (bufferR != null ){
                try{
                    bufferR.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static SingletonIn getInstance()
    {
        if (instance == null)
            instance = new SingletonIn();
        return instance;
    }

    public ArrayList<Task> getContinut() {
        return continut;
    }
}



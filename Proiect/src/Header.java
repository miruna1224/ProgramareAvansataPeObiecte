import java.util.Calendar;
import java.util.TimeZone;
import java.util.Scanner;

public class Header {
    private int day;
    private String month;
    private int year;
    static final String [] vmonths = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    static final int [] vdays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    void setDay(int x){
        this.day = x;
    }
    void setMonth(String x){
        this.month = x;
    }
    void setYear(int x){
        this.year = x;
    }

    int getDay(){
        return this.day;
    }
    String getMonth(){
        return this.month;
    }
    int getYear(){
        return this.year;
    }

    Header(){
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        int day = calendar.get(Calendar.DATE);
        int month = calendar.get(Calendar.MONTH) ;
        int year = calendar.get(Calendar.YEAR);
        setDay(day);
        setMonth(vmonths[month]);
        setYear(year);
    }

    Header( int day, String month, int year){
        try {
            String s = "";
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
                setMonth(vmonths[tmonth]);
                j = tmonth;
                s = "The month you want to use does not exist!";
            } else setMonth(month);
            int add_day = 0;
            if (year >= 1900 && year < tyear)
                setYear(year);
            else {
                setYear(tyear);
                s = "The year you want to use is lower tham 1900 or higher tang yhis year!";
            }
            if (getYear() % 100 == 0 && getYear() % 400 != 0 && getMonth().equals(vmonths[1]))
                add_day = 1;
            day += add_day;
            if (day > 0 && day < vdays[j])
                setDay(day);
            else {
                setDay(tday);
                s = "The day you want yo use is either negative, either does not exist in the given month!";
            }
            if( !s.equals("") ){
                throw new InvalidDataException(s);
            }
        }
        catch (InvalidDataException e){
            System.out.println("The variables which caused error will pe initialized with current date");
        }
    }

    Header( int day, String month){
        try {
            String s = "";
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
                setMonth(vmonths[tmonth]);
                s = "The month you want to use does not exist!";
            } else setMonth(month);
            int add_day = 0;
            setYear(tyear);
            if (getYear() % 100 == 0 && getYear() % 400 != 0 && getMonth().equals(vmonths[1]))
                add_day = 1;
            day += add_day;
            if (day > 0 && day <= vdays[j]) {
                setDay(day);
                s = "The day you want yo use is either negative, either does not exist in the given month! ";
            }
            else setDay(tday);

            if( !s.equals("") ){
                throw new InvalidDataException(s);
            }
        }
        catch(InvalidDataException e){
            System.out.println("The variables which caused error will pe initialized with current date");
        }
    }


    Header( int day ){
        try {
            String s = "";
            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
            int tday = calendar.get(Calendar.DATE);
            int tmonth = calendar.get(Calendar.MONTH);
            setYear(calendar.get(Calendar.YEAR));
            setMonth(vmonths[tmonth]);
            int add_day = 0;
            if (getYear() % 100 == 0 && getYear() % 400 != 0 && getMonth().equals(vmonths[1]))
                add_day = 1;
            int j = -1;
            for (int i = 0; i < 12; i++)
                if (vmonths[i].equals(getMonth())) {
                    j = i;
                    break;
                }
            if (j == -1)
                s = "The month you want to use does not exist!";
            day += add_day;
            if (day > 0 && day <= vdays[j])
                setDay(day);
            else {
                setDay(tday);
                s = "The day you want yo use is either negative, either does not exist in the given month!";
            }

            if( !s.equals("") ){
                throw new InvalidDataException(s);
            }
        }
        catch(InvalidDataException e){
            System.out.println("The variables which caused error will pe initialized with current date");
        }
    }


    Header( String month ){
        try {
            String s = "";
            Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
            int tday = calendar.get(Calendar.DATE);
            int tmonth = calendar.get(Calendar.MONTH);
            setYear(calendar.get(Calendar.YEAR));
            int j = -1;
            for (int i = 0; i < 12; i++)
                if (vmonths[i].equals(month)) {
                    j = i;
                    break;
                }
            if (j == -1) {
                setMonth(vmonths[tmonth]);
                j = tmonth;
                s = "The month you want to use does not exist!";
            } else setMonth(month);
            if (tday > vdays[j])
                setDay(vdays[j]);
            else {
                setDay(tday);
                s = "The day you want yo use is either negative, either does not exist in the given month!";
            }
            if( !s.equals("") ){
                throw new InvalidDataException(s);
            }
        }
        catch(InvalidDataException e){
            System.out.println("The variables which caused error will pe initialized with current date");
        }
    }

    Header( Header x){
        setDay(x.getDay());
        setMonth(x.getMonth());
        setYear(x.getYear());
    }

    void showHeader(){
        try {
            System.out.println("Choose a format to print the date : ");
            System.out.println("\t 1 - DD/MMMM/YYYY  0 - MMMM/DD/YYYY");
            System.out.println("\tThe date in this header is : ");
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            if (x == 0)
                System.out.println("\t" + getDay() + "." + getMonth() + "." + getYear());
            else {
                if (x == 1)
                    System.out.println("\t" + getMonth() + "." + getDay() + "." + getYear());
                else throw new InexNoException();
            }
        }
        catch (InexNoException e){
            System.out.println("Error");
        }
    }

    public boolean equals(Header o) {
        if(getDay() != o.getDay())
            return false;
        if(getYear() != o.getYear())
            return false;
        if(!getMonth().equals(o.getMonth()))
            return false;
        return true;
    }
}

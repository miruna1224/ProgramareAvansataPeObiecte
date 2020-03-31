import java.util.*;

public class main {
    public static void main( String[] args) {
        ArrayList<Album> a = new ArrayList<>();
        int [] r = new int [16];

        for (int i = 0; i < 15; i++)
            r[i] = getRandomNumberInRange(0, 100);

        int i = 0;
        a.add( new Album("Lonesome Crow" , 1972, r[i]));
        i++;
        a.add(  new Album("Unbreakable",  2004, r[i]));
        i++;
        a.add(  new Album("Lonesome Crow" , 1972, r[i]));
        i++;
        a.add( new Album("In Trance", 1975, r[i]));
        i++;
        a.add( new Album("In Trance", 1975, r[i]));
        i++;
        a.add( new Album("Taken by Force", 1977, r[i]));
        i++;
        a.add(  new Album("Lovedrive", 1979, r[i]));
        i++;
        a.add(  new Album("Blackout", 1982, r[i]));
        i++;
        a.add(  new Album("Blackout", 1982, r[i]));
        i++;
        a.add(  new Album("Love at First Sting", 1984, r[i]));
        i++;
        a.add(  new Album("Savage Amusement", 1988, r[i]));
        i++;
        a.add(  new Album("Crazy World", 1990, r[i]));
        i++;
        a.add(  new Album("Face the Heat", 1993, r[i]));
        i++;
        a.add(  new Album("Pure Instinct", 1996, r[i]));
        i++;
        a.add(  new Album("Eye II Eye", 1999, r[i]));
        i++;

        System.out.println( "NESORTAT : ");
        for ( Album x : a )
            System.out.println('\t' + x.getNume() + "- " + x.getAnPublicatie() + "- " + x.getRating());

        Collections.sort(a );

        System.out.println( "SORTAT : ");
        for ( Album x : a )
            System.out.println('\t' + x.getNume() + "- " + x.getAnPublicatie() + "- " + x.getRating());
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }


//    public static void main( String[] args){
//        RandomTask t0;
//        t0 = new RandomTask(0);
//        RandomTask t1;
//        t1 = new RandomTask(1);
//        RandomTask t2;
//        t2 = new RandomTask(2);
//
//        System.out.println( "Task 0: ");
//        t0.execute();
//        System.out.println( "Task 1: ");
//        t1.execute();
//        System.out.println( "Task 2: ");
//        t2.execute();
//
//        CounterOutTask t3;
//        t3 = new CounterOutTask();
//        CounterOutTask t4;
//        t4 = new CounterOutTask();
//    }

}



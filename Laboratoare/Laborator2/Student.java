package laborator2;

import java.util.*;
import java.lang.*;

public class Student
{
   private String nume;
   private int nota;
   
   public String getNume(){
       return this.nume;
   }
   public int getNota(){
       return this.nota;
   }
   
    public void setNume( String x ){
       this.nume = x;
   }
   public void setNota( int x ){
       this.nota = x;
   }
   
   public void afis(){
    System.out.println(this.nume);
    System.out.println(this.nota);
   }
   
   public static void main (String [] args){
       Scanner sc = new Scanner(System.in);
       String line = sc.nextLine();
       String list[] = new String [5];
       list = line.split(" ");
       int n = Integer.parseInt (list[0]);
       Student vec[] = new Student[n + 1];
       for (int i = 0, j = 1; i < n; i++, j+=2 ){
           String a = list[j];
           System.out.println(list[j]);
           System.out.println( " - ");
           System.out.println(list[j + 1]);
           System.out.println( "\n");
           int b = Integer.parseInt(list[j + 1]);
           vec[i] = new Student();
           vec[i].setNota(b);
           vec[i].setNume(a);
        }
       for (int i = 0; i < n; i++) {
           vec[i].afis();
        }
   }
}

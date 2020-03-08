package laborator2;

import java.util.*;

public class ex3{
    private float punctajObtinut;
    private float punctaj;
    private int dificultate;
    private String enunt;
    
    public float getPunctaj(){
        return this.punctaj;
    }
    public float getPunctajObtinut(){
        return this.punctajObtinut;
    }
    public int getDificultate(){
        return this.dificultate;
    }
    public String getEnunt(){
        return this.enunt;
    }
    
    
    public void setPunctaj(float x){
        this.punctaj = x;
    }
    public void setPunctajObtinut(float x){
        this.punctajObtinut = x;
    }
    public void setDificultate(int x){
        this.dificultate = x;
    }
    public void setEnunt(String x){
        this.enunt = x;
    }
    
    
    public void afisare(){
        System.out.println(this.punctaj);
        System.out.println(this.punctajObtinut);
        System.out.println(this.enunt);
        System.out.println(this.dificultate);
    }
    public static void main( String [] args ){
        ex3 exercitiu = new ex3();
        exercitiu.setPunctaj((float)5.55);
        exercitiu.setEnunt("Calculati media geometrica a numerelor: 1, 2, 3");
        exercitiu.setPunctajObtinut((float)2.45);
        exercitiu.setDificultate(2);
        exercitiu.afisare();
    }
}

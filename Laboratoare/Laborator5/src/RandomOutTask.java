import java.util.*;

public class RandomOutTask implements Task {
    private double randomNr;

    void setRandomNr (double randomNr){
        this.randomNr = randomNr;
    }

    double getRandomNr (){
        return this.randomNr;
    }

    RandomOutTask( ){
        System.out.println("Din clasa RandomOutTask");
        setRandomNr(Math.random());
    }

    @Override
    public void execute() {System.out.println(getRandomNr());}
}

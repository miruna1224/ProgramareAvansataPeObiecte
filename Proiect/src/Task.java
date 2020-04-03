import java.util.Scanner;

public abstract class Task {
    private int weight;
    private int maxWeight;

    void showWeight(){
        System.out.println("Task weight is " + this.weight + " from " + this.maxWeight);
    }

    void setWeight(int weight){this.weight = weight;}
    void setMaxWeight( int maxWeight ){this.weight = maxWeight;}

    int getWeight(){return weight;}
    int getMaxWeight(){return maxWeight;}

    Task(){
        setWeight(0);
        setMaxWeight(100);
    }
    Task(int weight, int maxWeight){
        try {
            if (weight < 0 || maxWeight < 0)
                throw new InvalidDataException("Illegal weight < 0 ");
            if (weight > maxWeight) {
                int aux = weight;
                weight = maxWeight;
                maxWeight = aux;
            }
            setWeight(weight);
            setMaxWeight(maxWeight);
        }
        catch (InvalidDataException e){
            System.out.println("Error");
        }
    }
    Task(int weight){
        try {
            setWeight(weight);
            setMaxWeight(weight);
            if (weight < 0)
                throw new InvalidDataException("Illegal weight < 0 ");
        }
        catch (InvalidDataException e){
            System.out.println("Error");
        }
    }
    Task(Task x){
        setWeight(x.getWeight());
        setMaxWeight(x.getMaxWeight());
    }

    void show(){
        System.out.println(getWeight());
        System.out.println(getMaxWeight());
    }

}

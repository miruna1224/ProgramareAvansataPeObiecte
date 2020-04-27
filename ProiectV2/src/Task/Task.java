package Task;

import Exceptions.InvalidDataException;

import java.io.FileWriter;

public abstract class Task {
    private int weight;
    private int maxWeight;

    public void showWeight(){
        System.out.println("Task.Task weight is " + this.weight + " from " + this.maxWeight);
    }

    public void setWeight(int weight){this.weight = weight;}
    public void setMaxWeight( int maxWeight ){this.weight = maxWeight;}

    public int getWeight(){return weight;}
    public int getMaxWeight(){return maxWeight;}

    public Task(){
        setWeight(0);
        setMaxWeight(100);
    }
    public Task(int weight, int maxWeight){
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
    public Task(int weight){
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
    public Task(Task x){
        setWeight(x.getWeight());
        setMaxWeight(x.getMaxWeight());
    }

    public void show(){
        Audit a = new Audit("showTask");
        System.out.println(getWeight());
        System.out.println(getMaxWeight());
    }

    public abstract void writeInfo(FileWriter w);
}

public class CounterOutTask implements Task{
    private static int var = 0;

    int getVar (){
        return (this.var);
    }

    CounterOutTask(){
        this.var += 1;
        System.out.println(getVar());
        System.out.println("Din clasa CounterOutTask");
    }

    @Override
    public void execute() { System.out.println(getVar()); }
}

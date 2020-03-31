public class RandomTask implements Task {
    private int nr = 0;

    int getNr (){
        return this.nr;
    }

    void setNr(int nr){
        if ( nr >= 0 && nr < 3 )
            this.nr = nr;
        else this.nr = 0;
    }

    RandomTask( int nr){
        System.out.println("Din clasa RandomTask");
        setNr(nr);
    }

    @Override
    public void execute(){
        if(getNr() == 0) {
            OutTask o = new OutTask();
            o.execute();
        }
        else{
            if (getNr() == 1) {
                RandomOutTask o = new RandomOutTask();
                o.execute();
            }
            else{
                CounterOutTask o = new CounterOutTask();
            }
        }
    }
}

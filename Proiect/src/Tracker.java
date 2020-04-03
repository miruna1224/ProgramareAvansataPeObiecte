public class Tracker extends Task {
    private String objective;
    private int done;
    private int toDo;

    void setObjective(String objective) {
        this.objective = objective;
    }

    void setDone(int done) {
        this.done = done;
    }

    void setToDo(int toDo) {
        this.toDo = toDo;
    }

    String getObjective() {
        return this.objective;
    }

    int getDone() {
        return this.done;
    }

    int getToDo() {
        return this.toDo;
    }


    Tracker() {
        setObjective("unknown");
        setDone(0);
        setToDo(100);
    }

    Tracker(String objective) {
        setObjective(objective);
        setDone(0);
        setToDo(100);
    }

    Tracker(int done) {
        System.out.println("toDo variable willl be automatically initialized");
        setObjective("unknown");
        setDone(done);
        if (done <= 100)
            setToDo(100);
        else setToDo(done + 1);
    }

    Tracker(String objective, int done, int toDo) {
        if (done < 0) {
            System.out.println("You can't initialize done with a negativ no, it will be set on 0");
            setDone(0);
        }
        if (toDo < 0) {
            System.out.println("You can't initialize toDo with a negativ no, it will be set on 100");
            setToDo(100);
        }
        if (done > toDo) {
            System.out.println("done > toDo => swap");
            int aux = done;
            done = toDo;
            toDo = aux;
        }
        setObjective(objective);
        setDone(done);
        setToDo(toDo);
    }

    Tracker(Tracker t) {
        setObjective(t.getObjective());
        setDone(t.getDone());
        setToDo(t.getToDo());
    }


    @Override
    void show() {
        System.out.println("The objective ofthe tracker is " + getObjective());
        System.out.println("The objective ofthe tracker is " + getDone());
        System.out.println("The objective ofthe tracker is " + getToDo());
    }

}

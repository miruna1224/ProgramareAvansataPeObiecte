public class Remainder extends Note {
    int imp;

    public int getImp() {
        return imp;
    }

    public void setImp(int imp) {
        this.imp = imp;
    }

    Remainder(){
        super("unknown");
        setImp(0);
    }

    Remainder(int imp){
        try {
            if( imp < 0 || imp > 100)
                throw new InvalidDataException("Invalid importance rate");
        }
        catch(InvalidDataException e){
            System.out.println("Error");
        }
    }

    Remainder (Remainder r){
        super(r.getNoteText());
        setImp(r.getImp());
    }

    @Override
    void show(){
        System.out.println("The note text is :");
        System.out.println(getNoteText());
        System.out.println("The importance rate of the remainder is " + getImp());
    }
}

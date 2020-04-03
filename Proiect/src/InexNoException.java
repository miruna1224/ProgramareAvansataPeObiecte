public class InexNoException extends Throwable {
    ///// Error class
    private String s;
    void setS (String s){
        this.s = s;
    }
    String getS (){
        return this.s;
    }

    InexNoException(){
        super("Inexistent No Exception Error: ");
    }
    InexNoException( String s ){
        System.out.println("Inexistent No Exception Error: ");
        setS(s);
        System.out.println("\t" + getS());
    }
    InexNoException( InexNoException E){
        System.out.println( "Inexistent No Exception Error: ");
        setS(E.s);
        System.out.println("\t" + getS());
    }
}


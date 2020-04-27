package Exceptions;

public class InexStException extends Throwable {
    ///// Error class
    private String s;
    void setS (String s){
        this.s = s;
    }
    String getS (){
        return this.s;
    }

    public InexStException(){
        super("Inexistent String Exception Error: ");
    }
    InexStException( String s ){
        System.out.println("Inexistent String Exception Error: ");
        setS(s);
        System.out.println("\t" + getS());
    }
    public InexStException( InexStException E){
        System.out.println( "Inexistent String Exception Error: ");
        setS(E.s);
        System.out.println("\t" + getS());
    }
}

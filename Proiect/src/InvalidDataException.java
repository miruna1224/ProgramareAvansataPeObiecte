public class InvalidDataException extends Throwable {
    ///// Error class
    private String s;
    void setS (String s){
        this.s = s;
    }
    String getS (){
        return this.s;
    }
    InvalidDataException(){
        super("Invalid Data Exception Error: ");
    }
    InvalidDataException( String s ){
        System.out.println( "Invalid Data Exception Error: ");
        setS(s);
        System.out.println("\t" + getS());
    }
    InvalidDataException( InvalidDataException E){
        System.out.println( "Invalid Data Exception Error: ");
        setS(E.s);
        System.out.println("\t" + getS());
    }
}

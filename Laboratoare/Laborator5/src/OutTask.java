public class OutTask implements Task {
    private String mesaj = "Mesaj aleator din clasa OutTask" ;

    void setMesaj ( String mesaj ){
        this.mesaj = mesaj;
    }

    String getMesaj (){
        return this.mesaj;
    }


    OutTask( ){
        setMesaj ("Mesaj aleator din clasa OutTask" );
    }
    OutTask( String mesaj ){
        setMesaj (mesaj);
    }

    @Override
    public void execute() { System.out.println (getMesaj()); }
}

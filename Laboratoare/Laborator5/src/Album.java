public class Album implements Comparable<Album>{
    private String nume = "";
    private int anPublicatie = 0;
    private int rating = 0;

    void setNume(String nume){ this.nume = nume;}
    void setAnPublicatie(int anPublicatie){ this.anPublicatie = anPublicatie;}
    void setRating(int rating){ this.rating = rating;}

    String getNume(){ return this.nume;}
    int getAnPublicatie(){ return anPublicatie;}
    int getRating(){ return rating;}

    Album ( String a, int b, int c){
        setNume(a);
        setAnPublicatie(b);
        setRating(c);
    }
    Album (int b, int c){
        setAnPublicatie(b);
        setRating(c);
    }
    Album ( String a){setNume(a); }

    @Override
    public int compareTo (Album a){
        if (this.getNume().compareTo(a.getNume()) == 0){
            if (this.getRating() < a.getRating())
                return 1;
            else{
                if (this.getRating() > a.getRating())
                    return -1;
                else return 0;
            }
        }
        else{
            if (this.getNume().compareTo(a.getNume()) < 0)
                return -1;
            else return 1;
        }
    }
}

import java.util.ArrayList;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.*;

public class Shopping extends Task {
    private String content;
    private ArrayList<Product> prod;
    private int noProd;

    public void setContent(String content) {
        this.content = content;
    }
    public void setProd(ArrayList<Product> prod) {
        this.prod = new ArrayList<>();
        int dim = prod.size();
        for (Product product : prod) this.prod.add(product);
    }
    public void setNoProd(int noProd) {
        this.noProd = noProd;
    }


    public String getContent() {
        return this.content;
    }
    public ArrayList<Product> getProd() {
        return this.prod;
    }
    public int getNoProd() {
        return noProd;
    }


    public Shopping() {
        ArrayList<Product> f = new ArrayList<>();
        setProd(f);
        setContent("unknown");
        setNoProd(0);
    }
    public Shopping(ArrayList<Product> prod, String content, int noProd) {
        setProd(prod);
        setContent(content);
        setNoProd(noProd);
    }

    public Shopping(ArrayList<Product> prod, int noProd) {
        setProd(prod);
        setContent("unknown");
        setNoProd(noProd);
    }

    public Shopping(Shopping s) {
        setContent(s.getContent());
        setNoProd(s.getNoProd());
        setProd(s.getProd());
    }

    @Override
    void show(){
        System.out.println("The list " + getContent() + " has " + getNoProd() + " elements");
        System.out.println("  The list is : ");
        for( Product p : getProd()){ p.showProduct();}
    }

    void sortProducts(int i){
        try{
            if(i != 1 && i != -1)
                throw new InvalidDataException("Order cand be eithrt 1 (incresing) or -1 (non-increasing)");
            ArrayList<Product> vec = getProd();
            Collections.sort(vec);
            setProd(vec);
            System.out.println("The list is now : ");
            show();
        }catch (InvalidDataException e){
            System.out.println("Error");
        }
    }

    void modifyElement( Product p, int i ){
        try {
            int j = 0;
            i --;
            if( i >= getNoProd())
                throw new ArrayIndexOutOfBoundsException ();
            while ( j < i )
                i++;
            ArrayList<Product> vec = getProd();
            vec.set(i, p);
            setProd(vec);
        }
        catch( ArrayIndexOutOfBoundsException  e){
            System.out.println("Error");
        }
    }
    void addProduct(Product x){
        ArrayList<Product> a = getProd();
        a.add(x);
        setProd(a);
        int b = getNoProd();
        b++;
        setNoProd(b);
    }
    void deleteProduct(int i){
        ArrayList<Product> a = getProd();
        Product x = a.get(i);
        a.remove(x);
        setProd(a);
        int b = getNoProd();
        b--;
        setNoProd(b);
    }

    void deleteProduct(Product x){
        ArrayList<Product> a = getProd();
        a.remove(x);
        setProd(a);
        int b = getNoProd();
        b--;
        setNoProd(b);
    }

    void appendContent(String contin){
        String content = getContent() + " " + contin;
        setContent(content);
    }

    void totalPrice(){
        double total = 0;
        ArrayList<Product> products = getProd();
        for(int i = 0; i < getNoProd(); i++ ){
            Product p = products.get(i);
            total += p.getPrice();
        }
        System.out.println("Total price for this shopping list is " + total );
    }
}

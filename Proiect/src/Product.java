import java.util.Scanner;

public class Product implements Comparable<Product>{
    private String name;
    private double price;
    private String distributer;
    private File picture;

    public void setName(String name) {
        this.name = name;
    }

    public void setDistributer(String distributer) {
        this.distributer = distributer;
    }

    public void setPicture(File picture) {
        this.picture = picture;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public File getPicture() {
        return picture;
    }

    public String getDistributer() {
        return distributer;
    }

    public String getName() {
        return name;
    }
    Product(String name, double price, String distributer, File picture){
        try {
            if (price < 0)
                throw new InvalidDataException("The price can't be negative");
            setDistributer(distributer);
            setName(name);
            setPicture(picture);
            setPrice(price);
        }
        catch (InvalidDataException e){
            System.out.println("Error");
        }
    }
    Product(String name, double price){
        try {
            if (price < 0)
                throw new InvalidDataException("The price can't be negative");
            setDistributer("unknown");
            setName(name);
            File unknown = new File();
            setPicture(unknown);
            setPrice(price);
        }
        catch (InvalidDataException e){
            System.out.println("Error");
        }
    }
    Product(Product p){
        try {
            if (p.price < 0)
                throw new InvalidDataException("The price can't be negative");
            setDistributer(p.getDistributer());
            setName(p.getName());
            setPicture(p.getPicture());
            setPrice(p.getPrice());
        }
        catch (InvalidDataException e){
            System.out.println("Error");
        }
    }

    void showProduct(){
        System.out.println("   The product " + getName() +  " costs " + getPrice());
        System.out.println(" You can find details about how it looks here : " + getPicture());
        System.out.println(" The product is distributed by " + getDistributer());
    }

    void modify (){
        try {
            System.out.println("Details about the products : ");
            showProduct();
            System.out.println("What do you want to change?");
            System.out.println("0 - name");
            System.out.println("1 - price");
            System.out.println("2 - distributer");
            System.out.println("3 - file");
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            if ( x < 0 || x > 3 )
                throw new InvalidDataException("This option doesn't exist");
            else{
                if (x == 0){
                    String newN = sc.nextLine();
                    setName(newN);
                    System.out.println("The name was updated to " + newN);
                }
                else{
                    if( x == 1){
                        try {
                            double newP = sc.nextDouble();
                            if(newP <= 0 )
                                throw new InvalidDataException("The price can't be 0 or lower");
                            setPrice(newP);
                            System.out.println("The price was updated to " + newP);
                        }
                        catch(InvalidDataException e){
                            System.out.println("Error");
                        }
                    }
                    else{
                        if (x == 2){
                            String newD = sc.nextLine();
                            setDistributer(newD);
                            System.out.println("The name was updated to " + newD);
                        }
                        else{
                            this.picture.read();
                        }
                    }
                }
            }
        }
        catch(InvalidDataException e){
            System.out.println("Error");
        }
    }

    @Override
    public int compareTo (Product a){
        if (this.getName().compareTo(a.getName()) == 0){
            if (this.getPrice() < a.getPrice())
                return 1;
            else{
                if (this.getPrice() > a.getPrice())
                    return -1;
                else return 0;
            }
        }
        else{
            if (this.getName().compareTo(a.getName()) < 0)
                return -1;
            else return 1;
        }
    }
}

package Page;

public class Footer {
    private static int noPage = 0;

    public int getNoPage(){return this.noPage;}
    private void setNoPage() {this.noPage += 1;}

    public Footer(){
        setNoPage();
    }

    public Footer(Footer x){
        setNoPage();
//        System.out.println( "Page.Page no can't be changed");
    }

    public Footer(int x){
        setNoPage();
//        System.out.println( "Page.Page no can't be changed");
    }

    public void showFooter(){
        System.out.println("Current page no is : " + getNoPage());
    }
}

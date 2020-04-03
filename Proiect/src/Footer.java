public class Footer {
    private static int noPage = 0;

    int getNoPage(){return this.noPage;}
    private void setNoPage() {this.noPage += 1;}

    Footer(){
        setNoPage();
    }

    Footer(Footer x){
        setNoPage();
//        System.out.println( "Page no can't be changed");
    }

    Footer(int x){
        setNoPage();
//        System.out.println( "Page no can't be changed");
    }

    void showFooter(){
        System.out.println("Current page no is : " + getNoPage());
    }
}

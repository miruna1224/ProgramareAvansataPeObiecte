import java.util.*;
import java.lang.Math;

public class temaex3 {
    public static void main(String args[]) {
        Scanner sc = new Scanner (System.in);
        int l = sc.nextInt();
        int c = sc.nextInt();
        int img[][] = new int [l + 1][c + 1];
        int nr1 = 0;
        for (int i = 0; i < l; i++ )
            for (int j = 0; j < c; j++ ){
                img[i][j] = sc.nextInt();
                int x = img[i][j];
                if ( x < 2 || (x !=2 && x % 2 == 0))
                    img[i][j] = 1;
                else{
                    if (x < 6)
                        img[i][j] = 0;
                    else{
                        for (int z = 3; z <= Math.sqrt(img[i][j]); z += 2)
                            if (img[i][j] % z == 0){
                                img[i][j] = 1;
                                break;
                            }
                        if (img[i][j] != 0 )
                            img[i][j] = 0;
                    }
                }
            }
        for ( int i = 0; i < l; i++ ){
            for (int j = 0; j < c; j++) {
                System.out.print(img[i][j]);
                System.out.print("   ");
            }
            System.out.print('\n');
        }
    }
}

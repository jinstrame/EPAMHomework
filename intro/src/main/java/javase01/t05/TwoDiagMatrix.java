package javase01.t05;

/**
 * Created by Eugene on 04.09.2016.
 */
public class TwoDiagMatrix {
    public static int[][] generate(int n){
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++){
            a[i][i] = 1;
            a[i][n - i - 1] = 1;
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        return a;
    }
}

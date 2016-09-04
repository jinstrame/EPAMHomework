package javase01.t05;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Eugene on 04.09.2016.
 */
public class TwoDiagMatrixTest {
    @Test
    public void generate() throws Exception {
        int n = 6;
        int[][] a = TwoDiagMatrix.generate(n);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i == j || i == n - j - 1) assertEquals(a[i][j], 1);
                else assertEquals(a[i][j], 0);
            }
        }

    }

}
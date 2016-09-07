package javase01.t05;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TwoDiagMatrixTest {
    @Test
    public void generate() throws Exception {
        int n = 6;
        int[][] a = TwoDiagMatrix.generate(n);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (i == j || i == n - j - 1) assertThat(a[i][j], is(1));
                else assertThat(a[i][j], is(0));
            }
        }
    }
}
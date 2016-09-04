package javase01.t03;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Eugene on 04.09.2016.
 */
public class FunctionTest {
    @Test
    public void f() throws Exception {
        double x = 25.0;
        double fx = Function.f(x);
        assertEquals(-3.2719007, fx, 0.0000001);
    }

    @Test
    public void fRange() throws Exception {
        double[] fx = {-3.2719007, -3.0655762, -2.8646652, -2.6524197, -2.4079984,
                        -2.0969139, -1.6464092, -0.8551933, 1.15323429, 24.5522255,
                        -9.0532723};
        assertArrayEquals(fx, Function.fRange(25.0, 26.0, 0.1), 0.0000001);
    }

}
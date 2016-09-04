package javase01.t02;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Eugene on 04.09.2016.
 */
public class LessThenEpsilonTest {
    @Test
    public void method() throws Exception {
        int i1 = 2;
        double epsilon1 = 0.15;
        assertEquals(i1, LessThenEpsilon.method(epsilon1));

        int i2 = 7;
        double epsilon2 = 0.02;
        assertEquals(i2, LessThenEpsilon.method(epsilon2));
    }
}
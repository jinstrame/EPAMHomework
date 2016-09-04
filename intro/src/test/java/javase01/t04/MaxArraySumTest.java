package javase01.t04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Eugene on 04.09.2016.
 */
public class MaxArraySumTest {
    @Test
    public void maxFromSides() throws Exception {
        double[] a = {15.26, 85.11, 32.009, 6.15, 50.5, 17.18};
        double[] a2 = {15.26, 85.11, 32.009, 6.15, 50.5, 17.18, 1000.123456};
        double max = a[1] + a[4];
        assertEquals(max, MaxArraySum.maxFromSides(a), 0.0000001);
        assertEquals(max, MaxArraySum.maxFromSides(a2), 0.0000001);
    }

}
package javase01.t04;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxArraySumTest {
    @Test
    public void maxFromSides() throws Exception {
        double[] a = {15.26, 85.11, 32.009, 6.15, 50.5, 17.18};
        double[] a2 = {15.26, 85.11, 32.009, 6.15, 50.5, 17.18, 1000.123456};
        double max = a[1] + a[4];
        assertThat(max - MaxArraySum.maxFromSides(a) < 0.0000001, is(true));
        assertThat(max - MaxArraySum.maxFromSides(a2) < 0.0000001,is(true));
    }
}
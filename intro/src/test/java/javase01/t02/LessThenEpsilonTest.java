package javase01.t02;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LessThenEpsilonTest {
    @Test
    public void method() throws Exception {
        int i = 7;
        int res = LessThenEpsilon.method(0.02);
        assertThat(res, is(i));
    }
}
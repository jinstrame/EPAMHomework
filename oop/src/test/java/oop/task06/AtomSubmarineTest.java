package oop.task06;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AtomSubmarineTest {
    @Test
    public void CheckEngineTest(){
        AtomSubmarine submarine = new AtomSubmarine();

        submarine.go(5);
        assertTrue(submarine.engine.isRunning());
        assertThat(submarine.getSpeed(), is(5));

        submarine.stop();
        assertTrue(submarine.engine.isRunning());
        assertThat(submarine.getSpeed(), is(0));

        submarine.go(10);
        submarine.shutdown();
        assertFalse(submarine.engine.isRunning());
        assertThat(submarine.getSpeed(), is(0));
    }

}
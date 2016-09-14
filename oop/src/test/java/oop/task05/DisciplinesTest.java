package oop.task05;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class DisciplinesTest {
    @Test
    public void RealValueTest(){
        assertTrue(Disciplines.ALGORYTMS_AND_DATA_STRUCTURES.isReal());
        assertTrue(Disciplines.C_PLUS_PLUS.isReal());

        assertFalse(Disciplines.ENGLISH.isReal());
        assertFalse(Disciplines.JAVA_FUNDAMENTALS.isReal());
    }
}
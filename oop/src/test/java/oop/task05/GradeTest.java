package oop.task05;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class GradeTest {
    @Test
    public void GradeValueTest(){
        Grade<Double> doubleGrade = new Grade<>(65.6);
        Grade<Integer> integerGrade = new Grade<>(50);

        assertThat(doubleGrade.toString(), equalTo("65.6"));
        assertThat(integerGrade.toString(), equalTo("50"));
    }

}
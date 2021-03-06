package oop.task05;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class DisciplineGroupTest {
    @Test
    public void ValuesTest() {
        DisciplineGroup<Integer> group1 = new DisciplineGroup<>(Disciplines.JAVA_FUNDAMENTALS);
        DisciplineGroup<Double> group2 = new DisciplineGroup<>(Disciplines.C_PLUS_PLUS);

        group1.addValue("student1", 5);
        group1.addValue("student2", 4);

        group2.addValue("student1", 60.50);
        group2.addValue("student3", 12.75);

        assertThat(group1.getValue("student1"), is(5));
        assertThat(group2.getValue("student3"), is(12.75));

        assertThat(null, is(group1.getValue("student3")));
        assertThat(null, is(group2.getValue("student2")));
    }
}
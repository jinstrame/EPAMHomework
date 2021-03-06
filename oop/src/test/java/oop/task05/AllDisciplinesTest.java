package oop.task05;

import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class AllDisciplinesTest {
    @Test
    public void AllGradesTest(){
        DisciplineGroup<Number> group1 = new DisciplineGroup<>(Disciplines.JAVA_FUNDAMENTALS);
        DisciplineGroup<Number> group2 = new DisciplineGroup<>(Disciplines.C_PLUS_PLUS);

        group1.addValue("student1", 5);
        group1.addValue("student2", 4);

        group2.addValue("student1", 60.50);
        group2.addValue("student3", 12.75);

        AllDisciplines allDisciplines = new AllDisciplines();
        allDisciplines.addGroup(group1);
        allDisciplines.addGroup(group2);

        String s1 = allDisciplines.allStudentGradesOut("student1");
        String s2 = "JAVA_FUNDAMENTALS -- 5\n" +
                "C_PLUS_PLUS -- 60.5\n";
        assertThat(s1, equalTo(s2));

        String s3 = allDisciplines.allStudentGradesOut("student2");
        String s4 = "JAVA_FUNDAMENTALS -- 4\n";
        assertThat(s3, equalTo(s4));

        String s5 = allDisciplines.allStudentGradesOut("student3");
        String s6 = "C_PLUS_PLUS -- 12.75\n";
        assertThat(s5, equalTo(s6));
    }

}
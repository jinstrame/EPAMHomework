package oop.task02;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class EmployeeToolsTest {

    @Test
    public void EmploeeCoastTest(){
        EmployeeTools employeeTools1 = new EmployeeTools("employee1");
        EmployeeTools employeeTools2 = new EmployeeTools("employee2");

        employeeTools1.add(new OfficeTool(345, "pen"));
        employeeTools1.add(new OfficeTool(15, "erase stick"));
        employeeTools1.add(new OfficeTool(670, "notebook"));

        employeeTools2.add(new OfficeTool(15, "notebook"));
        employeeTools2.add(new OfficeTool(40, "glue"));
        employeeTools2.add(new OfficeTool(1000, "staple"));

        assertThat(employeeTools1.getTotalPrice(), is(1030));
        assertThat(employeeTools2.getTotalPrice(), is(1055));




    }
}
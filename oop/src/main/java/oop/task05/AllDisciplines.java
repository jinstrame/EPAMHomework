package oop.task05;

import java.util.LinkedList;


@SuppressWarnings("WeakerAccess")
public class AllDisciplines {
    private LinkedList<DisciplineGroup> disciplineGroups;

    public AllDisciplines(){
        disciplineGroups = new LinkedList<>();
    }

    public void addGroup(DisciplineGroup disciplineGroup){
        for(DisciplineGroup group : disciplineGroups){
            if (group.getDiscipline() == disciplineGroup.getDiscipline())
                return;
        }
        disciplineGroups.add(disciplineGroup);
    }

    public String allStudentGradesOut(String name){
        System.out.println("Student grades: " + name);
        StringBuilder stringBuilder = new StringBuilder("");
        for (DisciplineGroup group: disciplineGroups){
            Number value = group.getValue(name);
            if (Double.isNaN(value.doubleValue()) || value.intValue() == Integer.MIN_VALUE)
                continue;

            stringBuilder.append(group.getDiscipline().name()).append(" -- ").append(value.toString()).append("\n");
        }
        String ret = stringBuilder.toString();
        System.out.println(ret);
        return ret;
    }
}

package oop.task05;


import lombok.Getter;

import java.util.HashMap;


@SuppressWarnings("WeakerAccess")
public class DisciplineGroup<T extends Number> {

    @Getter
    private final Disciplines discipline;

    private HashMap<String, T> studentValuePairs;

    public DisciplineGroup(Disciplines discipline){
        this.discipline = discipline;
        studentValuePairs = new HashMap<>();
    }

    public T getValue(String name){
        return studentValuePairs.get(name);
    }

    public void addValue(String name, T value){
        studentValuePairs.put(name, value);
    }

}

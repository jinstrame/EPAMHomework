package oop.task05;


import lombok.Getter;

import java.util.HashMap;


@SuppressWarnings("WeakerAccess")
public class DisciplineGroup {

    @Getter
    private final Disciplines discipline;

    private HashMap<String, Grade<Double>> doubleValues;
    private HashMap<String, Grade<Integer>> integerValues;

    public DisciplineGroup(Disciplines discipline){
        this.discipline = discipline;
        doubleValues = new HashMap<>();
        integerValues = new HashMap<>();
    }

    public Number getValue(String name){
        if (discipline.isReal())
            return doubleValues.containsKey(name)? doubleValues.get(name).getValue() : Double.NaN;

        if (!discipline.isReal())
            return integerValues.containsKey(name)? integerValues.get(name).getValue() : Integer.MIN_VALUE;

        return 0;
    }

    public void addDoubleValue(String name, Double value){
        if (!discipline.isReal())
            throw new RuntimeException("Grade value type must be \"Integer\"");
        doubleValues.put(name, new Grade<>(value));
    }

    public void addIntegerValue(String name, Integer value){
        if (discipline.isReal())
            throw new RuntimeException("Grade value type must be \"Double\"");
        integerValues.put(name, new Grade<>(value));
    }

    public void addValue (String name, Number value){
        if (discipline.isReal() && value instanceof Double) {
            addDoubleValue(name, (Double) value);
            return;
        }
        if (!(discipline.isReal()) && value instanceof Integer) {
            addIntegerValue(name, (Integer) value);
            return;
        }
        throw new RuntimeException("Grade type exception at addValue method");
    }



}

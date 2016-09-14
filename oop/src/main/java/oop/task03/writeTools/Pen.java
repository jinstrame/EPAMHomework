package oop.task03.writeTools;

import lombok.Getter;

@SuppressWarnings("unused")
public class Pen extends WriteTool {
    public enum Types {BALL, GEL, FOUNTAIN}

    @Getter
    private final Types type;

    public Pen(Types type, double width, String color, int price, String name){
        super(width, color, price, name);
        this.type = type;
    }

    public Pen(Types type, double width, String color, int price){
        this(type, width, color, price, color + "Pen");
    }
}

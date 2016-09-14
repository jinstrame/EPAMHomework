package oop.task03.writeTools;


import lombok.Getter;
import oop.task02.OfficeTool;

class WriteTool extends OfficeTool {

    @Getter
    protected double width;

    @Getter
    protected String color;

    @SuppressWarnings("WeakerAccess")
    public WriteTool(double width, String color, int price, String name){
        super(price, name);
        this.width = width;
        this.color = color;
    }

}

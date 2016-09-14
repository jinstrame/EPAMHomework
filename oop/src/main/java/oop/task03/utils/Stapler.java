package oop.task03.utils;


import lombok.Getter;
import oop.task02.OfficeTool;

@SuppressWarnings("unused")
public class Stapler extends OfficeTool {

    @Getter
    private double stapleSize;

    public Stapler(double stapleSize, int price, String name){
        super(price, name);
        this.stapleSize = stapleSize;
    }

    public Stapler(double stapleSize, int price){
        this(stapleSize, price, "Stapler");
    }

}

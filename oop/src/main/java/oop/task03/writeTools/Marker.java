package oop.task03.writeTools;

import lombok.Getter;

@SuppressWarnings("unused")
public class Marker extends WriteTool{
    @Getter
    private boolean permanent;

    @Getter
    private boolean transparent;

    public Marker(boolean isPermanent,boolean isTransparent, double width, String color, int price, String name ){
        super(width, color, price, name);
        permanent = isPermanent;
        transparent = isTransparent;
    }

    public Marker(boolean isPermanent, boolean isTransparent, double width, String color, int price){
        this(isPermanent, isTransparent, width, color, price, color + "Marker");
    }
}

package oop.task03.erraseTools;

import lombok.Getter;
import oop.task02.OfficeTool;

@SuppressWarnings({"WeakerAccess", "unused"})
public class ErraseStick extends OfficeTool{

    public enum Types {SOFT, MEDIUM, HARD}
    public enum Shapes {TRIANGLE, RECTANGLE, CIRCLE, CUSTOM}


    @Getter
    private final Types type;

    @Getter
    private final Shapes shape;

    public ErraseStick(Types type, Shapes shape, int price, String name){
        super(price, name);

        this.type = type;
        this.shape = shape;
    }

    public ErraseStick(Types type, Shapes shape, int price){
        this(type, shape, price, "ErraseStick");
    }


}

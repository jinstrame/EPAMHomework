package oop.task03.erraseTools;

import lombok.Getter;
import oop.task02.OfficeTool;

@SuppressWarnings("unused")
public class WhiteCorrector extends OfficeTool {
    public enum Types {PEN, BRUSH, TAPE}

    @Getter
    private final Types type;

    public WhiteCorrector(Types type, int price, String name){
        super(price, name);
        this.type = type;
    }

    public WhiteCorrector(Types type, int price){
        this(type, price, "WhiteCorrector");
    }

}

package oop.task02;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OfficeTool implements Comparable {
    protected int price;
    protected String name;

    //part of task04
    //sort by price
    @Override
    public int compareTo(Object o) {
        OfficeTool other = (OfficeTool)o;
        return this.price - other.getPrice();
    }
}

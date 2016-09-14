package oop.task04;

import oop.task02.OfficeTool;

import java.util.Comparator;


@SuppressWarnings("WeakerAccess")
public class PriceNameComparator implements Comparator<OfficeTool> {
    @Override
    public int compare(OfficeTool o1, OfficeTool o2) {
        if (o1.getName().compareTo(o2.getName()) == 0)
            return o1.compareTo(o2);
        else return o1.getName().compareTo(o2.getName());
    }
}

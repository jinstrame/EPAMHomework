package oop.task04;

import oop.task02.OfficeTool;

import java.util.Comparator;


@SuppressWarnings("WeakerAccess")
public class NameComparator implements Comparator<OfficeTool> {
    @Override
    public int compare(OfficeTool o1, OfficeTool o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

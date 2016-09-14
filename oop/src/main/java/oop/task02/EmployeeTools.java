package oop.task02;


import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;



@SuppressWarnings({"WeakerAccess", "unused"})
@EqualsAndHashCode
public class EmployeeTools {

    @Getter
    private String name;

    private ArrayList<OfficeTool> officeTools;

    public EmployeeTools(String name){
        officeTools = new ArrayList<>();
        this.name = name;
    }

    public Iterator<OfficeTool> iterator(){
        return officeTools.iterator();
    }

    public void add(OfficeTool officeTool){
        officeTools.add(officeTool);
    }

    public OfficeTool remove(int index){
        return officeTools.remove(index);
    }

    public int getTotalPrice(){
        int sum = 0;
        for (OfficeTool officeTool : officeTools)
            sum += officeTool.getPrice();

        return sum;
    }


}

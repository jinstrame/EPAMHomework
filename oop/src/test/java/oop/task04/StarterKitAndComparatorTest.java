package oop.task04;

import oop.task02.OfficeTool;
import oop.task03.StarterKit;
import oop.task03.writeTools.Pen;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class StarterKitAndComparatorTest {
    @Test
    public void StarterKitTest(){
        StarterKit starterKit = StarterKit.getKit();
        assertThat(starterKit.getBluePen().getColor(), is("Blue"));
        assertThat(starterKit.getCollection().size(), is(5));
    }


    @Test
    public void PriceSortTest(){
        Collection<OfficeTool> toolsCollection = StarterKit.getKit().getCollection();
        OfficeTool[] starterTools = new OfficeTool[toolsCollection.size()];
        toolsCollection.toArray(starterTools);
        Arrays.sort(starterTools);

        assertThat(starterTools[0].getName(), equalTo("StarterBluePen"));
        assertThat(starterTools[4].getName(), equalTo("StarterStapler"));
    }

    @Test
    public void NameSortTest(){
        ArrayList<OfficeTool> starterTools = StarterKit.getKit().getCollection();
        starterTools.sort(new NameComparator());

        assertThat(starterTools.get(0).getName(), equalTo("StarterBluePen"));
        assertThat(starterTools.get(4).getName(), equalTo("StarterYellowMarker"));
    }

    @Test
    public void NamePriceSortTest(){
        ArrayList<OfficeTool> starterTools = StarterKit.getKit().getCollection();
        Pen pen = new Pen(Pen.Types.BALL, 0.7, "Blue", 15, "StarterBluePen");
        starterTools.add(pen);
        starterTools.sort(new PriceNameComparator());

        assertThat(starterTools.get(0).getName(), equalTo(starterTools.get(1).getName()));
        assertThat(starterTools.get(0).getPrice(), is(15));
        assertThat(starterTools.get(1).getPrice(), is(50));
    }

}
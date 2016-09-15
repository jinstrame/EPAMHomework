package strings.task01;

import org.junit.Test;

import java.util.Iterator;

public class CrazyLoggerTest {
    @Test
    public void logTest() {
        CrazyLogger.log("message1");
        CrazyLogger.log("message to message");
        Iterator<String> i = CrazyLogger.search("message\\w");
        while (i.hasNext())
            System.out.println(i.next());
    }
}
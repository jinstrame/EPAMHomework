package strings.task01;

import org.junit.Test;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class CrazyLoggerTest {
    @Test
    public void logTest() {
        CrazyLogger.log("message1");
        CrazyLogger.log("message to message");
        Iterator<String> i = CrazyLogger.search("message\\w");

        String s = i.next();
        Pattern p = Pattern.compile("([0-9]{2}\\-){2}[0-9]{4} : [0-9]{2}\\-[0-9]{2} \\- .*");
        Matcher m = p.matcher(s);

        assertTrue(m.find());
        assertThat(m.end() - m.start(), is(s.length()));
    }
}
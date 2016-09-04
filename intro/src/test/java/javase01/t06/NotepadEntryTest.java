package javase01.t06;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Eugene on 04.09.2016.
 */
public class NotepadEntryTest {
    NotepadEntry e1;
    NotepadEntry e2;
    @Before
    public void setUp() throws Exception {
        e1 = new NotepadEntry();
        e2 = new NotepadEntry("test string");
    }

    @Test
    public void toStringTest() throws Exception {
        assertEquals("test string", e2.toString());
    }

    @Test
    public void edit() throws Exception {
        e1.edit().append("test strin");
        e2.edit().setLength(10);
        e2.edit().trimToSize();
        assertEquals(e1,e2);
    }

}
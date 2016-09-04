package javase01.t06;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Eugene on 04.09.2016.
 */
public class NotepadTest {
    Notepad notepad;
    NotepadEntry e1;
    NotepadEntry e2;
    NotepadEntry e3;
    NotepadEntry e4;


    @Before
    public void setUp() throws Exception {
        notepad = new Notepad();
        e1 = new NotepadEntry("entry 1");
        e2 = new NotepadEntry("entry 2");
        e3 = new NotepadEntry("entry 3");
        e4 = new NotepadEntry("entry 4");
        notepad.add(e1);
        notepad.add(e2);
        notepad.add(e3);
    }

    @Test
    public void get() throws Exception {
        assertEquals(e1, notepad.get(0));
        assertEquals(e2, notepad.get(1));
        assertEquals(e3, notepad.get(2));
    }

    @Test
    public void add() throws Exception {
        notepad.add(e4);
        assertEquals(notepad.get(3), e4);
        assertEquals(notepad.getSize(), 4);
    }

    @Test
    public void toStringTest() throws Exception {
        System.out.println(notepad.toString());
    }

}
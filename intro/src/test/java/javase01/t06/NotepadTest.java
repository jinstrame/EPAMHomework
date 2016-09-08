package javase01.t06;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class NotepadTest {
    private Notepad notepad;

    @Before
    public void setUp() throws Exception {
        notepad = new Notepad();

        NotepadEntry e1;
        NotepadEntry e2;
        NotepadEntry e3;

        e1 = new NotepadEntry("entry 1");
        e2 = new NotepadEntry("entry 2");
        e3 = new NotepadEntry("entry 3");

        notepad.add(e1);
        notepad.add(e2);
        notepad.add(e3);
    }

    @Test
    public void addNotepadEntryTest() throws Exception {
        NotepadEntry e4 = new NotepadEntry("entry 4");
        notepad.add(e4);
        assertThat(notepad.get(3).toString(), equalTo(e4.toString()));
        assertThat(notepad.getSize(), is(4));
    }

    @Test
    public void editNotepadEntryTest() throws Exception {
        notepad.get(0).getContent().append("content 1");
        assertThat(notepad.get("entry 1").getContent().toString(), equalTo("content 1"));

        notepad.get(2).setTitle("test title");
        notepad.get(2).getContent().append("test content");
        assertThat(notepad.get("test title").toString(), equalTo("test title :: test content"));
    }

    @Test
    public void toStringTest() throws Exception {
        String s = notepad.toString();
        String test = notepad.get(0).toString() + "\n";
        test += notepad.get(1).toString() + "\n";
        test += notepad.get(2).toString() + "\n";

        assertThat(s, is(test));
    }

    @Test
    public void removeTest() throws Exception {
        String first = notepad.get(1).toString() + "\n";
        first += notepad.get(2).toString() + "\n";

        String last = notepad.get(1).toString() + "\n";

        String middle = "";

        notepad.removeFirst();
        assertThat(notepad.toString(), is(first));

        notepad.removeLast();
        assertThat(notepad.toString(), is(last));

        notepad.remove(0);
        assertThat(notepad.toString(), is(middle));
    }


}
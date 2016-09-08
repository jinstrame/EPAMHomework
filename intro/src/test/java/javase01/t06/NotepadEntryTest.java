package javase01.t06;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class NotepadEntryTest {
    private NotepadEntry e1;
    private NotepadEntry e2;
    private NotepadEntry e3;
    @Before
    public void setUp() throws Exception {
        e1 = new NotepadEntry("first entry");
        e2 = new NotepadEntry("second entry", "test string");
        e3 = new NotepadEntry("first entry", "test string");
    }

    @Test
    public void NotepadEditTest() throws Exception {
        e1.getContent().append("test string");
        assertThat(e1.toString(), equalTo(e3.toString()));
        assertThat(e2.toString(), equalTo("second entry :: test string"));
    }

}
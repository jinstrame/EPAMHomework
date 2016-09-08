package javase01.t06;

import lombok.Getter;
import lombok.Setter;


/* TODO
* add javadoc*/

@SuppressWarnings("WeakerAccess")
public class NotepadEntry {
    @Getter
    @Setter
    private StringBuffer content;

    @Getter
    @Setter
    private String title;

    public NotepadEntry(String title, CharSequence content) {
        this.title = title;
        this.content = new StringBuffer(content);
    }

    public NotepadEntry(String title) {
        this.title = title;
        this.content = new StringBuffer();
    }

    public NotepadEntry() {
        this("");
    }

    @Override
    public String toString() {
        return title + " :: " + content.toString();
    }

}

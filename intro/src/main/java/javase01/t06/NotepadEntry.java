package javase01.t06;

/**
 * Created by Eugene on 04.09.2016.
 */
public class NotepadEntry {
    private StringBuffer content;

    public NotepadEntry(CharSequence content) {
        this.content = new StringBuffer(content);
    }

    public NotepadEntry() {
        this("");
    }

    @Override
    public String toString() {
        return content.toString();
    }

    public StringBuffer edit(){
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NotepadEntry that = (NotepadEntry) o;

        return content.toString().equals(that.content.toString());
    }
}

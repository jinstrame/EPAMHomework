package javase01.t06;


/**
 * The NotepadEntry class.
 * Contanst titeled string information.
 * @version 1.0
 */
@SuppressWarnings("WeakerAccess")
public class NotepadEntry {

    private StringBuilder content;

    private String title;

    /**
     * Creates new NotepadEntry object with given title and content.
     * @param title title of new NotepadEntry
     * @param content content for new NotepadEntry
     */
    public NotepadEntry(String title, CharSequence content) {
        this.title = title;
        this.content = new StringBuilder(content);
    }

    /**
     * Creates new NotepadEntry object with given title and empty content.
     * @param title The title of new NotepadEntry
     */
    public NotepadEntry(String title) {
        this.title = title;
        this.content = new StringBuilder();
    }

    /**
     * Creates new NotepadEntry object with empty title and empty content.
     */
    public NotepadEntry() {
        this("");
    }

    /**
     * Creates a String representation of the NotepadEntry object.
     * @return String
     */
    @Override
    public String toString() {
        return title + " :: " + content.toString();
    }

    /**
     * Get title of the NotepadEntry object.
     * @return String
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets new title for NotepadEntry.
     * @param title new NotepadEntry Title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets content from NotepadEntry object.
     * Content can be edited. No needs of setting it back.
     * @return StringBuilder
     */
    public StringBuilder getContent() {
        return this.content;
    }
}

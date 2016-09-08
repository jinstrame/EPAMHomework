package javase01.t06;

import lombok.Getter;

import java.util.Arrays;
import java.util.NoSuchElementException;


/**
 * The Notepad class.
 * Contains NotepadEntry objects as array.
 * @version 1.0
 */
@SuppressWarnings("WeakerAccess")
public class Notepad {

    private NotepadEntry[] notepadEntries;

    @Getter
    private int size;

    private int capacity;

    /**
     * Creates new Notepad object with 10 Entries of initial capacity.
     */
    public Notepad() {
        this(10);
    }

    /**
     * Creates new Notepad object with given capacity.
     * @param capacity The capacity of the new Notepad object.
     */
    public Notepad(int capacity) {
        if (capacity  <= 10) capacity = 10;
        notepadEntries = new NotepadEntry[capacity];
        this.capacity = capacity;
    }

    /**
     * Gest NotepadEntry object with given index from Notepad.
     * @param index Index of the element to get.
     * @return NotepadEntry element for given index.
     */
    public NotepadEntry get(int index){
        if (index >= size) throw new ArrayIndexOutOfBoundsException();
        return notepadEntries[index];
    }

    /**
     * Gest NotepadEntry object with given title from Notepad.
     * @param title Name of the element to get
     * @return NotepadEntry element for given title.
     */
    public NotepadEntry get(String title){
        for (int i = 0; i < size; i++) {
            if (notepadEntries[i].getTitle().equals(title))
                return notepadEntries[i];
        }
        throw new NoSuchElementException();
    }

    /**
     * Adds new NotepadEntry object to Notepad.
     * @param entry BotepadEntry object to add.
     */
    public void add(NotepadEntry entry){
        if (size == capacity){
            extendSize();
        }
        notepadEntries[size++] = entry;
    }

    /**
     * Removes last NotepadEntry element from Notepad.
     * @return NotepadEntry the removed element.
     */
    public NotepadEntry removeLast(){
        if (size == 0) throw new ArrayIndexOutOfBoundsException();
        NotepadEntry ret;

        size--;
        ret =  notepadEntries[size];
        notepadEntries[size] = null;

        return ret;
    }

    /**
     * Removes first NotepadEntry element from Notepad.
     * @return NotepadEntry the removed element.
     */
    public NotepadEntry removeFirst(){
        if (size == 0) throw new ArrayIndexOutOfBoundsException();

        NotepadEntry ret =  notepadEntries[0];
        notepadEntries = Arrays.copyOfRange(notepadEntries, 1, size);

        size --;

        return ret;
    }

    /**
     * Removes NotepadEntry element with given index from Notepad.
     * @param index Identifies the element to remove.
     * @return NotepadEntry the removed element.
     */
    public NotepadEntry remove(int index){
        if (index >= size) throw new ArrayIndexOutOfBoundsException();

        NotepadEntry ret =  notepadEntries[index];
        NotepadEntry[] temp = Arrays.copyOfRange(notepadEntries, index + 1, size);
        System.arraycopy(temp, 0, notepadEntries, index, temp.length);

        size--;

        return ret;
    }


    /**
     * Returns String representation of Notepad object
     * @return String
     */
    @Override public String toString(){
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < size; i++){
            sb.append(notepadEntries[i].toString()).append("\n");
        }
        return sb.toString();
    }

    private void extendSize(){
        if (capacity == Integer.MAX_VALUE) throw new ArrayIndexOutOfBoundsException();

        if ((Integer.MAX_VALUE / 3) * 2 <= capacity) capacity = Integer.MAX_VALUE;
        else capacity = capacity + (capacity / 2);

        NotepadEntry[] moreEntries = new NotepadEntry[capacity];
        System.arraycopy(notepadEntries, 0, moreEntries, 0, size);
        notepadEntries = moreEntries;
    }


}

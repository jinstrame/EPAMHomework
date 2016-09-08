package javase01.t06;

import lombok.Getter;

import java.util.Arrays;
import java.util.NoSuchElementException;


/* TODO
 * add javadoc */

@SuppressWarnings("WeakerAccess")
public class Notepad {


    private NotepadEntry[] notepadEntries;

    @Getter
    private int size;

    private int capacity;

    public Notepad() {
        this(10);
    }

    public Notepad(int capacity) {
        if (capacity  <= 10) capacity = 10;
        notepadEntries = new NotepadEntry[capacity];
        this.capacity = capacity;
    }

    public NotepadEntry get(int index){
        if (index >= size) throw new ArrayIndexOutOfBoundsException();
        return notepadEntries[index];
    }

    public NotepadEntry get(String title){
        for (int i = 0; i < size; i++) {
            if (notepadEntries[i].getTitle().equals(title))
                return notepadEntries[i];
        }

        throw new NoSuchElementException();
    }

    public void add(NotepadEntry e){
        if (size == capacity){
            if (capacity == Integer.MAX_VALUE) throw new ArrayIndexOutOfBoundsException();
            if ((Integer.MAX_VALUE / 3) * 2 <= capacity) capacity = Integer.MAX_VALUE;
            else capacity = capacity + (capacity / 2);
            NotepadEntry[] moreEntries = new NotepadEntry[capacity];
            System.arraycopy(notepadEntries, 0, moreEntries, 0, size);
            notepadEntries = moreEntries;
        }

        notepadEntries[size++] = e;
    }

    public void removeLast(){
        size--;
        notepadEntries[size] = null;
    }

    public void removeFirst(){
        notepadEntries = Arrays.copyOfRange(notepadEntries, 1, size);
        size --;
    }

    public void remove(int index){
        if (index >= size) throw new ArrayIndexOutOfBoundsException();
        NotepadEntry[] temp = Arrays.copyOfRange(notepadEntries, index + 1, size);
        System.arraycopy(temp, 0, notepadEntries, index, temp.length);
        size--;
    }
}

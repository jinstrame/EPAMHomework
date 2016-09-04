package javase01.t06;

import java.util.Arrays;

/**
 * Created by Eugene on 04.09.2016.
 */
public class Notepad {
    private NotepadEntry[] notepadEntries;
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

    @Override
    public String toString() {
        return "Notepad{" +
                "notepadEntries=" +
                Arrays.toString(Arrays.copyOfRange(notepadEntries, 0, size)) +
                '}';
    }

    public int getSize() {
        return size;
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

package oop.task05;


@SuppressWarnings("WeakerAccess")
public enum Disciplines {

    ALGORYTMS_AND_DATA_STRUCTURES(true), ENGLISH(false), JAVA_FUNDAMENTALS(false), C_PLUS_PLUS(true);

    private boolean real;

    public boolean isReal(){
        return real;
    }

    Disciplines(boolean isReal) {
        this.real = isReal;
    }
}

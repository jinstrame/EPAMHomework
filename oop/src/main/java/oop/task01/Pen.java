package oop.task01;

@SuppressWarnings("WeakerAccess")
public class Pen {

    private static final double ACCURACY = 0.01;
    private static final double MAX_WIDTH = 100.0;
    private static final double DEFAULT_WIDTH = 0.7;

    private String color;

    private double width;

    public Pen(String color, double width) {
        if (color == null) this.color = "ghost";
        else this.color = color;
        if (width > 0 && width <= MAX_WIDTH)
            this.width = width;
        else this.width = DEFAULT_WIDTH;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Pen)) return false;

        final Pen other = (Pen) o;
        if (getClass() != other.getClass()) return false;

        final String thisColor = this.color;
        final String otherColor = other.color;

        if (!thisColor.toLowerCase().equals(otherColor.toLowerCase())) return false;

        //noinspection RedundantIfStatement
        if (Math.abs(this.width - other.width) >= ACCURACY) return false;

        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final String color;
        color = this.color;
        result = result * PRIME + color.toLowerCase().hashCode();
        result = result * PRIME + (int)(this.width * (1.0/ACCURACY));
        return result;
    }
}

package javase01.t02;

/**
 * Created by Eugene on 04.09.2016.
 */
public class LessThenEpsilon {
    public static int method(double epsilon){
        double a = Double.POSITIVE_INFINITY;
        int i = 0;
        while (a > epsilon){
            i++;
            a = 1.0 / Math.pow((i + 1), 2);
            System.out.println("a[" + i + "] = " + a);
        }
        System.out.println();
        return i;
    }
}

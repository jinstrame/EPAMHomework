package javase01.t03;

/**
 * Created by Eugene on 04.09.2016.
 */
public class Function {
    public static double f (double x){
        return Math.tan(2.0 * x) - 3.0;
    }

    public static double[] fRange(double start, double end, double h){
        if (end < start){
            double t = end;
            end = start;
            start = t;
        }
        double range = end - start;
        int steps = (int)(range / h); //возможно переполнение

        //end != start + h*range с очень большой вероятностью
        double fx[] = new double[steps + 1];

        double point = start;
        for (int i = 0; i < steps; i++, point+=h){
            fx[i] = f(point);
            System.out.println("F(" + point + ") = " + fx[i]);
        }
        if (end > point) point = end;
        fx[steps] = f(point);
        System.out.println("F(" + point + ") = " + fx[steps]);
        return fx;
    }
}

package javase01.t03;

@SuppressWarnings("WeakerAccess")
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
        int steps = (int)(range / h);
        double fx[] = new double[steps + 1]; // internal points + start + end
        fx[steps] = Double.NaN;

        double point = start;
        fx[0] = f(point);
        System.out.println(fx[0]);

        point = start + h;
        for (int i = 1; point <= end; point+=h, i++){
            fx[i] = f(point);
            System.out.println(fx[i]);
        }

        point = end;
        if (Double.isNaN(fx[steps])) {
            fx[steps] = f(point);
            System.out.println(fx[steps]);
        }
        return fx;
    }
}

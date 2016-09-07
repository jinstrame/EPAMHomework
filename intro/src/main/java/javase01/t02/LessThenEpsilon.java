package javase01.t02;

@SuppressWarnings("WeakerAccess")
public class LessThenEpsilon {

    private double epsilon;
    private LessThenEpsilon(double epsilon){
        this.epsilon = epsilon;
    }

    private boolean condition(double a){
        return a > epsilon;
    }

    private double function(int i){
        return 1.0 / Math.pow((i + 1), 2);
    }

    public static int method(double epsilon){
        double a = Double.POSITIVE_INFINITY;
        LessThenEpsilon lte = new LessThenEpsilon(epsilon);

        int i;
        for (i = 1; lte.condition(a) ; i++){
            a = lte.function(i);
            System.out.println(a);
        }
        return i - 1;
    }
}

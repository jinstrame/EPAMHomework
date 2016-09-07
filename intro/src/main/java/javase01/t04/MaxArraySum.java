package javase01.t04;

@SuppressWarnings("WeakerAccess")
public class MaxArraySum {
    public static double maxFromSides(double[] a){
        int len = a.length;
        if (len%2 == 1) len--; //длина должна быть 2n => отбрасываем последний элемент

        double max = Double.NEGATIVE_INFINITY;

        int right_side = len - 1;
        for (int i = 0; i < len/2; i++){
            double t = a[i] + a[right_side - i];
            if (max < t)
                max = t;
        }
        System.out.println(max);
        return max;
    }
}

package ou2;

class Triangel{
    public static double area(double l, double h){
        double area = (l*h)/2;

        return area;
    }

    private static double bisektris(double b, double c, double a){
        double p = 2 * b * c * Math.cos (a / 2);
        return p / (b + c);
    }

    public static double calc_center(double s_a, double s_b, double s_c, double v_a, double v_b, double v_c){
        double bi_1 = Triangel.bisektris(s_a, s_c, v_a);
        double bi_2 = Triangel.bisektris(s_b, s_a, v_b);
        double bi_3 = Triangel.bisektris(s_c, s_b, v_c);

        return bi_1;
    }
}
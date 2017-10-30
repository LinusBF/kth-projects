class Triangel{
    public static double area(double l, double h){
        double area = (l*h)/2;

        return area;
    }

    public static double bisektris(double b, double c, double a){
        double p = 2 * b * c * Math.cos (alfa / 2);
        double bis = p / (b + c);
        return bis;
    }

    public static double calc_center(double s_a, double s_b, double s_c, double v_a, double v_b, double v_c){
        bi_1 = this.bisektris(s_a, s_c, v_a);
        bi_2 = this.bisektris(s_b, s_a, v_b);
        bi_3 = this.bisektris(s_c, s_b, v_c);
    }
}
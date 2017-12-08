package ou2;

class Triangel{
    public static double area(double l, double h){
        return (l*h)/2;
    }

    public static double bisektrisA(double b, double c, double alpha){
        double p = 2 * b * c * Math.cos (alpha / 2);
        return p / (b + c);
    }

    public static double bisektrisB(double a, double c, double beta){
        double p = 2 * a * c * Math.cos (beta / 2);
        return p / (a + c);
    }

    public static double bisektrisC(double a, double b, double charlie){
        double p = 2 * a * b * Math.cos (charlie / 2);
        return p / (a + b);
    }

    public static double excircleRadius(double s_a, double s_b, double s_c){
        double s = (s_a + s_b + s_c) / 2;
        double n = Math.sqrt((s - s_a)*(s - s_b)*(s - s_c)*s);

        return (s_a * s_b * s_c) / (4 * n);
    }

    public static double incircleRadius(double s_a, double s_b, double s_c){
        double s = (s_a + s_b + s_c) / 2;
        double t = (s - s_a)*(s - s_b)*(s - s_c);
        return Math.sqrt(t/s);
    }
}
package ou2;

import java.util.*;

class EnTriangelOchDessCirklar{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        System.out.println("TRIANGELN:");

        System.out.println("Triangelns sida 'a': ");
        double s_a = in.nextDouble();

        System.out.println("Triangelns sida 'b': ");
        double s_b = in.nextDouble();

        System.out.println("Triangelns sida 'c': ");
        double s_c = in.nextDouble();

        System.out.println("--------------------");

        //Getting radius of enrolled and rewritten circles
        double in_r = Triangel.incircleRadius(s_a, s_b, s_c);
        double out_r = Triangel.excircleRadius(s_a, s_b, s_c);

        System.out.println("TRIANGELNS CIRKLAR:");
        System.out.println("Radie inskrivna cirkeln: " + in_r);
        System.out.println("Radie omskrivna cirkeln: " + out_r);
    }
}
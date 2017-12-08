package ou3;

import java.util.*;

/**
 * Created by Linus Bein Fahlander on 2017-12-08.
 */
public class BestamDenKortasteVagen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("KORTASTE VÄGEN:");

        System.out.println("Antal stationer i zon 2 (m):");
        int a_size = in.nextInt();

        System.out.println("Antal stationer i zon 3 (n):");
        int c_size = in.nextInt();

        double[] a = new double[a_size + 1];
        System.out.println("Fyll i avstånden mellan stationen i zon 1 och stationerna i zon 2:");
        for(int i = 1; i < a_size + 1; i++){
            System.out.println("Station " + i + " i zon 2:");
            a[i] = in.nextDouble();
        }

        double[] c = new double[c_size + 1];;
        System.out.println("Fyll i avstånden mellan stationen i zon 4 och stationerna i zon 3:");
        for(int j = 1; j < c_size + 1; j++){
            System.out.println("Station " + j + " i zon 3:");
            c[j] = in.nextDouble();
        }

        double[][] b = new double[a_size + 1][c_size + 1];
        System.out.println("Fyll i avstånden mellan stationerna i zon 1 och zon 2:");
        for (int i = 1; i < a_size + 1; i++){
            for (int j = 1; j < c_size + 1; j++){
                System.out.println("Station " + i + " i zon 2 och station " + j + " i zon 3:");
                b[i][j] = in.nextDouble();
            }
        }

        int[] stations = DenKortasteVagen.mellanstationer(a, b, c);
        double distance = DenKortasteVagen.langd(a, b, c);

        System.out.println("Den kortaste vägen går via station " + stations[1] + " i zon 2 och station " + stations[2] + " i zon 3.");
        System.out.println("Den kortaste vägen är " + distance + " l.e lång.");

    }
}

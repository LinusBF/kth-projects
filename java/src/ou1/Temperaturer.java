import java.util.*; // Scanner, Locale

class Temperaturer {
    public static void main(String[] args) {
        System.out.println("TEMPERATURER\n");
// inmatningsverktyg
        Scanner in = new Scanner(System.in);
        in.useLocale(Locale.US);
// mata in uppgifter om antalet veckor och antalet mätningar
        System.out.print("antalet veckor: ");
        int antalVeckor = in.nextInt();
        System.out.print("antalet mätningar per vecka: ");
        int antalMatningarPerVecka = in.nextInt();
// plats att lagra temperaturer
        double[][] t = new double[antalVeckor + 1][antalMatningarPerVecka + 1];
// mata in temperaturerna
        for (int vecka = 1; vecka <= antalVeckor; vecka++) {
            System.out.println("temperaturer - vecka " + vecka + ":");
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
                t[vecka][matning] = in.nextDouble();
        }
        System.out.println();
// visa temperaturerna
        System.out.println("temperaturerna:\n\n");
        for (int vecka = 1; vecka <= antalVeckor; vecka++) {
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++)
                System.out.print(t[vecka][matning] + " ");
            System.out.println();
        }
        System.out.println();
// den minsta, den största och medeltemperaturen – veckovis
        double[] minT = new double[antalVeckor + 1];
        double[] maxT = new double[antalVeckor + 1];

        double[] sumT = new double[antalVeckor + 1];
        double[] medelT = new double[antalVeckor + 1];

        for (int vecka = 1; vecka <= antalVeckor; vecka++) {
            double veckomax = 0;
            double veckomin = Double.MAX_VALUE;
            double veckosumma = 0;
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++) {
                double cur_matning = t[vecka][matning];

                if (cur_matning > veckomax) {
                    veckomax = cur_matning;
                }

                if (cur_matning < veckomin) {
                    veckomin = cur_matning;
                }

                veckosumma += cur_matning;
            }

            minT[vecka] = veckomin;
            maxT[vecka] = veckomax;
            sumT[vecka] = veckosumma;
            medelT[vecka] = veckosumma / antalVeckor;

            System.out.println("VECKA " + vecka);
            System.out.println("Lägsta: " + veckomin);
            System.out.println("Högsta: " + veckomax);
            System.out.println("Summan: " + veckosumma);
            System.out.println("Snitt: " + (veckosumma / antalVeckor));
            System.out.println("---------------\n\n");
        }

        double minTemp = minT[1];
        double maxTemp = maxT[1];
        double sumTemp = sumT[1];
        double medelTemp = 0;

        for (int vecka = 2; vecka <= antalVeckor; vecka++) {
            if (minT[vecka] < minTemp) {
                minTemp = minT[vecka];
            }

            if (maxT[vecka] > maxTemp) {
                maxTemp = maxT[vecka];
            }

            sumTemp += sumT[vecka];
        }

        System.out.println("HELA PERIODEN");
        System.out.println("Lägsta: " + minTemp);
        System.out.println("Högsta: " + maxTemp);
        System.out.println("Summan: " + sumTemp);
        System.out.println("Snitt: " + (sumTemp / (antalVeckor * antalMatningarPerVecka)));
        System.out.println("---------------\n\n");

    }
}
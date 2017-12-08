package ou3;

/**
 * Created by Linus on 2017-11-14.
 */
public class DenKortasteVagen {
        // mellanstationer returnerar en vektor med de mellanstationer som finns på den kortaste
        // vägen. Ordningsnummer av den första mellanstationen finns på index 1, och ordningsnummer
        // av den andra mellanstationen på index 2 i vektorn.
        public static int[] mellanstationer (double[] a, double[][] b, double[] c)
        {
            double minLength = Double.MAX_VALUE;
            int[] stations = new int[3];

            for(int i = 1; i < a.length; i++){
                for (int j = 1; j < c.length; j++){
                    double len = a[i];
                    len += b[i][j];
                    len += c[j];

                    if (len < minLength){
                        minLength = len;
                        stations = new int[] {-1, i, j};
                    }
                }
            }

            return stations;
        }
        // langd returnerar längden av den kortaste vägen.
        public static double langd (double[] a, double[][] b, double[] c)
        {
            double minLength = Double.MAX_VALUE;

            for(int i = 1; i < a.length; i++) {
                for (int j = 1; j < c.length; j++) {
                    double len = a[i];
                    len += b[i][j];
                    len += c[j];

                    if (len < minLength) {
                        minLength = len;
                    }
                }
            }

            return minLength;
        }
}

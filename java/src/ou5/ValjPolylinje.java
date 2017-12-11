package ou5;

import java.util.Random;

/**
 * Created by Linus on 2017-12-10.
 */
public class ValjPolylinje
{
    public static final Random rand = new Random ();
    public static final int ANTAL_POLYLINJER = 10;

    public static void main (String[] args)
    {
        // skapa ett antal slumpmässiga polylinjer
        Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];
        for (int i = 0; i < ANTAL_POLYLINJER; i++)
            polylinjer[i] = slumpPolylinje ();

        // visa polylinjerna
        for (Polylinje pl: polylinjer) {
            System.out.println(pl.toString() + "\tLANGD: " + pl.langd());
        }

        // bestäm den kortaste av de polylinjer som är gula
        double minLangd = Double.MAX_VALUE;
        Polylinje kortaste = null;

        for (Polylinje pl: polylinjer) {
            if(pl.getFarg().equals("gul") && pl.langd() < minLangd){
                minLangd = pl.langd();
                kortaste = pl;
            }
        }

        // visa den valda polylinjen
        System.out.println("\n\nKORTASTE GULA POLYLINJEN:");
        System.out.println(kortaste.toString() + "\tLANGD: " + kortaste.langd());
    }

    // slumpPunkt returnerar en punkt med ett slumpmässigt namn, som är en stor bokstav i
    // det engelska alfabetet, och slumpmässiga koordinater.
    public static Punkt slumpPunkt ()
    {
        String n = "" + (char) (65 + rand.nextInt (26));
        int x = rand.nextInt (11);
        int y = rand.nextInt (11);
        return new Punkt (n, x, y);
    }

    // slumpPolylinje returnerar en slumpmässig polylinje, vars färg är antingen blå, eller röd
    // eller gul. Namn på polylinjens hörn är stora bokstäver i det engelska alfabetet. Två hörn
    // kan inte ha samma namn.
    public static Polylinje slumpPolylinje ()
    {
        // skapa en tom polylinje, och lägg till hörn till den
        Polylinje polylinje = new Polylinje ();
        int antalHorn = 2 + rand.nextInt (7);
        int antalValdaHorn = 0;
        boolean[] valdaNamn = new boolean[26];
        // ett och samma namn kan inte förekomma flera gånger
        Punkt valdPunkt = null;
        char valtChar = 0;

        while (antalValdaHorn < antalHorn)
        {
            valdPunkt = ValjPolylinje.slumpPunkt();
            valtChar = valdPunkt.getNamn().charAt(0);

            if(valdaNamn[(int)valtChar - 65]){
                continue;
            }

            valdaNamn[(int)valtChar - 65] = true;
            polylinje.laggTill(valdPunkt);

            antalValdaHorn++;
        }

        // sätt färg
        String[] farger = {"bla", "gul", "rod"};
        polylinje.setFarg(farger[rand.nextInt(3)]);

        return polylinje;
    }
}
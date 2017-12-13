package eu4;

/**
 * Created by Linus on 2017-12-13.
 */
public class Polylinjer {
    public static Polylinje getShortestYellow(Polylinje[] linjer){
        Polylinje kortasteGula = null;

        for (Polylinje linje : linjer) {
            if (linje.getFarg().equals("gul")){
                kortasteGula = linje;
                break;
            }
        }

        if (kortasteGula == null){
            return null;
        }

        for (Polylinje linje : linjer) {
            if (linje.getFarg().equals("gul") && linje.langd() < kortasteGula.langd()){
                kortasteGula = linje;
            }
        }

        return kortasteGula;
    }
}

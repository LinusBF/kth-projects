package eu1;

import java.util.Random;

/**
 * Created by Linus on 2017-12-10.
 */
public class MinFunktion {
    // min returnerar det minsta elementet i en sekventiell samling.
    // Om samlingen är tom, kastas ett undantag av typen IllegalArgumentException.
    public static int min (int[] element) throws IllegalArgumentException
    {
        if (element.length == 0)
            throw new IllegalArgumentException ("tom samling");
        // hör ihop med spårutskriften 2:
        // int antalVarv = 1;
        int[] sekvens = element;
        int antaletPar = sekvens.length / 2;
        int antaletOparadeElement = sekvens.length % 2;
        int antaletTankbaraElement = antaletPar + antaletOparadeElement;
        int i = 0;
        int j = 0;
        while (sekvens.length > 1)
        {
            int[] delsekvens = new int[antaletTankbaraElement];
            // skilj ur en delsekvens med de tänkbara elementen
            i = 0;
            j = 0;
            while (j < antaletPar)
            {
                delsekvens[j++] = (sekvens[i] < sekvens[i + 1])? sekvens[i] : sekvens[i + 1];
                i += 2;
            }
            if (antaletOparadeElement == 1)
                delsekvens[j] = sekvens[sekvens.length - 1];
            // utgå nu ifrån delsekvensen
            sekvens = delsekvens;
            antaletPar = antaletTankbaraElement / 2;
            antaletOparadeElement = antaletTankbaraElement % 2;
            antaletTankbaraElement = antaletPar + antaletOparadeElement;
            // spårutskrift 1 – för att följa sekvensen
             System.out.println (java.util.Arrays.toString (sekvens));
            // spårutskrift 2 - för att avsluta loopen i förväg
            // (för att kunna se vad som händer i början)
            // if (antalVarv++ == 10)
            // System.exit (0);
        }
        // sekvens[0] är det enda återstående tänkbara elementet
        // - det är det minsta elementet
        return sekvens[0];
    }

    public static int min2 (int[] element) throws IllegalArgumentException{
        if (element.length == 0)
            throw new IllegalArgumentException ("tom samling");

        int minValue = element[0];

        for (int elem : element) {
            if (elem < minValue) {
                minValue = elem;
            }
        }

        return minValue;
    }

    public static void main(String[] args) {
        Random rand = new Random();

        int[] elems = new int[19];

        for(int i = 0; i < elems.length; i++){
            if(i != 16){
                int r = rand.nextInt(20);
                elems[i] = (r > 1 ? r : 2);
            } else{
                elems[i] = 1;
            }
        }

        for (int elem :
                elems) {
            System.out.println(elem);
        }

        System.out.println("Minsta talet i elems:");
        System.out.println(min(elems));

    }
}

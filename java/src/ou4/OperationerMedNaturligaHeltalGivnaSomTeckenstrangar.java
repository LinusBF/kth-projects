package ou4;

import java.util.*; // Scanner

import static java.lang.System.out;

class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar {
    public static void main(String[] args) {
        out.println("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");
        // mata in två naturliga heltal
        Scanner in = new Scanner(System.in);
        out.println("två naturliga heltal:");
        String tal1 = in.next();
        String tal2 = in.next();
        out.println();
        // addera heltalen och visa resultatet
        String summa = addera(tal1, tal2);
        visa(tal1, tal2, summa, '+');
        // subtrahera heltalen och visa resultatet
        String differens = subtrahera(tal1, tal2);
        visa(tal1, tal2, differens, '-');
    }

    // addera tar emot två naturliga heltal givna som teckensträngar, och returnerar deras
    // summa som en teckensträng.
    public static String addera(String tal1, String tal2) {
        String biggestNr = tal1;
        String smallestNr = tal2;
        if(tal1.length() < tal2.length()) {
            biggestNr = tal2;
            smallestNr = tal1;
        }

        String result = "";
        boolean carry = false;

        int j = smallestNr.length() - 1;
        for(int i = biggestNr.length() - 1; i >= 0; i--){
            char b = biggestNr.charAt(i);
            int new_number = Character.getNumericValue(b);
            if(j < smallestNr.length() && j >= 0){
                char s = smallestNr.charAt(j);
                int i_s = Character.getNumericValue(s);
                new_number += i_s;
            }
            if (carry){
                new_number++;
                carry = false;
            }
            if(new_number >= 10){
                carry = true;
                new_number -= 10;
            }

            result = new_number + result;
            j--;
        }

        return result;
    }

    // subtrahera tar emot två naturliga heltal givna som teckensträngar, och returnerar
    // deras differens som en teckensträng.
    // Det första heltalet är inte mindre än det andra heltalet.
    public static String subtrahera(String tal1, String tal2) {
        String biggestNr = tal1;
        String smallestNr = tal2;
        if(tal1.length() < tal2.length()) {
            biggestNr = tal2;
            smallestNr = tal1;
        }

        String result = "";
        boolean carry = false;

        int j = smallestNr.length() - 1;
        for(int i = biggestNr.length() - 1; i >= 0; i--){
            char b = biggestNr.charAt(i);
            int new_number = Character.getNumericValue(b);

            if (carry){
                new_number -= 1;
                carry = false;
            }

            if(j < smallestNr.length() && j >= 0){
                char s = smallestNr.charAt(j);
                int i_s = Character.getNumericValue(s);

                if(i_s <= new_number){
                    new_number -= i_s;
                } else{
                    carry = true;
                    new_number = new_number + 10 - i_s;
                }
            }

            result = new_number + result;
            j--;
        }

        return result;
    }

    // visa visar två givna naturliga heltal, och resultatet av en aritmetisk operation
    // utförd i samband med hetalen
    public static void visa(String tal1, String tal2, String resultat, char operator) {
        // sätt en lämplig längd på heltalen och resultatet
        int len1 = tal1.length();
        int len2 = tal2.length();
        int len = resultat.length();
        int maxLen = Math.max(Math.max(len1, len2), len);
        tal1 = sattLen(tal1, maxLen - len1);
        tal2 = sattLen(tal2, maxLen - len2);
        resultat = sattLen(resultat, maxLen - len);
        // visa heltalen och resultatet
        out.println(" " + tal1);
        out.println("" + operator + " " + tal2);
        for (int i = 0; i < maxLen + 2; i++)
            out.print("-");
        out.println();
        out.println(" " + resultat + "\n");
    }

    // sattLen lägger till ett angivet antal mellanslag i början av en given sträng
    public static String sattLen(String s, int antal) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < antal; i++)
            sb.insert(0, " ");
        return sb.toString();
    }
}

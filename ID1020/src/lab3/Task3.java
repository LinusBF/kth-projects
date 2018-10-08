package lab3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Linus Bein Fahlander on 2018-09-26.
 */
public class Task3 {
    public static void main(String[] args) throws FileNotFoundException {
        URL url = Task3.class.getResource("filtered_text.txt");
        Scanner scan =  new Scanner(new FileReader(url.getPath()));
        BST<String, Integer> BST = new BST<>();
        Integer N = (args.length > 0 ? Integer.parseInt(args[0]) : 15);
        Integer M = (args.length > 1 ? Integer.parseInt(args[1]) : 10);
        System.out.println("Printing the " + (N + 1) + "th to the " + (N + M) + "th " + " most common words in the text:\n");
        FrequencyCounters.freqFromTo(BST, scan, N, M);
    }
}

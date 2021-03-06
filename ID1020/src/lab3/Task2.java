package lab3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Linus Bein Fahlander on 2018-09-26.
 */
public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        URL url = Task2.class.getResource("filtered_text.txt");
        Scanner scan =  new Scanner(new FileReader(url.getPath()));
        Scanner scan2 =  new Scanner(new FileReader(url.getPath()));

        BinarySearchST<String, Integer> ST = new BinarySearchST<>();
        BST<String, Integer> BST = new BST<>();

        Integer N = (args.length > 0 ? Integer.parseInt(args[0]) : 3);

        System.out.println("Scanning the first " + N + "00 words");

        long exeTime1 = FrequencyCounters.freqCount(ST, scan, N);
        long exeTime2 = FrequencyCounters.freqCount(BST, scan2, N);

        System.out.println("Symbol Table: " + (exeTime1 / 1000000.0) + "ms");
        System.out.println("Binary Tree: " + (exeTime2 / 1000000.0) + "ms");
    }
}

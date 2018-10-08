package lab3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Linus on 2018-09-30.
 */
public class Task4 {
    public static void main(String[] args) throws FileNotFoundException {
        URL url = Task4.class.getResource("filtered_text.txt");
        Scanner scan =  new Scanner(new FileReader(url.getPath()));
        Scanner scan2 =  new Scanner(new FileReader(url.getPath()));

        RedBlackBST<String, Integer> RBBST = new RedBlackBST<>();
        BST<String, Integer> BST = new BST<>();

        long exeTime1 = FrequencyCounters.freqCount(RBBST, scan);
        long exeTime2 = FrequencyCounters.freqCount(BST, scan2);

        System.out.println("Red Black Binary Tree: " + (exeTime1 / 1000000) + "ms");
        System.out.println("Binary Tree: " + (exeTime2 / 1000000) + "ms");
    }
}

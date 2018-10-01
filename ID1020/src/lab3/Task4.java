package lab3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Linus on 2018-09-30.
 */
public class Task4 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan =  new Scanner(new FileReader("E:\\kth-projects\\ID1020\\src\\lab3\\filtered_text.txt"));
        Scanner scan2 =  new Scanner(new FileReader("E:\\kth-projects\\ID1020\\src\\lab3\\filtered_text.txt"));

        RedBlackBST<String, Integer> RBBST = new RedBlackBST<>();
        BST<String, Integer> BST = new BST<>();

        long exeTime1 = FrequencyCounters.freqCount(RBBST, scan);
        long exeTime2 = FrequencyCounters.freqCount(BST, scan2);

        System.out.println("Red Black Binary Tree: " + (exeTime1 / 1000000) + "ms");
        System.out.println("Binary Tree: " + (exeTime2 / 1000000) + "ms");
    }
}

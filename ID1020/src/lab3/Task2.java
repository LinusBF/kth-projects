package lab3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Linus Bein Fahlander on 2018-09-26.
 */
public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan =  new Scanner(new FileReader("C:\\Projects\\kth-projects\\ID1020\\src\\lab3\\filtered_text.txt"));
        Scanner scan2 =  new Scanner(new FileReader("C:\\Projects\\kth-projects\\ID1020\\src\\lab3\\filtered_text.txt"));

        BinarySearchST<String, Integer> ST = new BinarySearchST<>();
        BST<String, Integer> BST = new BST<>();

        long timestart1 = System.nanoTime();
        FrequencyCounter.freqCount(ST, scan);
        long endtime1 = System.nanoTime();
        FrequencyCounter.freqCount(BST, scan2);
        long endtime2 = System.nanoTime();

        System.out.println("Symbol Table: " + ((endtime1 - timestart1) / 1000000));
        System.out.println("Binary Tree: " + ((endtime2 - endtime1) / 1000000));
    }
}

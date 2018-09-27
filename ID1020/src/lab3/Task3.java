package lab3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Linus Bein Fahlander on 2018-09-26.
 */
public class Task3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan =  new Scanner(new FileReader("C:\\Projects\\kth-projects\\ID1020\\src\\lab3\\filtered_text.txt"));
        BST<String, Integer> BST = new BST<>();

        FrequencyCounter.freqFromTo(BST, scan, 5, 15);
    }
}

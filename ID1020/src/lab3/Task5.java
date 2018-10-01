package lab3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Linus on 2018-10-01.
 */
public class Task5 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan =  new Scanner(new FileReader("E:\\kth-projects\\ID1020\\src\\lab3\\filtered_text.txt"));

        BinarySearchST<String, Integer> ST = new BinarySearchST<>();

        while (scan.hasNext()) {
            String key = scan.next().toLowerCase();
            if (ST.contains(key)) {
                ST.put(key, ST.get(key) + 1);
            }
            else {
                ST.put(key, 1);
            }
        }

        int distribution[] = new int[97];

        for (String key:ST.keys()){
            distribution[hash(key.hashCode())]++;
        }

        int index = 1;
        int min = 1000;
        int max = 0;
        for(int i:distribution){
            if(i < min)
                min = i;
            if(i > max)
                max = i;
            System.out.println("Bucket " + index + " has " + i + " elements");
            index++;
        }

        System.out.println("Biggest difference between two buckets is " + (max - min) + " elements");
    }

    private static int hash(int i){
        return (i & 0x7fffffff) % 97;
    }
}

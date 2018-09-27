package lab3;

/******************************************************************************
 *  Compilation:  javac FrequencyCounter.java
 *  Execution:    java FrequencyCounter L < input.txt
 *  Dependencies: ST.java StdIn.java StdOut.java
 *  Data files:   https://algs4.cs.princeton.edu/31elementary/tnyTale.txt
 *                https://algs4.cs.princeton.edu/31elementary/tale.txt
 *                https://algs4.cs.princeton.edu/31elementary/leipzig100K.txt
 *                https://algs4.cs.princeton.edu/31elementary/leipzig300K.txt
 *                https://algs4.cs.princeton.edu/31elementary/leipzig1M.txt
 *
 *  Read in a list of words from standard input and print out
 *  the most frequently occurring word that has length greater than
 *  a given threshold.
 *
 *  % java FrequencyCounter 1 < tinyTale.txt
 *  it 10
 *
 *  % java FrequencyCounter 8 < tale.txt
 *  business 122
 *
 *  % java FrequencyCounter 10 < leipzig1M.txt
 *  government 24763
 *
 *
 ******************************************************************************/

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *  The {@code FrequencyCounter} class provides a client for
 *  reading in a sequence of words and printing a word (exceeding
 *  a given length) that occurs most frequently. It is useful as
 *  a test client for various symbol table implementations.
 *  <p>
 *  For additional documentation, see <a href="https://algs4.cs.princeton.edu/31elementary">Section 3.1</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public class FrequencyCounter {

    // Do not instantiate.
    private FrequencyCounter() { }

    public static void freqCount(GenericStore<String, Integer> Store, Scanner scan) {
        int distinct = 0, words = 0;

        // compute frequency counts
        while (scan.hasNext()) {
            String key = scan.next();
            words++;
            if (Store.contains(key)) {
                Store.put(key, Store.get(key) + 1);
            }
            else {
                Store.put(key, 1);
                distinct++;
            }
        }

        // find a key with the highest frequency count
        String max = "";
        Store.put(max, 0);
        for (String word : Store.keys()) {
            if (Store.get(word) > Store.get(max))
                max = word;
        }

        System.out.println(max + " " + Store.get(max));
        System.out.println("distinct = " + distinct);
        System.out.println("words    = " + words);
        System.out.println("");
    }

    public static void freqFromTo(GenericStore<String, Integer> Store, Scanner scan, Integer n, Integer amount) {
        class Tuple {
            String s;
            Integer i;
            Tuple(String s, Integer i) {
                this.s = s;
                this.i = i;
            }

            @Override
            public String toString(){
                return s + ": " + i;
            }
        }

        class Compare implements Comparator<Tuple>{
            @Override
            public int compare(Tuple a, Tuple b) {
                if(a.i > b.i){
                    return 1;
                } else {
                    return -1;
                }
            }
        }

        while (scan.hasNext()) {
            String key = scan.next();
            if (Store.contains(key)) {
                Store.put(key, Store.get(key) + 1);
            }
            else {
                Store.put(key, 1);
            }
        }

        ArrayList<Tuple> maxList = new ArrayList<>();
        Compare c = new Compare();
        for (String word : Store.keys()) {
            maxList.add(new Tuple(word, Store.get(word)));
            maxList.sort(c);
            if(maxList.size() > (n + amount)){
                maxList.remove(0);
            }
        }

        for (int i = 0; i < amount; i++){
            System.out.println(maxList.get(i));
        }
    }

    /**
     * Reads in a command-line integer and sequence of words from
     * standard input and prints out a word (whose length exceeds
     * the threshold) that occurs most frequently to standard output.
     * It also prints out the number of words whose length exceeds
     * the threshold and the number of distinct such words.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        int distinct = 0, words = 0;
        int minlen = Integer.parseInt(args[0]);
        BinarySearchST<String, Integer> st = new BinarySearchST<>();
        Scanner scan = new Scanner(System.in);

        // compute frequency counts
        while (!scan.hasNext()) {
            String key = scan.next();
            if (key.length() < minlen) continue;
            words++;
            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            }
            else {
                st.put(key, 1);
                distinct++;
            }
        }

        // find a key with the highest frequency count
        String max = "";
        st.put(max, 0);
        for (String word : st.keys()) {
            if (st.get(word) > st.get(max))
                max = word;
        }

        System.out.println(max + " " + st.get(max));
        System.out.println("distinct = " + distinct);
        System.out.println("words    = " + words);
    }
}

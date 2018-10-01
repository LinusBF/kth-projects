package lab3;

/******************************************************************************
 *  Compilation:  javac FrequencyCounters.java
 *  Execution:    java FrequencyCounters L < input.txt
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
 *  % java FrequencyCounters 1 < tinyTale.txt
 *  it 10
 *
 *  % java FrequencyCounters 8 < tale.txt
 *  business 122
 *
 *  % java FrequencyCounters 10 < leipzig1M.txt
 *  government 24763
 *
 *
 ******************************************************************************/

import java.util.Scanner;

/**
 *  The {@code FrequencyCounters} class provides a client for
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
public class FrequencyCounters {

    // Do not instantiate.
    private FrequencyCounters() { }

    // Returns the execution time to find the max value in the GenericStore
    static long freqCount(GenericStore<String, Integer> Store, Scanner scan, Integer N) {
        int distinct = 0, words = 0;

        long start = System.nanoTime();

        while (scan.hasNext() && words < 100*N) {
            String key = scan.next().toLowerCase();
            words++;
            if (Store.contains(key)) {
                Store.put(key, Store.get(key) + 1);
            }
            else {
                Store.put(key, 1);
                distinct++;
            }
        }

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

        return System.nanoTime() - start;
    }

    static long freqCount(GenericStore<String, Integer> Store, Scanner scan) {
        long time = 0;

        while (scan.hasNext()) {
            String key = scan.next().toLowerCase();
            long start = System.nanoTime();
            if (Store.contains(key)) {
                Store.put(key, Store.get(key) + 1);
            }
            else {
                Store.put(key, 1);
            }
            time += System.nanoTime() - start;
        }
        long start = System.nanoTime();
        String max = "";
        Store.put(max, 0);
        for (String word : Store.keys()) {
            if (Store.get(word) > Store.get(max))
                max = word;
        }
        time += System.nanoTime() - start;

        return time;
    }

    static void freqFromTo(GenericStore<String, Integer> Store, Scanner scan, Integer fromIndex, Integer amount) {
        class Tuple implements Comparable<Tuple> {
            String s;
            Integer i;
            private Tuple(String s, Integer i) {
                this.s = s;
                this.i = i;
            }

            @Override
            public String toString(){
                return s + ": " + i;
            }

            @Override
            public int compareTo(Tuple o) {
                return this.i.compareTo(o.i);
            }
        }

        while (scan.hasNext()) {
            String key = scan.next().toLowerCase();
            if (Store.contains(key)) {
                Store.put(key, Store.get(key) + 1);
            }
            else {
                Store.put(key, 1);
            }
        }

        SortedLinkedList<Tuple> maxList = new SortedLinkedList<>();
        for (String word : Store.keys()) {
            maxList.enqueue(new Tuple(word, Store.get(word)));
            if(maxList.size() > (fromIndex + amount)){
                maxList.dequeue();
            }
        }

        for (int i = 0; i < amount; i++){
            System.out.println("The " + ((amount + fromIndex) - (i)) + "th most common word:");
            System.out.println(maxList.dequeue());
            System.out.println("");
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

package lab2;

import java.util.Iterator;

/**
 * Created by Linus Bein Fahlander on 2018-09-16.
 */
@SuppressWarnings("Duplicates")
public class ElemSorts {
    private static class SortedLinkedList {
        private Node first;
        private int N;

        private class Node {
            private Node next;
            private Integer item;
        }

        public boolean isEmpty() {
            return this.first == null;
        }

        public int size() {
            return this.N;
        }

        public void enqueue(Integer i) {
            if (this.isEmpty()) {
                this.first = new Node();
                this.first.item = i;
            } else {
                Node current = this.first;
                Node beforeCurrent = null;
                while(current != null && current.item <= i){
                    beforeCurrent = current;
                    current = current.next;
                }
                Node newNode = new Node();
                newNode.item = i;
                if(beforeCurrent != null) beforeCurrent.next = newNode;
                else this.first = newNode;
                newNode.next = current;
            }
            this.N++;
            System.out.println(this);
        }

        public Integer dequeue() {
            if (this.isEmpty()) return null;
            Integer i = this.first.item;
            this.first = first.next; // Does garbage collection remove old first?
            this.N--;
            return i;
        }

        @Override
        public String toString() {
            String s = "[" + this.first.item + "], ";
            Node temp = this.first.next;
            while (temp != null) {
                s += "[" + temp.item + "], ";
                temp = temp.next;
            }
            return s.substring(0, s.length() - 2);
        }
    }

    public static void sort1(Comparable[] list){
        int max = list.length;
        for(int i = 0; i < max; i++){
            int min = i;
            for(int j = i + 1; j < max; j++){
                if(less(list[j], list[min])) min = j;
                print(list);
            }
            swap(list, i, min);
        }
    }

    public static void sort2(Comparable[] list){
        int max = list.length;
        for(int i = 0; i < max; i++){
            int min = i;
            for(int j = i + 1; j < max; j++){
                if(more(list[j], list[min])) min = j;
                print(list);
            }
            swap(list, i, min);
        }
    }

    public static void sort3(Comparable[] list){
        int max = list.length;
        int swapped = 0;
        for(int i = 0; i < max; i++){
            int min = i;
            for(int j = i + 1; j < max; j++){
                if(more(list[j], list[min])) min = j;
                print(list);
            }
            swap(list, i, min);
            swapped++;
        }
        System.out.println("Swapped " + swapped + " times during sorting");
    }

    public static void amountOfInversions(Comparable[] list) {
        Integer nrOfInverse = 0;
        for(int i = 0; i < list.length; i++){
            for(int j = i + 1; j < list.length; j++){
                if(less(list[j], list[i])){
                    System.out.println("Inversion: [" + i + "," + list[i] + "], [" + j + "," + list[j] + "]");
                    nrOfInverse++;
                }
            }
        }
        System.out.println("Number of inversions: " + nrOfInverse);
    }

    private static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    private static boolean more(Comparable a, Comparable b){
        return a.compareTo(b) > 0;
    }

    private static void swap(Comparable[] list, int i, int j){
        Comparable temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    private static void print(Comparable[] list){
        StringBuilder sb = new StringBuilder("[");
        for (Comparable item : list) {
            sb.append("{").append(item).append("}, ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");

        System.out.println(sb.toString());
    }

    public static boolean isSorted(Comparable[] list){
        for(int i = 1; i < list.length; i++) {
            if(less(list[i], list[i-1])) return false;
        }
        return true;
    }

    public static boolean isSorted2(Comparable[] list){
        for(int i = 1; i < list.length; i++) {
            if(more(list[i], list[i-1])) return false;
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println("\nAssignment 1:\n");

        Integer[] testList = {3,2,1,4,5};
        sort1(testList);
        assert isSorted(testList);

        System.out.println("\nAssignment 2:\n");

        Integer[] testList2 = {3,2,1,4,5};
        sort2(testList2);
        assert isSorted2(testList2);

        System.out.println("\nAssignment 3:\n");

        Integer[] testList3 = {3,2,1,4,5};
        sort3(testList3);
        assert isSorted2(testList3);

        System.out.println("\nAssignment 4:\n");

        Integer[] testList4 = {1, 2, 4, 3, 5, 0};
        print(testList4);
        amountOfInversions(testList4);

        System.out.println("\nAssignment 7:\n");

        SortedLinkedList testList5 = new SortedLinkedList();

        System.out.println("Adding integers in the following order: 3, 1, 4, 2, 5:");
        testList5.enqueue(3);
        testList5.enqueue(1);
        testList5.enqueue(4);
        testList5.enqueue(2);
        testList5.enqueue(5);
    }
}

package lab2;

import java.util.Scanner;

/**
 * Created by Linus Bein Fahlander on 2018-09-16.
 */
@SuppressWarnings("Duplicates")
public class ElemSorts {
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

        String[] testList4 = {"E", "X", "A", "M", "P", "L", "E"};
        print(testList4);
        amountOfInversions(testList4);
    }
}

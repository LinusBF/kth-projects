/*
 * Lab 1 - Assignment 2
 *
 * Created by Linus on 2018-09-09.
 *
 * This program reads a text string and prints it backwards
 * This is done twice when run, once recursively and once iteratively
 */

package lab1;

import java.util.Scanner;

/**
 * This class contains two ways to print a
 * supplied String backwards.
 * recursive will print it backwards recursively
 * iterative will print it backwards iteratively
 */
public class Reverse {
    /**
     * Prints a String backwards recursively
     * by calling itself with a substring of the
     * supplied String as the parameter, until
     * the string is empty.
     * Each instance of the function called will
     * printout the first character of its String.
     * As such, the original String will be printed
     * backwards.
     * @param s The String to be printed backwards
     */
    public static void recursive(String s){
        if(!s.isEmpty()){
            recursive(s.substring(1));
            System.out.print(s.charAt(0));
        }
    }

    /**
     * Prints a String iteratively by looping
     * through all characters of the String, starting
     * at the last character and ending at index 0 of
     * the String.
     * @param s The String to be printed backwards
     */
    public static void iterative(String s){
        for(int i = s.length() - 1; i >= 0; i--){
            System.out.print(s.charAt(i));
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        iterative(in.nextLine());
        System.out.println("");
        recursive(in.nextLine());
        in.close();
    }
}

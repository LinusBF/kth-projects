package lab1;

import java.util.Scanner;

/**
 * Created by Linus on 2018-09-09.
 */
public class Reverse {
    private static void recursive(String s){
        if(!s.isEmpty()){
            recursive(s.substring(1));
            System.out.print(s.charAt(0));
        }
    }

    private static void iterative(String s){
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

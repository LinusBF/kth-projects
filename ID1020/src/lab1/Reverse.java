package lab1;

import java.util.Scanner;

/**
 * Created by Linus on 2018-09-09.
 */
public class Reverse {
    private static class CharStack{
        char[] chars;

        CharStack(){
            chars = new char[0];
        }

        private char[] copy(int increase){
            char[] newChars = new char[chars.length + increase];
            for(int i = 0; i < (chars.length + increase); i++){
                if(i < chars.length){
                    newChars[i] = chars[i];
                }
            }
            return newChars;
        }

        boolean isEmpty(){
            return chars.length == 0;
        }

        int size() {
            return chars.length;
        }

        void push(char c){
            char[] newChars = copy(1);
            newChars[newChars.length - 1] = c;
            chars = newChars;
        }

        char pop(){
            char lastChar = chars[chars.length - 1];
            chars = copy(-1);
            return lastChar;
        }
    }

    private static CharStack getInput(){
        CharStack input = new CharStack();
        Scanner in = new Scanner(System.in);
        String inStr = in.nextLine();
        in.close();
        for (char nextChar : inStr.toCharArray()) {
            if (nextChar != '\n') {
                input.push(nextChar);
            }
        }

        return input;
    }

    private static void printCharStack(CharStack stack){
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }

    public static void main(String[] args) {
        CharStack input = getInput();
        printCharStack(input);
    }
}

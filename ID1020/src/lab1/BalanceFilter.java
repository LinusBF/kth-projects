/*
 * Lab 1 - Assignment 6
 *
 * Created by Linus Bein Fahlander on 2018-09-12.
 *
 * This program checks the parentheses balance in a text
 */

package lab1;

import java.util.Arrays;

/**
 *
 * This class checks if a string is balanced or not.
 * It utilizes a stack to perform the balance check.
 * Every left parentheses is pushed to the stack.
 * When a right parentheses is discovered, it checks if the parentheses
 * matches the one on top of the stack, if not the string is not balanced
 * and the class returns false.
 *
 */
public class BalanceFilter {
    /**
     * A basic stack implementation with a peek function to check
     * the top value of the stack without removing it.
     * @param <Item>
     */
    private class BalanceStack<Item> { // Item could be specified as Character
        private Node current;
        private int N;

        private class Node {
            private Node next;
            private Item item;
        }

        boolean isEmpty() {
            return this.current == null;
        }

        public int size() {
            return this.N;
        }

        void push(Item i) {
            if (this.isEmpty()) {
                this.current = new Node();
                this.current.item = i;
            } else {
                Node oldCurrent = this.current;
                this.current = new Node();
                this.current.item = i;
                this.current.next = oldCurrent;
            }
            this.N++;
        }

        Item pop() {
            if (this.isEmpty()) return null;
            Item i = this.current.item;
            this.current = current.next;
            this.N--;
            return i;
        }

        Item peek() {
            return this.current.item;
        }

        @Override
        public String toString() {
            String s = "[" + this.current.item + "], ";
            Node temp = this.current.next;
            while (temp != null) {
                s += "[" + temp.item + "], ";
                temp = temp.next;
            }
            return s.substring(0, s.length() - 2);
        }
    }

    // A static storage for the different parentheses supported
    private static Character[] leftParans = {'(', '[', '{'};
    private static Character[] rightParans = {')', ']', '}'};

    /**
     * Returns the matching parentheses to a supplied right parentheses
     *
     * @param right The right parentheses to find a partner to.
     * @return The partner parentheses to the parameter character
     */
    private Character getMatchingParan(Character right) {
        return leftParans[Arrays.asList(rightParans).indexOf(right)];
    }

    /**
     * Checks if a character is a left parentheses
     *
     * @param c A character from a string
     * @return Boolean | True if the character is one of the parentheses in 'leftParans'
     */
    private boolean isLeftParan(Character c){
        return Arrays.asList(leftParans).contains(c);
    }

    /**
     * Checks if a character is a right parentheses
     *
     * @param c A character from a string
     * @return Boolean | True if the character is one of the parentheses in 'rightParans'
     */
    private boolean isRightParan(Character c){
        return Arrays.asList(rightParans).contains(c);
    }

    /**
     * Checks if the parentheses on top of the supplied stack is matching
     * the supplied parentheses
     *
     * @param c The right parentheses to check
     * @param stack The stack used during balance checking
     * @return Boolean | True if the two parentheses are matching
     */
    private boolean rightParanIsCorrect(Character c, BalanceStack<Character> stack) {
        return this.getMatchingParan(c) == stack.peek();
    }

    /**
     * This method is responsible for the abstracted logic of checking
     * if a string is balanced or not.
     *
     * @param input The string to check for balance
     * @return Boolean | True if input string is balanced
     */
    public boolean checkStringBalance(String input) {
        BalanceStack<Character> stack = new BalanceStack<>();
        boolean balanced = true;
        for (int i = 0; i < input.length(); i++){
            Character current = input.charAt(i);
            if(this.isLeftParan(current)){
                stack.push(current);
            } else if(this.isRightParan(current)){
                if(this.rightParanIsCorrect(current, stack)){
                    stack.pop();
                } else {
                    balanced = false;
                    break;
                }
            }
        }

        return balanced;
    }

    public static void main(String[] args) {
        BalanceFilter bf = new BalanceFilter();

        /*
        * Unit tests
        *   Tests the balance results of the following cases:
        *   Two balanced strings, one with and one without other text
        *   One imbalanced string
        */
        String correctTest = "[{[()()]()}]";
        String correctWithText = "[this {is} a (generic) [test{case}]]";
        String incorrectTest = "[[]{(})]";
        System.out.println("Unit tests ran with results:");
        System.out.println(bf.checkStringBalance(correctTest));
        System.out.println(bf.checkStringBalance(correctWithText));
        System.out.println(!bf.checkStringBalance(incorrectTest));
        System.out.println("\n\n\n");

        // Support for command line argument
        if(args.length > 0) {
            System.out.println("Your input is " + (bf.checkStringBalance(args[1]) ? "balanced!" : "not balanced!"));
        }

        //Support for text file piping
        StringBuilder fileInput = new StringBuilder();
        while(!StdIn.isEmpty()){
            fileInput.append(StdIn.readLine());
        }

        if(fileInput.length() > 0){
            System.out.println("Your file is " + (bf.checkStringBalance(fileInput.toString()) ? "balanced!" : "not balanced!"));
        }
    }
}

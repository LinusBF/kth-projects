package lab1;

import java.util.Arrays;

/**
 * Created by Linus on 2018-09-12.
 * Based on a Stack pattern
 */
public class BalanceFilter {
    private class BalanceStack<Item> {
        private Node current;
        private int N;

        private class Node {
            private Node next;
            private Item item;
        }

        public boolean isEmpty() {
            return this.current == null;
        }

        public int size() {
            return this.N;
        }

        public void push(Item i) {
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

        public Item pop() {
            if (this.isEmpty()) return null;
            Item i = this.current.item;
            this.current = current.next;
            this.N--;
            return i;
        }

        public Item peek() {
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

    private static Character[] leftParans = {'(', '[', '{'};
    private static Character[] rightParans = {')', ']', '}'};

    private Character getMatchingParan(Character right) {
        return leftParans[Arrays.asList(rightParans).indexOf(right)];
    }

    private boolean isLeftParan(Character c){
        return Arrays.asList(leftParans).contains(c);
    }

    private boolean isRightParan(Character c){
        return Arrays.asList(rightParans).contains(c);
    }

    private boolean rightParanIsCorrect(Character c, BalanceStack<Character> stack) {
        return this.getMatchingParan(c) == stack.peek();
    }

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

        if(args.length > 0) {
            System.out.println("Your input is " + (bf.checkStringBalance(args[1]) ? "balanced!" : "not balanced!"));
        }
        StringBuilder fileInput = new StringBuilder();
        while(!StdIn.isEmpty()){
            fileInput.append(StdIn.readLine());
        }

        if(fileInput.length() > 0){
            System.out.println("Your file is " + (bf.checkStringBalance(fileInput.toString()) ? "balanced!" : "not balanced!"));
        }

        String correctTest = "[{[()()]()}]";
        String correctWithText = "[this {is} a (generic) [test{case}]]";
        String incorrectTest = "[[]{(})]";
        System.out.println("\n\n\nUnit tests ran with results:");
        System.out.println(bf.checkStringBalance(correctTest));
        System.out.println(bf.checkStringBalance(correctWithText));
        System.out.println(!bf.checkStringBalance(incorrectTest));
    }
}

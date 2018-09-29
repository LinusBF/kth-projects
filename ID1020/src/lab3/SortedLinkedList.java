package lab3;

/**
 * Created by Linus on 2018-09-29.
 */
public class SortedLinkedList<Item extends Comparable<Item>> {
    private Node first;
    private int N;

    private class Node {
        private Node next;
        private Item item;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public int size() {
        return this.N;
    }

    public void enqueue(Item i) {
        if (this.isEmpty()) {
            this.first = new Node();
            this.first.item = i;
        } else {
            Node current = this.first;
            Node beforeCurrent = null;
            while(current != null && current.item.compareTo(i) <= 0){
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
    }

    public Item dequeue() {
        if (this.isEmpty()) return null;
        Item i = this.first.item;
        this.first = first.next;
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
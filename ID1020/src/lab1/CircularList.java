/*
 * Lab 1 - Assignment 4
 *
 * Created by Linus Bein Fahlander on 2018-09-10.
 *
 * This program contains a circular linked list that supports adding and removing items
 * from both the front and the back of the queue
 */

package lab1;

import java.util.Iterator;

/**
 * An iterable circular linked list that supports pushing and popping
 * items from the top and bottom of the list.
 */
public class CircularList<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node{
        private Node next;
        private Item item;
    }

    public boolean isEmpty(){return this.first == null;}

    public int size(){return this.N;}

    /**
     * Pushes an item to the back of the list.
     * @param i Item to add to the list
     */
    public void pushBack(Item i) {
        if(this.isEmpty()){
            this.first = new Node();
            this.first.item = i;
            this.last = this.first;
            this.first.next = this.last;
        } else {
            Node oldLast = this.last;
            this.last = new Node();
            this.last.item = i;
            this.last.next = this.first;
            oldLast.next = this.last;
        }
        this.N++;
    }

    /**
     * Pushes an item to the front of the list.
     * @param i Item to add to the list
     */
    public void pushFront(Item i) {
        if(this.isEmpty()){
            this.first = new Node();
            this.first.item = i;
            this.last = this.first;
            this.first.next = this.last;
        } else {
            Node oldFirst = this.first;
            this.first = new Node();
            this.first.item = i;
            this.first.next = oldFirst;
            this.last.next = this.first;
        }
        this.N++;
    }

    /**
     * Returns an item from the front of the list, removing it from the list.
     * @return Item The item that was at the front of the list
     */
    public Item popFront() {
        if(this.isEmpty()) return null;
        Item i = this.first.item;
        if(this.first.next == this.first){
            this.first.next = null;
        }
        this.first = first.next;
        this.last.next = this.first;
        if(this.isEmpty()){
            this.last = null;
        }
        this.N--;
        return i;
    }

    /**
     * Returns an item from the back of the list, removing it from the list.
     * @return Item The item that was at the back of the list
     */
    public Item popBack() {
        if(this.isEmpty()) return null;
        Item i = this.last.item;
        if(this.first.next == this.first){
            this.first = null;
        }
        else {
            Node newLast = this.first;
            while (newLast.next != this.last) {
                newLast = newLast.next;
            }
            this.last = newLast;
            this.last.next = this.first;
        }
        if(this.isEmpty()){
            this.last = null;
        }
        this.N--;
        return i;
    }

    private class NodeIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean hasNext()
        { return current != null; }
        public void remove() { }
        public Item next()
        {
            Item i = current.item;
            current = current.next;
            return i;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new NodeIterator();
    }

    @Override
    public String toString(){
        String s = "[" + this.first.item + "], ";
        Node temp = this.first.next;
        while (!temp.equals(this.first)){
            s += "[" + temp.item + "], ";
            temp = temp.next;
        }
        return s.substring(0, s.length() - 2);
    }

    public static void main(String[] args) {
        /*Unit test

            A list will have the following items put into it:
                - 1 and 2 pushed in order to the back of the list
                - 3 will be pushed to the front of the list (in front of 1)
                - 4 and 5 will be pushed to the back of the list (behind of 2)
            The test is considered a success if:
                - The first two items popped from the front of the list is 3 and 1
                - The first two items popped from the back of the list is 5 and 4
                - The size of the queue is 1 after all removals have been made

            After the setup the list will look like (front --> back)
            [3], [1], [2], [4], [5]
            During the test it will look like the following:
            [1], [2], [4], [5]
            [2], [4], [5]
            [2], [4]
            [2]
        */
        CircularList<Integer> list = new CircularList<>();
        list.pushBack(1);
        list.pushBack(2);
        list.pushFront(3);
        list.pushBack(4);
        list.pushBack(5);
        System.out.println(list.popFront().equals(3));
        System.out.println(list.popFront().equals(1));
        System.out.println(list.popBack().equals(5));
        System.out.println(list.popBack().equals(4));
        System.out.println(list.size() == 1);
    }
}

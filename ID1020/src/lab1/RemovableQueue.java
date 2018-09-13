/*
 * Lab 1 - Assignment 5
 *
 * Created by Linus Bein Fahlander on 2018-09-12.
 *
 * This program contains a LIFO queue that supports removing the n-th item in the queue
 */

package lab1;

import java.util.Iterator;

/**
 * An iterable LIFO queue that supports removing the n-th item in the queue
 */
public class RemovableQueue<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    private class Node{
        private Node next;
        private Item item;
    }

    public boolean isEmpty(){return this.first == null;}

    public int size(){return this.N;}

    public void enqueue(Item i) {
        if(this.isEmpty()){
            this.first = new Node();
            this.first.item = i;
        } else {
            Node oldFirst = this.first;
            this.first = new Node();
            this.first.item = i;
            this.first.next = oldFirst;
        }
        this.N++;
    }

    public Item dequeue() {
        if(this.isEmpty()) return null;
        Item i = this.first.item;
        this.first = first.next; // Does garbage collection remove old first?
        this.N--;
        return i;
    }

    /**
     * This function will traverse the nodes in the queue until the
     * supplied index is reached. During the traversing, the function
     * keeps track of the node visited during the previous loop and
     * will used that node to link the queue together again after the
     * desired element is removed. This is done by setting the previous
     * node's next reference to the next reference in the node that will
     * be deleted.
     *
     * @param index The index of the Item to remove from the queue
     * @return Boolean | True if the element was successfully removed
     */
    public boolean removeAtIndex(Integer index) {
        if(index < 1) return false;
        if(index == 1) {
            this.dequeue();
            return true;
        }
        Node prevNode = null;
        Node current = this.first;
        for(int i = 1; i < index; i++){
            if(current.next == null) return false;
            prevNode = current;
            current = current.next;
        }
        prevNode.next = current.next;
        current = null;
        this.N--;
        return true;
    }

    private class NodeIterator implements Iterator<Item> {
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
    public String toString(){
        String s = "[" + this.first.item + "], ";
        Node temp = this.first.next;
        while (temp != null){
            s += "[" + temp.item + "], ";
            temp = temp.next;
        }
        return s.substring(0, s.length() - 2);
    }

    @Override
    public Iterator<Item> iterator() {
        return new NodeIterator();
    }

    public static void main(String[] args) {
        /*Unit test

            Tests the class by adding 1 through 5 in reverse order and removing 5, 3, 1 in that order
            The test is considered a success if:
                - The size of the queue is 2 after removal
                - The next two items returned by dequeue is 2 and 4, in that order
        */
        RemovableQueue<Integer> list = new RemovableQueue<>();
        list.enqueue(5);
        list.enqueue(4);
        list.enqueue(3);
        list.enqueue(2);
        list.enqueue(1);
        list.removeAtIndex(5);
        list.removeAtIndex(3);
        list.removeAtIndex(1);
        System.out.println("Unit test ran with results:");
        System.out.println(list.size() == 2);
        System.out.println(list.dequeue().equals(2));
        System.out.println(list.dequeue().equals(4));
    }
}

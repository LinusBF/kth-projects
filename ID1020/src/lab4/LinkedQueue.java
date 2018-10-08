/*
 * Lab 1 - Assignment 3
 *
 * Created by Linus Bein Fahlander on 2018-09-09.
 *
 * This program contains a FIFO queue that implements a double linked list
 */

package lab4;

import java.util.Iterator;

/**
 * An iterable queue implementing a linked list
 */
public class LinkedQueue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node{
        private Node next;
        private Item item;
    }

    public boolean isEmpty(){return this.first == null;}

    public int size(){return N;}

    /**
     * Similar to a regular enqueue, but the new nodes
     * references needs to also be set, in addition to the
     * usual reference setting
     * @param i Item to add to the queue
     */
    public void enqueue(Item i) {
        Node oldLast = this.last;
        this.last = new Node();
        this.last.item = i;
        this.last.next = null;
        if(this.isEmpty()){
            this.first = this.last;
        }
        else{
            oldLast.next = this.last;
        }
        this.N++;
    }

    /**
     * Similar to a regular dequeue, but the new first item's
     * references needs to also be set, in addition to the
     * usual reference setting
     * @return Item that was removed from the queue
     */
    public Item dequeue() {
        Item i = this.first.item;
        this.first = first.next;
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
}

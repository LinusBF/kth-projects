package lab1;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by Linus Bein Fahlander on 2018-09-09.
 */
public class LinkedQueue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node{
        private Node next;
        private Node prev;
        private Item item;
    }

    public boolean isEmpty(){return this.first == null;}

    public int size(){return N;}

    public void enqueue(Item i) {
        Node oldLast = this.last;
        this.last = new Node();
        this.last.item = i;
        this.last.next = null;
        this.last.prev = oldLast;
        if(this.isEmpty()){
            this.first = this.last;
        }
        else{
            oldLast.next = this.last;
        }
        this.N++;
    }

    public Item dequeue() {
        Item i = this.first.item;
        this.first = first.next;
        this.first.prev = null;
        if(this.isEmpty()){
            this.last = null;
        }
        this.N--;
        return i;
    }

    private class ListIterator implements Iterator<Item>
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
        public Item prev(){
            Item i = current.item;
            current = current.prev;
            return i;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
}

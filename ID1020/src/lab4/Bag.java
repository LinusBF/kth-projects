package lab4;

import java.util.Iterator;

/**
 * Created by Linus on 2018-10-08.
 */
public class Bag<Item> implements Iterable<Item>{
    private Node<Item> first;
    private int N;

    private static class Node<Item> {
        private Item val;
        private Node<Item> next;
    }

    public Bag(){
        this.first = null;
        this.N = 0;
    }

    public void add(Item i){
        Node<Item> temp = this.first;
        this.first = new Node<>();
        this.first.val = i;
        this.first.next = temp;
        this.N++;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public int size() {return N;}

    public Iterator<Item> iterator()  {
        return new ListIterator<>(this.first);
    }

    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        ListIterator(Node<Item> first) {
            current = first;
        }
        public boolean hasNext()  { return current != null;}
        public Item next() {
            if (!hasNext()) return null;
            Item item = current.val;
            current = current.next;
            return item;
        }
    }
}

package lab4;

import java.util.Iterator;

/**
 * Created by Linus on 2018-10-11.
 */
public class Stack<Item> implements Iterable<Item> {
    private Node<Item> first;
    private int n;

    private static class Node<Item> {
        private Item i;
        private Node<Item> n;
    }

    public Stack(){
        first = null;
        n = 0;
    }

    public int size() {
        return n;
    }

    public void push(Item i){
        Node<Item> temp = first;
        first = new Node<>();
        first.i = i;
        first.n = temp;
        n++;
    }

    public Item pop(){
        Item i = first.i;
        first = first.n;
        n--;
        return i;
    }

    public Item peek(){
        return first.i;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator<Item>(first);
    }

    private class ListIterator<I> implements Iterator<I> {
        private Node<I> current;

        public ListIterator(Node<I> first) {
            current = first;
        }

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public I next() {
            I item = current.i;
            current = current.n;
            return item;
        }
    }
}

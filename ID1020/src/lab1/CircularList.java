package lab1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Linus Bein Fahlander on 2018-09-10.
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

    public void enqueue(Item i) {
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

    public void enqueueInverse(Item i) {
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

    public Item dequeue() {
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

    public Item dequeueInverse() {
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
        public boolean hasPrevious()
        { return current != null; }
        public void remove() { }
        public Item next()
        {
            Item i = current.item;
            current = current.next;
            return i;
        }
        public Item previous(){
            Item i = current.item;
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
        String test1 = "1";
        Integer test2 = 9;
        ArrayList<Integer> test3 = new ArrayList<>();
        test3.add(1);
        test3.add(2);
        CircularList list = new CircularList();
        list.enqueue(1);
        list.enqueue(2);
        list.enqueueInverse(3);
        list.enqueue(4);
        System.out.println(list);
        list.dequeue();
        System.out.println(list);
        list.dequeueInverse();
        System.out.println(list);
    }
}

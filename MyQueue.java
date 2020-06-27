package lb1;


import java.util.Iterator;

public class MyQueue<Item> implements Iterable<Item> {
    private int n;
    private Node first;
    private Node last;
    public MyQueue() {
        first = new Node();
        last = new Node();
        n = 0;
    }
    private class LinkedArrayIterator implements Iterator<Item> {
        Node node = first;
        boolean has_next = true;
        @Override
        public boolean hasNext() {
            return has_next;
        }

        @Override
        public Item next() {
            Item item = node.item;
            node = node.next;
            if (node == null) has_next = false;
            return item;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedArrayIterator();
    }

    private class Node {
        Item item;
        Node next;
    }
    public int size() {
        return n;
    }
    public boolean isEmpty() {
        return n==0;
    }

    public void push(Item elem) {
        Node old_last = last;
        last = new Node();
        last.item = elem;
        last.next = old_last;
        if (isEmpty()) first = last;
        else old_last.next = last;
        n++;
    }
    public Item pop() {
        Item item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        n--;
        return item;
    }
}

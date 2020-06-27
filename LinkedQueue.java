package lb1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<Item> implements Iterable<Item> {
    private int n;
    private int size;
    private Node first;
    private Node last;

    public LinkedQueue(int size) {
        n = 0;
        this.size = size;
    }

    private class LinkedQueueIterator implements Iterator<Item> {
        Node node = first;
        boolean has_next = true;
        @Override
        public boolean hasNext() {
            return node != null && has_next;
        }

        @Override
        public Item next() {
            Item item = node.item;
            if (node == last) has_next = false;
            node = node.next;
            return item;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedQueueIterator();
    }

    private class Node {
        Item item;
        Node next;
        public Node() {
            this.item = null;
            this.next = null;
        }
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return n==0;
    }

    public void push(Item elem) throws NoSuchElementException {
        if (n >= size) {
            System.out.println("Queue is full!");
            Node old_last = last;
            last = first;
            last.item = elem;
            old_last.next = last;
            first = first.next;
            return;
        }
        if (isEmpty()) {
            first = new Node();
            first.item = elem;
            last = new Node();
            first.next = last;
        } else {
            if (last.item == null) {
                last.item = elem;
                last.next = first;
            } else {
                Node new_last = new Node();
                new_last.item = elem;
                new_last.next = first;
                last.next = new_last;
                last = new_last;
            }
        }
        n++;
    }
    public Item pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty!");
        }
        Item item = first.item;
        first = first.next;
        last.next = first;
        n--;
        return item;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        for(Item elem: this) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }
}

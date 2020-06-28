package lb1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CycleQueue<Item> implements Iterable<Item>{
    private int size;
    private int n;
    private Item[] array;
    private int start;
    private int end;

    public CycleQueue(int size) {
        this.size = size;
        n = 0;
        array = (Item[]) new Object[size];
        start = 0;
        end = 0;
    }

    public int queue_size() {
        return size;
    }
    public int size() {
        return n;
    }
    public boolean isEmpty() {
        return n==0;
    }

    public void push(Item item) {
        if (n >= size) {
            System.out.println("Push error: queue is full!");
            return;
        }
        array[end] = item;
        end++;
        n++;
        if (end >= size) end = 0;
    }

    public Item pop() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Pop Error: queue is empty!");
        }
        if (start >= size) start = 0;
        Item item = array[start];
        array[start] = null;
        start++;
        n--;

        return item;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
    }

    public void print() {
        String item;
        int count_chars = 0;
        int start_marker = 0;
        for (int i = 0; i < size; i++) {
            if (i==start) start_marker = count_chars;
            if (array[i] == null) {
                if (i==end) System.out.print("[*] ");
                else System.out.print("[ ] ");
                count_chars += 4;
            } else {
                item = array[i].toString();
                System.out.print("[" + item + "]" + " ");
                count_chars += item.length() + 3;
            }
        }
        System.out.println();
        if (!isEmpty()) {
            if (start==0) start_marker = 1;

            char[] gabs = new char[start_marker];
            Arrays.fill(gabs, ' ');
            System.out.print(gabs);
            System.out.println("^");
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class CycleQueueIterator implements Iterator {
        int i = 0;
        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public Object next() {
            return array[i++];
        }
    }
}

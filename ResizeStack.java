package lb1;

import java.util.Iterator;

public class ResizeStack<Item> implements Iterable<Item> {
    private Item[] array = (Item[]) new Object[2];
    private int n;

    public ResizeStack() {
        n = 0;
    }

    public int size() {
        return n;
    }
    public int _size() {
        return array.length;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    private void resize(int new_size) {
        if (new_size < 1) return;

        Item[] temp = (Item[]) new Object[new_size];
        for (int i = 0; i < new_size; i++) {
            if (i >= n)
                temp[i] = null;
            else {
                temp[i] = array[i];
            }
        }
        array = temp;
    }

    public void push(Item elem) {
        if(n >= array.length) resize(2*array.length);
        array[n++] = elem;
    }
    public Item pop() {
        if(n-1 < array.length/4) resize(array.length/2);
        try {
            return array[--n];
        } catch (ArrayIndexOutOfBoundsException e){
            return null;
        }
    }

    private class ResizeStackIterator implements Iterator<Item> {
        private int i = n;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return array[--i];
        }

        @Override
        public void remove() {

        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ResizeStackIterator();
    }
}

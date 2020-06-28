package com.sort;

public class HashTable<Key, Value extends Comparable<Value>>
{
    private int size;
    private int n;
    private Value[] array;

    public HashTable(int size)
    {
        this.size = size;
        this.n = 0;
        array = (Value[]) new Comparable[size];
    }

    public void put(Key key, Value val)
    {
        int hash = hash(key);
        array[hash] = val;
        n++;
    }

    public Value get(Key key)
    {
        int hash = hash(key);
        return array[hash];
    }

    public int size() {
        return size;
    }

    public int amountKeys() {
        return n;
    }

    public boolean contains(Key key)
    {
        int hash = hash(key);
        return array[hash] != null;
    }

    private int hash(Key key)
    {
        int r = 31;
        return (key.hashCode() & 0x7fffffff) % size;
    }
}

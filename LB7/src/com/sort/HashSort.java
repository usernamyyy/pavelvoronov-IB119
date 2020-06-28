package com.sort;

public class HashSort
{
    private int maxHashSize;
    private HashTable<Comparable, Integer> hashAmount;

    public HashSort(int maxHashSize) {
        this.maxHashSize = maxHashSize+1;
    }

    public void sort(Comparable[] arr)
    {
        hashAmount = new HashTable<>(maxHashSize);
        for (Comparable item: arr)
            countItems(item);
        sort_(arr);
    }

    private void sort_(Comparable[] arr)
    {
        int N = arr.length;
        for (int i = 0; i < N; i++)
        {
            for (int j = i; j > 0 && over(arr[j], arr[j-1]); j--)
            {
                exch(arr, j, j - 1);
            }
        }
    }

    private void countItems(Comparable val)
    {
        int count;
        if(hashAmount.contains(val))
            count = hashAmount.get(val);
        else
            count = 0;

        hashAmount.put(val, count+1);
    }

    private void exch(Comparable[] hashQueue, int i, int j)
    {
        Comparable t = hashQueue[i];
        hashQueue[i] = hashQueue[j];
        hashQueue[j] = t;
    }

    private boolean over(Comparable a, Comparable b)
    {
        int countA = hashAmount.get(a);
        int countB = hashAmount.get(b);
        if (countA > countB)
            return true;
        else if (countA < countB)
            return false;
        else
            {
                return a.compareTo(b) < 0;
            }
    }
}

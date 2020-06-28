/*
Условие 4ой Лабораторной работы:
Даны n веревок разной длины, нам нужно соединить эти веревки в одну веревку.
Стоимость соединения двух веревок равна сумме их длин.
Нам нужно соединить веревки с минимальными затратами:
требуется вывести последовательность таких соединений и совокупную стоимость.
Чтобы получить минимальные затраты для соединения веревок всегда нужно выбирать
две веревки с наименьшими длинами.
 */
package com.Lab4_Ropes;
public class Ropes {

    public static void main(String[] args) {
	MinPQueue<Integer> minPQueue = new MinPQueue<>(100);
	Integer[] len = {1,3,5,4};
	int cost = 0;
	for (int i = 0;i<len.length;i++)
	    minPQueue.insert(len[i]);
	while (!minPQueue.isEmpty()) {
        Integer minlen1 = minPQueue.delMin();
        Integer minlen2;
        if (!minPQueue.isEmpty())
            minlen2 = minPQueue.delMin();
        else minlen2 = 0;
        cost += minlen1 + minlen2;
        if (!minPQueue.isEmpty())
            minPQueue.insert(minlen1+minlen2);
        StdOut.println("Соединить:"+minlen1+"+"+ minlen2);
    }
	StdOut.println("Total cost: "+cost);


    }
}


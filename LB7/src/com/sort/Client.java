package com.sort;

import java.util.Scanner;

public class Client
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner("1 4 5 2 6 2 4 5 2 4 5 2 5");


        ComparableString[] cs = new ComparableString[13]; //количество элементов
        for (int i = 0; i < cs.length && scan.hasNext(); i++)
        {
            cs[i] = new ComparableString(scan.next());
        }

        HashSort hs = new HashSort(1000);
        hs.sort(cs);
        System.out.println();
        for (ComparableString s: cs)
        {
            System.out.println(s);
        }
    }
}

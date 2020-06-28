package com.sort;

public class ComparableString implements Comparable<ComparableString>
{
    private String current;

    public ComparableString(String s) {
        this.current = s;
    }
    @Override
    public int compareTo(ComparableString cs)
    {
        String that = cs.toString();
        if (current.length() > that.length())
                return +1;
        else if (current.length() < that.length())
            return -1;
        else
            {
            char[] current_chars = current.toCharArray();
            char[] that_chars = that.toCharArray();
            for (int i = 0; i < current.length(); i++)
            {
                 if (current_chars[i] == that_chars[i])
                     continue;
                if (current_chars[i] > that_chars[i])
                    return +1;
                else
                    return -1;
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        return current;
    }

    @Override
    public int hashCode() {
        return current.hashCode();
    }
}

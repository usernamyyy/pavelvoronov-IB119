import java.util.Comparator;

public class Insertion {
    /*Begin
     *  S O R T E X A M P L E
     *
     *  A E E L M O P R S T X
     *
     *  bed bug dad yes zoo ... all bad yet
     *
     *  all bad bed bug dad ... yes yet zoo
     *
     *End*/
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
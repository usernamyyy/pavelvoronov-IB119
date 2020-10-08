import java.util.Comparator;

public class Selection {
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
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(a[j], a[min])) min = j;
            }
            exch(a, i, min);
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
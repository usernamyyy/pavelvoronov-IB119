public class Merge {
    /*
     * 0 1 2 3 4   5 6 7 8 9
     * E E G M R | A C E R T
     *                 ^
     * A C E E E   G M R R T
     * 0 1 2 3 4   5 6 7 8 9
     *
     * MERGESORTEXAMPLE
     * MERGESOR   TEXAMPLE
     * MERG   ESOR   TEXA   MPLE
     * ME  RG  ES  OR  TE  XA  MP  LE
     * EM  GR  ES  OR  ET  AX  MP  EL
     * ERGM   EORS   AETX   ELMP
     * EEGMORRS   AEELMPTX
     * AEEEEGLMMOPRRSTX
     * */
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];
            else if (j > hi)               a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }

    }
    public static void sort(Comparable[] a) {
        int n = a.length;
        Comparable[] aux = new Comparable[n];
        for (int len = 1; len < n; len *= 2) {
            for (int lo = 0; lo < n-len; lo += len+len) {
                int mid  = lo+len-1;
                int hi = Math.min(lo+len+len-1, n-1);
                merge(a, aux, lo, mid, hi);
            }
        }
        assert isSorted(a);
    }
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }
}
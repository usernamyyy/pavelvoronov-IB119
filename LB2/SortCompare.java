public class SortCompare{
    public static double time(String alg, Double[] a){
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Selection"))    Selection.sort(a);
        if (alg.equals("Insertion"))    Insertion.sort(a);
        if (alg.equals("Merge"))        Merge.sort(a);
        if (alg.equals("Quick"))        Quick.sort(a);
        if (alg.equals("Shell"))        Shell.sort(a);
        return timer.elapsedTime();
    }
    public static double timeRandomInput(String alg, int N, int T){
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t=0; t<T; t++){
            for (int i=0; i<N; i++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }
        long usedBytes = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        StdOut.printf("Количество памяти для %s: %d\n", alg, usedBytes/1048576);
        return total;
    }
    public static void main(String[] args){
        String alg_1="Selection";
        String alg_2="Insertion";
        String alg_3="Merge";
        String alg_4="Quick";
        String alg_5="Shell";
        int N=30000;
        int T=50;
        double t1 = timeRandomInput(alg_1,N,T);
        double t2 = timeRandomInput(alg_2,N,T);
        double t3 = timeRandomInput(alg_3,N,T);
        double t4 = timeRandomInput(alg_4,N,T);
        double t5 = timeRandomInput(alg_5,N,T);
        StdOut.printf("\nTime to sort Selection  - %.3f\nTime to sort Insertion  - %.3f\nTime to sort Merge  - %.3f\nTime to sort Quick  - %.3f\nTime to sort Shell  - %.3f\n", t1,t2,t3,t4,t5);
    }
}
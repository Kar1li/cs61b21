package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> sizes = new AList<>(), counts = new AList<>();
        AList<Double> times = new AList<>();

        for (int i = 1000; i <= 128000; i *=2)
        {
            sizes.addLast(i);
            SLList<Integer> tested = new SLList<>();
            for (int j = 0; j < i; ++j)
            {
                tested.addLast(7);
                counts.addLast(10000);
            }
            Stopwatch sw = new Stopwatch();
            for (int k = 0; k < 10000; ++k) {
                int p = tested.getLast();
            }
            double t = sw.elapsedTime();
            times.addLast(t);
        }

        printTimingTable(sizes, times, counts);

    }


}



package utils;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;

/**
 * @author lanqilu
 * @date Created in 2020/12/10  23:03
 * @description
 */
public class DoublingTest {
    public static double timeTrial(int N) {
        int MAX = 1_000_000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        Stopwatch stopwatch = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return stopwatch.elapsedTime();
    }

    public static void main(String[] args) {
        for (int N = 250; true; N += N) {
            double time = timeTrial(N);
            System.out.printf("%7d %5.1f\n", N, time);
        }
    }
}
/*
    250   0.0
    500   0.1
   1000   0.3
   2000   0.6
   4000   3.7
   8000  27.6
 */

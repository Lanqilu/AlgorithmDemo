package basics;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * @author lanqilu
 * @date 2020年07月11日  10:59
 * @description 打印N个(lo, hi)之间的随机值
 **/

public class RandomSeq {

    public static void main(String[] args) {
        //打印N个(lo, hi)之间的随机值
        int[] ns = {5, 100, 200};
        int n = ns[0];
        double lo = ns[1];
        double hi = ns[2];
        for (int i = 0; i < n; i++) {
            double x = StdRandom.uniform(lo, hi);
            StdOut.printf("%.2f\n", x);
        }
    }

}

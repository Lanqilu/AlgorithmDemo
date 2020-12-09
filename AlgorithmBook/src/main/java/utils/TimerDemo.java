package utils;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;

/**
 * @author lanqilu
 * @date Created in 2020/12/09  23:15
 * @description 计时器
 */
class TimerDemo {

    public static void main(String[] args) {

        int N = 2000;
        int[] ints = new int[N];
        for (int i = 0; i < N; i++) {
            ints[i] = StdRandom.uniform(-1_000_000, 1_000_000);
        }
        // 创建一个计时器
        Stopwatch timer = new Stopwatch();
        int count = ThreeSum.count(ints);
        // 返回对象创建以来所经历的时间
        double time = timer.elapsedTime();
        System.out.print(count + " triples " + time + " seconds");
    }

}

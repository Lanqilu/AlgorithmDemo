package api;

import edu.princeton.cs.algs4.StdStats;
import org.junit.Test;

/**
 * @author lanqilu
 * @date Created in 2020/10/18  14:54
 * @description 数据分析静态方法库的API
 */
public class StdStatsTest {
    @Test
    public void testSize() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("StdStats.max(a) = " + StdStats.max(a));
        System.out.println("StdStats.min(a) = " + StdStats.min(a));
    }

    @Test
    public void testStatistics() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // 平均值
        System.out.println("StdStats.mean(a) = " + StdStats.mean(a));
        // 采样方差
        System.out.println("StdStats.var(a) = " + StdStats.var(a));
        // 采样标准差
        System.out.println("StdStats.stddev(a) = " + StdStats.stddev(a));
    }

}

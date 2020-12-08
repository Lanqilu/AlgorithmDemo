package sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.List;

/**
 * @author lanqilu
 * @version v0.0
 * @package sort
 * @date Created in 2020/07/28  16:09
 * @description 选择排序, 找到最小的元素、与元素交换位置
 **/
public class SelectionSort {
    /**
     * 将a[]按升序排列
     **/
    public static void sort(Comparable[] a) {
        // 数组长度
        int N = a.length;
        // 将a[i]和a[i+1..N]中最小的元素交换
        for (int i = 0; i < N; i++) {
            // 最小元素的索引
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        // 在单行中打印数组
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        // 测试数组元素是否有序
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // 排序并输出
//        Comparable[] a = {1, 2, 3, 4, 3, 2, 1};
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        show(a);
        sort(a);
        assert isSorted(a);
        show(a);
    }

}

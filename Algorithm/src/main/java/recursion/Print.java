package recursion;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author lanqilu
 * @date Created in 2020/09/22  20:54
 * @description 可视化递归
 */
public class Print {
    public static void main(String[] args) {
        Print(8);
    }

    static int Print(int n) {
        if (n == 0) {
            return 0;
        }
        else {
            System.out.println(n);
            return Print(n - 1);
        }
    }
}

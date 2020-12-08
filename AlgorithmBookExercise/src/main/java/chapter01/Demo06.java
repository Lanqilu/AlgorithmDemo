package chapter01;

import edu.princeton.cs.algs4.StdOut;

/**
 * @author lanqilu
 * @date Created in 2020/08/08  14:18
 * @description
 */
public class Demo06 {
    public static void main(String[] args) {
        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            System.out.print(f+" ");
            f = f + g;
            g = f - g;
        }
    }
}

package chapter01;

import edu.princeton.cs.algs4.StdOut;
import jdk.nashorn.internal.ir.WhileNode;

/**
 * @author lanqilu
 * @date Created in 2020/08/08  14:23
 * @description
 */
public class Demo07 {
    public static void main(String[] args) {
        System.out.println("*************  1  ****************");
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001) {
            t = (9.0 / t + t) / 2;
        }
        System.out.printf("%.5f\n", t);

        System.out.println("*************  2  ****************");
        int sum1 = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0; j < i; j++) {
                sum1++;
            }
        }
        System.out.println("sum = " + sum1);

        System.out.println("*************  3  ****************");
        int sum2 = 0;
        for (int i = 1; i < 10000; i *= 2) {
            for (int j = 0; j < 1000; j++) {
                sum2++;
            }
        }
        System.out.println("sum = " + sum2);

    }
}

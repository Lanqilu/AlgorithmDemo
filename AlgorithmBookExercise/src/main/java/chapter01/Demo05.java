package chapter01;

import java.util.Scanner;

/**
 * @author lanqilu
 * @date Created in 2020/08/08  14:08
 * @description
 */
public class Demo05 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double x = Double.parseDouble(s.next());
        double y = Double.parseDouble(s.next());
        boolean flag = (0.0 < x && x < 1.0) && (0.0 < y && y < 1.0);
        if (flag) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}

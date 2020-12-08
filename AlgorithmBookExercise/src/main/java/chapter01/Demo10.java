package chapter01;

/**
 * @author lanqilu
 * @date Created in 2020/08/08  14:51
 * @description
 */
public class Demo10 {
    public static void main(String[] args) {
        int[] a = new int[20];
        for (int i = 0; i < 10; i++) {
            a[i] = i * i;
        }
        for (int i : a) {
            System.out.print(i + ",");
        }
    }
}

package chapter01;

/**
 * @author lanqilu
 * @date Created in 2020/08/08  14:00
 * @description
 */
public class Demo03 {
    public static void main(String[] args) {
        Demo03 demo3 = new Demo03();
        demo3.judge(1, 1, 1);
        demo3.judge(1, 2, 3);

    }

    public void judge(int a, int b, int c) {
        if (a == b && a == c) {
            System.out.println("equal");
        }
        else {
            System.out.println("not equal");
        }
    }
}

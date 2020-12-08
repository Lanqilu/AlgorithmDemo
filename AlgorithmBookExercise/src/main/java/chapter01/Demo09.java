package chapter01;

/**
 * @author lanqilu
 * @date Created in 2020/08/08  14:35
 * @description 将正整数N转变成二级制且用String类型表示
 */
public class Demo09 {
    public static void main(String[] args) {
        int N = 3546;
        System.out.println(Integer.toBinaryString(N));
        String s = "";
        for (int n = N; n > 0; n /= 2) {
            s = (n % 2) + s;
        }
        System.out.println(s);
    }
}

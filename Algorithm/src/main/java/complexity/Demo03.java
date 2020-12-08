package complexity;

/**
 * @author lanqilu
 * @date Created in 2020/09/11  22:11
 * @description 加法法则
 */
public class Demo03 {
    public static void main(String[] args) {
        System.out.println("cal(3) = " + cal(3));
    }

    private static int cal(int n) {
        int sum1 = 0;
        int p = 1;
        for (; p < 100; ++p) {
            sum1 = sum1 + p;
        }

        int sum2 = 0;
        int q = 1;
        for (; q < n; ++q) {
            sum2 = sum2 + q;
        }

        int sum3 = 0;
        int i = 1;
        int j = 1;
        for (; i <= n; ++i) {
            j = 1;
            for (; j <= n; ++j) {
                sum3 = sum3 + i * j;
            }
        }

        return sum1 + sum2 + sum3;
    }

}

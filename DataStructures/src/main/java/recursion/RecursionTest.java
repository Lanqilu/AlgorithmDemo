package recursion;

/**
 * @Author Halo
 * @Create 2021-03-10 下午 11:53
 * @Description
 */
public class RecursionTest {
    public static void main(String[] args) {
        test(4);
        int factorial = factorial(3);
        System.out.println(factorial);

    }

    public static void test(int n) {
        if (n > 2) {
            test(n - 1);
        }
        System.out.println("n = " + n);
    }

    /**
     * 阶乘
     * @param n 阶乘数
     * @return 阶乘结果
     */
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        else {
            return factorial(n - 1) * n;
        }
    }
}



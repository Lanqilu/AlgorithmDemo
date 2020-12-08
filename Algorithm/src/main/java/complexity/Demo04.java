package complexity;

/**
 * @author lanqilu
 * @date Created in 2020/09/11  22:44
 * @description 乘法法则
 */
public class Demo04 {
    public static void main(String[] args) {
        System.out.println("cal(3) = " + cal(3));
    }

    private static int cal(int n) {
        int ret = 0;
        int i = 1;
        for (; i < n; ++i) {
            ret = ret + f(i);
        }
        return ret;
    }

    private static int f(int n) {
        int sum = 0;
        int i = 1;
        for (; i < n; ++i) {
            sum = sum + i;
        }
        return sum;
    }
}

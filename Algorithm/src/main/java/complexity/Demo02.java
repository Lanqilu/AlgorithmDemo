package complexity;

/**
 * @author lanqilu
 * @date Created in 2020/09/11  21:55
 * @description complexity O(n^2)
 */
public class Demo02 {
    public static void main(String[] args) {
        System.out.println("cal(3) = " + cal(3));
    }

    private static int cal(int n) {
        int sum = 0;
        int i = 1;
        int j = 1;
        for (; i <= n; ++i) {
            j = 1;
            for (; j <= n; ++j) {
                sum = sum + i * j;
            }
        }
        return sum;
    }

}

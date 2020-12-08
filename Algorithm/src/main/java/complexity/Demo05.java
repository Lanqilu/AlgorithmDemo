package complexity;

/**
 * @author lanqilu
 * @date Created in 2020/09/11  22:47
 * @description
 */
public class Demo05 {
    public static void main(String[] args) {
        System.out.println("cal(3) = " + cal(3, 4));
    }


    private static int cal(int m, int n) {
        int sum_1 = 0;
        int i = 1;
        for (; i < m; ++i) {
            sum_1 = sum_1 + i;
        }

        int sum_2 = 0;
        int j = 1;
        for (; j < n; ++j) {
            sum_2 = sum_2 + j;
        }

        return sum_1 + sum_2;
    }
}

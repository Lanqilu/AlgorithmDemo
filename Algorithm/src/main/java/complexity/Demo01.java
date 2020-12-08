package complexity;


/**
 * @author lanqilu
 * @date Created in 2020/09/11  21:44
 * @description complexity O(n)
 */
public class Demo01 {
    public static void main(String[] args) {
        System.out.println("cal(3) = " + cal(3));
    }

    private static int cal(int n) {
        int sum = 0;
        int i = 1;
        for (; i <= n; ++i) {
            sum = sum + i;
        }
        return sum;
    }

}

package complexity;

/**
 * @author lanqilu
 * @date Created in 2020/09/11  22:49
 * @description
 */
public class Demo06 {
    public static void main(String[] args) {
        print(5);
    }
    private static void print(int n) {
        int i = 0;
        int[] a = new int[n];
        for (; i <n; ++i) {
            a[i] = i * i;
        }

        for (i = n-1; i >= 0; --i) {
            System.out.println(a[i]);
        }
    }
}

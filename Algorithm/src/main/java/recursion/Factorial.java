package recursion;

/**
 * @author lanqilu
 * @date Created in 2020/09/22  20:49
 * @description 递归解决阶乘
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println("Fact(4) = " + Fact(4));
    }



    static int Fact(int n) {
        if (n == 1) {
            return 1;
        }
        else if (n == 0) {
            return 1;
        }
        else {
            return n * Fact(n - 1);
        }
    }
}

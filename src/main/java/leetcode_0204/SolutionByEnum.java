package leetcode_0204;

/**
 * @author lanqilu
 * @date Created in 2020/12/03  21:45
 * @description 质数计数
 * 枚举法实现,会超时
 */
class SolutionByEnum {

    public int countPrimes(int n) {
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean isPrime(int num) {
        int max = (int) Math.sqrt(num);
        for (int i = 2; i <= max; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

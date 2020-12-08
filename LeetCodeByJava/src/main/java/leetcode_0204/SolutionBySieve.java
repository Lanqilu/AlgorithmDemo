package leetcode_0204;

import java.util.Arrays;

/**
 * @author lanqilu
 * @date Created in 2020/12/03  22:03
 * @description 质数计数
 * <p>
 * 使用埃拉托斯特尼筛法
 */
class SolutionBySieve {
    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        // 从2开始枚举到sqrt(n)
        for (int i = 2; i * i < n; i++) {
            if (isPrim[i]) {
                // 就把从 i*i 开始，i 的所有倍数都设置为 false。
                for (int j = i * i; j < n; j += i) {
                    isPrim[j] = false;
                }
            }
        }
        //计数
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}

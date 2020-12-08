package leetcode_0204;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lanqilu
 * @date Created in 2020/12/03  22:52
 * @description 线性筛
 * <p>
 * 用空间换时间
 */
class SolutionByEuler {
    public int countPrimes(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; ++j) {
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0) {
                    break;
                }
            }
        }
        return primes.size();
    }
}



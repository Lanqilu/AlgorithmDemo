package search;

import java.util.Arrays;

/**
 * @Author Halo
 * @Create 2021-03-14 下午 07:20
 * @Description 斐波那契查找 TODO 需理解
 */
public class FibonacciSearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int index = new FibonacciSearch().search(arr, 8);
        System.out.println(index);

    }

    private static int maxSize = 20;

    /**
     * 得到一个斐波那契数列
     *
     * @return 斐波那契数列
     */
    public int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    public int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        // 分割值的下标
        int k = 0;
        int mid = 0;
        int[] f = fib();
        while (right > f[k] - 1) {
            k++;
        }
        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i = right + 1; i < temp.length; i++) {
            temp[i] = arr[right];
        }

        while (left <= right) {
            mid = left + f[k - 1] - 1;
            if (target < temp[mid]) {
                right = mid - 1;
                k--;
            }
            else if (target > temp[mid]) {
                left = mid + 1;
                k -= 2;
            }
            else {
                if (mid <= right) {
                    return mid;
                }
                else {
                    return right;
                }
            }
        }

        return -1;
    }
}

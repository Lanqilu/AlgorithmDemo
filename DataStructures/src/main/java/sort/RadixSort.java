package sort;

import java.util.Arrays;

/**
 * @Author Halo
 * @Create 2021-03-14 下午 04:14
 * @Description 基数排序 平均O(n×k) 最好O(n×k) 最坏O(n×k) 空间O(n×k) 稳定 占用额外空间
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        RadixSort radixSort = new RadixSort();
        int[] ints = radixSort.toSort(arr);
        System.out.println(Arrays.toString(ints));
    }

    public int[] toSort(int[] arr) {
        // 定义一个二维数组,表示十个桶
        int[][] bucket = new int[10][arr.length];
        // 定义一维数组记录每个桶每次放入的数据个数
        int[] bucketElementCounts = new int[10];
        int index = 0;

        // 得到数组中最大的数的位数
        int max = arr[0];
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        int maxLength = (max + "").length();

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int value : arr) {
                // 取出每个元素的最后一位
                int digitOfElement = value / n % 10;
                // 放入对应桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = value;
                bucketElementCounts[digitOfElement]++;
            }
            index = 0;
            // 按照桶的顺序放入原来的数组中
            for (int k = 0; k < bucketElementCounts.length; k++) {
                // 桶中有数据
                if (bucketElementCounts[k] != 0) {
                    // 循环第k桶
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketElementCounts[k] = 0;
            }
        }
        return arr;
    }


}

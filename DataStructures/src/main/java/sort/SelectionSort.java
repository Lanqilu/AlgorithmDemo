package sort;

import java.util.Arrays;

/**
 * @Author Halo
 * @Create 2021-03-13 下午 04:40
 * @Description 选择排序 平均O(n^2) 最好O(n^2) 最坏O(n^2) 空间O(1) 不稳定 不占用额外空间
 */
public class SelectionSort {

    public int[] toSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            // 寻找最小值
            int minIndex = i;
            int min = arr[minIndex];
            for (int j = 1 + minIndex; j < arr.length; j++) {
                // 寻找最小值
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                // 将最小值放到前面
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        SelectionSort selectionSort = new SelectionSort();
        int[] ints = selectionSort.toSort(arr);
        System.out.println(Arrays.toString(ints));
    }
}

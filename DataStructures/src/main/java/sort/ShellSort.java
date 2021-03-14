package sort;

import java.util.Arrays;

/**
 * @Author Halo
 * @Create 2021-03-13 下午 10:14
 * @Description 希尔排序 平均O(n log n) 最好O(n log^2 n) 最坏O(n log^2 n) 空间O(1) 不稳定 不占用额外空间
 */
public class ShellSort {


    public int[] toSortByExchange(int[] arr) {

        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // 步长gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }
        return arr;
    }

    public int[] toSortByRemove(int[] arr) {

        int index = 0;
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                index = i;
                temp = arr[index];
                if (arr[index] < arr[index - gap]) {
                    while (index - gap >= 0 && temp < arr[index - gap]) {
                        // 移动
                        arr[index] = arr[index - gap];
                        index -= gap;
                    }
                    arr[index] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        ShellSort shellSort = new ShellSort();
        int[] ints = shellSort.toSortByExchange(arr);
        int[] ints1 = shellSort.toSortByRemove(arr);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints1));

    }
}

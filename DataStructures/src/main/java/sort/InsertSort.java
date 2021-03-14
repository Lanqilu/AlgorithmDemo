package sort;

import java.util.Arrays;

/**
 * @Author Halo
 * @Create 2021-03-13 下午 05:14
 * @Description 插入排序 平均O(n^2) 最好O(n) 最坏O(n^2) 空间O(1) 稳定 不占用额外空间
 */
public class InsertSort {

    public int[] toSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i - 1;

            // 找到插入的位置
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertVal + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }

        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 4, 5, 9, 7, -2, 4};
        InsertSort insertSort = new InsertSort();
        int[] ints = insertSort.toSort(arr);
        System.out.println(Arrays.toString(ints));
    }
}

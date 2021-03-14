package sort;

import java.util.Arrays;

/**
 * @Author Halo
 * @Create 2021-03-13 下午 10:57
 * @Description 快速排序 平均O(n log n) 最好O(n log n) 最坏O(n^2) 空间O(log n) 不稳定 不占用额外空间
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70};
        QuickSort quickSort = new QuickSort();
        int[] ints = quickSort.toSort(arr);
        System.out.println(Arrays.toString(ints));
    }

    public int[] toSort(int[] arr) {
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        return toSort(arr, leftIndex, rightIndex);
    }

    public int[] toSort(int[] arr, int leftIndex, int rightIndex) {
        int l = leftIndex;
        int r = rightIndex;
        int temp = 0;
        // 中间值
        int pivot = arr[(l + r) / 2];
        while (l < r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        if (l == r) {
            l++;
            r--;
        }

        if (leftIndex < r) {
            toSort(arr, leftIndex, r);
        }

        if (rightIndex > l) {
            toSort(arr, l, rightIndex);
        }

        return arr;
    }
}

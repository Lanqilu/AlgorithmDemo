package sort;

import edu.princeton.cs.algs4.TopM;

import java.util.Arrays;

/**
 * @Author Halo
 * @Create 2021-03-14 下午 03:30
 * @Description 归并排序 平均O(n log n) 最好O(n log n) 最坏O(n log n) 空间O(n) 稳定 占用额外空间
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2, 0};
        MergeSort mergeSort = new MergeSort();
        int[] ints = mergeSort.toSort(arr);
        System.out.println(Arrays.toString(ints));
    }

    public int[] toSort(int[] arr) {
        int[] temp = new int[arr.length];
        return toSort(arr, 0, arr.length - 1, temp);
    }

    public int[] toSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            toSort(arr, left, mid, temp);
            toSort(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);
        }

        return arr;
    }

    /**
     * 合并方法
     */
    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 左边有序序列的初始索引
        int i = left;
        // 右边有序序列的初始索引
        int j = mid + 1;
        // 指向temp数组的当前索引
        int t = 0;

        // 把左右两边的有序数据按照规则填充到temp数组
        // 直到左右两边中，有一边处理完成
        while (i <= mid && j <= right) {
            // 左边小于右边,拷贝到temp,并后移指针
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
            }
            else {
                temp[t] = arr[j];
                j++;
            }
            t++;
        }
        // 如果那一边有剩余，将剩余部分数据依次全部填充到temp数组中
        while (i <= mid) {
            // 左边有剩余
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            // 右边剩余
            temp[t] = arr[j];
            t++;
            j++;
        }
        // 将temp数组拷贝到arr
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }

}

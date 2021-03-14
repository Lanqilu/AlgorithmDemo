package sort;

import java.util.Arrays;

/**
 * @Author Halo
 * @Create 2021-03-13 下午 03:50
 * @Description 冒泡排序 平均O(n^2) 最好O(n) 最坏O(n^2) 空间O(1) 稳定 不占用额外空间
 */
public class BubbleSort {

    public int[] toSort(int[] arr) {
        int temp = 0;
        // 表示是否发生交换
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 如果前面的数大则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if (!flag) {
                break;
            }
            else {
                flag = false;
            }
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = {3, 10, -1, 9, 2, 5};
        BubbleSort bubbleSort = new BubbleSort();
        int[] ints = bubbleSort.toSort(arr);
        System.out.print("最后结果: ");
        System.out.println(Arrays.toString(ints));
    }

}

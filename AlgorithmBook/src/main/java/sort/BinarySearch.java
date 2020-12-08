package sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;

/**
 * @author lanqilu
 * @date Created in 2020/08/08  10:58
 * @description 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] whitelist = {84, 48, 68, 10, 18, 98, 12, 23, 54, 57, 33, 16, 77, 11, 29};
        // 对数组进行排序
        Arrays.sort(whitelist);
        // 打印排序结果
        for (int i : whitelist) {
            System.out.print(i + ",");
        }
        System.out.println();
        // 需要查找的值
        int key = 84;
        // rank函数使用二分查找
        int result = rank(key, whitelist);
        if (result < 0) {
            System.out.println(key + " :未在此数组中");
        }
        else {
            System.out.println("已查询到: " + key);
            System.out.println("索引为  : " + result);
        }
    }

    /**
     * 使用二分查找，返回值在目标数组的位置
     * <p>如果存在返回在目标数组的索引，否则返回-1</p>
     * 注意目标数组需是有序数组
     *
     * @param key: 需要查找的值
     * @param a:   目标数组
     * @return int
     **/
    public static int rank(int key, int[] a) {
        // 头部索引
        int lo = 0;
        // 尾部索引
        int hi = a.length - 1;

        while (lo <= hi) {
            // 中点索引
            int mid = lo + (hi - lo) / 2;
            // key小于中位值则尾部索引变为中点索引，进行二分
            if (key < a[mid]) {
                hi = mid - 1;
            }
            // 同理如果大于，头部索引变为中点
            else if (key > a[mid]) {
                lo = mid + 1;
            }
            // 如果等于，即找到返回索引值
            else {
                return mid;
            }
        }
        // 不存在返回-1
        return -1;
    }


}

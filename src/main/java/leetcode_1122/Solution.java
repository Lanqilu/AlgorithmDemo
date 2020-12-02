package leetcode_1122;

import java.util.*;


/**
 * @author lanqilu
 * @date Created in 2020/11/14  18:33
 * @description 数组的相对排序
 * <p>
 * 使用哈希表, 桶排序思想
 */
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : arr1) {
            list.add(num);
        }

        Collections.sort(list, (x, y) -> {
            if (map.containsKey(x) || map.containsKey(y)) {
                return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            }
            return x - y;
        });
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }

    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] save = new int[1001];
        for (int i : arr1) {
            save[i]++;
        }
        int j = 0;
        return null;
    }


    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};

        Solution solution1 = new Solution();
        int[] ints = solution1.relativeSortArray(arr1, arr2);
        for (int i : ints) {
            System.out.println(i);
        }

    }
}



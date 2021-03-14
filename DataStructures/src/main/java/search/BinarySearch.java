package search;

import sort.QuickSort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author Halo
 * @Create 2021-03-14 下午 06:18
 * @Description 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-1, 4, 6, 7, 32, 35, 43, 5, 456, 54, 6, 5};
        QuickSort quickSort = new QuickSort();
        quickSort.toSort(arr);
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        BinarySearch binarySearch = new BinarySearch();
        int index = binarySearch.search(arr, 5);
        ArrayList<Integer> list = binarySearch.searchAll(arr, 5);
        System.out.println(list.toString());
        System.out.println(index);

    }

    public int search(int[] arr, int left, int right, int target) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (target > midVal) {
            return search(arr, mid + 1, right, target);
        }
        else if (target < midVal) {
            return search(arr, left, mid - 1, target);
        }
        else {
            return mid;
        }
    }

    public int search(int[] arr, int target) {
        return search(arr, 0, arr.length - 1, target);
    }

    public ArrayList<Integer> searchAll(int[] arr, int target) {
        return searchAll(arr, 0, arr.length - 1, target);
    }

    public ArrayList<Integer> searchAll(int[] arr, int left, int right, int target) {

        if (left > right) {
            return new ArrayList<Integer>();
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (target > midVal) {
            return searchAll(arr, mid + 1, right, target);
        }
        else if (target < midVal) {
            return searchAll(arr, left, mid - 1, target);
        }
        else {
            ArrayList<Integer> resIndexList = new ArrayList<>();
            int temp = mid - 1;
            while (temp >= 0 && arr[temp] == target) {
                resIndexList.add(temp);
                temp--;
            }
            resIndexList.add(mid);
            temp = mid + 1;
            while (temp <= arr.length - 1 && arr[temp] == target) {
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }
    }

}


package search;

/**
 * @Author Halo
 * @Create 2021-03-14 下午 07:02
 * @Description 查值查找
 */
public class InterpolationSearch {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        int index = new InterpolationSearch().search(arr, 2);
        System.out.println("index = " + index);
    }

    public int search(int[] arr, int target) {
        return search(arr, 0, arr.length - 1, target);

    }

    public int search(int[] arr, int left, int right, int target) {

        if (left > right || target < arr[0] || target > arr[arr.length - 1]) {
            return -1;
        }

        int mid = left + (right - left) * (target - arr[left]) / (arr[right] - arr[left]);
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


}

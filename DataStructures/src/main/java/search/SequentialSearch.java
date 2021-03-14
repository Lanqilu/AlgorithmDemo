package search;

/**
 * @Author Halo
 * @Create 2021-03-14 下午 06:13
 * @Description 顺序查找
 */
public class SequentialSearch {

    public static void main(String[] args) {
        int[] arr = {-1, 4, 6, 7, 32, 35, 43, 5, 456, 54, 6, 5};
        SequentialSearch sequentialSearch = new SequentialSearch();
        int index = sequentialSearch.search(arr, 35);
        System.out.println(index);

    }

    public int search(int[] arr,int target){
        int index;
        for (index = 0; index < arr.length; index++) {
            if (arr[index] == target) {
                return index;
            }
        }
        return -1;
    }
}

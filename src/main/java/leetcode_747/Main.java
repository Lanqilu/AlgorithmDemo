package leetcode_747;

/**
 * @author lanqilu
 * @date Created in 2020/12/03  23:24
 * @description
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {3, 6, 1, 0};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {0, 0, 3, 2};

        System.out.println(solution.dominantIndex(nums1));
        System.out.println(solution.dominantIndex(nums2));
        System.out.println(solution.dominantIndex(nums3));
    }
}

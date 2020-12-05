package leetcode_0001;

/**
 * @author lanqilu
 * @date Created in 2020/12/04  23:50
 * @description 两数之和
 *
 * 暴力枚举
 */
class SolutionByEnum {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}

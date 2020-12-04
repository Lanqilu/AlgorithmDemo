package leetcode_747;

/**
 * @author lanqilu
 * @date Created in 2020/12/04  22:25
 * @description
 */
class Solution {
    public int dominantIndex(int[] nums) {
        int max = 0;
        boolean pin = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[max] < nums[i]) {
                if (nums[i] >= nums[max] * 2) {
                    pin = true;
                }
                else {
                    pin = false;
                }
                max = i;
            }
            else {
                if (nums[max] < nums[i] * 2) {
                    pin = false;
                }
            }
        }
        if (pin) {
            return max;
        }
        else {
            return -1;
        }
    }
}


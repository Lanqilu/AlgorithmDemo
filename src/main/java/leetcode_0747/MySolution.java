package leetcode_0747;

/**
 * @author lanqilu
 * @date Created in 2020/12/03  23:18
 * @description 至少是其他数字两倍的最大数
 */
class MySolution {
    public int dominantIndex(int[] nums) {

        int max = 0;
        int lmax = 0;
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                lmax = max;
                max = nums[i];
                index = i;
            }
            if (nums[nums.length - 1] > lmax) {
                lmax = nums[nums.length - 1];
            }
        }

        if (lmax * 2 > max) {
            return -1;
        }
        else {
            return index;
        }

    }
}

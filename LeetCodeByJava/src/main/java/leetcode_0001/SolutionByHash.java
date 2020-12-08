package leetcode_0001;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lanqilu
 * @date Created in 2020/12/05  19:31
 * @description 使用哈希表
 */
class SolutionByHash {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}

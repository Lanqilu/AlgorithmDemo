package leetcode_0014;

/**
 * @author lanqilu
 * @date Created in 2020/12/07  21:44
 * @description
 */
class SolutionByCompare {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        // 初始化ans为第一个字符串
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            for (; j < ans.length() && j < strs[i].length(); j++) {
                if (ans.charAt(j) != strs[i].charAt(j)) {
                    break;
                }
                ans = ans.substring(0, j);
                if (ans.equals("")) {
                    return ans;
                }
            }
        }
        return ans;
    }

}

package leetcode_0014;

/**
 * @author lanqilu
 * @date Created in 2020/12/05  19:52
 * @description 使用横向扫描的方法
 */
class SolutionByTransverse {
    public String longestCommonPrefix(String[] strs) {
        int count = strs.length;
        if (count == 0) {
            return "";
        }
        // 前缀
        String prefix = strs[0];
        for (int i = 0; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    private String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        // 返回从0开始到index的字符串
        return str1.substring(0, index);
    }

}

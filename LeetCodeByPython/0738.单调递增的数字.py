# -*- coding: utf-8 -*-
"""
@author lanqilu
@date Created in 2020/12/15  21:56
@file 0738.单调递增的数字.py
@description 
"""

"""
给定一个非负整数N，找出小于或等于N的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。

（当且仅当每个相邻位数上的数字x和y满足x <= y时，我们称这个整数是单调递增的。）

示例 1:
输入: N = 10
输出: 9

示例 2:
输入: N = 1234
输出: 1234

示例 3:
输入: N = 332
输出: 299

说明: N是在[0, 10^9]范围内的一个整数。

链接：https://leetcode-cn.com/problems/monotone-increasing-digits
"""


# https://leetcode-cn.com/problems/monotone-increasing-digits/solution/1111lei-jia-fa-by-wincss-zt83/
def monotoneIncreasingDigits(N):
    """
    :type N: int
    :rtype: int
    """
    ones = 111111111
    result = 0
    for _ in range(9):
        while result + ones > N:
            ones //= 10
        result += ones
    return result


if __name__ == '__main__':
    print(monotoneIncreasingDigits(10))
    print(monotoneIncreasingDigits(1234))
    print(monotoneIncreasingDigits(332))

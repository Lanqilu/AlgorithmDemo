# -*- coding: utf-8 -*-
"""
@author lanqilu
@date Created in 2020/12/11  23:48
@file 0009.回文数.py
@description 
"""


class Solution(object):
    @staticmethod
    def is_palindrome(x: int) -> bool:
        # 将int类型转换成string类型
        s = str(x)
        index = len(s) - 1
        # 利用string类型的遍历
        for i in range(len(s) // 2):
            if s[i] == s[index]:
                index -= 1
                continue
            else:
                return False
        return True

    @staticmethod
    def is_palindrome_simplify(x: int) -> bool:
        return False if x < 0 else (x == int(str(x)[::-1]))


if __name__ == '__main__':
    s = Solution()
    print(s.is_palindrome(121))
    print(s.is_palindrome(-121))
    print(s.is_palindrome(12345))

    print(s.is_palindrome_simplify(121))
    print(s.is_palindrome_simplify(-121))
    print(s.is_palindrome_simplify(12145))


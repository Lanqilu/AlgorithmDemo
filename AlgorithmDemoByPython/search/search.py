# -*- coding: utf-8 -*-
"""
@author lanqilu
@date Created in 2020/12/11  00:30
@file search.py
@description 线性搜索
"""
from typing import List


class Search(object):
    @staticmethod
    def linear_search(nums: List[int], target: int):
        for i in range(len(nums)):
            if nums[i] == target:
                return i
        return None

    @staticmethod
    def binary_search(nums: List[int], target: int):
        # low和high用于跟踪要在其中查找的列表部分
        low = 0
        high = len(nums) - 1
        # 不断将范围缩小直至只有一个元素
        while low <= high:
            # 检查中间元素
            mid = (low + high) // 2
            guess = nums[mid]
            if guess == target:
                return mid
            if guess > target:
                high = mid - 1
            else:
                low = mid + 1
        return None


if __name__ == '__main__':
    s = Search()
    # 线性搜索测试
    print(s.linear_search([1, 2, 3, 4, 5], 6))  # None
    print(s.linear_search([1, 2, 3, 4, 5], 5))  # 4
    # 二分查找测试
    my_list = [1, 3, 5, 7, 9]
    print(s.binary_search(my_list, 3))  # 1
    print(s.binary_search(my_list, -1))  # None

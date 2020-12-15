# -*- coding: utf-8 -*-
"""
@author lanqilu
@date Created in 2020/12/11  22:58
@file Sort.py
@description 
"""
from typing import List


# 选择排序
def select_sort(nums: List[int]) -> List[int]:
    suffix_start = 0
    while suffix_start != len(nums):
        for i in range(suffix_start, len(nums)):
            if nums[i] < nums[suffix_start]:
                # 交换元素位置
                nums[suffix_start], nums[i] = nums[i], nums[suffix_start]
        suffix_start += 1
    return nums


# 归并排序
def merge_sort(nums, compare=lambda x, y: x < y):
    """假设L是列表，compare定义了nums中元素的排序规则
    返回一个新的具有nums中相同元素的有序列表。"""
    if len(nums) < 2:
        return nums[:]
    else:
        middle = len(nums) // 2
        left = merge_sort(nums[:middle], compare)
        right = merge_sort(nums[middle:], compare)
        return merge(left, right, compare)


def merge(left, right, compare):
    """假设left和right是两个有序列表，compare定义了一种元素排序规则
    返回一个新的有序列表（按照compare定义的顺序），其中包含与（left+right）相同的元素。"""
    result = []
    i, j = 0, 0
    while i < len(left) and j < len(right):
        if compare(left[i], right[j]):
            result.append(left[i])
            i += 1
        else:
            result.append(right[j])
            j += 1
    while i < len(left):
        result.append(left[i])
        i += 1
    while j < len(right):
        result.append(right[j])
        j += 1
    return result


if __name__ == '__main__':
    lists = [1, 5, 3, 6, 8, 9, 7, 4, 5, 5, 7, 8, 9, 4, 6, 7, 8, 0]
    print(select_sort(lists))
    print(merge_sort(lists))
    print(merge_sort(lists, lambda x, y: x > y))

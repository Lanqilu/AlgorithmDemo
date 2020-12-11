# -*- coding: utf-8 -*-
"""
@author lanqilu
@date Created in 2020/12/11  22:58
@file sort.py
@description 
"""
from typing import List


class Sort(object):
    @staticmethod
    # 选择排序
    def select_sort(lists: List[int]) -> List[int]:
        suffix_start = 0
        while suffix_start != len(lists):
            for i in range(suffix_start, len(lists)):
                if lists[i] < lists[suffix_start]:
                    # 交换元素位置
                    lists[suffix_start], lists[i] = lists[i], lists[suffix_start]
            suffix_start += 1


if __name__ == '__main__':
    s = Sort()
    lists = [1, 5, 3, 6, 8, 9, 7, 4, 5, 5, 7, 8, 9, 4, 6, 7, 8, 0]
    s.select_sort(lists)
    print(lists)

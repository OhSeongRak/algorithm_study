from typing import List
from collections import defaultdict


class Solution:
    def countNicePairs(self, nums: List[int]) -> int:
        def rev(num):
            return int(str(num)[::-1])

        def n_Combination_2(num):
            return num * (num-1) // 2

        reverse, pairs = defaultdict(int), 0

        # num1 + rev(num2) == num2 + rev(num1)
        # => num1 - rev(num1) == num2 - rev(num2)
        for num in nums:
            # {num-rev(num): number of keys}
            reverse[num-rev(num)] += 1

        return sum(n_Combination_2(v) for v in reverse.values()) % (10**9 + 7)

from typing import List, Any, Union
from heapq import *

# list slicing => WA
# [0, -1, -2, -3, 1], k = 2
class Solution:
    def maxResult(self, nums: List[int], k: int) -> int:
        # if window = numset = list(enumerate(nums)), window and numset have the same reference
        # in that case, numset does not retain the original list
        window = list(enumerate(nums))
        numset = list(enumerate(nums))
        score = 0

        while True:
            score += window.pop(0)[1]
            if window:
                if not all(v < 0 for v in list(zip(*window[:k]))[1]):
                    line = next(i for i, v in window if v > 0)
                    window = numset[line:]
                else:
                    window = numset[max(window[:k], key=lambda x: x[1])[0]:]
                continue
            break

        return score


# DFS => TLE
# not CSP, no need backtracking
class Solution2:
    def maxResult(self, nums: List[int], k: int) -> int:
        all = []

        def dfs(index, path):
            if path == nums[-1]:
                # all <- sum of score
                return
            for i in range(index, len(nums)):
                dfs(i+1, path+k)

            return all

        return max(dfs)


# sliding window and heap
class Solution3:
    def maxResult1(self, nums: List[int], k: int) -> int:
        subsum = [0 for _ in range(len(nums))]
        subsum[0] = nums[0]

        for i in range(1, len(nums)):
            subsum[i] = nums[i] + max(subsum[max(0, i-k):i])  # continually calculate => TLE

        return subsum[-1]

    def maxResult2(self, nums: List[int], k: int) -> int:
        subsum = [0 for _ in range(len(nums))]
        subsum[0] = nums[0]
        heap = []
        heappush(heap, (-nums[0], 0))

        if len(nums) == 1:
            return nums[0]
        for i in range(1, len(nums)):
            while heap and heap[0][1] < i - k:
                heappop(heap)

            subsum[i] = -nums[i] + heap[0][0]
            heappush(heap, (subsum[i], i))

        return -subsum[-1]
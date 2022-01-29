from typing import *
import random

# TLE
# def triangleNumber(nums: List[int]) -> int:
#     nums.sort()
#     cnt = 0
#     for i in range(len(nums)):
#         for j in range(i + 1, len(nums) - 1):
#             k = j + 1
#             while k < len(nums) and nums[i] + nums[j] > nums[k]:
#                 cnt += 1
#                 k += 1
#
#     return cnt

def triangleNumber(nums: List[int]) -> int:
    nums.sort()
    count = 0
    for i in range(2, len(nums)):
        long_side, left, right = nums[i], 0, i - 1

        while left < right:
            if nums[left] + nums[right] <= long_side:
                left += 1
            else:
                count += right - left
                right -= 1

    return count

nums = [4,2,3,4]
#nums = [1, 4, 10, 12, 14, 19, 26, 31, 35, 44]

print(triangleNumber(nums))

from typing import *


class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        
        maxList = []
        maxList.append(nums[0])
        maxList.append(max(nums[0], nums[1]))

        for i in range(2, len(nums)):
            maxList.append(max(maxList[i - 1], maxList[i - 2] + nums[i]))

        return maxList[-1]

sol = Solution()
nums = [17, 11, 9, 4, 15, 12, 18, 8, 7, 8]

print(sol.rob(nums))

# import random
#
# list = []
#
# for i in range(10):
#     list.append(random.randrange(1, 20))
#
# print(list)

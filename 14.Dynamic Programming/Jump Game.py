from typing import *

class Solution:
    def canJump(self, nums: List[int]) -> bool:
        if len(nums) == 1:
            return True

        maxPos = nums[0]

        for cur in range(1, len(nums)):
            if maxPos >= len(nums) - 1:
                return True
            if cur > maxPos:
                return False

            maxPos = max(maxPos, cur + nums[cur])

        return False

sol = Solution()
nums = [3,2,1,1,4]
print(sol.canJump(nums))
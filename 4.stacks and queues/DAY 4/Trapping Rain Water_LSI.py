from lib import *

# two pointer
class Solution:
    def trap(self, height: List[int]) -> int:
        left, right = 0, len(height) - 1
        left_max, right_max = height[left], height[right]
        level = 0

        # left and right pointer moves right and left up to the maximum height
        # because pointer moves to maximum, the lower heights will be filled.
        # so if left_max > height[left], level increase by left_max - height[left]. the same for right
        while left != right:  # will be equal to the maximum height
            left_max = max(left_max, height[left])
            right_max = max(right_max, height[right])

            if left_max < right_max:
                level += left_max - height[left]
                left += 1
            else:
                level += right_max - height[right]
                right -= 1

        return level

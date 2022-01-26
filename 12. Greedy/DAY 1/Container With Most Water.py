from typing import *

def maxArea(height: List[int]) -> int:
    l, r = 0, len(height) - 1
    area = 0

    while l < r:
        lHeight = height[l]
        rHeight = height[r]
        area = max(area, min(lHeight, rHeight) * (r - l))

        if lHeight < rHeight:
            l += 1
        elif lHeight > rHeight:
            r -= 1
        else:
            l += 1
            r -= 1

    return area

height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
print(maxArea(height))
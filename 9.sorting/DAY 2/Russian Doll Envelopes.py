from typing import *
from bisect import bisect_left

def maxEnvelopes(E: List[List[int]]) -> int:
    E.sort(key=lambda x: (x[0], -x[1]))
    print(E)
    dp = []
    for _, height in E:
        left = bisect_left(dp, height)
        if left == len(dp):
            dp.append(height)
        else:
            dp[left] = height
    return len(dp)

envelopes = [[3,200],[4,500],[5,500],[2,400],[5,250],[5,100],[6,360],[6,370],[7,380]]

print(maxEnvelopes(envelopes))

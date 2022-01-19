from typing import *

def longestArithSeqLength(A):
    
    dp = {}
    for start in range(len(A)):
        for end in range(start + 1, len(A)):
            dp[(end, A[end] - A[start])] = dp.get((start, A[end] - A[start]), 1) + 1
    return max(dp.values())

nums = [9,4,7,2,10]
print(longestArithSeqLength(nums))

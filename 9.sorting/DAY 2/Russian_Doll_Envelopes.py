from typing import List
from bisect import bisect_left


class Solution:
    def maxEnvelopes(self, envelopes: List[List[int]]) -> int:
        envelopes.sort(key=lambda x: [x[0], -x[1]])
        lis = [envelopes[0][1]]

        for _, height in envelopes:
            if height > lis[-1]:
                lis.append(height)
            else:
                index = bisect_left(lis, height)
                lis[index] = height

        return len(lis)
    
    

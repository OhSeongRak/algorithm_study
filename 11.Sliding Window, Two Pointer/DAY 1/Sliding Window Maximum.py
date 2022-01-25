from typing import *
from collections import deque

# def maxSlidingWindow(nums: List[int], k: int) -> List[int]:
#
#     deq = deque()
#     answer = []
#
#     for i in range(len(nums)):
#
#         if len(deq) == k:
#             deq.popleft()
#
#         while deq and deq[-1] < nums[i]:
#             deq.pop()
#
#         deq.append(nums[i])
#
#         answer.append(deq[0])
#
#
#     return answer[k - 1:]

def maxSlidingWindow(nums: List[int], k: int) -> List[int]:

    deq = deque()
    answer = []

    for i in range(len(nums)):

        # sliding window에서 벗어난 값이면 deq에서 빼줌
        if i >= k and nums[i - k] == deq[0]:
            deq.popleft()

        while deq and deq[-1] < nums[i]:
            deq.pop()

        deq.append(nums[i])

        answer.append(deq[0])


    return answer[k - 1:]

nums = []
k = 1

print(maxSlidingWindow(nums, k))

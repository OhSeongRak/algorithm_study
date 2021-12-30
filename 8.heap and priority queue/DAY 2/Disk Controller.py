import heapq
import math

def solution(jobs):
    curPos = 0    # 현재 위치
    curTime = 0   # 소요 시간
    jobsHeap = [] # 고마웡
    tempHeap = [] # 먼저 처리할 작업이 있는 힙

    for start, length in jobs:
        heapq.heappush(jobsHeap, [start, length])
    #print(jobsHeap)

    start, length = heapq.heappop(jobsHeap)
    heapq.heappush(tempHeap, [length, start])
    #print(tempHeap)
    curPos = tempHeap[0][1]

    while True:
        popLength, popStart = heapq.heappop(tempHeap)
        curPos += popLength
        curTime += curPos - popStart

        while jobsHeap and jobsHeap[0][0] <= curPos:
            start, length = heapq.heappop(jobsHeap)
            heapq.heappush(tempHeap, [length, start])

        if not tempHeap and not jobsHeap:
            break

        elif not tempHeap and jobsHeap:
            curPos = jobsHeap[0][0]
            start, length = heapq.heappop(jobsHeap)
            heapq.heappush(tempHeap, [length, start])

    return curTime // len(jobs)

jobs = [[0, 3],[2, 6], [12, 9]]

print(solution(jobs))
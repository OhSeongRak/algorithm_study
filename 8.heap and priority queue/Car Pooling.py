from typing import *
from queue import PriorityQueue
import heapq

def carPooling(trips: List[List[int]], capacity: int) -> bool:

# [2,1,2],[2,2,2], [3,3,7]
    trips.sort(key=lambda x: x[1])
    cap = 0 # 현재 수용 상태
    heap = [] # (도착 위치 , 사람 수)
    heapq.heappush(heap, (trips[0][2], trips[0][0]))
    cap+=trips[0][0]

    if cap > capacity:
        return False

    for i in range(len(trips) - 1):
        pNum = trips[i + 1][0] # 들어오는 승객 수
        startPos = trips[i + 1][1] # 출발 위치
        arrivePos = trips[i + 1][2] # 도작 위치

        cap += pNum # 일단 들어오는 승객 수를 더함

        while heap and startPos >= heap[0][0]: # heap에 있는 팀이 먼저 내린다면
            cap -= heap[0][1] # cap의 사람 수 줄임
            heapq.heappop(heap) # pop해줌

        heapq.heappush(heap, (arrivePos, pNum))

        if cap > capacity: # 수용 인원을 초과한다면
            return False

    return True


trips = [[2,1,5],[3,5,7]]

print(carPooling(trips, 3))

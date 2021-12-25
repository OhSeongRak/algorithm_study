from typing import *
from itertools import accumulate
import heapq


# cumulative sum
class Solution1:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        last_dest = max([dest for _, _, dest in trips])

        now = [0] * (last_dest + 1)
        for passengers, src, dest in trips:
            now[src] += passengers
            now[dest] -= passengers

        cumulative_passengers = list(accumulate(now))
        if max(cumulative_passengers) > capacity:
            return False
        return True


# heap
class Solution2:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        sorted_by_src = sorted(trips, key=lambda lst: lst[1])
        heap = []
        now = 0

        for passengers, src, dest in sorted_by_src:
            now += passengers
            while heap and heap[0][0] <= src:
                _, out = heapq.heappop(heap)
                now -= out

            heapq.heappush(heap, (dest, passengers))
            if now > capacity:
                return False

        return True

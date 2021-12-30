import heapq

def solution(scoville, K):
    heap = []
    cnt = 0
    for value in scoville:
        heapq.heappush(heap, value)

    while heap[0] < K:
        if len(heap) == 1:
            return -1
        mixValue = heapq.heappop(heap) + 2 * heapq.heappop(heap)
        heapq.heappush(heap, mixValue)
        cnt += 1

    return cnt

scovile = [1, 2, 3, 9, 10, 12]
K = 7

print(solution(scovile, K))
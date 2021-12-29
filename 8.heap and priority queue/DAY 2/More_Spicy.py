import heapq


def solution(scoville, K):
    mix = 0
    heapq.heapify(scoville)

    while scoville[0] < K:
        spicy = heapq.heappop(scoville) + heapq.heappop(scoville) * 2
        heapq.heappush(scoville, spicy)
        mix += 1

        # try-except 구문 에서는 이미 heap이 비어져 있어 heap[0]을 판단할 수 없음
        if len(scoville) <= 1 and scoville[0] < K:
            return -1

    return mix

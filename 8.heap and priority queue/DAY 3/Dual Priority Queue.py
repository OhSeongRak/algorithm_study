import heapq
from collections import deque

def solution(operations):
    answer = [0, 0]
    minHeap = []

    for i in range(len(operations)):
        op, n = operations[i].split(' ')
        num = int(n)
        if op == 'I':
            heapq.heappush(minHeap, num)

        else:
            if minHeap and num == -1:
                heapq.heappop(minHeap)

            elif minHeap and num == 1:
                maxHeap = [-k for k in minHeap]
                heapq.heapify(maxHeap)
                heapq.heappop(maxHeap)
                minHeap = [-k for k in maxHeap]
                heapq.heapify(minHeap)

    if minHeap:
        answer = [max(minHeap), min(minHeap)]

    return answer

operations = 	["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]

print(solution(operations))
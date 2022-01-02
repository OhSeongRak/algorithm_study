import heapq


def solution(operations):
    heap, max_heap = [], []

    for operation in operations:
        op, num = operation.split()
        num = int(num)

        # heap push
        if op == "I":
            heapq.heappush(heap, num)
            heapq.heappush(max_heap, (-1 * num, num))

        # heap pop
        elif op == "D":
            if not heap:
                pass
            # from max_heap
            elif num == 1:
                maxi = heapq.heappop(max_heap)[1]
                heap.remove(maxi)
            # from min_heap
            elif num == -1:
                mini = heapq.heappop(heap)
                max_heap.remove((-1 * mini, mini))

    return [heapq.heappop(max_heap)[1], heapq.heappop(heap)] if heap else [0, 0]

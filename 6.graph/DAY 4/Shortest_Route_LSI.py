import sys
import heapq
from collections import defaultdict


def dijkstra(graph, start):
    heap = [(0, start)]  # [(cost, destination)]
    path = defaultdict(int)

    while heap:
        weight, cur = heapq.heappop(heap)
        if cur not in path:
            path[cur] = weight
            for v, w in graph[cur]:
                heapq.heappush(heap, (weight + w, v))

    return path


if __name__ == "__main__":
    graph = defaultdict(list)
    vertex, edges = map(int, sys.stdin.readline().split())
    start = int(input())

    for _ in range(edges):
        u, v, w = map(int, sys.stdin.readline().split())
        graph[u].append((v, w))

    path = dijkstra(graph=graph, start=start)

    for v in range(1, vertex + 1):
        print(path[v]) if v in path else print("INF")

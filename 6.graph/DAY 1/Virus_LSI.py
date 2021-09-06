from typing import List
from collections import deque


def infected(adjacency: List[List[int]], start: int) -> int:
    stack, visited = [start], set()

    # DFS
    while stack:
        cur = stack.pop()
        for neighbor in adjacency[cur]:
            if neighbor not in visited:
                stack.append(neighbor)
        visited.add(cur)

    return len(visited)


if __name__ == "__main__":
    computers = int(input())
    infected_computer = 1
    edges = int(input())
    adjacency = [[] for _ in range(computers + 1)]

    for _ in range(edges):
        v1, v2 = map(int, input().split())
        adjacency[v1].append(v2)
        adjacency[v2].append(v1)

    infected_computers = infected(adjacency, infected_computer)
    print(infected_computers - 1)   # except itself

from lib import *


class Solution:
    def validPath(self, n: int, edges: List[List[int]], start: int, end: int) -> bool:
        adjacency = [[] for i in range(n)]
        queue, visited = collections.deque([start]), set()

        for v1, v2 in edges:
            adjacency[v1].append(v2)
            adjacency[v2].append(v1)

        # BFS, find from start
        while queue:
            cur = queue.popleft()
            if cur == end:
                return True
            for neighbor in adjacency[cur]:
                if neighbor not in visited:
                    queue.append(neighbor)
            visited.add(cur)

        return False

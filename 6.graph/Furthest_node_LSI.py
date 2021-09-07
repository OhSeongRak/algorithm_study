from collections import defaultdict, deque, Counter


def solution(n, edge):
    adjacency = defaultdict(list)
    queue, visited = deque([1]), defaultdict(int)

    for v1, v2 in edge:
        adjacency[v1].append(v2)
        adjacency[v2].append(v1)

    # BFS
    while queue:
        cur = queue.popleft()
        for neighbor in adjacency[cur]:
            if not visited[neighbor]:
                visited[neighbor] = visited[cur] + 1
                queue.append(neighbor)

    del visited[1]
    visited_distance = Counter(visited.values())

    return visited_distance[max(visited_distance)]

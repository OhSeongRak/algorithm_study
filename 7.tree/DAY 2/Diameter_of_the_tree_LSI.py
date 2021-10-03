import sys
sys.setrecursionlimit(10**9)


if __name__ == "__main__":
    n = int(input())
    tree = [[] for _ in range(n+1)]
    visited = [-1] * (n + 1)

    for _ in range(n - 1):
        parent, child, weight = map(int, sys.stdin.readline().split())
        tree[parent].append([child, weight])
        tree[child].append([parent, weight])

    def dfs(vertex, weight):
        for child in tree[vertex]:
            node, node_weight = child
            if visited[node] == -1:
                visited[node] = weight + node_weight
                dfs(node, weight + node_weight)

    # Find the node furthest from the root
    visited[1] = 0
    dfs(1, 0)
    furthest = visited.index(max(visited))

    # Find the node furthest from the furthest node from the root
    visited = [-1] * (n + 1)
    visited[furthest] = 0
    dfs(furthest, 0)

    print(max(visited))

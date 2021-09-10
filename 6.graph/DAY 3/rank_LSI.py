from collections import defaultdict


# Floyd-Warshall
def solution(n, results):
    win, lose = defaultdict(set), defaultdict(set)
    ranked_boxer = 0

    for w, l in results:
        win[l].add(w)
        lose[w].add(l)

    # f A beats B and B beats C, C loses to A.
    for boxer in range(1, n+1):
        for w in win[boxer]:
            lose[w].update(lose[boxer])  # If A loses to B and B loses to C, A will lose to C.
        for l in lose[boxer]:
            win[l].update(win[boxer])  # If A beat B, A will beat other players who lose to B.

    # Knowing the ranking means knowing how many people you've won,
    # and how many people you've got.
    for i in range(1, n+1):
        if len(win[i]) + len(lose[i]) == n - 1:
            ranked_boxer += 1

    return ranked_boxer


# DFS, Do I really?
def solution_DFS(n, results):
    win, lose = [[] for _ in range(n+1)], [[] for _ in range(n+1)]
    battles, ranked_boxer = defaultdict(set), 0

    for w, l in results:
        win[w].append(l)
        lose[l].append(w)

    def dfs(vertex, result):
        visited, stack = [], [vertex]

        while stack:
            cur = stack.pop()
            for neighbor in result[cur]:
                if neighbor not in visited:
                    stack.append(neighbor)
            visited.append(cur)

        return set(visited)

    for boxer in range(1, n+1):
        battles[boxer].update(dfs(boxer, win))   # in the original graph, dfs to forward edge
        battles[boxer].update(dfs(boxer, lose))  # in the original graph, dfe to backward edge

    for boxer in range(1, n+1):
        if len(battles[boxer]) == n:
            ranked_boxer += 1

    return ranked_boxer

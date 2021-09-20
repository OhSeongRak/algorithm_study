def solution(n, computers):
    def dfs(i):
        visited[i] = True
        for computer, connected in enumerate(computers[i]):
            if connected and not visited[computer]:
                dfs(computer)

    visited = [False for _ in range(n)]
    network = 0

    for i in range(n):
        if not visited[i]:
            dfs(i)
            network += 1

    return network

import heapq
from collections import deque

def solution(jobs):
    # [소요 시간, 시작 시점] 소요 시간 순으로 정렬
    tasks = deque(sorted([(x[1], x[0]) for x in jobs], key=lambda x: (x[1], x[0])))
    print(tasks)
    q = []
    heapq.heappush(q, tasks.popleft())
    current_time, total_response_time = 0, 0

    while len(q) > 0:
        dur, arr = heapq.heappop(q)
        # arr + dur : 요청 시간이 늦어서 디스크가 쉬는 경우
        current_time = max(current_time + dur, arr + dur)
        total_response_time += current_time - arr

        while len(tasks) > 0 and tasks[0][1] <= current_time:
            heapq.heappush(q, tasks.popleft())

        if len(tasks) > 0 and len(q) == 0:
            heapq.heappush(q, tasks.popleft())

    return total_response_time // len(jobs)

jobs = [[0, 3],[2, 6], [12, 9]]

print(solution(jobs))
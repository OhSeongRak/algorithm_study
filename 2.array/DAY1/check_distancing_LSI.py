from typing import *


# 분할 상환 분석: 비관적
def dfs(places: List[List[str]], i: int, j: int, manhattan: int = 0):
    # 재귀 종료: 1. 더 이상 동서남북 방향으로 이동할 수 없을 때, 2. 파티션('X')을 만났을 때, 3. Manhattan-Distance > 2
    if (i < 0 or i >= len(places) or j < 0 or j > len(places[0]) or
            places[i][j] == 'X' or manhattan > 2):
        return

    # 거리두기 실패 : 맨해튼 거리 2 이하에서 'P'를 만났을 때,
    if places[i][j] == 'P' and manhattan <= 2:
        return False

    dfs(places, i+1, j, manhattan + 1)  # RIGHT
    dfs(places, i-1, j, manhattan + 1)  # LEFT
    dfs(places, i, j+1, manhattan + 1)  # UP
    dfs(places, i, j-1, manhattan + 1)  # DOWN


def solution(places):
    answer = []

    for i in range(len(places)):
        for j in range(len(places)):
            if places[i][j] == 'P':
                check = dfs(places, i, j)
        answer.append(1) if check is None else answer.append(0)

    return answer

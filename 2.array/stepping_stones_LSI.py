import collections
import sys


def solution(stones, k):
    window = collections.deque(stones[:k])
    current_max = -sys.maxsize
    maximum_window = {max(window)}

    for v in stones[k:]:
        if current_max == -sys.maxsize:
            current_max = max(window)
        elif v > current_max:
            current_max = v

        maximum_window.add(current_max)

        if current_max == window.popleft():
            current_max = -sys.maxsize

        window.append(v)

    return min(min(maximum_window), max(stones[len(stones) - k:]))


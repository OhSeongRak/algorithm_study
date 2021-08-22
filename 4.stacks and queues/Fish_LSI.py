from typing import List


def solution(A: List[int], B: List[int]) -> int:
    stack = []
    n, alive = len(A), 0  # N == len(A) == len(B)

    for i in range(n):
        # append the size of fish that flows to downstream to the stack
        if B[i] == 1:
            stack.append(A[i])

        # check when fish flows to upstream
        else:  # B[i] == 0
            while stack:
                if stack[-1] > A[i]:
                    break
                else:
                    stack.pop()

            if not stack:
                alive += 1

    return alive + len(stack)

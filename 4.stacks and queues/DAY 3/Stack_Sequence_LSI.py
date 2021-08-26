from typing import *
from collections import deque


def can_make_sequence(sequence: deque) -> bool or List[int]:
    global stack_operation
    stack, cur = [], 1
    answer = []

    while sequence:
        while cur <= sequence[0]:
            stack.append(cur)
            answer.append(stack_operation['push'])
            cur += 1

        if stack[-1] == sequence[0]:
            sequence.popleft()
            stack.pop()
            answer.append(stack_operation['pop'])
        else:
            return None

    return answer


if __name__ == "__main__":
    n = int(input())
    sequence, stack_operation = deque(), {'push': '+', 'pop': '-'}

    for i in range(n):
        sequence.append(int(input()))

    answer = can_make_sequence(sequence)

    if answer is None:
        print("NO")
    else:
        for operation in answer:
            print(operation)

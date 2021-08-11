from typing import *
import collections


def triangular_number(n: int) -> int:
    return n * (n + 1) // 2


def sum_of_sublist(lst: List[int]) -> Counter:
    suffix = [lst[0]]

    for i, v in enumerate(lst[1:]):
        # triangular_number(i) -> start_index_to_be_added_range
        suffix.extend(list(map(lambda x: x + v, suffix[triangular_number(i):])))
        suffix.append(v)

    return collections.Counter(suffix)


if __name__ == "__main__":
    T = int(input())
    n = int(input())
    A = list(map(int, input().split()))
    m = int(input())
    B = list(map(int, input().split()))
    count = 0

    sub_A = sum_of_sublist(A)
    sub_B = sum_of_sublist(B)

    if sub_A and sub_B:
        for k, v in sub_A.items():
            if T - k in sub_B:
                count += (v * sub_B[T - k])

    print(count)

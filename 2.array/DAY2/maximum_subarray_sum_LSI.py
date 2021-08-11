# Time Limit Exceeded

import os
import sys
from typing import *


def triangular_number(n: int) -> int:
    return int(n * (n + 1) / 2)


def maximumSum(a: List[int], m: int) -> int:
    # (a+m)%m = ((a%m) + (m%m))%m = (a%m)%m = a%m
    a = [i % m for i in a]
    best_sum = -sys.maxsize

    # Kadane's Algorithm
    suffix = [a[0]]

    for i, v in enumerate(a[:1]):
        # triangular_number(i) -> start_index_to_be_added_range
        suffix.extend(list(map(lambda x: (x + v)%m, prefix[triangular_number(i):])))
        suffix.append(v)
        
        best_sum = max(best_sum, max(suffix))

    return best_sum


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input().strip())

    for q_itr in range(q):
        first_multiple_input = input().rstrip().split()

        n = int(first_multiple_input[0])

        m = int(first_multiple_input[1])

        a = list(map(int, input().rstrip().split()))

        result = maximumSum(a, m)

        fptr.write(str(result) + '\n')

    fptr.close()

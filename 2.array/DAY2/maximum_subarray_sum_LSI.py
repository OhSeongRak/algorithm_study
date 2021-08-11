# Time Limit Exceeded

import os
import sys
from typing import *


def maximumSum(a: List[int], m: int) -> int:
    # (a+m)%m = ((a%m) + (m%m))%m = (a%m)%m = a%m
    a = [i % m for i in a]
    best_sum = -sys.maxsize

    # memoization
    prefix = {0}

    for i in range(len(a)):
        prefix.update(set(map(lambda x: (x + a[i])%m, prefix)))
        best_sum = max(best_sum, max(prefix))

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

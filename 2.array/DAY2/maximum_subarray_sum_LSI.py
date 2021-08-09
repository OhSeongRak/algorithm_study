# Time Limit Exceeded

import os
import sys
from typing import *


def maximumSum(a: List[int], m: int) -> int:  # m: modulo
    # (a+b) % M = ((a % M) + (b % M)) % M, M = mod(m)
    a = [i % m for i in a]

    # using the ideas of Kadane's Algorithm
    prefix = []
    best_sum = -sys.maxsize

    for i in range(len(a)):
        prefix.insert(0, 0)  # a[i] will insert to 0 index of prefix
        prefix = list(map(lambda x: x + a[i], prefix))  # add a[i] to all elements of prefix
        # extract the maximum among values less than m from prefix
        # and compare maximum with existing best_sum
        best_sum = max(best_sum, max(filter(lambda x: x < m, prefix)))

    return best_sum % m


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

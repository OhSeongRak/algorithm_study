from collections import Counter
from functools import reduce
from itertools import combinations


def solution(clothes):
    kinds = list(Counter(c[1] for c in clothes).values())
    # kinds of clothes only one
    if len(kinds) == 1:
        return kinds[0]

    comb, sum_comb = [], 0
    for r in range(1, len(kinds) + 1):
        comb.extend(combinations(kinds, r))

    for c in comb:
        sum_comb += reduce(lambda x, y: x * y, c)

    return sum_comb

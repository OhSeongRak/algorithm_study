from typing import *
import heapq


# generator + heapq.merge
class Solution:
    def nthSuperUglyNumber(self, n: int, primes: List[int]) -> int:
        super_uglies = [1]

        def next_ugly(prime_list):
            for ugly in super_uglies:
                yield ugly * prime_list

        heap = iter(heapq.merge(*map(next_ugly, primes)))
        while len(super_uglies) < n:
            new_ugly = next(heap)
            if new_ugly != super_uglies[-1]:
                super_uglies.append(new_ugly)

        return super_uglies[-1]

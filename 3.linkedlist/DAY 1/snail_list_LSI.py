from typing import *


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def make_snail_linked_list(val: List[int], cycle: int) -> ListNode:
    cur = cycle_head = head = ListNode()

    for v in val:
        cur.next = ListNode(v)
        cur = cur.next

    for _ in range(cycle):
        cycle_head = cycle_head.next

    cur.next = cycle_head

    return head.next


if __name__ == "__main__":
    N, M, V = map(int, input().split())
    C = list(map(int, input().split()))

    head = make_snail_linked_list(C, V)

    for _ in range(M):
        K = int(input())
        cur = head
        if K < N:
            for _ in range(K):
                cur = cur.next
            print(cur.val)
        else:
            for _ in range((K - N) % (N - V + 1) + (V - 1)):
                cur = cur.next
            print(cur.val)

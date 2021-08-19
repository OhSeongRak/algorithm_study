class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        root = prev = ListNode
        prev.next = head

        while head and head.next:
            # dummy -> head
            dummy = head.next
            head.next = dummy.next
            dummy.next = head

            # prev -> dummy
            prev.next = dummy

            # move to next
            head = head.next
            prev = prev.next.next

        return root.next

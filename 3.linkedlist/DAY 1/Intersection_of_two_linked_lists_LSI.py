class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def get_length_of_linked_list(self, head: ListNode) -> int:
        length = 0
        while head is not None:
            head = head.next
            length += 1
        return length

    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> ListNode:
        if headA is None or headB is None:
            return None

        ha, hb = headA, headB
        ha_len = self.get_length_of_linked_list(ha)
        hb_len = self.get_length_of_linked_list(hb)
        move = abs(ha_len - hb_len)

        # skip linked list until both linked list have the same length
        if ha_len > hb_len:
            for _ in range(move):
                ha = ha.next
        elif ha_len < hb_len:
            for _ in range(move):
                hb = hb.next

        while ha != hb:
            ha, hb = ha.next, hb.next

        return ha

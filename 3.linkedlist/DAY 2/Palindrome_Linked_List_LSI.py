class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        slow = fast = head
        rev = None

        # move slow runner and fast runner while making reverse
        while fast and fast.next:
            fast = fast.next.next  # fast runner moves 2steps
            rev, rev.next, slow = slow, rev, slow.next  # slow runner moves 1step

        # if slow is in the middle of the Linked List, have to move 1step to next
        # then, how to check? if fast is None => length of Linked List is even
        # but fast is not None and fast.next is None => length of Linked List is odd
        if fast is not None:
            slow = slow.next

        # check palindrome
        while rev and rev.val == slow.val:
            slow, rev = slow.next, rev.next

        return not rev

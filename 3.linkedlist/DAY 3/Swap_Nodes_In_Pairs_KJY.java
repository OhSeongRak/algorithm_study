/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
	public ListNode func(ListNode head) {
		if (head == null)
			return null;
		else if (head.next == null)
			return head;
		
		ListNode preTmp = head;
		ListNode tmp = head.next;
		ListNode nextTmp = head.next.next;
		
		tmp.next = preTmp;
		preTmp.next = func(nextTmp);
		return tmp;
		
	}
    public ListNode swapPairs(ListNode head) {
        return func(head);
    }
}
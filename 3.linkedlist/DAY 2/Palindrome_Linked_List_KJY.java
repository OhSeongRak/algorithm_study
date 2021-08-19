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
   public boolean isPalindrome(ListNode head) {

		// size check
		ListNode tmp = head;
		int size = 0;
		while (tmp != null) {
			size++;
			tmp = tmp.next;
		}
		if (size == 0 || size ==1)
			return true;

		// tmp location is startPoint
		int startPoint;
		if (size % 2 == 0)
			startPoint = size / 2;
		else
			startPoint = size / 2 + 1;
		tmp = head;
		for (int i = 0; i < startPoint; i++)
			tmp = tmp.next;

		// link change
		ListNode preTmp;
		ListNode nextTmp=tmp.next;
		while (nextTmp!=null) {		
			preTmp = tmp;
			tmp= nextTmp;
			nextTmp=tmp.next;
			
			tmp.next = preTmp;
		}
		
		//tail 
		ListNode tail = tmp;

		// check palindrome
		ListNode start = head;
		ListNode end = tail;
		int checkSize = size / 2;

		for (int i = 0; i < checkSize; i++) {
			if (start.val != end.val)
				return false;
			start = start.next;
			end = end.next;
		}
		return true;

	}
}
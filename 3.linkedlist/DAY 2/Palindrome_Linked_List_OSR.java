package LinkedList;

public class Palindrome_Linked_List_OSR {

	public boolean isPalindrome(ListNode head) {

		int len = 0;

		ListNode tmp = head;
		while (tmp != null) {
			tmp = tmp.next;
			len++;
		}

		ListNode pre = null;
		ListNode cur = head;
		ListNode next = head;

		for (int i = 0; i < len / 2; i++) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}

		if (len % 2 == 1)
			next = next.next;

		for (int i = 0; i < len / 2; i++) {
			if (pre.val != next.val)
				return false;
			else {
				pre = pre.next;
				next = next.next;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {

	}

}

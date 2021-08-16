package LinkedList;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		this.val = x;
		this.next = null;
	}
}

public class Intersection_Of_Two_Linked_Lists_OSR {

	static ListNode headA = null;
	static ListNode headB = null;

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = 0, lenB = 0;

		ListNode tmp = headA;
		while (tmp != null) {
			tmp = tmp.next;
			lenA++;
		}

		tmp = headB;
		while (tmp != null) {
			tmp = tmp.next;
			lenB++;
		}

		ListNode nodeA = headA;
		ListNode nodeB = headB;
		ListNode answer = null;
		int diff = Math.abs(lenA - lenB);

		if (lenA > lenB) {
			for (int i = 0; i < diff; i++)
				nodeA = nodeA.next;
		} else {
			for (int i = 0; i < diff; i++)
				nodeB = nodeB.next;
		}

		while (nodeA != null) {
			if (nodeA == nodeB && answer == null)
				answer = nodeA;

			else if (nodeA != nodeB && answer != null)
				return null;

			nodeA = nodeA.next;
			nodeB = nodeB.next;
		}

		return answer;
	}

	public static ListNode insertNode(ListNode head, int data) {
		ListNode newNode = new ListNode(data);
		if (head == null)
			head = newNode;
		else {
			ListNode tempNode = head;

			while (tempNode.next != null)
				tempNode = tempNode.next;

			tempNode.next = newNode;
		}

		return head;
	}

	public static void main(String[] args) {

		headA = insertNode(headA, 4);
		headA = insertNode(headA, 1);		
		headA = insertNode(headA, 8);
		headA = insertNode(headA, 4);
		headA = insertNode(headA, 5);

		headB = insertNode(headB, 5);
		headB = insertNode(headB, 6);
		headB = insertNode(headB, 1);
		headB = insertNode(headB, 8);
		headB = insertNode(headB, 4);
		headB = insertNode(headB, 5);

		ListNode ans = getIntersectionNode(headA, headB);
		System.out.print(ans.val);

	}

}

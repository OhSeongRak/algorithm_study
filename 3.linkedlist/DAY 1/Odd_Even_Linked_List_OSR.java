package LinkedList;

class ListNode {
	int val;
	ListNode next;

	ListNode() {}

	ListNode(int val) {this.val = val;}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class Odd_Even_Linked_List_OSR {
	public static ListNode oddEvenList(ListNode head) {
		
		if(head == null || head.next == null)
			return head;
		
		ListNode oddList = head, evenList = head.next, evenHead = head.next;
		
		while(oddList.next != null && evenList.next != null ) {
			oddList.next = evenList.next;
			evenList.next = oddList.next.next;
			
			oddList = oddList.next;
			evenList = evenList.next;
		}
		
		oddList.next = evenHead;
		
		return head;
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
		ListNode head = null;
		
		head = insertNode(head, 1);
		head = insertNode(head, 2);
		head = insertNode(head, 3);
		head = insertNode(head, 4);
		head = insertNode(head, 5);
		head = insertNode(head, 6);
//		head = insertNode(head, 7);

		ListNode answer = oddEvenList(head);
		ListNode tmp = answer;
		
		while(tmp != null) {
			System.out.println(tmp.val);
			tmp = tmp.next;
			
		}
	}

}

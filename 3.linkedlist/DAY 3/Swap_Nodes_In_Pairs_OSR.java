package LinkedList;

public class Swap_Nodes_In_Pairs_OSR {

	public static ListNode swapPairs(ListNode head) {
		
        if(head == null || head.next == null)
            return head;
		
		ListNode a = head;
		ListNode b = head;
		ListNode pre = new ListNode(0);
		head = head.next;

		while (a!= null && a.next != null) {
			b = b.next;
			pre.next = b;
			a.next = b.next;
			b.next = a;
			
			pre = a;
			a = a.next;
			b = a;
		}
		return head;
	}

	public static void main(String[] args) {

	}

}

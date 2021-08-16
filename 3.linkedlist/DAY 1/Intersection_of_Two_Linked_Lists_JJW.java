class ListNode{
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}	
}
public class Intersection_of_Two_Linked_Lists_JJW {
	public static int getLen(ListNode node) {
		int len = 0 ;
		while(node != null) {
			len++;
			node = node.next;
			
		}
		return len;
	}
	

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
		int lenA = getLen(headA);
		int lenB = getLen(headB);
		//각 노드의 길이를 구함
		//   4 1 8 4 5 (5)
		// 5 6 1 8 4 5 (6)
//		System.out.println(lenA);
//		System.out.println(lenB);
		
		
		if(lenA > lenB) {
			int skip = lenA - lenB;
			while(skip-- > 0) {
				headA = headA.next;
			}
		}
		else {
			int skip = lenB - lenA;
			while(skip-- > 0) {
				headB = headB.next;
			}
		}
		//길이 차 만큼 길이가 긴 리스트를 skip만큼 이동시켜줌
		//4 1 8 4 5
		//5 6 1 8 4 5
		
		ListNode intersect = null;
		
		while(true) {
			if(headA == headB) {
				intersect = headA;
				break;
			}
			headA = headA.next;
			headB = headB.next;
		}
		
		return intersect;
		
	}
}

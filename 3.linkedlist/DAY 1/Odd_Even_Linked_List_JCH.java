import java.util.Scanner;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class List{
	ListNode header = null;
	ListNode trailer = null;
	
	void insertNode(int data) {
		ListNode newNode = new ListNode(data);
		if(this.header == null && this.trailer == null) {
			this.header = newNode;
			this.trailer = newNode;
		}
		else {
			this.trailer.next = newNode;
			this.trailer = newNode;
		}
	}
}
 
class Solution1 {
    public ListNode oddEvenList(ListNode head) {
    	if(head == null || head.next == null || head.next.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode extra = even;
        
        while(even != null && even.next != null) {
        	odd.next = odd.next.next;
        	even.next = even.next.next;
        	odd = odd.next;
        	even = even.next;
        }
        
        
        	odd.next = extra;
        	return head;
    }
        	
        	
        
        
}
public class Odd_Even_Linked_List_JCH {

	public static void main(String[] args) {
		List l = new List();
		ListNode res = null;
		int val;
		
		Scanner input = new Scanner(System.in);
		
		
		l.insertNode(1);
		l.insertNode(2);
		l.insertNode(3);
		l.insertNode(4);
		l.insertNode(5);
		
		Solution1 s = new Solution1();
		res = s.oddEvenList(l.header);
		
		while(true) {
			if(res==null) break;
			
			System.out.println(res.val);
			res = res.next;
		}
	}
}

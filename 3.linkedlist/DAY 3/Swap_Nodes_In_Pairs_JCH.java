
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
	
	void insertNode(int data){
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

class Solution {
    public ListNode swapPairs(ListNode head) {
    	if(head == null || head.next == null) return head;
    	
        ListNode main = head.next;
        ListNode sub = head;
        ListNode save = head.next;
        
        while(head != null) {
        	head.next = main.next;	//1.next에 2.next(3)을 넣음
        	main.next = head;		//2.next에 1을 넣음
        	head = head.next;		//head가 1.next인 3으로 이동	2	1	3	4
        	
        	if(head!=null && head.next != null) main = head.next;	//head 다음노드가 존재할 경우 main을 head 다음노드로 이동
        	else break;	//head가 마지막노드이거나 head가 존재하지 않을 경우 break
        	
        	sub.next = main;	//바뀌기 전 head인 1과 main (4)를 이어줌
        	sub = head;			//뒤의 작업을 위해 sub에 head (3)을 넣어줌
        }
        return save;
    }
}
public class Swap_Nodes_In_Pairs_JCH {

	public static void main(String[] args) {
		List l = new List();
		
		l.insertNode(1);
		l.insertNode(2);
		l.insertNode(3);
		l.insertNode(4);
		
		Solution s = new Solution();
		
		ListNode tmp =s.swapPairs(l.header);
		
		while(true) {
			if(tmp == null) break;
			System.out.println(tmp.val);
			tmp = tmp.next;
		}
	}

}

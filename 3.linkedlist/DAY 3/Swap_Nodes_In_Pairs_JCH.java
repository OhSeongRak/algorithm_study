
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
        	head.next = main.next;	//1.next�� 2.next(3)�� ����
        	main.next = head;		//2.next�� 1�� ����
        	head = head.next;		//head�� 1.next�� 3���� �̵�	2	1	3	4
        	
        	if(head!=null && head.next != null) main = head.next;	//head ������尡 ������ ��� main�� head �������� �̵�
        	else break;	//head�� ����������̰ų� head�� �������� ���� ��� break
        	
        	sub.next = main;	//�ٲ�� �� head�� 1�� main (4)�� �̾���
        	sub = head;			//���� �۾��� ���� sub�� head (3)�� �־���
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

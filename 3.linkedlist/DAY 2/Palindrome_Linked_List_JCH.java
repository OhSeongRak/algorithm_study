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
			this.trailer = newNode;
			this.trailer.next = newNode;
		}
	}
}

class Solution2 {
    public boolean isPalindrome(ListNode head) {
        int cnt = 0;
        boolean res = true;
        
        ListNode tmp = head;
        
        ListNode midPoint = head;
        ListNode main = null;
        ListNode sub = null;
        ListNode curPoint = null;
        
        while(true) {
        	if(tmp == null) break;
        	cnt++;
        	tmp = tmp.next;
        }
        
        for(int i = 0; i < cnt / 2; i++) {	//midPoint�� Linked List�� �߰����� + 1
        	midPoint = midPoint.next;
        }
        
        if(cnt % 2 == 1) midPoint = midPoint.next;	//Linked List ������ Ȧ�� �ϰ�� midPoint�� �߰������������� �̵�
        
        sub = null;			//main�� �����ּ�
        main = midPoint;	//midPoint������  ��带 ��������Ű�� ���� sub�� �ּҸ� ��� ����ó�� �׾� �����ϴ� main
        curPoint = midPoint;	//main�� �ڷ� ��� �� �� �ֵ��� main�� ���� �ּҸ� �̸� �����صδ� curPoint
        
        for(int i = 0; i < cnt / 2; i++) {
        	curPoint = main.next;	//main�� ���� �ּҸ� curPont�� �����س���
        	main.next = sub;	//main�� ���� �ּҿ� main�� ���� �ּ��� sub�� ����
        	sub = main;			//sub���� main�� ���� �ּҰ� ����ǹǷ� sub�� main�� �ּҸ� �����ϰ�,
        	main = curPoint;	//main�� �̸� �����صξ��� main�� �����ּҸ� ����
        }						//for�� ����� ��������Ų ������� sub�� �����
        
        tmp = head;
        
        for(int i = 0; i < cnt / 2; i++) {		//Linked List�� ������������ midPoint-1 ���������� 
        										//sub�� ����� �� ���ĺ��� ������ �������� ���� ��
        	if(tmp.val != sub.val ) {
        		res = false;
        		break;
        	}
        	
        	tmp = tmp.next;
        	sub = sub.next;
  
        }
        
        return res;
    }
}
public class Palindrome_Linked_List_JCH {

	public static void main(String[] args) {
		List l = new List();
		
		l.insertNode(1);
		l.insertNode(2);
		l.insertNode(3);
		l.insertNode(4);
		l.insertNode(5);
		l.insertNode(5);
		l.insertNode(4);
		l.insertNode(3);
		l.insertNode(2);
		l.insertNode(1);
		
		Solution2 s = new Solution2();
		
		System.out.println(s.isPalindrome(l.header));
		
		/*ListNode tmp = s.isPalindrome(l.header);
		while(true) {
			if(tmp==null) break;
			System.out.println(tmp.val);
			tmp = tmp.next;
		}*/
	}

}

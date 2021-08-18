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
        
        for(int i = 0; i < cnt / 2; i++) {	//midPoint는 Linked List의 중간지점 + 1
        	midPoint = midPoint.next;
        }
        
        if(cnt % 2 == 1) midPoint = midPoint.next;	//Linked List 갯수가 홀수 일경우 midPoint를 중간다음지점으로 이동
        
        sub = null;			//main의 직전주소
        main = midPoint;	//midPoint부터의  노드를 리버스시키기 위해 sub의 주소를 계속 스택처럼 쌓아 저장하는 main
        curPoint = midPoint;	//main이 뒤로 계속 갈 수 있도록 main의 다음 주소를 미리 저장해두는 curPoint
        
        for(int i = 0; i < cnt / 2; i++) {
        	curPoint = main.next;	//main의 다음 주소를 curPont에 저장해놓음
        	main.next = sub;	//main의 다음 주소에 main의 직전 주소인 sub를 저장
        	sub = main;			//sub에는 main의 직전 주소가 저장되므로 sub에 main의 주소를 저장하고,
        	main = curPoint;	//main에 미리 저장해두었던 main의 다음주소를 저장
        }						//for문 종료시 리버스시킨 결과값은 sub에 저장됨
        
        tmp = head;
        
        for(int i = 0; i < cnt / 2; i++) {		//Linked List의 시작지점부터 midPoint-1 지점까지와 
        										//sub에 저장된 그 이후부터 마지막 지점까지 서로 비교
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

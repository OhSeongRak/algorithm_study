class ListNode{
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	
	
}
public class Odd_Even_Linked_List_JJW {
	
	public static ListNode oddEvenList(ListNode head) {
		if(head == null) return null; //[]일 경우 -> []
	      
		ListNode odd = new ListNode(0);
		ListNode even = new ListNode(0);
		//아무 값이나 넣어서 odd와 even 노드 생성
		
		ListNode oddNow = odd;
		ListNode evenNow = even;
		
		
		int idx = 1;
		
		while(head != null) {//인덱스에 따라 값을 저장, Now 노드가 움직이는 노드
			ListNode temp = head.next; //다음 값을 저장
			
			if(idx % 2 == 1) {//홀수면
				oddNow.next = head; //0 -> 1 , 
				oddNow = head; //1
			}
			else{
				evenNow.next = head; // 0 -> 2
				evenNow = head; // 2
			}
			head.next = null; 
			head = temp; //저장해두었던 temp로 다음 값 저장
			//head = head.next; -> runtime error ? head를 다 가져가는 게 아냐
			idx++;
		}
		oddNow.next = even.next; 
		ListNode answer = odd.next; 
    //odd와 even의 첫 값은 0으로 저장되어있기 때문에 next값으로 이어줌
		
		return answer;
		
			//Best Code
//	        ListNode odd = head; //홀수 인덱스
//	        ListNode even = head.next; //짝수 인덱스
//	        
//	        ListNode temp = even; 
//	        //짝수 인덱스 시작 : odd와 even을 연결시켜주어야함
//	        
//			while(odd.next != null && even.next != null) {
//				odd.next = odd.next.next; 
//				odd = odd.next;
//				
//				even.next = even.next.next; 
//				even = even.next;
//				
//			}
//			odd.next = temp;//odd와 even 연결 : odd의 마지막이 even의 시작인 temp와 연결
//			
//			return head;
//		
	
	}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean isPalindrome(ListNode head) {
        
        ListNode Head = head;
		ListNode temp = head;
		
		int cnt = getCount(head);
		
		for(int i = 0 ; i < cnt/2 ; i++) {
			temp = temp.next;
		}
		if(cnt%2 == 1) {
			temp = temp.next;
		}
    //노드의 개수를 구한 후에 짝수이면 cnt/2만큼 이동시키고
      // 홀수이면 한 칸만 더 이동시켜
      
		ListNode Tail = reverse(temp);
		//절반 이후의 노드를 reverse 시킨다
      
		boolean answer = true;
        
		while(Head != null && Tail != null) {
			System.out.println(Head.val + " " + Tail.val);
			if(Head.val != Tail.val){
                answer = false;
                break;
            }
            Head = Head.next;
            Tail = Tail.next;
		}
     //Head와 Tail의 val를 비교하되 같지 않다면 false로 변경후 break로 탈출하여 answer를 반환한다
		return answer;
		
	}
  //Node 개수 구하는 함수
    public int getCount(ListNode head){
        int count = 0 ;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
  //reverse 시키는 함수
    public ListNode reverse(ListNode head){
        ListNode tail = null;
        while(tail != null){
            ListNode next = head.next;
            head.next = tail;
            tail = head;
            head = next;
        }
        return tail;
    }
}

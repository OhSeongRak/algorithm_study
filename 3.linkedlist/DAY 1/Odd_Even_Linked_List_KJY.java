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
    public ListNode oddEvenList(ListNode head) {
        if (head==null)
            return null;
        int count = 1;
        ListNode tmp = head;
        ListNode rem = null;
        ListNode pre_tmp=null;
        while (tmp.next!=null){
            pre_tmp = tmp;
            tmp=tmp.next;
            pre_tmp.next =tmp.next;
            
            count ++;
            
            if(count ==2)
                rem = tmp;
        }
        if(count%2==1)
            tmp.next=rem;
        else
            pre_tmp.next =rem;
        return head;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ATmp = headA;
        ListNode BTmp = headB;
        
        int ALength = 0;
        while(ATmp!=null){
            ALength++;
            ATmp=ATmp.next;
        }
        int BLength = 0;
        while(BTmp!=null){
            BLength++;
            BTmp=BTmp.next;
        }
        
        ATmp = headA;
        BTmp = headB;
        
        if(BLength > ALength)
            for(int i = 0 ; i<BLength-ALength; i++)
                BTmp=BTmp.next;
        else
            for(int i = 0 ; i<ALength-BLength; i++)
                ATmp =ATmp.next;
        
        while(ATmp!=null){
            if(ATmp==BTmp)
                return ATmp;
            ATmp=ATmp.next;
            BTmp=BTmp.next;
        }
        
        
        
        return null;
    }
}

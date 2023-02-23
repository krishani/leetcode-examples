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
    public ListNode swapNodes(ListNode head, int k) {
        
        // Get the length of the linked list
        ListNode cur = head;
        int len = 1;
        if (head != null) {
            while(cur.next != null) {
                cur = cur.next;
                len += 1;
            
            } 
        } else {
            len = 0;
        }
        
        // find firstK, lastK, prevFirstK, prevLastK
        
        int secondK = len - k + 1;
        
        ListNode firstKNode = null;
        
        ListNode secondKNode = null;
        
        int maxIndex = Math.max(k, secondK);
        
        int j = 1;
        
        if (k == 1 || k == len) {
            int temp1 = head.val;
            head.val = cur.val;
            cur.val = temp1;
            
            return head;
            
        }
        
        if (k == secondK) {
            return head;
        }
        
        ListNode temp = head;
        while (j < maxIndex) {
            if (j == k-1) {
                firstKNode = temp.next;
            } else if ( j == secondK - 1) {
                secondKNode = temp.next;
            }
            temp = temp.next;
            j+=1;
        }
        
        int tempVal = firstKNode.val;
        firstKNode.val = secondKNode.val;
        secondKNode.val = tempVal;
        
        return head;
    }
    
}
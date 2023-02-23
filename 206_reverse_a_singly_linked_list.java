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
    public ListNode reverseList(ListNode head) {
        
        ListNode prev=null;
        ListNode cur = head;
        ListNode next=null;
        
        if (head == null) return null;
        
        while(cur.next != null) {
            next = cur.next;
            cur.next = prev; // reversed the pointer
            prev = cur;
            cur = next;
        }
        cur.next = prev;
        head = cur;
        return head;
        /*1 -> 2 -> 3
        next  -> cur.next
        cur.next -> prev
        prev -> cur
        cur -> neext*/
    }
}
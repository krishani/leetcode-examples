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
    ListNode head = null;
    
    public ListNode addToLL(int val, ListNode curNode) {
        if (curNode == null) {
            curNode = new ListNode(val);
            this.head = curNode;
            return curNode;
        }
        curNode.next = new ListNode(val);
        return curNode.next;
    }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode temp = head;
        
        ListNode pt1 = list1;
        ListNode pt2 = list2;
        
        while(pt1 != null && pt2 != null) {
            if (pt1.val == pt2.val) {
                temp = addToLL(pt1.val, temp);
                temp = addToLL(pt2.val, temp);
                
                pt1 = pt1.next;
                pt2 = pt2.next;
                
                
            } else if (pt1.val > pt2.val) {
                temp = addToLL(pt2.val, temp);
                pt2 = pt2.next;
                
            } else {
                // TODO add pt1 to ll
                temp = addToLL(pt1.val, temp);
                pt1 = pt1.next;
            }
        }
        
        if (pt1 != null || pt2 != null) {
            if (pt1 != null) {
                while(pt1 != null) {
                    temp = addToLL(pt1.val, temp);
                    pt1 = pt1.next;
                }
            } else {
                while(pt2 != null) {
                    temp = addToLL(pt2.val, temp);
                    pt2 = pt2.next;
                }
            }
        }
        return head;
        
    }
}
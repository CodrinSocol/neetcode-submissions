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
        ListNode ptr = head;
    
        if(ptr == null || ptr.next == null) {
            return ptr;
        }

        ListNode result = new ListNode(ptr.val);
        ptr = ptr.next;

        while(ptr != null) {
            ListNode resHead = new ListNode(ptr.val);

            resHead.next = result;
            result = resHead;
            ptr = ptr.next;
        }

        return result;
    }
}

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
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }

        ListNode ptr = head;
        ListNode ptr2 = head.next;

        while(ptr != ptr2) {
            if(ptr == null) {
                return false;
            }
            ptr = ptr.next;

            if(ptr2 == null || ptr2.next == null) {
                return false;
            }

            ptr2 = ptr2.next.next;
        }

        return true;
    }
}

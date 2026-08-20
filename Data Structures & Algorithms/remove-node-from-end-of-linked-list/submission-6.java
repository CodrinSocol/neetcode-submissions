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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return null;
        }

        int len = 0;
        ListNode cpy = head;

        while(cpy != null) {
            len++;
            cpy = cpy.next;
        }

        cpy = head;

        int idx = len - n; // to be deleted

        if(idx < 0) {
            return null;
        }

        if(idx == 0) {
            return head.next;
        }

        for(int i = 0; i < idx - 1; i++) {
            cpy = cpy.next;
        }

        if(cpy.next == null) {
            return null;
        }

        cpy.next = cpy.next.next;
        return head;
    }
}

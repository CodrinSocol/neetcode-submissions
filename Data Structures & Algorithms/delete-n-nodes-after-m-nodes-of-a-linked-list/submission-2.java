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
    public ListNode deleteNodes(ListNode head, int m, int n) {
        if(head == null) {
            return head;
        }

        ListNode headCpy = head;

        while(head != null) {
            for(int i = 0; i < m - 1 && head != null; i++) {
                head = head.next;
            }
            if(head == null) {
                break;
            }

            ListNode last = head.next;

            for(int i = 0; i < n && last != null; i++) {
                last = last.next;
            }
            head.next = last;
            head = head.next;
        }

        return headCpy;
    }
}

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

    private int greatestCommonDivisor(int a, int b) {
        while(b != 0) {
            int c = b;
            b = a % b;
            a = c;
        }

        return a;
    }


    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode headCpy = head;

        while(head != null && head.next != null) {
            int l = head.val;
            int r = head.next.val;

            ListNode n = new ListNode(greatestCommonDivisor(l,r));

            n.next = head.next;
            head.next = n;
            head = head.next.next;
        }

        return headCpy;
    }
}
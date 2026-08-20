/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) {\ this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) {
            return head;
        }

        ListNode originalHead = head;
        ListNode before = null;
        int i = 1;

        if(left != 1) {
            while(i < left - 1) {
                head = head.next;
                i++;
            }
            before = head;
            head = head.next;
            i++;
        }

        ListNode headCpy = originalHead;
        ListNode rev = head; // first element to be reversed
        ListNode prev = rev;

        while(i < right && rev.next != null) {
            ListNode newNode = new ListNode(rev.next.val);
            newNode.next = prev;
            prev = newNode;
            i++;
            rev = rev.next;
        }

        if(before != null) {
            before.next = prev;
        } else {
            headCpy = prev;
        }
        
        head.next = rev.next;

        return headCpy;
    }
}
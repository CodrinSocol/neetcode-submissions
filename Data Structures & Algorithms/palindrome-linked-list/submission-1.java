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
    public boolean isPalindrome(ListNode head) {
        ListNode reversed = reverse(head);

        while(reversed != null && head != null) {
            if(reversed.val != head.val) {
                return false;
            }

            reversed = reversed.next;
            head = head.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {

        ListNode prev = null;
        ListNode current = head;

        while(current != null) {
            ListNode newNode = new ListNode(current.val);
            newNode.next = prev;
            prev = newNode;
            current = current.next;
        }

        return prev;
    }
}
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }

        if(l2 == null) {
            return l1;
        }

        ListNode result = new ListNode(-1);
        ListNode ptr = result;
        int carry = 0;

        while(l1 != null && l2 != null) {
            int val = l1.val + l2.val + carry;
            carry = val / 10;
            ptr.next = new ListNode(val % 10);
            ptr = ptr.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        if(l1 != null) {
            if(carry == 0) {
                ptr.next = l1;
            } else {
                while(l1 != null) {
                    int val = l1.val + carry;
                    ptr.next = new ListNode(val % 10);
                    carry = val / 10;
                    ptr = ptr.next;
                    l1 = l1.next;
                }
            }
            
        }

        if(l2 != null) {
             if(carry == 0) {
                ptr.next = l2;
            } else {
                while(l2 != null) {
                    int val = l2.val + carry;
                    ptr.next = new ListNode(val % 10);
                    carry = val / 10;
                    ptr = ptr.next;
                    l2 = l2.next;
                }
            }
        }

        if(carry != 0) {
            ptr.next = new ListNode(carry);
        }

        return result.next;
    }
}

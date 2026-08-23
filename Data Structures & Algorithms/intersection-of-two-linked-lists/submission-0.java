/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }

        int n = 0;
        int m = 0;

        ListNode aCpy = headA;
        ListNode bCpy = headB;

        while(aCpy != null) {
            n++;
            aCpy = aCpy.next;
        }

        while(bCpy != null) {
            m++;
            bCpy = bCpy.next;
        }

        int diff = Math.abs(n-m);
        aCpy = headA;
        bCpy = headB;

        if(n > m) {
            for(int i = 0; i < diff; i++) {
                aCpy = aCpy.next;
            }
        } else {
            for(int i = 0; i < diff; i++) {
                bCpy = bCpy.next;
            }
        }

        while(aCpy != null && aCpy != bCpy) {
            aCpy = aCpy.next;
            bCpy = bCpy.next;
        }

        return aCpy;
    }
}
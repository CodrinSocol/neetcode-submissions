/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) {
 *         this.val = val;
 *     }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        Pair<ListNode, Integer> reversed = reverse(head);
        ListNode revList = reversed.getKey();
        int len = reversed.getValue();

        ListNode result = head;
        ListNode resultCpy = head;
        head = head.next;

        for (int i = 1; i < len; i++) {
            if (i % 2 != 0) {
                result.next = revList;
                revList = revList.next;
            } else {
                result.next = head;
                head = head.next;
            }

            result = result.next;
        }

        result.next = null;
        head = resultCpy;
    }

    private Pair<ListNode, Integer> reverse(ListNode head) {
        if (head == null) {
            return new Pair(null, 0);
        }

        ListNode newHead = null;
        ListNode headCpy = head;
        int len = 0;

        while (headCpy != null) {
            ListNode newNode = new ListNode(headCpy.val);
            newNode.next = newHead;
            newHead = newNode;

            headCpy = headCpy.next;
            len++;
        }

        return new Pair(newHead, len);
    }
}
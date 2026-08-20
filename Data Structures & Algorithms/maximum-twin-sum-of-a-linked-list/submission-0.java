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
    public int pairSum(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        int maxSum = Integer.MIN_VALUE;

        int n = 0;
        ListNode headPtr = head;

        while(headPtr != null) {
            n++;
            headPtr = headPtr.next;
        }

        headPtr = head;

        int i = 0;

        while(i < n/2) {
            stack.push(headPtr);
            headPtr = headPtr.next;
            i++;
        }

        while(i < n) {
            ListNode curr = stack.pop();
            if(curr.val + headPtr.val > maxSum) {
                maxSum = curr.val + headPtr.val;
            }

            i++;
            headPtr = headPtr.next;
        }

        return maxSum;
    }
}
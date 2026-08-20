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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        }

        if(list2 == null) {
            return list1;
        }

        ListNode merged = new ListNode();
        
        if(list1.val > list2.val) {
            merged.val = list2.val;
            list2 = list2.next;
        } else {
            merged.val = list1.val;
            list1 = list1.next;
        }

        ListNode mergedCpy = merged;

        while(list1 != null && list2 != null) {
            ListNode curr = new ListNode();

            if(list1.val > list2.val) {
                curr.val = list2.val;
                list2 = list2.next;
            } else {
                curr.val = list1.val;
                list1 = list1.next;
            }

            merged.next = curr;
            merged = merged.next;
        }

        if(list1 != null) {
            merged.next = list1;
        }

        if(list2 != null) {
            merged.next = list2;
        }

        return mergedCpy;
    }
}
class Solution {

    private ListNode reverse(ListNode head) {
        ListNode res = null;

        while(head != null) {
            ListNode n = new ListNode(head.val);

            if(res == null) {
                res = n;
            } else {
                n.next = res;
                res = n;
            }

            head = head.next;
        }

        return res;
    }

    public ListNode plusOne(ListNode head) {
        ListNode rev = reverse(head);
        ListNode revCpy = rev;

        int carry = 1;

        while(rev != null) {
            int sum = rev.val + carry;
            rev.val = sum % 10;
            carry = sum / 10;
            if (carry == 0) break;
            if (rev.next == null && carry > 0) {
                rev.next = new ListNode(carry);
                carry = 0;
                break;
            }
            rev = rev.next;
        }

        return reverse(revCpy);
    }
}
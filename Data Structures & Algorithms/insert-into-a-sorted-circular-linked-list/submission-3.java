class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null) {
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }

        Node curr = head;
        while (true) {
            if ((curr.val <= insertVal && insertVal <= curr.next.val) ||
                (curr.val > curr.next.val && (insertVal >= curr.val || insertVal <= curr.next.val)) ||
                (curr.next == head)) {
                Node newNode = new Node(insertVal, curr.next);
                curr.next = newNode;
                return head;
            }
            curr = curr.next;
        }
    }
}
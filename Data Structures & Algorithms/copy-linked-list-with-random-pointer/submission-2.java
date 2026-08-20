/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }

        Map<Node, Node> visited = new HashMap<>();

        Node initial = new Node(head.val);
        Node prev = initial;

        visited.put(head, initial);


        Node headCpy = head;
        head = head.next;

        while(head != null) {
            Node curr = head;
            Node newNode = new Node(curr.val);

            visited.put(curr, newNode);

            prev.next = newNode;
            prev = prev.next;
            head = head.next;
        }

        while(headCpy != null) {
            Node newNode = visited.get(headCpy);
            if(headCpy.random != null) {
                Node newRand = visited.get(headCpy.random);
                newNode.random = newRand;
            }

            headCpy = headCpy.next;
        }




        //     if(visited.containsKey(curr)) {
        //         newNode = visited.get(curr);
        //     } else {
                
        //         visited.put(curr, newNode);
        //     }

        //     if(curr.random != null) {
        //         if(visited.containsKey(curr.random)) {
        //             Node rand = visited.get(curr.random);
        //             newNode.random = rand;
        //         } else {
        //             Node newRand = new Node(curr.random.val);
        //             visited.put(curr.random, newRand);
        //         }
        //     }

        //     head = head.next;
        //     if(initial == null) {
        //         initial = newNode;
        //     }

        //     if(prev == null) {
        //         prev = newNode;
        //     } else {
        //         prev.next = newNode;
        //         prev = prev.next;
        //     }
        // }

        return initial;
    }
}

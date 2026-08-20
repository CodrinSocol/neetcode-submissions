/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }

        Map<Integer, Node> visited = new HashMap<>();

        return helper(node, visited);
    }

    private Node helper(Node node, Map<Integer, Node> visited) {

        Node cpy = new Node(node.val);
        visited.put(node.val, cpy);

        List<Node> newNeigh = new ArrayList<>();

        for(Node n : node.neighbors) {
            if(!visited.containsKey(n.val)) {
                Node res = helper(n, visited);
                newNeigh.add(res);
            } else {
                newNeigh.add(visited.get(n.val));
            }
        }

        cpy.neighbors = newNeigh;
        return cpy;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> bfs = new ArrayList<>();

        if(root == null) {
            return bfs;
        }

        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        
        while(q.size() > 0) {
            List<Integer> level = new ArrayList<>();
            int levelSize = q.size();
            for(int i = 0; i < levelSize; i++) {
                TreeNode n = q.poll();
                level.add(n.val);

                if(n.left != null) {
                    q.add(n.left);
                }

                if(n.right != null) {
                    q.add(n.right);
                }
            }

            bfs.add(level);
        }
        return bfs;
    }
}

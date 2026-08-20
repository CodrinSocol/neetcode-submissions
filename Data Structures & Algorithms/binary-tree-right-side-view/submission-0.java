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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        Queue<TreeNode> bfs = new ArrayDeque<>();

        bfs.add(root);

        while(bfs.size() > 0) {
            

            int levelSize = bfs.size();

            while(levelSize > 0) {
                TreeNode curr = bfs.poll();
                if(curr.left != null) {
                    bfs.add(curr.left);
                }

                if(curr.right != null) {
                    bfs.add(curr.right);
                }

                if(levelSize == 1) {
                    result.add(curr.val);
                }

                levelSize--;
            }
        }

        return result;        
    }
}

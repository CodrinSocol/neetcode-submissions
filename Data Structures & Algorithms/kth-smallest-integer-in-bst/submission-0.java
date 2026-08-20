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
    public int kthSmallest(TreeNode root, int k) {
        int[] result = helper(root, k, 0);

        return result[0];
    }

    private int[] helper(TreeNode root, int k, int visited) {
        if(root == null) {
            return new int[]{-1, visited};
        }

        int[] left = helper(root.left, k, visited);

        if(left[0] != -1) {
            return left;
        }

        if(left[1] + 1 == k) {
            return new int[]{root.val, left[1] + 1};
        }

        int[] right = helper(root.right, k, left[1] + 1);

        if(right[0] != -1) {
            return right;
        }

        return new int[]{-1, right[1]};
    } 
}

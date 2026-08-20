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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }

        if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if(root.right != null && root.left != null) {
                int min = findMin(root.right);
                root.val = min;
                root.right = deleteNode(root.right, min);
            } else {
                if(root.right == null) {
                    root = root.left;
                } else {
                    root = root.right;
                }
            }
        }

        return root;
    }

    public int findMin(TreeNode root) {
        int res = Integer.MAX_VALUE;

        while(root != null && root.left != null) {
            root = root.left;
        }

        return root.val;
    }
}
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
    public int find_height(TreeNode root, int count){
        if(root==null)
        return count;

        //left//
        int left = find_height(root.left, count+1);

        //right//
        int right = find_height(root.right, count+1);

        return Math.max(left, right);
    }

    public int maxDepth(TreeNode root) {
        int count = 0;
        return find_height(root, 0);
    }
}
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
    int maxi;
    public int solve(TreeNode root){
        if(root==null)
        return 0;

        //left//
        int left = solve(root.left);

        //right//
        int right = solve(root.right);

        maxi = Math.max(maxi, left+right);

        return 1+Math.max(left, right);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null)
        return 0;

        solve(root);

        return maxi;
    }
}
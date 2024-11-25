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
    int answer;

    public int solve(TreeNode root){
        if(root==null)
        return 0;

        //left//
        int left = Math.max(0, solve(root.left));

        //right//
        int right = Math.max(0, solve(root.right));

        answer = Math.max(answer, root.val+left+right);
        return root.val + Math.max(left, right);
    }

    public int maxPathSum(TreeNode root) {
        answer = Integer.MIN_VALUE;
        solve(root);
        return answer;
    }
}
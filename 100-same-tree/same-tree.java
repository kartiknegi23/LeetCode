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
    public boolean solve(TreeNode p, TreeNode q){
        if(p==null && q==null)
        return true;

        if((p==null && q!=null) || (p!=null && q==null) || (p!=null && q!=null && p.val!=q.val))
        return false;

        //left//
        boolean left = solve(p.left, q.left);

        //right//
        boolean right = solve(p.right, q.right);

        return left && right;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return solve(p, q);
    }
}
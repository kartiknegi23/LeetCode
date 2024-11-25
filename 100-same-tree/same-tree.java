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
        if((p==null && q!=null) || (p!=null && q==null) || (p!=null && q!=null && p.val!=q.val))
        return false;

        boolean l = true;
        boolean r = true;
        //left//
        if(p!=null && q!=null)
        l = solve(p.left, q.left);

        //right//
        if(p!=null && q!=null)
        r = solve(p.right, q.right);

        return l && r;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return solve(p, q);
    }
}
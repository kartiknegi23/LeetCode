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
    public boolean check_flip(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null)
        return true;

        if(root1 == null || root2 == null)
        return false;

        if(root1.val == root2.val){
            boolean noflip_left = check_flip(root1.left, root2.left);
            boolean noflip_right = check_flip(root1.right, root2.right);

            boolean noflip = noflip_left && noflip_right;

            boolean flip_left = check_flip(root1.left, root2.right);
            boolean flip_right = check_flip(root1.right, root2.left);
            
            boolean flip = flip_left && flip_right;

            return noflip || flip;
        }
        
        return false;
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        return check_flip(root1, root2);
    }
}
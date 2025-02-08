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
    public TreeNode helper(TreeNode root){
        if(root.left==null)
        return root.right;

        else if(root.right==null)
        return root.left;

        else{
            TreeNode rightMost = findRightMost(root.left);
            TreeNode right = root.right;
            rightMost.right = right;
            return root.left;
        }
    }

    public TreeNode findRightMost(TreeNode root){
        while(root.right!=null){
            root = root.right;
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
        return root;

        TreeNode head = root;

        while(root!=null){
            if(key == root.val){
                return helper(root);
            }

            else if(key < root.val){
                if(root.left!= null && root.left.val == key){
                    root.left = helper(root.left);
                }
                else
                root = root.left;
            }

            else{
                if(root.right!=null && root.right.val == key){
                    root.right = helper(root.right);
                }
                else
                root = root.right;
            }
        }
        return head;    
    }
}
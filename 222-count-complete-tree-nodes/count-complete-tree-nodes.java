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
    public int calculate_left(TreeNode node){
        int height = 1;

        while(node.left!=null){
            height++;
            node = node.left;
        }
        return height;
    }

    public int calculate_right(TreeNode node){
        int height = 1;

        while(node.right!=null){
            height++;
            node = node.right;
        }
        return height;
    }

    public int countNodes(TreeNode root) {
        if(root==null)
        return 0;

        int left_height = calculate_left(root);
        int right_height = calculate_right(root);

        if(left_height == right_height){
            return (int) Math.pow(2, left_height)-1;
        }

        else
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
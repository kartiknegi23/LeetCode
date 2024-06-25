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
    public void inorder(TreeNode node, ArrayList<Integer> arr){
    if(node==null)
    return;
    
    inorder(node.left, arr);
    arr.add(node.val);
    inorder(node.right, arr);
    }

    public void update(TreeNode node, ArrayList<Integer> arr){
        if(node==null)
        return;

        update(node.left, arr);

        int sum = 0;
        int index = arr.indexOf(node.val);
        for(int i=index;i<arr.size();i++){
        sum+=arr.get(i);
        }
        node.val = sum; 

        update(node.right, arr);
    }

    public TreeNode bstToGst(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        System.out.println(arr);
        
        update(root, arr);

        return root;
    }


}
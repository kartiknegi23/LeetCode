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
    public void inorder(TreeNode node, List<Integer> arr){
        if(node==null)
        return;

        inorder(node.left, arr);
        arr.add(node.val);
        inorder(node.right, arr);
    }

    public TreeNode create_new(int start, int end, List<Integer> arr){
        if(start>end)
        return null;

        int mid = ((start+end)/2);
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = create_new(start, mid-1, arr);
        root.right = create_new(mid+1, end, arr);
        return root;
    }
    
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        inorder(root, arr);
        System.out.println(arr);
        return create_new(0, arr.size()-1, arr);
    }
}
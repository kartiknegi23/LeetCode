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
    public TreeNode solve(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, Map<Integer, Integer> map){
        if(is > ie || ps > pe)
        return null;

        int rootval = postorder[pe];
        TreeNode root = new TreeNode(postorder[pe]);
        int idx = map.get(postorder[pe]);
        int numsleft = idx-is;

        //left//
        root.left = solve(inorder, is, idx-1, postorder, ps, ps+numsleft-1, map);

        //right//
        root.right = solve(inorder, idx+1, ie, postorder, ps+numsleft, pe-1, map);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length)
        return null;
        
        int n = inorder.length;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(inorder[i], i);
        }

        return solve(inorder, 0, n-1, postorder, 0, n-1, map);
    }
}
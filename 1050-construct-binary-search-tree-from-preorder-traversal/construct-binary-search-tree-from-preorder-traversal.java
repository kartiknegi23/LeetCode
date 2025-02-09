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
    public TreeNode solve(int[] preorder, int[] inorder, int start, int end, int[] idx, Map<Integer, Integer> map){
        if(start>end)
        return null;

        int rootval = preorder[idx[0]];
        int i = map.get(rootval);
        idx[0]++;

        TreeNode node = new TreeNode(rootval);

        //left//
        node.left = solve(preorder, inorder, start, i-1, idx, map);

        node.right = solve(preorder, inorder, i+1, end, idx, map);

        return node; 
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = Arrays.copyOf(preorder, preorder.length);
        Arrays.sort(inorder);
        int n = preorder.length;
        int[] idx = new int[1];
        idx[0] = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            map.put(inorder[i], i);
        }

        return solve(preorder, inorder, 0, n-1, idx, map);
    }
}
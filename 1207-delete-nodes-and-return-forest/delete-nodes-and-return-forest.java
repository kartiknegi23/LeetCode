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
    public TreeNode dfs(TreeNode root, boolean flag, Set<Integer>set, List<TreeNode>result){
        if(root==null)
        return root;

        root.left = dfs(root.left, set.contains(root.val), set, result);
        root.right = dfs(root.right, set.contains(root.val), set, result);

        if(set.contains(root.val)){
            if(root.left!=null)
            result.add(root.left);

            if(root.right!=null)
            result.add(root.right);

            return null;
        }

        return root;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer>set = new HashSet<>();
        for(int i=0;i<to_delete.length;i++){
            set.add(to_delete[i]);
        }
        List<TreeNode>result = new ArrayList<>();
        root = dfs(root, true, set, result);

        if(root!=null)
        result.add(root);

        return result;
    }
}
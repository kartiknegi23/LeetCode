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
class FindElements {
    TreeNode root;
    Set<Integer> set = new HashSet<>();

    public void dfs(TreeNode root, Set<Integer> set, int current){
        if(root==null)
        return;

        set.add(current);

        //left//
        dfs(root.left, set, current*2+1);

        //right//
        dfs(root.right, set, current*2+2);
    }

    public FindElements(TreeNode root) {
        this.root = root;
        dfs(root, set, 0);
    }
    
    public boolean find(int target) {
        if(set.contains(target))
        return true;

        return false;
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
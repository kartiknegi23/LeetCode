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
class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode root;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        this.root = root;
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }
    
    public int next() {
        int val = -1;
        if(!stack.isEmpty()){
            TreeNode node = stack.pop();
            val = node.val;
            if(node.right!=null){
                TreeNode rightNode = node.right;
                while(rightNode!=null){
                    stack.push(rightNode);
                    rightNode = rightNode.left;
                }
            }
        }
        return val;
    }
    
    public boolean hasNext() {
        if(stack.size()>0)
        return true;

        else
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
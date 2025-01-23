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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root==null)
        return result;

        queue.offer(root);

        while(queue.size()>0){
            int size = queue.size();
            int max_val = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left != null)
                queue.offer(node.left);

                if(node.right != null)
                queue.offer(node.right);    

                max_val = Math.max(max_val, node.val);
            }
            result.add(max_val);
        }
        return result;
    }
}
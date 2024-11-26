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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if(root==null)
        return answer;
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size()>0){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while(size>0){
                TreeNode node = queue.poll();

                if(node.left!=null)
                queue.add(node.left);
                if(node.right!=null)
                queue.add(node.right);
                
                list.add(node.val);
        
                size--;
            }
            if(level%2!=0)
            Collections.reverse(list);
            answer.add(list);
            level++;
        }

        return answer;
    }
}
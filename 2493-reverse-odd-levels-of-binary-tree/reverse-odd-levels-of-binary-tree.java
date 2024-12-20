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

    public TreeNode reverseOddLevels(TreeNode root) {
        if(root==null)
        return root;

        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(queue.size()>0){
            int size = queue.size();
            List<TreeNode> levelOrder = new ArrayList<>(); 
            while(size>0){
                TreeNode node = queue.poll();
                levelOrder.add(node);

                if(node.left!=null)
                queue.add(node.left);

                if(node.right!=null)
                queue.add(node.right);

                size--;
            }

            if(level%2==1){
                int i = 0;
                int j = levelOrder.size()-1;

                while(i<j){
                    int temp = levelOrder.get(i).val;
                    levelOrder.get(i).val = levelOrder.get(j).val;
                    levelOrder.get(j).val = temp;

                    i++;
                    j--;
                }
            }

            level++;
        }

        return root;
    }
}
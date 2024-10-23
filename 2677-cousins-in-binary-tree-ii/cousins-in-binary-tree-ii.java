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
    public TreeNode replaceValueInTree(TreeNode root) {
        if(root == null)
        return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> levelsum = new ArrayList<>();

        while(queue.size()>0){
            int size = queue.size();
            int sum = 0;
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                sum += node.val;
                
                if(node.left!=null)
                queue.add(node.left);

                if(node.right!=null)
                queue.add(node.right);
            }
            levelsum.add(sum);
        }

        root.val = 0;
        int index = 1; 
        queue.add(root);
        while(queue.size()>0){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();

                int left_child = node.left!=null ? node.left.val : 0;
                int right_child = node.right!=null ? node.right.val : 0;

                int child_sum = left_child + right_child;

                if(node.left!=null){
                    node.left.val = (levelsum.get(index) - child_sum);
                    queue.add(node.left);
                }

                if(node.right!=null){
                    node.right.val = (levelsum.get(index) - child_sum);
                    queue.add(node.right);
                }
            }
            index++;
        }

        return root;
    }
}
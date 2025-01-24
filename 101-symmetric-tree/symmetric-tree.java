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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true; // An empty tree is symmetric

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> level = new ArrayList<>();
            
            // Process the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                level.add(node.left);
                level.add(node.right);

                if(node.left!=null)
                queue.offer(node.left);

                if(node.right!=null)
                queue.offer(node.right);
            }

            // Check if the current level is symmetric (a palindrome)
            int i = 0, j = level.size() - 1;
            while (i < j) {
                TreeNode leftNode = level.get(i);
                TreeNode rightNode = level.get(j);

                if (leftNode == null && rightNode == null) {
                    i++;
                    j--;
                    continue;
                }

                if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                    return false; // Not symmetric
                }

                i++;
                j--;
            }
        }

        return true; // All levels are symmetric
    }
}

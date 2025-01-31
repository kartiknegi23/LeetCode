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
class Pair{
    TreeNode node;
    int idx;

    public Pair(TreeNode node, int idx){
        this.node = node;
        this.idx = idx;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> queue = new ArrayDeque<>();
        Pair p = new Pair(root, 0);
        queue.offer(p);
        int result = 0;

        while(queue.size()>0){
            int size = queue.size();
            int width = queue.getLast().idx - queue.getFirst().idx+1;
            result = Math.max(result, width);
            for(int i=0;i<size;i++){
                Pair pair = queue.removeFirst();
                TreeNode node = pair.node;
                int idx = pair.idx;

                if(node.left!=null)
                queue.offer(new Pair(node.left, idx*2+1));

                if(node.right!=null)
                queue.offer(new Pair(node.right, idx*2+2));
            }
        }

        return result;
    }
}
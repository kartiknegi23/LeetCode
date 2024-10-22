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
    public void bfs(TreeNode root, List<List<Integer>> levels){
        if(root==null)
        return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(queue.size()>0){
            int size = queue.size();
            List<Integer> sublist = new ArrayList<>();

            for(int i=0;i<size;i++){
                if(queue.peek().left!=null)
                queue.add(queue.peek().left);

                if(queue.peek().right!=null)
                queue.add(queue.peek().right);

                sublist.add(queue.poll().val);
            }

            levels.add(sublist);
            
        }

        return ;
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        List<List<Integer>> levels = new ArrayList<>();
        bfs(root, levels);

        if(k>levels.size())
        return -1;

        List<Long> sums = new ArrayList<>();
        PriorityQueue<Long> minheap = new PriorityQueue<>();
        long sum = 0;

        for(int i=0;i<levels.size();i++){
            sum = 0;
            for(int j=0;j<levels.get(i).size();j++){
                sum += levels.get(i).get(j);
            }
            sums.add(sum);

            minheap.add(sum);

            if(minheap.size()>k){
                minheap.poll();
            }
        }  

        return minheap.peek();
    }
}
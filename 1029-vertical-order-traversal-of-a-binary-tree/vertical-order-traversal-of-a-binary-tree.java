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
class Tuple{
    TreeNode node;
    int x;
    int y;

    public Tuple(TreeNode node, int x, int y){
        this.node = node;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<Tuple>();
        queue.offer(new Tuple(root, 0, 0));

        while(queue.size()>0){
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int x = tuple.x;
            int y = tuple.y;

            if(!map.containsKey(x)){
                map.put(x, new TreeMap<Integer, PriorityQueue<Integer>>());
            } 

            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<Integer>());
            }

            map.get(x).get(y).offer(node.val);

            if(node.left!=null){
                queue.offer(new Tuple(node.left, x-1, y+1));
            }

            if(node.right!=null){
                queue.offer(new Tuple(node.right, x+1, y+1));
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> tm : map.values()){
            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> pq : tm.values()){
                while(pq.size()>0){
                    int val = pq.poll();
                    list.add(val);
                }
            }
            result.add(list);
        }

        return result;
    }
}
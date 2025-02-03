/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void findParents(TreeNode root, Map<TreeNode, TreeNode> hashmap){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(queue.size()>0){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();

                if(node.left!=null){
                    queue.offer(node.left);
                    hashmap.put(node.left, node);
                }

                if(node.right!=null){
                    queue.offer(node.right);
                    hashmap.put(node.right, node);
                }
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        if(root==null)
        return result;

        if(k==0){
            result.add(target.val);
            return result;
        }

        Map<TreeNode, TreeNode> hashmap = new HashMap<>();
        findParents(root, hashmap);

        Set<TreeNode> visited = new HashSet<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.add(target);

        int count = 0;

        while(queue.size()>0 && count<=k){
            int size = queue.size();
            count++;
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();

                if(node.left!=null && (!visited.contains(node.left)) ){
                    queue.offer(node.left);
                    visited.add(node.left);

                    if(count==k)
                    result.add(node.left.val);
                }

                if(node.right!=null && (!visited.contains(node.right))){
                    queue.offer(node.right);
                    visited.add(node.right);

                    if(count==k)
                    result.add(node.right.val);
                }

                if(hashmap.containsKey(node) && (!visited.contains(hashmap.get(node)))){
                    queue.offer(hashmap.get(node));
                    visited.add(hashmap.get(node));

                    if(count==k)
                    result.add(hashmap.get(node).val);
                }
            }
            
        }

        return result;
    }
}
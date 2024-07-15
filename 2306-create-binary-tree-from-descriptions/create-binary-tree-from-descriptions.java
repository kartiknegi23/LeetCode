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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Set<Integer> set = new HashSet<>();
        HashMap<Integer, TreeNode> map= new HashMap<>();

        for(int i=0;i<descriptions.length;i++){
            set.add(descriptions[i][1]);
            if(map.containsKey(descriptions[i][0])){
                if(map.containsKey(descriptions[i][1])){
                    if(descriptions[i][2]==1)
                    map.get(descriptions[i][0]).left = map.get(descriptions[i][1]);

                    else
                    map.get(descriptions[i][0]).right = map.get(descriptions[i][1]);
                }

                else{
                    TreeNode newnode = new TreeNode(descriptions[i][1]);
                    map.put(descriptions[i][1], newnode);

                    if(descriptions[i][2]==1)
                    map.get(descriptions[i][0]).left = newnode;

                    else
                    map.get(descriptions[i][0]).right = newnode;
                }
            }

            else{
                TreeNode node = new TreeNode(descriptions[i][0]);
                map.put(descriptions[i][0], node);
                
                if(map.containsKey(descriptions[i][1])){
                    if(descriptions[i][2]==1){
                        node.left = map.get(descriptions[i][1]);
                    }
                    else{
                        node.right = map.get(descriptions[i][1]);
                    }
                }

                else{
                    TreeNode newnode = new TreeNode(descriptions[i][1]);
                    map.put(descriptions[i][1], newnode);
                    if(descriptions[i][2]==1){
                        node.left = newnode;
                    }
                    else{
                        node.right = newnode;
                    }
                }
                
            }
        }

        for(int i=0;i<descriptions.length;i++){
            if(!(set.contains(descriptions[i][0])))
            return map.get(descriptions[i][0]);
        } 

        return null;
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        if(root==null)
        return str.toString();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.size()>0){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                
                if(node==null)
                str.append("#,");

                
                if(node!=null)
                {
                    str.append(node.val);
                    str.append(",");
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        
        System.out.println(str);
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals(""))
        return null;

        Queue<TreeNode> queue = new LinkedList<>();
        String[] str = data.split(",");
        TreeNode root = new TreeNode();
        System.out.println(Arrays.toString(str));
        root.val = Integer.parseInt(str[0]);
        queue.offer(root);

        for(int i=1;i<str.length;i++){
            TreeNode node = queue.poll();
            if(!str[i].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(str[i]));
                node.left = left;
                queue.offer(left);
            }

            if(!str[++i].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(str[i]));
                node.right = right;
                queue.offer(right);
            }
        }
        
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
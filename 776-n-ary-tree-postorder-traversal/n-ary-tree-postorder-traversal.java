/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public void dfs(Node root, List<Integer> arr){
        if(root==null)
        return;

        if(root.children.size()==0)
        {
            arr.add(root.val);
            return;
        }

        for(int i=0;i<root.children.size();i++){
            dfs(root.children.get(i), arr);
        }
        arr.add(root.val);
    }

    public List<Integer> postorder(Node root) {
        List<Integer>arr = new ArrayList<>();
        if(root==null)
        return arr;

        dfs(root, arr);

        return arr;
    }
}
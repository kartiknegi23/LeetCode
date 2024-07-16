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

    TreeNode lowest_common_ancestor(TreeNode root, int start, int end){
        if(root==null || root.val==start || root.val==end){
            return root;
        }

        TreeNode left = lowest_common_ancestor(root.left, start, end);
        TreeNode right = lowest_common_ancestor(root.right, start, end);

        if(left==null)
        return right;

        else if(right==null)
        return left;

        else
        return root;
    }


    StringBuilder dfs(TreeNode root, int dest, StringBuilder str){
        if(root==null)
        return null;

        if(root.val==dest){
            return str;
        }

        StringBuilder leftchild = new StringBuilder();
        str.append('L');
 
        leftchild = dfs(root.left, dest, str);
        if(leftchild!=null){
            return leftchild;
        }
        
        str.deleteCharAt(str.length() - 1);

        StringBuilder rightchild = new StringBuilder();
        str.append('R');
        rightchild = dfs(root.right, dest, str);
        if(rightchild!=null){
            return rightchild;
        }
        
        str.deleteCharAt(str.length() - 1);
        return null;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {

        TreeNode lowest_common = lowest_common_ancestor(root, startValue, destValue);

        StringBuilder startpath = new StringBuilder();
        StringBuilder endpath = new StringBuilder();

        startpath = dfs(lowest_common, startValue, startpath);
        endpath = dfs(lowest_common, destValue, endpath);

        System.out.println(startpath);
        System.out.println(endpath);


        StringBuilder result = new StringBuilder();

        for(int i=0;i<startpath.length();i++){
            result.append('U');
        }

        result.append(endpath);

        return result.toString();

    }
}
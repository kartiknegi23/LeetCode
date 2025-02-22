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
    public TreeNode solve(String traversal, int[] i, int depth){
        if(i[0]>=traversal.length())
        return null;

        int j=i[0];
        while(j<traversal.length() && traversal.charAt(j)=='-'){
            j++;
        }       
        int dash_count = j-i[0];

        if(depth!=dash_count)
        return null;

        int num = 0;
        i[0]=j;

        while(i[0]<traversal.length() && traversal.charAt(i[0])!='-'){
            num = num*10 + (traversal.charAt(i[0])-'0');
            i[0]++;
        } 

        TreeNode node = new TreeNode(num);

        node.left = solve(traversal, i, depth+1);
        node.right = solve(traversal, i, depth+1);

        return node;
    }

    public TreeNode recoverFromPreorder(String traversal) {
        int[] i = new int[]{0};
        return solve(traversal, i, 0);
    }
}
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
    int[] levels = new int[100001];
    int[] heights = new int[100001];
    int[] maxheight = new int[100001];
    int[] secondmax = new int[100001]; 

    public int findheight(TreeNode root, int level){
        if(root==null)
        return 0;

        int left = 1 + findheight(root.left, level+1);
        int right = 1 + findheight(root.right, level+1);

        int height = Math.max(left, right);

        heights[root.val] = height;
        levels[root.val] = level;

        if(maxheight[level] < height){
            secondmax[level] = maxheight[level];
            maxheight[level] = height;
        }

        else if(secondmax[level] < height){
            secondmax[level] = height;
        } 

        return height;
    }

    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] ans = new int[queries.length];
        findheight(root, 0);

        for(int i=0;i<queries.length;i++){
            int level = levels[queries[i]];
            int height = heights[queries[i]] == maxheight[level] ? secondmax[level] : maxheight[level];

            ans[i] = level + height -1;
        }

        return ans;
    }
}
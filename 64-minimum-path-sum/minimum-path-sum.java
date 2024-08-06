class Solution {
    public int find_minpath(int[][] grid, int m, int n, int[][] dp){
        if(m==0 && n==0){
            return grid[m][n];
        }

        if(dp[m][n]!=-1)
        return dp[m][n];

        int left = Integer.MAX_VALUE;
        int up = Integer.MAX_VALUE;

        if(m>0){
            up = grid[m][n] + find_minpath(grid, m-1, n, dp);
        }

        if(n>0){
            left = grid[m][n] + find_minpath(grid, m, n-1, dp);
        }

        return dp[m][n] = Math.min(up, left);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][]dp = new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }

        return find_minpath(grid, m-1, n-1, dp);
    }
}
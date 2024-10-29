class Solution {
    public int solve(int i, int j, int[][] grid, int[][] dp){
        if(i<0 || j>=grid[0].length || i>=grid.length)
        return 0;

        if(dp[i][j]!=-1)
        return dp[i][j];

        int up = 0;
        int right = 0;
        int down = 0;

        //up//
        if(i>0 && j<grid[0].length-1 && grid[i-1][j+1]>grid[i][j])
        up = 1 + solve(i-1, j+1, grid, dp);

        //right//
        if(j<grid[0].length-1 && grid[i][j+1]>grid[i][j])
        right = 1 + solve(i, j+1, grid, dp);

        //down//
        if(i<grid.length-1 && j<grid[0].length-1 && grid[i+1][j+1]>grid[i][j])
        down = 1 + solve(i+1, j+1, grid, dp);

        return dp[i][j] = Math.max(up, Math.max(right, down));
    }

    public int maxMoves(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }

        int result = 0;
        for(int i=0;i<grid.length;i++){
            result = Math.max(result, solve(i, 0, grid, dp));
        }

        return result;
    }
}
class Solution {
    public int calculate(int row, int col, int[][] dp){
        if(row==0 && col==0)
        return 1;

        int left = 0;
        int up = 0;

        if(dp[row][col]!=-1)
        return dp[row][col];

        if(col>0){
            left = calculate(row, col-1, dp);
        }

        if(row>0){
            up = calculate(row-1, col, dp);
        }

        return dp[row][col] = left+up;
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i], -1);
        }

        return calculate(m-1,n-1, dp);
    }
}
class Solution {
    public int find_path(int[][] obstacleGrid, int row, int col, int[][] dp){
        if(row==0 && col==0)
        {
            if(obstacleGrid[row][col]==0)
            return 1;

            else
            return 0;
        }

        if(obstacleGrid[row][col] == 1){
            return 0;
        }

        if(dp[row][col]!=-1)
        return dp[row][col];

        int top = 0;
        int left = 0;

        if(col>0){
            left = find_path(obstacleGrid, row, col-1, dp);
        }

        if(row>0){
            top = find_path(obstacleGrid, row-1, col, dp);
        }

        return dp[row][col] = top + left;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                
                if(i==0 && j==0){
                    if(obstacleGrid[0][0]==0)
                    dp[0][0]=1;

                    else
                    dp[0][0]=0;
                }

                else if(obstacleGrid[i][j]==1)
                dp[i][j]=0;

                else{
                    int top = 0;
                    int left = 0;

                    if(i>0)
                    top = dp[i-1][j];

                    if(j>0)
                    left = dp[i][j-1];

                    dp[i][j] = top+left;

                }

            }
        }

        return dp[m-1][n-1];
    }
}
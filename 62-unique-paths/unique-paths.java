class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        dp[0][0] = 1;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int up = 0;
                int left = 0;

                if(i==0 && j==0)
                continue;

                if(j>0)
                left = dp[i][j-1];

                if(i>0)
                up = dp[i-1][j];

                dp[i][j] = left + up;
            }
        }
        

        return dp[m-1][n-1];
    }
}
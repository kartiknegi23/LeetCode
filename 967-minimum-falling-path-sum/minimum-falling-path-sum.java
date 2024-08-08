class Solution {
    public int minimum_sum(int[][] matrix, int m, int n, int[][] dp){
        if(n<0 || n>=matrix[0].length)
        return 1000000;

        if(m==0){
            return matrix[0][n];
        }

        if(dp[m][n]!=-1)
        return dp[m][n];

        int left = matrix[m][n] + minimum_sum(matrix, m-1, n-1, dp);
        int center = matrix[m][n] + minimum_sum(matrix, m-1, n, dp);
        int right = matrix[m][n] + minimum_sum(matrix, m-1, n+1, dp);

        return dp[m][n] = Math.min(left, Math.min(center, right));
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        if(n==1)
        return matrix[0][0];

        int[][] dp = new int[n][n];

        for(int i=0;i<n;i++){
            dp[0][i] = matrix[0][i];
        }

        for(int i=1;i<n;i++){
            int left = Integer.MAX_VALUE;
            int right = Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
                if(j>0)
                left = dp[i-1][j-1];

                int center = dp[i-1][j];

                if(j<n-1)
                right = dp[i-1][j+1];

                dp[i][j] = matrix[i][j] + Math.min(left, Math.min(center, right));
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            result = Math.min(result, dp[n-1][i]);
        }

        return result;
    }
}
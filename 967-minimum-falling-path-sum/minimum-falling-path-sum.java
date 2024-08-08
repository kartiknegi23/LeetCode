class Solution {
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